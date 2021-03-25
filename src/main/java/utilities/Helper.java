package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Helper {

	public static void isElementVisible(By locator, AppiumDriver<MobileElement> driver) {
		MobileElement element = driver.findElement(locator);

		/*
		 * while(!element.isDisplayed()) { System.out.println("Inside While Looop");
		 * Dimension dimensions = driver.manage().window().getSize(); Double
		 * screenHeightStart = dimensions.getHeight() * 0.7; int scrollStart =
		 * screenHeightStart.intValue(); Double screenHeightEnd =
		 * dimensions.getHeight()* 0.3; int scrollEnd = screenHeightEnd.intValue();
		 * //Double screenHeight =dimensions.getWidth() * 0.3;
		 * 
		 * new TouchAction((PerformsTouchActions)driver).press(PointOption.point(0,
		 * scrollStart)) .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		 * .moveTo(PointOption.point(0, scrollEnd)) .release().perform();
		 * 
		 * //driver.findElement(MobileBy.
		 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
		 * +element.getText()+"\").instance(0));"));
		 * 
		 * 
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
		 * element);
		 * 
		 * 
		 * }
		 */
		
		while(driver.findElements(locator).size()==0){

			Dimension size = driver.manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.20);
			int startx = size.width / 2;
			System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

			new TouchAction((PerformsTouchActions)driver).press(PointOption.point(0,starty)) .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					 .moveTo(PointOption.point(0, endy)) .release().perform();
			
			/*driver.swipe(startx, starty, startx, endy, 3000);
			Thread.sleep(2000);
			driver.swipe(startx, endy, startx, starty, 3000);
			Thread.sleep(2000);*/
			}
		
		System.out.println("Out of While");

	}
	
	
	
	
	public static void scrollElementoWeb(By locator, AppiumDriver<MobileElement> driver){
		WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    try{
	        int x = element.getLocation().getX();
	        int y = element.getLocation().getY();
	        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	    }catch(Exception e){
	        try{
	            js.executeScript("arguments[0].scrollIntoView(true);",element);
	        }catch(Exception f){
	           // assert false,"No se pudo realizar scroll en la pagina web en el elemento ${params."Tipo ID"}:'${params.ID}'. ${f}"
	        }
	    }   
	}
}
