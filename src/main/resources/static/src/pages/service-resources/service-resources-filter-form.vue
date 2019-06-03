<template>
    <div :class="gridClass">

        <form-element label="Service Resource" :class="gridItemClass">
            <input
                id="phone"
                v-model="innerValue.name"
                class="slds-input"
            />
        </form-element>

        <form-element label="Phone" :class="gridItemClass">
            <input
                id="phone"
                v-model="innerValue.phone__c"
                class="slds-input"
            />
        </form-element>

        <form-element label="Sales org." :class="gridItemClass" for="sales_org">
            <div class="slds-select_container">
                <select-loader
                    :source="$API.case.getUniqueSalesOrganizations"
                    v-model="innerValue.salesOrganization__c"
                    :allowEmpty="true"
                    id="sales_org"
                    class="slds-select"
                />
            </div>
        </form-element>

        <div :class="buttonsClass">
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
                    name: null,
                    phone__c: null,
                    salesOrganizations__c: null
                }
            }
        }

    }
 </script>
