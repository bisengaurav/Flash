<template>
     <div class="slds-grid slds-gutters_direct slds-grid_vertical-align-end slds-wrap">

          <form-element label="Case ID" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
            <input
                id="case_id"
                class="slds-input"
            />
        </form-element>

        <form-element label="Created after" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="created_after"
                class="slds-input"
            />
        </form-element>

        <form-element label="Due Date after" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="due_date_after"
                class="slds-input"
            />
        </form-element>

       <form-element label="Entrapment" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small" for="entrapment">
            <div class="slds-select_container">
                <select
                    id="entrapment"
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
                class="slds-input"
            />
        </form-element>

        <form-element label="Location" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="location"
                class="slds-input"
            />
        </form-element>

        <form-element label="Street" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="street"
                class="slds-input"
            />
        </form-element>

        <form-element label="City" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="city"
                class="slds-input"
            />
        </form-element>

        <form-element label="State / Province" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="state_province"
                class="slds-input"
            />
        </form-element>

        <form-element label="Contact" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="contact"
                class="slds-input"
            />
        </form-element>

        <form-element label="Caller name" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="caller_name"
                class="slds-input"
            />
        </form-element>

        <form-element label="Work order" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="work_order"
                class="slds-input"
            />
        </form-element>

        <form-element label="Assembly Code" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="assembly_code"
                class="slds-input"
            />
        </form-element>

        <form-element label="Maintenance Activity Type" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="maintenance_activity_type"
                class="slds-input"
            />
        </form-element>

        <form-element label="Service appointment" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_appointment"
                class="slds-input"
            />
        </form-element>

        <form-element label="SA status" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="sa_status"
                class="slds-input"
            />
        </form-element>

        <form-element label="Service Resource" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_resource"
                class="slds-input"
            />
        </form-element>

        <form-element label="Service territory" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="service_territory"
                class="slds-input"
            />
        </form-element>

        <form-element label="Case Owner" class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="case_owner"
                class="slds-input"
            />
        </form-element>

        <form-element label="Sales org." class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_small">
             <input
                id="sales_org"
                class="slds-input"
            />
        </form-element>

        <div class="slds-col slds-size_1-of-1 slds-p-top_small">
            <button class="slds-button slds-button_brand" >Apply</button>
            <button class="slds-button slds-button_neutral" >Clear All</button>
        </div>
    </div>
</template>

<script>
    import FiltersInterface from '../../components/filters-interface.vue';

    export default {
        extends: FiltersInterface,

        data() {
            return {
                // metadata: {
                //     installationCountry__c:  null,
                //     equipmentType__c: null,
                //     customerAssetName__c: null,
                //     equipmentPhoneNumber__c: null,
                //     accountName: null,
                //     soldToName: null,
                //     locationName: null,
                //     installationStreet__c: null,
                //     installationCity__c: null,
                //     installationStateProvince__c: null,
                //     fsmLastValidCliEndDate__c: null
                // }
            }
        },

        computed: {
            disableButton: function() {
                return !Object.keys(this.appliedFilters).length;
            }
        }

    }
 </script>
