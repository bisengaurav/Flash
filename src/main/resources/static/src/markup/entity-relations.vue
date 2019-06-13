<template functional>
    <div :class="[data.class, data.staticClass]">
        <h2 class="slds-text-heading_small slds-m-bottom_x-small">{{props.title}}</h2>
        <div class="primary-section slds-m-bottom_large">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: props, data, computed
        //
        props: {
            title: {
                type: String,
                default: ''
            }
        }
    }
</script>
