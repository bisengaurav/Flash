<template>
    <datetime
        v-model="innerValue"
        :type="type"
        :zone="$timezone"
        :phrases="{
            ok: $t('label.button.ok'),
            cancel: $t('label.button.cancel')
        }"
        class="slds-input-has-icon slds-input-has-icon_right"
        input-class="slds-input"
    >
        <template #after>
            <icon icon="calendar-alt" class="slds-icon slds-input__icon slds-input__icon_right slds-icon-text-default" />
        </template>
    </datetime>
</template>

<script>
    import {Datetime} from 'vue-datetime';
    import 'vue-datetime/dist/vue-datetime.min.css'

    import Icons from '../core/icons.js';
    import {faCalendarAlt} from '@fortawesome/free-solid-svg-icons/';
    Icons.add(faCalendarAlt);


    export default {
        components: {
            Datetime
        },

        //
        // PARAMS: porps, data, computed
        //
        props: {
            value: {
                default: null
            },
            type: {
                type: String,
                default: 'datetime'
            },
            valueTimestamp: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return  {
                innerValue: null
            };
        },

        //
        // WATCHERS
        //
        watch: {
            value: {
                handler(val, oldVal) {
                    if (typeof val == 'number') {
                        this.innerValue = new Date(val).toISOString();

                    } else {
                        this.innerValue = val;
                    }
                },
                immediate: true
            },

            innerValue: function(val, oldVal) {
                this.$emit('input', val ? this.$props.valueTimestamp ? Date.parse(val) : val : null);
            }
        }
    }
</script>

<style>
    .vdatetime-overlay {
        z-index: 1000;
        position: fixed;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background: rgba(255,255,255,.6);
    }




    .vdatetime-popup {
        z-index: 1100;
        position: fixed;

        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
        width: 340px;

        max-width: calc(100% - 30px);
        box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .3);
        color: #444;
        background: #fff;
    }

    .vdatetime-popup__header {
        padding: 18px 30px;
        background: #3f51b5;
        color: #fff;
        font-size: 32px;
    }
    .vdatetime-popup__title {
        display: none;
    }
    .vdatetime-popup__year {
        font-weight: 300;
        font-size: 14px;
        cursor: pointer;
    }
    .vdatetime-popup__date {
        line-height: 1;
        cursor: pointer;
    }

    .vdatetime-popup__actions {
        padding: 0 20px 10px 30px;
        text-align: right;
    }

    .vdatetime-popup__actions__button {
        display: inline-block;
        border: none;
        padding: 10px 20px;
        background: transparent;
        font-size: 16px;
        color: #3f51b5;
        cursor: pointer;
        transition: color .3s
    }

    .vdatetime-popup__actions__button:hover {
        color: #444
    }
    .vdatetime-calendar__navigation--previous:hover svg path, .vdatetime-calendar__navigation--next:hover svg path {
        stroke: #888;
    }




    .vdatetime-calendar__navigation {
        position: relative;
        margin: 15px 0;
        padding: 0 30px;
        width: 100%;
    }
    .vdatetime-calendar__navigation--previous,
    .vdatetime-calendar__navigation--next {
        position: absolute;
        top: 0;
        padding: 0 5px;
        width: 18px;
        cursor: pointer
    }
    .vdatetime-calendar__navigation--previous svg, .vdatetime-calendar__navigation--next svg {
        width: 8px;
    }
    .vdatetime-calendar__navigation--previous svg path, .vdatetime-calendar__navigation--next svg path {
        transition: stroke .3s;
    }
    .vdatetime-calendar__navigation--previous {
        left: 25px;
    }
    .vdatetime-calendar__navigation--next {
        right: 25px;
        -webkit-transform: scaleX(-1);
        transform: scaleX(-1);
    }

    .vdatetime-calendar__current--month {
        text-align: center;
        text-transform: capitalize;
    }

    .vdatetime-calendar__month {
        padding: 0 20px;
    }

    .vdatetime-calendar__month__weekday,
    .vdatetime-calendar__month__day {
        display: inline-block;
        width: 14.28571%;
        line-height: 36px;
        text-align: center;
        font-size: 15px;
        font-weight: 300;
        cursor: pointer
    }

    .vdatetime-calendar__month__weekday > span, .vdatetime-calendar__month__day > span {
        display: block;
        width: 100%;
        position: relative;
        height: 0;
        padding: 0 0 100%;
        overflow: hidden;
    }

    .vdatetime-calendar__month__weekday > span > span, .vdatetime-calendar__month__day > span > span {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        border: 0;
        border-radius: 50%;
        transition: background-color .3s, color .3s;
    }

    .vdatetime-calendar__month__weekday {
        font-weight: bold;
    }

    .vdatetime-calendar__month__day:hover > span > span {
        background: #eee;
    }

    .vdatetime-calendar__month__day--selected {
    }

    .vdatetime-calendar__month__day--selected > span > span,
    .vdatetime-calendar__month__day--selected:hover > span > span {
        color: #fff;
        background: #3f51b5;
    }

    .vdatetime-calendar__month__day--disabled {
        opacity: 0.4;
        cursor: default
    }

    .vdatetime-calendar__month__day--disabled:hover > span > span {
        color: inherit;
        background: transparent;
    }




    .vdatetime-time-picker::after {
        content: '';
        display: table;
        clear: both
    }

    .vdatetime-time-picker__list {
        float: left;
        width: 50%;
        height: 305px;
        overflow-y: scroll
    }

    .vdatetime-time-picker__with-suffix .vdatetime-time-picker__list {
        width: 33.3%;
    }

    .vdatetime-time-picker__item {
        padding: 10px 0;
        font-size: 20px;
        text-align: center;
        cursor: pointer;
        transition: font-size .3s;
    }

    .vdatetime-time-picker__item:hover {
        font-size: 32px;
    }

    .vdatetime-time-picker__item--selected {
        color: #3f51b5;
        font-size: 32px;
    }

    .vdatetime-time-picker__item--disabled {
        opacity: 0.4;
        cursor: default;
        font-size: 20px !important;
    }



    .vdatetime-year-picker__list {
        width: 100%;
        height: 305px;
        overflow-y: scroll
    }
    .vdatetime-year-picker__item {
        padding: 10px 0;
        font-size: 20px;
        text-align: center;
        cursor: pointer;
        transition: font-size .3s;
    }

    .vdatetime-year-picker__item:hover {
        font-size: 32px;
    }

    .vdatetime-year-picker__item--selected {
        color: #3f51b5;
        font-size: 32px;
    }

    .vdatetime-year-picker__item--disabled {
        opacity: 0.4;
        cursor: default
    }

    .vdatetime-year-picker__item--disabled:hover {
        color: inherit;
        background: transparent
    }




    .vdatetime-month-picker::after {
        content: '';
        display: table;
        clear: both
    }
    .vdatetime-month-picker__list {
        float: left;
        width: 100%;
        height: 305px;
        overflow-y: scroll
    }

    .vdatetime-month-picker__item {
        padding: 10px 0;
        font-size: 20px;
        text-align: center;
        cursor: pointer;
        transition: font-size .3s;
    }

    .vdatetime-month-picker__item:hover {
        font-size: 32px;
    }

    .vdatetime-month-picker__item--selected {
        color: #3f51b5;
        font-size: 32px;
    }

    .vdatetime-month-picker__item--disabled {
        opacity: 0.4;
        cursor: default
    }

    .vdatetime-month-picker__item--disabled:hover {
        color: inherit;
        background: transparent
    }

</style>
