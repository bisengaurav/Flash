<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>
        <loader v-if="loading" type="block" :height="400" />
        <div v-else>
            <div class="slds-col slds-size_1-of-1">

                <div class="slds-card slds-p-around_medium">
                     <!-- slds-p-bottom_mediumslds-border_bottom -->
                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <!-- <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Case title</span>
                            <div class="slds-form-element__static">
                                {{caseData.caseOwnerTxt__c}}
                            </div>
                        </div> -->

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Status</span>
                            <div class="slds-form-element__static">
                                {{workOrder.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Last updated in FSM</span>
                            <div class="slds-form-element__static">
                                {{workOrder.lastModifiedDate|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Earliest Start Date</span>
                            <div class="slds-form-element__static">
                                {{workOrder.earliestStartDate__c|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Due Date</span>
                            <div class="slds-form-element__static">
                                {{workOrder.dueDate__c|formatDate}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Assembly Code</span>
                            <div class="slds-form-element__static">
                               {{workOrder.assembly__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account name</span>
                            <div class="slds-form-element__static">
                                {{workOrder.accountName}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">


                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Asset</span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: '', params: {id: workOrder.assetId }}">{{workOrder.assetName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account ID</span>
                            <div class="slds-form-element__static">
                                {{workOrder.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Service territory</span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'serviceTerritory', params: {id: workOrder.serviceTerritoryId }}">{{workOrder.serviceTerritoryName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Location</span>
                            <div class="slds-form-element__static">
                                {{workOrder.locationName}}
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Case</span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'case', params: {id: workOrder.caseId }}"> {{workOrder.caseNumber}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Description</span>
                            <div class="slds-form-element__static">
                                {{workOrder.description__c}}
                            </div>
                        </div>
                    </div>

                </div>

            </div>

              <div v-if="workOrder.serviceAppointments.length > 0">

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                        <h2 class="slds-text-heading_small slds-m-bottom_small">Work orders of the case</h2>
                        <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                            <thead>
                                <tr class="slds-line-height_reset">
                                    <th>Service Appointment ID</th>
                                    <th>Status</th>
                                    <th>Service resource</th>
                                    <th>Scheduled Start Date</th>
                                    <th>Scheduled End Date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-for="row in workOrder.serviceAppointments"
                                    :key="row.id"
                                >
                                <td><router-link :to="{name: 'serviceAppointment', params: {id: row.id }}">{{row.appointmentNumber}}</router-link></td>
                                <td>{{row.status}}</td>
                                <td><router-link :to="{name: 'serviceAppointment', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link></td>
                                <td>{{row.scheduledStartOriginal__c|formatDate}}</td>
                                <td>{{row.scheduledEndOriginal__c|formatDate}}</td>
                                </tr>
                            </tbody>
                        </table>
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
                pageTitle: 'Work Order',
                loading: true,
                workOrder: {
                    serviceAppointments: []
                }
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
                  this.$API.workOrder.getById(this.id)
                    .then(data => {
                        this.loading = false;
                        this.workOrder = data;
                        this.pageTitle = 'Work Order — '+ this.workOrder.workOrderNumber;
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
