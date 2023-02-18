package com.ibm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SimpleAutomatedTest {
	
	private ChromeOptions options = new ChromeOptions()
		                                .addArguments("--no-sandbox");
	private WebDriver driver = new ChromeDriver(options);
	
	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
			"/Users/ionut/workspace/trainings/java-ibm/src/test/resources/chromedriver");
		
		driver.navigate()
		      .to("https://www.calculator.net/mortgage-payoff-calculator.html");
		
		Thread.sleep(2000);
	}
	
}
