package assignments;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumclasses.ElementUtil;

public class TotalImgsAttributes {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");

		By imgs = By.tagName("img");
		ElementUtil elUtil = new ElementUtil(driver);
		List<String> imgList = elUtil.getElementsAttributeList(imgs, "alt");

		for(String e : imgList)
		{
			System.out.println(e);
		}


	}

}
