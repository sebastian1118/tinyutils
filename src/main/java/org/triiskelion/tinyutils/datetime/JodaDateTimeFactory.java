package org.triiskelion.tinyutils.datetime;

import org.joda.time.DateTime;

/**
 * @author Sebastian MA
 */
public class JodaDateTimeFactory extends DateTimeFactory<DateTime> {

	@Override
	public DateTime fromDateTime(DateTime date) {

		return null;
	}

	@Override
	public DateTime toDateTime(DateTime date) {

		return null;
	}

	@Override
	public DateTime now() {

		return org.joda.time.DateTime.now();
	}

	@Override
	public DateTime beginOfDay(DateTime date, int offset) {

		return date
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue()
				.millisOfSecond().withMinimumValue()
				.plusDays(offset);
	}

	@Override
	public DateTime endOfDay(DateTime date, int offset) {


		return date
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue()
				.millisOfSecond().withMinimumValue()
				.plusDays(offset);
	}

	@Override
	public DateTime beginOfMonth(DateTime date, int offset) {

		return date
				.dayOfMonth().withMinimumValue()
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue()
				.millisOfSecond().withMinimumValue()
				.plusMonths(offset);
	}

	@Override
	public DateTime endOfMonth(DateTime date, int offset) {

		return date
				.dayOfMonth().withMaximumValue()
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue()
				.millisOfSecond().withMaximumValue()
				.plusMonths(offset);
	}
}
