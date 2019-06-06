export default {
    'message.from-lang-pages': 'From Lang Pages',

    //equipment title
    'label.equipment': 'Equipment',
    'label.equipment.slas': 'SLAs',

    //service territory title
    'label.service-territory': 'Service Territory',
    'label.service-territory.service-resources': 'Service Resources',

    //work center title
    'label.work-center': 'Work Center',

    //service resource title
    'label.service-resource': 'Service Resource',
    'label.service-resource.service-resource-territories': 'Service Territories',
    'label.service-resource.work-centers': 'Work Centers',
    'label.service-resource.resource-absences': 'Absencess',
    'label.service-resource.service-resource-appointments': 'Service Appointments',

    //callouts title
    'label.callouts': 'Callouts',

    //case title
    'label.case': 'Case',
    'label.case.work-orders': 'Work orders of the case',

    //work order title
    'label.work-order': 'Work Order',
    'label.work-order.service-appointments': 'Work orders of the case',

    //service appointment title
    'label.service-appointment': 'Service Appointment',

    //user management
    'label.users': 'User Management',

    //equipment filters
    'filter.equipment.country.label': 'Country',
    'filter.equipment.equipment-type.label': 'Equipment Type',
    'filter.equipment.customer-asset-name.label': 'Customer Asset Name',
    'filter.equipment.account.label': 'Account',
    'filter.equipment.sold-to.label': 'Sold to',
    'filter.equipment.valid-contract.label': 'Valid Contract',

    //case filters
    'filter.case.case-id.label': 'Case ID',
    'filter.case.created-after.label': 'Created after',
    'filter.case.due-date-after.label': 'Due Date after',
    'filter.case.entrapment.label': 'Entrapment',
    'filter.case.hazard.label': 'Hazard',
    'filter.case.Injury.label': 'Injury',
    'filter.case.asset.label': 'Asset',
    'filter.case.contact.label': 'Contact',
    'filter.case.caller-name.label': 'Caller name',
    'filter.case.work-order.label': 'Work order',
    'filter.case.assembly-code.label': 'Assembly Code',
    'filter.case.maintenance-activity-type.label': 'Maintenance Activity Type',
    'filter.case.service-appointment.label': 'Service appointment',
    'filter.case.sa-status.label': 'SA status',
    'filter.case.service-territory.label': 'Service territory',
    'filter.case.case-owner.label': 'Case Owner',

    //asset filters
    'filter.asset.phone.label': 'Phone',
    'filter.asset.location.label': 'Location',
    'filter.asset.street.label': 'Street',
    'filter.asset.city.label': 'City',
    'filter.asset.state-province.label': 'State/Province',
    'filter.asset.service-resource.label': 'Service Resource',
    'filter.asset.sales-org.label': 'Sales org.',



    //equipment fields
    'field.equipment.name.label': 'Equipment',
    'field.equipment.equipmentphonenumber__c.label': 'Phone',
    'field.equipment.customerassetname__c.label': 'Customer asset name',
    'field.equipment.equipmenttype__c.label': 'Equipment type',
    'field.equipment.soldtoname.label': 'Sold-to name',
    'field.equipment.fsmlastvalidclienddate__c.label': 'Valid contract',
    'field.equipment.soldtoid.label': 'Sold-to ID',
    'field.equipment.installationcountry__c.label': 'Country',

    //equipment slas fields
    'field.equipment.activeslas.name.label': 'SLA',
    'field.equipment.activeslas.coverage__c.label': 'Coverage',
    'field.equipment.activeslas.startdate.label': 'Start Date',
    'field.equipment.activeslas.enddate.label': 'End Date',
    'field.equipment.activeslas.status.label': 'Status',
    'field.equipment.activeslas.responseTime__c.label': 'Response Time',
    'field.equipment.activeslas.responseTimeAfterHours__c.label': 'Response Time After Hours',
    'field.equipment.activeslas.calloutHours__c.label': 'Callout Hours',
    'field.equipment.activeslas.serviceHours__c.label': 'Service Hours',

    //service territory fields
    'field.serviceterritory.salesorganization__c.label': 'Sales organization',
    'field.serviceterritory.serviceterritoryresources.effectivestartdate.label': 'Start Date',
    'field.serviceterritory.serviceterritoryresources.effectiveenddate.label': 'End Date',
    'field.serviceterritory.serviceterritoryresources.serviceresource_name.label': 'Title',
    'field.serviceterritory.serviceterritoryresources.phone__c.label': 'Phone',

    //work center fields
    'field.workcenter.workcenterresources.serviceresourcename.label': 'Service Resource',
    'field.workcenter.workcenterresources.workcentername.label': 'Work Center',
    'field.workcenter.workcenterresources.worktypename.label': 'Work Type',
    'field.workcenter.workcenterresources.preferencetype__c.label': 'Preference Type',
    'field.workcenter.workcenterresources.startdate__c.label': 'Start Time',
    'field.workcenter.workcenterresources.enddate__c.label': 'End Time',

    //service resource fields
    'field.serviceresource.name.label': 'Title',
    'field.serviceresource.phone__c.label': 'Phone',
    'field.serviceresource.salesorganization__c.label': 'Sales organization',

    'field.serviceresource.serviceresourceterritories.name.label': 'Name',
    'field.serviceresource.serviceresourceterritories.territorytype.label': 'Territory Type',
    'field.serviceresource.serviceresourceterritories.shifttype__c.label': 'Shift Type',
    'field.serviceresource.serviceresourceterritories.effectivestartdate.label': 'Start Date',
    'field.serviceresource.serviceresourceterritories.effectiveenddate.label': 'End Date',

    'field.serviceresource.serviceresourceworkcenters.name.label': 'Title',

    'field.serviceresource.resourceabsences.start.label': 'Start time',
    'field.serviceresource.resourceabsences.end.label': 'End time',
    'field.serviceresource.resourceabsences.recordtype__c.label': 'Record Type',
    'field.serviceresource.resourceabsences.type.label': 'Type',
    
    'field.serviceresource.serviceresourceappointments.appointmentnumber.label': 'Service Appointment',
    'field.serviceresource.serviceresourceappointments.status.label': 'SA Status',
    'field.serviceresource.serviceresourceappointments.scheduledstartoriginal__c.label': 'Scheduled Start',
    'field.serviceresource.serviceresourceappointments.scheduledendoriginal__c.label': 'Scheduled End',
    'field.serviceresource.serviceresourceappointments.fslpinned__c.label': 'Pinned',
    'field.serviceresource.serviceresourceappointments.workordernumber.label': 'Work Order',
    'field.serviceresource.serviceresourceappointments.earlieststartdate__c.label': 'Earliest Start Date',
    'field.serviceresource.serviceresourceappointments.duedate__c.label': 'Due Date',
    'field.serviceresource.serviceresourceappointments.maintenanceactivitytype__c.label': 'Activity Type',
    'field.serviceresource.serviceresourceappointments.assembly__c.label': 'Assembly',
    'field.serviceresource.serviceresourceappointments.description__c.label': 'Description',
    'field.serviceresource.serviceresourceappointments.locationname.label': 'Location',
    'field.serviceresource.serviceresourceappointments.installationstreet__c.label': 'Street',
    'field.serviceresource.serviceresourceappointments.installationcity__c.label': 'City',

    //case fields
    'field.case.casenumber.label': 'Case ID',
    'field.case.createddate.label': 'Created',
    'field.case.duedate__c.label': 'Due Date',
    'field.case.entrapment__c.label': 'Entrap.',
    'field.case.hazard__c.label': 'Hazard',
    'field.case.injury__c.label': 'Injury',
    'field.case.assetname.label': 'Equipment',
    'field.case.street__c.label': 'Street',
    'field.case.city__c.label': 'City',
    'field.case.stateprovince__c.label': 'State / Province',
    'field.case.contactname.label': 'Contact',
    'field.case.callername__c.label': 'Caller name',
    'field.case.workordernumber.label': 'Work order',
    'field.case.assemblynumber__c.label': 'Assembly Code',
    'field.case.appointmentnumber.label': 'Service appointment',
    'field.case.serviceappointmentstatus.label': 'SA status',
    'field.case.serviceresourcename.label': 'Service resource',
    
    'field.case.status.label': 'Status',
    'field.case.caseownertxt__c.label': 'Owner',
    'field.case.createddate.label': 'Created in FSM',
    'field.case.accountid.label': 'Account ID',
    'field.case.accountname.label': 'Account name',
    'field.case.contactphone.label': 'Contact phone',
    'field.case.callerphonenumber__c.label': 'Caller phone',
    'field.case.fsmcontactIspassenger__c.label': 'Passenger',
    'field.case.salesorganization__c.label': 'Sales organization',
    'field.case.subject.label': 'Case title',

    'field.case.workorders.workordernumber': 'Work order ID',
    'field.case.workorders.status': 'Status',
    'field.case.workorders.earlieststartdate__c': 'Earliest Start Date',
    'field.case.workorders.duedate__c': 'Due Date',

    //work orders fields
    'field.workorder.status.label': 'Status',
    'field.workorder.lastmodifieddate.label': 'Last updated in FSM',
    'field.workorder.earlieststartdate__c.label': 'Earliest Start Date',
    'field.workorder.duedate__c.label': 'Due Date',
    'field.workorder.assembly__c.label': 'Assembly Code',
    'field.workorder.assetname.label': 'Equipment',
    'field.workorder.accountid.label': 'Account ID',
    'field.workorder.serviceterritoryname.label': 'Service territory',
    'field.workorder.casenumber.label': 'Case',
    'field.workorder.description__c.label': 'Description',

    'field.workorder.serviceappointments.appointmentnumber.label': 'Service Appointment ID',
    'field.workorder.serviceappointments.status.label': 'Status',
    'field.workorder.serviceappointments.serviceresourcename.label': 'Service resource',
    'field.workorder.serviceappointments.scheduledstartoriginal__c.label': 'Scheduled Start Date',
    'field.workorder.serviceappointments.scheduledendoriginal__c.label': 'Scheduled End Date',
    
    //service appointment fields
    'field.serviceappointment.status.label': 'Status',
    'field.serviceappointment.lastmodifieddate.label': 'Last updated in FSM',
    'field.serviceappointment.scheduledstartoriginal__c.label': 'Scheduled Start Date',
    'field.serviceappointment.duedate__c.label': 'Scheduled End Date',
    'field.serviceappointment.fslpinned__c.label': 'Pinned',
    'field.serviceappointment.blockedreason__c.label': 'Blocked reason',
    'field.serviceappointment.accountid.label': 'Account ID',
    'field.serviceappointment.accountname.label': 'Account name',
    'field.serviceappointment.serviceresourcename.label': 'Service resource',
    'field.serviceappointment.workordernumber.label': 'Work order',
    'field.serviceappointment.assetname.label': 'Equipment',
    'field.serviceappointment.serviceterritoryname.label': 'Service territory',
    'field.serviceappointment.salesorganization__c.label': 'Sales organization',

    //users fields
    'field.users.name.label': 'Name',
    'field.users.profileid.label': 'Profile',
    'field.users.timezonesidkey.label': 'Time zone',
    'field.users.languagelocalekey.label': 'Language',
    'field.users.isadmin.label': 'Admin',
  
    //asset fields
    'field.asset.accountname.label': 'Account name',
    'field.asset.locationname.label': 'Location',
    'field.asset.installationstreet__c.label': 'Street',//---
    'field.asset.installationcity__c.label': 'City',//---
    'field.asset.installationstateprovince__c.label': 'State / Province',//---
    'field.asset.serviceterritoryname.label': 'Service Territory',
    'field.asset.workcentername.label': 'Work Center',//---
    'field.asset.accountid.label': 'Account ID',//---

    //Buttons
    'label.button.apply': 'Apply',
    'label.button.clear-all': 'Clear All'
}
