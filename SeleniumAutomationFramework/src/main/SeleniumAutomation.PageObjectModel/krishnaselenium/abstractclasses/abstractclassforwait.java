package krishnaselenium.abstractclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import krishnaselenium.SeleniumAutomationFramework.CartPage;



public class abstractclassforwait {
	
	WebDriver driver;

	public abstractclassforwait(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*=cart]")
	WebElement cartTab;


	public void explicitWaitToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

	
	public void explicitWaitToInvisible(WebElement webele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(webele));

		
	}
	
	public CartPage clickonAddToCartTab() {
		cartTab.click();
		CartPage cartTab = new CartPage(driver);
		return cartTab;
		
	}
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results'] button")));

}
