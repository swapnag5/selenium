package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentAnnotations {

	@BeforeSuite
	public static void dbConnection()
	{
		System.out.println("BS--DB connection");
	}
	@BeforeTest
	public static void createUser()
	{
		System.out.println("BT--Create user");
	}
	@BeforeClass
	public static void launchBrowser()
	{
		System.out.println("BC--launch browser");
	}
	@BeforeMethod
	public static void loginToApp()
	{
		System.out.println("BM--login user");
	}
	@Test
	public static void getPageTitleTest()
	{
		System.out.println("title test");
	}
	@Test
	public static void getLoginTest()
	{
		System.out.println("login test");
	}
	@Test
	public static void getPageUrlTest()
	{
		System.out.println("url test");
	}
	@AfterMethod
	public static void logout()
	{
		System.out.println("AM--logout user");
	}
	@AfterClass
	public static void closeBrowser()
	{
		System.out.println("AC--Close browser");
	}
	@AfterTest
	public static void deleteUser()
	{
		System.out.println("AT--delete user");
	}
	@AfterSuite
	public static void disconnectDB()
	{
		System.out.println("AS--disconnect db");
	}
}
