package seleniumclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//1.Recommended for local execution
		//WebDriver driver = new ChromeDriver();
        //1.not recommended
		//ChromeDriver driver = new ChromeDriver();
		
		//2.not recommended it has only two methods
		//SearchContext driver = new ChromeDriver();
		 
		//3.recommended for local execution
		//RemoteWebDriver driver = new ChromeDriver();
		
		//4.Recommended for only remote GRID execution : cloud,remote,AWS machines
		//WebDriver driver = new RemoteWebDriver(new URL("123.43.321.3"), capabilities);
		
		//5.recommended only for edge and chrome 
		//ChromiumDriver driver = new EdgeDriver();
		
		//6.
		//WebDriver driver = new OperaDriver();//opera is deprecated in Selenium 4.x
	}

}
