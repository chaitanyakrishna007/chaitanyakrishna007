import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ktayyala\\Desktop\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']"));
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int count=0;
		
		for(WebElement checkboxList : checkBoxes) {
			count++;
			
		}
		System.out.println(count);
	}

}
