package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartRightPanelLinks {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/login");
		List<WebElement> rightList = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		
		for(WebElement e : rightList)
		{
			String text = e.getText();
			System.out.println(text);
		}
		

	}

}
