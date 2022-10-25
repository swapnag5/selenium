package seleniumclasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserWindowHandle {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		String parentWindow = driver.getWindowHandle();
		//driver.findElement(By.xpath("(//*[local-name()='svg' and @role='presentation'])[3]")).click();

		driver.findElement(By.xpath("//i[@class='icon-facebook']")).click();
		//child window will be opened
		driver.findElement(By.xpath("//i[@class='icon-twitter']")).click();
		driver.findElement(By.xpath("//i[@class='icon-youtube']")).click();
		driver.findElement(By.xpath("//i[@class='icon-linkedin']")).click();
		driver.findElement(By.xpath("//i[@class='icon-glassdoor']")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> it = windowHandles.iterator();

		while(it.hasNext())
		{
			String windowId = it.next();

			if(!parentWindow.equals(windowId))
			{
				//System.out.println(windowId);
				driver.switchTo().window(windowId);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());



	}


}
