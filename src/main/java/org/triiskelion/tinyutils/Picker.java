package org.triiskelion.tinyutils;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: January 22, 2015
 * Time: 21:51
 */
public interface Picker<T> {

	public boolean pick(T t);

	public T getDefault();
}
