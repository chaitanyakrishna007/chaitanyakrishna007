import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcomPractise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] vegArray = { "Tomato", "Cucumber", "Carrot" };
		
		getProducts(driver, vegArray);

	}

	public static void getProducts(WebDriver driver, String[] vegArray) {
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
