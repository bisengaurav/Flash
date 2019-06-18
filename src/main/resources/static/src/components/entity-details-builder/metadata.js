import API from '../../core/api';

export const Asset = {
    title: 'name',
    action: API.asset.getById,

    fields: [
        {
            field: 'equipmentTypeValue',
            type: 'text'
        },
        {
            field: 'fsmLastValidCliEndDate__c',
            type: 'yn'
        },
        {
            field: 'customerAssetName__c',
            type: 'text'
        },
        {
            field: 'accountId',
            type: 'text'
        },
        {
            field: 'accountName',
            type: 'text'
        },
        {
            field: 'soldToId',
            type: 'text'
        },
        {
            field: 'soldToName',
            type: 'text'
        },
        {
            field: 'installationCity__c',
            type: 'text'
        },
        {
            field: 'installationCountry__c',
            type: 'text'
        },
        {
            field: 'locationName',
            type: 'text'
        },
        {
            field: 'serviceTerritoryName',
            type: 'link',
            to: 'serviceTerritory',
            id: 'serviceTerritoryId'
        },
        {
            field: 'workCenterName',
            type: 'link',
            to: 'workCenter',
            id: 'workCenterId'
        }
    ],

    relations: [
        {
            title: 'text.asset.related-entitlements',
            dataField: 'activeEntitlements',
            entity: 'Entitlement',
            fields: [
                {
                    field: 'name',
                    type: 'text'
                },
                {
                    field: 'coverage__c',
                    type: 'text'
                },
                {
                    field: 'startDate',
                    type: 'datetime'
                },
                {
                    field: 'endDate',
                    type: 'datetime'
                },
                {
                    field: 'status',
                    type: 'text'
                },
                {
                    field: 'responseTime__c',
                    type: 'text'
                },
                {
                    field: 'responseTimeAfterHours__c',
                    type: 'text'
                },
                {
                    field: 'calloutHours__c',
                    type: 'text'
                },
                {
                    field: 'serviceHours__c',
                    type: 'text'
                },
            ]
        }
    ]
}

export const Callout = {
    title: 'caseNumber',
    action: API.case.getById,
    fields: [
        {
            field: 'status',
            type: 'text'
        },
        {
            field: 'caseOwnerTxt__c',
            type: 'text'
        },
        {
            field: 'createdDate',
            type: 'datetime'
        },
        {
            field: 'entrapment__c',
            type: 'yn'
        },
        {
            field: 'hazard__c',
            type: 'yn'
        },
        {
            field: 'injury__c',
            type: 'yn'
        },
        {
            field: 'assetName',
            type: 'link',
            to: 'asset',
            id: 'assetId'
        },
        {
            field: 'accountId',
            type: 'text'
        },
        {
            field: 'accountName',
            type: 'text'
        },
        {
            field: 'contactName',
            type: 'text'
        },
        {
            field: 'contactPhone',
            type: 'text'
        },
        {
            field: 'callerName__c',
            type: 'text'
        },
        {
            field: 'callerPhoneNumber__c',
            type: 'text'
        },
        {
            field: 'fsmContactIsPassenger__c',
            type: 'yn'
        },
        {
            field: 'salesOrganizations__c',
            type: 'text'
        },
        {
            field: 'subject',
            type: 'text'
        },
        {
            field: 'description',
            type: 'text'
        },
    ],
    relations: [
        {
            title: 'text.case.related-work-orders',
            dataField: 'workOrders',
            entity: 'WorkOrder',
            fields: [
                {
                    field: 'workOrderNumber',
                    type: 'link',
                    to: 'workOrder',
                    id: 'id'
                },
                {
                    field: 'status',
                    type: 'text'
                },
                {
                    field: 'earliestStartDate__c',
                    type: 'datetime'
                },
                {
                    field: 'dueDate__c',
                    type: 'datetime'
                }
            ]
        }
    ]

}

export const ServiceAppointment = {
    title: 'appointmentNumber',
    action: API.case.getById,
    fields: [
        {
            field: 'status',
            type: 'text'
        },
        {
            field: 'lastModifiedDate',
            type: 'datetime'
        },
        {
            field: 'scheduledStartOriginal__c',
            type: 'datetime'
        },
        {
            field: 'dueDate__c',
            type: 'datetime'
        },
        {
            field: 'fslPinned__c',
            type: 'yn'
        },
        {
            field: 'blockedReason__c',
            type: 'text'
        },
        {
            field: 'accountId',
            type: 'text'
        },
        {
            field: 'accountName',
            type: 'text'
        },
        {
            field: 'serviceResourceName',
            type: 'link',
            to: 'serviceResource',
            id: 'serviceResourceId'
        },
        {
            field: 'workOrderNumber',
            type: 'link',
            to: 'workOrder',
            id: 'workOrderId'
        },
        {
            field: 'assetName',
            type: 'link',
            to: 'asset',
            id: 'assetId'
        },
        {
            field: 'serviceTerritoryName',
            type: 'link',
            to: 'serviceTerritory',
            id: 'serviceTerritoryId'
        },
        {
            field: 'salesOrganization__c',
            type: 'text'
        }
    ]
}

export const ServiceResource = {
    action: API.serviceResource.getById,
    fields: [
        {
            field: 'phone__c',
            type: 'text'
        },
        {
            field: 'salesOrganization__c',
            type: 'text'
        }
    ],
    relations: [
        {
            title: 'text.service-resource.related-territories',
            dataField: 'serviceResourceTerritories',
            entity: 'ServiceTerritoryMember',
            fields: [
                {
                    field: 'name',
                    type: 'link',
                    to: 'serviceTerritory',
                    id: 'id'
                },
                {
                    field: 'territoryType',
                    type: 'text'
                },
                {
                    field: 'shiftType__c',
                    type: 'text'
                },
                {
                    field: 'effectiveStartDate',
                    type: 'datetime'
                },
                {
                    field: 'effectiveEndDate',
                    type: 'datetime'
                }
            ]
        },
        {
            title: 'text.service-resource.related-work-centers',
            dataField: 'serviceResourceWorkCenters',
            entity: 'WorkCenterResource',
            fields: [
                {
                    field: 'name',
                    type: 'link',
                    to: 'workCenter',
                    id: 'id'
                }
            ] 
        },
        {
            title: 'text.service-resource.related-absences',
            dataField: 'resourceAbsences',
            entity: 'ResourceAbsence',
            fields: [
                {
                    field: 'start',
                    type: 'datetime'
                },
                {
                    field: 'end',
                    type: 'datetime'
                },
                {
                    field: 'recordType__c',
                    type: 'text'
                },
                {
                    field: 'type',
                    type: 'text'
                }
            ]
        },
        {
            title: 'text.service-resource.related-appointments',
            dataField: 'serviceResourceAppointments',
            entity: 'ServiceAppointment',
            fields: [
                {
                    field: 'appointmentNumber',
                    type: 'link',
                    to: 'serviceAppointment',
                    id: 'id'
                },
                {
                    field: 'status',
                    type: 'text'
                },
                {
                    field: 'scheduledStartOriginal__c',
                    type: 'datetime'
                },
                {
                    field: 'scheduledEndOriginal__c',
                    type: 'datetime'
                },
                {
                    field: 'fslPinned__c',
                    type: 'yn'
                },
                {
                    field: 'workOrderNumber',
                    type: 'link',
                    to: 'workOrder',
                    id: 'workOrderId'
                },
                {
                    field: 'earliestStartDate__c',
                    type: 'datetime'
                },
                {
                    field: 'dueDate__c',
                    type: 'datetime'
                },
                {
                    field: 'maintenanceActivityType__c',
                    type: 'text'
                },
                {
                    field: 'assembly__c',
                    type: 'text'
                },
                {
                    field: 'locationName',
                    type: 'text'
                },
                {
                    field: 'installationStreet__c',
                    type: 'text'
                },
                {
                    field: 'installationCity__c',
                    type: 'text'
                },
                {
                    field: 'description__c',
                    type: 'text'
                }
            ]
        }
    ]

}

export const ServiceTerritory = {
    action: API.serviceTerritory.getById,
    fields: [
        {
            field: 'salesOrganization__c',
            type: 'text'
        }
    ],
    relations: [
        {
            title: 'text.service-territory.related-service-resources',
            dataField: 'activeServiceTerritoryResources',
            entity: 'ServiceTerritoryMember',
            fields: [
                {
                    field: 'effectiveStartDate',
                    type: 'datetime'
                },
                {
                    field: 'effectiveEndDate',
                    type: 'datetime'
                },
                {
                    field: 'serviceResource_name',
                    type: 'link',
                    to: 'serviceResource',
                    id: 'serviceResource_id'
                },
                {
                    field: 'phone__c',
                    type: 'text'
                }
            ]
        }
    ]
}

export const WorkCenter = {
    action: API.workCenter.getById,

    relations: [
        {
            title: 'text.work-center.related-service-resources',
            dataField: 'workCenterResources',
            entity: 'WorkCenterResource',
            fields: [
                {
                    field: 'serviceResourceName',
                    type: 'link',
                    to: 'serviceResource',
                    id: 'serviceResourceId'
                },
                {
                    field: 'workCenterName',
                    type: 'text'
                },
                {
                    field: 'workTypeName',
                    type: 'text'
                },
                {
                    field: 'preferenceType__c',
                    type: 'text'
                },
                {
                    field: 'startDate__c',
                    type: 'datetime'
                },
                {
                    field: 'endDate__c',
                    type: 'datetime'
                }
            ]
        }
    ]
}

export const WorkOrder = {
    title: 'workOrderNumber',
    action: API.workOrder.getById,
    fields: [
        {
            field: 'status',
            type: 'text'
        },
        {
            field: 'lastModifiedDate',
            type: 'datetime'
        },
        {
            field: 'earliestStartDate__c',
            type: 'datetime'
        },
        {
            field: 'dueDate__c',
            type: 'datetime'
        },
        {
            field: 'caseNumber',
            type: 'link',
            to: 'case',
            id: 'caseId'
        },
        {
            field: 'maintenanceActivityTypeCode__c',
            type: 'text'
        },
        {
            field: 'assembly__c',
            type: 'text'
        },
        {
            field: 'assetName',
            type: 'link',
            to: 'asset',
            id: 'assetId'
        },
        {
            field: 'accountId',
            type: 'text'
        },
        {
            field: 'accountName',
            type: 'text'
        },
        {
            field: 'locationName',
            type: 'text'
        },
        {
            field: 'serviceTerritoryName',
            type: 'link',
            to: 'serviceTerritory',
            id: 'serviceTerritoryId'
        },
        {
            field: 'sales_organization__c',
            type: 'text'
        },
        {
            field: 'description__c',
            type: 'text'
        }
    ],
    relations: [
        {
            title: 'text.work-order.related-appointments',
            dataField: 'serviceAppointments',
            entity: 'ServiceAppointment',
            fields: [
                {
                    field: 'appointmentNumber',
                    type: 'link',
                    to: 'serviceAppointment',
                    id: 'id'
                },
                {
                    field: 'serviceResourceName',
                    type: 'link',
                    to: 'serviceResource',
                    id: 'serviceResourceId'
                },
                {
                    field: 'scheduledStartOriginal__c',
                    type: 'datetime'
                },
                {
                    field: 'scheduledEndOriginal__c',
                    type: 'datetime'
                }
            ]
        }
    ]
}
