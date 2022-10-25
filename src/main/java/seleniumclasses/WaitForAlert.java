package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//JS pop up : alert/prompt/confirmation
		//model dialogue
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		//driver.switchTo().alert();//NoAlertPresentException 
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait for alert and then switch to alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.dismiss();
		
	}
	
	public static Alert waitForAlert(int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait for alert and then switch to alert
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String doGetAlertText(int timeOut)
	{
		return waitForAlert(timeOut).getText();
	}
	public static void acceptAlert(int timeOut)
	{
		 waitForAlert(timeOut).accept();
	}
	public static void dismissAlert(int timeOut)
	{
		 waitForAlert(timeOut).dismiss();
	}
	public static void alertSendKeys(int timeOut,String value)
	{
		 waitForAlert(timeOut).sendKeys(value);
	}
}
