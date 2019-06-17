<template functional>
    <div :class="[data.class, data.staticClass]">
        <h1 class="slds-text-heading_large slds-m-bottom_large">{{props.title}}</h1>

        <slot name="filters"></slot>
       
        <p class="slds-text-color_weak slds-m-vertical_large" v-t="'message.common.search-disclaimer'"></p>

        <div class="primary-section">
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
