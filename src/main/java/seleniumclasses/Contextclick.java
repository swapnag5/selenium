package seleniumclasses;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contextclick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//context--right click

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		By rightClick=By.xpath("//span[contains(text(),'right click me')]");
		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(rightClick)).perform();

		By rightClickItems = By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]");
		By cut = By.xpath("//span[text() = 'Cut']");
		By copy = By.xpath("//span[text() = 'Copy']");
		By quit = By.xpath("//span[text() = 'Quit']");

		//driver.findElement(By.xpath("//span[text() = 'Cut']")).click();

		//		List<WebElement> right_click_list = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]"));
		//	    
		//		for(WebElement e: right_click_list)
		//		{
		//			String text = e.getText();
		//			System.out.println(text);
		//			if(text.equals("Copy"))
		//			{
		//				e.click();
		//				break;
		//			}
		//		}
		//	

		/***using generic method***/
		//method 1:
		selectRightClickMenuItem(rightClick,quit);
		//method:2
//		List<String> rightlist = getRightClickMenuList(rightClick, rightClickItems);
//        System.out.println(rightlist);


	}
	public static  WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static  List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	//select the item form right click menu directly(direct item locator)
	public static void selectRightClickMenuItem(By rightClick,By rightMenuItem)
	{
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();
		getElement(rightMenuItem).click();

	}
	//get the list of rightclick menu items using the context click
	public static List<String> getRightClickMenuList(By rightClick,By rightMenuItemList)
	{
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).perform();


		List<WebElement> right_click_list = getElements(rightMenuItemList);
		List<String> rightMenuList = new ArrayList<String>();

		for(WebElement e: right_click_list)
		{
			String text = e.getText();
			rightMenuList.add(text);
		}
		return rightMenuList;

	}
}
