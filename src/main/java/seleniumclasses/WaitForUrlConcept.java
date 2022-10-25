package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/orangehrm-30-day-trial/");

//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.urlContains("orangehrm"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
		
//		String waitUrl = waitForUrlContains("orange", 4);
//		System.out.println(waitUrl);
		
		String flag =waitForUrlIs("https://www.orangehrm.com/orangehrm-30-day-trial/",10);
		System.out.println(flag);
	}
	public static String waitForUrlContains(String fractionUrl, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(fractionUrl))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	public static String waitForUrlIs(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

}
