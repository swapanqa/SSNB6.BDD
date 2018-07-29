package com.shiftedtech.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SpreeCommon extends BaseStep{

	@Before
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Given("Not a validated user")
	public void not_a_validated_user() {
		driver.manage().deleteAllCookies();
	}

	@When("User browse to the site")
	public void user_browse_to_the_site() {
	    driver.navigate().to("http://spree.shiftedtech.com/");
	}
}
