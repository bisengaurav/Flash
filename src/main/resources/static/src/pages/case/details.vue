<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button to="callouts" class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>
              <div class="slds-col slds-size_1-of-1">

                <div class="slds-card slds-p-around_medium">
                     <!-- slds-p-bottom_mediumslds-border_bottom -->
                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Case title</span>
                            <div class="slds-form-element__static">
                              
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Status</span>
                            <div class="slds-form-element__static">
                              
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Owner</span>
                            <div class="slds-form-element__static">
                               
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Created in FSM</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Entrapment</span>
                            <div class="slds-form-element__static">
                               
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Hazard</span>
                            <div class="slds-form-element__static">
                               
                            </div>
                        </div>
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded slds-m-bottom_small">
                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Injury</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Asset</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account ID</span>
                            <div class="slds-form-element__static">
                               
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Account name</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Contact</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Contact phone</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>  
                    </div>

                    <div class="slds-grid slds-wrap slds-grid_pull-padded">
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label">Caller name</span>
                            <div class="slds-form-element__static">
                              
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Caller phone</span>
                            <div class="slds-form-element__static">
                              
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Passenger</span>
                            <div class="slds-form-element__static">
                               
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label">Sales organization</span>
                            <div class="slds-form-element__static">
                                
                            </div>
                        </div>

                        
                    </div>
                </div>

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
                pageTitle: 'Case Record Detail',
                loading: true,
                case: {}
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
                  this.$API.case.getById(this.id)
                    .then(data => {                    
                        this.loading = false;
                        this.case = data;
                        console.log(data);
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
