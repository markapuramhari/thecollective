package org.thecollective.pageobjects.brands;

import java.io.FileReader;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bsh.Parser;

public class BDirectoryMasterCall extends PageFactoryInitializer{
	
	public void bDirectoryMasterSetup()
	
	{
		 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1)); //switches to new tab
		    driver.get("http://bflytebo.trendin.com/");
		
		System.out.println("possible");
		driver.close();
	}
	@Test
	public void bDirectory()
	
	{
		String parentWindowHandler = driver.getWindowHandle();
		System.out.println("calling method");
		
		bDirectoryMasterSetup();
		
		driver.switchTo().window(parentWindowHandler);
		
		
		
		homePage().clickLogo();
		System.out.println("success");
	}

}
