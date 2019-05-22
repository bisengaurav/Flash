<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <div>
            <equpment-filter-form v-model="filters"></equpment-filter-form>
            
            <div class="primary-section">

                <data-table-basic
                        ref="equipmentTable"
                        :action="$API.equipmentApi.getAllByFilter"
                        :filters="filters"
                    >
                        <template #head>
                            <th>Equipment</th>
                            <th>Equipment type</th>
                            <th>Customer asset name</th>
                            <th>Phone</th>
                            <th>Account name</th>
                            <th>Sold-to name</th>
                            <th>Location</th>
                            <th>Street</th>
                            <th>City</th>
                            <th>State / Province</th>
                            <th>Service Territory</th>
                            <th>Work Center</th>
                            <th>Valid contract</th>
                            <th></th>
                        </template>
                        <template #row="{row, id}">
                            <td>{{id}}</td>
                            <td>{{row.type}}</td>
                            <td>{{row.customerName}}</td>
                            <td>{{row.phone}}</td>
                            <td>{{row.accountName}}</td>
                            <td>{{row.soldTo}}</td>
                            <td>{{row.location}}</td>
                            <td>{{row.street}}</td>
                            <td>{{row.city}}</td>
                            <td>{{row.stateProvince}}</td>
                            <td>{{row.serviceTerritory}}</td>
                            <td>{{row.workCenter}}</td>
                            <td>{{row.validContract}}</td>
                        </template>
                    </data-table-basic>
                </div>

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
