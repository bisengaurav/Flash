<template>
    <filters-page-layout :title="pageTitle">
        <template #filters>
            <filters-form v-model="filters" cacheUniqueKey="callouts" />
        </template>

        <template #table>
            <data-table-basic
                keyField="compositeKey"
                :action="$API.case.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'entity.case.casenumber.label'"></th>
                    <th v-t="'entity.case.createddate.label'"></th>
                    <th v-t="'entity.case.duedate__c.label'"></th>
                    <th v-t="'entity.case.entrapment__c.label'"></th>
                    <th v-t="'entity.case.hazard__c.label'"></th>
                    <th v-t="'entity.case.injury__c.label'"></th>
                    <th v-t="'entity.case.assetname.label'"></th>
                    <th v-t="'entity.asset.locationname.label'"></th>
                    <th v-t="'entity.case.street__c.label'"></th>
                    <th v-t="'entity.case.city__c.label'"></th>
                    <th v-t="'entity.case.stateprovince__c.label'"></th>
                    <th v-t="'entity.case.contactname.label'"></th>
                    <th v-t="'entity.case.callername__c.label'"></th>
                    <th v-t="'entity.case.workordernumber.label'"></th>
                    <th v-t="'entity.case.assemblynumber__c.label'"></th>
                    <th v-t="'entity.case.appointmentnumber.label'"></th>
                    <th v-t="'entity.case.serviceappointmentstatus.label'"></th>
                    <th v-t="'entity.case.serviceresourcename.label'"></th>
                    <th v-t="'entity.asset.serviceterritoryname.label'"></th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'case', params: {id: row.id }}">{{row.caseNumber}}</router-link></td>
                    <td>{{ $dtz(row.createdDate, 'datetime') }}</td>
                    <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
                    <td>{{ row.entrapment__c|yesNo }}</td>
                    <td>{{ row.hazard__c|yesNo }}</td>
                    <td>{{ row.injury__c|yesNo }}</td>
                    <td><router-link :to="{name: 'asset', params: {id: row.assetId }}">{{row.assetName}}</router-link></td>
                    <td>{{row.locationName}}</td>
                    <td>{{row.street__c}}</td>
                    <td>{{row.city__c}}</td>
                    <td>{{row.stateProvince__c}}</td>
                    <td>{{row.contactName}}</td>
                    <td>{{row.callerName__c}}</td>
                    <td><router-link v-if="row.workOrderNumber" :to="{name: 'workOrder', params: {id: row.workOrderId }}">{{row.workOrderNumber}}</router-link></td>
                    <td>{{row.assemblyNumber__c}}</td>
                    <td><router-link v-if="row.appointmentNumber" :to="{name: 'serviceAppointment', params: {id: row.serviceAppointmentId }}">{{row.appointmentNumber}}</router-link></td>
                    <td>{{row.serviceAppointmentStatus}}</td>
                    <td><router-link v-if="row.serviceResourceName" :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link></td>
                    <td><router-link v-if="row.serviceTerritoryName" :to="{name: 'serviceTerritory', params: {id: row.serviceTerritoryId }}">{{row.serviceTerritoryName}}</router-link></td>
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
                pageTitle: this.$t('text.callouts.page-title'),
                filters: {}
            }
        }
    }
</script>
