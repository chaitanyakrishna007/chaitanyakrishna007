import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practiceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.findElement(By.xpath("//input[@id=\"checkBoxOption2\"]")).click();
			System.out.println(driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]")).getText());
			String option = driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]")).getText();
			//System.out.println(option);
			WebElement selectList =  driver.findElement(By.xpath("//Select[contains(@id,\"dropdown\")]"));
			
			Select sel = new Select(selectList);
			
			sel.selectByVisibleText(option);
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(option);
			
			
			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
			
			String text = driver.switchTo().alert().getText();
			
			String[] dummyText = text.split(",");
			String[] dummyText2 = dummyText[0].split(" ");
			String finalText = dummyText2[1].trim();
			
			System.out.println(finalText);
			
			if(finalText.equals(option)) {
				
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
				
	}

}
