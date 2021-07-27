package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import testBase.TestBaseClass;
import utilities.Log;

public class HomeTest extends TestBaseClass
{

	public HomeTest() throws IOException 
	{
		super();
	}

	
	@Test
	public void print()
	{
		Log.info("Home Test started");
		System.out.println("HomeTest");
	}
}
