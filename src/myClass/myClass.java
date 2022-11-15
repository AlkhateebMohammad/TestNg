package myClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;

public class myClass {
	
	public WebDriver driver;
	
	String baseUrl="https://www.saucedemo.com/";
	@BeforeTest
	public void login()
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(baseUrl);
		
	driver.manage().window().maximize();
	
	}
	
	@Test
	public void testLogin() throws InterruptedException
	{
		WebElement expecteUser=driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		expecteUser.sendKeys("standard_user");
		WebElement actuialPass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		actuialPass.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void addCart()
	{
		int expectedNumber=5;
		List<WebElement> myButton=driver.findElements(By.className("btn "));
		
	for(int i=0 ;i<myButton.size();i++)
	{
		myButton.get(i).click();
	}
	
String actuailNumer=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
int RealAcctuailNumber=Integer.parseInt(actuailNumer);
Assert.assertEquals(RealAcctuailNumber,expectedNumber);
		

		
		
	}
	@AfterTest
	public void afterBroser()
	{
		driver.close();
	}
	

}
