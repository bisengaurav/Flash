<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>

             <div class="slds-card slds-p-around_medium">

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.status.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.lastmodifieddate.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(serviceAppointment.lastModifiedDate, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.scheduledstartoriginal__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(serviceAppointment.scheduledStartOriginal__c, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.duedate__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(serviceAppointment.dueDate__c, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.fslpinned__c.label'"></span>
                            <div class="slds-form-element__static">
                               {{ serviceAppointment.fslPinned__c |yesNo }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.blockedreason__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.blockedReason__c}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">


                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.accountid.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t=" 'field.serviceappointment.accountname.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.accountName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.serviceresourcename.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'serviceResource', params: {id: serviceAppointment.serviceResourceId }}">{{serviceAppointment.serviceResourceName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.workordernumber.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'workOrder', params: {id: serviceAppointment.workOrderId }}">{{serviceAppointment.workOrderNumber}}  </router-link>
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.assetname.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'equipmentDetails', params: {id: serviceAppointment.assetId }}"> {{serviceAppointment.assetName}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.serviceterritoryname.label'"></span>
                            <div class="slds-form-element__static">
                                  <router-link :to="{name: 'serviceTerritory', params: {id: serviceAppointment.serviceTerritoryId }}">{{serviceAppointment.serviceTerritoryName}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.serviceappointment.salesorganization__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.salesOrganization__c}}
                            </div>
                        </div>
                    </div>

                </div>

        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';

    export default {
        extends: Page,

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
                pageTitle: this.$t('label.service-appointment'),
                loading: true,
                serviceAppointment: {}
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
                  this.$API.serviceAppointment.getById(this.id)
                    .then(data => {
                        this.loading = false;
                        this.serviceAppointment = data;
                        this.pageTitle = this.$t('label.service-appointment') +' — '+ this.serviceAppointment.appointmentNumber;
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
