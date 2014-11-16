package org.triiskelion.tinyutils;

import org.apache.commons.lang3.StringUtils;

/**
 * Conversion between some common forms
 */
public class Converter {

	/**
	 * Convert the string representation of an integer list into an int array
	 *
	 * @param string
	 * 		string of integers
	 * @param separatorChars
	 * 		the characters used as the delimiters, null splits on whitespace
	 *
	 * @return converted int array
	 *
	 * @throws java.lang.NumberFormatException
	 * 		if the string does not contain a parsable integer.
	 */
	public static int[] toIntArray(String string, String separatorChars) {

		return toIntArray(StringUtils.split(string, separatorChars));
	}

	/**
	 * Convert the string array representation of an integer list into an int array
	 *
	 * @param array
	 * 		the string array representation of an integer list
	 *
	 * @return converted int array
	 *
	 * @throws java.lang.NumberFormatException
	 * 		if the string does not contain a parsable integer.
	 */
	public static int[] toIntArray(String[] array) {

		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = Integer.parseInt(array[i]);
		}
		return result;
	}

	/**
	 * Convert the string representation of an integer list into an Integer array
	 *
	 * @param string
	 * 		string of integers
	 * @param separatorChars
	 * 		the characters used as the delimiters, null splits on whitespace
	 *
	 * @return converted Integer array
	 *
	 * @throws java.lang.NumberFormatException
	 * 		if the string does not contain a parsable integer.
	 */
	public static Integer[] toIntegerArray(String string, String separatorChars) {

		return toIntegerArray(StringUtils.split(string, separatorChars));
	}


	/**
	 * Convert the string array representation of an integer list into an Integer array
	 *
	 * @param array
	 * 		the string array representation of an integer list
	 *
	 * @return converted Integer array
	 *
	 * @throws java.lang.NumberFormatException
	 * 		if the string does not contain a parsable integer.
	 */
	public static Integer[] toIntegerArray(String[] array) {

		Integer[] result = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = Integer.valueOf(array[i]);
		}
		return result;
	}

	public static Double[] toDoubleArray(String string, String separatorChars) {

		return toDoubleArray(StringUtils.split(string, separatorChars));
	}

	public static Double[] toDoubleArray(String[] array) {

		if(array == null) {
			return null;
		}
		Double[] result = new Double[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = Double.valueOf(array[i]);
		}
		return result;
	}
}
