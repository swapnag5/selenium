package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.freshworks.com");

		By contact_sales = By.linkText("Contact sales11");

		//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		//				.withTimeout(Duration.ofSeconds(10))
		//				.pollingEvery(Duration.ofMillis(1000))
		//				.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
		//				.withMessage("element is not found///");
		//		wait.until(ExpectedConditions.presenceOfElementLocated(contact_sales)).click();

		//fluentWaitForPresenceOfElement(contact_sales, 10, 2000,"element is not found///").click();

		//we can use fluent wait methods with WebDriverWait class also
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
		    .ignoring(NoSuchElementException.class)
		    .withMessage("element is not present");
		wait.until(ExpectedConditions.presenceOfElementLocated(contact_sales)).click();

	}
	public static WebElement fluentWaitForPresenceOfElement(By locator,int timeOut,
			int pollTime,String message) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollTime))
				.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
				.withMessage(message);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	
}
