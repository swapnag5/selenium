package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//menu items:---parent to child menu
		//multi level menu items
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		

		By parentmenu=By.cssSelector("a.menulink");
		By submenuArticles = By.xpath("//ul[@class='submenu']//a[contains(text(),'Articles')]");
		
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(parentmenu)).perform();
//
//		Thread.sleep(2000);
//		
//		driver.findElement(submenu).click();
		
		/** Using Generic method*/
		levelTwoMenuHandling(parentmenu,submenuArticles);

	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

	public static void levelTwoMenuHandling(By parentMenu,By childMenu) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();

		Thread.sleep(2000);
		
		getElement(childMenu).click();

	}
}


