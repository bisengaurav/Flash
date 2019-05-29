<template>
     <div class="slds-grid slds-gutters_direct slds-grid_vertical-align-end slds-wrap">

          <form-element label="Case ID" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
            <input
                id="case_id"
                v-model="innerValue.caseNumber"
                class="slds-input"
            />
        </form-element>

        <form-element label="Created after" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="created_after"
                v-model="innerValue.createdDate"
                class="slds-input"
            />
        </form-element>

        <form-element label="Due Date after" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="due_date_after"
                v-model="innerValue.npxResponseDueDate__c"
                class="slds-input"
            />
        </form-element>

       <form-element label="Entrapment" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small" for="entrapment">
            <div class="slds-select_container">
                <select
                    id="entrapment"
                    v-model="innerValue.entrapment__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </div>
        </form-element>

        <form-element label="Hazard" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small" for="hazard">
            <div class="slds-select_container">
                <select
                    id="hazard"
                    v-model="innerValue.hazard__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </div>
        </form-element>

        <form-element label="Injury" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small" for="injury">
            <div class="slds-select_container">
                <select
                    id="injury"
                    v-model="innerValue.injury__c"
                    class="slds-select"
                >
                    <option></option>
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </div>
        </form-element>

        <form-element label="Asset" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="asset"
                v-model="innerValue.assetName"
                class="slds-input"
            />
        </form-element>

        <form-element label="Location" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="location"
                v-model="innerValue.locationName"
                class="slds-input"
            />
        </form-element>

        <form-element label="Street" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="street"
                v-model="innerValue.street__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="City" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="city"
                v-model="innerValue.city__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="State / Province" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="state_province"
                v-model="innerValue.stateProvince__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="Contact" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="contact"
                v-model="innerValue.contactName"
                class="slds-input"
            />
        </form-element>

        <form-element label="Caller name" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="caller_name"
                v-model="innerValue.callerName__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="Work order" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="work_order"
                v-model="innerValue.workOrderNumber"
                class="slds-input"
            />
        </form-element>

        <form-element label="Assembly Code" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="assembly_code"
                v-model="innerValue.assemblyNumber__c"
                class="slds-input"
            />
        </form-element>

        <!-- <form-element label="Maintenance Activity Type" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="maintenance_activity_type"
                v-model="innerValue"
                class="slds-input"
            />
        </form-element> -->

        <form-element label="Service appointment" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_appointment"
                v-model="innerValue.appointmentNumber"
                class="slds-input"
            />
        </form-element>

        <form-element label="SA status" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="sa_status"
                v-model="innerValue.serviceAppointmentStatus"
                class="slds-input"
            />
        </form-element>

        <form-element label="Service Resource" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_resource"
                v-model="innerValue.serviceResourceName"
                class="slds-input"
            />
        </form-element>

        <form-element label="Service territory" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_territory"
                v-model="innerValue.serviceTerritoryName"
                class="slds-input"
            />
        </form-element>

        <form-element label="Case Owner" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="case_owner"
                v-model="innerValue.caseOwnerTxt__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="Sales org." class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="sales_org"
                v-model="innerValue.salesOrganization__c"
                class="slds-input"
            />
        </form-element>

        <div class="slds-col slds-size_1-of-1 slds-p-top_small">
            <button class="slds-button slds-button_brand" @click="apply" :disabled="!countOfAppliedFilters">Apply</button>
            <button class="slds-button slds-button_neutral" @click="clearAll">Clear All</button>
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
                    npxResponseDueDate__c: null,
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
                    assemblyNumber__c: null,
                    appointmentNumber: null,
                    serviceAppointmentStatus: null,
                    serviceResourceName: null,
                    serviceTerritoryName: null,
                    caseOwnerTxt__c: null,
                    salesOrganization__c: null,
                }
            }
        }
    }
 </script>
