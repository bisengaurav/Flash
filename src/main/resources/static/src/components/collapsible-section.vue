<template>
    <div :class="{'collapsible-section_collapsed': state}">
        <div @click="state = !state" class="slds-grid slds-grid_vertical-align-center collapsible-section_title">
            <icon icon="chevron-right" class="slds-icon slds-icon_x-small collapsible-section_chevron" />
            <div class="slds-grow slds-m-left_x-small">
                <div v-if="title" class="slds-text-heading_small">{{title}}</div>
                <slot v-else name="title"></slot>
            </div>
        </div>
        <div v-show="state" class="collapsible-section_body slds-p-top_small">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faChevronRight} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faChevronRight);

    export default {
        //
        // PARAMS: props, data, computed
        //
        props: {
            title: {
                type: String,
                default: ''
            },
            defaultState: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                state: this.$props.defaultState
            }
        }
    }
</script>

<style>
    .collapsible-section_title {
        cursor: pointer;
    }
    .collapsible-section_body {

    }
    .collapsible-section_collapsed {}

    .collapsible-section_title .collapsible-section_chevron {
        fill: currentColor;
        transform: rotate(0deg);
    }
    .collapsible-section_collapsed .collapsible-section_title .collapsible-section_chevron {
        transform: rotate(90deg);
    }
</style>
