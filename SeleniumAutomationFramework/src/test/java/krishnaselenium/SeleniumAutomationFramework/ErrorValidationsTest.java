package krishnaselenium.SeleniumAutomationFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import krishnaselenium.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void loginFailureTest() throws IOException

	{
		// String product1 = "ZARA COAT 3";
		String loginId = "vamshikrish@gmail.com";
		String passcode = "Vamshi@12387";

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		loginPage.loginActions(loginId, passcode); // logged in to application
		Assert.assertEquals("Incorrect email or password.", loginPage.errorValidation());

	}
	
	@Test
	
	public void productSelectValidations() {
		String product1 = "ZARA COAT 33";
		String loginId = "rahulshetty1467@gmail.com";
		String passcode = "Vamshi@123";

		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		ProductsCatalougePage prodcart = loginPage.loginActions(loginId, passcode); // logged in to application

		prodcart.getProducts(); // get the products
		prodcart.clickonAddtoCart(product1);

		CartPage cartTab = prodcart.clickonAddToCartTab();

		// moved to cart page

		Boolean match = cartTab.verifyItemsinCart(product1);
		Assert.assertFalse(match);
	}
}
