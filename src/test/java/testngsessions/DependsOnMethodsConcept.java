package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	//AAA Rule----Arrange Act Assert
	//dependsOnMethods means if some test cases depends on other testcase if that test case pass only the 
	//dependent tests will be executed otherwise skipped
	@Test
	public void loginTest()
	{
		System.out.println("login test");
		//int i=2/0;//it fails bcz of ArithmeticException so other tests skipped they r dependent on this test
	}
	@Test(dependsOnMethods="loginTest")
	public void dashboardTest()
	{
		System.out.println("dashboard test");
	}
	@Test(dependsOnMethods="loginTest")
	public void searchTest()
	{
		System.out.println("search test");
	}
}
