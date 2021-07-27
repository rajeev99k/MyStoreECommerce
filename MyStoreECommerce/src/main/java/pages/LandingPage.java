package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;
import utilities.Log;

public class LandingPage extends TestBaseClass 
{

	public LandingPage() throws IOException 
	{
		super();
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement SignInLink;
	
	@FindBy(xpath = "//a[@title='Contact Us']")
	WebElement ContactUsLink;
	
	@FindBy(xpath = "//a[@title = 'My Store']/*[1]")
	WebElement title;
	
	@FindBy(xpath ="//span[@class= 'shop-phone']/strong")
	WebElement CallusText;
	
	
	
	public LoginPage clickSignIn() throws IOException
	{
		SignInLink.click();
		Log.info("Clicking on SignIn link in "+LandingPage.class.getName());
		return new LoginPage();
	}

}
