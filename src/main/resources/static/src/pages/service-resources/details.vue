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
                        <span class="slds-form-element__label" v-t="'field.serviceresource.phone__c.label'"></span>
                        <div class="slds-form-element__static">
                           {{serviceResource.phone__c}}
                        </div>
                    </div>

                    <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                        <span class="slds-form-element__label" v-t="'field.serviceresource.salesorganization__c.label'"></span>
                        <div class="slds-form-element__static">
                           {{serviceResource.salesOrganization__c}}
                        </div>
                    </div>

                </div>
            </div>

            <div>

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.service-resource-territories.heading'"></h2>

                    <div v-if="serviceResource.serviceResourceTerritories.length <= 0" class="slds-p-around_medium">
                        <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-related-record'" />
                    </div>
                        
                    <table v-else class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.serviceresourceterritory.name.label'"></th>
                                <th v-t="'field.serviceresourceterritory.territorytype.label'"></th>
                                <th v-t="'field.serviceresourceterritory.shifttype__c.label'"></th>
                                <th v-t="'field.serviceresourceterritory.effectivestartdate.label'"></th>
                                <th v-t="'field.serviceresourceterritory.effectiveenddate.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in serviceResource.serviceResourceTerritories"
                                :key="row.id"
                            >
                                <td><router-link :to="{name: 'serviceTerritory', params: {id: row.id }}">{{row.name}}</router-link></td>
                                <td>{{row.territoryType}}</td>
                                <td>{{row.shiftType__c}}</td>
                                <td>{{ $dtz(row.effectiveStartDate, 'datetime') }}</td>
                                <td>{{ $dtz(row.effectiveEndDate, 'datetime') }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

            <div>

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.work-centers.heading'"></h2> 
                    
                    <div v-if="serviceResource.serviceResourceWorkCenters.length <= 0" class="slds-p-around_medium">
                        <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-related-record'" />
                    </div>
                        
                    <table v-else class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.serviceresourceworkcenter.name.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in serviceResource.serviceResourceWorkCenters"
                                :key="row.id"
                            >
                                <td><router-link :to="{name: 'workCenter', params: {id: row.id }}">{{row.name}}</router-link></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

            <div>

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.resource-absences.heading'"></h2>
                    
                    <div v-if="serviceResource.resourceAbsences.length <= 0" class="slds-p-around_medium">
                        <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-related-record'" />
                    </div>
                        
                    <table v-else class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.resourceabsence.start.label'"></th>
                                <th v-t="'field.resourceabsence.end.label'"></th>
                                <th v-t="'field.resourceabsence.recordtype__c.label'"></th>
                                <th v-t="'field.resourceabsence.type.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in serviceResource.resourceAbsences"
                                :key="row.id"
                            >
                                <td>{{ $dtz(row.start, 'datetime') }}</td>
                                <td>{{ $dtz(row.end, 'datetime') }}</td>
                                <td>{{row.recordType__c}}</td>
                                <td>{{row.type}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>

            <div>

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_small" v-t="'text.service-resource-appointments.heading'"></h2>

                    <div v-if="serviceResource.serviceResourceAppointments.length <= 0" class="slds-p-around_medium">
                        <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-related-record'" />
                    </div>
                        
                    <table v-else class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.serviceresourceappointment.appointmentnumber.label'"></th>
                                <th v-t="'field.serviceresourceappointment.status.label'"></th>
                                <th v-t="'field.serviceresourceappointment.scheduledstartoriginal__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.scheduledendoriginal__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.fslpinned__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.workordernumber.label'"></th>
                                <th v-t="'field.serviceresourceappointment.earlieststartdate__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.duedate__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.maintenanceactivitytype__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.assembly__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.description__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.locationname.label'"></th>
                                <th v-t="'field.serviceresourceappointment.installationstreet__c.label'"></th>
                                <th v-t="'field.serviceresourceappointment.installationcity__c.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in serviceResource.serviceResourceAppointments"
                                :key="row.id"
                            >
                                 <td><router-link :to="{name: 'serviceAppointment', params: {id: row.id }}">{{row.appointmentNumber}}</router-link></td>
                                <td>{{row.status}}</td>
                                <td>{{ $dtz(row.scheduledStartOriginal__c, 'datetime') }}</td>
                                <td>{{ $dtz(row.scheduledEndOriginal__c, 'datetime') }}</td>
                                <td>{{  row.fslPinned__c |yesNo }}</td>
                                <td><router-link :to="{name: 'workOrder', params: {id: row.workOrderId }}">{{row.workOrderNumber}}</router-link></td>
                                <td>{{ $dtz(row.earliestStartDate__c, 'datetime') }}</td>
                                <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
                                <td>{{row.maintenanceActivityType__c}}</td>
                                <td>{{row.assembly__c}}</td>
                                <td>{{row.description__c}}</td>
                                <td>{{row.locationName}}</td>
                                <td>{{row.installationStreet__c}}</td>
                                <td>{{row.installationCity__c}}</td>
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
                pageTitle: this.$t('text.service-resources.heading'),  
                loading: true,
                serviceResource: {
                    serviceResourceTerritories: [],
                    serviceResourceWorkCenters: [],
                    resourceAbsences: [],
                    serviceResourceAppointments: []
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
                this.$API.serviceResource.getById(this.id)
                .then(data => {
                    this.loading = false;
                    this.serviceResource = data;
                    this.pageTitle =  this.$t('text.service-resources.heading') +' — '+ this.serviceResource.name;
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
