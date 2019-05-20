<template>
	<div class="slds-date-picker" :class="[wrapperClass]">

		<date-input
			:selectedDate="selectedDate"
      		:resetTypedDate="resetTypedDate"
      		:format="format"
      		:translation="translation"
      		:id="id"
      		:name="name"
      		:refName="refName"
      		:openDate="openDate"
      		:placeholder="placeholder"
      		:inputClass="inputClass"
		    :typeable="typeable"
			:disabled="disabled"
			:required="required"
			:use-utc="useUtc"
			@showCalendar="showCalendar"
			@closeCalendar="close"
			@typedDate="setTypedDate"
			@clearDate="clearDate">
		</date-input>

		<!-- Day View -->
		<picker-day
      		:pageDate="pageDate"
      		:selectedDate="selectedDate"
      		:showDayView="showDayView"
      		:fullMonthName="fullMonthName"
			:disabledDates="disabledDates"
			:highlighted="highlighted"
			:calendarClass="calendarClass"
			:translation="translation"
			:pageTimestamp="pageTimestamp"
			:mondayFirst="mondayFirst"
			:use-utc="useUtc"
			@changedMonth="handleChangedMonthFromDayPicker"
			@selectDate="selectDate"
			@selectedDisabled="selectDisabledDate">
		</picker-day>
	</div>
</template>

<script>
import DateInput from './date-input.vue'
import PickerDay from './picker-day.vue'
import utils, { makeDateUtils, en } from '../core/dateutils'
export default {
	components: {
		DateInput,
		PickerDay,
	},
	props: {
		value: {
			validator: val => utils.validateDateInput(val)
		},
		name: String,
		refName: String,
		id: String,
    	format: {
			type: [String, Function],
			default: 'dd MMM yyyy'
    	},
    	language: {
			type: Object,
      		default: () => en
    	},
    	openDate: {
      		validator: val => utils.validateDateInput(val)
    	},
		fullMonthName: Boolean,
		disabledDates: Object,
		highlighted: Object,
		placeholder: String,
		calendarClass: [String, Object, Array],
		inputClass: [String, Object, Array],
		wrapperClass: [String, Object, Array],
		mondayFirst: Boolean,
		disabled: Boolean,
		required: Boolean,
		typeable: Boolean,
		useUtc: Boolean,
		minimumView: {
      		type: String,
      		default: 'day'
    	},
	},
	data () {
		const startDate = this.openDate ? new Date(this.openDate) : new Date()
		const constructedDateUtils = makeDateUtils(this.useUtc)
		const pageTimestamp = constructedDateUtils.setDate(startDate, 1)

		return {
			/*
			* Vue cannot observe changes to a Date Object so date must be stored as a timestamp
			* This represents the first day of the current viewing month
			* {Number}
			*/
			pageTimestamp,
			/*
			* Selected Date
			* {Date}
			*/
			selectedDate: null,
			/*
			* Flags to show calendar views
			* {Boolean}
			*/
			showDayView: false,
			/*
			* Positioning
			*/
			calendarHeight: 0,
			resetTypedDate: new Date(),
			utils: constructedDateUtils
		}
	},
	watch: {
		value (value) {
		  this.setValue(value)
		},
		openDate () {
		  this.setPageDate()
		}
	},
	computed: {
		pageDate () {
		  return new Date(this.pageTimestamp)
		},

		translation () {
		  return this.language
		},
		isOpen () {
		  return this.showDayView
		}
	},
	methods: {
		/**
		 * Called in the event that the user navigates to date pages and
		 * closes the picker without selecting a date.
		 */
		 resetDefaultPageDate () {
			if (this.selectedDate === null) {
				this.setPageDate()
				return
			}
			this.setPageDate(this.selectedDate)
		},
		/**
		 * Effectively a toggle to show/hide the calendar
		 * @return {mixed}
		 */
		 showCalendar () {
			if (this.disabled) {
				return false
			}

			if (this.isOpen) {
				return this.close(true)
			}
      		this.showDayCalendar()
			this.$emit('opened')
		},
		/**
		 * Show the day picker
		 * @return {Boolean}
		 */
		showDayCalendar () {
		  	this.close()
		  	this.showDayView = true
		  	return true
		},
		/**
		* Set the selected date
		* @param {Number} timestamp
		*/
		setDate (timestamp) {
			const date = new Date(timestamp)
			this.selectedDate = date
			this.setPageDate(date)
			this.$emit('selected', date)
			this.$emit('input', this.utils.formatDate(date, 'yyyy-MM-dd'))
		},
		/**
		 * Clear the selected date
		 */
		clearDate () {
			this.selectedDate = null
			this.setPageDate()
			this.$emit('selected', null)
			this.$emit('input', null)
			this.$emit('cleared')
		},
		/**
		 * @param {Object} date
		 */
		selectDate (date) {
			this.setDate(date.timestamp)
			this.close(true)
			this.resetTypedDate = new Date()
		},
		/**
		 * @param {Object} date
		 */
		selectDisabledDate (date) {
			this.$emit('selectedDisabled', date)
		},
		/**
		 * Set the datepicker value
		 * @param {Date|String|Number|null} date
		 */
		setValue (date) {
			if (typeof date === 'string' || typeof date === 'number') {
				let parsed = new Date(date)
				date = isNaN(parsed.valueOf()) ? null : parsed
			}
			if (!date) {
				this.setPageDate()
				this.selectedDate = null
				return
			}
			this.selectedDate = date
			this.setPageDate(date)
		},
		/**
		 * Sets the date that the calendar should open on
		 */
		setPageDate (date) {
			if (!date) {
				if (this.openDate) {
					date = new Date(this.openDate)
				} else {
					date = new Date()
				}
			}
			this.pageTimestamp = this.utils.setDate(new Date(date), 1)
		},
		/**
		 * Handles a month change from the day picker
		 */
		handleChangedMonthFromDayPicker (date) {
			this.setPageDate(date)
			this.$emit('changedMonth', date)
		},
		/**
		 * Set the date from a typedDate event
		 */
		setTypedDate (date) {
		  	this.setDate(date.getTime())
		},
		/**
		 * Close all calendar layers
		 * @param {Boolean} emitEvent - emit close event
		 */
		close (emitEvent) {
			this.showDayView = false
			if (emitEvent) {
				this.$emit('closed')
			}
		},
		/**
		 * Initiate the component
		 */
		init () {
			if (this.value) {
				this.setValue(this.value)
			}
		}
	},
	mounted () {
		this.init()
	}
};
</script>

<style>

.slds-date-picker .slds-is-selected.highlighted {
	background: #4bd;
}
.slds-date-picker .highlighted {
	background: #cae5ed;
}
.slds-date-picker .highlighted.disabled {
	color: #a3a3a3;
}

.slds-date-picker {
	background-color: #fff;
	border: 1px solid #dddbda;
	border-radius: .25rem;
	width: 100%;
	transition: border .1s linear,background-color .1s linear;
	height: calc(1.875rem + (1px * 2));
}

.slds-blank-day {
	pointer-events: none;
	cursor: auto;
}

.slds-date-picker__year {
	position: relative;
	padding-top: .4rem;
	padding-bottom: .4rem;
	padding-left: .5rem;
	padding-right: 1.5rem;
	border: 1px solid #dddbda;
	border-radius: .25rem;
}

.slds-date-picker__year-arrow {
	position: absolute;
	content: '';
	display: block;
	right: .5rem;
	width: 0;
	height: 0;
	border-left: 3px solid transparent;
	border-right: 3px solid transparent;
}

.slds-date-picker__year-arrow--top {
	border-bottom: 5px solid #061c3f;
	top: calc((1.75rem / 2) - 6px);
}

.slds-date-picker__year-arrow--bottom {
	border-top: 5px solid #061c3f;
	bottom: calc((1.75rem / 2) - 6px);
}

.slds-date-picker__no-event {
	pointer-events: none;
}
</style>
