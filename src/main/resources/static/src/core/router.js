import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);


//
// create config
//

let routes = [];


//
// Main Navigation pages
//

// Home
import Home from '../pages/home/';
routes.push({
    path: '/',
    name: 'home',
    component: Home
});

// Callouts Filters
import Callouts from '../pages/callout/';
routes.push({
    path: '/callouts',
    name: 'callouts',
    component: Callouts
});

// Assets Filters
import Assets from '../pages/asset/';
routes.push({
    path: '/assets',
    name: 'assets',
    component: Assets
});

// Service Resources Filters
import ServiceResources from '../pages/service-resource/';
routes.push({
    path: '/service-resources',
    name: 'serviceResources',
    component: ServiceResources
});

// Profile
import Profile from '../pages/profile/';
routes.push({
    path: '/profile',
    name: 'profile',
    component: Profile
});




//
// Entity Details pages
//

//import EntityDetailsBuilder from '../components/entity-details-builder/';


// Asset
import AssetDetails from '../pages/asset/details.vue';
routes.push({
    path: '/asset/:id',
    name: 'asset',
    component: AssetDetails,
//    component: EntityDetailsBuilder,
    props(route) {
        return {
//            entity: 'Asset',
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

// Service Resource
import ServiceResourceDetails from '../pages/service-resource/details.vue';
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




//
// 404
//

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



//
// init CONST and export
//

const router = new VueRouter({
    routes,
    mode: 'history'
});

export default router;
