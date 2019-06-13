<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t('entity.Asset.equipmentTypeValue.label')">{{data.equipmentTypeValue}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.fsmLastValidCliEndDate__c.label')">{{data.fsmLastValidCliEndDate__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.customerAssetName__c.label')">{{data.customerAssetName__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.accountId.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.accountName.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.soldToId.label')">{{data.soldToId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.soldToName.label')">{{data.soldToName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.installationCity__c.label')">{{data.installationCity__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.installationCountry__c.label')">{{data.installationCountry__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.locationName.label')">{{data.locationName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.serviceTerritoryName.label')">
                    <router-link :to="{name: 'serviceTerritory', params: {id: data.serviceTerritoryId }}">{{data.serviceTerritoryName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Asset.workCenterName.label')">
                    <router-link :to="{name: 'workCenter', params: {id: data.workCenterId }}">{{data.workCenterName}}</router-link>
                </form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.asset.related-entitlements')">
                <data-table-basic :source="data.activeSLAs">
                    <template #head>
                        <th v-t="'entity.Entitlement.name.label'"></th>
                        <th v-t="'entity.Entitlement.coverage__c.label'"></th>
                        <th v-t="'entity.Entitlement.startdate.label'"></th>
                        <th v-t="'entity.Entitlement.enddate.label'"></th>
                        <th v-t="'entity.Entitlement.status.label'"></th>
                        <th v-t="'entity.Entitlement.responseTime__c.label'"></th>
                        <th v-t="'entity.Entitlement.responseTimeAfterHours__c.label'"></th>
                        <th v-t="'entity.Entitlement.calloutHours__c.label'"></th>
                        <th v-t="'entity.Entitlement.serviceHours__c.label'"></th>
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
