import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calenderex1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		//driver.manage().window().fullscreen();
		

		
		/*WebElement element = driver.findElement(By.xpath("//input[@name=\'form_fields[travel_comp_date]\']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();*/
		
		driver.findElement(By.xpath("//input[@name='form_fields[travel_comp_date]']")).click();
		
		List<WebElement> dayList = driver.findElements(By.cssSelector(".dayContainer"));
		
		int days = driver.findElements(By.cssSelector(".dayContainer")).size();
		
		for(int i=0;i<days;i++) {
			
		String newDate = dayList.get(i).getText();
		
		if(newDate.equalsIgnoreCase("25")) {
			
			driver.findElements(By.cssSelector(".dayContainer")).get(i).click();
			break;
		}
			
			
		}
		
		
		
		;
	}
}
