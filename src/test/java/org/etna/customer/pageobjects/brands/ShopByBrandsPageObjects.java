package org.etna.customer.pageobjects.brands;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ShopByBrandsPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//h2[contains(text(),'Shop By Brands')]")
	private WebElement shopByBrandsHeading;
	
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'cimm_brandAtoZletters')]/descendant::li/a")})
	private List<WebElement> listOfAlphabets;
	
	@FindAll(value={@FindBy(xpath="//div[@id='displayBrand']/descendant::li/a")})
	private List<WebElement> listOfBrandsUnderEveryAlphabet;
	
	@FindAll(value={@FindBy(xpath="(//h4[contains(text(),'Brands')]/following-sibling::span/ancestor::dt/following-sibling::dd)[1]/descendant::li/a")})
	public List<WebElement> allBrandsUnderBrandsDropdown;
	
	
	@Step("verify shop by brands page name")
	public ShopByBrandsPageObjects verifyShopByBrandsPageName(){
		Waiting.explicitWaitVisibilityOfElement(shopByBrandsHeading, 10);
		Assert.assertTrue(shopByBrandsHeading.isDisplayed(),"shop by brands heading is not displayed.");
		return this;
	}
	
	@Step("verify shop by brand breadcrump")
	public ShopByBrandsPageObjects verifyShopByBreadcrump(String shopByBrandBreadcrump) throws  Exception{
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			Thread.sleep(3500);
		}
		else
		{
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		}
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equals(shopByBrandBreadcrump),"Breadcrump is not Shop By Brands. It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		return this;
	}
	
	@Step("verify page title of shop by brand to have {0}")
	public ShopByBrandsPageObjects verifyTitleOfShopByBrand(String shopByBrandBreadcrump) throws Exception{
		Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase(shopByBrandBreadcrump.replace("Shop By ","")+" | "+setUp.getProductName().trim()),"Title is "+driver.getTitle().trim()+" Asserting with data "+shopByBrandBreadcrump.replace("Shop By ","")+" | "+setUp.getProductName().trim());
		return this;
	}

	@Step("click on every alphabet and verify the first letter of all the options displayed.")
	public ShopByBrandsPageObjects clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands() throws Exception {
	try
	{
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
			for(int j=0;j<listOfBrandsUnderEveryAlphabet.size();j++)
			{
					Waiting.explicitWaitVisibilityOfElements(listOfBrandsUnderEveryAlphabet, 20);		
					Assert.assertTrue(listOfBrandsUnderEveryAlphabet.get(j).getText().trim()
					.startsWith(listOfAlphabets.get(i).getText().trim()),
					"Brand does not start with aphabet chosen. Brand name is - "+listOfBrandsUnderEveryAlphabet.get(j).getText().trim()+
					" and alphabet chosen is "+listOfAlphabets.get(i).getText().trim()+".");
			}
		}
	}
	}
	catch(StaleElementReferenceException e)
	{
		driver.navigate().refresh();
		clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();
	}
	return this;	
	}

	@Step("click on brands toggle button")
	public ShopByBrandsPageObjects clickOnBrandsToggleButton() {
		productListPage().filterBrandsDropdownToggleButtonLocator.click();
		return this;
	}

	@Step("click on {0} st/nd/rd brand")
	public ShopByBrandsPageObjects clickOnSpecificBrand(int specificBrand) throws Exception {
		Thread.sleep(2000);
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			allBrandsUnderBrandsDropdown.get(specificBrand-1).click();
		}
		else
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",allBrandsUnderBrandsDropdown.get(specificBrand-1));
		}
		return this;
	}

	public String getNameOfTheSpecificBrand(int specificBrand) {
		String nameOfTheBrandString = allBrandsUnderBrandsDropdown.get(specificBrand-1).getAttribute("href");
		String nameOfTheBrandSubString =nameOfTheBrandString.substring(nameOfTheBrandString.lastIndexOf("/")+1);
		return nameOfTheBrandSubString;
	}

	@Step("verify whether breadcrumb contains {0}")
	public ShopByBrandsPageObjects verifyBrandBreadCrump(String nameOfTheBrand) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.contains(nameOfTheBrand),"Breadcrump does not contain the brand that is clicked. It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		return this;
	}

	@Step("verify whether title contains {0}")
	public ShopByBrandsPageObjects verifyTitleOfTheBrand(String nameOfTheBrand) throws Exception{
		Thread.sleep(2500);;
		Assert.assertTrue(driver.getTitle().trim().contains(nameOfTheBrand),"The title does not contain the brand that was clicked. The title is "+driver.getTitle().trim()+"."+"Asserting with data : "+nameOfTheBrand + " | "+setUp.getProductName()+".");
		Assert.assertTrue(driver.getTitle().trim().contains(" | "+setUp.getProductName()),"The title does not contain the product name.");
		Assert.assertFalse(driver.getTitle().trim().startsWith("|"),"The title does start with | .");
		return this;
		
	}

	public String getNameOfTheSpecificBrand(String specificBrandname) {
		String nameOfTheBrandString = driver.findElement(By.xpath("//dt[contains(text(),'Brands')]/following-sibling::dd/descendant::a[contains(@href,'"+specificBrandname+"')]")).getAttribute("href");
		String nameOfTheBrandsubString =nameOfTheBrandString.substring(nameOfTheBrandString.lastIndexOf("/")+1);
		return nameOfTheBrandsubString;
	}

	@Step("click on {0} st/nd/rd brand")
	public ShopByBrandsPageObjects clickOnSpecificBrand(String specificBrandname) throws Exception{
		Thread.sleep(2000);
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			driver.findElement(By.xpath("//dt[contains(text(),'Brands')]/following-sibling::dd/descendant::a[contains(@href,'"+specificBrandname+"')]")).click();		
		}
		else
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//dt[contains(text(),'Brands')]/following-sibling::dd/descendant::a[contains(@href,'"+specificBrandname+"')]")));
		}
		return this;
	}

}