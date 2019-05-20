<template>
	<div class="slds-form-element__control slds-input-has-icon slds-input-has-icon_right">
		<input
			class="slds-input"
			:type="'text'"
			:class="computedInputClass"
			:name="name"
			:ref="refName"
			:id="id"
			:value="formattedValue"
			:open-date="openDate"
			:placeholder="placeholder"
			:disabled="disabled"
			:required="required"
			@click="showCalendar"
			@keyup="parseTypedDate"
			@blur="inputBlurred"
			@keypress="keyPress"
			autocomplete="off">
		<button class="slds-button slds-button_icon slds-input__icon slds-input__icon_right slds-date-picker__no-event" title="Select a date">
			<svg class="slds-button__icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" id="event" width="100%" height="100%">
				<path d="M21.5 9.2h-19c-.3 0-.7.4-.7.7v11.3c0 1 .9 1.9 1.9 1.9h16.6c1 0 1.9-.9 1.9-1.9V9.9c0-.3-.4-.7-.7-.7zM8.8 19.4c0 .3-.2.4-.5.4H6.5c-.3 0-.5-.1-.5-.4v-1.9c0-.2.2-.4.5-.4h1.8c.3 0 .5.2.5.4v1.9zm0-4.6c0 .2-.2.4-.5.4H6.5c-.3 0-.5-.2-.5-.4v-1.9c0-.3.2-.4.5-.4h1.8c.3 0 .5.1.5.4v1.9zm4.6 4.6c0 .3-.2.4-.5.4h-1.8c-.3 0-.5-.1-.5-.4v-1.9c0-.2.2-.4.5-.4h1.8c.3 0 .5.2.5.4v1.9zm0-4.6c0 .2-.2.4-.5.4h-1.8c-.3 0-.5-.2-.5-.4v-1.9c0-.3.2-.4.5-.4h1.8c.3 0 .5.1.5.4v1.9zm4.6 4.6c0 .3-.2.4-.5.4h-1.8c-.3 0-.5-.1-.5-.4v-1.9c0-.2.2-.4.5-.4h1.8c.3 0 .5.2.5.4v1.9zm0-4.6c0 .2-.2.4-.5.4h-1.8c-.3 0-.5-.2-.5-.4v-1.9c0-.3.2-.4.5-.4h1.8c.3 0 .5.1.5.4v1.9zm2.3-11.6H18v-.9c0-.7-.6-1.4-1.4-1.4-.7 0-1.4.6-1.4 1.4v.9H8.8v-.9c0-.7-.6-1.4-1.4-1.4C6.6.9 6 1.5 6 2.3v.9H3.7c-1 0-1.9.9-1.9 1.9v1.1c0 .4.4.7.7.7h19c.3 0 .7-.3.7-.7V5.1c0-1-.9-1.9-1.9-1.9z">
				</path>
			</svg>
		</button>
	</div>
</template>

<script>
import { makeDateUtils } from '../core/dateutils'

export default {
	props: {
		selectedDate: Date,
		resetTypedDate: [Date],
		format: [String, Function],
		translation: Object,
		id: String,
		name: String,
		refName: String,
		openDate: Date,
		placeholder: String,
		inputClass: [String, Object, Array],
		disabled: Boolean,
		required: Boolean,
		typeable: Boolean,
		useUtc: Boolean,
	},
	data () {
		const constructedDateUtils = makeDateUtils(this.useUtc)
		return {
			input: null,
			typedDate: false,
			utils: constructedDateUtils
		}
	},
	computed: {
		formattedValue () {
			if (!this.selectedDate) {
				return null
			}
			if (this.typedDate) {
				return this.typedDate
			}
			return typeof this.format === 'function'
				? this.format(this.selectedDate)
				: this.utils.formatDate(new Date(this.selectedDate), this.format, this.translation)
		},

		computedInputClass () {
			return this.inputClass
		}
	},
	watch: {
		resetTypedDate () {
			this.typedDate = false
		}
	},
	methods: {
		showCalendar () {
			this.$emit('showCalendar')
		},
	    /**
	     * Attempt to parse a typed date
	     * @param {Event} event
	     */
		 parseTypedDate (event) {
      		// close calendar if escape or enter are pressed
			if ([
				27, // escape
				13 // enter
			].includes(event.keyCode)) {
				this.input.blur()
			}

			if (this.typeable) {
				const typedDate = Date.parse(this.input.value)
				if (!isNaN(typedDate)) {
					this.typedDate = this.input.value
					this.$emit('typedDate', new Date(this.typedDate))
				}
			}
		},
	    /**
	     * nullify the typed date to defer to regular formatting
	     * called once the input is blurred
	     */
		inputBlurred () {
			if (this.typeable && isNaN(Date.parse(this.input.value))) {
				this.clearDate()
				this.input.value = null
				this.typedDate = null
			}

			this.$emit('closeCalendar')
		},
		/**
		 * emit a clearDate event
		 */
		 clearDate () {
			 this.$emit('clearDate')
		 },
		 keyPress(event) {
			 event.preventDefault()
		 }
	 },
	mounted () {
		this.input = this.$el.querySelector('input')
	}
};
</script>
