package seleniumclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandleConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		//frame
		//iframe
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(3);//by indexing frame
		//driver.switchTo().frame("navbar");//by passing name attribute value
		driver.findElement(By.name("navbar"));//by web element
		
		String header = driver.findElement(By.tagName("h3")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();//the driver come back to the web page from frame
		

		//selenium 4.x:
		driver.switchTo().parentFrame();//the driver focused on the immediate parent frame 
	}

}
