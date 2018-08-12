package com.shiftedtech.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.shiftedtech.framework.DriverFactory;
import com.shiftedtech.framework.PageFactory;
import com.shiftedtech.framework.PropertyReaderService;

public class LoginFunctionalTest {
	
	private WebDriver driver = null;
	private PageFactory spree = null;
	
	@Before
	public void setUp() {
		driver = DriverFactory.getInstance("CH").getDriver();
		spree = PageFactory.getInstance();
		
		driver.navigate().to(PropertyReaderService.getInstance().getProperty("APP_URL"));
	}

	@Test
	public void test1() {
		spree.homePage().goToLoginPage();
		spree.loginPage().login("shiftqa01@gmail.com", "shiftedtech");
		spree.homePage().verifyLoginSuccess();
	}
	
	@After
	public void tearDown() {
		DriverFactory.getInstance().removeDriver();
		driver = null;
		spree = null;
	}
}
