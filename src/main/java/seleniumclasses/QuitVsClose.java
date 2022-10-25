package seleniumclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().to("http://facebook.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().to("http://google.com");
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
