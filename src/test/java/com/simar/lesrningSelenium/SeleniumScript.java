package com.simar.lesrningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumScript {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		driver = new ChromeDriver();

		// Get the URL of the Web page
		driver.get("http://automationpractice.com/index.php?controller=contact");

		// Maximise the browser
		driver.manage().window().maximize();

	}

	@Test
	public void sendKeys() {

		// Identifying the elements
		WebElement subjectHeading = driver.findElement(By.id("id_contact"));
		Select select = new Select(subjectHeading);
		select.selectByIndex(2);

		WebElement email = driver.findElement(By.id("email"));
		WebElement orderReference = driver.findElement(By.id("id_order"));
		WebElement message = driver.findElement(By.id("message"));
		WebElement sendMessageButton = driver.findElement(By.id("submitMessage"));

		// perform sendKeys
		email.sendKeys("simar@gmail.com");
		orderReference.sendKeys("12345");
		message.sendKeys("i want to place an order");
//clicking
		sendMessageButton.click();

	}

	@AfterMethod
	public void tearDown() {
//driver.quit();
	}
}
