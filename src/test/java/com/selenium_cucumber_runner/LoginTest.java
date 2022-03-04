package com.selenium_cucumber_runner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

//glue code - selenium stuff
public class LoginTest {
	String browserName = "chrome";
	
	WebDriver driver;
	
	@Given("browswer is open")
	public void browswer_is_open() {
		System.out.println("Step - browswer in open");
		if(browserName.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	} else if(browserName.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();    		
    	}
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Step - user is on login page");
		driver.get("http://www.saucedemo.com");
		assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("Step - user enters username and password");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("Step - user clicks on login button");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	@Then("user is be navigated to the home page")
	public void user_is_be_navigated_to_the_home_page() {
		assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
	}
}
