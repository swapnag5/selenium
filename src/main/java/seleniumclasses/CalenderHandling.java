package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='29']")).click();
		//selectFutureDate("April 2023", "13");
		selectPastDate("August 2017", "9");
	}

	public static void selectFutureDate(String ExpMonthYear,String day) throws InterruptedException
	{
		String actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actualMonthYear);
		//
		while(!actualMonthYear.equals(ExpMonthYear))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			System.out.println(actualMonthYear);
		}
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();

	}
	public static void selectPastDate(String ExpMonthYear,String day)
	{
		String actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();

		while(!actualMonthYear.equals(ExpMonthYear))
		{
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actualMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			System.out.println(actualMonthYear);
		}
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}
}