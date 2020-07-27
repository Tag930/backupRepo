package tddframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleTitleTest {
	WebDriver driver;

	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	@Test(priority=2,groups="icon")
	public void testmn() throws InterruptedException {
		
		String st=driver.getTitle();
		String title="Google";
		Assert.assertEquals(title, st, "Title is not matched");
		
	}
	
	@Test(dependsOnGroups = "icon")
	public void testst() {
		
		boolean b= driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(b,"Logo not Found");
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}

}
