<template functional>
    <div :class="[data.class, data.staticClass]">
        <grid>
            <slot name="fields"></slot>
        </grid>

        <div class="slds-p-top_small">
            <slot name="buttons"></slot>
        </div>
    </div>
</template>
