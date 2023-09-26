package krishnaselenium.SeleniumAutomationFramework;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEndTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String product1 = "ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000L));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage loginPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("vamshikrish@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vamshi@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='offset-sm-1']")));

		List<WebElement> productsList = driver.findElements(By.cssSelector("div[class*='offset-sm-1']"));

		/*WebElement desiredProd = productsList.stream()
				.filter(product -> product.findElement(By.xpath("//div[@class='card-body']/h5/b")).getText().equalsIgnoreCase(product1)).findFirst()
				.orElse(null);*/
		WebElement desiredProd = driver.findElement(By.xpath("//b[normalize-space()='adidas original']"));
		
		desiredProd.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();

		List<WebElement> cartProduct = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

		Boolean match = cartProduct.stream().anyMatch(cartFinder -> cartFinder.getText().contains(product1));

		Assert.assertTrue(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results'] button")));

		// Stream<WebElement> desiredCountry = country.stream().filter(getCountry ->
		// getCountry.getText().equals("India"));
		for (int i = 0; i < driver.findElements(By.cssSelector("section[class*='ta-results'] button")).size(); i++) {
			
			String country = driver.findElements(By.cssSelector("section[class*='ta-results'] button")).get(i)
					.getText();

			if (country.equals("India")) {

				driver.findElements(By.xpath("//span[@class='ng-star-inserted']")).get(i).click();
				//break;
			}
		}
		
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//span[@class='ng-star-inserted']"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn.action__submit.ng-star-inserted")));

		//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		//driver.findElement(By.tagName("a")).click();
		

		//driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		//driver.manage().window().setSize(new Dimension(1440,990));
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		driver.close();
	}

}
