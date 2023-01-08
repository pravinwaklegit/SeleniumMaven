package com.practiceSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_VerifyTable {
	
	
    @Test
	public void verifyTable() {
			
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://selectorshub.com/xpath-practice-page/");
		
     //List<WebElement> allheaders=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
     ////table[@id='resultTable']//tr//td[2]
     List<WebElement> allheaders=driver.findElements(By.xpath("//table[@id='resultTable']//th"));
   
   
     System.out.println(allheaders.size());
     Assert.assertEquals(allheaders.size(),5,"Count do not match");
     
     boolean status=false;
     for(WebElement ele:allheaders)
     {
    	 String value=ele.getText();
    	 System.out.println(value);
    	 if(value.contains("Status"))
    	 {
    		 status=true;
    		 break;
    	 }
     }
     Assert.assertTrue(status, "Jasmine is not present");
     
     List<WebElement> numberOFRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
     System.out.println("No of Rows are "+numberOFRows.size());
     Assert.assertEquals(numberOFRows.size(), 6,"Count Mismatch");
     
     driver.quit();
	}

}
