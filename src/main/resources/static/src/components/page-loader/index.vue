<template>
    <div class="z-level9" v-show="queue > 0">
        <div class="slds-backdrop slds-backdrop_open cmp-page-loader_overlay"></div>

        <spinner class="cmp-page-loader_spinner" />
    </div>
</template>

<script>
    import {SHOW, HIDE, HIDE_ALL} from './events';

    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                queue: 0
            }
        },

        //
        // EVENTS
        //
        created() {
            this.$EM.$on(SHOW, () => {
                this.queue++;
            });
            this.$EM.$on(HIDE, () => {
                if (this.queue > 0) this.queue--;
            });
            this.$EM.$on(HIDE_ALL, () => {
                this.queue = 0;
            });
        },
        destroyed() {
            this.$off();
        }
    }
</script>

<style>
    .cmp-page-loader_overlay {
        z-index: 10000 !important;
    }

    .cmp-page-loader_spinner {
        position: fixed;
        top: 50%;
        left: 50%;
        z-index: 10001 !important;

        /* .slds-icon size */
        height: 4rem;
        width: 4rem;
        margin: -2rem 0 0 -2rem;
        /*fill: #fff;*/
    }
</style>
