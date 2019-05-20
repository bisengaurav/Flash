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
            keyField: {
                type: String,
                default: 'id'
            },
            action: {
                type: Function,
                required: true
            },
            params: {},
            rowClass: null
        },
        data() {
            return {
                loading: true,
                data: [],
                highlightedId: null
            }
        },

        //
        // METHODS
        //
        methods: {
            refresh(id) {
                this.loading = true;
                this.action(this.params)
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
            this.refresh();
        },

        //
        // WATCHERS
        //
        watch: {
            params: {
                handler() {
                    this.refresh();
                },
                deep: true
            }
        }

    }
</script>
