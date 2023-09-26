import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E2etest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer2 = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		//List<WebElement> footerLinks = footer2.findElements(By.tagName("a"));
		//System.out.println(footerLinks.size());
		for (int i = 1; i < footer2.findElements(By.tagName("a")).size(); i++) {
			
			String keyseq = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footer2.findElements(By.tagName("a")).get(i).sendKeys(keyseq);
			Thread.sleep(5000L);

		}
		
		Set<String> windowHandle = driver.getWindowHandles();
		Iterator<String> it = windowHandle.iterator();
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
