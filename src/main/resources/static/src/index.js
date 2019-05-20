//
// import all CSS
//
import '../assets/css/slds-addons.css';
import '../assets/css/slds-branding.css';
import '../assets/css/slds-fontawesome-svg.css';
import '../assets/css/z-levels.css';


//
// import Vue.js
//
import Vue from 'vue';



//
// init global Links to services
//
import API from './core/api.js';
Vue.prototype.$API = API;

import EM from './core/event-emitter.js';
Vue.prototype.$EM = EM;



//
// global Components
//
import Modal from './components/modal.vue';
Vue.component('Modal', Modal);

import Spinner from './components/spinner.vue';
Vue.component('Spinner', Spinner);

import Loader from './components/loader.vue';
Vue.component('Loader', Loader);

import Alert from './components/alert.vue';
Vue.component('Alert', Alert);

import SelectLoader from './components/select-loader.vue';
Vue.component('SelectLoader', SelectLoader);

import Checkbox from './components/checkbox.vue';
Vue.component('Checkbox', Checkbox);

import CheckboxToggle from './components/checkbox-toggle.vue';
Vue.component('CheckboxToggle', CheckboxToggle);

import PeriodDuration from './components/period-duration.vue';
Vue.component('PeriodDuration', PeriodDuration);

import CollapsibleSection from './components/collapsible-section.vue';
Vue.component('CollapsibleSection', CollapsibleSection);

import BackButton from './components/back-button.vue';
Vue.component('BackButton', BackButton);

import FormElement from './components/form-element.vue';
Vue.component('FormElement', FormElement);

import DataTableBasic from './components/data-table-basic.vue';
Vue.component('DataTableBasic', DataTableBasic);

import DataTablePagination from './components/data-table-pagination.vue';
Vue.component('DataTablePagination', DataTablePagination);

import Popover from './components/popover.vue';
Vue.component('Popover', Popover);

import Dropdown from './components/dropdown.vue';
Vue.component('Dropdown', Dropdown);

import Tooltip from './components/tooltip.vue';
Vue.component('Tooltip', Tooltip);

import HelpPointer from './components/help-pointer.vue';
Vue.component('HelpPointer', HelpPointer);



//
// global Modules
//
import Vuelidate from 'vuelidate';
Vue.use(Vuelidate);

import Prompt from './components/prompt.vue';
Vue.use(Prompt);



//
// global Formats
//
import DateService from './core/date-service.js';
Vue.filter("formatDate", function(value, format, useLocal) {
    return DateService.formatUTCDateToLocal({
        date: value,
        format,
        useLocal
    });
});

import numeral from 'numeral';
Vue.filter("formatNumber", function(value, format) {
    return numeral(value).format(format || '0,0');
});



//
// import root Vue component (App.vue) and Routes instanse
// init app
//
import router from './core/router.js';
import app from './components/app.vue';

new Vue({
    el: '#app',
    render: h => h(app),
    router
});
