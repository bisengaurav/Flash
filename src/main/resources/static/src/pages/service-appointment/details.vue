<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.status.label')">{{data.status}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.lastModifiedDate.label')">{{ $dtz(data.lastModifiedDate, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.scheduledStartOriginal__c.label')">{{ $dtz(data.scheduledStartOriginal__c, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.dueDate__c.label')">{{ $dtz(data.dueDate__c, 'datetime') }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.fslPinned__c.label')">{{ data.fslPinned__c|yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.blockedReason__c.label')">{{data.blockedReason__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.accountId.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t( 'entity.ServiceAppointment.accountName.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.serviceResourceName.label')">
                    <router-link :to="{name: 'serviceResource', params: {id: data.serviceResourceId }}">{{data.serviceResourceName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.workOrderNumber.label')">
                    <router-link :to="{name: 'workOrder', params: {id: data.workOrderId }}">{{data.workOrderNumber}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.assetName.label')">
                    <router-link :to="{name: 'asset', params: {id: data.assetId }}">{{data.assetName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.serviceTerritoryName.label')">
                    <router-link :to="{name: 'serviceTerritory', params: {id: data.serviceTerritoryId }}">{{data.serviceTerritoryName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.ServiceAppointment.salesOrganization__c.label')">{{data.salesOrganization__c}}</form-element-static>
            </grid-item>
        </template>
    </entity-details-layout>
</template>

<script>
    import EntityDetailsInterface from '../../interfaces/entity-details.js';
    export default {
        extends: EntityDetailsInterface,

        data() {
            return  {
                action: this.$API.serviceAppointment.getById,
                titleField: 'appointmentNumber'
            }
        }
    }
</script>
