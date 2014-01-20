package com.epam.mentoring.tests;

import java.util.concurrent.TimeUnit;

import com.epam.mentoring.dataprovider.CsvDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.mentoring.configuration.CredentialsConfiguration;
import com.epam.mentoring.dataprovider.JsonDataProvider;

public class DDTGoogleLoginTest {

	CredentialsConfiguration credentials;
	WebDriver driver;
	CsvDataProvider data;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		here you should change initialization of dataprovider
		data = new CsvDataProvider();
		credentials = new CredentialsConfiguration(data.loadData());
//		use one of this initialization
//		credentials = new CredentialsConfiguration(data.loadData(2));
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys(credentials.getLogin());
		driver.findElement(By.id("Passwd")).sendKeys(credentials.getPassword());
		driver.findElement(By.id("signIn")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='gb_f gb_j']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='gb_f gb_j']")).getText(), credentials.getUserName(), "Name for logged in user is not found. Probably user is not logged in propertly");
	}
	
	@AfterClass
	public void cleanUp(){
		driver.quit();
	}
	
}
