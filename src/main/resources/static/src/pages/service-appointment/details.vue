<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>

             <div class="slds-card slds-p-around_medium">

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Status</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Last updated in FSM</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.lastModifiedDate|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Scheduled Start Date</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.scheduledStartOriginal__c|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Scheduled End Date</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.dueDate__c|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Pinned</span>
                            <div class="slds-form-element__static">
                               {{ serviceAppointment.fslPinned__c ? 'Yes' : '' }} {{ serviceAppointment.fslPinned__c === false ? 'No' : '' }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Blocked reason</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.blockedReason__c}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">


                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account ID</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account name</span>
                            <div class="slds-form-element__static">
                                {{serviceAppointment.accountName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Service resource</span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: '', params: {id: serviceAppointment.serviceResourceId }}">{{serviceAppointment.serviceResourceName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Work order</span>
                            <div class="slds-form-element__static">
                                <!-- <router-link :to="{name: 'workOrder', params: {id: row.workOrderId }}">{{row.workOrderNumber}}</router-link> -->
                                <router-link :to="{name: 'workOrder', params: {id: serviceAppointment.workOrderId }}">{{serviceAppointment.workOrderNumber}}  </router-link>
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Asset</span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: '', params: {id: serviceAppointment.assetId }}"> {{serviceAppointment.assetName}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Service territory</span>
                            <div class="slds-form-element__static">
                                  <router-link :to="{name: 'serviceTerritory', params: {id: serviceAppointment.serviceTerritoryId }}">{{serviceAppointment.serviceTerritoryName}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Sales organization</span>
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
                pageTitle: 'Service Appointment',
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
                        this.pageTitle = 'Service Appointment — '+ this.serviceAppointment.appointmentNumber;
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
