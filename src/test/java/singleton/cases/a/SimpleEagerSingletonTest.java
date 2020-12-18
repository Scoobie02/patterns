package singleton.cases.a;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SimpleEagerSingletonTest {

	@Test
	public void testSameReferenceSingleton() {
		SimpleEagerSingleton simpleEagerSingleton1 = SimpleEagerSingleton.getInstance();
		SimpleEagerSingleton simpleEagerSingleton2 = SimpleEagerSingleton.getInstance();

		assertSame(simpleEagerSingleton1, simpleEagerSingleton2);
	}

	@Test
	public void testMultiThreadNotFailureBecauseEagerInitialization() {
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadFoo());

		threadFoo.start();
		threadBar.start();
	}

	static class ThreadFoo implements Runnable {
		@Override
		public void run() {
			System.out.println(SimpleEagerSingleton.getInstance());
		}
	}

}
