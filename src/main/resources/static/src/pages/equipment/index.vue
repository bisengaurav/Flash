<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <div>
            <equpment-filter-form v-model="filters"></equpment-filter-form>
            <equpment-table></equpment-table>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
    import EqupmentFilterForm from './equipment-filter-form.vue';
    import EqupmentTable from './equipment-table.vue';

    export default {
        extends: Page,

        components: {
            EqupmentFilterForm,
            EqupmentTable
        },

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Equipment',
                filters: {
                  
                }
            }
        },
       
        watch: {
            filters: {
                handler: function(newValue) {
                    console.log(newValue);
                },
                deep: true
            }
        },
    }
</script>
