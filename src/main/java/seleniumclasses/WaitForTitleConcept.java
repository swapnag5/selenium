package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitleConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/orangehrm-30-day-trial/");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.titleContains("HR Software")))
		{
			System.out.println(driver.getTitle());
		}

	}
	/**
	 * An expectation for checking that the title contains a case-sensitive substring
	 * @param titleFraction
	 * @param timeOut
	 * @return
	 */
	public static String waitForTitleContains(String titleFraction,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleContains(titleFraction)))
		{
			return driver.getTitle();
		}
		return null;
	}
	/**
	 * An expectation for checking the title of a page.
	 * @param title
	 * @param timeOut
	 * @return
	 */
	public static String waitForTitleIs(String title,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleIs(title)))
		{
			return driver.getTitle();
		}
		return null;
	}



}
