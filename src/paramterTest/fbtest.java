package paramterTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class fbtest {
	WebDriver driver;

	@BeforeMethod
	public void LauncherFb1()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Files\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https:\\www.google.com");


	}

	@Test 
	@Parameters("browser")
	public void LoginFb(String bw)
	{
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(bw);
		List<WebElement> ls = driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']"));

		String xx1="//*[@id='tsf']/div[2]/div/div[2]/div[2]/ul/li[";
		String xx2="]";
		String ff=bw;

		for(int i=1;i<ls.size();i++)
		{
			//
			String srch= driver.findElement(By.xpath(xx1+i+xx2)).getText();
			//System.out.println(srch);

			if (ff.equals(srch)) 
			{

				driver.findElement(By.xpath(xx1+i+xx2)).click();



				List<WebElement> lst = driver.findElements(By.xpath("//*[@class='bkWMgd']//following-sibling::cite"));
				//String txt=	driver.findElement(By.xpath("//*[@id='rso']/div[3]//following-sibling::cite")).getText();
				for (int j = 0; j < lst.size(); j++) {
					//System.out.println("Elements are :"+ lst.get(j).getText());
					if (lst.get(j).getText().contains("facebook.com"))
					{
						lst.get(j).click();
						{
							break;					
						}}
				}}
		}
	}

	@AfterMethod
	public void close()
	{

		driver.close();

	}
}
