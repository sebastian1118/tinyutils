package org.triiskelion.tinyutils.valuemap;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: January 04, 2015
 * Time: 11:35
 */
public class ValuePair<A, B> {

	A a;

	B b;

	public ValuePair(A a, B b) {

		this.a = a;
		this.b = b;
	}

	public static <A, B> ValuePair<A, B> of(A a, B b) {

		return new ValuePair<>(a, b);
	}
}
