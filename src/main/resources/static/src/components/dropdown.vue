<template>
    <span>

        <span
            ref="popover"
            v-show="isShow"
            class="popover"
            :style="{
                maxWidth: ($props.maxWidth ? $props.maxWidth+'px' : 'none')
            }"
        >
            <span class="dropdown__arrow" x-arrow></span>
            <div class="dropdown">
                <slot name="content"></slot>
            </div>
        </span>

        <slot></slot>

    </span>
</template>

<script>
    import Popover from './popover.vue';

    export default {
        extends: Popover,

        data() {
            return {
                defaultTrigger: 'click',
                defaultPosition: 'bottom',
                defaultOffset: 0
            };
        }

    }
</script>

<style>
    .dropdown {
        border-radius: .25rem;
        background-color: #fff;
        border: 1px solid #dddbda;
        box-shadow: 0 2px 3px 0 rgba(0, 0, 0, .16);
    }

    .dropdown__arrow {
        display: block;
        position: absolute;
        margin: 10px;
    }
    .dropdown__arrow::before,
    .dropdown__arrow::after {
        width: 1rem;
        height: 1rem;
        position: absolute;
        transform: rotate(45deg);
        content: "";
        background-color: #fff;
        left: 50%;
        margin-left: -.5rem;
        top: 50%;
        margin-top: -.5rem;
    }
    .dropdown__arrow::before {
        box-shadow: 0 0 1px 1px #dddbda;
        z-index: -1;
    }
    .dropdown__arrow::after {
        z-index: 1;
    }


    [x-placement^="top"] .dropdown {
        margin-bottom: 11px;
    }
    [x-placement^="top"] .dropdown__arrow {
        bottom: 12px;
        margin-top: 0;
        margin-bottom: 0;
    }

    [x-placement^="bottom"] .dropdown {
        margin-top: 11px;
    }
    [x-placement^="bottom"] .dropdown__arrow {
        top: 12px;
        margin-top: 0;
        margin-bottom: 0;
    }

    [x-placement^="right"] .dropdown {
        margin-left: 11px;
    }
    [x-placement^="right"] .dropdown__arrow {
        left: 12px;
        margin-left: 0;
        margin-right: 0;
    }

    [x-placement^="left"] .dropdown {
        margin-right: 11px;
    }
    [x-placement^="left"] .dropdown__arrow {
        right: 12px;
        margin-left: 0;
        margin-right: 0;
    }
</style>
