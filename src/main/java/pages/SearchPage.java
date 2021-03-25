package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverfactoryutility.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilities.Helper;

public class SearchPage {

	private AppiumDriver<MobileElement>driver;
	
	private By searchField = By.xpath("//input[@name='k']");
	private By goButton = By.xpath("//input[@class='nav-input']");
	private By firstProduct = By.xpath("(//div[@class='sg-col-inner'])[1]//div/img");
	private By menu = By.xpath("//i[contains(@class,'nav-icon-a11y')]");
	private By logout = By.xpath("//a[text()='Sign Out']");
	private By cross = By.xpath("//div[contains(@class,'hmenu-close-icon')]");
	
	public SearchPage(AppiumDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	
	
	public void searchProduct(String product)
	{
		try {
			driver.findElement(cross).click();
		} catch (Exception e) {}
		driver.findElement(searchField).sendKeys(product);
	}
	
	public void clickGoButton()
	{
		driver.findElement(goButton).click();
	}
	
	public void clickFirstProduct()
	{
		Helper.scrollElementoWeb(firstProduct, driver);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(firstProduct)).isDisplayed();
		driver.findElement(firstProduct).click();
	}
	
	public void navigateBack()
	{
		driver.navigate().back();
	}
	
	public void doLogout()
	{
		driver.findElement(menu).click();
		driver.findElement(logout).click();
	}
	
	public boolean verifyLogin()
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(menu)).isDisplayed();
		driver.findElement(menu).click();	
		//Helper.isElementVisible(logout, driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.scrollElementoWeb(logout, driver);
		return driver.findElement(logout).isDisplayed();
	}
}
