<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>
        <loader v-if="loading" type="block" :height="400" />
        <div v-else>

            <div class="slds-col slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                     <!-- slds-p-bottom_mediumslds-border_bottom -->
                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceterritory.salesorganization__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceTerritory.salesOrganization__c}}
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div v-if="serviceTerritory.serviceTerritoryResources.length > 0">

                 <div class="slds-card slds-p-around_medium slds-m-top_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'label.service-territory.service-resources'"></h2>
                    <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.serviceterritoryresources.effectivestartdate.label'"></th>
                                <th v-t="'field.serviceterritoryresources.effectiveenddate.label'"></th>
                                <th v-t="'field.serviceterritoryresources.serviceresource_name.label'"></th>
                                <th v-t="'field.serviceterritoryresources.phone__c.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in serviceTerritory.serviceTerritoryResources"
                                :key="row.id"
                            >
                                <td>{{ $dtz(row.effectiveStartDate, 'datetime') }}</td>
                                <td>{{ $dtz(row.effectiveEndDate, 'datetime') }}</td>
                                <td><router-link :to="{name: 'serviceResource', params: {id: row.serviceResource_id }}">{{row.serviceResource_name}}</router-link></td>
                                <td>{{row.phone__c}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    import PageInterface from '../../components/page-interface.vue';

    export default {
        extends: PageInterface,

        //
        // PARAMS: porps, data, computed
        //
        props: {
            id: {
                type: Number,
                default: null
            }
        },
        data() {
            return  {
                pageTitle: this.$t('text.service-territory.heading'),
                loading: true,
                serviceTerritory: {},
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.loading = true;

                // wrong Job ID
                if (!this.id) {
                    throw new Error('Wrong ID');
                }

                // data
                 this.$API.serviceTerritory.getById(this.id)
                    .then(data => {
                        this.loading = false;
                        this.serviceTerritory = data;
                        this.pageTitle =  this.$t('text.service-territory.heading') +' — '+ this.serviceTerritory.name;
                    });
            }
        },

        //
        // WATCHERS
        //
        watch: {
            id: {
                handler() {
                    this.init();
                },
                immediate: true
            }
        }

    }
</script>
