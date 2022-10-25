package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorStrategy {
	
	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(driver.getTitle());
		
		//1.ID
//		driver.findElement(By.id("Form_getForm_subdomain")).sendKeys("sai");
//		driver.findElement(By.id("Form_getForm_Name")).sendKeys("SaiTeja");
//		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("9873525");
		
		//2.Name
		
//		WebElement name = driver.findElement(By.name("subdomain"));
//		WebElement fullName = driver.findElement(By.name("Name"));
//		WebElement contact = driver.findElement(By.name("Contact"));
//		
//		name.sendKeys("Teja");
//		fullName.sendKeys("SaiTeja");
//		contact.sendKeys("8977123");
		
		//3.maintaining By locators---Object Repository
		
//		By name = By.id("Form_getForm_subdomain");
//		By fullName = By.id("Form_getForm_Name");
//		By contact = By.id("Form_getForm_Contact");
//		
//		WebElement name_ele = driver.findElement(name);
//		WebElement fName_ele = driver.findElement(fullName);
//		WebElement contact_ele = driver.findElement(contact);
//
//		name_ele.sendKeys("Sai");
//		fName_ele.sendKeys("RamSai");
//		contact_ele.sendKeys("78963772");

//		//4.By locator with generic method
//		By name = By.id("Form_getForm_subdomain");
//		By fullName = By.id("Form_getForm_Name");
//		By contact = By.id("Form_getForm_Contact");
//		
//		getElement(name).sendKeys("Sai");
//		getElement(fullName).sendKeys("SaiRam");
//		getElement(contact).sendKeys("673298211");
		
		//5. By locator with generic method of send keys
//		By name = By.id("Form_getForm_subdomain");
//		By fullName = By.id("Form_getForm_Name");
//		By contact = By.id("Form_getForm_Contact");
		
//		doSendKeys(name, "SaiRam");
//		doSendKeys(fullName, "SriSairam");
//		doSendKeys(contact, "5673288");
		
		//6.By using ElementUtil object
		
//		ElementUtil el = new ElementUtil(driver);
//		el.doSendKeys(name, "Sai");
//		el.doSendKeys(fullName, "SAiram");
//		el.doSendKeys(contact, "678292");
		
		//7.String 
		
		String name_id="Form_getForm_subdomain";
		String fName_id="Form_getForm_Name";
		String contact_id="Form_getForm_Contact";
//		By name = By.id(name_id);
//		By fName = By.id(fName_id);
//		By contact = By.id(contact_id);
//		 
		ElementUtil el = new ElementUtil(driver);
		
		el.doSendKeys(el.getBy("id",name_id), "Rama");
		el.doSendKeys(el.getBy("id",fName_id), "JaiRam");
		el.doSendKeys(el.getBy("id",contact_id), "7684733");



	}
	
	public static void doSendKeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}

}
