<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">
            <back-button to="users" class="slds-m-right_medium" />
            {{pageTitle}}
        </h1>

        <loader v-if="loading" type="block" :height="400" />
        <div v-else>

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
                pageTitle: 'Service Appointment Record Detail',
                loading: true,
                serviceAppointment: {}
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
                  this.$API.serviceAppointment.getById(this.id)
                    .then(data => {                    
                        this.loading = false;
                        this.serviceAppointment = data;
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
