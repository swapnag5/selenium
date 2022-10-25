package seleniumclasses;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarousalConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/");
//        String xpath = "//h3[text()='Recommended for you']/parent::div/parent::div//following-sibling::div//div[@data-qa='widget_productCarousel']";
//		WebElement recomended_for_u=driver.findElement(By.xpath(xpath));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",recomended_for_u);
        //driver.findElement(By.xpath("(//div[contains(@class,'swiper-button-next')])[4]")).click();
		
		getCarousalItemList("Recommended for you");
	}
	
	
	public static void getCarousalItemList(String sectionName) throws InterruptedException
	{
      String xpath = "//h3[text()='"+sectionName+"']/parent::div/..//following-sibling::div//div[@data-qa='product-name']";
       List<WebElement> recomList = driver.findElements(By.xpath(xpath));
       Thread.sleep(2000);

       System.out.println(recomList.size());
       Set<String> dataList = new TreeSet<String>();
       String next_xpath = "//h3[text()='"+sectionName+"']/parent::div/parent::div//following-sibling::div//div[contains(@class,'swiper-button-next')]";
	   while(!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled"))
	   {
		   for(WebElement e:recomList)
		   {
			   String text =e.getText();
			   if(!text.isEmpty())
			   {
				   dataList.add(text);
			   }
		   }
		   driver.findElement(By.xpath(next_xpath)).click();
	       recomList = driver.findElements(By.xpath(xpath));
 
	   }
	   for(String s:dataList)
	   {
		   System.out.println(s);
	   }
	}
}
