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

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.equipmenttype__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.equipmentType__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.fsmlastvalidclienddate__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ equipment.fsmLastValidCliEndDate__c |yesNo }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.customerassetname__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.customerAssetName__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.accountid.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.accountId}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.accountname.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.accountName}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.soldtoid.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.soldToId}}
                            </div>
                        </div>
                    </div>
                    <div class="slds-grid slds-wrap slds-grid_pull-padded">
                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.soldtoname.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.soldToName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.installationcity__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.installationCity__c}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.equipment.installationcountry__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.installationCountry__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.locationname.label'"></span>
                            <div class="slds-form-element__static">
                                {{equipment.locationName}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.serviceterritoryname.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'serviceTerritory', params: {id: equipment.serviceTerritoryId }}">{{equipment.serviceTerritoryName}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t=" 'field.asset.workcentername.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'workCenter', params: {id: equipment.workCenterId }}">{{equipment.workCenterName}}</router-link>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

            <div v-if="equipment.activeSLAs.length > 0">

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                        <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.slas.heading'"></h2>
                        <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                            <thead>
                                <tr class="slds-line-height_reset">
                                    <th v-t="'field.equipment.activeslas.name.label'"></th>
                                    <th v-t="'field.equipment.activeslas.coverage__c.label'"></th>
                                    <th v-t="'field.equipment.activeslas.startdate.label'"></th>
                                    <th v-t="'field.equipment.activeslas.enddate.label'"></th>
                                    <th v-t="'field.equipment.activeslas.status.label'"></th>
                                    <th v-t="'field.equipment.activeslas.responseTime__c.label'"></th>
                                    <th v-t="'field.equipment.activeslas.responseTimeAfterHours__c.label'"></th>
                                    <th v-t="'field.equipment.activeslas.calloutHours__c.label'"></th>
                                    <th v-t="'field.equipment.activeslas.serviceHours__c.label'"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-for="row in equipment.activeSLAs"
                                    :key="row.id"
                                >
                                <td>{{row.name}}</td>
                                <td>{{row.coverage__c}}</td>
                                <td>{{ $dtz(row.startdate, 'datetime') }}</td>
                                <td>{{ $dtz(row.enddate, 'datetime') }}</td>
                                <td>{{row.status}}</td>
                                <td>{{row.responseTime__c}}</td>
                                <td>{{row.responseTimeAfterHours__c}}</td>
                                <td>{{row.calloutHours__c}}</td>
                                <td>{{row.serviceHours__c}}</td>
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
                pageTitle: this.$t('text.equipment.heading'),
                loading: true,
                equipment: {},
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
                this.$API.equipment.getById(this.id)
                    .then(data => {
                        this.equipment = data;
                        this.loading = false;
                        this.pageTitle = this.$t('text.equipment.heading') +' — '+ this.equipment.name;
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
