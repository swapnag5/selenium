package seleniumclasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopUpHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//JS pop up : alert/prompt/confirmation
		//model dialogue
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		 
		//we cannot inspect the JS pop up alert so by using Alert instance we can(driver) switch to the pop up alert
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		Thread.sleep(3000);
		
		alert.accept();//accepeting the alert by clicking ok
		//alert.dismiss();//dismiss alert,click cancel


	
		
	}

}
