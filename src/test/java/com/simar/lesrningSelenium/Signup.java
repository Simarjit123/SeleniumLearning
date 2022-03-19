package com.simar.lesrningSelenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signup {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Get the URL of the Web page
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximise the browser
		wd.manage().window().maximize();

	}

	@Test
	void verifySignupTest() {
		// email and submit form
		WebElement emailInput = wd.findElement(By.id("email_create"));
		WebElement createAccount = wd.findElement(By.id("SubmitCreate"));
//		emailInput.sendKeys(randomString() + "@gmail.com");
		emailInput.sendKeys(generateRandomString(5) + "@gmail.com");
		createAccount.submit();
		// Signup details form

		WebElement genderInput = wd.findElement(By.id("id_gender2"));
		genderInput.click();

		WebElement firstNameInput = wd.findElement(By.cssSelector("#customer_firstname"));
		// id("customer_firstname"));
		firstNameInput.sendKeys("Simar");

		WebElement lastNameInput = wd.findElement(By.id("customer_lastname"));
		lastNameInput.sendKeys("Kaur");

		WebElement passwordInput = wd.findElement(By.cssSelector("#passwd"));
		passwordInput.sendKeys("Sim123");

		WebElement dateInput = wd.findElement(By.id("days"));
		Select selectDate = new Select(dateInput);
		selectDate.selectByValue("5");

		WebElement monthInput = wd.findElement(By.cssSelector("select[name='months']"));
		Select months1 = new Select(monthInput);
		months1.selectByValue("10");

		WebElement yearInput = wd.findElement(By.id("years"));
		Select years1 = new Select(yearInput);
		years1.selectByValue("2016");

		WebElement addressInput = wd.findElement(By.cssSelector("input[name='address1']"));
		addressInput.sendKeys("Willow road,Guelph");

		WebElement cityInput = wd.findElement(By.id("city"));
		cityInput.sendKeys("guelph");

		WebElement addressStateInput = wd.findElement(By.id("id_state"));
		Select state = new Select(addressStateInput);
		state.selectByIndex(2);

		WebElement addressZipInput = wd.findElement(By.cssSelector("input[ name = 'postcode']"));
		addressZipInput.sendKeys("12345");

		WebElement countryInput = wd.findElement(By.id("id_country"));
		Select country = new Select(countryInput);
		country.selectByValue("21");

		WebElement additionalInput = wd.findElement(By.cssSelector("#other"));
		additionalInput.sendKeys("Hello i am here for signup registration");

		WebElement homePhoneInput = wd.findElement(By.cssSelector("#phone"));
		homePhoneInput.sendKeys("519333");

		WebElement mobPhoneInput = wd.findElement(By.cssSelector("#phone_mobile"));
		mobPhoneInput.sendKeys("3344");

		WebElement aliasAddressInput = wd.findElement(By.cssSelector("#alias"));
		aliasAddressInput.sendKeys("Elmira road,Guelph");

		// wd.findElement(By.cssSelector("#submitAccount")).submit();

//click
		wd.findElement(By.id("uniform-newsletter")).click();

		wd.findElement(By.id("uniform-optin")).click();
		wd.findElement(By.cssSelector("#submitAccount")).click();

		// Assertion
		WebElement submissionCheck = wd.findElement(By.className("page-heading"));
		Assert.assertEquals(submissionCheck.getText(), "MY ACCOUNT", "Please try again later");

	}

	// method to generate alphanumeric string
	public String generateRandomString(int length) {
		String randomString = "";

		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			randomString = randomString + chars[random.nextInt(chars.length)];
		}

		return randomString;

	}

}
