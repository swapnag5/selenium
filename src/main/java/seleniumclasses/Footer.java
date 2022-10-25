package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Footer {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.freshworks.com/");
		
		List<WebElement> footerList = driver.findElements(By.xpath("//div[@class='footer-main']//li/a"));
		System.out.println(footerList.size());
//		for(WebElement e:footerList)
//		{
//			String text = e.getAttribute("href");
//			System.out.println(text);
//		}
		
		footerList.stream().filter(e->!e.getText().isEmpty()).forEach(e->System.out.println(e.getText()));
		
	}

}
