<template>
    <div class="z-level7">
        <div class="cmp-alert-emitter_pool" aria-hidden="true" v-show="pool.length > 0">
            <button v-show="pool.length > 1" @click="clear" class="slds-button slds-button_neutral slds-m-bottom_xx-small cmp-alert-emitter_clear-all">Clear All</button>
            <alert
                v-for="alert in pool"
                :key="alert.id"
                :type="alert.type"
                :animate="(alert.type != 'warning' && alert.type != 'error')"
                @CLOSED="deleteElement(alert.id)"
                class="slds-notify_toast slds-m-bottom_xx-small"
            >
                <div v-html="alert.message"></div>
            </alert>
        </div>
    </div>
</template>

<script>
    import {PUSH, CLEAR} from './events';

    export default {
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pool: []
            }
        },

        //
        // METHODS
        //
        methods: {
            deleteElement(id) {
                let index = this.pool.findIndex(alert => {
                    return alert.id == id;
                });
                this.pool.splice(index, 1);
            },
            clear() {
                this.pool = [];
            }
        },

        //
        // EVENTS
        //
        created() {
            this.$EM.$on(PUSH, (params) => {
                if (params && params.message) {
                    params.id = Math.floor( Math.random() *1000 *1000 );
                    this.pool.push(params);
                }
            });
            this.$EM.$on(CLEAR, () => {
                this.clear();
            });
        },

    }
</script>

<style>
    .cmp-alert-emitter_pool {
        position: fixed;
/*        top: 1rem;
        left: 50%;
        margin-left: -200px;*/
        width: 400px;
        bottom: 1rem;
        right: 1rem;
        z-index: 6000;
    }
    .cmp-alert-emitter_clear-all {
        display: block;
        width: 100%;
        border: none;
    }
</style>
