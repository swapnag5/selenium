package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLocators {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		 
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		br.launchUrl("http://demo.opencart.com/index.php?route=account/login");
		
		//ElementUtil elUtil = new ElementUtil(driver);

		//1.id--always unique attribute
		
		//2.Name--it can be duplicate
		
//		driver.findElement(By.name("email")).sendKeys("aks@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("abc");
//		
		//3.classname--duplicate most of the times
		
		//driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");
		
		//4.xpath--isnot an attribute,it is address of the element in the html DOM
		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@hm");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@hm");
//		driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();


//		By email=By.xpath("//*[@id=\"input-email\"]");
//		By pwd=By.xpath("//*[@id=\"input-password\"]");
//		By loginBttn=By.xpath("//*[@id=\"form-login\"]/button");
//		
//		ElementUtil elUtil = new ElementUtil(driver);
//		elUtil.doSendKeys(email, "test@gmail");
//		elUtil.doSendKeys(pwd, "test");
//		elUtil.doClick(loginBttn);
		
		//5.Cssselector--not an attribute
		
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gma");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@gma");
//		driver.findElement(By.cssSelector("#form-login > button")).click();
		
		//6.LinkText---works only for links having text
		//driver.findElement(By.linkText("Register")).click();
		
//		By link = By.linkText("Register");
//		 //elUtil.doGetText(link);
//		
//		if(elUtil.doGetText(link).equals("Register"))
//		{
//			System.out.println("PASS");
//		}
//		
		//7.PartialLinkText---only works for having a long text
		
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8.TagName --- 
		
		String header = driver.findElement(By.tagName("h2")).getText();

		System.out.println(header);
	}

}
