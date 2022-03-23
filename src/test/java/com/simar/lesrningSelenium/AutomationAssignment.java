package com.simar.lesrningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationAssignment {

	WebDriver wd;
	Actions action;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path}
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Get the URL of the page
		wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximise the browser
		wd.manage().window().maximize();
	}

	@Test
	public void testShoppingWebPage() {

		// step 1-LOGIN TO PORTAL WebElement
		WebElement emailInput = wd.findElement(By.cssSelector("#email"));
		emailInput.sendKeys("sim1234@gmail.com");
		WebElement passwordInput = wd.findElement(By.cssSelector("#passwd"));
		passwordInput.sendKeys("123456");
		WebElement signInClickBtn = wd.findElement(By.cssSelector("#SubmitLogin"));
		signInClickBtn.click();

		// step2- ASSERT NAME
		WebElement customerAccountName = wd.findElement(By.cssSelector(".account"));
		Assert.assertEquals(customerAccountName.getText(), "Sim sim");

		// Step 3-CLICK ON WOMEN
		WebElement womenButtonClick = wd.findElement(By.cssSelector(".sf-with-ul"));
		womenButtonClick.click();

		// Step 4-CLICK QUICK VIEW
		WebElement fadedShortSleeveTshirt = wd.findElement(By.cssSelector(".product_img_link"));
		fadedShortSleeveTshirt.click();

		// Step5-INCREASE QUANTITY TO 2
		/*
		 * 
		 * WebElement addQuantity = wd.findElement(By.cssSelector("quantity_wanted"));
		 * addQuantity.clear(); addQuantity.sendKeys("2");
		 */
		
		//Step 6-Select Size as L

		/*
		 * WebElement sizeSelection = wd.findElement(By.id("group_1"));
		 * sizeSelection.sele
		 */
		
		//Step7-ADD TO CART
		WebElement addToCart = wd.findElement(By.cssSelector("#add_to_cart"));
		addToCart.click();
		
	}

}
