package com.epam.mentoring.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DDTGoogleLoginTest {

	WebDriver driver;
//	variables that need to be read from file
	String login = "fortrainingepam";
	String pass = "qwe123asd123zxc";
	String verifName = "+Sergiy";

	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys(login);
		driver.findElement(By.id("Passwd")).sendKeys(pass);
		driver.findElement(By.id("signIn")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='gb_f gb_j']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='gb_f gb_j']")).getText(), verifName, "Name for logged in user is not found. Probably user is not logged in propertly");
	}
	
	@AfterClass
	public void cleanUp(){
		driver.quit();
	}
	
}
