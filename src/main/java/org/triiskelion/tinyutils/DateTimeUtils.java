package org.triiskelion.tinyutils;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: June 22, 2014
 * Time: 23:17
 * <p/>
 * DateTimeUtils using JodaTime library
 */
public class DateTimeUtils {

	private static DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

	private static DateTimeFormatter hourMinuteFormatter = DateTimeFormat.forPattern("HH:mm");


	public static String format(DateTime time, String pattern) {

		return DateTimeFormat.forPattern(pattern).print(time);
	}

	public static Timestamp timestamp(DateTime time) {

		return new Timestamp(time.getMillis());
	}

	/**
	 * formats date to HH:mm
	 *
	 * @param date
	 *
	 * @return
	 */
	public static String toHHmm(Date date) {

		return hourMinuteFormatter.print(date.getTime());
	}

	/**
	 * format to yyyy-MM-dd
	 *
	 * @param date
	 *
	 * @return
	 */
	public static String toDateString(Date date) {

		if(date == null) {
			return "";
		}
		return dateFormatter.print(date.getTime());
	}

	public static Timestamp toTimestamp(String dateString) {

		return new Timestamp(dateFormatter.parseDateTime(dateString).getMillis());
	}

	/**
	 * returns a timestamp representing the given date at 00:00:00.<br>
	 * A offset equals to zero means same day as the given time. A offset less than zero
	 * means [offset] days before the given time. a offset greater than zero means
	 * [offset] days after the given time.
	 *
	 * @param time
	 * 		a certain time
	 * @param offset
	 * 		offset in days.
	 *
	 * @return
	 */
	public static Timestamp beginOfDay(Date time, int offset) {

		DateTime jodaTime = new DateTime(time.getTime());
		jodaTime = jodaTime
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue();

		jodaTime = jodaTime.plusDays(offset);
		return new Timestamp(jodaTime.getMillis());
	}

	/**
	 * returns a timestamp representing the given date at 00:00:00
	 *
	 * @param time
	 * 		a certain time
	 *
	 * @return the specific date
	 */
	public static Timestamp beginOfDay(Date time) {

		DateTime jodaTime = new DateTime(time.getTime());
		jodaTime = jodaTime
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue();

		jodaTime = jodaTime.plusDays(0);
		return new Timestamp(jodaTime.getMillis());
	}

	public static Timestamp beginOfDay(String timeString) {

		DateTime jodaTime = new DateTime(timeString);
		jodaTime = jodaTime
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue();

		jodaTime = jodaTime.plusDays(0);
		return new Timestamp(jodaTime.getMillis());
	}

	/**
	 * returns a date representing today at 00:00:00
	 *
	 * @return the specific date
	 */
	public static Timestamp beginOfDay() {

		DateTime jodaTime = new DateTime(System.currentTimeMillis());
		jodaTime = jodaTime
				.hourOfDay().withMinimumValue()
				.minuteOfHour().withMinimumValue()
				.secondOfMinute().withMinimumValue();

		jodaTime = jodaTime.plusDays(0);
		return new Timestamp(jodaTime.getMillis());
	}

	/**
	 * returns a date representing today at 00:00:00
	 *
	 * @return the specific date
	 */
	public static Timestamp endOfDay() {

		DateTime jodaTime = new DateTime(System.currentTimeMillis());
		jodaTime = jodaTime
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue();

		jodaTime = jodaTime.plusDays(0);
		return new Timestamp(jodaTime.getMillis());
	}

	public static Timestamp endOfDay(String dateString) {

		DateTime jodaTime = new DateTime(dateString);
		jodaTime = jodaTime
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue();

		return new Timestamp(jodaTime.getMillis());
	}

	public static Timestamp endOfDay(Date time) {

		DateTime jodaTime = new DateTime(time.getTime());
		jodaTime = jodaTime
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue();
		return new Timestamp(jodaTime.getMillis());
	}

	public static Timestamp endOfDay(Date time, int offset) {

		DateTime jodaTime = new DateTime(time.getTime());
		jodaTime = jodaTime
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue();
		jodaTime = jodaTime.plusDays(offset);
		return new Timestamp(jodaTime.getMillis());
	}

	/**
	 * Return the beginning of that month
	 *
	 * @param year
	 * 		the year
	 * @param month
	 * 		the month
	 * @param offset
	 * 		the offset in month. positive value moves the result later than the time
	 * 		point. negative value moves the result earlier.
	 *
	 * @return the corresponding timestamp
	 */
	public static Timestamp beginOfMonth(int year, int month, int offset) {

		return new Timestamp(
				new MutableDateTime()
						.year().set(year)
						.monthOfYear().set(month)
						.toDateTime()
						.dayOfMonth().withMinimumValue()
						.hourOfDay().withMinimumValue()
						.minuteOfHour().withMinimumValue()
						.secondOfMinute().withMinimumValue()
						.millisOfSecond().withMinimumValue()
						.plusMonths(offset).getMillis()
		);
	}

	/**
	 * Return the end of that month
	 *
	 * @param year
	 * 		the year
	 * @param month
	 * 		the month
	 * @param offset
	 * 		the offset in month. positive value for months after the current time point.
	 *
	 * @return the corresponding timestamp
	 */
	public static Timestamp endOfMonth(int year, int month, int offset) {

		return new Timestamp(new MutableDateTime()
				.year().set(year)
				.monthOfYear().set(month)
				.toDateTime()
				.dayOfMonth().withMaximumValue()
				.hourOfDay().withMaximumValue()
				.minuteOfHour().withMaximumValue()
				.secondOfMinute().withMaximumValue()
				.millisOfSecond().withMaximumValue()
				.plusMonths(offset)
				.getMillis());
	}

	public static Timestamp now() {

		return new Timestamp(System.currentTimeMillis());
	}

	public static Timestamp parse(String time) {

		if(time == null || time.isEmpty()) {
			return null;
		}
		return new Timestamp(DateTime.parse(time).getMillis());
	}

}
