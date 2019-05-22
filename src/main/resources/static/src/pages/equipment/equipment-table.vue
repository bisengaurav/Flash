<template>

     <div class="primary-section">
            <data-table-pagination
               :action="dataTemplate"
                sortDir="DESC"
                sortBy="id"
            >
                <template #head>
                    <th>Equipment</th>
                    <th>Equipment type</th>
                    <th>Customer asset name</th>
                    <th>Phone</th>
                    <th>Account name</th>
                    <th>Sold-to name</th>
                    <th>Location</th>
                    <th>Street</th>
                    <th>City</th>
                    <th>State / Province</th>
                    <th>Service Territory</th>
                    <th>Work Center</th>
                    <th>Valid contract</th>
                    <th></th>
                </template>
                <template #row="{row, id}">
                    <td>{{id}}</td>
                    <td>{{row.type}}</td>
                    <td>{{row.customerName}}</td>
                    <td>{{row.phone}}</td>
                    <td>{{row.accountName}}</td>
                    <td>{{row.soldTo}}</td>
                    <td>{{row.location}}</td>
                    <td>{{row.street}}</td>
                    <td>{{row.city}}</td>
                    <td>{{row.stateProvince}}</td>
                    <td>{{row.serviceTerritory}}</td>
                    <td>{{row.workCenter}}</td>
                    <td>{{row.validContract}}</td>
                </template>
            </data-table-pagination>
        </div>


</template>

<script>

    export default {

        methods: {
            dataTemplate() {
                return new Promise((resolve, reject) => {
                    resolve({
                           "content": [
                                {
                                    "id": 10296163,
                                    "type": "Elevator",
                                    "customerName": "LINKSE LIFT",
                                    "phone": "n/a",
                                    "accountName": "VME RES SIBELIUS",
                                    "soldTo": "VME RES SIBELIUS",
                                    "location": "RES SIBELIUS",
                                    "street": "BANHAGENSTR 90",
                                    "city": "BLANDEN",
                                    "stateProvince": null,
                                    "serviceTerritory": "BEL:B12 - SEB Diest 2",
                                    "workCenter": "BEL06080",
                                    "validContract": "Yes"
                                },
                                {
                                    "id": 10296164,
                                    "type": "Elevator",
                                    "customerName": "LINKSE LIFT",
                                    "phone": "n/a",
                                    "accountName": "VME RES SIBELIUS",
                                    "soldTo": "VME RES SIBELIUS",
                                    "location": "RES SIBELIUS",
                                    "street": "BANHAGENSTR 90",
                                    "city": "BLANDEN",
                                    "stateProvince": null,
                                    "serviceTerritory": "BEL:B12 - SEB Diest 2",
                                    "workCenter": "BEL06080",
                                    "validContract": "Yes"
                                },
                            ]
                    } )
                })
                
            }
        }   
    }


 </script>