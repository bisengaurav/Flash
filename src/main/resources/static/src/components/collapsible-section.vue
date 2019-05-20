<template>
    <div :class="{'cmp-collapsible-section_collapsed': state}">
        <div @click="state = !state" class="slds-grid slds-grid_vertical-align-center cmp-collapsible-section_title">
            <icon icon="chevron-right" class="slds-icon slds-icon_x-small cmp-collapsible-section_chevron" />
            <div class="slds-grow slds-m-left_x-small">
                <div v-if="title" class="slds-text-heading_small">{{title}}</div>
                <slot v-else name="title"></slot>
            </div>
        </div>
        <div v-show="state" class="cmp-collapsible-section_body slds-p-top_small">
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
        // PARAMS: porps, data, computed
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
    .cmp-collapsible-section_title {
        cursor: pointer;
    }
    .cmp-collapsible-section_body {

    }
    .cmp-collapsible-section_collapsed {}

    .cmp-collapsible-section_title .cmp-collapsible-section_chevron {
        fill: currentColor;
        transform: rotate(0deg);
    }
    .cmp-collapsible-section_collapsed .cmp-collapsible-section_title .cmp-collapsible-section_chevron {
        transform: rotate(90deg);
    }
</style>
