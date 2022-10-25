package seleniumclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowseWindowHandleUsingList {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		//driver.findElement(By.xpath("(//*[local-name()='svg' and @role='presentation'])[3]")).click();
		
		driver.findElement(By.xpath("//i[@class='icon-facebook']")).click();
         //child window will be opened
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		//converting the set into list
		List<String> windowHandleList = new ArrayList<String>(windowHandles);
		
		String parentWindow = windowHandleList.get(0);
		System.out.println("parent window is: "+parentWindow);
		 
		String childWindow = windowHandleList.get(1);
		System.out.println("child window is: "+childWindow);
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}

}
