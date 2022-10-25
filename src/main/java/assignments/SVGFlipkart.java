package assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGFlipkart {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");

		driver.findElement(By.name("q")).sendKeys("women dresses");
		
//		Set<String> windowHandles = driver.getWindowHandles();
//		Iterator<String> it = windowHandles.iterator();
//		String parentWindow = it.next();
//		
//		String childWindow = it.next();
//		driver.switchTo().window(childWindow);
//		System.out.println(driver.getTitle());
		//driver.findElement(By.linkText("✕")).click();
		
		//driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']")).click();

	}

}
