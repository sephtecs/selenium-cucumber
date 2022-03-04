package com.selenium_cucumber_runner.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		glue = "com.selenium_cucumber_runner",
		monochrome = true,
		plugin = {	//these create folders and subfolders:
					"pretty", "html:target/HTMLReports/index.html",
					"json:target/JSONReports/report.json",
					"junit:target/XMLReports/report.xml"
			}
		)


public class TestRunner {

}
