package com.simar.lesrningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AutomationAssignment {

	WebDriver wd;

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

		wd.switchTo().frame(0);
		WebElement addQuantity = wd.findElement(By.cssSelector("#quantity_wanted"));
		/*
		 * Actions action = new Actions(wd);
		 * action.moveToElement(addQuantity).build().perform();
		 */
		addQuantity.clear();

		addQuantity.sendKeys("2");

		// Step 6-Select Size as L

		WebElement sizeSelection = wd.findElement(By.cssSelector("#group_1"));
		Select sizeSelect = new Select(sizeSelection);
		sizeSelect.selectByValue("3");

		// Step7-CLICK ON ADD TO CART"a[title='Proceed to checkout']

		WebElement addToCart = wd.findElement(By.cssSelector("#add_to_cart"));
		addToCart.click();
		wd.switchTo().defaultContent();

		// Step 8- ASSERT SUCCESS MESSAGE

		WebElement successMessage = wd.findElement(By.cssSelector("div.layer_cart_product.col-xs-12.col-md-6>h2"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(successMessage.getText(), "Product successfully added to your shopping cart");

		// Step 9-ASSERT QTY & PRODUCT

//product name assert
		WebElement productName = wd.findElement(By.cssSelector("#layer_cart_product_title"));
		Assert.assertEquals(productName.getText(), "Faded Short Sleeve T-shirts");

		// product quantity assert
		WebElement productQuantity = wd.findElement(By.id("layer_cart_product_quantity"));
		Assert.assertEquals(productQuantity.getText(), "2");

		// Step 10- PROCEED TO CHECKOUT
		WebElement checkOutClick1 = wd.findElement(By.cssSelector("a.btn.btn-default.button.button-medium"));
		checkOutClick1.click();

		// Step11- ASSERT totalPrice

		WebElement totalPrice = wd.findElement(By.cssSelector("#total_price"));
		Assert.assertEquals(totalPrice.getText(), "$35.02");

		// Step 12-CLICK PROCEED TO CHECKOUT
		WebElement checkOutClick2 = wd
				.findElement(By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium"));
		checkOutClick2.click();

		// Step 13-Enter in TextBox
		WebElement addMessage = wd.findElement(By.cssSelector("textarea[name = 'message']"));
		addMessage.sendKeys("I am buying new clothes");

		// Step14-CLICK ON PROCEED TO CHECKOUT
		WebElement checkOutClick3 = wd.findElement(By.cssSelector("button[name='processAddress']"));
		checkOutClick3.click();

		// Step 15-SELECT THE CHECKBOX

		// WebElement selectCheckbox = wd.findElement(By.cssSelector("p.checkbox"));

		WebElement selectCheckBox = wd.findElement(By.cssSelector("#cgv"));
		selectCheckBox.click();

		// Step16- proceed to checkout
		WebElement checkOutClick4 = wd.findElement(By.cssSelector("button[name='processCarrier']"));
		checkOutClick4.click();

		// STEP 17-CLICK ON PAY WITH WIRE
		WebElement payByWire = wd.findElement(By.cssSelector(".bankwire"));
		payByWire.click();

		// STEP 18-ASSERT PAYMENT METHOD
		WebElement bankWireAssertion = wd.findElement(By.cssSelector(".page-subheading"));

		Assert.assertEquals(bankWireAssertion.getText(), "BANK-WIRE PAYMENT.");

		// STEP 19-CLICK ON CONFIRM ORDER
		WebElement confirmOrderClick = wd.findElement(By.cssSelector("button.button.btn.btn-default.button-medium"));
		confirmOrderClick.click();

		// STEP 20-ASSERT ORDER CONFIRMATION
		WebElement orderConfirmAssertion = wd.findElement(By.cssSelector("p.cheque-indent"));
		Assert.assertEquals(orderConfirmAssertion.getText(), "Your order on My Store is complete.");

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
