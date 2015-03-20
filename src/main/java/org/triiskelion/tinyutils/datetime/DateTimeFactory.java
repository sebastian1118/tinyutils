package org.triiskelion.tinyutils.datetime;

import org.joda.time.DateTime;

import java.sql.Timestamp;

/**
 * @author Sebastian MA
 */
public abstract class DateTimeFactory<T> {

	public static final DateTimeFactory<DateTime> DateTime = new JodaDateTimeFactory();

	public static final DateTimeFactory<Timestamp> Timestamp = new TimestampDateTimeFactory();

	protected abstract T fromDateTime(DateTime date);

	protected abstract DateTime toDateTime(T date);

	public T now() {


		return fromDateTime(DateTime.now());
	}

	public T beginOfDay(T date, int offset) {

		return fromDateTime(DateTime.beginOfDay(toDateTime(date), offset));
	}

	public T endOfDay(T date, int offset) {

		return fromDateTime(DateTime.endOfDay(toDateTime(date), offset));
	}

	public T beginOfMonth(T date, int offset) {

		return fromDateTime(DateTime.beginOfMonth(toDateTime(date), offset));
	}

	public T endOfMonth(T date, int offset) {

		return fromDateTime(DateTime.endOfMonth(toDateTime(date), offset));
	}
}
