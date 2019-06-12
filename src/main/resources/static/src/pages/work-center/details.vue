<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data" :hideDetails="true">
        <template #relations>
            <entity-relations :title="$t('text.work-center.related-service-resources')">
                <data-table-basic :source="data.workCenterResources">
                    <template #head>
                        <th v-t="'entity.workcenterresource.serviceresourcename.label'"></th>
                        <th v-t="'entity.workcenterresource.workcentername.label'"></th>
                        <th v-t="'entity.workcenterresource.worktypename.label'"></th>
                        <th v-t="'entity.workcenterresource.preferencetype__c.label'"></th>
                        <th v-t="'entity.workcenterresource.startdate__c.label'"></th>
                        <th v-t="'entity.workcenterresource.enddate__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>
                            <router-link :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link>
                        </td>
                        <td>{{row.workCenterName}}</td>
                        <td>{{row.workTypeName}}</td>
                        <td>{{row.preferenceType__c}}</td>
                        <td>{{ $dtz(row.startDate__c, 'datetime') }}</td>
                        <td>{{ $dtz(row.endDate__c, 'datetime') }}</td>
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
                action: this.$API.workCenter.getById
            }
        }
    }
</script>
