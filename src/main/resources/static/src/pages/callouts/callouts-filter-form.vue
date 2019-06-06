<template>
     <div :class="gridClass">

          <form-element :label="$t('filter.case.case-id.label')" :class="gridItemClass">
            <input
                id="case_id"
                v-model="innerValue.caseNumber"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.created-after.label')" :class="gridItemClass">
             <input
                id="created_after"
                v-model="innerValue.createdDate"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.due-date-after.label')" :class="gridItemClass">
             <input
                id="due_date_after"
                v-model="innerValue.dueDate__c"
                class="slds-input"
            />
        </form-element>

       <form-element :label="$t('filter.case.entrapment.label')" :class="gridItemClass" for="entrapment">
            <div class="slds-select_container">
                <select
                    id="entrapment"
                    v-model="innerValue.entrapment__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">{{ $t('label.common.yes') }}</option>
                    <option value="false">{{ $t('label.common.no') }}</option>
                </select>
            </div>
        </form-element>

        <form-element :label="$t( 'filter.case.hazard.label')" :class="gridItemClass" for="hazard">
            <div class="slds-select_container">
                <select
                    id="hazard"
                    v-model="innerValue.hazard__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">{{ $t('label.common.yes') }}</option>
                    <option value="false">{{ $t('label.common.no') }}</option>
                </select>
            </div>
        </form-element>

        <form-element :label="$t('filter.case.Injury.label')" :class="gridItemClass" for="injury">
            <div class="slds-select_container">
                <select
                    id="injury"
                    v-model="innerValue.injury__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">{{ $t('label.common.yes') }}</option>
                    <option value="false">{{ $t('label.common.no') }}</option>
                </select>
            </div>
        </form-element>

        <form-element :label="$t('filter.case.Injury.label')" :class="gridItemClass">
             <input
                id="asset"
                v-model="innerValue.assetName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.location.label')" :class="gridItemClass"> 
             <input
                id="location"
                v-model="innerValue.locationName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.street.label')" :class="gridItemClass">
             <input
                id="street"
                v-model="innerValue.street__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.city.label')" :class="gridItemClass">
             <input
                id="city"
                v-model="innerValue.city__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.state-province.label')" :class="gridItemClass">
             <input
                id="state_province"
                v-model="innerValue.stateProvince__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.contact.label')" :class="gridItemClass"> 
             <input
                id="contact"
                v-model="innerValue.contactName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.caller-name.label')" :class="gridItemClass">
             <input
                id="caller_name"
                v-model="innerValue.callerName__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.caller-name.label')" :class="gridItemClass"> 
             <input
                id="work_order"
                v-model="innerValue.workOrderNumber"
                class="slds-input"
            />
        </form-element>

         <form-element :label="$t('filter.case.assembly-code.label')" :class="gridItemClass" for="assembly_code">
            <div class="slds-select_container">
                <select-loader
                    :source="$API.case.getUniqueAssemblies"
                    :allowEmpty="true"
                    v-model="innerValue.assembly__c"
                    id="assembly_code"
                    class="slds-select"
                />
            </div>
        </form-element>

        <form-element :label="$t('filter.case.maintenance-activity-type.label')" :class="gridItemClass" for="maintenance_activity_type">
            <div class="slds-select_container">
                <select-loader
                    :source="$API.case.getUniqueMaintenanceActivityTypeCodes"
                    :allowEmpty="true"
                    v-model="innerValue.maintenanceActivityTypeCode__c"
                    id="maintenance_activity_type"
                    class="slds-select"
                />
            </div>
        </form-element>

        <form-element :label="$t('filter.case.service-appointment.label')" :class="gridItemClass">
             <input
                id="service_appointment"
                v-model="innerValue.appointmentNumber"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.sa-status.label')" :class="gridItemClass" for="sa_status"> 
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

        <form-element :label="$t('filter.asset.service-resource.label')" :class="gridItemClass">
             <input
                id="service_resource"
                v-model="innerValue.serviceResourceName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.service-territory.label')" :class="gridItemClass">
             <input
                id="service_territory"
                v-model="innerValue.serviceTerritoryName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.case.case-owner.label')" :class="gridItemClass"> 
             <input
                id="case_owner"
                v-model="innerValue.caseOwnerTxt__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.sales-org.label')" :class="gridItemClass" for="sales_org">
            <div class="slds-select_container">
                <select-loader
                    :source="$API.case.getUniqueSalesOrganizations"
                    :allowEmpty="true"
                    v-model="innerValue.salesOrganizations__c"
                    id="sales_org"
                    class="slds-select"
                />
            </div>
        </form-element>

        <div :class="buttonsClass">
            <button class="slds-button slds-button_brand" @click="apply" :disabled="!countOfAppliedFilters" v-t="'label.button.apply'"></button>
            <button class="slds-button slds-button_neutral" @click="clearAll" v-t="'label.button.clear-all'"></button>
        </div>
    </div>
</template>

<script>
    import FiltersInterface from '../../components/filters-interface.vue';

    export default {
        extends: FiltersInterface,

        data() {
            return {
                metadata: {
                    caseNumber:  null,
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
                    salesOrganizations__c: null,
                }
            }
        }
    }
 </script>
