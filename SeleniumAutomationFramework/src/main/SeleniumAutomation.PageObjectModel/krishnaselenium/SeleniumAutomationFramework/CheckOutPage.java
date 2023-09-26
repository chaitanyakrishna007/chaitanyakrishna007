package krishnaselenium.SeleniumAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import krishnaselenium.abstractclasses.abstractclassforwait;

public class CheckOutPage extends abstractclassforwait{
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement enterCountryName;
	
	@FindBy(css = "section[class*='ta-results'] button")
	List<WebElement> desiredCountryName;
	
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> countryNameSelector;
	
	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")  //  .action__submit
	WebElement placeOrder;
	
	By resultLoading = By.cssSelector("section[class*='ta-results'] button");
	
	public void enterCountryName() {
		//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		
		enterCountryName.sendKeys("ind");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results'] button")));

		explicitWaitToAppear(resultLoading);
		
	}
	

	public void clickOnCountry() {
		
		for (int i = 0; i < desiredCountryName.size(); i++) {

			String country = desiredCountryName.get(i)
					.getText();

			if (country.equals("India")) {

				countryNameSelector.get(i).click();
				
				//driver.findElement(By.cssSelector(".action__submit")).click();
				
				break;
			}
		}
	}
	
	public void clickOnPlaceOrder(){
		placeOrder.click();
	}
		
	}
