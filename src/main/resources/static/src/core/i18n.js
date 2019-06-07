import Vue from 'vue';
import VueI18n from 'vue-i18n';

//
// install plugin
//

Vue.use(VueI18n);


//
// init CONST and export
//

const i18n = new VueI18n({
    silentTranslationWarn: (process.env.NODE_ENV === 'production'),
    silentFallbackWarn: (process.env.NODE_ENV === 'production'),
    missing: (locale, key, vm) => {
        return '...';
    }
});

// check inited method

i18n.inited = function() {
    return !(i18n.messages[i18n.locale] === undefined);
};


// $t alias function with default value

i18n.tdef = function(defaultString, key, values) {
    if (i18n.inited()) {
        return i18n.t(key, values);
    } else {
        return defaultString;
    }
};

Vue.prototype.$tdef = i18n.tdef;



// $d alias function

Vue.prototype.$dtz = function(value, key) {
    if (!value) return '';

    var date = Date.parse(value);
    if (!date || typeof date != 'number' || date === NaN) return '';

    return i18n.d(date, key);
};


export default i18n;
