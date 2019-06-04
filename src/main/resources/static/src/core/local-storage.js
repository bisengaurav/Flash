import moment from 'moment';
import store from '../store';


class LocalStorage {
    constructor() {
        // check if localStorage available
        this.isAvailable = this._checkStorage();
    }

    _checkStorage() {
        try {
            let storage = window.localStorage,
                x = '__test__';

            storage.setItem(x, x);
            storage.removeItem(x);

            return true;
        }

        catch(e) {
            return false;
        }
    }

    get(key) {
        if (!this.isAvailable) return null;

        let storage = window.localStorage;
        if (storage.getItem(key)) {
            return JSON.parse(storage.getItem(key));

        } else {
            storage.removeItem(key);
            return null;
        }
    }
    set(key, value) {
        if (!this.isAvailable) return null;

        let storage = window.localStorage;
        storage.setItem(key, JSON.stringify(value));
    }
    clear() {
        let storage = window.localStorage;
        storage.clear();
    }


    getVersionedCache(key, v) {
        if (!this.isAvailable) return null;

        let storage = window.localStorage,
            data = this.get(key);

        if (data && data.version && data.version === v) {
            return data.value;

        } else {
            storage.removeItem(key);
            return null;
        }
    }
    setVersionedCache(key, v, value) {
        if (!this.isAvailable) return null;

        this.set(key, {
            version: v,
            value: value
        });
    }

    getSessionCache(key) {
        if (!this.isAvailable || !store.state.$sessionId) return null;

        return this.getVersionedCache(key, store.state.$sessionId);
    }
    setSessionCache(key, value) {
        if (!this.isAvailable || !store.state.$sessionId) return null;

        this.setVersionedCache(key, store.state.$sessionId, value);
    }

    /*
    years       y
    quarters    Q
    months      M
    weeks       w
    days        d
    hours       h
    minutes     m
    seconds     s
    */
    getDatedCache(key, ageCount, ageUnit) {
        if (!this.isAvailable) return null;

        let storage = window.localStorage,
            data = this.get(key);

        if (data && data.date && moment(data.date) > moment().subtract(ageCount, ageUnit)) {
            return data.value;

        } else {
            storage.removeItem(key);
            return null;
        }

    }
    setDatedCache(key, value) {
        if (!this.isAvailable) return null;

        this.set(key, {
            date: moment(),
            value: value
        });
    }


    install(Vue) {
        Vue.prototype.$ls = this;
    }
}

export default new LocalStorage();
