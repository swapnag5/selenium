package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");

		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		Thread.sleep(4000);

		//1st approach best

		driver.findElement(By.xpath("//li[contains(text(),'Summer Dresses > Printed Chiffon ')]")).click();

		//2nd approcah
		//		List<WebElement> eleList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		//		for(WebElement e : eleList)
		//		{
		//			String text = e.getText();
		//			System.out.println(text);
		//			if(text.contains("Casual Dresses > Printed"))
		//			{
		//				e.click();
		//				break;
		//			}
		//		}

	}

}
