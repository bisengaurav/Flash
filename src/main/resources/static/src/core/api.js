import Query from './query.js';

//
// API methods
//
let API = {
    equipmentApi: {
        getAllByFilter: (params) => {
            return Query('/ui-api/equipment/getAllByFilter', params);
        },
        getById: (id) => {
            return Query('/ui-api/equipment/getById', {id});
        },
        getUniqueCountries: () => {
            return Query('/ui-api/equipment/getUniqueCountries');
        },
        getEquipmentTypes: () => {
            return Query('/ui-api/equipment/getEquipmentTypes');
        }
    }
};

export default API;
