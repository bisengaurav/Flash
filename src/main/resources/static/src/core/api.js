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
    }
};

export default API;
