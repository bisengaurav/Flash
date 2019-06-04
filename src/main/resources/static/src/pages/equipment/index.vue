<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <equipment-filter-form v-model="filters" cacheUniqueKey="equipment-page" :applyOnCacheLoad="true"></equipment-filter-form>

        <div class="primary-section slds-m-top_x-large">
            <data-table-basic
                    :action="$API.equipment.getAllByFilter"
                    :filters="filters"
                    :immediateRefresh="false"
                    :useLoading="false"
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
                    <td><router-link :to="{name: 'equipmentDetails', params: {id: id }}">{{row.name}}</router-link></td>
                    <td>{{row.equipmentTypeValue}}</td>
                    <td>{{row.customerAssetName__c}}</td>
                    <td>{{row.equipmentPhoneNumber__c}}</td>
                    <td>{{row.accountName}}</td>
                    <td>{{row.soldToName}}</td>
                    <td>{{row.locationName}}</td>
                    <td>{{row.installationStreet__c}}</td>
                    <td>{{row.installationCity__c}}</td>
                    <td>{{row.installationStateProvince__c}}</td>
                    <td><router-link :to="{name: 'serviceTerritory', params: {id: row.serviceTerritoryId }}">{{row.serviceTerritoryName}}</router-link></td>
                    <td><router-link :to="{name: 'workCenter', params: {id: row.workCenterId }}">{{row.workCenterName}}</router-link></td>
                    <td>{{ row.fsmLastValidCliEndDate__c ? 'Yes' : '' }} {{ row.fsmLastValidCliEndDate__c === false ? 'No' : '' }}</td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
    import EquipmentFilterForm from './equipment-filter-form.vue';

    export default {
        extends: Page,

        components: {
            EquipmentFilterForm
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
