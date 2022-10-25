package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    //driver.get("http://www.orangehrm.com/orangehrm-30-day-trial/");
	    driver.get("https://amazon.com");
	   //JavascriptExecutor is an interface helps to execute the javascript code
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("alert('hi')");
	    
//	    String title= getTitleByJS();
//	    System.out.println(title);
	    
	    //generateAlert("hiiii");
	    
//	    String pageText = getPageInnerText();
//	    System.out.println(pageText);
//	    System.out.println(pageText.contains("Platform"));
	    
	   // refreshPageByJs();
	    
	    WebElement name = driver.findElement(By.id("Form_getForm_Name"));
	    //drawBorder(name);
//	    flash(name);
//	    name.sendKeys("test");
//	    WebElement contact_sales = driver.findElement(By.linkText("Contact Sales")); 
//	    clickElementByJs(contact_sales);
	    scrollPageDown();
	    
	}
	
	//otherway to get title using javascript
	
	public static String getTitleByJS()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title").toString();
	}
	
	//to generate alert using javascript
	
	public static void generateAlert(String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("alert('"+message+"')");
	}
	//to get entire text from page
	public static String getPageInnerText()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.documentElement.innerText").toString();

	}
	//to refresh the page using js
	public static void refreshPageByJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("history.go(0)");
	}
	
	//drawing the border using js for highlighting somthing to enhance the framework
	public static void drawBorder(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	//to highlight the element using js--this tells where the driver is exactly
	public static void  flash(WebElement element) {
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0;i<15;i++)
		{
			changeColor("rgb(0,200,0)", element);
			changeColor(bgColor, element);
		}
		
	}
	public static void changeColor(String color,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	//to click an element using JS
	public static void clickElementByJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);

	}
	//to scrool the page down using js
	public static void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	//overloaded scroll page down with specified height
	public static void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo('"+height+"')");
	}
	//to scroll the page up using js
	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	//it scrolls till the specified element
	public static void scrollIntoView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

	}
	
}
