package seleniumclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUps {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//Authentication pop ups are different from alerts
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String username = "test";
		String password = "test";
		
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
	}

}
