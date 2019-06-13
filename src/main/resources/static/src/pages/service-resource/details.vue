<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item x="2">
                <form-element-static :label="$t('entity.ServiceResource.phone__c.label')">{{data.phone__c}}</form-element-static>
            </grid-item>

            <grid-item x="2">
                <form-element-static :label="$t('entity.ServiceResource.salesOrganization__c.label')">{{data.salesOrganization__c}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.service-resource.related-territories')">
                <data-table-basic :source="data.serviceResourceTerritories">
                    <template #head>
                        <th v-t="'entity.ServiceTerritoryMember.name.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.territoryType.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.shiftType__c.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.effectiveStartDate.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.effectiveEndDate.label'"></th>
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
                        <th v-t="'entity.WorkCenterResource.name.label'"></th>
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
                        <th v-t="'entity.ResourceAbsence.start.label'"></th>
                        <th v-t="'entity.ResourceAbsence.end.label'"></th>
                        <th v-t="'entity.ResourceAbsence.recordType__c.label'"></th>
                        <th v-t="'entity.ResourceAbsence.type.label'"></th>
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
                        <th v-t="'entity.ServiceAppointment.appointmentNumber.label'"></th>
                        <th v-t="'entity.ServiceAppointment.status.label'"></th>
                        <th v-t="'entity.ServiceAppointment.scheduledStartOriginal__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.scheduledEndOriginal__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.fslPinned__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.workOrderNumber.label'"></th>
                        <th v-t="'entity.ServiceAppointment.earliestStartDate__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.dueDate__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.maintenanceActivityType__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.assembly__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.locationName.label'"></th>
                        <th v-t="'entity.ServiceAppointment.installationStreet__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.installationCity__c.label'"></th>
                        <th v-t="'entity.ServiceAppointment.description__c.label'"></th>
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
                        <td>{{row.locationName}}</td>
                        <td>{{row.installationStreet__c}}</td>
                        <td>{{row.installationCity__c}}</td>
                        <td>{{row.description__c}}</td>
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
