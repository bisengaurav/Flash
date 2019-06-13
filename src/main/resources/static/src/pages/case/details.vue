<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t('entity.Case.status.label')">{{data.status}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.caseOwnerTxt__c.label')">{{data.caseOwnerTxt__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.createdDate.label')">{{ $dtz(data.createdDate, 'datetime')}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.entrapment__c.label')">{{ data.entrapment__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.hazard__c.label')">{{ data.hazard__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.injury__c.label')">{{ data.injury__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.assetName.label')">
                    <router-link :to="{name: 'asset', params: {id: data.assetId }}">{{data.assetName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.accountId.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.accountName.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.contactName.label')">{{data.contactName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.contactPhone.label')">{{data.contactPhone}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t( 'entity.Case.callerName__c.label')">{{data.callerName__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.callerPhoneNumber__c.label')">{{data.callerPhoneNumber__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.fsmContactIsPassenger__c .label')">{{ data.fsmContactIsPassenger__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.salesOrganizations__c.label')">{{data.salesOrganizations__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.subject.label')">{{data.subject}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('entity.Case.description.label')">{{data.description}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.case.related-work-orders')">
                <data-table-basic :source="data.workOrders">
                    <template #head>
                        <th v-t="'entity.WorkOrder.workOrderNumber.label'"></th>
                        <th v-t="'entity.WorkOrder.status.label'"></th>
                        <th v-t="'entity.WorkOrder.earliestStartDate__c.label'"></th>
                        <th v-t="'entity.WorkOrder.dueDate__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'workOrder', params: {id: row.id }}">{{row.workOrderNumber}}</router-link>
                        </td>
                        <td>{{row.status}}</td>
                        <td>{{ $dtz(row.earliestStartDate__c, 'datetime') }}</td>
                        <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
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
                action: this.$API.case.getById,
                titleField: 'caseNumber'
            }
        }
    }
</script>
