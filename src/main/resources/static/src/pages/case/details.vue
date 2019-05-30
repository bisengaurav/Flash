<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button to="callouts" class="slds-m-right_medium" />
            {{pageTitle}} - {{caseData.caseNumber}}
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
                                {{caseData.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Owner</span>
                            <div class="slds-form-element__static">
                                {{caseData.caseOwnerTxt__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Created in FSM</span>
                            <div class="slds-form-element__static">
                                 {{caseData.caseOwnerTxt__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Entrapment</span>
                            <div class="slds-form-element__static">
                               {{ caseData.entrapment__c ? 'Yes' : '' }} {{ caseData.entrapment__c === false ? 'No' : '' }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Hazard</span>
                            <div class="slds-form-element__static">
                               {{ caseData.hazard__c ? 'Yes' : '' }} {{ caseData.hazard__c === false ? 'No' : '' }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Injury</span>
                            <div class="slds-form-element__static">
                                {{ caseData.injury__c ? 'Yes' : '' }} {{ caseData.injury__c === false ? 'No' : '' }}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                         

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Asset</span>
                            <div class="slds-form-element__static">
                               <router-link :to="{name: '', params: {id: caseData.assetId }}">{{caseData.assetName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account ID</span>
                            <div class="slds-form-element__static">
                                {{caseData.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account name</span>
                            <div class="slds-form-element__static">
                                 {{caseData.accountName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Contact</span>
                            <div class="slds-form-element__static">
                                 {{caseData.contactName}}
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Contact phone</span>
                            <div class="slds-form-element__static">
                                 {{caseData.contactPhone}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Caller name</span>
                            <div class="slds-form-element__static">
                               {{caseData.callerName__c}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded">

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Caller phone</span>
                            <div class="slds-form-element__static">
                               {{caseData.callerPhoneNumber__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Passenger</span>
                            <div class="slds-form-element__static">
                                 {{ caseData.fsmContactIsPassenger__c ? 'Yes' : '' }} {{ caseData.fsmContactIsPassenger__c === false ? 'No' : '' }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Sales organization</span>
                            <div class="slds-form-element__static">
                                {{caseData.salesOrganization__c}}
                            </div>
                        </div>

                        
                    </div>
                </div>

            </div>

             <div v-if="caseData.workOrders.length > 0">
                
                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                        <h2 class="slds-text-heading_small slds-m-bottom_small">Work orders of the case</h2>
                        <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                            <thead>
                                <tr class="slds-line-height_reset">
                                    <th>Work order ID</th>
                                    <th>Status</th>
                                    <th>Earliest Start Date</th>
                                    <th>Due Date</th>         
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-for="row in caseData.workOrders"
                                    :key="row.id"
                                >
                                <td><router-link :to="{name: 'workOrder', params: {id: row.id }}">{{row.workOrderNumber}}</router-link></td>
                                <td>{{row.status}}</td>
                                <td>{{row.earliestStartDate__c|formatDate}}</td>
                                <td>{{row.dueDate__c|formatDate}}</td>
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
                pageTitle: 'Case Record Detail',
                loading: true,
                caseData: {}
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
                  this.$API.case.getById(this.id)
                    .then(data => {                    
                        this.loading = false;
                        this.caseData = data;
                        console.log(data);
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
