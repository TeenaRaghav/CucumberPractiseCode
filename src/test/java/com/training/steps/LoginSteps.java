package com.training.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;
	@Given("User has opened the application url")
	public void user_has_opened_the_application_url() {
		if(driver==null) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	}
	
	@Given("Navigated to login page")
	public void navigated_to_login_page() {
		driver.get("https:/login.salesforce.com/");    	
	}
	
	@When("User enters the valid username {string}")
	public void user_enters_the_valid_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@When("User enters the valid password")
	public void user_enters_the_valid_password() {
		driver.findElement(By.id("password")).sendKeys("pritishtina@1");
	}
	
	@When("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("Login")).click();
	}
	
	@Then("User should be able to successfully login")
	public void user_should_be_able_to_successfully_login() {
	 String actualpagetitle =driver.getTitle();
	 String Expectedpagetitle = "Home Page ~ Salesforce -Developer Edition";
	 if(actualpagetitle.equalsIgnoreCase(Expectedpagetitle)) {
		 System.out.println("login successful");
	 }
	}
	@And("Close the browser")
	@After
	public void close_the_browser() {
		if(driver != null) {
		driver.quit();
		}
	
	}
	@When("User enters the invalid username {string}")
	public void user_enters_the_invalid_username(String username) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Then("User should not able to successfully login")
	public void user_should_not_able_to_successfully_login() {
		
		if(driver.getTitle().equalsIgnoreCase("Login|Salesforce")) {
			System.out.println("Error message is diplayed");
		}
	}
	@Then("Get a proper warning message")
	public void get_a_proper_warning_message() {
		String errormessage =driver.findElement(By.xpath("(//div[@class='loginError'])[2]")).getText();
		if(errormessage.contentEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) {
			System.out.println("Login failed.");
		}
	}
	
}
