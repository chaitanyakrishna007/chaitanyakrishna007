package krishnaselenium.SeleniumAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import krishnaselenium.abstractclasses.abstractclassforwait;

public class CartPage  extends abstractclassforwait{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProduct;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	

	public Boolean verifyItemsinCart(String product1) {
		//List<WebElement> cartProduct = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match = cartProduct.stream().anyMatch(cartFinder -> cartFinder.getText().contains(product1));
		return match;

}
	
	public CheckOutPage clickonCheckOut() {
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		checkoutButton.click();
		
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		return checkoutPage;
	}
	

	
	
}
