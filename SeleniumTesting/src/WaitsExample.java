import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000L));

		String[] vegArray = { "Tomato", "Cucumber", "Carrot" };
		
		getProducts(driver, vegArray);
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		
		driver.findElement(By.xpath("//div[@class='action-block'] /button[contains(text(),'PROCEED')]")).click();
		
		
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBTN")).click();
		
		WebDriverWait wa = new WebDriverWait(driver, Duration.ofMillis(5000L));
		wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		String promoCode = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		
		if(promoCode.contains("Code applied ..!")) {
			
			driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		}
		else {
			System.out.println(promoCode);
		}
	}
				
	public static void getProducts(WebDriver driver, String[] vegArray)
	
	{
		int count = 0;
		List<WebElement> allVeggies = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int j = 0; j < allVeggies.size(); j++) {
			String[] veg = allVeggies.get(j).getText().split("-");
			String finalVeg = veg[0].trim();

			List vegList = Arrays.asList(vegArray);// converting Array to Arraylist

			if (vegList.contains(finalVeg)) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(j).click();
				if (count == vegList.size())
					break;

			}
		}
		

	}
}