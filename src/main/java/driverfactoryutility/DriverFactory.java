package driverfactoryutility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	public static AppiumDriver<MobileElement> driver;
	
	private static ThreadLocal<AppiumDriver> threadlocal = new ThreadLocal<>();
	
	public AppiumDriver<MobileElement> init_driver(String devicename,String platformname,String platformversion,String udid,String browsername,String noreset,String automationname)
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", devicename);
		cap.setCapability("platformName", platformname);
		cap.setCapability("platformVersion", platformversion);
		cap.setCapability("udid", udid);
		cap.setCapability(CapabilityType.BROWSER_NAME, browsername);
		cap.setCapability("noReset", noreset);
		cap.setCapability("automationName", automationname);
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		threadlocal.set(driver);
		return getdriver();
	}
	
	
	public static AppiumDriver<MobileElement> getdriver()
	{
		return threadlocal.get();
	}
	
}
