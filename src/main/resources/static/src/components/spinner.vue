<template>
    <icon icon="spinner" pulse class="slds-icon spinner" />
</template>

<script>
    import Icons from '../core/icons';
    import {faSpinner} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faSpinner);

    export default {}
</script>

<style>
    .spinner {
        fill: #0071b9;
    }
</style>
