package com.maven.popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Alert_PopUp 
{
    public static WebDriver driver;
	
    @BeforeMethod
	public void pre_condition() 
	{
    		
        driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();
	}
	
	
	@Parameters("url")
	@Test
	public void handle_popup(String url) throws InterruptedException 
	{
		driver.get(url);
		WebElement alert_btn = driver.findElement(By.id("buttonAlert2"));
		alert_btn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}
}
