package com.maven.popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Confirm_Popup 
{
	public static WebDriver driver;

	@BeforeMethod
	public void pre_condition() 
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

//	@AfterMethod
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();
	}

	@Test
	public void handle_popup()
	{
		driver.get("https://www.leafground.com/alert.xhtml");
		
		WebElement confirm_btn = driver.findElement(By.id("j_idt88:j_idt93"));
		
		Actions actions = new Actions(driver);
	            actions.click(confirm_btn).build().perform();

	    driver.switchTo().alert().dismiss();
	}
  
}
