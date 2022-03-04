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

public class GoogleChromeSteps {
	String browserName = "chrome";
	WebDriver driver;
	
	@Given("new browser is open")
	public void new_browser_is_open() {
		System.out.println("Step - browswer in open");
		if(browserName.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	} else if(browserName.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();    		
    	}
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {
		driver.get("http://www.google.com");
		assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}

	@When("user enters a text search page")
	public void user_enters_a_text_search_page() {
		driver.findElement(By.name("q")).sendKeys("laptop");;
	}

	@When("user clicks on the search button")
	public void user_clicks_on_the_search_button() {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).submit();
	}

	@Then("user is navigated to the search results")
	public void user_is_navigated_to_the_search_results() {
		assertTrue(driver.getPageSource().contains("laptop"));
		
		driver.close();
		driver.quit();
	}

}
