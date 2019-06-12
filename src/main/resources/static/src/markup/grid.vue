<template functional>
    <div :class="[
        'slds-grid slds-wrap slds-gutters_direct',
        data.class,
        data.staticClass
    ]">
        <slot></slot>
    </div>
</template>
