import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2EndTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ktayyala\\Desktop\\chromedriver-win64");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000L);
		getCountryList(driver);
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//label[text()='One Way']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='TIR']"))
				.click();
		Thread.sleep(2000L);
		driver.findElement(By.cssSelector("a[class*='ui-state-default ui-state-highlight']")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Disabled");
			Assert.assertTrue(true);

		} else {
			System.out.println("Enabled");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		Thread.sleep(2000L);
		setPersons(driver);
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();

	}

	public static void getCountryList(WebDriver driver) {
		List<WebElement> countryList = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
		for (WebElement newCountryList : countryList) {
			if (newCountryList.getText().equals("India")) {
				newCountryList.click();
				break;
			}
		}

	}

	public static void setPersons(WebDriver driver) {
		for (int i = 1; i <= 3; i++) {

			driver.findElement(By.xpath("//div[@id='divAdult'] //span[@id='hrefIncAdt']")).click();
			driver.findElement(By.xpath("//div[@id='divInfant'] //span[@id='hrefIncInf']")).click();

		}

	}

}
