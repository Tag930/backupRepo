package paramterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramtest1 {

	WebDriver driver;
	
	@Test
	@Parameters({"browser","url","name","pass"})
	public void login(String browser, String url, String name, String pass) {
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Files\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(name);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		
		driver.findElement(By.className("radius")).click();

	}
}
