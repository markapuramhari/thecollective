package org.thecollective.modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	 private  int minValue=1;
	 private int maxValue=1000;
	@Test()
	public void reIndexProductIds() throws InterruptedException {
	 String csvFile = "D:\\Thiruveedhi\\Implementation\\thecollective\\resources\\ExcelsheetData\\t_product.csv";
     String line = "";
     String cvsSplitBy=",";
    
     ArrayList<String> ar = new ArrayList<String>();
     driver.findElement(By.xpath("//input[@name='sleUsername']")).clear();
     driver.findElement(By.xpath("//input[@name='sleUsername']")).sendKeys("ashwinkumar");
     driver.findElement(By.xpath("//input[@name='slePassword']")).clear();
     driver.findElement(By.xpath("//input[@name='slePassword']")).sendKeys("ashwin@123");
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
         for(int k=minValue;k<=maxValue;k++)
         {
        	 driver.findElement(By.id("DocIDs")).clear();
         for(int j=minValue;j<=maxValue;j++) 
         {
         driver.findElement(By.id("DocIDs")).sendKeys(ar.get(j)+",");
         
         }
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         Thread.sleep(1500);
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@onclick='generateCSV()']")));
//    	 driver.findElement(By.xpath("//button[@onclick='generateCSV()']")).click();
    	 System.out.println(ar.get(maxValue-1));
    	// Assert.assertTrue(assertVerifySuccess(ar.get(maxValue-1)),"products were not generated successfully");
    	 Thread.sleep(40000);
    	 minValue=minValue+1001;
    	 maxValue=maxValue+1001;
         }

     } catch (IOException e) {
         e.printStackTrace();
     }

 }
	private boolean assertVerifySuccess(final String lastRecord) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(300, TimeUnit.SECONDS)
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
					return true;
				}
		
	}

}
