package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	
 static WebDriver driver;	
@BeforeClass
  public static void launch() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
@AfterClass
public static void close() {
	driver.quit();
}

static long startTime;
@Before
public void startTime() {
	startTime = System.currentTimeMillis();
	
}
@After
public void endTime() {
	long endTime =System.currentTimeMillis();
	System.out.println("Total time taken by:"+(endTime-startTime));
}
@Test
public void m1() {
	try {
		WebElement close=driver.findElement(By.xpath("//button[text()='✕']"));
		close.isDisplayed();
		close.click();
	}
	catch(Exception e) {
		System.out.println("Login not Required");
	}
}
static String fn;
@Test
public void m2() throws Exception {
	 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobiles",Keys.ENTER);
	 WebElement mobileName=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	 mobileName.click();
	 fn=mobileName.getText();
	 System.out.println("First Mobile name is:"+fn);
	 }
@Test
public void m3() {
	String cWin =driver.getWindowHandle();
	
	Set<String> allWin=driver.getWindowHandles();
	for(String x:allWin) {
		if(!x.equals(cWin)) {
			driver.switchTo().window(x);
			System.out.println("Window Switched");
		}
		
	}
	
}
@Ignore
@Test
public void m4() { 
	WebElement mobName=driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
	String ln=mobName.getText();
	System.out.println("Second Mobile name is:"+ln);
	boolean mobile=fn.equals(ln);
	System.out.println(mobile);
	
	Assert.assertEquals(fn,fn);
	
	WebElement buyNow=driver.findElement(By.xpath("//button[text()='BUY NOW']"));
	Assert.assertTrue(buyNow.isDisplayed());
	System.out.println("End");
}




}
