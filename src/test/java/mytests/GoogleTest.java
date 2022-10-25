package mytests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	

	
	@Test(priority=1,description = ".....checking the title of the page....")
	public void pageTitleTest()
	{

		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Google","...google page title is wrong...");
	}
	@Test(priority=2,description="....checking page url contains google....",enabled=true)
	public void pageUrlTest()
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("google"),"...url not matched with https://www.google.com/");
	}
	
	@AfterTest(description = "....closing the browser...")
	public void tearDown() {
		driver.quit();
	}

}
