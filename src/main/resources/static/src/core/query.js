import EM from './event-emitter.js';
import {PUSH} from '../components/alert-emitter/events';
import {SHOW, HIDE} from '../components/page-loader/events';

/**
 * Wrapper for native fetch() method
 *
 * @param url [String]
 * @param data [Object/Array]
 * - for GET method: data will be converted to query string and must be Object (pairs name/value)
 * - for POST method: data will be stringify to JSON and may be any type of data
 * @param method [String] default 'GET'
 * @param loading [Boolean] default false - if true: global page loader will shown during request process
 * @return Promise
 */
function Query(url, data, method = 'GET', loading = false) {
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
                    'status: ' +response.status
                    +(response.statusText && ', message: ' +response.statusText)
                );
            }
        })
        //
        // process business logic response
        //
        .then(json => {
            if (json.isSuccessful) {
                return json.returnedObject;

            } else {
                console.log(json);
                throw new Error(
                    json.messages.length > 0 ? json.messages.join(', ') : 'API query error'
                );
            }
        })
        //
        // process any errors from response and 2 "then" above
        //
        .catch(error => {
            console.log(error);

            let message = `
                <h2 class="slds-text-heading_small">ERROR</h2>
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
