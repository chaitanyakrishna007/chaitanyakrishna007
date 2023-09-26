package krishnaselenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import krishnaselenium.SeleniumAutomationFramework.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage loginPage;

	public WebDriver getDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\SeleniumAutomation.PageObjectModel\\krishnaselenium\\resources\\GlobalData.properties");
		properties.load(fis);
		String browserName = properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("Edge")) {
			// write Edge code here
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			// write firefox code here
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000L));
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException {
		driver=getDriver();
		loginPage = new LandingPage(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		driver.close();
	}*/

	public List<HashMap<String, String>> getJsonDataToMap(String FileName) throws IOException {
		
		String jsonContent = 	FileUtils.readFileToString(new File(FileName),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		
		List<HashMap<String, String>> data =	mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>> (){
		});
		return data;
		}


}
