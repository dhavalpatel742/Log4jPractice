package com.log4j.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

	WebDriver driver;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	@BeforeMethod
	public void setup(){
		
		log.info("****************************** Starting test cases execution  *****************************************");
		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	@Test(priority=1)
	public void FBTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** FBTitleTest *****************************************");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook - log in or sign up");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** FBTitleTest *****************************************");

	}
	
	@Test(priority=2)
	public void FBLogoTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** FBLogoTest *****************************************");
		boolean logo = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']")).isDisplayed();
		Assert.assertTrue(logo);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** FBLogoTest *****************************************");
	}
	
	@AfterMethod
	public void shutdown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
