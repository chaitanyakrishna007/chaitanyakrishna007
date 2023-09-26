import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);
		// 

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		
		driver.get("https://rahulshettyacademy.com");
		
		String text =driver.findElement(By.xpath("//a[contains(text(),'All-Access')]")).getText();
		//System.out.println(text);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(text);
		
		
		WebElement name = driver.findElement(By.xpath("//div/input[@name='name']"));
		
	System.out.println(name.getRect().getDimension().getHeight());
	System.out.println(name.getRect().getWidth());
	System.out.println(name.getRect().getHeight());
	
		driver.quit();

		// 
	}

}
