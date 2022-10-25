package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandleEasy {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("software testing");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[contains(text(),'jobs')]")).click();

	}

}
