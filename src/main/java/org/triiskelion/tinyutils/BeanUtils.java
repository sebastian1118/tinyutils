package org.triiskelion.tinyutils;

/**
 * @author Sebastian MA
 */
public class BeanUtils {


	@SafeVarargs
	public static <T> T firstAvailable(AvailableCondition<T> ac, T... objects) {

		if(objects == null || objects.length == 0) {
			return null;
		}

		for(T obj : objects) {
			if(ac.isAvailable(obj)) {
				return obj;
			}
		}
		return null;
	}

	public static String firstAvailable(String... objects) {

		if(objects == null || objects.length == 0) {
			return null;
		}

		AvailableCondition<String> ac = new AvailableCondition<String>() {

			@Override
			public boolean isAvailable(String obj) {

				return obj != null && !obj.trim().isEmpty();
			}

			@Override
			public String getDefault() {

				return "";
			}
		};
		for(String obj : objects) {
			if(ac.isAvailable(obj)) {
				return obj;
			}
		}
		return ac.getDefault();
	}

	//	public static <T> T cherryPick(CherryPicker picker, T... objects) {
	//
	//		if(objects == null || objects.length == 0) {
	//			return null;
	//		}
	//
	//		for(T obj : objects) {
	//
	//		}
	//		return null;
	//	}

	public static String cherryPick(String... objects) {

		if(objects == null || objects.length == 0) {
			return null;
		}

		for(String obj : objects) {

		}
		return null;
	}

	public static boolean allNull(Object... objects) {

		if(objects == null) {
			return true;
		}
		for(Object o : objects) {
			if(o != null) {
				return false;
			}
		}
		return true;
	}
}
