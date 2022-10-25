package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooter {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");

		//List<WebElement> footer_list = driver.findElements(By.xpath("(//div[@class='navFooterColHead'])[2]//following-sibling::ul/li"));
	
//		List<WebElement> footer_list = driver.findElements(By.xpath("//div[text()='Get to Know Us']/parent::div//li"));
//				
//		for(WebElement e: footer_list)
//		{
//			System.out.println(e.getText());
//		}
		
		By footer_header= By.xpath("//div[text()='Get to Know Us']/parent::div//li");
	    System.out.println(getFooterList(footer_header));
	}
	
	public static List<String> getFooterList(By locator)
	{
		List<WebElement> footer_list = driver.findElements(locator);
		List<String> footerListItems = new ArrayList<String>();
		for(WebElement e: footer_list)
		{
			String text = e.getText();
			footerListItems.add(text);
			
		}
		return footerListItems;
	}

}
