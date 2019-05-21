<template>
       <div class="slds-grid slds-grid_vertical-align-end slds-wrap">

            <form-element label="Country" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    v-model="value.country"
                    id="country"
                    class="slds-input"
                />
            </form-element>
   
             <form-element label="Equipment Type" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6" for="equipment_type">
                <div class="slds-select_container">
                    <select-loader
                        :source="list.equipment"
                        valueParam="name"
                        :allowEmpty="true"
                        v-model="value.equipment"
                        id="equipment_type"
                        class="slds-select"
                    />
                </div>
            </form-element>

            <form-element label="Customer Asset Name" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="customer_asset_name"
                    v-model="value.customerAssetName"
                    class="slds-input"
                />
            </form-element>

             <form-element label="Phone" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="phone"
                    v-model="value.phone"
                    class="slds-input"
                />
            </form-element>

            <form-element label="Account" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="account"
                    v-model="value.account"
                    class="slds-input"
                />
            </form-element>

            <form-element label="Sold to" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="sold_to"
                    v-model="value.soldTo"
                    class="slds-input"
                />
            </form-element>

            <form-element label="Location" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="location"
                    v-model="value.location"
                    class="slds-input"
                />
            </form-element>

            <form-element label="Street" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="street"
                    v-model="value.street"
                    class="slds-input"
                />
            </form-element>

            <form-element label="City" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="сity"
                    v-model="value.сity"
                    class="slds-input"
                />
            </form-element>

            <form-element label="State/Province" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6">
                <input
                    id="stateProvince"
                    v-model="value.stateProvince"
                    class="slds-input"
                />
            </form-element>

            <form-element label="Valid Contract" class="slds-p-right_small slds-size_1-of-1 slds-small-size_1-of-2 slds-medium-size_1-of-3  slds-large-size_1-of-6" for="valid_contract">
                <div class="slds-select_container">
                    <select-loader
                        :source="list.valid"
                        valueParam="name"
                        :allowEmpty="true"
                         v-model="value.validContract"
                        id="valid_contract"
                        class="slds-select"
                    />
                </div>
            </form-element>

            <div class="slds-size_1-of-1">
                <button class="slds-button slds-button_neutral slds-text-nowrap slds-m-top_large">Apply</button>
            </div>
    </div>
</template>

<script>

    export default {

         props: {
            value: {
                type: Object,
                default: null
            }
        },

        data() {
            return {
              
                list: {
                        equipment: [{"label":"Autowalk","name":"Autowalk"},{"label":"Building","name":"Building"},{"label":"Building Door","name":"Building Door"},{"label":"Dumbwaiter","name":"Dumbwaiter"},{"label":"Elevator","name":"Elevator"},{"label":"Escalator","name":"Escalator"},{"label":"Façadator","name":"Façadator"},{"label":"Marine Elevator","name":"Marine Elevator"},{"label":"Marine Escalator","name":"Marine Escalator"},{"label":"Marine Other Eq.","name":"Marine Other Eq."},{"label":"Other","name":"Other"},{"label":"PFI","name":"PFI"},{"label":"Stairlift","name":"Stairlift"},{"label":"Test","name":"Test"}],
                        valid:     [{"label":"yes","name":"yes"},{"label":"no","name":"no"}]
                },
            }
        },
    }
 </script>