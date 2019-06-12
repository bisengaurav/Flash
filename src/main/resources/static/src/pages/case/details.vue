<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item>
                <form-element-static :label="$t('field.case.status.label')">{{data.status}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.caseownertxt__c.label')">{{data.caseOwnerTxt__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.createddate.label')">{{ $dtz(data.createdDate, 'datetime')}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.entrapment__c.label')">{{ data.entrapment__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.hazard__c.label')">{{ data.hazard__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.injury__c.label')">{{ data.injury__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.assetname.label')">
                    <router-link :to="{name: 'asset', params: {id: data.assetId }}">{{data.assetName}}</router-link>
                </form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.accountid.label')">{{data.accountId}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.accountname.label')">{{data.accountName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.contactname.label')">{{data.contactName}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.contactphone.label')">{{data.contactPhone}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t( 'field.case.callername__c.label')">{{data.callerName__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.callerphonenumber__c.label')">{{data.callerPhoneNumber__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.fsmcontactIspassenger__c.label')">{{ data.fsmContactIsPassenger__c |yesNo }}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.salesorganization__c.label')">{{data.salesOrganizations__c}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.subject.label')">{{data.subject}}</form-element-static>
            </grid-item>

            <grid-item>
                <form-element-static :label="$t('field.case.description.label')">{{data.description}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.case.related-work-orders')">
                <data-table-basic :source="data.workOrders">
                    <template #head>
                        <th v-t="'field.workorder.workordernumber.label'"></th>
                        <th v-t="'field.workorder.status.label'"></th>
                        <th v-t="'field.workorder.earlieststartdate__c.label'"></th>
                        <th v-t="'field.workorder.duedate__c.label'"></th>
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
