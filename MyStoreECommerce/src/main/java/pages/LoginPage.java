package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;
import utilities.Log;

public class LoginPage extends TestBaseClass
{

	public LoginPage() throws IOException 
	{
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement loginemail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement loginpassword;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement SigninButton;
	
	
	public void enteremail(String emailid)
	{
		loginemail.sendKeys(emailid);
		Log.info("Entering email id- "+ emailid);
	}
	
	public void enterpassword(String password)
	{
		loginpassword.sendKeys(password);
		Log.info("Entering password- " + password);
	}
	
	public void enterdetails(String email,String password)
	{
		loginemail.sendKeys(email);
		loginpassword.sendKeys(password);
	}
	
	
	public HomePage clickSignIn() throws IOException
	{
		SigninButton.click();
		Log.info("Clicking on SignIn button in "+ LoginPage.class.getName());
		return new HomePage();
	}
	
}
