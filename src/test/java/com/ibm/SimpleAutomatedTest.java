package com.ibm;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleAutomatedTest {
	
	private ChromeOptions options;
	private WebDriver driver;
	private Wait wait;
	
	@BeforeMethod
	public void setupDriver() {
		//in acest fel ii spunem lui selenium de locatia driverului
		System.setProperty("webdriver.chrome.driver",
			"/Users/ionut/workspace/trainings/java-ibm/src/test/resources/chromedriver");
		
		options = new ChromeOptions()//.addArguments("--headless") //--> folosing arg. --headless nu va mai porni interfata Chrome, ci va rula in background
		                             .addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
		
		//Puts an Implicit wait, Will wait for 2 seconds before throwing exception
		driver.manage()
		      .timeouts()
		      .implicitlyWait(2, SECONDS);
		
		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
		                               .pollingEvery(Duration.ofSeconds(1))
		                               .ignoring(NoSuchElementException.class);
	}
	
	@AfterMethod
	public void after() {
		driver.close();
	}
	
	@Test
	public void textBox() {
		driver.navigate()
		      .to("http://www.calculator.net/percent-calculator.html");
		
		driver.manage()
		      .window()
		      .maximize(); //maximizeaza fereastra de Chrome
		
		// Enter value 10 in the first number of the percent Calculator
		String inputValue = "10";
		driver.findElement(By.id("cpar1"))
		      .sendKeys(inputValue);
		
		// Get the text box from the application
		String result = driver.findElement(By.id("cpar1"))
		                      .getAttribute("value");
		
		assertEquals(result, inputValue);
	}
	
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMonthlyPayLogic() {
		//Given
		driver.navigate()
		      .to("http://www.calculator.net/mortgage-calculator.html");
		driver.manage()
		      .window()
		      .maximize();
		//When
		By checkBoxXpath = By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/table/tbody/tr[6]/td/label/span");
		WebElement checkBox = driver.findElement(checkBoxXpath);
		sleep(2000);
		checkBox.click();
		sleep(2000);
		checkBox.click();
		
		assertTrue(driver.findElement(checkBoxXpath)
		                 .isSelected());
		assertTrue(checkBox.isEnabled());
		assertTrue(checkBox.isDisplayed());
		
	}
	
	@Test 
	public void checkBox() {
		//Given
		driver.navigate()
		      .to("http://www.calculator.net/mortgage-calculator.html");
		driver.manage()
		      .window()
		      .maximize();
		
		//When
		By checkBoxXpath = By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr/td[1]/table/tbody/tr[6]/td/label/span");
		WebElement checkBox = driver.findElement(checkBoxXpath);
		sleep(2000);
		checkBox.click();
		sleep(2000);
		checkBox.click();
		sleep(2000);
		checkBox.click();
		
		assertFalse(driver.findElement(checkBoxXpath)
		                 .isSelected());
		assertTrue(checkBox.isEnabled());
		assertTrue(checkBox.isDisplayed());
	}
}
