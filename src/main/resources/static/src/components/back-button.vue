<template>
    <tooltip v-if="type" :content="innerTooltip" :offset="3" position="right">
        <router-link v-if="type === 'route'" :to="{name: to}" class="cmp-back-button">
            <icon icon="arrow-left" class="slds-icon slds-icon_small" />
        </router-link>
        <button v-else-if="type === 'history'" @click="back" class="cmp-back-button">
            <icon icon="arrow-left" class="slds-icon slds-icon_small" />
        </button>
    </tooltip>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faArrowLeft} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faArrowLeft);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            to: {
                type: String
            },
            tooltip: {
                type: String
            }
        },
        data() {
            return  {
                type: null, // route | history | null
            }
        },
        computed: {
            innerTooltip() {
                return this.$props.label || this.$t('label.button.back');
            }
        },

        //
        // EVENTS
        //
        mounted() {
            if (this.$props.to) {
                this.type = 'route';
            }
            else if (window.history.length > 1 && window.history.state) {
                this.type = 'history';
            }
        },

        //
        // METHODS
        //
        methods: {
            back() {
                window.history.back();
            }
        }
    }
</script>

<style>
    .cmp-back-button {
        display: inline-block;
        width: 50px;
        height: 50px;
        text-align: center;
        line-height: 48px;

        border-radius: 50%;
        border: 1px solid #706e6b;
    }
    .cmp-back-button .slds-icon {
        vertical-align: baseline;
        fill: #706e6b;
    }


    .cmp-back-button:hover {
        border-color: #005fb2;
    }
    .cmp-back-button:hover .slds-icon {
        fill: #005fb2;
    }
</style>
