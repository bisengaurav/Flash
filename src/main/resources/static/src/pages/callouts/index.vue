<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <callouts-filter-form></callouts-filter-form>
        <div>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
     import CalloutsFilterForm from './callouts-filter-form.vue';

    export default {
        extends: Page,

        components: {
            CalloutsFilterForm
        },
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Callouts'
            }
        }
    }
</script>
