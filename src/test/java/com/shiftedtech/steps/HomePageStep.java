package com.shiftedtech.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.openqa.selenium.By;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStep extends BaseStep {
	
	@Then("Spree home page should display")
	public void spree_home_page_should_display() {
	    String title = driver.getTitle();
	    assertThat(title, startsWith("Spree Demo Site"));
	}

	@When("User click login link")
	public void user_click_login_link() {
	    driver.findElement(By.linkText("Login")).click();
	}
	
	@Then("Home page should display")
	public void home_page_should_display() {
		String title = driver.getTitle();
	    assertThat(title, startsWith("Spree Demo Site"));
	}

	@Then("Login success message display")
	public void login_success_message_display() {
	   String msg =  driver.findElement(By.cssSelector(".alert-success")).getText();
	   assertThat(msg, startsWith("Logged in successfully"));
	}

}
