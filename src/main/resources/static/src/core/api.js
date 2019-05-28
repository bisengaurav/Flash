import Query from './query.js';

//
// API methods
//
let API = {
    equipment: {
        getAllByFilter: (params) => {
            return Query('/ui-api/equipment/getAllByFilter', params, 'GET', true);
        },
        getById: (id) => {
            return Query('/ui-api/equipment/getById', {id});
        },
        getUniqueCountries: () => {
            return Query('/ui-api/equipment/getUniqueCountries');
        },
        getEquipmentTypes: () => {
            return Query('/ui-api/equipment/getUniqueEquipmentTypes');
        } 
    },
    workCenter: {
        getById: (id) => {
            return Query('/ui-api/workCenter__c/getById', {id});
        }
    },
    serviceTerritory: {
        getById: (id) => {
            return Query('/ui-api/serviceTerritory/getById', {id});
        }
    },
    case: {
        getById: (id) => {
            return Query('/ui-api/case/getById', {id});
        },
        getAllByFilter: (params) => {
            return Query('/ui-api/case/getAllByFilter', params, 'GET', true);
        },
        getUniqueSalesOrganizations: () => {
            return Query('/ui-api/equipment/getUniqueSalesOrganizations');
        },
        getUniqueStatuses: () => {
            return Query('/ui-api/equipment/getUniqueStatuses');
        } 
    }
};

export default API;
