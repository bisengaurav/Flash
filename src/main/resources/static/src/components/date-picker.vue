<template>
    <datetime
        v-model="innerValue"
        :type="type"
        :zone="$timezone"
        :phrases="{
            ok: $t('label.button.ok'),
            cancel: $t('label.button.cancel')
        }"
        :auto="true"
        :input-id="id"
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
            },
            id: {
                type: String,
                default: ''
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
        -webkit-transform: translate(-50%, -160px);
        transform: translate(-50%, -160px);
        width: 300px;

        max-width: calc(100% - 30px);
        box-shadow: 0 2px 3px 0 rgba(0,0,0,.16);
        background: #fff;
        border: 1px solid #dddbda;
        border-radius: .25rem;
    }



    .vdatetime-popup__header {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        -ms-flex-line-pack: center;
        align-content: center;
        -ms-flex-pack: justify;
        justify-content: space-between;
        -ms-flex-direction: row-reverse;
        flex-direction: row-reverse;

        padding: .6rem 1rem .65rem;;
        /*background-color: #0071b9;*/
        border-bottom: 2px solid #dddbda;
        border-radius: .24rem .24rem 0 0;
    }
    .vdatetime-popup__title {
        display: none;
    }
    .vdatetime-popup__year,
    .vdatetime-popup__date {
        font-weight: 700;
        cursor: pointer;
        /*color: #fff;*/
        border-bottom: 1px dashed #ccc;
    }



    .vdatetime-popup__actions {
        padding: .75rem 1rem;
        text-align: right;
        border-top: 2px solid #dddbda;
        border-bottom-right-radius: .25rem;
        border-bottom-left-radius: .25rem;
        background-color: #edeff0;
    }

    .vdatetime-popup__actions__button {
        position: relative;
        display: inline-block;
        padding: 0 1rem;
        border-radius: 0.25rem;

        line-height: 1.875rem;
        color: #0070d2;

        white-space: nowrap;
        text-align: center;
        vertical-align: middle;
        cursor: pointer;

        -webkit-appearance: none;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
    .vdatetime-popup__actions__button--cancel {
        color: #0071b9;
        border: 1px solid #dddbda;
        background-color: #fff;
    }
    .vdatetime-popup__actions__button--cancel:hover {
        color: #004987;
        background-color: #f4f6f9;
    }

    .vdatetime-popup__actions__button--confirm {
        color: #fff;
        background-color: #0071b9;
        border: 1px solid #0071b9;
    }
    .vdatetime-popup__actions__button--confirm:hover {
        background-color: #004987;
        border-color: #004987;
    }




    .vdatetime-calendar__navigation {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        -ms-flex-line-pack: center;
        align-content: center;
        -ms-flex-pack: justify;
        justify-content: space-between;

        margin: .5rem 0;
        padding: 0 .5rem;
        width: 100%;
    }

    .vdatetime-calendar__current--month {
        text-align: center;
    }

    .vdatetime-calendar__navigation--previous,
    .vdatetime-calendar__navigation--next {
        padding: 4px 10px;
        cursor: pointer
    }
    .vdatetime-calendar__navigation--previous {
    }
    .vdatetime-calendar__navigation--next {
        -webkit-transform: scaleX(-1);
        transform: scaleX(-1);
    }
    .vdatetime-calendar__navigation--previous svg,
    .vdatetime-calendar__navigation--next svg {
        width: 8px;
        stroke: #706e6b;
    }
    .vdatetime-calendar__navigation--previous:hover svg path,
    .vdatetime-calendar__navigation--next:hover svg path {
        stroke: #0070d2;
    }




    .vdatetime-calendar__month {
        padding: .4rem .5rem;

        display: -ms-flexbox;
        display: flex;

        -ms-flex-pack: justify;
        justify-content: space-between;

        -ms-flex-wrap: wrap;
        flex-wrap: wrap;

        -ms-flex-align: start;
        align-items: flex-start;
    }

    .vdatetime-calendar__month__weekday,
    .vdatetime-calendar__month__day {
        display: inline-block;
        width: 14.28571%;
        text-align: center;
    }

    .vdatetime-calendar__month__weekday > span,
    .vdatetime-calendar__month__day > span {
        display: block;
        width: 100%;
        padding: 1px 0;
    }

    .vdatetime-calendar__month__weekday > span > span,
    .vdatetime-calendar__month__day > span > span {
        display: block;
        width: 2rem;
        height: 2rem;
        line-height: 2rem;
        margin: 0 auto;
        border-radius: 50%;
        cursor: pointer
    }

    .vdatetime-calendar__month__weekday {
        padding-bottom: 2px;
        font-size: .75rem;
        font-weight: bold;
    }

    .vdatetime-calendar__month__day:hover > span > span {
        background: #edeff0;
    }

    .vdatetime-calendar__month__day--selected {
    }
    .vdatetime-calendar__month__day--selected > span > span,
    .vdatetime-calendar__month__day--selected:hover > span > span {
        color: #fff;
        background: #0071b9;
    }

    .vdatetime-calendar__month__day--disabled {
        opacity: 0.4;
        cursor: default
    }
    .vdatetime-calendar__month__day--disabled:hover > span > span {
        color: inherit;
        background: transparent;
    }




    .vdatetime-time-picker,
    .vdatetime-year-picker,
    .vdatetime-month-picker {
        display: -ms-flexbox;
        display: flex;
    }
    .vdatetime-time-picker__list,
    .vdatetime-year-picker__list,
    .vdatetime-month-picker__list {
        height: 230px;
        overflow-y: scroll
    }

    .vdatetime-time-picker__item,
    .vdatetime-year-picker__item,
    .vdatetime-month-picker__item {
        padding: 4px 0;
        text-align: center;
        cursor: pointer;
    }
    .vdatetime-time-picker__item:hover,
    .vdatetime-year-picker__item:hover,
    .vdatetime-month-picker__item:hover {
        background: #edeff0;
    }

    .vdatetime-time-picker__item--selected,
    .vdatetime-time-picker__item--selected:hover,
    .vdatetime-year-picker__item--selected,
    .vdatetime-year-picker__item--selected:hover,
    .vdatetime-month-picker__item--selected,
    .vdatetime-month-picker__item--selected:hover {
        color: #fff;
        background: #0071b9;
    }

    .vdatetime-time-picker__item--disabled,
    .vdatetime-time-picker__item--disabled:hover,
    .vdatetime-year-picker__item--disabled,
    .vdatetime-year-picker__item--disabled:hover,
    .vdatetime-month-picker__item--disabled,
    .vdatetime-month-picker__item--disabled:hover {
        color: #8d9194;
        background: #fff;
        cursor: default;
    }




    .vdatetime-time-picker__list {
        width: 50%;
    }
    .vdatetime-time-picker__with-suffix .vdatetime-time-picker__list {
        width: 33.3%;
    }
    .vdatetime-year-picker__list,
    .vdatetime-month-picker__list {
        width: 100%;
    }

</style>
