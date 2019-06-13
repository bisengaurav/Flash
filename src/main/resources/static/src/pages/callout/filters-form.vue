<template>
    <filters-form-layout>
        <template #fields>
            <grid-item>
                <form-element :label="$t('filter.callouts.case-number.label')">
                    <input
                        id="case_id"
                        v-model="innerValue.caseNumber"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.status.label')" for="status">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.callout.getUniqueStatuses"
                            :allowEmpty="true"
                            v-model="innerValue.status"
                            id="status"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.created-after.label')">
                    <input
                        id="created_after"
                        v-model="innerValue.createdDate"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.due-date-after.label')">
                    <input
                        id="due_date_after"
                        v-model="innerValue.dueDate__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.entrapment.label')">
                    <div class="slds-select_container">
                        <select-boolean
                            v-model="innerValue.entrapment__c"
                            :allowEmpty="true"
                            id="entrapment"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t( 'filter.callouts.hazard.label')">
                    <div class="slds-select_container">
                        <select-boolean
                            v-model="innerValue.hazard__c"
                            :allowEmpty="true"
                            id="hazard"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.injury.label')">
                    <div class="slds-select_container">
                        <select-boolean
                            v-model="innerValue.injury__c"
                            :allowEmpty="true"
                            id="injury"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.asset-name.label')">
                    <input
                        id="asset"
                        v-model="innerValue.assetName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.location.label')">
                    <input
                        id="location"
                        v-model="innerValue.locationName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.street.label')">
                    <input
                        id="street"
                        v-model="innerValue.street__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.city.label')">
                    <input
                        id="city"
                        v-model="innerValue.city__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.state-province.label')">
                    <input
                        id="state_province"
                        v-model="innerValue.stateProvince__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.contact.label')">
                    <input
                        id="contact"
                        v-model="innerValue.contactName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.caller-name.label')">
                    <input
                        id="caller_name"
                        v-model="innerValue.callerName__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.work-order.label')">
                    <input
                        id="work_order"
                        v-model="innerValue.workOrderNumber"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.assembly-code.label')" for="assembly_code">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.callout.getUniqueAssemblies"
                            :allowEmpty="true"
                            v-model="innerValue.assembly__c"
                            id="assembly_code"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.maintenance-activity-type.label')" for="maintenance_activity_type">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.callout.getUniqueMaintenanceActivityTypeCodes"
                            :allowEmpty="true"
                            v-model="innerValue.maintenanceActivityTypeCode__c"
                            id="maintenance_activity_type"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.service-appointment.label')">
                    <input
                        id="service_appointment"
                        v-model="innerValue.appointmentNumber"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.sa-status.label')" for="sa_status">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.serviceAppointment.getUniqueStatuses"
                            :allowEmpty="true"
                            v-model="innerValue.serviceAppointmentStatus"
                            id="sa_status"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.service-resource.label')">
                    <input
                        id="service_resource"
                        v-model="innerValue.serviceResourceName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.service-territory.label')">
                    <input
                        id="service_territory"
                        v-model="innerValue.serviceTerritoryName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.callouts.case-owner.label')">
                    <input
                        id="case_owner"
                        v-model="innerValue.caseOwnerTxt__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element
                    :label="$t('filter.callouts.sales-organization.label')"
                    for="sales_org"
                    :validator="$v.innerValue.salesOrganization__c"
                >
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.callout.getUniqueSalesOrganizations"
                            :allowEmpty="true"
                            v-model="innerValue.salesOrganization__c"
                            @blur.native="$v.innerValue.salesOrganization__c.$touch()"
                            id="sales_org"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>
        </template>


        <template #buttons>
            <button class="slds-button slds-button_brand" @click="apply" :disabled="$v.$invalid || countOfAppliedFilters < 2" v-t="'label.button.apply'"></button>
            <button class="slds-button slds-button_neutral" @click="clearAll" v-t="'label.button.clear-all'"></button>
        </template>
    </filters-form-layout>
</template>

<script>
    import FiltersInterface from '../../interfaces/filters.js';
    import SelectBoolean from '../../components/select-boolean.vue';
    import {required} from 'vuelidate/lib/validators';

    export default {
        extends: FiltersInterface,

        components: {
            SelectBoolean
        },

        data() {
            return {
                metadata: {
                    caseNumber:  null,
                    status: null,
                    createdDate: null,
                    dueDate__c: null,
                    entrapment__c: null,
                    hazard__c: null,
                    injury__c: null,
                    assetName: null,
                    locationName: null,
                    street__c: null,
                    city__c: null,
                    stateProvince__c: null,
                    contactName: null,
                    callerName__c: null,
                    workOrderNumber: null,
                    assembly__c: null,
                    maintenanceActivityTypeCode__c: null,
                    appointmentNumber: null,
                    serviceAppointmentStatus: null,
                    serviceResourceName: null,
                    serviceTerritoryName: null,
                    caseOwnerTxt__c: null,
                    salesOrganization__c: null,
                }
            }
        },

        //
        // VALIDATION
        //
        validations: {
            innerValue: {
                salesOrganization__c: {
                    required
                }
            }
        }

    }
 </script>
