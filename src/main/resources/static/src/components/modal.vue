<template>
    <div class="z-level6">
        <div v-if="!hideBackdrop" class="slds-backdrop slds-backdrop_open"></div>

        <section
            class="slds-modal slds-fade-in-open"
            :class="[
                preset.modalClass,
                {'cmp-modal_no-header': hideHeader}
            ]"
        >
            <div class="slds-modal__container">

                <header v-if="!hideHeader" class="slds-modal__header">
                    <h2 class="slds-text-heading_medium">
                        <slot name="header">{{header}}</slot>
                    </h2>
                </header>

                <div class="slds-modal__content" :class="preset.contentClass">
                    <slot></slot>
                </div>

            </div>
        </section>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faTimes} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faTimes);

    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            header: {
                type: String,
                default: ''
            },
            size: {
                type: String
            },
            hideBackdrop: {
                type: Boolean,
                default: false
            },
            hideHeader: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
                presets: new Map([
                    ['default', {
                        'modalClass': '',
                        'contentClass': ''
                    }],
                    ['small', {
                        'modalClass': 'slds-modal_small',
                        'contentClass': ''
                    }],
                    ['medium', {
                        'modalClass': 'slds-modal_medium',
                        'contentClass': ''
                    }],
                    ['large', {
                        'modalClass': 'slds-modal_large',
                        'contentClass': ''
                    }]
                ]),
            }
        },
        computed: {
            preset: function() {
                return this.presets.has(this.size) ? this.presets.get(this.size) : this.presets.values().next().value;
            }
        },

    }
</script>

<style>
    .cmp-modal_no-header {}
    .cmp-modal_no-header .slds-modal__content {
        border-top-right-radius: .25rem;
        border-top-left-radius: .25rem;
    }
</style>
