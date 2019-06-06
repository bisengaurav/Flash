<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_large">{{pageTitle}}</h1>

        <loader v-if="loading" type="block" :height="400" />
        <div>
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
        data() {
            return {
                pageTitle: 'User Management',
                loading: true,
            }
        },

        //
        // METHODS
        //
        methods: {
            init() {
                this.loading = true;
                
                // data
                  this.$API.user.getUserInfo()
                    .then(data => {
                        console.log(data);
                        // this.loading = false;
                        // this.workCenter = data;
                        // this.pageTitle = this.$t('label.work-center')+' — '+ this.workCenter.name;
                    });
            }
        },
    }
</script>
