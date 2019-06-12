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
            dataField: 'activeSLAs',
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
                    field: 'startdate',
                    type: 'datetime'
                },
                {
                    field: 'enddate',
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
