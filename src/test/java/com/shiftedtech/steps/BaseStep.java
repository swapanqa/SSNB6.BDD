package com.shiftedtech.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.shiftedtech.framework.DriverFactory;
import com.shiftedtech.framework.PropertyReaderService;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseStep {
	//protected static WebDriver driver = null;
	
	protected WebDriver driver = DriverFactory.getInstance(PropertyReaderService.getInstance().getProperty("BROWSER")).getDriver();
	
	//protected WebDriver driver = DriverFactory.getInstance(PropertyReaderService.getInstance().getEnvProperty("TEST_BROWSER")).getDriver();
	
	
}
