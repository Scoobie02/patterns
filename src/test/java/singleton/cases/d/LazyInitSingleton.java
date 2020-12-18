package singleton.cases.d;

public final class LazyInitSingleton {

	/**
	 *  Lazy init singleton
	 */
	private static LazyInitSingleton instance;
	private LazyInitSingleton() {
	}

	public static LazyInitSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitSingleton();
		}
		return instance;
	}
}
