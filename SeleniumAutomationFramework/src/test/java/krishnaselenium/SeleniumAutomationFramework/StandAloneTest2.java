package krishnaselenium.SeleniumAutomationFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import krishnaselenium.TestComponents.BaseTest;
import krishnaselenium.abstractclasses.abstractclassforwait;

public class StandAloneTest2 extends BaseTest {

	@Test(dataProvider = "getDataSets", groups = "Purchase")
	public void SubmitOrder(HashMap<String,String> inputValues) throws IOException

	{
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		ProductsCatalougePage prodcart = loginPage.loginActions(inputValues.get("email"), inputValues.get("password")); // logged in to application
		
		List<WebElement> products = prodcart.getProducts();
		//prodcart.getProductbyName(inputValues.get("productname")); // get the products
		prodcart.clickonAddtoCart(inputValues.get("productname"));

		CartPage cartTab = prodcart.clickonAddToCartTab();

		// moved to cart page

		Boolean match = cartTab.verifyItemsinCart(inputValues.get("productname"));
		Assert.assertTrue(match);
		// adds to cart

		CheckOutPage checkoutPage = cartTab.clickonCheckOut(); // clicks on checkout button in cart section
		checkoutPage.enterCountryName();
		checkoutPage.clickOnCountry();
		// Thread.sleep(5000);
		// checkoutPage.clickOnPlaceOrder();
		//

	}
	

	@DataProvider

	public Object[][] getDataSets() throws IOException {
		
		/*HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "vamshikrish@gmail.com");
		map.put("password", "Vamshi@123");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "rahulshetty1467@gmail.com");
		map1.put("password", "Vamshi@123");
		map1.put("productName", "ADIDAS ORIGINAL");*/
		
	List<HashMap<String, String>> jdata =	getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\SeleniumAutomation.PageObjectModel\\krishnaselenium\\data\\DataProvider.json");
	//return jdata;
	
		return new Object[][] { { jdata.get(0) }, {jdata.get(1)}};

	}

}
