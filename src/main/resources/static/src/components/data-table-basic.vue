<template>
    <loader v-if="loading" type="block" :height="200" />

    <table v-else-if="data.length > 0" class="slds-table slds-table_cell-buffer slds-table_bordered">
        <thead>
            <tr class="slds-line-height_reset">
                <slot name="head"></slot>
            </tr>
        </thead>
        <tbody>
            <tr
                v-for="row in data"
                :key="row[key]"
                :class="[
                    $props.rowClass && $props.rowClass(row),
                    {'slds-table_row-highlight': highlightedId === row[key]}
                ]"
            >
                <slot name="row" :row="row" :id="row[key]"></slot>
            </tr>
        </tbody>
    </table>

    <div v-else class="slds-p-around_medium">
        <alert type="static" :showIcon="false" :animate="false" :closable="false">
            No data found
        </alert>
    </div>
</template>

<script>
    export default {
        //
        // PARAMS: porps, data, computed
        //
        props: {
            // query params
            keyField: {
                default: 'id'
            },
            action: {
                type: Function,
                required: true
            },

            // behavior params
            immediateRefresh: {
                type: Boolean,
                default: true
            },
            useLoading: {
                type: Boolean,
                default: true
            },
            cacheUniqueKey: {
                type: String
            },

            // "static" external params, not used in logic
            params: {
                type: Object,
                default: () => ({})
            },
            filters: {
                type: Object,
                default: () => ({})
            },

            rowClass: null
        },
        data() {
            return {
                loading: false,
                data: [],
                highlightedId: null
            }
        },
        computed: {
            key() {
                if (typeof this.$props.keyField == 'function')
                    return '_rowKey';

                if (typeof this.$props.keyField == 'string')
                    return this.$props.keyField;
            }
        },

        //
        // METHODS
        //
        methods: {
            refresh(id) {
                this.loading = this.useLoading;

                this.action(Object.assign(
                    {},
                    this.$props.params,
                    {filter: JSON.stringify(this.$props.filters)},
                ))
                    .then(data => {
                        this.highlightedId = id;

                        if (typeof this.$props.keyField == 'function') {
                            data = data.map((row) => {
                                row._rowKey = this.$props.keyField(row);
                                return row;
                            });
                        }
                        this.data = data;

                        console.log(this.data);
                        this.loading = false;

                        if (this.$props.cacheUniqueKey) this._saveCache();
                    });
            },

            _loadCache() {
                return this.$ls.getSessionCache(this._cacheKey());
            },
            _saveCache() {
                this.$ls.setSessionCache(this._cacheKey(), this.data);
            },
            _cacheKey() {
                return 'table-cache_'+ this.$props.cacheUniqueKey;
            }
        },

        //
        // EVENTS
        //
        mounted() {
            if (this.$props.cacheUniqueKey) {
                let data = this._loadCache();
                if (data) {
                    this.data = data;
                    return;
                }
            }

            if (this.$props.immediateRefresh) this.refresh();
        },

        //
        // WATCHERS
        //
        watch: {
            params: {
                handler(val, oldVal) {
                    this.refresh();
                },
                deep: true
            },
            filters: {
                handler(val, oldVal) {
                    this.refresh();
                },
                deep: true
            }
        }

    }
</script>
