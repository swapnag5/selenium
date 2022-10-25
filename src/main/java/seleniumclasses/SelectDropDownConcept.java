package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_getForm_Country");
//		WebElement countryEle = driver.findElement(country);
//
//		Select select = new Select(countryEle);
//		select.selectByIndex(3);
//		select.selectByValue("Angola");
//		select.selectByVisibleText("India");
		
		selectDropdownByVisibleText(country, "India");
	}


	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

	public static void selectDropdownByIndex(By locator , int i)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(i);
	}

	public static void selectDropdownByVisibleText(By locator , String visibleText)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public static void selectDropdownByValue(By locator , String valAttribute)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(valAttribute);
	}
}