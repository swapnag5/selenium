package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginOpenCartTest extends BaseTest {
	
	

	@DataProvider
	public Object[][] getLoginData()
	{
		return new Object[][] {
			{"admin23421@gmail.com","test123456"},
			{"admin23345@gmail.com"," "},
			{" ","test35271"},
			{" "," "}
		};
	}

	@Test(dataProvider="getLoginData")
	public void loginTest(String username,String password)
	{
		Assert.assertTrue(doLogin(username, password));
	}
	
	public boolean doLogin(String username,String password)
	{
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String warningMssg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		if(warningMssg.contains("No match for E-Mail Address and/or Password."))
		{
			return true;
		}
		
      return false;
	}
}
