package hooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import driverfactoryutility.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class AppHooks {

	AppiumDriver<MobileElement> driver;
	private DriverFactory driverfactory;
	private ConfigReader reader ;
	private Properties prop;
	
	
	@Before(order=0)
	public void initprop()
	{
		driverfactory = new DriverFactory();
		reader = new ConfigReader();
		prop = reader.intiProp();
	}
	
	@Before(order=1)
	public void startServer(Scenario scenario)
	{
		if(scenario.getName().equals("Amazon login scenario"))
		{
			driverfactory.startServer();
		}
		else
		{
			System.out.println("Server Already Started");
		}
	}
	
	@Before(order = 2)
	public void initialise()
	{
		String devicename = prop.getProperty("devicename");
		String platformname = prop.getProperty("platformname");
		String platformversion = prop.getProperty("platformversion");
		String udid = prop.getProperty("udid");
		String browsername = prop.getProperty("browsername");
		String noreset = prop.getProperty("noreset");
		String automationname = prop.getProperty("automationname");
		driver = driverfactory.init_driver(devicename, platformname, platformversion,udid, browsername, noreset, automationname);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After(order=1)
	public void quit()
	{
		driver.quit();
	}
	
	@After(order=0)
	public void stopServer(Scenario scenario)
	{
		if(scenario.getName().equals("Search a mobile device"))
		{
			driverfactory.stopServer();
		}
		else
		{
			System.out.println("Scenario is remaining");
		}
	}
	
}
