package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count=0;
	int Limit=3;
	
	public boolean retry(ITestResult result) {
		if (count<Limit) {
			count++;
			return true;
		}
		return false;
		
	}

}
