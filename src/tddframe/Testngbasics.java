package tddframe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngbasics {

	@BeforeSuite
	public void setup() {
		System.out.println("Setup system property for chrome");

	}

	@BeforeTest
	public void launchbrowser() {
		System.out.println("Launch chrome Browser");
	}

	@BeforeClass
	public void launchbrowserlogin() {
		System.out.println("Login to app");

	}

	@BeforeMethod
	public void enterURL() {
		System.out.println("URL entered");

	}

	@Test
	public void googleTitleTest() {	
		System.out.println("Google Title Test");

	}

	@AfterMethod
	public void logout() {
		System.out.println("logout from apps");

	}
	
	@AfterClass
	public void closebrowser() {
		System.out.println("CLOSE Browser");
	}

	@AfterTest
	public void deleteAllcookies() {
		System.out.println("deleteallcookies");

	}

	@AfterSuite           //THIS WILL NOT EXECUTE
	public void generatereport() {
		System.out.println("Report Generated");

	}

}
