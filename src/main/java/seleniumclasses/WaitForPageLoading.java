package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoading {

	static WebDriver driver;
	
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://www.freshworks.com");
		
		waitForPageLoading(10);

	}
	
	public static void waitForPageLoading(int timeOut) {
		
		long endTime = System.currentTimeMillis()+timeOut;
		
		while(System.currentTimeMillis() < endTime) {
			//indicates that driver can execute the javascript
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String state = js.executeScript("return document.readyState").toString();
			System.out.println("page is :"+state);
			if(state.equals("complete"))
			{
				System.out.println("the page is fully loaded");
				break;
			}
		}
	}

}
