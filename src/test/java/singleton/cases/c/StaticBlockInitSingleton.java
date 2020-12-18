package singleton.cases.c;

public final class StaticBlockInitSingleton {

	/**
	 *  Static block init singleton
	 */
	private static StaticBlockInitSingleton instance;
	public StaticBlockInitSingleton() {
		/*if (instance != null) {
			throw new RuntimeException("Creating singleton second instance");
		}*/
	}

	static {
		try{ instance = new StaticBlockInitSingleton(); }
		catch(Exception e){ throw new RuntimeException("Creating singleton instance failed"); }
	}
	public static StaticBlockInitSingleton getInstance() { return instance; }

}
