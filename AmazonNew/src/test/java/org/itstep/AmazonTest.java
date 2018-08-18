package org.itstep;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
	
	WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.chrome.driver","C:\\TESTS\\WEB DRIVERS\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.com");
		
		
	}

	

	@Test
	public void test() {
	WebElement a = driver.findElement(By.id("nav-link-accountList"));
	String href = a.getAttribute("href");
	driver.get(href);
	
	WebElement a1 = driver.findElement(By.xpath("//a[@id = 'createAccountSubmit'][@tabindex = '6']"));
	String href1 = a1.getAttribute("href"); 
	driver.get(href1);
	
	WebElement f = driver.findElement(By.id("ap_customer_name"));
	f.sendKeys("Mihsannya22");
	
	WebElement f1 = driver.findElement(By.id("ap_email"));
	f1.sendKeys("pupki22n@gmal.com");
	
	WebElement f2 = driver.findElement(By.xpath("//input[@type='password'][@id='ap_password']"));
	f2.sendKeys("123456");
	
	WebElement f3 = driver.findElement(By.xpath("//input[@type='password'][@id='ap_password_check']"));
	f3.sendKeys("123456");
	
	WebElement but1 = driver.findElement(By.xpath("//input[@id='continue'][@tabindex='11']"));
	but1.submit();
	
	WebElement finala = driver.findElement(By.id("nav-link-accountList"));
	WebElement span = finala.findElement(By.xpath("//span[@class='nav-line-3']"));
	String text = span.getText();
	assertEquals("Hello, Mihsannya22", text);
	
	
	
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

}
