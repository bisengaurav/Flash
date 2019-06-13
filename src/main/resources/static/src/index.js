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
// GLOBAL Components
//

import Spinner from './components/spinner.vue';
Vue.component('Spinner', Spinner);

import Loader from './components/loader.vue';
Vue.component('Loader', Loader);

import Alert from './components/alert.vue';
Vue.component('Alert', Alert);

import SelectLoader from './components/select-loader.vue';
Vue.component('SelectLoader', SelectLoader);
/*
import Checkbox from './components/checkbox.vue';
Vue.component('Checkbox', Checkbox);

import CheckboxToggle from './components/checkbox-toggle.vue';
Vue.component('CheckboxToggle', CheckboxToggle);

import CollapsibleSection from './components/collapsible-section.vue';
Vue.component('CollapsibleSection', CollapsibleSection);
*/
import BackButton from './components/back-button.vue';
Vue.component('BackButton', BackButton);

import FormElement from './components/form-element.vue';
Vue.component('FormElement', FormElement);

import FormElementStatic from './components/form-element-static.vue';
Vue.component('FormElementStatic', FormElementStatic);

import DataTableBasic from './components/data-table-basic.vue';
Vue.component('DataTableBasic', DataTableBasic);
/*
import Popover from './components/popover.vue';
Vue.component('Popover', Popover);

import Dropdown from './components/dropdown.vue';
Vue.component('Dropdown', Dropdown);

import Tooltip from './components/tooltip.vue';
Vue.component('Tooltip', Tooltip);
/*
import HelpPointer from './components/help-pointer.vue';
Vue.component('HelpPointer', HelpPointer);
*/
import OutputField from './components/output-field.vue';
Vue.component('OutputField', OutputField);

//
// MARKUP Components
//

import Grid from './markup/grid.vue';
Vue.component('Grid', Grid);

import GridItem from './markup/grid-item.vue';
Vue.component('GridItem', GridItem);

import EntityDetailsLayout from './markup/entity-details-layout.vue';
Vue.component('EntityDetailsLayout', EntityDetailsLayout);

import EntityRelations from './markup/entity-relations.vue';
Vue.component('EntityRelations', EntityRelations);

import FiltersFormLayout from './markup/filters-form-layout.vue';
Vue.component('FiltersFormLayout', FiltersFormLayout);

import FiltersPageLayout from './markup/filters-page-layout.vue';
Vue.component('FiltersPageLayout', FiltersPageLayout);



//
// global Modules
//
import Vuelidate from 'vuelidate';
Vue.use(Vuelidate);

import Prompt from './components/prompt.vue';
Vue.use(Prompt);

import LocalStorage from './core/local-storage';
Vue.use(LocalStorage);

import i18n from './core/i18n'; // contains Vue.use()

import router from './core/router.js'; // contains Vue.use()

import store from './store'; // contains Vue.use()



//
// global |formats and $functions()
//
/*
import numeral from 'numeral';
Vue.filter("formatNumber", function(value, format) {
    return numeral(value).format(format || '0,0');
});
*/
Vue.filter("yesNo", function(value) {
    if (value) return i18n.t('label.common.yes');
    if (value === false) return i18n.t('label.common.no');
    return '';
});



//
// load top level data and init app
//

import App from './components/app.vue';
import AppLoader from './components/app-loader.vue';

let _lang = {};
import _text from './i18n/text.js';
import _label from './i18n/label.js';
import _message from './i18n/message.js';
import _entity from './i18n/entity.js';
import _filter from './i18n/filter.js';
_lang = Object.assign({}, _text, _label, _message, _entity, _filter);


//
// load session data
//

API.session.getInfo()
    .then(session => {
        // save session data to Store
        store.commit('setSession', session);


        // init Localization

        if (!store.state.$lang)
            throw new Error("Can't resolve language settings");

        i18n.locale = store.state.$lang;
        i18n.setDateTimeFormat(store.state.$lang, {
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
        });


        // check cached language data

        let cachedLangData = null;
        if (store.state.$langVersion)
            cachedLangData = LocalStorage.getVersionedCache(store.state.$lang, store.state.$langVersion);


        if (cachedLangData) {
            // no cached data or no lang version
            i18n.setLocaleMessage(store.state.$lang, cachedLangData);
            init();

        } else {
            createAppLoader();

            // async load language data

            API.i18n.getLanguageData(session.l10nParams.languageCode)
                .then(data => {
                    if (!data.stringsMap)
                        throw new Error("Can't resolve language data");

                    i18n.setLocaleMessage(
                        store.state.$lang,
                        Object.assign({}, _lang, data.stringsMap)
                    );
                    LocalStorage.setVersionedCache(
                        store.state.$lang,
                        data.stringsHashCode,
                        Object.assign({}, _lang, data.stringsMap)
                    );
                    init();
                });
        }
    });



// global init functions

function createAppLoader() {
    const loaderDiv = document.createElement('div');
    document.querySelector('#app').appendChild(loaderDiv);

    new Vue({
        el: loaderDiv,
        render: h => h(AppLoader)
    });
}

function init() {
    new Vue({
        el: '#app',
        render: h => h(App),
        router,
        store,
        i18n
    });
}
