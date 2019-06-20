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

import EntityDetailsBuilder from '../components/entity-details-builder/';

// Asset
routes.push({
    path: '/asset/:id',
    name: 'asset',
   component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'Asset',
            id: +route.params['id']
        }
    }
});

// Case
routes.push({
    path: '/case/:id',
    name: 'case',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'Case',
            id: +route.params['id']
        }
    }
});

// Service Resource
routes.push({
    path: '/service-resource/:id',
    name: 'serviceResource',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'ServiceResource',
            id: +route.params['id']
        }
    }
});

// Service Territory
routes.push({
    path: '/service-territory/:id',
    name: 'serviceTerritory',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'ServiceTerritory',
            id: +route.params['id']
        }
    }
});

// Service Appointment
routes.push({
    path: '/service-appointment/:id',
    name: 'serviceAppointment',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'ServiceAppointment',
            id: +route.params['id']
        }
    }
});

// Work Center
routes.push({
    path: '/work-center/:id',
    name: 'workCenter',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'WorkCenter',
            id: +route.params['id']
        }
    }
});

// Work Order
routes.push({
    path: '/work-order/:id',
    name: 'workOrder',
    component: EntityDetailsBuilder,
    props(route) {
        return {
            entity: 'WorkOrder',
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
