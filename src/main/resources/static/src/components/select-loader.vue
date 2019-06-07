<template>
    <loader v-if="loading" type="input" />
    <select
        v-else
        v-model="innerValue"
    >
        <option v-if="allowEmpty" :value="null">{{emptyLabel}}</option>
        <option v-for="o in options" :value="o.value">{{o.label}}</option>
    </select>
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
            emptyLabel: ''
        },
        data() {
            return  {
                innerValue: this.$props.value,
                innerSource: this.$props.source,
                options: [],
                loading: true
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
                    this.innerSource()
                        .then(data => {
                            this.processOptions(data);
                            this.loading = false;
                        });
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

            processOptions: function(data) {
                this.options = data.map(option => {
                    return {
                        value: this.getValue(option),
                        label: this.getLabel(option)
                    }
                });
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
        }
    }
</script>
