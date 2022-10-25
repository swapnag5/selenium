package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
	
	@Test(priority=3,description = ".....checking the title of the page....")
	public void pageTitleTest()
	{
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Amazon.com. Spend less. Smile more.","...amazon page title is wrong...");
	}
	@Test(priority=1,description="....checking page url....")
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
	
}
