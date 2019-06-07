<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <equipment-filter-form v-model="filters" cacheUniqueKey="equipment-page" :applyOnCacheLoad="true"></equipment-filter-form>

        <div class="primary-section slds-m-top_x-large">
            <data-table-basic
                    :action="$API.equipment.getAllByFilter"
                    :filters="filters"
                    :immediateRefresh="false"
                >
                <template #head>
                    <th v-t="'field.equipment.name.label'"></th>
                    <th v-t="'field.equipment.equipmenttype__c.label'"></th>
                    <th v-t="'field.equipment.customerassetname__c.label'"></th>
                    <th v-t="'field.equipment.equipmentphonenumber__c.label'"></th>
                    <th v-t="'field.asset.accountname.label'"></th>
                    <th v-t="'field.equipment.soldtoname.label'"></th>
                    <th v-t="'field.asset.locationname.label'"></th>
                    <th v-t="'field.asset.installationstreet__c.label'"></th>
                    <th v-t="'field.asset.installationcity__c.label'"></th>
                    <th v-t="'field.asset.installationstateprovince__c.label'"></th>
                    <th v-t="'field.asset.serviceterritoryname.label'"></th>
                    <th v-t="'field.asset.workcentername.label'"></th>
                    <th v-t="'field.equipment.fsmlastvalidclienddate__c.label'"></th>
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
                    <td>{{row.fsmLastValidCliEndDate__c|yesNo}}</td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import PageInterface from '../../components/page-interface.vue';
    import EquipmentFilterForm from './equipment-filter-form.vue';

    export default {
        extends: PageInterface,

        components: {
            EquipmentFilterForm
        },

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: this.$t('label.equipment'),
                filters: {}
            }
        }
    }
</script>
