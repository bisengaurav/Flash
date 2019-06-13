<template>
    <filters-page-layout :title="pageTitle">
        <template #filters>
            <filters-form v-model="filters" cacheUniqueKey="callouts" />
        </template>

        <template #table>
            <data-table-basic
                keyField="compositeKey"
                :action="$API.callout.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'entity.Callout.caseNumber.label'"></th>
                    <th v-t="'entity.Callout.status.label'"></th>
                    <th v-t="'entity.Callout.createdDate.label'"></th>
                    <th v-t="'entity.Callout.dueDate__c.label'"></th>
                    <th v-t="'entity.Callout.entrapment__c.label'"></th>
                    <th v-t="'entity.Callout.hazard__c.label'"></th>
                    <th v-t="'entity.Callout.injury__c.label'"></th>
                    <th v-t="'entity.Callout.assetName.label'"></th>
                    <th v-t="'entity.Callout.locationName.label'"></th>
                    <th v-t="'entity.Callout.street__c.label'"></th>
                    <th v-t="'entity.Callout.city__c.label'"></th>
                    <th v-t="'entity.Callout.stateProvince__c.label'"></th>
                    <th v-t="'entity.Callout.contactName.label'"></th>
                    <th v-t="'entity.Callout.callerName__c.label'"></th>
                    <th v-t="'entity.Callout.workOrderNumber.label'"></th>
                    <th v-t="'entity.Callout.assemblyNumber__c.label'"></th>
                    <th v-t="'entity.Callout.appointmentNumber.label'"></th>
                    <th v-t="'entity.Callout.serviceAppointmentStatus.label'"></th>
                    <th v-t="'entity.Callout.serviceResourceName.label'"></th>
                    <th v-t="'entity.Callout.serviceTerritoryName.label'"></th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'case', params: {id: row.id }}">{{row.caseNumber}}</router-link></td>
                    <td>{{row.status}}</td>
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
