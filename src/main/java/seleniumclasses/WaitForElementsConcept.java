package seleniumclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.freshworks.com/ae/");
		By footers = By.xpath("//div[@class='footer-main']//li/a");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
			
		List<WebElement> footerList = waitForElementsVisibleByLocator(footers,10);

		for(WebElement e: footerList)
		{
			System.out.println(e.getText());
			
		}

	}
	public static List<WebElement> waitForElementsVisibleByLocator(By locator,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}

}
