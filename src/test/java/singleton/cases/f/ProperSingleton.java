package singleton.cases.f;

import java.io.Serializable;

public final class ProperSingleton implements Serializable {
	private static final long serialVersionUID = -1104762320317737265L;
	/**
	 *  Thread safe Eager init singleton
	 */
	private ProperSingleton() {}

	private static class SingletonHelper {
		private static final ProperSingleton INSTANCE = new ProperSingleton();
	}

	public static ProperSingleton getInstance() { return SingletonHelper.INSTANCE; }

	//protected Object readResolve() { return getInstance(); }
}
