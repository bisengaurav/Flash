<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>
             <div class="slds-col slds-size_1-of-1">

                <div class="slds-card slds-p-around_medium">

                    <div class="slds-grid slds-wrap slds-grid_pull-padded">
                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6 slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.user.name.label'"></span>
                            <div class="slds-form-element__static">
                                {{userData.name}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.user.profileid.label'"></span>
                            <div class="slds-form-element__static">
                                {{ userData.profileId }}
                            </div>
                        </div>



                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.user.timezonesidkey.label'"></span>
                            <div class="slds-form-element__static">
                                {{userData.timezoneSidKey}}
                            </div>
                        </div>

                        <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.user.languagelocalekey.label'"></span>
                            <div class="slds-form-element__static">
                                {{userData.languageLocaleKey}}
                            </div>
                        </div>

                         <div class="slds-size_1-of-2 slds-medium-size_1-of-3 slds-large-size_1-of-6  slds-col_padded">
                            <span class="slds-form-element__label" v-t="'field.user.isadmin.label'"></span>
                            <div class="slds-form-element__static">
                                {{ userData.isAdmin |yesNo }}
                            </div>
                        </div>



                    </div>
                </div>

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
        data() {
            return {
                pageTitle: this.$t('text.users.heading'),
                userData: {},
                loading: true,
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                console.log('init');
                this.loading = true;

                // data
                this.$API.user.getUserInfo().then(data => {
                    this.loading = false;
                    this.userData = data;
                    this.pageTitle = this.$t('text.users.heading')+' — '+ this.workCenter.name;
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
