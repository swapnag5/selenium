package seleniumclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
	
	public static void main(String[] args) {
		
	
	//to start the server(chrome.exe file launched) 
	System.setProperty("webdriver.chrome.driver", "/Users/chinnu/Downloads/chromedriver");
	
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
