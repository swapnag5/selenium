package assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoWebTable {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/new-zealand-a-in-india-2022-1329818/india-a-vs-new-zealand-a-3rd-unofficial-test-1329823/full-scorecard");

		//		String text = driver.findElement(By.xpath("(//span[text()='Rachin Ravindra'])[2]//ancestor::tr")).getText();
		//		System.out.println(text);

		//		List<WebElement> scorecardList = driver.findElements(By.xpath("(//span[text()='Rachin Ravindra'])[2]//ancestor::td/following-sibling::td"));
		//		
		//		for(WebElement e: scorecardList)
		//		{
		//			System.out.println(e.getText());
		//		}

		//
		//System.out.println(getScoreCard("Rachin Ravindra"));
		
		List<WebElement> tableList = driver.findElements(By.xpath("(//th[text()='BATTING'])[1]//ancestor::table//span//ancestor::tr"));
		for(WebElement e:tableList)
		{
			System.out.println(e.getText());
		}
	}
	public static List<String> getScoreCard(String userName)
	{
		List<WebElement> scorecardList = driver.findElements(By.xpath("(//th[text()='BATTING'])[2]/ancestor::table//span[text()='"+userName+"']/ancestor::td/following-sibling::td"));

		List<String> scoreList = new ArrayList<>();
		for(WebElement e: scorecardList)
		{
			String text = e.getText();
			scoreList.add(text);
		}
		return scoreList;
	}


}
