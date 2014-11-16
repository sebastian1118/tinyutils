package org.triiskelion.tinyutils;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * User: tian
 * Date: 14/2/14
 * Time: 15:19
 */
public class Validator {


	/**
	 * validates if paramter is location
	 *
	 * @param location
	 * 		comma-delimited two double values
	 *
	 * @return true if location is valid location
	 */
	public static boolean isGeolocation(String location) {

		return !StringUtils.isBlank(location) && location.matches("\\d*\\.\\d,\\d*\\.\\d");
	}

	/**
	 * Validates if a string is
	 *
	 * @param string
	 * @param separator
	 *
	 * @return
	 */
	public static boolean containsOnlyDouble(String string, String separator) {

		try {
			String[] splitted = string.split(separator);

			for(String str : splitted) {
				if(!str.matches("[0-9]*\\.[0-9]")) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	/**
	 * valid email address. Null pointer safe.
	 *
	 * @param email
	 * 		may be null
	 */
	public static boolean isEmail(String email) {

		return StringUtils.isNotBlank(email) && email.matches(".*@.*\\..*");
	}

	/**
	 * valid mobile number an optional country code of 0086 or +86 followed by an 11-digit
	 * number. Null pointer safe.
	 *
	 * @param number
	 * 		may be null
	 * @param locale
	 * 		the locale
	 */
	public static boolean isMobileNumber(String number, Locale locale, boolean allowNationalCode) {

		if(locale.equals(Locale.CHINA)) {
			if(allowNationalCode) {
				return StringUtils.isNotBlank(number) && number.matches("(((00)|\\+)86)" +
						"?[0-9]{11}");
			} else {
				return StringUtils.isNotBlank(number) && number.matches("1[0-9]{10}");
			}
		} else {
			throw new NotImplementedException(locale.toString());
		}
	}

	/**
	 * Strict 11-digit mobile number. country code is not allowed.
	 */
	public static boolean isStrictMobileNumber(String number) {

		return StringUtils.isNotBlank(number) && number.matches("1[0-9]{10}");
	}


}
