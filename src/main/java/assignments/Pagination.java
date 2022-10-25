package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://homedepot.com");
		Thread.sleep(2000);
		driver.findElement(By.id("headerSearch")).sendKeys("samsung washer");
//		List<WebElement> target = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']//*[name()='path']"));
//		for(WebElement e:target) {
//			Actions act = new Actions(driver);
//			act.click(e).perform();
//		}
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='SearchBox__buttonIcon']")).click();
		List<WebElement> pages = driver.findElements(By.xpath("//nav[@role='navigation']/ul/li"));
		System.out.println(pages.size());
		int i=0;
		//int pagecount=1;
		while(true)
		{
			if(driver.findElements(By.xpath("//a[@class='header product-pod--ie-fix']//span[text()='BLACK+DECKER67']")).size()==1)
			{
				selectItem("BLACK+DECKER67");
				//driver.findElement(By.xpath("//a[@title='Fellix Wooden Brown Book Rest'")).click();
				break;
			}
			else {
				//WebElement next = driver.findElement(By.linkText("Next"));
				try {
				pages.get(i).click();
				}catch(Exception e)
				{
					System.out.println("pagination is over and did not find the item: ");
					break;
				}
				pages = driver.findElements(By.xpath("//nav[@role='navigation']/ul/li"));                
               Thread.sleep(2000);
              
			}
			i++;
			//pagecount++;
		}
		
		
	}
	
	public static void selectItem(String item) {
		
		driver.findElement(By.xpath("//a[@class='header product-pod--ie-fix']//span[text()='"+item+"']")).click();
	}
}

