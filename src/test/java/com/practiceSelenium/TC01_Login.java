package com.practiceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_Login {
		
	    @Test
		public void Login_test() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			 Thread.sleep(3000);
		     driver.findElement(By.name("username")).sendKeys("Admin");
			 driver.findElement(By.name("password")).sendKeys("admin123");
			 driver.findElement(By.xpath("//button [@type= 'submit']")).click();
			 
			 Thread.sleep(3000);
			 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			 driver.close();
			
		}

	}
