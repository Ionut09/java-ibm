package com.ibm;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;
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
		
		options = new ChromeOptions()//.addArguments("--headless") //--> folosing arg. --headless nu va mai porni interfata Chrome, ci o va rula in background
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
	
	@Test
	public void testMonthlyPayment() {
		//given
		driver.navigate()
		      .to("https://www.calculator.net/mortgage-payoff-calculator.html");
		driver.manage()
		      .window()
		      .maximize();
		
		// Enter value 100000 in the first number of the percent Calculator
		WebElement element = driver.findElement(By.name("cloanamount")); ////amount
		element.clear();
		element.sendKeys("50000");
		sleep(500);
		
		element = driver.findElement(By.name("cloanterm")); //period
		element.clear();
		element.sendKeys("20");
		sleep(500);
		
		element = driver.findElement(By.name("cinterestrate")); //interest rate
		element.clear();
		element.sendKeys("7.5");
		sleep(500);
		
		element = driver.findElement(By.name("cremainingyear"));
		element.clear();
		element.sendKeys("20");
		sleep(500);
		
		element = driver.findElement(By.name("cremainingmonth"));
		element.clear();
		element.sendKeys("0");
		
		driver.findElement(By.xpath("//*[@id=\"calinputtable\"]/tbody/tr[5]/td/label[4]/span"))
		      .click();
		
		//when
		driver.findElement(By.xpath("//*[@id=\"calinputtable\"]/tbody/tr[6]/td/input[2]"))
		      .click();
		
		//then
		element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/table/tbody/tr[1]/td[2]"));
		System.out.println(element.getTagName());
		
		BigDecimal money = new BigDecimal(402.80);
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		String expectedFormattedAmount = formatter.format(money); //this formats the amount to $402.80
		assertEquals(element.getText(), expectedFormattedAmount);
	}
	
	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
