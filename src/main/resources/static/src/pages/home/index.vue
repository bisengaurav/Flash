<template>
    <section>

        <h1 class="slds-text-heading_large slds-m-bottom_small">Welcome to the Heroku Data Archiver application</h1>
        <p class="slds-container_medium slds-text-heading_medium">This application is used to configure, run and manage archiving processes to offload data from a Salesforce environment to Heroku Postgres.  The application is targeted to be utilized by Administrators.</p>

        <div class="slds-grid slds-gutters_direct slds-wrap slds-m-vertical_large">
            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">Job Configs</h2>
                    <p>The Job Configuration page is utilized to create, edit and delete archiving job configurations.  Job Configurations can also be run manually or can be scheduled to run at a specific time and date.</p>
                </div>
            </div>

            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">Jobs</h2>
                    <p>The Jobs page is utilized to monitor and view jobs that have either been executed or are currently running.  An administrator can also view details of a specific job including status of the job, the job configuration that was run, row counts for each object archived and any error messages associated with a job configuration.</p>
                </div>
            </div>

            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">Relationship Manager</h2>
                    <p>The Relationship Manager page is utilized to configure the object hierarchy and relationships that will be applied when a Job Configuration is executed.  The list of objects that appear will be based on the objects that have been mapped in Heroku Connect or configured as SOAP-based objects for archiving in the Object Configuration page.</p>
                </div>
            </div>

            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">App Configuration</h2>
                    <p>The Application Configuration page is utilized to configure the Salesforce URL end point and the Salesforce Administrator credentials that will be used for archiving of any SOAP-based objects.  This credential will need to have full access to all the objects and fields for the SOAP-based objects to full archive.</p>
                </div>
            </div>

            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">Object Configuration</h2>
                    <p>The Object Configuration page is utilized to manage the list of objects that have been configured for archiving and unarchiving.  Objects can be configured to either utilized Heroku Connect or SOAP and also identify if it will be considered a read-only object, which will identify which objects will not be including during an unarchive process.</p>
                </div>
            </div>

            <div class="slds-col slds-p-bottom_medium slds-medium-size_1-of-3 slds-small-size_1-of-2 slds-size_1-of-1">
                <div class="slds-card slds-p-around_medium">
                    <h2 class="slds-text-heading_small slds-m-bottom_x-small">User Management</h2>
                    <p>The User Management page is utilized to manage the list of administrators who have access to the Archiver Application and if they are considered a full admin or just a read-only admin.</p>
                </div>
            </div>
        </div>

    </section>
</template>

<script>
    import Page from '../../components/page.vue';

    import Icons from '../../core/icons.js';
    import {faEye} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faEye);


    export default {
        extends: Page,

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Home'
            }
        }
    }
</script>

<style scoped>
    .slds-text-heading_small {
        font-size: 1.1rem;
    }
</style>
