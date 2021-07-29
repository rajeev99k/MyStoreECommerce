package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pages.LandingPage;
import utilities.Log;

public class TestBaseClass 
{
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBaseClass() throws IOException
	{
		prop = new Properties();
		FileInputStream input = new FileInputStream("D:\\eclipseProjects\\MyStoreECommerce\\src\\main\\java\\config\\config.properties");
		prop.load(input);
		Log.info("Loading Properties File");
	}
	
	public void Initialization()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\eclipseProjects\\MyStoreECommerce\\src\\main\\java\\config\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info("Launching Chrome Browser");
		}
		else if(prop.getProperty("browser").equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\eclipseProjects\\MyStoreECommerce\\src\\main\\java\\config\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Log.info("Launching ie Browser");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Log.info("Navigating to url -> "+ prop.getProperty("url"));
		
	}
	
	//Trying fetching/pulling from Git
	
	
}
