<template>
    <entity-details-layout :title="pageTitle" :loading="loading" :data="data">
        <template #details>
            <grid-item x="1">
                <form-element-static :label="$t('entity.ServiceTerritory.salesOrganization__c.label')">{{data.salesOrganization__c}}</form-element-static>
            </grid-item>
        </template>


        <template #relations>
            <entity-relations :title="$t('text.service-territory.related-service-resources')">
                <data-table-basic :source="data.activeServiceTerritoryResources">
                    <template #head>
                        <th v-t="'entity.ServiceTerritoryMember.effectiveStartDate.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.effectiveEndDate.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.serviceResource_name.label'"></th>
                        <th v-t="'entity.ServiceTerritoryMember.phone__c.label'"></th>
                    </template>
                    <template #row="{row, id}">
                        <td>{{ $dtz(row.effectiveStartDate, 'datetime') }}</td>
                        <td>{{ $dtz(row.effectiveEndDate, 'datetime') }}</td>
                        <td>
                            <router-link :to="{name: 'serviceResource', params: {id: row.serviceResource_id }}">{{row.serviceResource_name}}</router-link>
                        </td>
                        <td>{{row.phone__c}}</td>
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
                action: this.$API.serviceTerritory.getById
            }
        }
    }
</script>
