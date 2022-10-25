package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");

//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("automation testing");
//		Thread.sleep(5);
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
//		for(WebElement e : list)
//		{
//			String s = e.getText();
//			System.out.println(s);
//			if(s.contains("automation testing course"))
//			{
//				e.click();
//				break;
//			}
//		}
		By suggestions = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span");
		//getGoogleSuggestionList(suggestions, "automation testing");
		
		selectElementFromSuggestionList(suggestions, "automation testing", "automation testing jobs");

	}

	public static void getGoogleSuggestionList(By locator,String searchKey) throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys(searchKey);

		Thread.sleep(5);
		List<WebElement> suggList = driver.findElements(locator);
		for(WebElement e : suggList)
		{
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	public static void selectElementFromSuggestionList(By locator,String searchKey,String selValue) throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys(searchKey);

		Thread.sleep(5);
		List<WebElement> suggList = driver.findElements(locator);
		for(WebElement e : suggList)
		{
			String text = e.getText();
			Thread.sleep(3);
			System.out.println(text);
			if(text.contains(selValue)) {
				e.click();
				break;
			}
		}
	}

}
