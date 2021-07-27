package testPackage;

import org.testng.TestNG;

import utilities.TestNGITestListen;

public class TestRunner 
{
	static TestNG testng;

	public static void main(String[] args) 
	{
		TestNGITestListen listenerobj = new  TestNGITestListen();
		testng = new TestNG();
		
		testng.setTestClasses(new Class[] {LoginTest.class });
		testng.addListener(listenerobj);
		testng.run();

	}

}
