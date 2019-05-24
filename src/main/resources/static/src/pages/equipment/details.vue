<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button to="equipment" class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>
             <div class="slds-col slds-size_1-of-1">

                <div class="slds-card slds-p-around_medium">
                     <!-- slds-p-bottom_mediumslds-border_bottom -->
                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Equipment type</span>
                            <div class="slds-form-element__static">
                                {{equipment.equipmentType__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Valid contract</span>
                            <div class="slds-form-element__static">
                                {{ equipment.fsmLastValidCliEndDate__c ? 'Yes' : '' }} {{ equipment.fsmLastValidCliEndDate__c === false ? 'No' : '' }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Customer asset name</span>
                            <div class="slds-form-element__static">
                                {{equipment.customerAssetName__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Account ID</span>
                            <div class="slds-form-element__static">
                                {{equipment.accountId}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Account name</span>
                            <div class="slds-form-element__static">
                                {{equipment.accountName}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Sold-to ID</span>
                            <div class="slds-form-element__static">
                                {{equipment.soldToId}}
                            </div>
                        </div>
                    </div>
                    <div class="slds-grid slds-wrap slds-grid_pull-padded">
                         <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Sold-to name</span>
                            <div class="slds-form-element__static">
                                {{equipment.soldToName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">City</span>
                            <div class="slds-form-element__static">
                                {{equipment.installationCity__c}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Country</span>
                            <div class="slds-form-element__static">
                                {{equipment.installationCountry__c}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Location</span>
                            <div class="slds-form-element__static">
                                {{equipment.locationName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Service territory</span>
                            <div class="slds-form-element__static">
                                {{equipment.serviceTerritoryName}}
                            </div>
                        </div>   
                    </div>

                </div>

            </div>

            <div class="primary-section">

                    <table v-if="equipment.activeSLAs.length > 0" class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th>SLA</th>
                                <th>Coverage</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Status</th>
                                <th>Response Time</th>
                                <th>Response Time After Hours</th>
                                <th>Callout Hours</th>
                                <th>Service Hours</th>           
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in equipment.activeSLAs"
                                :key="row.id"
                            >
                               <td>{{row.name}}</td>
                               <td>{{row.coverage__c}}</td>
                               <td>{{row.startdate|formatDate}}</td>
                               <td>{{row.enddate|formatDate}}</td>
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
                pageTitle: 'Equipment Record Detail',
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
                console.log('init');

                if (!this.id) {
                    throw new Error('Wrong ID');
                }

                // data
                // data
                this.$API.equipment.getById(this.id)
                    .then(data => {
                       
                        console.log(data);
                        this.equipment = data;
                        this.loading = false;
                        // run auto refresh
                        if (this.autoRefreshOn) this.initAutoRefresh();
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
