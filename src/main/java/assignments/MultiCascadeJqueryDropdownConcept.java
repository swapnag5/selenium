package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiCascadeJqueryDropdownConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox1")).click();
		By choice = By.xpath("(//div[contains(@id,'DropDownContainer')])[2]//span[@class='comboTreeItemTitle']");

//		List<WebElement> list = driver.findElements
//				(By.xpath("(//div[contains(@id,'DropDownContainer')])[2]/ul//span[@class='comboTreeItemTitle']"));
//		
//		for(WebElement e:list)
//		{
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains("choice 2"))
//			{
//				e.click();
//				break;
//			}
//		}
		//selectMultiChoice(choice,"choice 2","choice 6");
		//selectChoice(choice, "all");

	}
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	public static void selectMultiChoice(By locator,String... value)//3 . parameter is another way of array representation
	{
		List<WebElement> choiceList=getElements(locator);

		for(WebElement e : choiceList)
		{
			String text = e.getText();
			System.out.println(text);
			for(int i=0;i<value.length;i++)
			{
				if(text.equals(value[i]))
				{
					e.click();
					break;
				}
			}


		}
	}
	public static void selectChoice(By locator,String... value)//3 . parameter is another way of array representation
	{
		List<WebElement> choiceList=getElements(locator);
		boolean flag = false;//what if user pass wrong choice

		if(value[0].equalsIgnoreCase("all"))
		{
			for(WebElement e: choiceList)
			{
				e.click();
				flag = true;
			}
		}
		else
		{
			for(WebElement e : choiceList)
			{
				String text = e.getText();
				//System.out.println(text);
				for(int i=0;i<value.length;i++)
				{
					if(text.equals(value[i]))
					{
						flag = true;
						e.click();
						break;
					}
				}


			}
		}
		if(flag==false)
		{
			System.out.println("choice is not available "+value[0]);
		}
	}




}
