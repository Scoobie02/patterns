package singleton.cases.b;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SimpleLazySingletonWithValueTest {

	@Test
	public void testSameReferenceSingleton() {
		SimpleLazySingletonWithValue simpleLazySingletonWithValue1 = SimpleLazySingletonWithValue.getInstance("FOO");
		SimpleLazySingletonWithValue simpleLazySingletonWithValue2 = SimpleLazySingletonWithValue.getInstance("BAR");

		assertSame(simpleLazySingletonWithValue1, simpleLazySingletonWithValue2);
	}

	@Test
	public void testMultiThreadFailure() {
		Thread threadFoo = new Thread(new ThreadFoo());
		Thread threadBar = new Thread(new ThreadBar());

		threadFoo.start();
		threadBar.start();
	}

	static class ThreadFoo implements Runnable {
		@Override
		public void run() {
			SimpleLazySingletonWithValue singleton = SimpleLazySingletonWithValue.getInstance("FOO");
			System.out.println(singleton.getValue());
		}
	}

	static class ThreadBar implements Runnable {
		@Override
		public void run() {
			SimpleLazySingletonWithValue singleton = SimpleLazySingletonWithValue.getInstance("BAR");
			System.out.println(singleton.getValue());
		}
	}

}
