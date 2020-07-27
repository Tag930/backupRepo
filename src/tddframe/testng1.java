package tddframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testng1 {
	
	ChromeDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
	}
	@Test(priority=2,groups="menu")
	public void testmn() throws InterruptedException {
		
		driver.findElement(By.className("menu_Holidays")).isDisplayed();
		Thread.sleep(5000);
		
	}
	@Test(priority=1,groups="link",dependsOnGroups = "menu")
	public void testmn2() throws InterruptedException {
		
		//driver.findElement(By.linkText("Search")).isDisplayed();
		boolean b=driver.findElement(By.xpath("//a[contains(text(),'Search')]")).isDisplayed();
		
		if (b) {
			driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
			boolean b1 = driver.findElement(By.className("flexOne")).getText().equalsIgnoreCase("Zero Cancellation");
		}
		
	}
	
	@Test(priority=1, groups="UI")
	public void testt3() {
		driver.findElement(By.className("mmtLogo")).isDisplayed();
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}

}
