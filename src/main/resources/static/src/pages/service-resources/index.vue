<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <service-resources-filter-form v-model="filters" cacheUniqueKey="service-resources-page" :applyOnCacheLoad="true"></service-resources-filter-form>

         <div class="primary-section slds-m-top_x-large">
            <data-table-basic
                    :action="$API.serviceResource.getAllByFilter"
                    :filters="filters"
                    :immediateRefresh="false"
                    :useLoading="false"
                >
                <template #head>
                    <th>Title</th>
                    <th>Phone</th>
                    <th>Sales organization</th>
                </template>
                <template #row="{row, id}">
                    <td><router-link :to="{name: 'serviceResource', params: {id: row.id }}">{{row.name}}</router-link></td>
                    <td>{{row.phone__c}}</td>
                    <td>{{row.salesOrganization__c}}</td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
    import ServiceResourcesFilterForm from './service-resources-filter-form.vue';

    export default {
        extends: Page,

        components: {
            ServiceResourcesFilterForm
        },
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Service Resource',
                filters: {}
            }
        }
    }
</script>
