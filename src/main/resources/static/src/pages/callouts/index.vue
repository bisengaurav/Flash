<template>
    <div>

        <h1 class="slds-text-heading_large slds-m-bottom_x-large">{{pageTitle}}</h1>

        <callouts-filter-form v-model="filters"></callouts-filter-form>
        
         <div class="primary-section">
            <data-table-basic
                    ref="caseTable"
                    key-field="serviceAppointmentId"
                    :action="$API.case.getAllByFilter"
                    :filters="filters"
                    :immediateRefresh="false"
                    :useLoading="false"
                >
                <template #head>
                    <th>Case ID</th>
                    <th>Created</th>
                    <th>Due Date</th>
                    <th>Entrap.</th>
                    <th>Hazard</th>
                    <th>Injury</th>
                    <th>Asset</th>
                    <th>Location</th>
                    <th>Street</th>
                    <th>City</th>
                    <th>State / Province</th>
                    <th>Contact</th>
                    <th>Caller name</th>
                    <th>Work order</th>
                    <th>Assembly Code</th>
                    <th>Service appointment</th>
                    <th>SA status</th>
                    <th>Service resource</th>
                    <th>Service territory</th>
                    <th></th>
                </template>
                <template #row="{row, id}">
                    <td>{{row.caseNumber}}</td>
                    <td>{{row.createdDate}}</td>
                    <td>{{row.npxResponseDueDate__c}}</td>
                    <td>{{row.entrapment__c}}</td>
                    <td>{{row.hazard__c}}</td>
                    <td>{{row.injury__c}}</td>
                    <td>{{row.assetName}}</td>
                    <td>{{row.locationName}}</td>
                    <td>{{row.street__c}}</td>
                    <td>{{row.city__c}}</td>
                    <td>{{row.stateProvince__c}}</td>
                    <td>{{row.contactName}}</td>
                    <td>{{row.callerName__c}}</td>
                    <td>{{row.workOrderNumber}}</td>
                    <td>{{row.assemblyNumber__c}}</td>
                    <td>{{row.appointmentNumber}}</td>
                    <td>{{row.serviceAppointmentStatus}}</td>
                    <td>{{row.serviceResourceName}}</td>
                    <td>{{row.serviceTerritoryName}}</td>
                    <td></td>
                </template>
            </data-table-basic>
        </div>

    </div>
</template>

<script>
    import Page from '../../components/page.vue';
     import CalloutsFilterForm from './callouts-filter-form.vue';

    export default {
        extends: Page,

        components: {
            CalloutsFilterForm
        },
        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Callouts',
                 filters: {}
            }
        }
    }
</script>
