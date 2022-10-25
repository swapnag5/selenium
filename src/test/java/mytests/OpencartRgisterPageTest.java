package mytests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class OpencartRgisterPageTest extends BaseTest {
	
	@DataProvider
	public Object[][] getRegisterData()
	{
		return new Object[][] {
			{"sai","ram","sai@gmail.com","32342","sairam","sairam","yes"},
			{"jai","sri","jai@gmail.com","3342","jai","jai","no"},
			{"sita","ram","sita@hjdg","34221","sita","sita","yes"}
		};
	}
	@Test(dataProvider="getRegisterData")
	public void registerTest(String fname,String lname,String mail,String phone,String pwd,
			                 String confpwd,String subscribe) throws InterruptedException
	{
		//Thread.sleep(5000);
	  doRegister(fname, lname, mail, phone, pwd, confpwd, subscribe);
	  //Assert.assertEquals("driver.getTitle()", "Register Account");
	}
	public void doRegister(String fname,String lname,String mail,String phone,String pwd,
			                 String confpwd,String subscribe) {
		
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lname);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(mail);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(confpwd);
		
		if(subscribe.equalsIgnoreCase("yes"))
		{
			driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@name='newsletter' and @value='0']")).click();

		}
	}

}
