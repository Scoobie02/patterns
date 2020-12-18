package singleton.cases.g;


import org.junit.Test;
import singleton.cases.f.ProperSingleton;

import java.io.*;

public class EnumTest {

	@Test
	public void enumTest() {

		EnumSingleton singleton = EnumSingleton.INSTANCE;
		System.out.println(singleton.getValue()); // output: 0
		singleton.setValue(2);
		System.out.println(singleton.getValue()); // output: 2
	}

	@Test
	public void testSerializable() throws IOException, ClassNotFoundException {
		EnumSingleton instanceOne = EnumSingleton.INSTANCE;
		instanceOne.setValue(2);
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		out.writeObject(instanceOne);
		out.close();
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		EnumSingleton instanceTwo = (EnumSingleton) in.readObject();
		in.close();
		System.out.println(instanceOne.hashCode() + " value: " + instanceOne.getValue());
		System.out.println(instanceOne.hashCode() + " value: " + instanceTwo.getValue());
	}
}