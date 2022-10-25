package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	WebDriver driver;

	@BeforeTest(description="...set up the the amazon Test....")
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com");
	}
	@Test(priority=3,description = ".....checking the title of the page....")
	public void pageTitleTest()
	{
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Amazon.com. Spend less. Smile more.","...amazon page title is wrong...");
	}
	@Test(priority=1,description="....checking page url....",enabled=false)
	public void pageUrlTest()
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("amazon"));
	}
	@Test(priority=2,description="...checking the search field exist or not...")
	public void isSearchFieldExistTest() {
		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@AfterTest(description = "....closing the browser...")
	public void tearDown() {
		driver.quit();
	}
}
