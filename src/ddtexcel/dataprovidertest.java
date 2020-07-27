package ddtexcel;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.TestUtil;

import junit.framework.Assert;

public class dataprovidertest extends Base {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
	
		Base obj = new Base();
		obj.browseropen(driver);
	}

	@DataProvider(name = "newdata")
	public Iterator<Object[]> gettestdata() {
		ArrayList<Object[]> testData = TestUtil.getexceldata();
		//System.out.println(testData.iterator());
		return testData.iterator();
		//System.out.println(testData.iterator());

	}



	@Test(dataProvider = "newdata")
	public void testmn(String email1, String pass1) throws InterruptedException {

		System.out.println(email1+pass1);

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//*[@id='header-waypoint-sticky']/div[1]/div/div/div[2]/div/ul/li[3]/div"))).click().build().perform();
		Thread.sleep(1000);
		if (driver.findElement(By.linkText("Login")).isDisplayed()) {
			act.moveToElement(driver.findElement(By.linkText("Login"))).click().build().perform();
		}
		



		boolean r = false;
		driver.findElement(By.xpath(
				"//*[@id='toggleStyle04-collapseOne']/div/div/div[3]/div/div[1]/input")).
		clear(); driver.findElement(By.xpath(
				"//*[@id='toggleStyle04-collapseOne']/div/div/div[3]/div/div[1]/input")).
		sendKeys(email1);

		driver.findElement(By.xpath(
				"//*[@id='toggleStyle04-collapseOne']/div/div/div[3]/div/div[2]/input")).
		clear(); driver.findElement(By.xpath(
				"//*[@id='toggleStyle04-collapseOne']/div/div/div[3]/div/div[2]/input")).
		sendKeys(pass1);


		driver.findElement(By.xpath(
				"//*[@id='toggleStyle04-collapseOne']/div/div/div[3]/div/div[3]/label")).
		click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id='loginfrm']/button")).click();
		Thread.sleep(3000);
		if (driver.getCurrentUrl().equals("https://www.phptravels.net/account/")) {
			
			r = true;
			
		}
		
		
		
		Assert.assertEquals(true, r);



	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}

}
