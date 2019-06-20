export default {
    //
    // PARAMS: props, data, computed
    //
    props: {
        value: {}, // ignored for now
        cacheUniqueKey: {
            type: String
        },
        applyOnCacheLoad: {
            type: Boolean,
            default: true
        }
    },

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
                if (this.innerValue[k] !== undefined && this.innerValue[k] !== null) f[k] = this.innerValue[k];
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

            // cache filter values
            if (this.$props.cacheUniqueKey) this._saveCache();

            // apply values - fire to v-model bind
            this.$emit('input', this.appliedFilters);
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

            // apply loaded values
            if (this.$props.applyOnCacheLoad) this.apply();
        }
    }
}
