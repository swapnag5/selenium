package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{
	
	@Test(priority=1,description = ".....checking the title of the page....")
	public void pageTitleTest()
	{
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Sign Up for a Free HR Software Trial | OrangeHRM | OrangeHRM","...orangehrm page title is wrong...");
	}
	@Test(priority=2,description="....checking page url....",enabled=true)
	public void pageUrlTest()
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("orangehrm"),"...url not matched with https://www.orangehrm.com/orangehrm-30-day-trial/?");
	}
	
	
}
