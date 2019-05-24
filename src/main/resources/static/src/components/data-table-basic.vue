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
                :key="row[$props.keyField]"
                :class="[
                    $props.rowClass && $props.rowClass(row),
                    {'slds-table_row-highlight': highlightedId === row[$props.keyField]}
                ]"
            >
                <slot name="row" :row="row" :id="row[$props.keyField]"></slot>
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
                type: String,
                default: 'id'
            },
            action: {
                type: Function,
                required: true
            },
            immediateRefresh: {
                type: Boolean,
                default: true
            },
            useLoading: {
                type: Boolean,
                default: true
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
                        this.data = data;
                        this.loading = false;
                    });
            }
        },

        //
        // EVENTS
        //
        mounted() {
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
