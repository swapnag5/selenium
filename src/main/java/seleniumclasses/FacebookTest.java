package seleniumclasses;

public class FacebookTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.init_driver("chrome");
		br.launchUrl("http://www.facebook.com");
		String title = br.getPageTitle();
		System.out.println(title);
		if(title.contains("Facebook"))
		{
			System.out.println("Correct title");
		}
		String url = br.getPageUrl();
		System.out.println(url);
		
		br.closeBrowser();
		}

}
