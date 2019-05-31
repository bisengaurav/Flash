<template></template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: ['value'],

        data() {
            return {
                innerValue: {},
                metadata: {}
            }
        },
        computed: {
            appliedFilters: function() {
                let f = {};

                Object.keys(this.innerValue).forEach(k => {
                    if (this.innerValue[k]) f[k] = this.innerValue[k];
                });

                return f;
            },
            countOfAppliedFilters: function() {
                return Object.keys(this.appliedFilters).length;
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.innerValue = Object.assign({}, this.metadata);
            },

            apply() {
                console.log(this.innerValue, this.appliedFilters);
                this.$v.$touch();
                if (this.$v.$invalid) return;
                this.$emit('input', this.appliedFilters);
            },

            clearAll() {
                this.init();
//                this.apply();
            }
        },

        //
        // EVENTS
        //
        created() {
            this.init();
        },

        //
        // WATCHERS
        //
        // watch: {
        //     innerValue: function() {
        //         console.log('innerValue');
        //     //   this.disableButton = this.innerValue !== {} ? true : false;
        //     },
        //     deep: true
        // }

    }
</script>
