<template>
    <div
        v-if="!closed"
        class="slds-notify slds-notify_alert"
        :class="[
            preset.class,
            {
                'cmp-alert_fixed slds-notify_toast' : this.fixed,
                'cmp-alert_animate' : this.startAnimation,
                'slds-notify_not-closable' : !this.closable
            }
        ]"
    >
        <span v-if="showIcon" class="slds-icon_container slds-m-right_x-small">
            <icon :icon="preset.icon" class="slds-icon slds-icon_x-small" />
        </span>
        <slot></slot>

        <div v-if="closable" class="slds-notify__close">
            <button @click="close" class="slds-button slds-button_icon slds-button_icon-small slds-button_icon-inverse" title="Close">
                <icon icon="times" class="slds-button__icon" />
            </button>
        </div>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faCheckCircle, faExclamationTriangle, faExclamationCircle, faBan, faTimes} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faCheckCircle, faExclamationTriangle, faExclamationCircle, faBan, faTimes);

    /* Events:
    *
    * CLOSED
    *
    * */

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            type: {
                type: String
            },
            showIcon: {
                type: Boolean,
                default: true
            },
            fixed: {
                type: Boolean,
                default: false
            },
            animate: {
                type: Boolean,
                default: false
            },
            closable: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                presets: new Map([
                    ['info', {
                        'class': 'slds-theme_alert-texture slds-theme_info',
                        'icon': 'exclamation-circle'
                    }],
                    ['warning', {
                        'class': 'slds-theme_alert-texture slds-theme_warning',
                        'icon': 'exclamation-triangle'
                    }],
                    ['error', {
                        'class': 'slds-theme_alert-texture slds-theme_error',
                        'icon': 'ban'
                    }],
                    ['success', {
                        'class': 'slds-theme_alert-texture slds-theme_success',
                        'icon': 'check-circle'
                    }],
                    ['static', {
                        'class': 'slds-theme_static',
                        'icon': 'exclamation-circle'
                    }]
                ]),
                startAnimation: false,
                closed: false
            }
        },
        computed: {
            preset: function() {
                return this.presets.has(this.type) ? this.presets.get(this.type) : this.presets.values().next().value;
            }
        },

        //
        // METHODS
        //
        methods: {
            close() {
                this.$emit('CLOSED');
                this.closed = true;
            }
        },

        //
        // EVENTS
        //
        mounted() {
            if (this.animate) {
                setTimeout(() => {
                    this.startAnimation = true;
                }, 3000);
                setTimeout(() => {
                    this.close();
                }, 4000);
            }
        }
    }
</script>

<style>
    .cmp-alert_fixed {
        position: fixed;
        right: 1rem;
        bottom: 1rem;
        z-index: 7000;
        max-width: 300px;
    }
    .cmp-alert_animate {
        opacity: 0;
        transition: opacity 1s;
    }
</style>
