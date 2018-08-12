package com.shiftedtech.framework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverFactory {
	
	private ThreadLocal<WebDriver> driverCollection = new ThreadLocal<WebDriver>();
	
	private static String LOCAL_GRID_URL = "http://10.10.20.70:4444/wd/hub";
 
	
	private static DriverFactory instance = null;
	
	private DriverFactory() {
	}
	
	public static DriverFactory getInstance() {
		
		
		return getInstance(null);
	}

	public static DriverFactory getInstance(String browser) {
		if(instance == null) {
			instance = new DriverFactory();
		}
		
		if(browser == null) {
			browser = "";
		}
		
		if(instance.driverCollection.get() == null) {
			
			if(browser.toUpperCase().contentEquals("FF")) {
				
				//System.setProperty("webdriver.gecko.driver","C:\\MyDevelopment\\webdrivers\\geckodriver.exe");
				FirefoxDriverManager.getInstance().arch64().setup();
				
				//DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
				//capabilities.setBrowserName("firefox");
				//capabilities.setVersion("56.0");
				//capabilities.setPlatform(Platform.WINDOWS);
				//capabilities.setCapability("marionette", true);
				
				//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		       // capabilities.setCapability("marionette", true);
		        
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability("marionette", true);
				 
				WebDriver driver = new FirefoxDriver(options);
		        instance.driverCollection.set(driver);
			}
			else if(browser.toUpperCase().contentEquals("CH")) {
				ChromeDriverManager.getInstance().setup();
				WebDriver driver = new ChromeDriver();
		        instance.driverCollection.set(driver);
			}
			else if(browser.toUpperCase().contentEquals("IE")) {
				InternetExplorerDriverManager.getInstance().arch32().setup();
				WebDriver driver = new InternetExplorerDriver();
		        instance.driverCollection.set(driver);
			}
			else if(browser.toUpperCase().contentEquals("GRID-CH")) {
				 DesiredCapabilities caps = new DesiredCapabilities();
		         caps.setPlatform(Platform.ANY);
		         caps.setBrowserName("chrome");
		         try {
		        	 WebDriver driver = new RemoteWebDriver(new URL(LOCAL_GRID_URL),caps);
		             instance.driverCollection.set(driver);
		            } catch (MalformedURLException e) {
		                e.printStackTrace();
		            }
			}
			else {
				ChromeDriverManager.getInstance().setup();
				WebDriver driver = new ChromeDriver();
		        instance.driverCollection.set(driver);
			}
  
		}


		return instance;
	}
	

		    
	public WebDriver getDriver() {
		return driverCollection.get();
	}
	
	public void removeDriver() // Quits the driver and closes the browser
	{
		driverCollection.get().quit();
		driverCollection.remove();
	}

}
