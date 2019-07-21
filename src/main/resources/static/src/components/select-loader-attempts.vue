<template>
    <loader v-if="loading" type="input" />
    <select
        v-else-if="loadedSuccessful"
        v-model="innerValue"
        class="slds-select"
    >
        <option v-if="allowEmpty" :value="null">{{emptyLabel}}</option>
        <option v-for="o in options" :value="o.value">{{o.label}}</option>
    </select>
    <input
        v-else
        v-model="innerValue"
        class="slds-input"
    >
    </input>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            value: {
                type: String
            },
            source: {
                default: null
            },
            valueParam: {
                default: 'value'
            },
            labelParam: {
                default: 'label'
            },
            allowEmpty: {
                type: Boolean,
                default: false
            },
            autoApplyFirstOption: {
                type: Boolean,
                default: false
            },
            emptyLabel: '',
            attempts: {
                type: Number,
                default: 2
            }
        },
        data() {
            return  {
                innerValue: this.$props.value,
                innerSource: this.$props.source,
                options: [],
                loading: true,
                loadedSuccessful: false,
                attemptsCounter: 0
            };
        },

        //
        // METHODS
        //
        methods: {
            init() {
                // empty source
                if (!this.innerSource) {
                    throw new Error('Invalid "source" parameter');
                }

                // process Source as Promise function
                if (typeof this.innerSource === 'function') {
                    this.attempt();
                }

                // process Source as simple Array
                else if (Array.isArray(this.innerSource)) {
                    this.processOptions(this.innerSource);
                    this.loading = false;
                }
                // unsupported type
                else {
                    throw new Error('Unsupported type of "source" parameter: must be Function or Array');
                }
            },
            attempt() {
                this.innerSource()
                    .then(data => {
                        this.processOptions(data);
                        this.loadedSuccessful = true;
                        this.loading = false;
                    })
                    .catch(error => {
                        this.attemptsCounter++;

                        if ( error.context.status && error.context.status === 503 && (this.attemptsCounter < this.$props.attempts) ) {
                            this.attempt();

                        } else {
                            this.loadedSuccessful = false;
                            this.loading = false;
                            this.$emit('LOADING_FAILED')
                        }
                    });
            },

            processOptions: function(data) {
                this.options = data.map(option => {
                    return {
                        value: this.getValue(option),
                        label: this.getLabel(option)
                    }
                });

                // auto apply 1st option in the list
                if (this.$props.autoApplyFirstOption && this.options.length > 0 && !this.innerValue) {
                    this.innerValue = this.options[0].value;
                }
            },
            getValue: function(option) {
                if (typeof this.valueParam === 'function') {
                    return this.valueParam(option);
                } else {
                    if (typeof option === 'object' && option !== null)
                        return option[this.valueParam];
                    else
                        return option;
                }
            },
            getLabel: function(option) {
                if (typeof this.labelParam === 'function') {
                    return this.labelParam(option);
                } else {
                    if (typeof option === 'object' && option !== null)
                        return option[this.labelParam];
                    else
                        return option;
                }
            }
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
        },

        //
        // EVENTS
        //
        mounted() {
            this.init();
        },
        beforeDestroy() {
            this.attemptsCounter = 100;
        }
    }
</script>
