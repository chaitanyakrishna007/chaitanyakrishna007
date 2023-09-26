package krishnaselenium.SeleniumAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import krishnaselenium.abstractclasses.abstractclassforwait;

public class ProductsCatalougePage extends abstractclassforwait {

	WebDriver driver;
	

	public ProductsCatalougePage(WebDriver driver) {

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// List<WebElement> productsList =
	// driver.findElements(By.cssSelector("div[class*='offset-sm-1']"));

	@FindBy(css = "div[class*='offset-sm-1']")
	List<WebElement> productsList;
	
	@FindBy(css = ".ng-animating")
	WebElement animating;
	


	By prodList = By.cssSelector("div[class*='offset-sm-1']");
	By addtocart = By.xpath("//div[@class='card-body']/button[2]");
	By toastContainer = By.id("toast-container");

	public List<WebElement> getProducts() {
		explicitWaitToAppear(prodList);
		return productsList;

	}

	public WebElement getProductbyName(String product1) { // get all the products which is same as ZARA COAT 3
		WebElement desiredProd = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().contains(product1)).findFirst()
				.orElse(null);

		return desiredProd;
	}

	// desiredProd.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
	
	

	public void clickonAddtoCart(String product1) {
		// TODO Auto-generated method stub
		WebElement desiredProd = getProductbyName(product1);
		desiredProd.findElement(addtocart).click();
		explicitWaitToAppear(toastContainer);
		explicitWaitToInvisible(animating);
	 //driver.findElement(By.cssSelector(".ng-animating"))

	}
	

	

	}

