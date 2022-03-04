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

public class TestProjectLoginSteps {
	String browserName = "chrome";
	WebDriver driver;
	
	@Given("new tab is open")
	public void new_tab_is_open() {
		System.out.println("#Step 1 - tab in open");
		if(browserName.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	} else if(browserName.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();    		
    	}
	}

	@Given("user is on login page of test project")
	public void user_is_on_login_page_of_test_project() {
		System.out.println("#Step 2 - user is on login page");
		driver.get("https://example.testproject.io/web/");
		assertTrue(driver.findElement(By.id("login")).isDisplayed());
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		System.out.println("#Step 3 - user enters username and password");
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("user clicks on login button of test project")
	public void user_clicks_on_login_button_of_test_project() {
		System.out.println("#Step 4 - user clicks on login button");
		driver.findElement(By.id("login")).click();
	}

	@Then("user is be navigated to the home page of test project")
	public void user_is_be_navigated_to_the_home_page_of_test_project() {
		assertTrue(driver.findElement(By.id("logout")).isDisplayed());
		System.out.println("#Step 5 - user is navigated back to home page");
	}
}
