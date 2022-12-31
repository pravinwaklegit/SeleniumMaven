package com.practiceSelenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_LoginWithHM {
	
	
	static HashMap<String,String> logindata()
	{
	 HashMap<String,String> hm=new HashMap<String,String>();
	 hm.put("x", "pravinwaklegit@PWakle123");
	 hm.put("y", "pravinwgit@j0g0NNath");
	 return hm;
	}
    
	@Test
	public void LoginWithHM() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://github.com/login");
		
		String credentials=logindata().get("y");
		String arr[]=credentials.split("@");
		
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		Assert.assertEquals(driver.getTitle(), "GitHub");
		
		driver.findElement(By.xpath("//img[@class=\"avatar avatar-small circle\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"dropdown-item dropdown-signout\"]")).click();
		
		
		driver.close();
		

	}

}
