package seleniumclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

		String title = driver.getTitle();
		System.out.println("page title is "+title);

		if(title.equals("Google"))
		{
			System.out.println("correct title");
		}
		else
			System.out.println("incorrect");

	}


}


