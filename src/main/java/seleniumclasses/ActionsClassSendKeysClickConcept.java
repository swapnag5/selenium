package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassSendKeysClickConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/?route=account/login");

		WebElement  email = driver.findElement(By.id("input-email"));
		WebElement pwd = driver.findElement(By.id("input-password"));
		WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]"));
		//driver.findElement(By.linkText("LOGIN"));
		System.out.println("hi");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(email, "admin@gmail.com").perform();
//		Thread.sleep(2000);
//		act.sendKeys(pwd,"admin").perform();
//		Thread.sleep(2000);

//		act.click(login_btn).perform();
		
		/** using generic mthods***/
		By emailLoc = By.id("input-email");
		By pwdLoc = By.id("input-password");
		By loginBtnLoc =By.xpath("//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]");
		
		doActionsSendKeys(emailLoc, "test@gmd");
		doActionsSendKeys(pwdLoc, "test@");
		doActionsClick(loginBtnLoc);


		
	}
	public static WebElement  getElement(By locator)
	{
		return driver.findElement(locator);
				
	}
	
	public static void  doActionsSendKeys(By locator,String value)
	{
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void  doActionsClick(By locator)
	{
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
}
