package singleton.cases.f;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

import static org.junit.Assert.assertSame;

public class ProperSingletonTest {

	@Test
	public void testSameReferenceSingleton() {
		ProperSingleton properSingleton1 = ProperSingleton.getInstance();
		ProperSingleton properSingleton2 = ProperSingleton.getInstance();

		assertSame(properSingleton1, properSingleton2);
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
			System.out.println(ProperSingleton.getInstance());
		}
	}

	@Test
	public void failure() {
		// Tworzymy pierwszą instancję
		ProperSingleton instanceOne = ProperSingleton.getInstance();
		// Tworzymy drugą instancję przy pomocy refleksji
		ProperSingleton instanceTwo = null;
		try {
			Constructor[] constructors = ProperSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				//ustawiamy dostępność konstruktora
				constructor.setAccessible(true);
				instanceTwo = (ProperSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) { e.printStackTrace(); }
		/**
		 * Jak widać hashCode zwraca inny wynik w obu przypadkach.
		 */
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

	@Test
	public void testSerializable() throws IOException, ClassNotFoundException {
		ProperSingleton instanceOne = ProperSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceOne);
		out.close();
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		ProperSingleton instanceTwo = (ProperSingleton) in.readObject();
		in.close();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
