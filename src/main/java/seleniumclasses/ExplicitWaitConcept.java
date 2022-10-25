package seleniumclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		//Explicit wait:--web elemnts and also non web elements
		//can be customized for a specific element
		//not a global wait

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/orangehrm-30-day-trial/");
		
		By name = By.id("Form_getForm_Name");
		By email = By.id("Form_getForm_Email");
		By contact = By.id("Form_getForm_Contact");
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement name_ele = wait.until(ExpectedConditions.presenceOfElementLocated(name));
//		name_ele.sendKeys("admin");
		waitForElementPresence(name,10).sendKeys("admin");
		
		driver.findElement(email).sendKeys("admin@gmail");
		driver.findElement(contact).sendKeys("9876654");
		
	}
	
	public static WebElement waitForElementPresence(By locator,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
