<template>
    <div>


        <loader v-if="loading" type="block" :height="41*pageSize +37" />

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
            <alert type="static" :showIcon="false" :animate="false" :closable="false" v-t="'message.common.no-data'" />
        </div>


        <div v-if="data.length > 0 && showPagination" class="slds-p-horizontal_medium slds-p-vertical_small">
            <div class="slds-pagination slds-grid slds-grid_vertical-align-center">

                <div class="slds-col_bump-right">
					<span v-if="totalItems > 0" class="slds-text-body_small slds-text-nowrap" v-t="{
					    path: 'label.pagination.info.vue',
					    args: {
					        from: (currentPage-1)*pageSize +1,
					        to: (totalItems > currentPage*pageSize ? currentPage*pageSize : totalItems),
					        total: totalItems
					    }
					}" />
                </div>

                <template v-if="totalPages > 1">
                    <button
                        class="slds-button slds-button_icon slds-button_icon-container"
                        :title="$t('label.pagination.previous-page')"
                        @click="currentPage--"
                        :disabled="currentPage == 1"
                    >
                        <icon icon="chevron-left" class="slds-button__icon" />
                    </button>

                    <div class="slds-p-horizontal--small">
                        <div v-if="totalPages <= maxPageListing" class="slds-pagination_pages">
                            <a
                                v-for="p in totalPages"
                                :class="[
                                    'slds-button',
                                    (p == currentPage ? 'slds-button_brand' : 'slds-button_neutral')
                                ]"
                                @click="currentPage = p"
                            >
                                {{p}}
                            </a>
                        </div>

                        <div v-else class="slds-pagination_page-selector slds-grid slds-grid_vertical-align-center">
                            <span class="slds-text-body_small slds-pagination_page-text slds-m-right_x-small" v-t="'label.pagination.page'" />
                            <input
                                v-model.lazy.number="currentPage"
                                autocomplete="false"
                                class="slds-input"
                            />
                            <span class="slds-text-body_small slds-pagination_page-text slds-m-left_x-small" v-t="{path: 'label.pagination.of-total.vue', args: {total: totalPages}}" />
                        </div>
                    </div>

                    <button
                        class="slds-button slds-button_icon slds-button_icon-container"
                        :title="$t('label.pagination.next-page')"
                        @click="currentPage++"
                        :disabled="currentPage == totalPages"
                    >
                        <icon icon="chevron-right" class="slds-button__icon" />
                    </button>
                </template>

            </div>
        </div>


    </div>
</template>

<script>
    import Icons from '../core/icons.js';
    import {faChevronLeft, faChevronRight} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faChevronLeft, faChevronRight);

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

            // "static" external params, not used in logic
            params: {
                type: Object,
                default: () => ({})
            },
            filters: {
                type: Object,
                default: () => ({})
            },

            // "dynamic" params, used in logic
            showPagination: {
                type: Boolean,
                default: true
            },
            pageSize: {
                type: Number,
                default: 5
            },
            sortBy: {
                type: String,
                required: true
            },
            sortDir: {
                type: String,
                required: true
            },

            // design
            rowClass: Function
        },
        data() {
            return {
                loading: true,
                data: [],
                highlightedId: null,

                innerSortBy: this.$props.sortBy,
                innerSortDir: this.$props.sortDir === 'ASC' ? 'ASC' : 'DESC',
                innerCurrentPage: 1,
                totalItems: 0,
                maxPageListing: 5
            }
        },
        computed: {
            totalPages: function() {
                return Math.ceil(this.totalItems / this.pageSize);
            },
            currentPage: {
                get: function() {
                    return +this.innerCurrentPage;
                },
                set: function(v) {
                    v = +v;
                    if (v < 1 || v > this.totalPages) v = 1;
                    this.innerCurrentPage = v;
                }
            }
        },

        //
        // METHODS
        //
        methods: {
            refresh(id) {
                this.loading = true;

                let params = Object.assign(
                    this.$props.params,
                    {filter: JSON.stringify(this.$props.filters)},
                    {pagingParams: JSON.stringify(
                        {
                            pageNumber: this.currentPage -1,
                            pageSize: this.$props.pageSize,
                            sortingParams: [
                                {
                                    direction: this.innerSortDir,
                                    property: this.innerSortBy
                                }
                            ]
                        }
                    )}
                );
                this.action(params)
                    .then(data => {
                        this.highlightedId = id;
                        this.data = data.content;
                        this.totalItems = data.totalElements;
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
                handler(val, oldVal) {
                    this.currentPage = 1;
                    this.refresh();
                },
                deep: true
            },
            filters: {
                handler(val, oldVal) {
                    this.currentPage = 1;
                    this.refresh();
                },
                deep: true
            },
            innerCurrentPage: function(val, oldVal) {
                this.refresh();
            },
            totalPages: function(val, oldVal) {
                if (this.innerCurrentPage > this.totalPages) this.innerCurrentPage = 1;
            }
        }

    }
</script>
