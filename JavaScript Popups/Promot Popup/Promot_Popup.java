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

public class Promot_Popup 
{
	public static WebDriver driver;

	@BeforeMethod
	public void pre_condition() 
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();
	}

	@Test
	public void handle_popup()
	{
		driver.get("https://demoapps.qspiders.com/ui/alert/prompt?sublist=2");
		
		WebElement promot_btn = driver.findElement(By.xpath("//button[text()='Prompt Alert Box']"));
		
		Actions actions = new Actions(driver);
	            actions.click(promot_btn).build().perform();
	    
	    driver.switchTo().alert().sendKeys("yes");
	    driver.switchTo().alert().accept();
	}

}
