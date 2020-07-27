package part1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class manutest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Files\\geckodriver.exe");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.get("https://www.google.com/");
		driver.get("https://www.google.com/search?q=facebook&rlz=1C1GCEA_enIN873IN873&oq=faceb&aqs=chrome.0.0j69i57j0l6.8504j0j8&sourceid=chrome&ie=UTF-8");
		Thread.sleep(5000);
		
		List<WebElement> ls = driver.findElements(By.xpath("a200165573"));
		for (int i = 0; i < ls.size(); i++) {
			System.out.println("Element gettext : " + ls.get(i).getText());
			
		}
		
		driver.close();
	}

}
