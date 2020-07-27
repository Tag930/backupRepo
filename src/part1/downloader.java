package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class downloader {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium Files\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Files\\geckodriver.exe");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.get("https://www.google.com/");
		driver.get("http://online-courses.club/creating-an-advanced-cinematic-character-vagrant-knight-chinese-eng-sub/");
		//driver.findElement(By.xpath("//*[@id=\"post-3756\"]/div[2]/div[2]/div[2]/div[1]")).click();
		//Actions act =new Actions(driver);
		//act.fi
		//WebElement element = driver.findElement(By.xpath("//*[@id='post-3756']/div[2]/div[2]/div[2]/div[1]"));
		WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[1]/article/div[2]/div[2]/div[2]"));
		//System.out.println(element.getText());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1500);
		String strFirstWindowHandle = driver.getWindowHandle();
		driver.findElement(By.className("su-spoiler-title")).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
		Thread.sleep(500);
		
		List<WebElement> lst =driver.findElements(By.xpath("/html/body/div[1]/div[2]/main/div[1]/article/div[2]/div[2]/div[2]/div[2]/p[2]/a"));
		//driver.findElement(By.id("/html/bod/html/body/div[1]/div[2]/main/div[1]/article/div[2]/div[2]/div[2]/div[2]/p[2]y/div[1]/div[2]/main/div[1]/article/div[2]/div[2]/div[2]/div[1]/span[1]")).click();
		//Actions actions = new Actions(driver);
		//actions.moveToElement(element2).click().build().perform();
		//driver.findElement(By.xpath("//*[@id='IL_AD1']")).click();
		for (int i = 0; i < lst.size(); i++) {
			lst.get(i).click();
			Thread.sleep(2000);
			//String windowHandle = driver.getWindowHandle();
			//ArrayList tabs = new ArrayList (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			//driver.switchTo().window(tabs.get(0));

			//Switch back to original window
			//driver.switchTo().window(mainWindowHandle);
			for (String handle1 : driver.getWindowHandles()) {
		        System.out.println(handle1); 
		        driver.switchTo().window(handle1);     }
			//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			Thread.sleep(35000);
			//if (driver.findElement(By.xpath("")).isDisplayed()) {
			driver.findElement(By.linkText("download/view now")).click();
				//driver.findElement(By.xpath("/html/body/section[1]/div/div/div[3]/table/tbody/tr[2]/td/div/a")).click();
			WebElement el = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[3]/div/div/div[5]/table/tbody/tr[1]/td[2]/a[1]"));
			//driver.get(el.getText());
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
			Thread.sleep(1500);
			int j = 0;
			while (j<=10) {
				el.sendKeys(Keys.ARROW_DOWN);
			   i++;
				
			}
			
				driver.findElement(By.xpath("/html/body/section[1]/div/div/div[3]/div/div/div[5]/table/tbody/tr[1]/td[2]/a[1]")).click();
				((JavascriptExecutor) driver).executeScript("window.close();");
				driver.switchTo().window(strFirstWindowHandle);
				//Set<String> setWindowHandles = driver.getWindowHandles();
				//var originalTabInstance = myWebDriverInstance.CurrentWindowHandle;
			/*
			 * for(String strWindowHandle: setWindowHandles){ //If the window handle is not
			 * same as the one stored before opening up second window, it is the new window
			 * if(!strWindowHandle.equals(strFirstWindowHandle)){ //Switch to the new window
			 driver.switchTo().window(strWindowHandle); //Print window title
			 * System.out.println(driver.getTitle()); //Close this browser window
			 * driver.close(); //Exit from loop break; } }
			 */
				
				
			//}
			Thread.sleep(120000);
			
			
			
		}

		
		System.out.println(driver.getTitle());

	}

}
