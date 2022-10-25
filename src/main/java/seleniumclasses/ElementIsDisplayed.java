package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/?route=account/login");

		By email = By.id("input-email");
//		if(driver.findElements(email).size()>0)
//		{
//			System.out.println("Element is displayed");
//		}
//		else
//			System.out.println("No element displayed");

		isElementDisplayed(email);

	}
	public static boolean isElementDisplayed(By locator)
	{
		WebElement ele = getElement(locator);
		List<WebElement> elementsList= getElements(locator);
		
		if(elementsList.size()>0) {
			if(ele.isDisplayed())
			return true;
		}
		return false;
	}
	private static List<WebElement>  getElements(By locator) {
		return driver.findElements(locator);
	}
	private static WebElement  getElement(By locator) {
		return driver.findElement(locator);
	}
}
