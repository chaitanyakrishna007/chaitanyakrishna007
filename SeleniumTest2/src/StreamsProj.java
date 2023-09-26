import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamsProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
		/*
		 * for(int i=0;i<products.size();i++) { String[] products.get(i).getText(); }
		 */

		List<String> newList = products.stream().map(s->s.getText()).collect(Collectors.toList());

		List<String> sortedList = newList.stream().sorted().collect(Collectors.toList());
		
		if(sortedList.equals(products)) {
			
			System.out.println("Products Sorted!!");
		}else System.out.println("Not Sorted!!");

	}

}
