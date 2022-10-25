package seleniumclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//SVG--Scalable Vector Graphs
		//only xpath applicable for SVG element
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.petdiseasealerts.org/forecast-map#/");

		List<WebElement> statesList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		for(WebElement e : statesList) {
			act.moveToElement(e).perform();
			String state = e.getAttribute("name");
			System.out.println(state);
			if(state.equals("California"))
			{
				e.click();
				

//				List<WebElement> countyList = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='california']//*[name()='path']"));
//				Thread.sleep(5000);
//				for(WebElement ele : countyList) {
//					act.moveToElement(ele).perform();
//					String county = ele.getAttribute("name");
//					System.out.println(county);
					break;
				//}
			}
		}

	}
}
