package singleton.cases.c;

import org.junit.Test;

import static org.junit.Assert.*;

public class StaticBlockInitSingletonTest {

	@Test
	public void testSameReferenceSingleton() {
		StaticBlockInitSingleton staticBlockInitSingleton1 = StaticBlockInitSingleton.getInstance();
		StaticBlockInitSingleton staticBlockInitSingleton2 = StaticBlockInitSingleton.getInstance();

		assertSame(staticBlockInitSingleton1, staticBlockInitSingleton2);
	}

	@Test
	public void testMultiThreadNotFailureStaticBlockInitializeDuringClassLoading() {
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadFoo());

		threadFoo.start();
		threadBar.start();
	}

	static class ThreadFoo implements Runnable {
		@Override
		public void run() {
			System.out.println(StaticBlockInitSingleton.getInstance());
		}
	}
}
