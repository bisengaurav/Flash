<template>
    <filters-page-layout :title="pageTitle">
        <template #filters>
            <filters-form v-model="filters" cacheUniqueKey="equipment" />
        </template>

        <template #table>
            <data-table-basic
                :action="$API.asset.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'entity.equipment.name.label'"></th>
                    <th v-t="'entity.equipment.equipmenttype__c.label'"></th>
                    <th v-t="'entity.equipment.customerassetname__c.label'"></th>
                    <th v-t="'entity.equipment.equipmentphonenumber__c.label'"></th>
                    <th v-t="'entity.asset.accountname.label'"></th>
                    <th v-t="'entity.equipment.soldtoname.label'"></th>
                    <th v-t="'entity.asset.locationname.label'"></th>
                    <th v-t="'entity.equipment.installationstreet__c.label'"></th>
                    <th v-t="'entity.equipment.installationcity__c.label'"></th>
                    <th v-t="'entity.equipment.installationstateprovince__c.label'"></th>
                    <th v-t="'entity.asset.serviceterritoryname.label'"></th>
                    <th v-t="'entity.equipment.workcentername.label'"></th>
                    <th v-t="'entity.equipment.fsmlastvalidclienddate__c.label'"></th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'asset', params: {id: id }}">{{row.name}}</router-link></td>
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
        </template>
    </filters-page-layout>
</template>

<script>
    import PageInterface from '../../interfaces/page.js';
    import FiltersForm from './filters-form.vue';
    import SelectBoolean from '../../components/select-boolean.vue';
    import {required} from 'vuelidate/lib/validators';

    export default {
        extends: PageInterface,

        components: {
            FiltersForm,
            SelectBoolean
        },

        //
        // PARAMS: props, data, computed
        //
        data() {
            return {
                pageTitle: this.$t('text.assets.page-title'),
                filters: {}
            }
        }
    }
</script>
