<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">
            <back-button class="slds-m-right_medium" />
            {{pageTitle}}
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
        </div>

        <div v-if="workCenter.workCenterResources.length > 0">

                <div class="slds-card slds-p-around_medium">
                    <table  class="slds-table slds-table_cell-buffer slds-table_bordered">
                        <thead>
                            <tr class="slds-line-height_reset">
                                <th v-t="'field.workcenter.serviceresourcename.label'"></th>
                                <th v-t="'field.workcenter.workcentername.label'"></th>
                                <th v-t="'field.workcenter.worktypename.label'"></th>
                                <th v-t="'field.workcenter.preferencetype__c.label'"></th>
                                <th v-t="'field.workcenter.startdate__c.label'"></th>
                                <th v-t="'field.workcenter.enddate__c.label'"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr
                                v-for="row in workCenter.workCenterResources"
                                :key="row.id"
                            >
                                <td><router-link :to="{name: 'serviceResource', params: {id: row.serviceResourceId }}">{{row.serviceResourceName}}</router-link></td>
                                <td>{{row.workCenterName}}</td>
                                <td>{{row.workTypeName}}</td>
                                <td>{{row.preferenceType__c}}</td>
                                <td>{{ $dtz(row.startDate__c, 'datetime') }}</td>
                                <td>{{ $dtz(row.endDate__c, 'datetime') }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

    </div>
</template>

<script>
    import PageInterface from '../../components/page-interface.vue';

    export default {
        extends: PageInterface,

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
                pageTitle: this.$t('text.work-center.heading'),
                loading: true,
                workCenter: {
                    workCenterResources: [],
                },
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
                        this.workCenter = data;
                        this.pageTitle = this.$t('text.work-center.heading')+' — '+ this.workCenter.name;
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
