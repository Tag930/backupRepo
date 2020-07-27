package tddframe;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	//@Test(timeOut = 5000)
	public void test() {
		int i =1;
		while (i==1) {
			System.out.println(i);
			}
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test2() {
		String x= "100A";
		Integer.parseInt(x);
		
	}
}
