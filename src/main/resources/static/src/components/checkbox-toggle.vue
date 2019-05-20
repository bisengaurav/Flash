<template>
    <div class="slds-form-element">
        <label class="slds-checkbox_toggle slds-grid" :for="'checkbox_'+_uid">
            <span class="slds-form-element__label slds-m-bottom_none">
                {{label}}
                <help-pointer v-if="tooltip" :content="tooltip" class="slds-m-left_xx-small" />
            </span>
            <input
                type="checkbox"
                v-model="innerValue"
                :id="'checkbox_'+_uid"
                @change="$emit('change', $event)"
                @focus="$emit('focus', $event)"
                @blur="$emit('blur', $event)"
            />

            <span class="slds-checkbox_faux_container">
                <span class="slds-checkbox_faux"></span>
                <span class="slds-checkbox_on">{{onLabel}}</span>
                <span class="slds-checkbox_off">{{offLabel}}</span>
            </span>
        </label>
    </div>
</template>

<script>
    import Checkbox from './checkbox.vue';

    export default {
        extends: Checkbox,

        //
        // PARAMS: porps, data, computed
        //
        props: {
            onLabel: {
                type: String,
                default: 'On'
            },
            offLabel: {
                type: String,
                default: 'Off'
            }
        }
    }
</script>
