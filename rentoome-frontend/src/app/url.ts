export const PROPERTIES_SERVICE_ROOT_PATH: string = '/api/v1/property-service/';
export const AUTH_SERVICE_ROOT_PATH: string = '/api/v1/auth/';

export const urls = {
    /******************  PROPERTY MODULE ********************/
    //PropertyTypes services
    GET_PROPERTY_TYPES: PROPERTIES_SERVICE_ROOT_PATH + 'tproperties',
    ADD_PROPERTY_TYPES: PROPERTIES_SERVICE_ROOT_PATH + 'tproperties/add',
    EDIT_PROPERTY_TYPES: PROPERTIES_SERVICE_ROOT_PATH + 'tproperties/update/',
    DELETE_PROPERTY_TYPES: PROPERTIES_SERVICE_ROOT_PATH + 'tproperties/delete/',
    FIND_PROPERTY_TYPE: PROPERTIES_SERVICE_ROOT_PATH + 'tproperties/find/',

    //Properties services
    GET_PROPERTIES: PROPERTIES_SERVICE_ROOT_PATH + 'properties',
    ADD_PROPERTIES: PROPERTIES_SERVICE_ROOT_PATH + 'properties/add',
    EDIT_PROPERTIES: PROPERTIES_SERVICE_ROOT_PATH + 'properties/update/',
    DELETE_PROPERTIES: PROPERTIES_SERVICE_ROOT_PATH + 'properties/delete/',
    FIND_PROPERTY: PROPERTIES_SERVICE_ROOT_PATH + 'properties/find/',

    //USER MODULE
    //AUTHENTIFICATION
    LOGIN: AUTH_SERVICE_ROOT_PATH + "login",
    DEFAULT_LANGUAGE: 'fr',
} as const;

