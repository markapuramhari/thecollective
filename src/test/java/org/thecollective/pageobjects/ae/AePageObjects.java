package org.thecollective.pageobjects.ae;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

public class AePageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//div[@class='modal-content']//button[contains(@class,'btn btn-primary btn-block cookie')]")
	private WebElement coockePopUp;
	
	@FindBy(xpath="(//input[@name='search-input'])[1]")
	private WebElement searchInputField;
	
	
	@FindBy(xpath="//div[contains(@class,'product-images ')]")
	private WebElement listedProducts;
	
	@FindAll(value={@FindBy(xpath="//div[@role='presentation']/following-sibling::div[@class='pdp-about-details-txt pdp-about-details-equit']")
	,@FindBy(xpath="//div[@role='presentation']/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')]")})
	private List<WebElement> theDatailsData;
	
	public boolean acceptCoockies(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			
			if(coockePopUp.isDisplayed()){
				coockePopUp.click();
/*			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", coockePopUp);*/
			Thread.sleep(1000);
			return true;
			
		}
		}catch(Exception e)
		{
			return true;
		}
		return false;
		
	}
	public AePageObjects enterSearchData(String searchData) throws AWTException, InterruptedException{
		
		driver.navigate().refresh();
		Thread.sleep(2500);
		Waiting.explicitWaitVisibilityOfElement(searchInputField, 15);
		searchInputField.clear();
		searchInputField.sendKeys(searchData);
		searchInputField.sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		return this;
	}
	public AePageObjects clickOnProduct() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(listedProducts, 20);
		listedProducts.click();
		Thread.sleep(1200);
		return this;
	}
	public String getTheDetails() {
		//List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@role='presentation']/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')]"));
		 List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		 System.out.println(listString);
		return listString;
	}
	public String getMaterialsAndCare() {
		List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@role='presentation']/h2/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')]"));
		 List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		 System.out.println(listString);
		return listString;
	}
	public String getSizeAndFit() {
		List<WebElement> theDatailsData=driver.findElements(By.xpath("//div[@class='pdp-about-fit pdp-about-section']/h2/following-sibling::ul/li[contains(@class,'pdp-about-list-item pdp-about-bullet')]"));
		 List<String> all_elements_text=new ArrayList<>();
		 for(int i=0; i<theDatailsData.size(); i++)
		 {
			 all_elements_text.add(theDatailsData.get(i).getAttribute("innerText").toString()+"\n");
		 }
		 String listString = String.join("", all_elements_text);
		 System.out.println(listString);
		return listString;
	}
}
