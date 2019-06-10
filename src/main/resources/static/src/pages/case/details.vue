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
                        <!-- <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Case title</span>
                            <div class="slds-form-element__static">
                                {{caseData.caseOwnerTxt__c}}
                            </div>
                        </div> -->

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.status.label'"></span>
                            <div class="slds-form-element__static">
                                {{caseData.status}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.caseownertxt__c.label'"></span>
                            <div class="slds-form-element__static" >
                                {{caseData.caseOwnerTxt__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.createddate.label'"></span>
                            <div class="slds-form-element__static">
                                 {{ $dtz(caseData.createdDate, 'datetime')}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.entrapment__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ caseData.entrapment__c |yesNo }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.hazard__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ caseData.hazard__c |yesNo }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.injury__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{ caseData.injury__c |yesNo }}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">


                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.assetname.label'"></span>
                            <div class="slds-form-element__static">
                               <router-link :to="{name: 'equipmentDetails', params: {id: caseData.assetId }}">{{caseData.assetName}}</router-link>
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.accountid.label'"></span>
                            <div class="slds-form-element__static">
                                {{caseData.accountId}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.accountname.label'"></span>
                            <div class="slds-form-element__static">
                                 {{caseData.accountName}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.contactname.label'"></span>
                            <div class="slds-form-element__static">
                                 {{caseData.contactName}}
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.contactphone.label'"></span>
                            <div class="slds-form-element__static">
                                 {{caseData.contactPhone}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t=" 'field.case.callername__c.label'"></span>
                            <div class="slds-form-element__static">
                               {{caseData.callerName__c}}
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded">

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.callerphonenumber__c.label'"></span>
                            <div class="slds-form-element__static">
                               {{caseData.callerPhoneNumber__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.fsmcontactIspassenger__c.label'"></span>
                            <div class="slds-form-element__static">
                                 {{ caseData.fsmContactIsPassenger__c |yesNo }}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.salesorganization__c.label'"></span>
                            <div class="slds-form-element__static">
                                {{caseData.salesOrganizations__c}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.subject.label'"></span>
                            <div class="slds-form-element__static">
                                {{caseData.subject}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.case.description.label'"></span>
                            <div class="slds-form-element__static">
                                {{caseData.description}}
                            </div>
                        </div>

                    </div>
                </div>

            </div>

             <div>

                <div class="slds-card slds-p-around_medium slds-m-top_medium">
                        <h2 class="slds-text-heading_small slds-m-bottom_small"  v-t="'text.case-work-orders.heading'"></h2>

                        <div v-if="caseData.workOrders.length <= 0" class="slds-p-around_medium">
                            <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-related-record'" />
                        </div>
                        
                        <table v-else class="slds-table slds-table_cell-buffer slds-table_bordered">
                            <thead>
                                <tr class="slds-line-height_reset">
                                    <th v-t="'field.workorder.workordernumber.label'"></th>
                                    <th v-t="'field.workorder.status.label'"></th>
                                    <th v-t="'field.workorder.earlieststartdate__c.label'"></th>
                                    <th v-t="'field.workorder.duedate__c.label'"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-for="row in caseData.workOrders"
                                    :key="row.id"
                                >
                                <td><router-link :to="{name: 'workOrder', params: {id: row.id }}">{{row.workOrderNumber}}</router-link></td>
                                <td>{{row.status}}</td>
                                <td>{{ $dtz(row.earliestStartDate__c, 'datetime') }}</td>
                                <td>{{ $dtz(row.dueDate__c, 'datetime') }}</td>
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
                pageTitle: this.$t('text.case.heading'),
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
                        this.pageTitle =  this.$t('text.case.heading') +' — '+ this.caseData.caseNumber;
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
