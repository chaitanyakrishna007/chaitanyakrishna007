import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollby {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,800)");

		Thread.sleep(3000L);

		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> elementList = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;

		for (int i = 0; i < elementList.size(); i++) {

			// System.out.println(Integer.parseInt(elementList.get(i).getText()));

			sum = sum + Integer.parseInt(elementList.get(i).getText());

		}
		System.out.println(sum);

		String[] dummy = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":");
		int actual =Integer.parseInt(dummy[1].trim());
		

		if (actual == sum) {

			System.out.println("Test Passed");

		} else
			System.out.println("Test Failed");

	}

}
