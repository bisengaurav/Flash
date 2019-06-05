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
/*
import PeriodDuration from './components/period-duration.vue';
Vue.component('PeriodDuration', PeriodDuration);
*/
import CollapsibleSection from './components/collapsible-section.vue';
Vue.component('CollapsibleSection', CollapsibleSection);

import BackButton from './components/back-button.vue';
Vue.component('BackButton', BackButton);

import FormElement from './components/form-element.vue';
Vue.component('FormElement', FormElement);

import DataTableBasic from './components/data-table-basic.vue';
Vue.component('DataTableBasic', DataTableBasic);
/*
import DataTablePagination from './components/data-table-pagination.vue';
Vue.component('DataTablePagination', DataTablePagination);
*/
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

import VueI18n from 'vue-i18n';
Vue.use(VueI18n);

import DateService from './core/date-service.js';
Vue.use(DateService);

import LocalStorage from './core/local-storage';
Vue.use(LocalStorage);

import router from './core/router.js'; // contains Vue.use()

import store from './store'; // contains Vue.use()



//
// global |formats and $functions()
//

import numeral from 'numeral';
Vue.filter("formatNumber", function(value, format) {
    return numeral(value).format(format || '0,0');
});

Vue.filter("yesNo", function(value) {
    if (value) return 'Yes';
    if (value === false) return 'No';
    return '';
});



//
// load top level data and init app
//

import app from './components/app.vue';

import messagesCmp from './core/tmp-lang-components.js';
import messagesPages from './core/tmp-lang-pages.js';

// load session data

API.session.getInfo()
    .then(session => {
        // save session data to Store
        store.commit('setSession', session);


        // init Localization

        if (!store.state.$lang)
            throw new Error("Can't resolve language settings");

        const i18n = new VueI18n({
            silentTranslationWarn: (process.env.NODE_ENV === 'production'),
            silentFallbackWarn: (process.env.NODE_ENV === 'production'),
            locale: store.state.$lang,
            /*messages: {
                [store.state.$lang]: {}
            },*/
            dateTimeFormats: {
                [store.state.$lang]: {
                    date: {
                        timeZone: store.state.$timezone,
                        year: 'numeric', month: '2-digit', day: '2-digit'
                    },
                    datetime: {
                        timeZone: store.state.$timezone,
                        year: 'numeric', month: '2-digit', day: '2-digit',
                        hour: 'numeric', minute: 'numeric'
                    },
                    time: {
                        timeZone: store.state.$timezone,
                        hour: 'numeric', minute: 'numeric'
                    }
                }
            },
            missing: (locale, key, vm) => {
                return '...';
            }
        });


        // create $d alias function

        Vue.prototype.$dtz = function(value, key) {
            if (!value) return '';

            var date = Date.parse(value);
            if (!date || typeof date != 'number' || date === NaN) return '';

            return i18n.d(date, key);
        };


        // check cached language data

        let cachedLangData = null;
        if (store.state.$langVersion)
            cachedLangData = LocalStorage.getVersionedCache(store.state.$lang, store.state.$langVersion);

        if (cachedLangData) {
            // no cached data or no lang version
            i18n.setLocaleMessage(store.state.$lang, cachedLangData);

        } else {
            // async load language data

            API.i18n.getLanguageData(session.l10nParams.languageCode)
                .then(data => {
                    if (!data.stringsMap)
                        throw new Error("Can't resolve language data");

                    i18n.setLocaleMessage(
                        store.state.$lang,
                        Object.assign({}, messagesCmp, messagesPages, data.stringsMap)
                    );
                    LocalStorage.setVersionedCache(
                        store.state.$lang,
                        data.stringsHashCode,
                        Object.assign({}, messagesCmp, messagesPages, data.stringsMap)
                    );
                });
        }


        // init APP

        new Vue({
            el: '#app',
            render: h => h(app),
            router,
            store,
            i18n
        });


    });
