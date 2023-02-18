package com.ibm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleAutomatedTest {
	
	private SafariOptions options = new SafariOptions();
	private WebDriver driver = new SafariDriver(options);
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.safari.driver", "/Users/ionut/workspace/trainings/java-ibm/src/test/resources/chromedriver");
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.navigate()
		      .to("https://www.calculator.net/mortgage-payoff-calculator.html");
		
		Thread.sleep(2000);
	}
	
	
	
	
}
