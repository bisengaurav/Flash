<template></template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            value: {}, // ignored for now
            cacheUniqueKey: {
                type: String
            },
            applyOnCacheLoad: {
                type: Boolean,
                default: false
            }
        },

        data() {
            return {
                innerValue: {},
                metadata: {},

                gridClass: 'slds-grid slds-gutters_direct slds-grid_vertical-align-start slds-wrap',
                gridItemClass: 'slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-large-size_1-of-6 slds-m-bottom_x-small',
                buttonsClass: 'slds-col slds-size_1-of-1 slds-p-top_small'
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
            _loadCache() {
                return this.$ls.getSessionCache(this._cacheKey());
            },
            _saveCache() {
                this.$ls.setSessionCache(this._cacheKey(), this.appliedFilters);
            },
            _cacheKey() {
                return 'filters-cache_'+ this.$props.cacheUniqueKey;
            },

            // buttons actions
            apply() {
                // prevent action, if button enabled - force validate all fields
                if (this.$v !== undefined) {
                    this.$v.$touch();
                    if (this.$v.$invalid) return;
                }

                this.$emit('input', this.appliedFilters);
                if (this.$props.cacheUniqueKey) this._saveCache();
            },
            clearAll() {
                this.init();
            }
        },

        //
        // EVENTS
        //
        created() {
            this.init();

            // load cached data
            if (this.$props.cacheUniqueKey && this._loadCache()) {
                this.innerValue = Object.assign({}, this.metadata, this._loadCache());
                if (this.$props.applyOnCacheLoad) this.apply();
            }
        }
    }
</script>
