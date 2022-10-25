package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4NewWindowConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String parent_windowHandle = driver.getWindowHandle();
		//Selenium 4.x feature:-a blank new window or new tab will be opened using below method
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://amazon.com");
		
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parent_windowHandle);
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("test");
				
		System.out.println(driver.getTitle());

		driver.quit();
		
	}

}
