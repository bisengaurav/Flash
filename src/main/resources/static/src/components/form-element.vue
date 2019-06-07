<template>
    <div class="slds-form-element" :class="{'slds-has-error': (validator && validator.$error)}">
        <div v-if="label" class="slds-form-element__label">
            <abbr v-if="required" class="slds-required" :title="$t('label.common.required')">* </abbr>
            <label :for="id">
                {{label}}
            </label>
            <help-pointer v-if="tooltip" :content="tooltip" class="slds-m-left_xx-small" />
        </div>

        <div class="slds-form-element__control">
            <slot></slot>
        </div>


        <slot name="help"></slot>

        <div v-for="errorMessage in errors" class="slds-form-element__help">{{errorMessage}}</div>
        <slot name="errors"></slot>
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            for: {
                type: String,
                default: null
            },
            label: {
                type: String,
                default: ''
            },
            tooltip: {
                type: String,
                default: ''
            },
            validator: null
        },
        data() {
            return  {
                id: this.$props.for,
                required: false,
                errors: [],
                messages: {
                    required: this.$t('message.validation.required'),
                    requiredIf: this.$t('message.validation.required'),
                    requiredUnless: this.$t('message.validation.required'),

                    minLength: ({min}) => this.$t('message.validation.minLength.vue', {min}),
                    maxLength: ({max}) => this.$t('message.validation.maxLength.vue', {max}),
                    minValue: ({min}) => this.$t('message.validation.minValue.vue', {min}),
                    maxValue: ({max}) => this.$t('message.validation.maxValue.vue', {max}),

                    between: ({min, max}) => this.$t('message.validation.between.vue', {min, max}),

                    alpha: this.$t('message.validation.alpha'),
                    alphaNum: this.$t('message.validation.alphaNum'),
                    numeric: this.$t('message.validation.numeric'),
                    integer: this.$t('message.validation.integer'),
                    decimal: this.$t('message.validation.decimal'),
                    email: this.$t('message.validation.email'),
                    macAddress: this.$t('message.validation.macAddress'),
                    ipAddress: this.$t('message.validation.ipAddress'),
                    url: this.$t('message.validation.url')
                }
            };
        },

        //
        // METHODS
        //
        methods: {
            processRequired() {
                let v = this.validator;

                Object.entries(v.$params).some(([name, p]) => {
                    if (p.type == 'required') {
                        this.required = true;
                        return true;
                    }
                });
            },
            processErrors() {
                let v = this.validator;

                if (v.$error) {
                    let errors = [];
                    Object.keys(v.$params).forEach(name => {
                        if (!v[name]) {
                            let p = v.$params[name],
                                message = this.messages[p.type];

                            if (typeof message === 'string') {
                                errors.push(message);
                            } else {
                                errors.push(
                                    message(
                                        this.getValidatorParams(p)
                                    )
                                );
                            }
                        }
                    });
                    this.errors = errors;

                } else {
                    this.errors = [];
                }
            },
            getValidatorParams(v) {
                let params = {};
                Object.keys(v).forEach(k => {
                    if (k != 'type')
                        params[k] = v[k];
                });
                return params;
            },
            findControlIdRecursive(el) {
                if (el.tag == 'input' || el.tag == 'select' || el.tag == 'textarea') {
                    this.id = el.elm.id || null;
                    return true;
                } else {
                    if (el.children) {
                        return el.children.some(child => {
                            return this.findControlIdRecursive(child);
                        });
                    } else {
                        return false;
                    }
                }
            }
        },

        //
        // EVENTS
        //
        mounted() {
            // recursively search input/select/textarea control and his id attr
            if (!this.$props.for) {
                this.$slots.default.some(child => {
                    return this.findControlIdRecursive(child);
                });
            }

            // apply watcher to validator if exist
            if (this.validator) {
                // look required status based on passed validator
                this.processRequired();

                // apply watcher to validator if exist
                this.$watch(
                    'validator',
                    () => {
                        this.processErrors();
                    },
                    {
                        deep: true,
                        immediate: true
                    }
                );
            }
        }
    }
</script>
