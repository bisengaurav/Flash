<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t('entity.equipment.equipmenttype__c.label')">{{data.equipmentType__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.fsmlastvalidclienddate__c.label')">{{data.fsmLastValidCliEndDate__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.customerassetname__c.label')">{{data.customerAssetName__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.accountid.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.asset.accountname.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.soldtoid.label')">{{data.soldToId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.soldtoname.label')">{{data.soldToName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.installationcity__c.label')">{{data.installationCity__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.installationcountry__c.label')">{{data.installationCountry__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.asset.locationname.label')">{{data.locationName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.asset.serviceterritoryname.label')">
                    <router-link :to="{name: 'serviceTerritory', params: {id: data.serviceTerritoryId }}">{{data.serviceTerritoryName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.equipment.workcentername.label')">
                    <router-link :to="{name: 'workCenter', params: {id: data.workCenterId }}">{{data.workCenterName}}</router-link>
                </form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.asset.related-slas')">
                <data-table-basic :source="data.activeSLAs">
                    <template #head>
                        <th v-t="'entity.activesla.name.label'"></th>
                        <th v-t="'entity.activesla.coverage__c.label'"></th>
                        <th v-t="'entity.activesla.startdate.label'"></th>
                        <th v-t="'entity.activesla.enddate.label'"></th>
                        <th v-t="'entity.activesla.status.label'"></th>
                        <th v-t="'entity.activesla.responseTime__c.label'"></th>
                        <th v-t="'entity.activesla.responseTimeAfterHours__c.label'"></th>
                        <th v-t="'entity.activesla.calloutHours__c.label'"></th>
                        <th v-t="'entity.activesla.serviceHours__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>{{row.name}}</td>
                        <td>{{row.coverage__c}}</td>
                        <td>{{ $dtz(row.startdate, 'datetime') }}</td>
                        <td>{{ $dtz(row.enddate, 'datetime') }}</td>
                        <td>{{row.status}}</td>
                        <td>{{row.responseTime__c}}</td>
                        <td>{{row.responseTimeAfterHours__c}}</td>
                        <td>{{row.calloutHours__c}}</td>
                        <td>{{row.serviceHours__c}}</td>
                    </template>
                </data-table-basic>
            </entity-relations>
        </template>
    </entity-details-layout>
</template>

<script>
    import EntityDetailsInterface from '../../interfaces/entity-details.js';

    export default {
        extends: EntityDetailsInterface,

        data() {
            return  {
                action: this.$API.asset.getById
            }
        }
    }
</script>
