import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		Actions a = new Actions(driver).click();
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement tagret = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, tagret).build().perform();

		driver.switchTo().defaultContent();

	}

}
