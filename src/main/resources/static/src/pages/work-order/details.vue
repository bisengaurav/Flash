<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t( 'field.workorder.status.label')">{{data.status}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.lastmodifieddate.label')">{{ $dtz(data.lastModifiedDate, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.earlieststartdate__c.label')">{{ $dtz(data.earliestStartDate__c, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.duedate__c.label')">{{ $dtz(data.dueDate__c, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.assembly__c.label')">{{data.assembly__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.asset.accountname.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.assetname.label')">
                    <router-link :to="{name: 'asset', params: {id: data.assetId }}">{{data.assetName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.accountid.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.serviceterritoryname.label')">
                    <router-link :to="{name: 'serviceTerritory', params: {id: data.serviceTerritoryId }}">{{data.serviceTerritoryName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.asset.locationname.label')">{{data.locationName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.casenumber.label')">
                    <router-link :to="{name: 'case', params: {id: data.caseId }}"> {{data.caseNumber}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.description__c.label')">{{data.description__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.sales_organization__c.label')">{{data.sales_organization__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.workorder.maintenanceActivityTypeCode__c.label')">{{data.maintenanceActivityTypeCode__c}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.work-order.related-appointments')">
                <data-table-basic :source="data.serviceAppointments">
                    <template #head>
                        <th v-t="'field.workorder.appointmentnumber.label'"></th>
                        <th v-t="'field.workorder.status.label'"></th>
                        <th v-t="'field.workorder.serviceresourcename.label'"></th>
                        <th v-t="'field.workorder.scheduledstartoriginal__c.label'"></th>
                        <th v-t="'field.workorder.scheduledendoriginal__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'serviceAppointment', params: {id: row.id }}">{{row.appointmentNumber}}</router-link>
                        </td>
                        <td>{{row.status}}</td>
                        <td>
                            <router-link :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link>
                        </td>
                        <td>{{ $dtz(row.scheduledStartOriginal__c, 'datetime') }}</td>
                        <td>{{ $dtz(row.scheduledEndOriginal__c, 'datetime') }}</td>
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
                action: this.$API.workOrder.getById,
                titleField: 'workOrderNumber'
            }
        }
    }
</script>
