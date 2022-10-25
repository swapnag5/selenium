package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinksOnPage {

	//total links on a page
	//print text of the links
	//ignore blank texts

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.opencart.com/index.php?route=account/login");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("total links :"+linksList.size());
		//		for(WebElement e:linksList)
		//		{
		//
		//			String text = e.getText();
		//			if(!text.isEmpty())
		//			System.out.println(text);
		//		}

		//		for(int i=0;i<linksList.size();i++)
		//		{
		//			
		//			String text =linksList.get(i).getText();
		//			//System.out.println(text);
		//			if(!text.isEmpty())
		//			{
		//				System.out.println(text);
		//
		//			}
		//		}

		//linksList.stream().forEach(ele -> System.out.println(ele.getText()));

		linksList
		  .stream()
		    .filter(ele -> !ele.getText().isEmpty())
		      .forEach(ele->System.out.println(ele.getText()));

	}

}
