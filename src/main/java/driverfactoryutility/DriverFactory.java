package driverfactoryutility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
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
	
	
	public void startServer() {
		CommandLine cmd = new CommandLine("C:\\Users\\SurajM4\\Nodejs\\node.exe");
		cmd.addArgument("C:\\Users\\SurajM4\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"); // C:\\Program
		cmd.addArgument("--address");
		cmd.addArgument("0.0.0.0");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			Thread.sleep(5000);
			executor.execute(cmd, handler);
			Thread.sleep(10000);
			System.out.println("Appium server started successfully");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	public void stopServer() { Runtime runtime =
			 Runtime.getRuntime(); try {
				  runtime.exec("taskkill /F /IM node.js");
				  Thread.sleep(3000);
				  runtime.exec("taskkill /F /IM node.exe");
				  Thread.sleep(5000);
				  System.out.println("Server Stopped successfully"); } catch (IOException e) {
			  e.printStackTrace(); } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
	
	public static AppiumDriver<MobileElement> getdriver()
	{
		return threadlocal.get();
	}
	
}
