package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDrodownConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();

		//		List<WebElement> list=driver.findElements(By.xpath("(//div[contains(@id,'DropDownContainer')])[1]/ul//span[@class='comboTreeItemTitle']"));
		//
		//		for(WebElement e : list)
		//		{
		//			String text = e.getText();
		//			System.out.println(text);
		//		}

		By choice = By.xpath("(//div[contains(@id,'DropDownContainer')])[1]/ul//span[@class='comboTreeItemTitle']");

		//tc_01:single selection
		selectSingleChoice(choice, "choice 2");
//		selectChoice(choice, "choice 3");//selecting choice 3
//		Thread.sleep(3000);
//		selectChoice(choice, "choice 3");//deselecting choice 3

		//selectChoice(choice,"choice 9");
		//tc_2:multi selection
		//selectMultiChoice(choice,"choice 1","choice 4","choice 6 2 1","choice 7");
//		selectChoice(choice,"choice 1","choice 4","choice 6 2 1","choice 7");
//		selectChoice(choice,"choice 1","choice 4","choice 6 2 1","choice 7");

		//tc_03:all selection
		//selectChoice(choice,"all");
	}

	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	//select single choice from dropdown

	public static void selectSingleChoice(By locator,String value)
	{
		List<WebElement> choiceList=getElements(locator);

		for(WebElement e : choiceList)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains(value))
			{
				e.click();
				break;
			}
		}
	}
	//select multi choice from dropdown

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

	//it will work for single,multi,or select all choices from dropdown

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
