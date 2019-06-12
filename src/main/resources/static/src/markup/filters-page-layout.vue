<template functional>
    <div :class="[data.class, data.staticClass]">
        <h1 class="slds-text-heading_large slds-m-bottom_large">{{props.title}}</h1>

        <slot name="filters"></slot>

        <div class="primary-section slds-m-top_x-large">
            <slot name="table"></slot>
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
