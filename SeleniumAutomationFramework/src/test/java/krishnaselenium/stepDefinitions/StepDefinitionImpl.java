package krishnaselenium.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import krishnaselenium.SeleniumAutomationFramework.CartPage;
import krishnaselenium.SeleniumAutomationFramework.CheckOutPage;
import krishnaselenium.SeleniumAutomationFramework.LandingPage;
import krishnaselenium.SeleniumAutomationFramework.ProductsCatalougePage;
import krishnaselenium.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage loginPage;
	public ProductsCatalougePage prodcart;
	public CheckOutPage checkoutPage;

	@Given("I landed on the login page")
	public void i_landed_on_the_login_page() throws IOException {

		loginPage = launchApp();
	}

	@When("^I logged in with userName (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		prodcart = loginPage.loginActions(username, password); // logged in to application

	}
	
	
	/*
	 * @When("^add product (.+) to cart$") public void add_product_to_cart(String
	 * productname) { //List<WebElement> productsList =
	 * driver.findElements(By.cssSelector("div[class*='offset-sm-1']"));
	 * 
	 * List<WebElement> products = prodcart.getProducts();
	 * //prodcart.getProductbyName(inputValues.get("productname")); // get the
	 * products prodcart.clickonAddtoCart(productname); }
	 */
	
	@When("^add product (.+) to cart$")
	public void add_product_zara_coat_to_cart(String productname) {
		List<WebElement> products = prodcart.getProducts();
		//prodcart.getProductbyName(inputValues.get("productname")); // get the products
		prodcart.clickonAddtoCart(productname);	
	   
	}
	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submi_the_order(String productname) {
		CartPage cartTab = prodcart.clickonAddToCartTab();

		// moved to cart page

		Boolean match = cartTab.verifyItemsinCart(productname);
		Assert.assertTrue(match);
		// adds to cart

		checkoutPage = cartTab.clickonCheckOut(); // clicks on checkout button in cart section
			
	}
	@Then("select the country and click on ok")
	public void select_the_country_and_click_on_ok() {
		checkoutPage.enterCountryName();
		checkoutPage.clickOnCountry();
		
		driver.close();
		
	}
	@Then("{string} message is displayed")
	public void error_message_displayed(String emessage) {
		Assert.assertEquals(emessage, loginPage.errorValidation());

		driver.close();
	}

}
