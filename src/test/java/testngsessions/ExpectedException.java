package testngsessions;

import org.testng.annotations.Test;

public class ExpectedException {
	String name;
	@Test(expectedExceptions= {ArithmeticException.class,NullPointerException.class})
	public void loginTest()
	{
		System.out.println("hii");
		int x= 9/0;
		System.out.println(x);
		ExpectedException obj = new ExpectedException();
		obj.name=null;
		System.out.println(obj.name);
	}
}
