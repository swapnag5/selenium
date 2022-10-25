package seleniumclasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		 
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		br.launchUrl("http://www.orangehrm.com/orangehrm-30-day-trial/");
		String title = br.getPageTitle();
		System.out.println(title);
		
		By name = By.id("Form_getForm_subdomain");
		By fullName = By.id("Form_getForm_Name");
		By contact = By.id("Form_getForm_Contact");
		
		ElementUtil elUtil = new ElementUtil(driver);
		elUtil.doSendKeys(name, "Sai");
		elUtil.doSendKeys(fullName, "RamSai");
		elUtil.doSendKeys(contact, "8978985");
		
		br.closeBrowser();
		
		
				
		
	}

}
 