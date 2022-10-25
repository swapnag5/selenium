package seleniumclasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAllOptions {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.orangehrm.com/orangehrm-30-day-trial/");

		By country = By.id("Form_getForm_Country");
		
		//getOptions()--all(list) options from select tag--without using select by value,index visible text mthds
		Select select = new Select(driver.findElement(country));
		System.out.println(select.isMultiple()); //isMultiple() mthd tells wether the dropdown multi selection--true/false

		//List<WebElement> dropdownList = select.getOptions();
//		for(WebElement e : dropdownList)
//		{
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains("India"))
//			{
//				e.click();
//				break;
//			}
//		}
		
		 //dropdownSelectValueOfAllOptions(country,"India");
		 
		 
		 //without using select class how to handle drop down
		
		By countrySel = By.xpath("//select[@id='Form_getForm_Country']/option");
		 
//		List<WebElement> optionsList = driver.findElements(countrySel);
//		for(WebElement e : optionsList)
//		{
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains("Australia"))
//			{
//				e.click();
//				break;
//			}
//		}
		
		//dropdownSelectValue(countrySel , "India");
		dropdownSelectValue(countrySel,"Australia");

		
	}
	public static WebElement getElement(By locaor)
	{
		return driver.findElement(locaor);
	}
	
	//select a value from drop down using getOptions method
	public static void dropdownSelectValueWithGetOptions(By locator,String value)
	{
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList)
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
	public static List<WebElement> getElements(By locaor)
	{
		return driver.findElements(locaor);
	}
	
	//without select class
	
	public static void dropdownSelectValueUsingLocator(By locator,String value)
	{
		List<WebElement> optionsList =getElements(locator);
		for(WebElement e : optionsList)
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
	
	//using String locator--take blank String type ArrayList then add all values to that list
	//using String locator
	public static  List<String> dropdownSelectValue(By locator,String value)
	{
		List<WebElement> optionsList =getElements(locator);
		List<String> selectOptionsList = new ArrayList<>();
		for(WebElement e : optionsList)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains(value))
			{
				e.click();
				selectOptionsList.add(value);
				break;
			}
			
		}
		
		return selectOptionsList;
			
		
	}

		
}
