import Vue from 'vue';
import Vuex from 'vuex';

//
// install plugin
//

Vue.use(Vuex);


//
// create config
//

let storeConfig = {
    state: {
        $sessionId: null,
        $user: null,
        $country: null,
        $lang: null,
        $langVersion: 0,
        $timezone: null
    },

    mutations: {
        setSession(state, session) {
            state.$sessionId = session.sessionId;
            state.$user = session.userInfo;
            if (session.l10nParams) {
                state.$country = session.l10nParams.countryCode;
                state.$lang = session.l10nParams.languageCode.replace('_', '-');
                state.$langVersion = session.l10nParams.languageDataHashCode;
                state.$timezone = session.l10nParams.timeZoneId;
            }
        }
    }
};


Vue.mixin({
    computed: {
        ...Vuex.mapState([
            '$sessionId',
            '$user',
            '$country',
            '$lang',
            '$langVersion',
            '$timezone'
        ])
    }
});



//
// init CONST and export
//

const store = new Vuex.Store(storeConfig);

export default store;
