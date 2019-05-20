import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);



let routes = [];

// Home
import Home from '../pages/home/';
routes.push({
    path: '/',
    name: 'home',
    component: Home
});


// Users
import Users from '../pages/users/';
routes.push({
    path: '/users',
    name: 'users',
    component: Users
});

import UserEdit from '../pages/users/edit.vue';
routes.push({
    path: '/user/:id',
    name: 'userEdit',
    component: UserEdit,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Callouts
import Callouts from '../pages/callouts/';
routes.push({
    path: '/callouts',
    name: 'callouts',
    component: Callouts
});


// Equipment
import Equipment from '../pages/equipment/';
routes.push({
    path: '/equipment',
    name: 'equipment',
    component: Equipment
});

import EquipmentDetails from '../pages/equipment/details.vue';
routes.push({
    path: '/equipment/:id',
    name: 'equipmentDetails',
    component: EquipmentDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Service Resources
import ServiceResources from '../pages/service-resources/';
routes.push({
    path: '/service-resources',
    name: 'serviceResources',
    component: ServiceResources
});

import ServiceResourceDetails from '../pages/service-resources/details.vue';
routes.push({
    path: '/service-resource/:id',
    name: 'serviceResource',
    component: ServiceResourceDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Case
import CaseDetails from '../pages/case/details.vue';
routes.push({
    path: '/case/:id',
    name: 'case',
    component: CaseDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Service Territory
import ServiceTerritoryDetails from '../pages/service-territory/details.vue';
routes.push({
    path: '/service-territory/:id',
    name: 'serviceTerritory',
    component: ServiceTerritoryDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Service Appointment
import ServiceAppointmentDetails from '../pages/service-appointment/details.vue';
routes.push({
    path: '/service-appointment/:id',
    name: 'serviceAppointment',
    component: ServiceAppointmentDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Work Center
import WorkCenterDetails from '../pages/work-center/details.vue';
routes.push({
    path: '/work-center/:id',
    name: 'workCenter',
    component: WorkCenterDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});


// Work Order
import WorkOrderDetails from '../pages/work-order/details.vue';
routes.push({
    path: '/work-order/:id',
    name: 'workOrder',
    component: WorkOrderDetails,
    props(route) {
        return {
            id: +route.params['id']
        }
    }
});




// 404
import NotFound from '../pages/404/';
routes.push({
    path: '/404',
    name: '404',
    component: NotFound
});

// ** redirect to 404 for invalid urls **
routes.push({
    path: '*',
    redirect: {name: '404'}
});

export default new VueRouter({
    routes,
    mode: 'history'
});


