package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		 
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		br.launchUrl("http://demo.opencart.com/index.php?route=account/login");
		
		//WebElement + action(click,sendkeys,gettext,isDisplayed)
		
		//isDisplayed()
		
//		boolean flag = driver.findElement(By.name("email")).isDisplayed();
//		System.out.println(flag);
		ElementUtil elUtil = new ElementUtil(driver);
		
		By email =By.name("email");
		
		if(elUtil.doIsDisplayed(email))
		{
		  elUtil.doSendKeys(email, "test@gmail");
		}
		
		//getAttribute()
		String value = driver.findElement(email).getAttribute("value");
		System.out.println(value);
		
		String att = elUtil.doGetAttribute(email, "name");
		
		System.out.println(att);
	}

}
