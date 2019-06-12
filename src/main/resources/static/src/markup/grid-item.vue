<template functional>
    <div :class="[
        'slds-col',
        'slds-size_1-of-1',
        {
            'slds-medium-size_1-of-2': (+props.x >= 2 && +props.x != 6),
            'slds-medium-size_1-of-3': (+props.x == 6)
        },
        {
            'slds-large-size_1-of-3': (+props.x == 3),
            'slds-large-size_1-of-4': (+props.x == 4),
            'slds-large-size_1-of-5': (+props.x == 5),
            'slds-large-size_1-of-6': (+props.x == 6)
        },
        'slds-m-bottom_x-small',
        data.class,
        data.staticClass
    ]">
        <slot></slot>
    </div>
</template>

<script>
    export default {
        props: {
            x: {
                default: 6
            }
        }
    }
</script>
