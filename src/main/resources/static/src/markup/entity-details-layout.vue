<template functional>
    <div :class="[data.class, data.staticClass]">

        <h1 class="slds-text-heading_large slds-m-bottom_large">
            <back-button class="slds-m-right_medium" />
            {{props.title}}
        </h1>

        <loader type="block" :height="400" :loading="props.loading" #content>
            <div v-if="props.data">
                <div v-if="!props.hideDetails" class="slds-card slds-p-around_medium slds-m-bottom_x-large">
                    <grid>

                        <slot name="details"></slot>

                    </grid>
                </div>

                <slot name="relations"></slot>
            </div>
        </loader>

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
            },
            loading: {
                type: Boolean,
                default: false
            },
            data: {
                type: Object,
                default: null
            },
            hideDetails: {
                type: Boolean,
                default: false
            }
        }
    }
</script>
