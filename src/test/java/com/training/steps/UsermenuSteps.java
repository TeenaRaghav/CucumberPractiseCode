package com.training.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UsermenuSteps {
	WebDriver driver;
	WebElement usermenu;

	@Given("User is on Salesforce application Login page")
	public void user_is_on_salesforce_application_login_page() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get("https:/login.salesforce.com");
	}

	@When("user enters the valid username {string}")
	public void user_enters_the_valid_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@When("user enters the valid password")
	public void user_enters_the_valid_password() {
		driver.findElement(By.id("password")).sendKeys("pritishtina@1");
	}

	@Then("Clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@When("user clicks on usermenu button")
	public void user_clicks_on_usermenu_button() {
		usermenu = driver.findElement(By.id("userNavLabel"));
		usermenu.click();
	}

	@Then("the usermenu dropdown should displayed")
	public void the_usermenu_dropdown_should_displayed() {
		usermenu.isDisplayed();
	}


@Then("Browser Should be Closed")
public void browser_should_be_closed() {
	if(driver != null) {
    driver.quit();
}
}

}
