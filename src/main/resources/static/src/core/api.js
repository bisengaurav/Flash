import Query from './query.js';

//
// API methods
//
let API = {
    asset: {
        getAllByFilter: (params) => {
            return Query('/ui-api/asset/getAllByFilter', params);
        },
        getById: (id) => {
            return Query('/ui-api/asset/getById', {id});
        },
        getUniqueCountries: () => {
            return Query('/ui-api/asset/getUniqueCountries', null, 'GET', false, 'session', false);
        },
        getEquipmentTypes: () => {
            return Query('/ui-api/asset/getUniqueEquipmentTypes', null, 'GET', false, 'session');
        },
        getUniqueSalesOrganizations: () => {
            return Query('/ui-api/asset/getUniqueSalesOrganizations', null, 'GET', false, 'session');
        }
    },
    case: {
        getById: (id) => {
            return Query('/ui-api/case/getById', {id});
        }
    },
    callout: {
        getAllByFilter: (params) => {
            return Query('/ui-api/callout/getAllByFilter', params);
        },
        getUniqueSalesOrganizations: () => {
            return Query('/ui-api/callout/getUniqueSalesOrganizations', null, 'GET', false, 'session');
        },
        getUniqueMaintenanceActivityTypeCodes: () => {
            return Query('/ui-api/callout/getUniqueMaintenanceActivityTypeCodes', null, 'GET', false, 'session');
        },
        getUniqueAssemblies: () => {
            return Query('/ui-api/callout/getUniqueAssemblies', null, 'GET', false, 'session');
        },
        getUniqueStatuses: () => {
            return Query('/ui-api/callout/getUniqueStatuses', null, 'GET', false, 'session');
        },
        getUniqueSAStatuses: () => {
            return Query('/ui-api/callout/getUniqueSAStatuses', null, 'GET', false, 'session');
        }
    },
    serviceResource: {
        getById: (id) => {
            return Query('/ui-api/serviceResource/getById', {id});
        },
        getAllByFilter: (params) => {
            return Query('/ui-api/serviceResource/getAllByFilter', params);
        },
        getUniqueSalesOrganizations: () => {
            return Query('/ui-api/serviceResource/getUniqueSalesOrganizations', null, 'GET', false, 'session');
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
        }
    },
    workOrder: {
        getById: (id) => {
            return Query('/ui-api/workOrder/getById', {id});
        }
    },
    user: {
        getUserInfo: () => {
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
