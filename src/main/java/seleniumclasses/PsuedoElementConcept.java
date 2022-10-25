package seleniumclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PsuedoElementConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/register");
		//Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script ="return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),'::before').getPropertyValue('content')";
			String mand_firstname = js.executeScript(script).toString();
			System.out.println(mand_firstname);
			if(mand_firstname.contains("*"))
			{
				System.out.println("mandatory field");
			}
  
		
	}
}