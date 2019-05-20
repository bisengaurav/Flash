<template>
    <span>

        <span class="z-level7">
            <span
                ref="popover"
                v-show="isShow"
                class="tooltip"
                :style="{
                    maxWidth: ($props.maxWidth ? $props.maxWidth+'px' : 'none')
                }"
            >
                <span class="tooltip__arrow" x-arrow></span>
                <slot name="content">
                    <span v-html="content"></span>
                </slot>
            </span>
        </span>

        <slot></slot>

    </span>
</template>

<script>
    import Popover from './popover.vue';

    export default {
        extends: Popover,

        props: {
            content: String
        },
        data() {
            return {
                defaultTrigger: 'hover',
                defaultPosition: 'top',
                defaultOffset: 1
            };
        }

    }
</script>

<style>
    .tooltip {
        position: absolute;
        display: block;
        width: auto;

        font-size: .75rem;
        font-weight: normal;
        color: #fff;

        overflow-wrap: normal !important;
        word-wrap: normal !important;
        -webkit-hyphens: none !important;
        -ms-hyphens: none !important;
        hyphens: none !important;
        white-space: normal !important;

        padding: .5rem .75rem;
        border-radius: .25rem;
        background-color: #007298;
        box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .16);
    }

    .tooltip .tooltip__arrow {
        display: block;
        position: absolute;
        width: 0;
        height: 0;
        border-style: solid;
        margin: 5px;
    }


    .tooltip[x-placement^="top"] {
        margin-bottom: 5px;
    }
    .tooltip[x-placement^="top"] .tooltip__arrow {
        border-width: 5px 5px 0 5px;
        border-color: #007298 transparent transparent transparent;
        bottom: -5px;
        left: calc(50% - 5px);
        margin-top: 0;
        margin-bottom: 0;
    }

    .tooltip[x-placement^="bottom"] {
        margin-top: 5px;
    }
    .tooltip[x-placement^="bottom"] .tooltip__arrow {
        border-width: 0 5px 5px 5px;
        border-color: transparent transparent #007298 transparent;
        top: -5px;
        left: calc(50% - 5px);
        margin-top: 0;
        margin-bottom: 0;
    }

    .tooltip[x-placement^="right"] {
        margin-left: 5px;
    }
    .tooltip[x-placement^="right"] .tooltip__arrow {
        border-width: 5px 5px 5px 0;
        border-color: transparent #007298 transparent transparent;
        left: -5px;
        top: calc(50% - 5px);
        margin-left: 0;
        margin-right: 0;
    }

    .tooltip[x-placement^="left"] {
        margin-right: 5px;
    }
    .tooltip[x-placement^="left"] .tooltip__arrow {
        border-width: 5px 0 5px 5px;
        border-color: transparent transparent transparent #007298;
        right: -5px;
        top: calc(50% - 5px);
        margin-left: 0;
        margin-right: 0;
    }
</style>
