package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TVPurchase {

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
	 	 driver.findElement(By.xpath("//input[@name='q']")).sendKeys("TV",Keys.ENTER);
	 	 WebElement tv=driver.findElement(By.xpath("(//div[contains(text(),'PHILIPS')])[1]"));
	 	 tv.click();
	 	 fn=tv.getText();
	 	 System.out.println("First TV name is:"+fn);
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

	 @Test
	 public void m4() { 
	 	WebElement tv=driver.findElement(By.xpath("//span[contains(text(),'PHILIPS')]"));
	 	String ln=tv.getText();
	 	System.out.println("Second TV name is:"+ln);
	 	boolean compare=fn.equals(ln);
	 	System.out.println(compare);
	 	
	 	Assert.assertEquals(fn,ln);
	 	
	 	WebElement buyNow=driver.findElement(By.xpath("//button[text()='BUY NOW']"));
	 	Assert.assertTrue(buyNow.isDisplayed());
	 	System.out.println("End");
	 }

}
