import EM from './event-emitter.js';
import {PUSH} from '../components/alert-emitter/events';
import {SHOW, HIDE} from '../components/page-loader/events';

import LocalStorage from './local-storage';
import i18n from './i18n';


/**
 * Wrapper for native fetch() method
 *
 * @param url [String]
 * @param data [Object | Array]
 * - for GET method: data will be converted to query string and must be Object (pairs name/value)
 * - for POST method: data will be stringify to JSON and may be any type of data
 * @param method [String] default 'GET'
 * @param loading [Boolean] default false - if true: global page loader will shown during request process
 * @param cacheType [false | 'session' | {ageCount, ageUnit}] default false - set caching for specific url. Required method GET
 * @return Promise
 */
function Query(url, data, method = 'GET', loading = false, cacheType = false) {
    //
    // process Headers
    //
    let headers = new Headers();

    // Content Type
    headers.set('Content-Type', 'application/json');


    // CSRF header
    let csrfHeaderName = document.querySelector('meta[name=_csrf_header]').content;
    let csrfHeaderValue = document.querySelector('meta[name=_csrf]').content;

    headers.set(csrfHeaderName, csrfHeaderValue);


    //
    // process Query-String for GET
    //
    if (method === 'GET' && data) {
        url += '?'+ Object.keys(data).map((key) => (encodeURIComponent(key) + '=' + encodeURIComponent(data[key]))).join('&');
    }


    //
    // process INIT
    //
    let init = {
        headers,
        method
    };


    //
    // process BODY for POST
    //
    if (method === 'POST' && data)
        init.body = typeof data === 'string' ? data : JSON.stringify(data);

    //
    // process Loading
    //
    if (loading) EM.$emit(SHOW);


    //
    // process caching
    //
    if (method === 'GET' && cacheType) {
        let cachedData = null;
        if (cacheType === 'session') {
            cachedData = LocalStorage.getSessionCache(url);
        }
        if (typeof cacheType === 'object') {
            cachedData = LocalStorage.getDatedCache(url, cacheType);
        }

        if (cachedData) {
            if (loading) EM.$emit(HIDE);
            return Promise.resolve(cachedData);
        }
    }


    return fetch(url, init)
        //
        // process standard http/fetch response
        //
        .then(response => {
            if (loading) EM.$emit(HIDE);

            if (response.ok) {
                return response.json();

            } else {
                console.log(response);
                throw new Error(
                    i18n.tdef('message', 'label.http.response-status') +': '+response.status

                    +(response.statusText &&
                        ', '+i18n.tdef('response', 'label.http.response-message') +': '+response.statusText
                    )
                );

            }
        })
        //
        // process business logic response
        //
        .then(json => {
            if (json.isSuccessful) {

                // process caching
                if (method === 'GET' && cacheType) {
                    if (cacheType === 'session') {
                        LocalStorage.setSessionCache(url, json.returnedObject);
                    }
                    if (typeof cacheType === 'object') {
                        LocalStorage.setDatedCache(url, json.returnedObject);
                    }
                }

                return json.returnedObject;

            } else {
                console.log(json);
                throw new Error(
                    json.messages.length > 0 ? json.messages.join(', ') : i18n.tdef('API query error', 'message.api.undefined-error')
                );
            }
        })
        //
        // process any errors from response and 2 "then" above
        //
        .catch(error => {
            let message = `
                <h2 class="slds-text-heading_small">`+i18n.tdef('ERROR', 'label.common.error-title')+`</h2>
                <p>${error.message}</p>
            `;
            EM.$emit(PUSH, {
                type: 'error',
                message
            });

            throw error;
        });
}

export default Query;
