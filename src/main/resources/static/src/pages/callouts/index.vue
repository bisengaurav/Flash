<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <callouts-filter-form v-model="filters" cacheUniqueKey="callouts-page" :applyOnCacheLoad="true"></callouts-filter-form>

        <div class="primary-section slds-m-top_x-large">
            <data-table-basic
                :keyField="(row) => {
                    return  row.compositeKey.id +'_'+ row.compositeKey.serviceAppointmentId +'_'+ row.compositeKey.workOrderId;
                }"
                :action="$API.case.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'field.case.casenumber.label'"></th>
                    <th v-t="'field.case.createddate.label'"></th>
                    <th v-t="'field.case.duedate__c.label'"></th>
                    <th v-t="'field.case.entrapment__c.label'"></th>
                    <th v-t="'field.case.hazard__c.label'"></th>
                    <th v-t="'field.case.injury__c.label'"></th>
                    <th v-t="'field.case.assetname.label'"></th>
                    <th v-t="'field.asset.locationname.label'"></th>
                    <th v-t="'field.case.street__c.label'"></th>
                    <th v-t="'field.case.city__c.label'"></th>
                    <th v-t="'field.case.stateprovince__c.label'"></th>
                    <th v-t="'field.case.contactname.label'"></th>
                    <th v-t="'field.case.callername__c.label'"></th>
                    <th v-t="'field.case.workordernumber.label'"></th>
                    <th v-t="'field.case.assemblynumber__c.label'"></th>
                    <th v-t="'field.case.appointmentnumber.label'"></th>
                    <th v-t="'field.case.serviceappointmentstatus.label'"></th>
                    <th v-t="'field.case.serviceresourcename.label'"></th>
                    <th v-t="'field.asset.serviceterritoryname.label'"></th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'case', params: {id: row.id }}">{{row.caseNumber}}</router-link></td>
                    <td>{{ $dtz(row.createdDate, 'datetime') }}</td>
                    <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
                    <td>{{ row.entrapment__c|yesNo }}</td>
                    <td>{{ row.hazard__c|yesNo }}</td>
                    <td>{{ row.injury__c|yesNo }}</td>
                    <td><router-link :to="{name: 'equipmentDetails', params: {id: row.assetId }}">{{row.assetName}}</router-link></td>
                    <td>{{row.locationName}}</td>
                    <td>{{row.street__c}}</td>
                    <td>{{row.city__c}}</td>
                    <td>{{row.stateProvince__c}}</td>
                    <td>{{row.contactName}}</td>
                    <td>{{row.callerName__c}}</td>
                    <td><router-link :to="{name: 'workOrder', params: {id: row.workOrderId }}">{{row.workOrderNumber}}</router-link></td>
                    <td>{{row.assemblyNumber__c}}</td>
                    <td><router-link :to="{name: 'serviceAppointment', params: {id: row.serviceAppointmentId }}">{{row.appointmentNumber}}</router-link></td>
                    <td>{{row.serviceAppointmentStatus}}</td>
                    <td><router-link :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link></td>
                    <td><router-link :to="{name: 'serviceTerritory', params: {id: row.serviceTerritoryId }}">{{row.serviceTerritoryName}}</router-link></td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import PageInterface from '../../components/page-interface.vue';
    import CalloutsFilterForm from './callouts-filter-form.vue';

    export default {
        extends: PageInterface,

        components: {
            CalloutsFilterForm
        },

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: this.$t('text.callouts.heading'),
                filters: {}
            }
        }
    }
</script>
