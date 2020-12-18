package singleton.cases.e;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ThreadSafeLazyInitSingletonTest {

	@Test
	public void testSameReferenceSingleton() {
		ThreadSafeLazyInitSingleton threadSafeLazyInitSingleton1 = ThreadSafeLazyInitSingleton.getInstance();
		ThreadSafeLazyInitSingleton threadSafeLazyInitSingleton2 = ThreadSafeLazyInitSingleton.getInstance();

		assertSame(threadSafeLazyInitSingleton1, threadSafeLazyInitSingleton2);
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
			System.out.println(ThreadSafeLazyInitSingleton.getInstance());
		}
	}

}
