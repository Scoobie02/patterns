package singleton.cases.d;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.*;

public class LazyInitSingletonTest {

	@Test
	public void testSameReferenceSingleton() {
		LazyInitSingleton lazyInitSingleton1 = LazyInitSingleton.getInstance();
		LazyInitSingleton lazyInitSingleton2 = LazyInitSingleton.getInstance();

		assertSame(lazyInitSingleton1, lazyInitSingleton2);
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
			System.out.println(LazyInitSingleton.getInstance());
		}
	}

}
