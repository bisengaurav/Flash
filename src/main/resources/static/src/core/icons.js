import Vue from 'vue';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';
import {config, library} from '@fortawesome/fontawesome-svg-core';

config.autoAddCss = false;
Vue.component('icon', FontAwesomeIcon);


export default library;
