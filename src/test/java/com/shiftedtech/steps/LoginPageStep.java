package com.shiftedtech.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageStep extends BaseStep {
	@Then("Browser display Login page")
	public void browser_display_Login_page() {
		String title = driver.getTitle();
	    assertThat(title, startsWith("Login - Spree Demo Site"));
	}

	@When("^User enter user email as \"([^\"]*)\"$")
	public void user_enter_user_email_as(String email) {
	    driver.findElement(By.id("spree_user_email")).sendKeys(email);
	}

	@When("^User enter password as \"([^\"]*)\"$")
	public void user_enter_password_as(String password) {
		driver.findElement(By.id("spree_user_password")).sendKeys(password);
	}

	@When("User click login button")
	public void user_click_login_button() {
	    driver.findElement(By.name("commit")).click();
	}
	
	@Then("^Login not success message \"([^\"]*)\" display$")
	public void login_not_success_message_display(String expectedmsg) {
		 String msg =  driver.findElement(By.cssSelector(".alert-error")).getText();
		 assertThat(msg, startsWith(expectedmsg));
	}

}
