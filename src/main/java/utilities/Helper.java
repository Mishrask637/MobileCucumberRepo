package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Helper {

	public static void isElementVisible(By locator, AppiumDriver<MobileElement> driver)
	{
		MobileElement element = driver.findElement(locator);
		
		while(!element.isDisplayed())
		{
			  System.out.println("Inside While Looop");
			  Dimension dimensions = driver.manage().window().getSize(); 
			  Double screenHeightStart = dimensions.getHeight() * 0.7; int scrollStart =
			  screenHeightStart.intValue(); 
			  Double screenHeightEnd = dimensions.getHeight()* 0.3; 
			  int scrollEnd = screenHeightEnd.intValue(); 
			  //Double screenHeight =dimensions.getWidth() * 0.3;
			  
			  new TouchAction((PerformsTouchActions)driver).press(PointOption.point(0, scrollStart))
			  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			  .moveTo(PointOption.point(0, scrollEnd)) .release().perform();
			 
			 //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+element.getText()+"\").instance(0));")); 
		
				/*
				 * ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
				 * element);
				 */
			  
		}
		System.out.println("Out of While");
		
	}
}
