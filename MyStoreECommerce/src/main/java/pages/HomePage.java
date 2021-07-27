package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;
import utilities.Log;

public class HomePage extends TestBaseClass
{

	public HomePage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@class='account']/span")
	WebElement customername;
	
	
	public String getCustomerName()
	{
		Log.info("Capturing customer name");
		return customername.getText();
	}

}
