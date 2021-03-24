package pages;

import org.openqa.selenium.By;

import driverfactoryutility.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {

	private AppiumDriver<MobileElement>driver;
	
	private By amazonLogo = By.id("nav-logo-sprites");
	
	private By menu = By.xpath("//i[contains(@class,'nav-icon-a11y')]");
	
	private By signInButton = By.xpath("//a[text()='Sign In' and @class='hmenu-item']");
	
	private By signInRadio = By.xpath("//span[text()='Sign-In']");
	
	private By emailField = By.xpath("//input[@id='ap_email_login' and @name='emailLogin']");
	
	private By submitButton = By.xpath("(//input[@id='continue'])[2]");
	
	private By signinsubmitButton = By.xpath("//input[@id='signInSubmit']");
	
	private By passwordField = By.xpath("//input[@id='ap_password']");
	
	public LoginPage(AppiumDriver<MobileElement>driver)
	{
		this.driver=driver;
	}
	
	public void signInTab()
	{
		driver.findElement(menu).click();
		driver.findElement(signInButton).click();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailField).sendKeys(username);
	}
	
	public void enterPassword(String pwd) throws InterruptedException
	{
		for(int i=0;i<pwd.length();i++)
		{
			Thread.sleep(100);
			driver.findElement(passwordField).sendKeys(pwd.subSequence(i,i+1));
		}
	}
	public void clicksubmit()
	{
		driver.findElement(submitButton).click();
	}
	
	public void clicksigninsubmit()
	{
		driver.findElement(signinsubmitButton).click();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public SearchPage doLogin(String username,String pwd)
	{
		driver.findElement(emailField).sendKeys(username);
		driver.findElement(submitButton).click();
		driver.findElement(passwordField).sendKeys(pwd);
		driver.findElement(signinsubmitButton).click();
		return new SearchPage(driver);
	}
}
