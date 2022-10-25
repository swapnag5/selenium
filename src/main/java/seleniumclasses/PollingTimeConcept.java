package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By contact_sales = By.linkText("Contact Sales");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(1000));
		wait.until(ExpectedConditions.elementToBeClickable(contact_sales)).click();
	}
	
	public static void waitForElementToBeClickableWithPolling(By locator,int timeOut,int pollingTime)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(1000));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

}
