package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiLevelMenuHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// multi level menu handling
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://bigbasket.com");

		//		WebElement parentmenu = driver.findElement(By.xpath("//a[@class=\"dropdown-toggle meganav-shop\"]"));
		//
		//		Actions act = new Actions(driver);
		//
		//		act.moveToElement(parentmenu).perform();
		//		Thread.sleep(1000);
		//
		//		act.moveToElement(driver.findElement(By.linkText("Fruits & Vegetables"))).perform();
		//		Thread.sleep(1000);
		//
		//		act.moveToElement(driver.findElement(By.linkText("Fresh Fruits"))).perform();
		//		Thread.sleep(1000);
		//
		//		act.moveToElement(driver.findElement(By.linkText("Mangoes"))).perform();
		//		Thread.sleep(1000);
		//
		//		driver.findElement(By.linkText("Apple")).click();

		By parentMenu = By.xpath("//a[@class=\"dropdown-toggle meganav-shop\"]");
		By level_1=By.linkText("Fruits & Vegetables");
		By level_2=By.linkText("Fresh Fruits");
		By level_3=By.linkText("Mangoes");
		By level_4=By.linkText("Apple");
		multiLevelMenuHandling(parentMenu, level_1, level_2, level_3, level_4);


	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

	public static void multiLevelMenuHandling(By parentMenu,By l1,By l2,By l3,By l4) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(1000);

		act.moveToElement(getElement(l1)).perform();
		Thread.sleep(1000);

		act.moveToElement(getElement(l2)).perform();
		Thread.sleep(1000);

		act.moveToElement(getElement(l3)).perform();
		Thread.sleep(1000);

		getElement(l4).click();



	}
}
