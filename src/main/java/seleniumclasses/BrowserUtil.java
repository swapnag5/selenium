package seleniumclasses;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;
	//initializing the driver
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/Users/chinnu/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "/Users/chinnu/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			//System.setProperty("webdriver.gecko.driver", "/Users/chinnu/Downloads/geckodriver");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			driver = new SafariDriver();
		}
		else
			System.out.println("enter correct browser "+browserName);

		return driver;
	}

	//launching browser: launchUrl method with String type parameters

	public void launchUrl(String url)
	{
		if(url==null)
		{
			System.out.println("enter url");
			return;
		}
		if((url.indexOf("http")==-1)&&(url.indexOf("https")==-1))
		{
			System.out.println("http/s missing in the url");
			try
			{
				throw new Exception("HTTPMISSINGEXCEPTION");
			}catch(Exception e)
			{
				System.out.println("http(s) missing");
			}
			
		}
		driver.get(url);
	}
	
	//launchUrl overloaded with URL type parameters
	
	public void launchUrl(URL url)
	{
		driver.navigate().to(url);
	}

	//get title

	public String getPageTitle()
	{
		return driver.getTitle();

	}

	//get url
	public String getPageUrl()
	{
		return driver.getCurrentUrl();

	}

	public void closeBrowser()
	{
		driver.close();
	}

	public void quitBrowser()
	{
		driver.quit();
	}

}
