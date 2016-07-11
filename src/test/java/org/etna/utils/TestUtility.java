package org.etna.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestUtility extends MainController {

	static WebDriverWait wait = new WebDriverWait(driver, 10);
	public static HashMap<String,Integer> headerindex=new HashMap<String, Integer>();
	
	public static void openPageInNewTab() throws AWTException {
		Robot r = new Robot();                          
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	}

	public static void fileUpload(String fileLocation) throws AWTException {
		
		 StringSelection stringSelection = new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   Robot robot;
		   
		   robot = new Robot();
		   robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_C);
           robot.keyRelease(KeyEvent.VK_C);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_V);
           robot.keyRelease(KeyEvent.VK_CONTROL);
           robot.keyRelease(KeyEvent.VK_V);
           robot.keyPress(KeyEvent.VK_ENTER);
           robot.keyRelease(KeyEvent.VK_ENTER);
           
		}
	

	public static void closeCurrentTab() {
		driver.close();
		
	}

	public static void closeAllTabsExceptFirst() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=1;i<tabs.size();i++)
		{	
	    driver.switchTo().window(tabs.get(i));
	    driver.close();
		}
		driver.switchTo().window(tabs.get(0));
	}

	public static void switchToDialogBox(){
		
	    driver.switchTo().window(driver.getWindowHandle());
	    
	}


	public static void printAllTheWindows() {
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		for(String window : al)
		{
			System.out.println(window);
		}
		
	}

	public static void hitEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public static void alertAccept() {
		Waiting.explicitWaitForAlert(5);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void selectByVisibleText(WebElement element, String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElement element, int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void mouseHoverActions(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void clickAndHoldActions(WebElement element)
	{
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
	}
	
	public static String getAlertText()
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText().trim();
		return alertText;
	}

	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		Waiting.explicitWaitForAlert(5);
		alert.dismiss();
		
	}

	public static void verifyToolTip(WebElement element, String expectedToolTip) {
		Assert.assertEquals(element.getAttribute("title").trim(),"Print this page");
		
	}
	
	public static void maximizeScreen(WebDriver driver) {
 	    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 	    Point position = new Point(0, 0);
 	    driver.manage().window().setPosition(position);
 	    Dimension maximizedScreenSize =
 	        new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
 	    driver.manage().window().setSize(maximizedScreenSize);
 	  }
	

	 public  static HashMap<String,Integer> headers(By table, By header){
	        wait.until(ExpectedConditions.presenceOfElementLocated(table));
	        WebElement tablename = driver.findElement(table);
	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(header));
	        List<WebElement> colummheader = tablename.findElements(header);
	        for (int i = 0; i < colummheader.size(); i++) {
	            if(i==0){
	                continue;
	            }
	            headerindex.put(colummheader.get(i).getText(),i);
	        }
	        return headerindex;
	    }
	 
	 // Method to enter the data on the respective row and column based on column name
	    public static void enterDataInHandsOnTable(int rownumber,String colName,String dataToEnter) throws Exception{
	    	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	    	Actions action = new Actions(driver);
	    	
	    	String colrow="//tr["+rownumber+"]/td["+headerindex.get(colName)+"]";
	       if(setUp.getBrowser().equalsIgnoreCase("chrome"))
	       {
	        action.click(driver.findElement(By.xpath(colrow))).sendKeys(dataToEnter).build().perform();
	       }
	       else 
	       {
	    	 driver.findElement(By.xpath(colrow)).click();
	    	 driver.findElement(By.xpath(colrow)).sendKeys(dataToEnter);
	       }
	    }
}
