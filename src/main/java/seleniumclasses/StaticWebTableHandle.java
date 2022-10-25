package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		 int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		 int colCount = driver.findElements(By.xpath("//table[@id='customers']//tr/th")).size();

		 System.out.println(rowCount);
		 System.out.println(colCount);
//		 List<WebElement> list = driver.findElements(By.xpath("//table[@id='customers']//tr/td"));
//		for(WebElement e : list)
//		{
//			System.out.println(e.getText());
//		}
		
		/**capturing particular column in static web table***/
		
		List<WebElement> coloumnItemsList = driver.findElements(By.xpath("//th[text()='Company']/parent::tr//following-sibling::tr/td[1]"));
		for(WebElement e : coloumnItemsList)
		{
			System.out.println(e.getText());
		}
	
	}
	

}
