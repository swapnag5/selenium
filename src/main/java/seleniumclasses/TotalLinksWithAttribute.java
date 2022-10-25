package seleniumclasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinksWithAttribute {

	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");

//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println("total links :"+links.size());
		//		for(WebElement e : links)
		//		{
		//			String hrefValue = e.getAttribute("href");
		//			System.out.println(hrefValue);
		//		}
		By links = By.tagName("a");
		By imgs = By.tagName("img");
		System.out.println("total links :"+getElementsCount(links));
		System.out.println("toatal images :"+getElementsCount(imgs));


		//		List<String> list =getElementsAttributeList(links, "href");
		//		for(String e : list)
		//		{
		//			System.out.println(e);
		//		}

//		List<String> textList = getElementsTextList(links);
//		for(String e : textList)
//		{
//			if(!e.isEmpty()) {
//			System.out.println(e);
//			}
//		}
		
		if(getElementsTextList(links).contains("Registry"))
		{
			System.out.println("PASS");
		}




	}

	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator)
	{
		return getElements(locator).size();
	}

	public static List<String> getElementsAttributeList(By locator , String attName)
	{
		List<WebElement> list = getElements(locator);
		List<String> attList = new ArrayList<String>();
		for(WebElement e:list)
		{
			String attValue = e.getAttribute(attName);
			//System.out.println(attValue);
			attList.add(attValue);
		}
		return attList;
	}

	public static List<String> getElementsTextList(By locator)
	{
		List<WebElement> list = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: list)
		{
			String eleText = e.getText();
			eleTextList.add(eleText);
		}
		return eleTextList;
	}



}
