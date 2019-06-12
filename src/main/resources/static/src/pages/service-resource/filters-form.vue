<template>
    <filters-form-layout>
        <template #fields>
            <grid-item>
                <form-element :label="$t('filter.service-resources.name.label')">
                    <input
                        id="name"
                        v-model="innerValue.name"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.service-resources.phone.label')">
                    <input
                        id="phone"
                        v-model="innerValue.phone__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.service-resources.sales-organization.label')" for="sales_org">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.serviceResource.getUniqueSalesOrganizations"
                            v-model="innerValue.salesOrganization__c"
                            :allowEmpty="true"
                            id="sales_org"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>
        </template>


        <template #buttons>
            <button class="slds-button slds-button_brand" @click="apply" :disabled="!countOfAppliedFilters" v-t="'label.button.apply'"></button>
            <button class="slds-button slds-button_neutral" @click="clearAll" v-t="'label.button.clear-all'"></button>
        </template>
    </filters-form-layout>
</template>

<script>
    import FiltersInterface from '../../interfaces/filters.js';

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
