package seleniumclasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandling {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		//driver.findElement(By.xpath("(//*[local-name()='svg' and @role='presentation'])[3]")).click();
		
		driver.findElement(By.xpath("//i[@class='icon-facebook']")).click();
         //child window will be opened
		
		Set<String> windowHandles = driver.getWindowHandles();
		//to iterate the set we use Iterator interface
		Iterator<String> it = windowHandles.iterator();
		
		String parentWindowId= it.next();//
		System.out.println("the parent window name is: "+parentWindowId);
		
		String childwindowId = it.next();
		System.out.println("the child window id is: "+childwindowId);
		
		driver.switchTo().window(childwindowId);
		System.out.println(driver.getTitle());
		driver.close();//it closes the child window and driver will be lost
		
		//driver switching to parent window
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		driver.quit();//it closes all windows
	}

}
