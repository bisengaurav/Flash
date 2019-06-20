<template>
    <filters-page-layout :title="pageTitle">
        <template #filters>
            <filters-form v-model="filters" cacheUniqueKey="assets" />
        </template>

        <template #table>
            <data-table-basic
                :action="$API.asset.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'entity.Asset.name.label'"></th>
                    <th v-t="'entity.Asset.equipmentTypeValue.label'"></th>
                    <th v-t="'entity.Asset.customerAssetName__c.label'"></th>
                    <th v-t="'entity.Asset.equipmentPhoneNumber__c.label'"></th>
                    <th v-t="'entity.Asset.accountName.label'"></th>
                    <th v-t="'entity.Asset.soldToName.label'"></th>
                    <th v-t="'entity.Asset.locationName.label'"></th>
                    <th v-t="'entity.Asset.installationStreet__c.label'"></th>
                    <th v-t="'entity.Asset.installationCity__c.label'"></th>
                    <th v-t="'entity.Asset.installationStateProvince__c.label'"></th>
                    <th v-t="'entity.Asset.installationCountry__c.label'"></th>
                    <th v-t="'entity.Asset.serviceTerritoryName.label'"></th>
                    <th v-t="'entity.Asset.workCenterName.label'"></th>
                    <th v-t="'entity.Asset.fsmLastValidCliEndDate__c.label'"></th>
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
                    <td>{{row.installationCountry__c}}</td>
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
