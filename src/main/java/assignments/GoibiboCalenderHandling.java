package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboCalenderHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		selectDepartureDate("December 2022", "20");
		driver.findElement(By.cssSelector("p.gr_fswFld__info")).click();
		selectReturnDate("February 2023", "15");

}
	public static void selectDepartureDate(String ExpMonthYear,String day) throws InterruptedException
	{
		String actualMonthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText();
		System.out.println(actualMonthYear);
		//
		while(!actualMonthYear.equals(ExpMonthYear))
		{
			driver.findElement(By.cssSelector("span.DayPicker-NavButton.DayPicker-NavButton--next")).click();
			actualMonthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText();
			System.out.println(actualMonthYear);
		}
		driver.findElement(By.xpath("//p[text()='"+day+"']")).click();

	}
	public static void selectReturnDate(String ExpMonthYear,String day) throws InterruptedException
	{
		String actualMonthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText();
		System.out.println(actualMonthYear);
		//
		while(!actualMonthYear.equals(ExpMonthYear))
		{
			driver.findElement(By.cssSelector("span.DayPicker-NavButton.DayPicker-NavButton--next")).click();
			actualMonthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption div")).getText();
			System.out.println(actualMonthYear);
		}
		driver.findElement(By.xpath("//p[@class='fsw__date' and text()='"+day+"']")).click();

	}
}