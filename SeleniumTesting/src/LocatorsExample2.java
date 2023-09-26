import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("kittu");
		//driver.close();
		//
		LocatorsExample2 locClass = new LocatorsExample2();
		String pwd = locClass.getPassword(driver);
		driver.findElement(By.xpath("//div/button[contains(@class,'login-btn')]")).click();
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		Thread.sleep(2000);
		
		driver.findElement(By.className("signInBtn")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/p")).getText());
		driver.findElement(By.cssSelector(".logout-btn")).click();
	}

	public String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.partialLinkText("Forgot your")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/button[2]")).click();
		String msg=driver.findElement(By.cssSelector(".infoMsg")).getText();
		String[] passcode=msg.split("'");
		String pass=passcode[1].split("'")[0];
		
		return pass;
	}
}
