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

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t=" 'field.workorder.status.label'"></span>
                            <div class="slds-form-element__static">
                                {{workOrder.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.lastmodifieddate.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(workOrder.lastModifiedDate, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.earlieststartdate__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(workOrder.earliestStartDate__c, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.duedate__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ $dtz(workOrder.dueDate__c, 'datetime') }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.assembly__c.label'"></span>
                            <div class="slds-form-element__static">
                               {{workOrder.assembly__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.accountname.label'"></span>
                            <div class="slds-form-element__static">
                                {{workOrder.accountName}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">


                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.assetname.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: '', params: {id: workOrder.assetId }}">{{workOrder.assetName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.accountid.label'"></span>
                            <div class="slds-form-element__static">
                                {{workOrder.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.serviceterritoryname.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'serviceTerritory', params: {id: workOrder.serviceTerritoryId }}">{{workOrder.serviceTerritoryName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.asset.locationname.label'"></span>
                            <div class="slds-form-element__static">
                                {{workOrder.locationName}}
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.casenumber.label'"></span>
                            <div class="slds-form-element__static">
                                <router-link :to="{name: 'case', params: {id: workOrder.caseId }}"> {{workOrder.caseNumber}}</router-link>
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.workorder.description__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{workOrder.description__c}}
                            </div>
                        </div>
                    </div>

                </div>

            </div>

              <div v-if="workOrder.serviceAppointments.length > 0">

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                        <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.work-order-service-appointments.heading'"></h2>
                        <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                            <thead>
                                <tr class="slds-line-height_reset">
                                    <th v-t="'field.workorder.serviceappointments.appointmentnumber.label'"></th>
                                    <th v-t="'field.workorder.serviceappointments.status.label'"></th>
                                    <th v-t="'field.workorder.serviceappointments.serviceresourcename.label'"></th>
                                    <th v-t="'field.workorder.serviceappointments.scheduledstartoriginal__c.label'"></th>
                                    <th v-t="'field.workorder.serviceappointments.scheduledendoriginal__c.label'"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-for="row in workOrder.serviceAppointments"
                                    :key="row.id"
                                >
                                    <td><router-link :to="{name: 'serviceAppointment', params: {id: row.id }}">{{row.appointmentNumber}}</router-link></td>
                                    <td>{{row.status}}</td>
                                    <td><router-link :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link></td>
                                    <td>{{ $dtz(row.scheduledStartOriginal__c, 'datetime') }}</td>
                                    <td>{{ $dtz(row.scheduledEndOriginal__c, 'datetime') }}</td>
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
                pageTitle: this.$t('text.work-order.heading'),  
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
                        this.pageTitle = this.$t('text.work-order.heading') +' — '+ this.workOrder.workOrderNumber;
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
