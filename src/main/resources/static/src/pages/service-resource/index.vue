<template>
    <filters-page-layout :title="pageTitle">
        <template #filters>
            <filters-form v-model="filters" cacheUniqueKey="service-resources" />
        </template>

        <template #table>
            <data-table-basic
                :action="$API.serviceResource.getAllByFilter"
                :filters="filters"
                :immediateRefresh="false"
            >
                <template #head>
                    <th v-t="'field.serviceresource.name.label'"></th>
                    <th v-t="'field.serviceresource.phone__c.label'"></th>
                    <th v-t="'field.serviceresource.salesorganization__c.label'"></th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'serviceResource', params: {id: row.id }}">{{row.name}}</router-link></td>
                    <td>{{row.phone__c}}</td>
                    <td>{{row.salesOrganization__c}}</td>
                </template>
            </data-table-basic>
        </template>
    </filters-page-layout>
</template>

<script>
    import PageInterface from '../../interfaces/page.js';
    import FiltersForm from './filters-form.vue';

    export default {
        extends: PageInterface,

        components: {
            FiltersForm
        },

        //
        // PARAMS: props, data, computed
        //
        data() {
            return {
                pageTitle: this.$t('text.service-resources.page-title'),
                filters: {}
            }
        }
    }
</script>
