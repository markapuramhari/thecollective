package org.thecollective.modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thecollective.maincontroller.MainController;

import com.google.common.base.Function;

public class Sparrow extends MainController
{
	 private  int minValue=0;
	 private int maxValue=149;
	@Test()
	public void reIndexProductIds() throws InterruptedException {
	 String csvFile = "C:\\Users\\thiruveedhi.chinna-v\\Downloads\\Testing Product Shop Details.csv";
     String line = "";
     String cvsSplitBy=",";
    
     ArrayList<String> ar = new ArrayList<String>();
     driver.findElement(By.xpath("//input[@name='sleUsername']")).clear();
     driver.findElement(By.xpath("//input[@name='sleUsername']")).sendKeys("kramesh1");
     driver.findElement(By.xpath("//input[@name='slePassword']")).clear();
     driver.findElement(By.xpath("//input[@name='slePassword']")).sendKeys("Boss%123");
     driver.findElement(By.xpath("//button[text()='Sign me in']")).click();
     Thread.sleep(2500);
     driver.get("http://testsparrow.trendin.com/es/regenerate");
     Thread.sleep(2500);
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//li[@class='dropdown']")).click();
     driver.findElement(By.xpath("//a[text()='testing_products']")).click();
     driver.findElement(By.id("DocIDs")).clear();
     try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
     {
          while ((line = br.readLine()) != null)
         {
             // use comma as separator
             String[] productId = line.split(cvsSplitBy);
            List<String> s= Arrays.asList(productId[0]);
           for(int i=0;i<s.size();i++) 
	           {
        	   ar.add(s.get(i));
        	   //System.out.println("product id= " + s.get(i));
	            }
         }
         System.out.println(ar.size());
         for(int k=minValue;k<maxValue;k++)
         {
        	 driver.findElement(By.id("DocIDs")).clear();
         for(int j=minValue;j<maxValue || j<ar.size();j++) 
         {
         driver.findElement(By.id("DocIDs")).sendKeys(ar.get(j)+",");
         }
    	 driver.findElement(By.xpath("//button[@onclick='generateCSV()']")).click();
    	 System.out.println(ar.get(maxValue-1));
    	 Assert.assertTrue(assertVerifySuccess(ar.get(maxValue-1)),"products were not generated successfully");
    	 minValue=minValue+149;
    	 maxValue=maxValue+150;
         }

     } catch (IOException e) {
         e.printStackTrace();
     }

 }
	private boolean assertVerifySuccess(String lastRecord) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(1500, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.xpath("//div/*[contains(text(),'"+lastRecord+"')]"));
			}
			});
			if(foo.isDisplayed())
				{
					return true;
				}
			else 
				{
					return false;
				}
		
	}

}
