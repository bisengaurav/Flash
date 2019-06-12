<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item x="2">
                <form-element-static :label="$t('field.serviceresource.phone__c.label')">{{data.phone__c}}</form-element-static>
            </grid-item>

            <grid-item x="2">
                <form-element-static :label="$t('field.serviceresource.salesorganization__c.label')">{{data.salesOrganization__c}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.service-resource.related-territories')">
                <data-table-basic :source="data.serviceResourceTerritories">
                    <template #head>
                        <th v-t="'field.serviceresourceterritory.name.label'"></th>
                        <th v-t="'field.serviceresourceterritory.territorytype.label'"></th>
                        <th v-t="'field.serviceresourceterritory.shifttype__c.label'"></th>
                        <th v-t="'field.serviceresourceterritory.effectivestartdate.label'"></th>
                        <th v-t="'field.serviceresourceterritory.effectiveenddate.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'serviceTerritory', params: {id: row.id }}">{{row.name}}</router-link>
                        </td>
                        <td>{{row.territoryType}}</td>
                        <td>{{row.shiftType__c}}</td>
                        <td>{{ $dtz(row.effectiveStartDate, 'datetime') }}</td>
                        <td>{{ $dtz(row.effectiveEndDate, 'datetime') }}</td>
                    </template>
                </data-table-basic>
            </entity-relations>

            <entity-relations :title="$t('text.service-resource.related-work-centers')">
                <data-table-basic :source="data.serviceResourceWorkCenters">
                    <template #head>
                        <th v-t="'field.serviceresourceworkcenter.name.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'workCenter', params: {id: row.id }}">{{row.name}}</router-link>
                        </td>
                    </template>
                </data-table-basic>
            </entity-relations>

            <entity-relations :title="$t('text.service-resource.related-absences')">
                <data-table-basic :source="data.resourceAbsences">
                    <template #head>
                        <th v-t="'field.resourceabsence.start.label'"></th>
                        <th v-t="'field.resourceabsence.end.label'"></th>
                        <th v-t="'field.resourceabsence.recordtype__c.label'"></th>
                        <th v-t="'field.resourceabsence.type.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>{{ $dtz(row.start, 'datetime') }}</td>
                        <td>{{ $dtz(row.end, 'datetime') }}</td>
                        <td>{{row.recordType__c}}</td>
                        <td>{{row.type}}</td>
                    </template>
                </data-table-basic>
            </entity-relations>

            <entity-relations :title="$t('text.service-resource.related-appointments')">
                <data-table-basic :source="data.serviceResourceAppointments">
                    <template #head>
                        <th v-t="'field.serviceresourceappointment.appointmentnumber.label'"></th>
                        <th v-t="'field.serviceresourceappointment.status.label'"></th>
                        <th v-t="'field.serviceresourceappointment.scheduledstartoriginal__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.scheduledendoriginal__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.fslpinned__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.workordernumber.label'"></th>
                        <th v-t="'field.serviceresourceappointment.earlieststartdate__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.duedate__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.maintenanceactivitytype__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.assembly__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.description__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.locationname.label'"></th>
                        <th v-t="'field.serviceresourceappointment.installationstreet__c.label'"></th>
                        <th v-t="'field.serviceresourceappointment.installationcity__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'serviceAppointment', params: {id: row.id }}">{{row.appointmentNumber}}</router-link>
                        </td>
                        <td>{{row.status}}</td>
                        <td>{{ $dtz(row.scheduledStartOriginal__c, 'datetime') }}</td>
                        <td>{{ $dtz(row.scheduledEndOriginal__c, 'datetime') }}</td>
                        <td>{{ row.fslPinned__c |yesNo }}</td>
                        <td>
                            <router-link :to="{name: 'workOrder', params: {id: row.workOrderId }}">{{row.workOrderNumber}}</router-link>
                        </td>
                        <td>{{ $dtz(row.earliestStartDate__c, 'datetime') }}</td>
                        <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
                        <td>{{row.maintenanceActivityType__c}}</td>
                        <td>{{row.assembly__c}}</td>
                        <td>{{row.description__c}}</td>
                        <td>{{row.locationName}}</td>
                        <td>{{row.installationStreet__c}}</td>
                        <td>{{row.installationCity__c}}</td>
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
                action: this.$API.serviceResource.getById
            }
        }
    }
</script>
