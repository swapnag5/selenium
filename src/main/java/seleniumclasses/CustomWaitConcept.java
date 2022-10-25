package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaitConcept {

	//without using any selenium waits
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com");

		By amazonBasics = By.linkText("Amazon Basics2");
		retryingForElement(amazonBasics, 10, 500).click();

	}

	public static WebElement retryingForElement(By locator,int timeOut,int pollTime) {

		WebElement element = null;
		int attempts = 0;
		while(attempts < timeOut)
		{
			try {
				element = driver.findElement(locator);
				break;//throws NoSuchEle Exception if it is not found so surround by try catch

			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempts of :"+timeOut+"for"+locator);

				try {
					Thread.sleep(pollTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null)
		{
			try {
				throw new Exception("ELEMENTISNOTFOUND");
			}
			catch(Exception e)
			{
				System.out.println("element is not found in attempts of :"+attempts+"sec : with interval of :"+pollTime);
			}

		}
		return element;
	}

}
