package org.triiskelion.tinyutils.datetime;

import org.joda.time.DateTime;

import java.sql.Timestamp;

/**
 * @author Sebastian MA
 */
public class TimestampDateTimeFactory extends DateTimeFactory<Timestamp> {

	@Override
	public Timestamp fromDateTime(DateTime date) {

		return new Timestamp(date.getMillis());
	}

	@Override
	public DateTime toDateTime(Timestamp date) {

		return new DateTime(date.getTime());
	}


}
