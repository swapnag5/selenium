package assignments;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonCarousalHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		String xpath = "//h2[text()='Trending deals']/parent::div/following-sibling::div//ul/li";
		WebElement ele = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
		getCarousalList();
	}

	public static void getCarousalList() throws InterruptedException
	{
		String xpath = "//h2[text()='Trending deals']/parent::div/following-sibling::div//ul/li";
		List<WebElement> dealList = driver.findElements(By.xpath(xpath));
		System.out.println(dealList.size());
		Set<String> deelDataList = new TreeSet<String>();
		String next_xpath = "//h2[text()='Trending deals']/parent::div/following-sibling::div//a[contains(@class,'feed-right')]";
		String xpath2="//h2[text()='Trending deals']/parent::div/following-sibling::div//ul[@role='list']//img";
		while(!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("feed-control-disabled"))
		{
			for(WebElement e:dealList)
			{
				String text = e.getText();
				if(!text.isEmpty()) {
					deelDataList.add(text);
					System.out.println(deelDataList);
				}
			}
			//			Actions act = new Actions(driver);
			//			Thread.sleep(2000);
			//			WebElement mouseOver = driver.findElement(By.xpath(xpath2));
						WebElement next=driver.findElement(By.xpath(next_xpath));
					   // By nextLocator = By.xpath(next_xpath);
			//			act.moveToElement(mouseOver).perform();
			//			act.moveToElement(next).click().perform();
			//			Thread.sleep(2000);
			//driver.findElement(By.xpath(next_xpath)).click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();",next);
//	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.elementToBeClickable(nextLocator)).click();


			//Thread.sleep(2000);
			dealList = driver.findElements(By.xpath(xpath));


		}
		for(String s: deelDataList)
		{
			System.out.println(s);
		}
	}
}
