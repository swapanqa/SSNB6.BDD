package com.shiftedtech.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shiftedtech.framework.DriverFactory;

public class HomePage {
	
	@FindBy(linkText="Login")
	private WebElement loginLink;
	
	@FindBy(css=".alert-success")
	private WebElement successMsg;
	
	public HomePage() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void goToLoginPage() {
		loginLink.click();
	}
	
	public void veryfyTitle() {
		String title = DriverFactory.getInstance().getDriver().getTitle();
	    assertThat(title, startsWith("Spree Demo Site"));
	}
	
	public void verifyLoginSuccess() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg =  successMsg.getText();
		assertThat(msg, startsWith("Logged in successfully"));
	}

}
