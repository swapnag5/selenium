package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumclasses.BrowserUtil;
import seleniumclasses.ElementUtil;

public class OrangerHrmcontactSales {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.init_driver("chrome");
		
		brUtil.launchUrl("https://www.orangehrm.com/contact-sales");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		//By locators
		
		By fullName = By.id("Form_getForm_FullName");
		By email = By.id("Form_getForm_Email");
		By phoneNo = By.id("Form_getForm_Contact");
		By jodTitle = By.id("Form_getForm_JobTitle");
		By mssg = By.id("Form_getForm_Comment");

		
		ElementUtil elUtil = new ElementUtil(driver);
		elUtil.doSendKeys(fullName, "SriSai");
		elUtil.doSendKeys(email, "SriSai@gmail.com");
		elUtil.doSendKeys(phoneNo, "98775543");
		elUtil.doSendKeys(jodTitle, "HR");
		elUtil.doSendKeys(mssg, "Hello,OrangeHRM");
		

	}

}
