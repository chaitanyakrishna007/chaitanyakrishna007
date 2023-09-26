import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamsEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<String> newProdList;

		//List<WebElement> prodList = driver.findElements(By.xpath("//tr/td[1]"));
		
		do{
		List<WebElement> productsList = driver.findElements(By.xpath("//tr/td[1]"));

		newProdList = productsList.stream().filter(s -> s.getText().contains("Apple")).map(s -> getPrice(s))
				.collect(Collectors.toList());

		newProdList.forEach(a -> System.out.println(a));

		if (newProdList.size() < 1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();

		}
		}while(newProdList.size() < 1);
	}

	public static String getPrice(WebElement s) {

		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;

	}

}
