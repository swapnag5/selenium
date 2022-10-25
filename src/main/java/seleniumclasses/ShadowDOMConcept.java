package seleniumclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		//html DOM-->element
		               //Shadow root----->element
		
		//html Dom--->
		           //frame-->
		                //Shadoow root---->element
		//cssSelector is only applicable for shadow elements
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		//shadow elmnt is inside the frame so first we need to switch to the frame
		driver.switchTo().frame("pact");
		
		//shadow elemnt we need javascript executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js script returns web elemnt so we need to convert js to WebElement
		WebElement tea=(WebElement)js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
		tea.sendKeys("Ginger Tea");
		
	}

}
