<template functional>
    <div :class="[
        'slds-form-element',
        data.class,
        data.staticClass
    ]">
        <div v-if="props.label" class="slds-form-element__label">
            {{props.label}}
            <help-pointer v-if="props.tooltip" :content="props.tooltip" class="slds-m-left_xx-small" />
        </div>

        <div class="slds-form-element__static">
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
            label: {
                type: String,
                default: ''
            },
            tooltip: {
                type: String,
                default: ''
            }
        }
    }
</script>
