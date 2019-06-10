export default {
    'message.from-lang-pages': 'From Lang Pages',

    //equipment title
    'text.equipment.heading': 'Equipment',
    'text.slas.heading': 'SLAs',

    //service territory title
    'text.service-territory.heading': 'Service Territory',
    'text.service-resources.heading': 'Service Resources of Territory',

    //work center title
    'text.work-center.heading': 'Work Center',

    //service resource title
    'text.service-resource.heading': 'Service Resource',
    'text.service-resource-territories.heading': 'Service Territories',
    'text.work-centers.heading': 'Work Centers',
    'text.resource-absences.heading': 'Absencess',
    'text.service-resource-appointments.heading': 'Service Appointments',

    //callouts title
    'text.callouts.heading': 'Callouts',

    //case title
    'text.case.heading': 'Case',
    'text.case-work-orders.heading': 'Work orders of the case',

    //work order title
    'text.work-order.heading': 'Work Order',
    'text.work-order-service-appointments.heading': 'Service Appointments',

    //service appointment title
    'text.service-appointment.heading': 'Service Appointment',

    //user management title
    'text.users.heading': 'User Management',

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
    'filter.case.injury.label': 'Injury',
    'filter.case.equipment.label': 'Equipment',
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
    'field.equipment.installationstreet__c.label': 'Street',
    'field.equipment.installationcity__c.label': 'City',
    'field.equipment.installationstateprovince__c.label': 'State / Province',
    'field.equipment.workcentername.label': 'Work Center',
    'field.equipment.accountid.label': 'Account ID',

    //equipment slas fields
    'field.activesla.name.label': 'SLA',
    'field.activesla.coverage__c.label': 'Coverage',
    'field.activesla.startdate.label': 'Start Date',
    'field.activesla.enddate.label': 'End Date',
    'field.activesla.status.label': 'Status',
    'field.activesla.responseTime__c.label': 'Response Time',
    'field.activesla.responseTimeAfterHours__c.label': 'Response Time After Hours',
    'field.activesla.calloutHours__c.label': 'Callout Hours',
    'field.activesla.serviceHours__c.label': 'Service Hours',

    //service territory fields
    'field.serviceterritory.salesorganization__c.label': 'Sales organization',

    'field.serviceterritoryresource.effectivestartdate.label': 'Start Date',
    'field.serviceterritoryresource.effectiveenddate.label': 'End Date',
    'field.serviceterritoryresource.serviceresource_name.label': 'Title',
    'field.serviceterritoryresource.phone__c.label': 'Phone',

    //work center fields
    'field.workcenterresource.serviceresourcename.label': 'Service Resource',
    'field.workcenterresource.workcentername.label': 'Work Center',
    'field.workcenterresource.worktypename.label': 'Work Type',
    'field.workcenterresource.preferencetype__c.label': 'Preference Type',
    'field.workcenterresource.startdate__c.label': 'Start Time',
    'field.workcenterresource.enddate__c.label': 'End Time',

    //service resource fields
    'field.serviceresource.name.label': 'Title',
    'field.serviceresource.phone__c.label': 'Phone',
    'field.serviceresource.salesorganization__c.label': 'Sales organization',

    'field.serviceresourceterritory.name.label': 'Name',
    'field.serviceresourceterritory.territorytype.label': 'Territory Type',
    'field.serviceresourceterritory.shifttype__c.label': 'Shift Type',
    'field.serviceresourceterritory.effectivestartdate.label': 'Start Date',
    'field.serviceresourceterritory.effectiveenddate.label': 'End Date',

    'field.serviceresourceworkcenter.name.label': 'Title',

    'field.resourceabsence.start.label': 'Start time',
    'field.resourceabsence.end.label': 'End time',
    'field.resourceabsence.recordtype__c.label': 'Record Type',
    'field.resourceabsence.type.label': 'Type',
    
    'field.serviceresourceappointment.appointmentnumber.label': 'Service Appointment',
    'field.serviceresourceappointment.status.label': 'SA Status',
    'field.serviceresourceappointment.scheduledstartoriginal__c.label': 'Scheduled Start',
    'field.serviceresourceappointment.scheduledendoriginal__c.label': 'Scheduled End',
    'field.serviceresourceappointment.fslpinned__c.label': 'Pinned',
    'field.serviceresourceappointment.workordernumber.label': 'Work Order',
    'field.serviceresourceappointment.earlieststartdate__c.label': 'Earliest Start Date',
    'field.serviceresourceappointment.duedate__c.label': 'Due Date',
    'field.serviceresourceappointment.maintenanceactivitytype__c.label': 'Activity Type',
    'field.serviceresourceappointment.assembly__c.label': 'Assembly',
    'field.serviceresourceappointment.description__c.label': 'Description',
    'field.serviceresourceappointment.locationname.label': 'Location',
    'field.serviceresourceappointment.installationstreet__c.label': 'Street',
    'field.serviceresourceappointment.installationcity__c.label': 'City',

    //case fields
    'field.case.casenumber.label': 'Case ID',
    'field.case.createddate.label': 'Created Date',
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
    'field.case.description.label': 'Description',
    
    'field.case.status.label': 'Status',
    'field.case.caseownertxt__c.label': 'Owner',
    'field.case.accountid.label': 'Account ID',
    'field.case.accountname.label': 'Account name',
    'field.case.contactphone.label': 'Contact phone',
    'field.case.callerphonenumber__c.label': 'Caller phone',
    'field.case.fsmcontactIspassenger__c.label': 'Passenger',
    'field.case.salesorganization__c.label': 'Sales organization',
    'field.case.subject.label': 'Case title',

    //work orders fields
    'field.workorder.workordernumber.label': 'Work order ID',
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
    'field.workorder.sales_organization__c.label': 'Sales organization',
    'field.workorder.maintenanceActivityTypeCode__c.label': 'Maintenance Activity Type',

    'field.workorder.appointmentnumber.label': 'Service Appointment ID',
    'field.workorder.serviceresourcename.label': 'Service resource',
    'field.workorder.scheduledstartoriginal__c.label': 'Scheduled Start Date',
    'field.workorder.scheduledendoriginal__c.label': 'Scheduled End Date',
    
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
    'field.user.name.label': 'Name',
    'field.user.profileid.label': 'Profile',
    'field.user.timezonesidkey.label': 'Time zone',
    'field.user.languagelocalekey.label': 'Language',
    'field.user.isadmin.label': 'Admin',
  
    //asset fields
    'field.asset.accountname.label': 'Account name',
    'field.asset.locationname.label': 'Location',
    'field.asset.serviceterritoryname.label': 'Service Territory',

    //Buttons
    'label.button.apply': 'Apply',
    'label.button.clear-all': 'Clear All',

    //messsages
    'message.common.no-related-record': 'No Related Records',
}
