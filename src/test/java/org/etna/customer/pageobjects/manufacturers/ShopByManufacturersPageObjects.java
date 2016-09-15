package org.etna.customer.pageobjects.manufacturers;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ShopByManufacturersPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//h2[contains(text(),'Shop By Manufacturers')]")
	private WebElement shopByManufacturersName;
	
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'cimm_brandAtoZletters')]/descendant::li/a")})
	private List<WebElement> listOfAlphabets;
	
	@FindAll(value={@FindBy(xpath="//div[@id='displayBrand']/descendant::li/a")})
	private List<WebElement> listOfManufacturersUnderEveryAlphabet;
	
	@FindAll(value={@FindBy(xpath="(//h4[contains(text(),'Manufacturers')]/following-sibling::span/ancestor::dt/following-sibling::dd)[1]/descendant::li/a")})
	public List<WebElement> allManufacturersUnderManufacturersDropdown;
	
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]/following-sibling::span")
	private WebElement filterManufacturersDropdownToggleButtonLocator;
	
	
	@Step("verify shop by manufacturers page name")
	public ShopByManufacturersPageObjects verifyShopByManufacturersPageName(){
		Waiting.explicitWaitVisibilityOfElement(shopByManufacturersName, 10);
		Assert.assertTrue(shopByManufacturersName.isDisplayed(),"shop by manufacturers heading is not displayed.");
		return this;
	}
	
	@Step("verify shop by manufacturers breadcrumb contains {0}")
	public ShopByManufacturersPageObjects verifyShopByBreadcrump(String shopByManufacturerBreadcrump){
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equals(shopByManufacturerBreadcrump),"Breadcrump is not "+shopByManufacturerBreadcrump+". It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim()+".");
		return this;
	}
	
	@Step("verify title of shop by manufacturers contains {0}")
	public ShopByManufacturersPageObjects verifyTitleOfShopByManufacturers(String shopByManufacturersBreadcrump) throws Exception{
		
		Assert.assertTrue(driver.getTitle().trim().equals(shopByManufacturersBreadcrump.replace("Shop By ","")+" | "+setUp.getProductName().trim()),"Title is "+driver.getTitle().trim()+" Asserting with data : "+shopByManufacturersBreadcrump.replace("Shop By ","")+" | "+setUp.getProductName().trim());
		
		return this;
	}
	
	@Step("click on every alphabet and check the first letter of the options")
	public ShopByManufacturersPageObjects clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers() throws Exception {
		Waiting.explicitWaitVisibilityOfElements(listOfAlphabets, 10);
	for(int i=0;i<listOfAlphabets.size();i++)
	{
		
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			listOfAlphabets.get(i).click();
		}
		else
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",listOfAlphabets.get(i));
		}
		
		Thread.sleep(4000);
		{
			for(int j=0;j<listOfManufacturersUnderEveryAlphabet.size();j++)
			{
					Waiting.explicitWaitVisibilityOfElements(listOfManufacturersUnderEveryAlphabet, 20);
					Thread.sleep(2000);
					Assert.assertTrue(listOfManufacturersUnderEveryAlphabet.get(j).getText().trim()
					.startsWith(listOfAlphabets.get(i).getText().trim()),
					"Manufacturer does not start with aphabet chosen. Manufacturer name is - "+listOfManufacturersUnderEveryAlphabet.get(j).getText().trim()+
					" and alphabet chosen is "+listOfAlphabets.get(i).getText().trim()+".");
			}
		}
	}
	return this;	
	}

	@Step("click on manufacturers toggle button")
	public ShopByManufacturersPageObjects clickOnManufacturersToggleButton() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			Waiting.explicitWaitVisibilityOfElement(filterManufacturersDropdownToggleButtonLocator, 15);
		}
		filterManufacturersDropdownToggleButtonLocator.click();
		return this;
	}
	

	@Step("click on manufacturer with name {0} ")
	public ShopByManufacturersPageObjects clickOnSpecificManufacturer(String specificManufacturer) throws Exception {
		Thread.sleep(2000);
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			driver.findElement(By.xpath("(//h4[contains(text(),'Manufacturers')]/following-sibling::span/ancestor::dt/following-sibling::dd)[1]/descendant::li/a[contains(@href,'"+specificManufacturer+"')]")).click();	
		}
		else
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("(//h4[contains(text(),'Manufacturers')]/following-sibling::span/ancestor::dt/following-sibling::dd)[1]/descendant::li/a[contains(@href,'"+specificManufacturer+"')]")));
		} 
		return this;
	}
	
	
	@Step("click on {0} st/nd/3rd manufacturer")
	public ShopByManufacturersPageObjects clickOnSpecificManufacturer(int specificManufacturer) throws Exception {
		Thread.sleep(2000);
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			allManufacturersUnderManufacturersDropdown.get(specificManufacturer-1).click();	
		}
		else
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",allManufacturersUnderManufacturersDropdown.get(specificManufacturer-1));
		}
		return this;
	}

	
	public String getNameOfTheSpecificManufacturer(int specificManufacturer) {
		String nameOfTheManufacturerString = allManufacturersUnderManufacturersDropdown.get(specificManufacturer-1).getAttribute("href");
		String nameOfTheManufacturersubString =nameOfTheManufacturerString.substring(nameOfTheManufacturerString.lastIndexOf("/")+1);
		return nameOfTheManufacturersubString;
	}
	
	public String getNameOfTheSpecificManufacturer(String specificManufacturer) {
		String nameOfTheManufacturerString = driver.findElement(By.xpath("(//h4[contains(text(),'Manufacturers')]/following-sibling::span/ancestor::dt/following-sibling::dd)[1]/descendant::li/a[contains(@href,'"+specificManufacturer+"')]")).getAttribute("href");
		String nameOfTheManufacturersubString =nameOfTheManufacturerString.substring(nameOfTheManufacturerString.lastIndexOf("/")+1);
		return nameOfTheManufacturersubString;
	}
	

	@Step("verify manufacturer breadcrumb contains {0}")
	public ShopByManufacturersPageObjects verifyManufacturerBreadCrump(String nameOfTheManufacturer) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.contains(nameOfTheManufacturer),"Breadcrump does not contain the manufacturer that is clicked. It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim()+".");
		return this;
	}

	@Step("verify manufacturer title contains {0}")	
	public ShopByManufacturersPageObjects verifyTitleOfTheManufacturer(String nameOfTheManufacturer) throws Exception{
		Thread.sleep(2500);
		Assert.assertTrue(driver.getTitle().trim().contains(nameOfTheManufacturer),"The title does not contain the manufacturer that was clicked. The title is "+driver.getTitle().trim()+"."+"Asserting with data : "+nameOfTheManufacturer + ".");
		Assert.assertTrue(driver.getTitle().trim().contains(" | "+setUp.getProductName()),"The title does not contain the product name.");
		Assert.assertFalse(driver.getTitle().trim().startsWith("|"),"The title does start with | .");
		return this;
		
	}
}