package krishnaselenium.SeleniumAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import krishnaselenium.abstractclasses.abstractclassforwait;

public class LandingPage extends abstractclassforwait{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}


	//WebElement userId = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userId;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement login;
	
	//
	@FindBy(css="div[class*='toast-error']")
	WebElement errorToastMsg;
	
	By toastMsg = By.cssSelector("div[class*='toast-error']");
	
	
	public ProductsCatalougePage loginActions(String loginId,String passcode) {
		userId.sendKeys(loginId);
		pwd.sendKeys(passcode);
		login.click();  //go to productscatalogue page
		ProductsCatalougePage prodcart = new ProductsCatalougePage(driver);
		return prodcart;
	}
	@BeforeMethod
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorValidation() {
		explicitWaitToAppear(toastMsg);
		return errorToastMsg.getText();
	}
	

}
