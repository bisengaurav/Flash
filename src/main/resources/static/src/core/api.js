import Query from './query.js';

//
// API methods
//
let API = {
    constants: {
        jobActions: () => {
            return Query('/ui-api/constants/jobActions');
        },
        jobStatuses: () => {
            return Query('/ui-api/constants/jobStatuses');
        },
        jobVolumes: () => {
            return Query('/ui-api/constants/jobVolumes');
        },
        managementTypes: () => {
            return Query('/ui-api/constants/managementTypes');
        },
        userRoles: () => {
            return Query('/ui-api/constants/userRoles');
        },
        soqlQueryTypes: () => {
            return Query('/ui-api/constants/soqlQueryTypes');
        },
        baseSfUrl: () => {
            return Query('/ui-api/constants/baseSfUrl');
        }
    },

    appSettings: {
        getBasic: () => {
            return Query('/ui-api/appSettings/getBasic');
        },
        saveBasic: (data) => {
            return Query('/ui-api/appSettings/saveBasic', data, 'POST', true);
        },
        getSfUserCredentials: () => {
            return Query('/ui-api/appSettings/getSfUserCredentials');
        },
        saveSfUserCredentials: (data) => {
            return Query('/ui-api/appSettings/saveSfUserCredentials', data, 'POST', true);
        }
    },

    objectConfig: {
        getAll: () => {
            return Query('/ui-api/sfObjectInfo/getAll');
        },
        getByName: (objectName) => {
            return Query('/ui-api/sfObjectInfo/getByName', {objectName});
        },
        save: (data) => {
            return Query('/ui-api/sfObjectInfo/save', data, 'POST', true);
        },
        deleteByName: (data) => {
            return Query('/ui-api/sfObjectInfo/deleteByName', data, 'POST', true);
        },
        getAllSfObjectsNames: () => {
            return Query('/ui-api/sfObjectInfo/getAllSfObjectsNames');
        }
    },

    archiverConfig: {
        getSupportedSfObjects: () => {
            return Query('/ui-api/archiverConfig/getSupportedSfObjects');
        }
    },

    userManagement: {
        getAll: () => {
            return Query('/ui-api/userInfo/getAll');
        },
        getRoles: () => {
            return Query('ui-api/constants/userRoles');
        },
        getById: (id) => {
            return Query('/ui-api/userInfo/getById', {id});
        },
        saveUser: (data) => {
            return Query('/ui-api/userInfo/save', data, 'POST', true);
        },
        deleteUserById: (data) => {
            return Query('/ui-api/userInfo/deleteById', data, 'POST', true);
        }
    },

    job: {
        getAll: () => {
            return Query('/ui-api/job/getAll');
        },
        getAllByFilter: (params) => {
            return Query('/ui-api/job/getAllByFilter', params);
        },
        getById: (id) => {
            return Query('/ui-api/job/getById', {id});
        },
        startNewByJobConfigId: (data) => {
            return Query('/ui-api/job/startNewByJobConfigId', data, 'POST', true);
        },
        continueFailedJob: (data) => {
            return Query('/ui-api/job/continueFailedJob', data, 'POST', true);
        },
        getJobTransactionLogsByJobId: (jobId) => {
            return Query('/ui-api/job/getJobTransactionLogsByJobId', {jobId});
        }
    },

    jobConfig: {
        getAll: () => {
            return Query('/ui-api/jobConfig/getAll');
        },
        getById: (id) => {
            return Query('/ui-api/jobConfig/getById', {id});
        },
        save: (data) => {
            return Query('/ui-api/jobConfig/save', data, 'POST', true);
        },
        deleteById: (data) => {
            return Query('/ui-api/jobConfig/deleteById', data, 'POST', true);
        },
        checkSqlCondition: (data) => {
            return Query('/ui-api/jobConfig/checkSqlCondition', data, 'POST', true);
        },
        getWarningsForNewMngmntType: (data) => {
            return Query('/ui-api/jobConfig/getWarningsForNewMngmntType', data, 'POST', true);
        }
    },

    scheduledJob: {
        getById: (id) => {
            return Query('/ui-api/scheduledJob/getById', {id});
        },
        getByJobConfigId: (jobConfigId) => {
            return Query('/ui-api/scheduledJob/getByJobConfigId', {jobConfigId});
        },
        save: (data) => {
            return Query('/ui-api/scheduledJob/save', data, 'POST', true);
        },
        deleteById: (data) => {
            return Query('/ui-api/scheduledJob/deleteById', data, 'POST', true);
        },
        startById: (data) => {
            return Query('/ui-api/scheduledJob/startById', data, 'POST', true);
        },
        stopById: (data) => {
            return Query('/ui-api/scheduledJob/stopById', data, 'POST', true);
        }
    },

    relationships: {
        getByObjectName_Lazy: (params) => {
            return Query('/ui-api/relationships/getByObjectName_Lazy', params);
        },
        getAllByObjectName_LM: (params) => {
            return Query('/ui-api/relationships/getAllByObjectName_LM', params);
        },
        save: (data) => {
            return Query('/ui-api/relationships/save', data, 'POST', true);
        }
    }
};

export default API;
