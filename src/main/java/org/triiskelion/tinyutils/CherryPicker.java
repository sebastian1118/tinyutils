package org.triiskelion.tinyutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: January 22, 2015
 * Time: 21:46
 */
public class CherryPicker {


	@SafeVarargs
	public static <T> T pickFirst(Picker<T> picker, T... objects) {

		if(objects == null || objects.length == 0) {
			return null;
		}

		for(T obj : objects) {
			if(picker.pick(obj)) {
				return obj;
			}
		}
		return picker.getDefault();
	}

	@SafeVarargs
	public static <T> List<T> pick(Picker<T> picker, T... objects) {

		ArrayList<T> result = new ArrayList<>();
		if(objects == null || objects.length == 0) {
			return result;
		}

		for(T obj : objects) {
			if(picker.pick(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public static final Picker<String> NotNullStringPicker = new Picker<String>() {

		@Override
		public boolean pick(String s) {

			return s != null;
		}

		@Override
		public String getDefault() {

			return null;
		}
	};
}
