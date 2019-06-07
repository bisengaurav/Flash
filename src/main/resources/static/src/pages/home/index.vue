<template>
    <section>

        <h1 class="slds-text-heading_large slds-m-bottom_large">Translation</h1>
        <p><b>Lang:</b> {{$lang}}</p>
        <p><b>Timezone:</b> {{$timezone}}</p>
        <br/>
        <p><b>date:</b> {{ $dtz(new Date(), 'date') }}</p>
        <p><b>datetime:</b> {{ $dtz(new Date(), 'datetime') }}</p>
        <p><b>time:</b> {{ $dtz(new Date(), 'time') }}</p>
        <br/><br/>

        <div class="slds-container_large">
            <h1 class="slds-text-heading_large slds-m-bottom_large">Branding</h1>

            <p class="slds-text-heading_medium slds-m-bottom_small">Medium Heading</p>
            <p class="slds-text-heading_small slds-m-bottom_small">Small Heading</p>

            <p class="slds-m-bottom_small">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis dolore ducimus, excepturi expedita illo impedit inventore ipsa minus, necessitatibus nemo neque placeat quas quod tempora tenetur veritatis voluptas voluptate voluptatem. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
            <p class="slds-text-color_weak slds-m-bottom_small">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
            <p class="slds-text-color_error slds-m-bottom_small">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
            <p class="slds-text-color_success slds-m-bottom_small">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>

            <alert type="info" class="slds-m-bottom_small">Lorem ipsum dolor sit amet</alert>
            <alert type="warning" class="slds-m-bottom_small">Lorem ipsum dolor sit amet</alert>
            <alert type="error" class="slds-m-bottom_small">Lorem ipsum dolor sit amet</alert>
            <alert type="success" class="slds-m-bottom_small">Lorem ipsum dolor sit amet</alert>
            <alert type="static" class="slds-m-bottom_small">Lorem ipsum dolor sit amet</alert>

            <div class="slds-grid slds-gutters_direct slds-wrap">
                <div class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2">
                    <div class="slds-p-vertical_medium">
                        <help-pointer content="Lorem ipsum dolor sit amet, consectetur adipisicing elit."></help-pointer>
                        <span class="slds-m-left_xx-small">Tooltip</span>
                    </div>

                    <form-element label="Lorem ipsum dolor sit" class="slds-m-bottom_small">
                        <input class="slds-input" />
                        <div class="slds-form-element__help">Lorem ipsum dolor sit amet, consectetur adipisicing elit</div>
                    </form-element>

                    <form-element label="Lorem ipsum dolor sit" class="slds-m-bottom_small">
                        <div class="slds-select_container">
                            <select class="slds-select">
                                <option>Option</option>
                            </select>
                        </div>
                    </form-element>

                    <checkbox label="Lorem ipsum dolor sit" class="slds-m-bottom_small" />

                    <checkbox-toggle label="Lorem ipsum dolor sit" class="slds-m-bottom_small" />

                    <button class="slds-button slds-button_neutral">Cancel</button>
                    <button class="slds-button slds-button_outline-brand">Cancel</button>
                    <button class="slds-button slds-button_brand">Save</button>
                    <button class="slds-button slds-button_neutral" disabled>Cancel</button>
                    <button class="slds-button slds-button_outline-brand" disabled>Cancel</button>
                    <button class="slds-button slds-button_brand" disabled>Save</button>
                </div>

                <div class="slds-col slds-size_1-of-1 slds-medium-size_1-of-2 slds-has-error">
                    <div class="slds-p-vertical_medium">
                        <icon icon="exclamation-triangle" class="slds-icon slds-icon_x-small slds-icon-text-default" />
                        <icon icon="exclamation-triangle" class="slds-icon slds-icon_x-small slds-icon-text-light" />
                        <icon icon="exclamation-triangle" class="slds-icon slds-icon_x-small slds-icon-text-warning" />
                        <icon icon="exclamation-triangle" class="slds-icon slds-icon_x-small slds-icon-text-error" />
                        <icon icon="exclamation-triangle" class="slds-icon slds-icon_x-small slds-icon-text-success" />
                    </div>

                    <form-element label="Lorem ipsum dolor sit" class="slds-m-bottom_small">
                        <input class="slds-input" />
                        <div class="slds-form-element__help">Lorem ipsum dolor sit amet, consectetur adipisicing elit</div>
                    </form-element>

                    <form-element label="Lorem ipsum dolor sit" :required="true" class="slds-m-bottom_small">
                        <div class="slds-select_container">
                            <select class="slds-select">
                                <option>Option</option>
                            </select>
                        </div>
                    </form-element>

                    <checkbox label="Lorem ipsum dolor sit" class="slds-m-bottom_small" />

                    <checkbox-toggle label="Lorem ipsum dolor sit" class="slds-m-bottom_small" />

                    <button class="slds-button slds-button_destructive">Save</button>
                    <button class="slds-button slds-button_text-destructive">Save</button>
                    <button class="slds-button slds-button_success">Success</button>
                    <button class="slds-button slds-button_destructive" disabled>Save</button>
                    <button class="slds-button slds-button_text-destructive" disabled>Save</button>
                    <button class="slds-button slds-button_success" disabled>Success</button>
                </div>
            </div>
        </div>

    </section>
</template>

<script>
    import PageInterface from '../../components/page-interface.vue';

    import Icons from '../../core/icons.js';
    import {faExclamationTriangle} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faExclamationTriangle);
//    import moment from 'moment-timezone';

    export default {
        extends: PageInterface,

        //
        // PARAMS: porps, data, computed
        //
        data() {
            return {
                pageTitle: 'Home'
            }
        }/*,
        mounted() {
            let stringUTCInput = '2019-05-13T07:46:28.000Z';
            console.log(stringUTCInput);
            console.log('\nDEFAULT');
            console.log(moment(stringUTCInput).format());
            console.log(moment(stringUTCInput).utcOffset(), moment(stringUTCInput).format('Z z'));
            console.log(moment(stringUTCInput));
            console.log('\nLOCAL');
            console.log(moment(stringUTCInput).local().format());
            console.log(moment(stringUTCInput).local().utcOffset(), moment(stringUTCInput).local().format('Z z'));
            console.log(moment(stringUTCInput).local());
            console.log('\nUTC');
            console.log(moment(stringUTCInput).utc().format());
            console.log(moment(stringUTCInput).utc().utcOffset(), moment(stringUTCInput).utc().format('Z z'));
            console.log(moment(stringUTCInput).utc());
            console.log('\nTIMEZONE ADD');
            console.log(moment(stringUTCInput).tz(this.$timezone).format());
            console.log(moment(stringUTCInput).tz(this.$timezone).utcOffset(), moment(stringUTCInput).tz(this.$timezone).format('Z z'));
            console.log(moment(stringUTCInput).tz(this.$timezone));
            console.log('\nTIMEZONE CREATE');
            console.log(moment.tz(stringUTCInput, this.$timezone).format());
            console.log(moment.tz(stringUTCInput, this.$timezone).utcOffset(), moment.tz(stringUTCInput, this.$timezone).format('Z z'));
            console.log(moment.tz(stringUTCInput, this.$timezone));

        }*/


    }
</script>
