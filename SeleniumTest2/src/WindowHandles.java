import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		Iterator<String> it = windowHandle.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String name= getuser(driver);
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(name);
		

	}

	public static String getuser(WebDriver driver) {
		
		String userName = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim();
		
		String user = userName.split("with")[0].trim();
		return user;

	}
}
