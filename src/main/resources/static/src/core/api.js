import Query from './query.js';

//
// API methods
//
let API = {
    equipment: {
        getAllByFilter: (params) => {
            return Query('/ui-api/equipment/getAllByFilter', params, 'GET', true, {ageCount: 10, ageUnit: 'm'});
        },
        getById: (id) => {
            return Query('/ui-api/equipment/getById', {id});
        },
        getUniqueCountries: () => {
            return Query('/ui-api/equipment/getUniqueCountries', null, 'GET', false, 'session');
        },
        getEquipmentTypes: () => {
            return Query('/ui-api/equipment/getUniqueEquipmentTypes', null, 'GET', false, 'session');
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
            return Query('/ui-api/case/getUniqueSalesOrganizations', null, 'GET', false, 'session');
        },
        getUniqueMaintenanceActivityTypeCodes: () => {
            return Query('/ui-api/case/getUniqueMaintenanceActivityTypeCodes', null, 'GET', false, 'session');
        },
        getUniqueAssemblies: () => {
            return Query('/ui-api/case/getUniqueAssemblies', null, 'GET', false, 'session');
        }
    },
    serviceResource: {
        getById: (id) => {
            return Query('/ui-api/serviceResource/getById', {id});
        },
        getAllByFilter: (params) => {
            return Query('/ui-api/serviceResource/getAllByFilter', params, 'GET', true);
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
    serviceAppointment: {
        getById: (id) => {
            return Query('/ui-api/serviceAppointment/getById', {id});
        },
        getUniqueStatuses: () => {
            return Query('/ui-api/serviceAppointment/getUniqueStatuses', null, 'GET', false, 'session');
        }
    },
    workOrder: {
        getById: (id) => {
            return Query('/ui-api/workOrder/getById', {id});
        }
    },
    user: {
        getUserInfo: (id) => {
            return Query('/ui-api/user/getUserInfo');
        }
    },


    session: {
        getInfo: () => {
            return Query('/ui-api/session/getInfo');
        }
    },
    i18n: {
        getL10nData: (languageCode, countryCode) => {
            return Query('/ui-api/i18n/getL10nData', {languageCode, countryCode});
        },
        getLanguageData: (languageCode) => {
            return Query('/ui-api/i18n/getLanguageData', {languageCode});
        }

    }
};

export default API;
