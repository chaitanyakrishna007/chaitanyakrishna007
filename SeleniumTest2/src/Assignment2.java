import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int rows = driver.findElements(By.xpath("//div/fieldset/table/tbody/tr")).size();
		
		System.out.println("Rows Count"+"="+rows);
		
		int col = driver.findElements(By.xpath("//div/fieldset/table/tbody/tr/th")).size();
		
		System.out.println("Column Count"+"="+col);
		
		String data =driver.findElement(By.xpath("//div/fieldset/table/tbody/tr[3]")).getText();
		
		System.out.println(data);
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("uni");
		
		for(int i=0;i<driver.findElements(By.xpath("//ul/li[@class=\"ui-menu-item\"]/div")).size();i++) {
			
			List<WebElement> countries = driver.findElements(By.xpath("//ul/li[@class=\"ui-menu-item\"]/div"));
			
			while(countries.get(i).getText().equalsIgnoreCase("United Arab Emirates")){
				countries.get(i).click();	
			}
		}
		
		
		
		
	}

}
