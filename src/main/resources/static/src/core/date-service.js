
import moment from 'moment';

const DEFAULT_FORMAT = 'MM/DD/YYYY HH:mm:ss';

class DateService {
	constructor() {
	}

	/*
	* @param {Object}
	* @param {string} date
	* @param {string} format default DEFAULT_FORMAT
	* @param {boolean} useLocal default true
	* @return {string}
	*/
	formatUTCDateToLocal({date, format = DEFAULT_FORMAT, useLocal = true}) {
        if (!date) return '';

		let d = moment.utc(date);
		useLocal && d.local();
		return d.format(format);
	}

	/*
	* @param {Object}
	* @param {string} startTime
	* @param {string} endTime
	* @return {string} - Totaltime
	*/
	diffBetweenDates(startTime, endTime) {
	    if (!startTime || !endTime) return '';

		const time = moment(endTime) - moment(startTime);

		let days    = Math.floor(moment.duration(time).asDays()),
			hours   = moment.duration(time).hours(),
			minutes = moment.duration(time).minutes(),
            seconds = moment.duration(time).seconds();

		let result = [];

        days && result.push(days + 'd');
        hours && result.push(hours + 'h');
        minutes && result.push(minutes + 'm');
        (!days && !hours && seconds) && result.push(seconds + 's');

		return result.join(' ');
	}
}

export default new DateService();
