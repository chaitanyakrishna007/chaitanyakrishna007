import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Linkscount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//Actions a = new Actions(driver);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement miniFooter = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));

		System.out.println(miniFooter.findElements(By.tagName("a")).size());
		

		for (int i = 1; i < miniFooter.findElements(By.tagName("a")).size(); i++) {
			
			String clickLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			miniFooter.findElements(By.tagName("a")).get(i).sendKeys(clickLinks);
			
			Thread.sleep(5000L);
			
		}
			
			Set<String> windowsSet = driver.getWindowHandles();	
			Iterator<String> it = windowsSet.iterator();
			while(it.hasNext()) {
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			
			
			
		}
		
		

		// driver.quit();
	}

}
