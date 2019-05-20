<template>
	<div class="slds-datepicker slds-dropdown slds-dropdown_left" :class="[calendarClass, 'vdp-datepicker__calendar']" v-show="showDayView" :style="calendarStyle" @mousedown.prevent>
		<div class="slds-datepicker__filter slds-grid">
			<div class="slds-datepicker__filter_month slds-grid slds-grid_align-spread slds-grow">
				<div class="slds-align-middle">
					<button class="slds-button slds-button_icon slds-button_icon-container" @click="previousMonth()">
						<svg class="slds-button__icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" id="left" width="100%" height="100%">
							<path d="M17.5 3.8v16.4c0 .4-.6.8-1 .4l-9.8-8c-.3-.3-.3-.9 0-1.2l9.8-8c.4-.4 1-.1 1 .4z"></path>
						</svg>
					</button>
				</div>
      			<h2 class="slds-align-middle">{{ isYmd ? currYearName : currMonthName }}</h2>
				<div class="slds-align-middle">
					<button class="slds-button slds-button_icon slds-button_icon-container" @click="nextMonth()">
						<svg class="slds-button__icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" id="right" width="100%" height="100%">
							<path d="M6.5 20.2V3.8c0-.4.6-.8 1-.4l9.8 8c.3.3.3.9 0 1.2l-9.8 8c-.4.4-1 .1-1-.4z"></path>
						</svg>
					</button>
				</div>
			</div>
			<div class="slds-shrink-none">
				<div class="slds-date-picker__year">
					{{ currYearName }}
					<div class="slds-date-picker__year-arrow slds-date-picker__year-arrow--top" @click="nextYear()"></div>
					<div class="slds-date-picker__year-arrow slds-date-picker__year-arrow--bottom" @click="previousYear()"></div>
				</div>
			</div>
		</div>

		<table class="slds-datepicker__month">
			<thead>
				<tr>
					<th scope="col" v-for="d in daysOfWeek" :key="d.timestamp">
						<abbr>{{ d }}</abbr>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="days in rows">
					<td v-for="day in days"
						:key="day.timestamp"
						:class="dayClasses(day)"
						@click="selectDate(day)">
						<span class="slds-day">{{day.date}}</span>
					</td>
				</tr>
			</tbody>
	    </table>
	</div>
</template>

<script>
import { makeDateUtils } from '../core/dateutils'

export default {
	props: {
		showDayView: Boolean,
		selectedDate: Date,
		pageDate: Date,
		pageTimestamp: Number,
		fullMonthName: Boolean,
		disabledDates: Object,
		highlighted: Object,
		calendarClass: [String, Object, Array],
		calendarStyle: Object,
		translation: Object,
		mondayFirst: Boolean,
		useUtc: Boolean
	},
	data () {
		const constructedDateUtils = makeDateUtils(this.useUtc)
		return {
			utils: constructedDateUtils
		}
	},
	computed: {
		/**
		* Returns an array of day names
		* @return {String[]}
		*/
		daysOfWeek () {
			if (this.mondayFirst) {
				const tempDays = this.translation.days.slice()
				tempDays.push(tempDays.shift())
				return tempDays
			}
			return this.translation.days
		},
		/**
		* @return {Object[]}
		*/
		days () {
			const d = this.pageDate
			let days = []
			// set up a new date object to the beginning of the current 'page'
			let dObj = this.useUtc
				? new Date(Date.UTC(d.getUTCFullYear(), d.getUTCMonth(), 1))
				: new Date(d.getFullYear(), d.getMonth(), 1, d.getHours(), d.getMinutes())
			let daysInMonth = this.utils.daysInMonth(this.utils.getFullYear(dObj), this.utils.getMonth(dObj))

			for (let i = 0; i < this.blankDays(d); i++) {
				days.push({
					blank: true,
				});
			}

			for (let i = 0; i < daysInMonth; i++) {
					days.push({
					date: this.utils.getDate(dObj),
					timestamp: dObj.getTime(),
					isSelected: this.isSelectedDate(dObj),
					isDisabled: this.isDisabledDate(dObj),
					isHighlighted: this.isHighlightedDate(dObj),
					isHighlightStart: this.isHighlightStart(dObj),
					isHighlightEnd: this.isHighlightEnd(dObj),
					isToday: this.utils.compareDates(dObj, new Date()),
					isWeekend: this.utils.getDay(dObj) === 0 || this.utils.getDay(dObj) === 6,
					isSaturday: this.utils.getDay(dObj) === 6,
					isSunday: this.utils.getDay(dObj) === 0
				})
				this.utils.setDate(dObj, this.utils.getDate(dObj) + 1)
			}
			return days
		},
		rows() {
			return this.days.reduce(function(p, c, i) {
				if (i % 7 === 0) {
					p[p.length] = []
				}
				p[p.length - 1].push(c)
				return p
			}, [])
		},
		/**
		* Gets the name of the month the current page is on
		* @return {String}
		*/
		currMonthName () {
			const monthName = this.fullMonthName ? this.translation.months : this.translation.monthsAbbr
			return this.utils.getMonthNameAbbr(this.utils.getMonth(this.pageDate), monthName)
		},
		/**
		* Gets the name of the year that current page is on
		* @return {Number}
		*/
		currYearName () {
			const yearSuffix = this.translation.yearSuffix
			return `${this.utils.getFullYear(this.pageDate)}${yearSuffix}`
		},
		/**
		* Is this translation using year/month/day format?
		* @return {Boolean}
		*/
		isYmd () {
			return this.translation.ymd && this.translation.ymd === true
		},
	},
	methods: {
		selectDate (date) {
			if (date.isDisabled) {
				this.$emit('selectedDisabled', date)
				return false
			}
			this.$emit('selectDate', date)
		},
		/**
		* Returns the day number of the week less one for the first of the current month
		* Used to show amount of empty cells before the first in the day calendar layout
		* @return {Number}
		*/
		blankDays () {
			const d = this.pageDate
			let dObj = this.useUtc
				? new Date(Date.UTC(d.getUTCFullYear(), d.getUTCMonth(), 1))
				: new Date(d.getFullYear(), d.getMonth(), 1, d.getHours(), d.getMinutes())
			if (this.mondayFirst) {
				return this.utils.getDay(dObj) > 0 ? this.utils.getDay(dObj) - 1 : 6
			}
			return this.utils.getDay(dObj)
		},
		/**
		* @return {Number}
		*/
		getPageMonth () {
			return this.utils.getMonth(this.pageDate)
		},
		/**
		* Change the page month
		* @param {Number} incrementBy
		*/
		changeMonth (incrementBy) {
			let date = this.pageDate
			this.utils.setMonth(date, this.utils.getMonth(date) + incrementBy)
			this.$emit('changedMonth', date)
		},
		/**
		* Decrement the page month
		*/
		previousMonth () {
			if (!this.isPreviousMonthDisabled()) {
				this.changeMonth(-1)
			}
		},
		previousYear () {
			if (!this.isPreviousMonthDisabled()) {
				this.changeMonth(-12)
			}
		},
		/**
		* Is the previous month disabled?
		* @return {Boolean}
		*/
		isPreviousMonthDisabled () {
			if (!this.disabledDates || !this.disabledDates.to) {
				return false
			}
			let d = this.pageDate
			return this.utils.getMonth(this.disabledDates.to) >= this.utils.getMonth(d) &&
			this.utils.getFullYear(this.disabledDates.to) >= this.utils.getFullYear(d)
		},
		/**
		* Increment the current page month
		*/
		nextMonth () {
			if (!this.isNextMonthDisabled()) {
				this.changeMonth(+1)
			}
		},
		nextYear () {
			if (!this.isNextMonthDisabled()) {
				this.changeMonth(+12)
			}
		},
		/**
		* Is the next month disabled?
		* @return {Boolean}
		*/
		isNextMonthDisabled () {
			if (!this.disabledDates || !this.disabledDates.from) {
				return false
			}
			let d = this.pageDate
			return this.utils.getMonth(this.disabledDates.from) <= this.utils.getMonth(d) &&
			this.utils.getFullYear(this.disabledDates.from) <= this.utils.getFullYear(d)
		},
		/**
		* Whether a day is selected
		* @param {Date}
		* @return {Boolean}
		*/
		isSelectedDate (dObj) {
			return this.selectedDate && this.utils.compareDates(this.selectedDate, dObj)
		},
		/**
		* Whether a day is disabled
		* @param {Date}
		* @return {Boolean}
		*/
		isDisabledDate (date) {
			let disabledDates = false

			if (typeof this.disabledDates === 'undefined') {
				return false
			}

			if (typeof this.disabledDates.dates !== 'undefined') {
				this.disabledDates.dates.forEach(d => {
					if (this.utils.compareDates(date, d)) {
						disabledDates = true
						return true
					}
				})
			}
			if (typeof this.disabledDates.to !== 'undefined' && this.disabledDates.to && date < this.disabledDates.to) {
				disabledDates = true
			}
			if (typeof this.disabledDates.from !== 'undefined' && this.disabledDates.from && date > this.disabledDates.from) {
				disabledDates = true
			}
			if (typeof this.disabledDates.ranges !== 'undefined') {
				this.disabledDates.ranges.forEach(range => {
					if (typeof range.from !== 'undefined' && range.from && typeof range.to !== 'undefined' && range.to) {
						if (date < range.to && date > range.from) {
					  	disabledDates = true
					  	return true
						}
					}
				})
			}
			if (typeof this.disabledDates.days !== 'undefined' && this.disabledDates.days.indexOf(this.utils.getDay(date)) !== -1) {
				disabledDates = true
			}
			if (typeof this.disabledDates.daysOfMonth !== 'undefined' && this.disabledDates.daysOfMonth.indexOf(this.utils.getDate(date)) !== -1) {
				disabledDates = true
			}
			if (typeof this.disabledDates.customPredictor === 'function' && this.disabledDates.customPredictor(date)) {
				disabledDates = true
			}
			return disabledDates
		},
		/**
		* Whether a day is highlighted (only if it is not disabled already except when highlighted.includeDisabled is true)
		* @param {Date}
		* @return {Boolean}
		*/
		isHighlightedDate (date) {
			if (!(this.highlighted && this.highlighted.includeDisabled) && this.isDisabledDate(date)) {
				return false
			}

		let highlighted = false

		if (typeof this.highlighted === 'undefined') {
			return false
		}

		if (typeof this.highlighted.dates !== 'undefined') {
			this.highlighted.dates.forEach(d => {
				if (this.utils.compareDates(date, d)) {
					highlighted = true
					return true
				}
			})
		}

		if (this.isDefined(this.highlighted.from) && this.isDefined(this.highlighted.to)) {
			highlighted = date >= this.highlighted.from && date <= this.highlighted.to
		}

		if (typeof this.highlighted.days !== 'undefined' && this.highlighted.days.indexOf(this.utils.getDay(date)) !== -1) {
			highlighted = true
		}

		if (typeof this.highlighted.daysOfMonth !== 'undefined' && this.highlighted.daysOfMonth.indexOf(this.utils.getDate(date)) !== -1) {
			highlighted = true
		}

		if (typeof this.highlighted.customPredictor === 'function' && this.highlighted.customPredictor(date)) {
			highlighted = true
		}

		return highlighted
		},
		dayClasses (day) {
			return {
				'slds-blank-day': day.blank,
				'slds-is-selected': day.isSelected,
				'disabled': day.isDisabled,
				'highlighted': day.isHighlighted,
				'slds-is-today': day.isToday,
				'weekend': day.isWeekend,
				'sat': day.isSaturday,
				'sun': day.isSunday,
				'highlight-start': day.isHighlightStart,
				'highlight-end': day.isHighlightEnd
			}
		},
		/**
		* Whether a day is highlighted and it is the first date
		* in the highlighted range of dates
		* @param {Date}
		* @return {Boolean}
		*/
		isHighlightStart (date) {
			return this.isHighlightedDate(date) &&
			(this.highlighted.from instanceof Date) &&
			(this.utils.getFullYear(this.highlighted.from) === this.utils.getFullYear(date)) &&
			(this.utils.getMonth(this.highlighted.from) === this.utils.getMonth(date)) &&
			(this.utils.getDate(this.highlighted.from) === this.utils.getDate(date))
		},
		/**
		* Whether a day is highlighted and it is the first date
		* in the highlighted range of dates
		* @param {Date}
		* @return {Boolean}
		*/
		isHighlightEnd (date) {
			return this.isHighlightedDate(date) &&
			(this.highlighted.to instanceof Date) &&
			(this.utils.getFullYear(this.highlighted.to) === this.utils.getFullYear(date)) &&
			(this.utils.getMonth(this.highlighted.to) === this.utils.getMonth(date)) &&
			(this.utils.getDate(this.highlighted.to) === this.utils.getDate(date))
		},
		/**
		* Helper
		* @param  {mixed}  prop
		* @return {Boolean}
		*/
		isDefined (prop) {
			return typeof prop !== 'undefined' && prop
		}
	}
};
</script>
