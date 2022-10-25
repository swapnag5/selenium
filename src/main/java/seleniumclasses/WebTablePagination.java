package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePagination {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.selectorshub.com/xpath-practice-page/");
		
		int pageCount = 1;//to count pages on which page record has found
		
		//we dnt know how many times it should iterate then so go for while loop
		while(true)
		{
			//it finds the elemnt if it is greater than 0,then click
			if(driver.findElements(By.xpath("//td[text()='Samsun']")).size()>0)  
			{
				selectCity("Samsun");//generic mthd
				System.out.println("found at page num :"+pageCount);
				break;
			}
			else
			{
				//pagination logic:
				//click on next:
				WebElement next =driver.findElement(By.linkText("Next"));
				
				//what if the elmnt is not available in all pages ,so if we locate the next after its disabled
				if(next.getAttribute("class").contains("disabled"))
				{
					System.out.println("Pagination is over :");
					break;
				}
				
				next.click();
				Thread.sleep(2000);
				pageCount++;
			}

		}


	}
	
	public static void selectCity(String userName)
	{
		driver.findElement(By.xpath("//td[text()='"+userName+"']/preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
