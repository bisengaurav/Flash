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
            return Query('/ui-api/workCenter/getById', {id});
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
            return Query('/ui-api/case/getUniqueSalesOrganizations');
        },
        getUniqueMaintenanceActivityTypeCodes: () => {
            return Query('/ui-api/case/getUniqueMaintenanceActivityTypeCodes');
        },
        getUniqueAssemblies: () => {
            return Query('/ui-api/case/getUniqueAssemblies');
        }
    },
    serviceAppointment: {
        getById: (id) => {
            return Query('/ui-api/serviceAppointment/getById', {id});
        },
        getUniqueStatuses: () => {
            return Query('/ui-api/serviceAppointment/getUniqueStatuses');
        } 
    },
    workOrder: {
        getById: (id) => {
            return Query('/ui-api/workOrder/getById', {id});
        }
    }
};

export default API;
