package singleton.cases.a;

public final class SimpleEagerSingleton {
	/**
	 *  Eager initialization what is a minus if we dont need it
	 */
	private final static SimpleEagerSingleton instance = new SimpleEagerSingleton();

	private SimpleEagerSingleton() {
	}

	public static SimpleEagerSingleton getInstance() {
		return instance;
	}

}
