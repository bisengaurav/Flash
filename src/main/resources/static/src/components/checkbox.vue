<template>
    <div class="slds-form-element">
        <div class="slds-form-element__control">
            <div class="slds-checkbox">
                <input
                    type="checkbox"
                    v-model="innerValue"
                    :id="'checkbox_'+_uid"
                    @change="$emit('change', $event)"
                    @focus="$emit('focus', $event)"
                    @blur="$emit('blur', $event)"
                />
                <label class="slds-checkbox__label" :for="'checkbox_'+_uid">
                    <span class="slds-checkbox_faux"></span>
                    {{ label }}
                    <help-pointer v-if="tooltip" :content="tooltip" class="slds-m-left_xx-small" />
                </label>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            label: {
                type: String,
                default: ''
            },
            value: {
                type: Boolean,
                default: false
            },
            tooltip: {
                type: String,
                default: ''
            }
        },
        data() {
            return  {
                innerValue: this.$props.value
            };
        },

        //
        // WATCHERS
        //
        watch: {
            innerValue: function() {
                this.$emit('input', this.innerValue);
            },
            value: function(val, oldVal) {
                this.innerValue = val;
            }
        }
    }
</script>
