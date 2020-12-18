package singleton.cases.e;

public final class ThreadSafeLazyInitSingleton {

	/**
	 *  Thread safe lazy init singleton
	 */
	private static ThreadSafeLazyInitSingleton instance;
	private ThreadSafeLazyInitSingleton() {}

	public static synchronized ThreadSafeLazyInitSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeLazyInitSingleton();
		}
		return instance;
	}

	public static ThreadSafeLazyInitSingleton getInstanceV2() {
		if(instance == null) {
			synchronized (ThreadSafeLazyInitSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeLazyInitSingleton();
				}
			}
		}
		return instance;
	}
}
