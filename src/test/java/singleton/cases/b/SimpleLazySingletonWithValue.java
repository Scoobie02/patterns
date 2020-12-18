package singleton.cases.b;

public final class SimpleLazySingletonWithValue {

	/**
	 *  Lazy init singleton with value
	 */
	private static SimpleLazySingletonWithValue instance;
	private String value;

	private SimpleLazySingletonWithValue(final String value) {
		this.value = value;
	}

	public static SimpleLazySingletonWithValue getInstance(String value) {
		if (instance == null) {
			instance = new SimpleLazySingletonWithValue(value);
		}
		return instance;
	}

	String getValue() {
		return value;
	}
}
