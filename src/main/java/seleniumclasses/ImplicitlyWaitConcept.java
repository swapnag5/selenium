package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

		public static void main(String[] args) throws InterruptedException {

			/**Implicit wait:--It tells the WebDriver to wait for a certain amount 
			 * of time before it throw an exception.
			 * 1.It is a global wait means it will be applied for all web elements by default
			 * 2.Not applicable for non web elements --title,url,alert
			 * 3.Only for web elements
			 * **/
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//deprecated in sel 4.x
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Sel 4.x
			//1.home page
			driver.findElement(By.name("username")).sendKeys("test");
			driver.findElement(By.name("password")).sendKeys("test123");
			
			//2.contact page
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//e3
			//e4
			//the latest time out is 5
			//if u go back to home page it considers the latest time i.e.5sec
			
			//we need to over write the time out to change the duration 
			
			
	}

}
