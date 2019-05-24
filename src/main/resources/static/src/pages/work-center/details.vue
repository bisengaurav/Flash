<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button to="equipment" class="slds-m-right_medium" />
            {{title}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>
            <!-- <div class="slds-col slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium"> -->
                     <!-- slds-p-bottom_mediumslds-border_bottom -->
                    <!-- <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <div class="slds-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Sales organization</span>
                            <div class="slds-form-element__static">
                                {{serviceTerritory.name}}
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->

            <div class="primary-section" v-if="workCenter.workCenterResources.length > 0">

                    <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th>Workcenter Members</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in workCenter.workCenterResources"
                                :key="row.id"
                            >
                               <td>{{row.serviceResource_name}}</td>
                            </tr>
                        </tbody>
                    </table>

            </div>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';

    export default {
        extends: Page,

        //
        // PARAMS: porps, data, computed
        //
        props: {
            id: {
                type: Number,
                default: null
            }
        },
        data() {
            return  {
                pageTitle: 'Work Center Record Detail',
                loading: true,
                workCenter: {},
                title: ''
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.loading = true;

                // wrong Job ID
                if (!this.id) {
                    throw new Error('Wrong ID');
                }

                // data
                  this.$API.workCenter.getById(this.id)
                    .then(data => {
                        
                        this.loading = false;
                        console.log(data);
                        this.workCenter = data;
                        this.title = data.name;
                        if (this.autoRefreshOn) this.initAutoRefresh();
                    });
            }
        },

        //
        // WATCHERS
        //
        watch: {
            id: {
                handler() {
                    this.init();
                },
                immediate: true
            }
        }

    }
</script>
