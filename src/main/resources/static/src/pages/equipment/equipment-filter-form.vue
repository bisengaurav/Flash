<template>
    <div :class="gridClass">

        <form-element
            :label="$t('filter.equipment.country.label')"
            :class="gridItemClass"
            for="country"
            :validator="$v.innerValue.installationCountry__c"
        >
            <div class="slds-select_container">
                <select-loader
                        :source="$API.equipment.getUniqueCountries"
                        valueParam="value"
                        :allowEmpty="true"
                        v-model="innerValue.installationCountry__c"
                        @blur.native="$v.innerValue.installationCountry__c.$touch()"
                        id="country"
                        class="slds-select"
                />
            </div>
        </form-element>

        <form-element
            :label="$t('filter.equipment.equipment-type.label')"
            :class="gridItemClass"
            for="equipment_type"
            :validator="$v.innerValue.equipmentType__c"
        >
            <div class="slds-select_container">
                <select-loader
                    :source="$API.equipment.getEquipmentTypes"
                    :allowEmpty="true"
                    v-model="innerValue.equipmentType__c"
                    @blur.native="$v.innerValue.equipmentType__c.$touch()"
                    id="equipment_type"
                    class="slds-select"
                />
            </div>
        </form-element>

        <form-element :label="$t('filter.equipment.customer-asset-name.label')" :class="gridItemClass">
            <input
                id="customer_asset_name"
                v-model="innerValue.customerAssetName__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.phone.label')" :class="gridItemClass">
            <input
                id="phone"
                v-model="innerValue.equipmentPhoneNumber__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.equipment.account.label')" :class="gridItemClass">
            <input
                id="account"
                v-model="innerValue.accountName"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.equipment.sold-to.label')" :class="gridItemClass">
            <input
                id="sold_to"
                v-model="innerValue.soldToName"
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
                v-model="innerValue.installationStreet__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.city.label')" :class="gridItemClass">
            <input
                id="сity"
                v-model="innerValue.installationCity__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.asset.state-province.label')" :class="gridItemClass">
            <input
                id="stateProvince"
                v-model="innerValue.installationStateProvince__c"
                class="slds-input"
            />
        </form-element>

        <form-element :label="$t('filter.equipment.valid-contract.label')" :class="gridItemClass">
            <div class="slds-select_container">
                <select-boolean
                    v-model="innerValue.fsmLastValidCliEndDate__c"
                    :allowEmpty="true"
                    id="valid_contract"
                    class="slds-select"
                />
            </div>
        </form-element>

        <form-element :label="$t('filter.asset.sales-org.label')" :class="gridItemClass" for="sales_org">
            <div class="slds-select_container">
                <select-loader
                    :source="$API.equipment.getUniqueSalesOrganizations"
                    :allowEmpty="true"
                    v-model="innerValue.salesOrganization__c"
                    id="sales_org"
                    class="slds-select"
                />
            </div>
        </form-element>

        <div :class="buttonsClass">
            <button class="slds-button slds-button_brand" @click="apply" :disabled="!countOfAppliedFilters || $v.$invalid" v-t="'label.button.apply'"></button>
            <button class="slds-button slds-button_neutral" @click="clearAll" v-t="'label.button.clear-all'"></button>
        </div>
    </div>
</template>

<script>
    import FiltersInterface from '../../components/filters-interface.vue';
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
