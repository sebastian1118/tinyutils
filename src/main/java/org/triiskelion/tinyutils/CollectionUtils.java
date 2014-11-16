package org.triiskelion.tinyutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: October 16, 2014
 * Time: 15:19
 */
public class CollectionUtils {

	public static <T> List<T> asList(T... elements) {

		ArrayList<T> result = new ArrayList<>();

		Collections.addAll(result, elements);
		return result;

	}
}
