package assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumclasses.BrowserUtil;
import seleniumclasses.ElementUtil;

public class OpencartRegister {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		BrowserUtil brUtil = new BrowserUtil();

		WebDriver driver = brUtil.init_driver("chrome");

		brUtil.launchUrl("https://opencart.antropy.co.uk/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		//By locators
		
				By fName = By.id("input-firstname");
				By lName = By.id("input-lastname");

				By email = By.id("input-email");
				By phoneNo = By.id("input-telephone");
				By pwd = By.id("input-password");
				By pwdConfirm = By.id("input-confirm");
				
				ElementUtil elUtil = new ElementUtil(driver);
				
				elUtil.doSendKeys(fName, "SriSai");
				elUtil.doSendKeys(lName, "SriSaiRam");
				elUtil.doSendKeys(email, "SriSai@gmail.com");
				elUtil.doSendKeys(phoneNo, "988754332");
				elUtil.doSendKeys(pwd, "sairam");
				elUtil.doSendKeys(pwdConfirm, "sairam");

				


	}

}
