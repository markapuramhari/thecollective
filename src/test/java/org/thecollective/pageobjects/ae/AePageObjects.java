package org.thecollective.pageobjects.ae;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.modules.ExcelFileReadAndWrite;
import org.thecollective.utils.Waiting;

public class AePageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//div[@class='modal-content']//button[contains(@class,'btn btn-primary btn-block cookie')]")
	private WebElement coockePopUp;
	
	@FindBy(xpath="(//input[@name='search-input'])[1]")
	private WebElement searchInputField;
	
	
	@FindBy(xpath="//div[@class='products__list']//img[1]")
	private WebElement listedProducts;
	
	@FindAll(value={@FindBy(xpath="//h4[text()='The Details']/following-sibling::div")
	})
	private List<WebElement> theDatailsData;
	//,@FindBy(xpath="//h4[text()='The Details']/following-sibling::div/ul/li")
	
	@FindBy(xpath="//p/span[@id='searchprodcnt']")
	private WebElement searchResultsCount;
	
	public boolean acceptCoockies(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try{
			
			if(coockePopUp.isDisplayed())
			{
				coockePopUp.click();
/*			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", coockePopUp);*/
			Thread.sleep(500);
			return true;
			
		}
		}catch(Exception e)
		{
			return true;
		}
		return true;
		
	}
	public AePageObjects enterSearchData(String searchData) throws AWTException, InterruptedException{
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//Waiting.explicitWaitVisibilityOfElement(searchInputField, 15);
		searchInputField.click();
		searchInputField.clear();
		searchInputField.sendKeys(searchData);
		searchInputField.sendKeys(Keys.ENTER);
		/* // Create object of Robot class
		  Robot r=new Robot();
		 
		   // Press Enter
		   r.keyPress(KeyEvent.VK_ENTER);
		 
		   // Release Enter
		   r.keyRelease(KeyEvent.VK_ENTER);*/
		Thread.sleep(1000);
		return this;
	}
	public AePageObjects clickOnProduct(String id) throws InterruptedException, EncryptedDocumentException, InvalidFormatException {
		try{
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Waiting.explicitWaitVisibilityOfElement(listedProducts, 10);
		listedProducts.click();
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Assert.assertTrue(assertVerifyZeroResults(id),"products are available for "+id+"");
		}
		return this;
	}
	private boolean assertVerifyZeroResults(String id) throws EncryptedDocumentException, InvalidFormatException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(searchResultsCount.getText().equals("0"))
		{

			ExcelFileReadAndWrite write =new ExcelFileReadAndWrite();
			write.writeData(id,"No Results found","No Results found","No Results found","No Results found","No Results found","No Results found");
			return false;
		}else
		{
			return true;	
		}
		
	}
	public String getTheDetails() {
		//List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@role='presentation']/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')]"));
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		// System.out.println(listString);
		return listString;
	}
	public String getMaterialsAndCare() {
		List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@class='product__desc--block']/h4[text()='Materials & Care']/following-sibling::ul/li"));
		//div[@role='presentation']/h2/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')] 
		List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		// System.out.println(listString);
		return listString;
	}
	public String getSizeAndFit() {
		List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@class='product__desc--block']/h4[text()='Size & Fit']/following-sibling::ul/li"));
		//div[@class='pdp-about-fit pdp-about-section']/h2/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')] 
		List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		// System.out.println(listString);
		return listString;
	}
	public String getColor() {
		String color=driver.findElement(By.xpath("//span[@itemprop='color']")).getText().trim();
		//System.out.println(color);
		return color;
	}
	public String getProductName() {
		String productName=driver.findElement(By.xpath("//div[@id='pdp-sticky-menu']//h1")).getText();
		//System.out.println(productName);
		return productName;
	}
}
