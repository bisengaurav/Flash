<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <div>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';

    export default {
        extends: Page,

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Service Resource'
            }
        }
    }
</script>
