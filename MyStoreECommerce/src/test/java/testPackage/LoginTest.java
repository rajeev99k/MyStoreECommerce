package testPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;





import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import testBase.TestBaseClass;
import utilities.Log;
import utilities.util;

//@Listeners(utilities.TestNGITestListen.class)

public class LoginTest extends TestBaseClass 
{
	LandingPage landingpageobj;
	LoginPage loginpageobj;
	HomePage homepageobj;
	ArrayList<String> cnamelist = new ArrayList<String>();
	
	public LoginTest() throws IOException 
	{
		super();
	}
	
	
	  @BeforeSuite
      public static void Setup() {
		/*  Properties props = new Properties();
		  props.load(new FileInputStream("log4j.properties"));
		  Log.configure(props);*/
		  
		 DOMConfigurator.configure("D:\\eclipseProjects\\MyStoreECommerce\\src\\main\\syslogs\\log4j.xml");
		  //DOMConfigurator.configure(".\\log4j.xml");
		  
      }
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		Log.info("Starting Test Setup Activities");
		Initialization();
		landingpageobj = new LandingPage();
		loginpageobj = landingpageobj.clickSignIn();
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		util utilobj = new util();
		Object[][] data = utilobj.fetchExcelData();
		return data;
		
	}
	
	
	@Test(dataProvider = "getData")
	public void loginTest(String username,String password) throws IOException
	{
		loginpageobj = new LoginPage();
		loginpageobj.enteremail(username);
		loginpageobj.enterpassword(password);
		homepageobj = loginpageobj.clickSignIn(); 
		cnamelist.add(homepageobj.getCustomerName());
	}
	
	@AfterMethod
	public void tearDown()
	{
		//Log.info("Closing the browser");
		driver.quit();
	}
	
	
	@AfterClass
	public void setData() throws IOException
	{
		util utilobj = new util();
		utilobj.CreateSheetandSetExcelData(cnamelist);
	}
	

}
