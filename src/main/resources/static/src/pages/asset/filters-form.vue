<template>
    <filters-form-layout>
        <template #fields>
            <grid-item>
                <form-element
                    :label="$t('filter.assets.type.label')"
                    for="equipment_type"
                    :validator="$v.innerValue.equipmentType__c"
                >
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.asset.getEquipmentTypes"
                            :allowEmpty="true"
                            v-model="innerValue.equipmentType__c"
                            @blur.native="$v.innerValue.equipmentType__c.$touch()"
                            id="equipment_type"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.customer-asset-name.label')">
                    <input
                        id="customer_asset_name"
                        v-model="innerValue.customerAssetName__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.equipment-id.label')">
                    <input
                        id="customer_asset_name"
                        v-model="innerValue.name"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.location.label')">
                    <input
                        id="location"
                        v-model="innerValue.locationName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.street.label')">
                    <input
                        id="street"
                        v-model="innerValue.installationStreet__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.city.label')">
                    <input
                        id="сity"
                        v-model="innerValue.installationCity__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.state-province.label')">
                    <input
                        id="stateProvince"
                        v-model="innerValue.installationStateProvince__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element
                    :label="$t('filter.assets.country.label')"
                    for="country"
                    :validator="$v.innerValue.installationCountry__c"
                >
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.asset.getUniqueCountries"
                            valueParam="value"
                            :allowEmpty="true"
                            v-model="innerValue.installationCountry__c"
                            @blur.native="$v.innerValue.installationCountry__c.$touch()"
                            id="country"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.account.label')">
                    <input
                        id="account"
                        v-model="innerValue.accountName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.sold-to.label')">
                    <input
                        id="sold_to"
                        v-model="innerValue.soldToName"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.phone.label')">
                    <input
                        id="phone"
                        v-model="innerValue.equipmentPhoneNumber__c"
                        class="slds-input"
                    />
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.valid-contract.label')">
                    <div class="slds-select_container">
                        <select-boolean
                            v-model="innerValue.fsmLastValidCliEndDate__c"
                            :allowEmpty="true"
                            id="valid_contract"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>

            <grid-item>
                <form-element :label="$t('filter.assets.sales-organization.label')" for="sales_org">
                    <div class="slds-select_container">
                        <select-loader
                            :source="$API.asset.getUniqueSalesOrganizations"
                            :allowEmpty="false"
                            v-model="innerValue.salesOrganization__c"
                            id="sales_org"
                            class="slds-select"
                        />
                    </div>
                </form-element>
            </grid-item>
        </template>


        <template #buttons>
            <button class="slds-button slds-button_brand" @click="apply" :disabled="!countOfAppliedFilters || $v.$invalid" v-t="'label.button.apply'"></button>
            <button class="slds-button slds-button_neutral" @click="clearAll" v-t="'label.button.clear-all'"></button>
        </template>
    </filters-form-layout>
</template>

<script>
    import FiltersInterface from '../../interfaces/filters.js';
    import {required} from 'vuelidate/lib/validators';
    import SelectBoolean from '../../components/select-boolean.vue';

    export default {
        extends: FiltersInterface,

        components: {
            SelectBoolean
        },

        data() {
            return {
                metadata: {
                    installationCountry__c:  null,
                    equipmentType__c: null,
                    customerAssetName__c: null,
                    equipmentPhoneNumber__c: null,
                    accountName: null,
                    soldToName: null,
                    locationName: null,
                    installationStreet__c: null,
                    installationCity__c: null,
                    installationStateProvince__c: null,
                    fsmLastValidCliEndDate__c: null,
                    salesOrganization__c: null,
                    name: null
                }

            }
        },

        //
        // VALIDATION
        //
        validations: {
            innerValue: {
                installationCountry__c: {
                    required
                },
                equipmentType__c: {
                    required
                }
            }
        }
    }
 </script>
