package com.shiftedtech.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shiftedtech.framework.DriverFactory;

public class LoginPage {
	
	@FindBy(id="spree_user_email")
	private WebElement emailTextbox;
	
	@FindBy(id="spree_user_password")
	private WebElement passwordTextbox;
	
	@FindBy(name="commit")
	private WebElement loginButton;
	
	@FindBy(css=".alert-error")
	private WebElement errorMeg;
	
	public LoginPage() {
		
		WebDriver driver = DriverFactory.getInstance().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void setEmailAdderss(String email) {
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void login(String email, String password) {
		setEmailAdderss(email);
		setPassword(password);
		clickLogin();
	}
	
	public void verifyTitle() {
		String title = DriverFactory.getInstance().getDriver().getTitle();
	    assertThat(title, startsWith("Login - Spree Demo Site"));
	}
	public void verifyLoginError(String expectedmsg) {
		String msg =  errorMeg.getText();
		assertThat(msg, startsWith(expectedmsg));
	}

}
