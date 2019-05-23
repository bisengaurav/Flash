<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <equpment-filter-form v-model="filters"></equpment-filter-form>

        <div class="primary-section">
            <data-table-basic
                    ref="equipmentTable"
                    :action="$API.equipment.getAllByFilter"
                    :filters="filters"
                    :immediateRefresh="false"
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
                    <td><router-link :to="{name: 'equipmentDetails', params: {id: id }}">{{id}}</router-link></td>
                    <td>{{row.equipmentType__c}}</td>
                    <td>{{row.customerAssetName__c}}</td>
                    <td>{{row.equipmentPhoneNumber__c}}</td>
                    <td>{{row.accountName}}</td>
                    <td>{{row.soldToName}}</td>
                    <td>{{row.locationName}}</td>
                    <td>{{row.installationStreet__c}}</td>
                    <td>{{row.installationCity__c}}</td>
                    <td>{{row.installationStateProvince__c}}</td>
                    <td>{{row.serviceTerritoryName}}</td>
                    <td>{{row.workCenterName}}</td>
                    <td>{{ row.fsmLastValidCliEndDate__c ? 'Yes' : '' }} {{ row.fsmLastValidCliEndDate__c === false ? 'No' : '' }}</td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
    import EqupmentFilterForm from './equipment-filter-form.vue';

    export default {
        extends: Page,

        components: {
            EqupmentFilterForm
        },

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Equipment',
                filters: {}
            }
        }
    }
</script>
