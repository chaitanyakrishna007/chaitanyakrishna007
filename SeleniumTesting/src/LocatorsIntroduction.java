import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kittu");
		//driver.close();
		driver.findElement(By.name("inputPassword")).sendKeys("123");
		driver.findElement(By.className("signInBtn")).click();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		driver.findElement(By.partialLinkText("Forgot your")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("RahulShetty");
		driver.findElement(By.xpath("//div/form/input[@type='text'][2]")).sendKeys("rahul@gmail.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("9876543210");
		driver.findElement(By.xpath("//div/button[2]")).click();
		driver.findElement(By.xpath("//div/button[contains(@class,'login-btn')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Rahul");
		
		
		
	}

}
