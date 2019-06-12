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
                <span class="slds-checkbox_on">{{innerOnLabel}}</span>
                <span class="slds-checkbox_off">{{innerOffLabel}}</span>
            </span>
        </label>
    </div>
</template>

<script>
    import Checkbox from './checkbox.vue';

    export default {
        extends: Checkbox,

        //
        // PARAMS: props, data, computed
        //
        props: {
            onLabel: {
                type: String
            },
            offLabel: {
                type: String
            }
        },
        computed: {
            innerOnLabel() {
                return this.$props.onLabel || this.$t('label.checkbox.on');
            },
            innerOffLabel() {
                return this.$props.offLabel || this.$t('label.checkbox.off');
            }
        }

    }
</script>
