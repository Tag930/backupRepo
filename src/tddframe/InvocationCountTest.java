package tddframe;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 10)
	public void test1() {
		int a= 10;
		int b=20;
		
		
		System.out.println("Product of the two is " + a*b);
		
	}

}
