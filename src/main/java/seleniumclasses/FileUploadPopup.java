package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopup {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//file upload pop up---desktop window..so selnium cant handle directly
		
		//type = file (Mandatory) attribute should be there in html tag
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		driver.findElement(By.name("upfile")).sendKeys("/Users/chinnu/Desktop/MethodOverloading.txt");
		

	}

}
