package org.thecollective.pageobjects.listpage;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.pageobjects.homepage.StoresPageObjects;
import org.thecollective.utils.SearchDataPropertyFile;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class ListPageObjects extends PageFactoryInitializer{

	SearchDataPropertyFile data=new SearchDataPropertyFile();
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'category__breadcrumbs')]/a")})
	private  List<WebElement> breadCrumbs;
	
	@FindBy(xpath="//h1[contains(@class,'brand-title')]")
	private WebElement brandTitle;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'products_list_item')]")})
	private List<WebElement> listedItems;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'product-price')]/span")})
	private List<WebElement> listedItemsPrice;
	
	@FindBy(xpath="//div[@class='custom_pagination_inner']//a[@class='nextpageupdate']")
	private WebElement nextPaginationBottom;
	
	
	
	
	//===================================================
	@Step("verify product list page")
	public ListPageObjects verifyListedProducts() throws Exception {
			//throw new Exception("needs to write the code for verification of listed items");
	Assert.assertTrue(listedItems.get(0).isDisplayed(),"products are not available");
			return this;
		
	}
	@Step("verify product list page")
	public boolean verifyListedProduct() throws Exception {
	Waiting.explicitWaitVisibilityOfElements(listedItems, 30);
	Assert.assertTrue(listedItems.get(0).isDisplayed(),"products are not available");
			return true;
		
	}

	public ListPageObjects verifyBreadcrumbs(String brandName)
	{
		Assert.assertTrue(verifyBreadcrumb(brandName),"breadcrumbs were not same");
		Assert.assertEquals(driver.getTitle(),""+brandName+" | "+data.getProductName(),"page title is not correct");

		return this;
	}

	private boolean verifyBreadcrumb(String brandName) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(breadCrumbs.get(breadCrumbs.size()-1).getText().replace(">", "").trim().toLowerCase().contains(brandName))
		{
			return true;
		}
			else 
		{
			Assert.assertTrue(brandTitle.getText().toLowerCase().contains(brandName));
			return true;
		}
	}catch(Exception e)
		{
		return false;
	}
	}
	@Step("verify search results page")
	public ListPageObjects verifySearchResultsPage() {
		Waiting.explicitWaitVisibilityOfElements(listedItems, 15);
		Assert.assertTrue(listedItems.get(0).isDisplayed(), "search results not found");
		return this;
	}
	@Step("verify search results page title")
	public ListPageObjects verifyPageTitle() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), data.getSearchResultsPageTitle()+" | "+data.getProductName().trim());

		return this;
	}
	@Step("verify invalid search results")
	public ListPageObjects verifyInvalidSearchResultsPage() throws Exception {
		 throw new  Exception("needs to write code for invalid search results");
	}
	@Step("click on specific product {0} in list page")
	public ListPageObjects clickOnSpecificProduct() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElements(listedItems, 30);
		listedItems.get(0).click();
		Thread.sleep(3000);

		return this;
	}
	@Step("click on a product for cod order")
	public ListPageObjects clickOnProductForCod(String orderType,String maxPriceForCod) throws Exception {
		Assert.assertTrue(assertVerifyItemsAvailability(), "items are not displayed in product list page");
		for(int i=0;i<listedItems.size();i++)
		{
			Double expPrice=Double.parseDouble(maxPriceForCod);
			Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
		if(actPrice<expPrice)
		{
			listedItems.get(i).click();
			break;
		}else{
			if(nextPaginationBottom.isDisplayed())
			{
			nextPaginationBottom.click();
			Thread.sleep(4000);
			clickOnProductForCod(orderType, maxPriceForCod);
			}else
			{
				throw new Exception("Please select other category to place an order for COD option");
			}
		}
		}
			
			/*switch(orderType)
			{
			case "Cash on Delivery":
				for(int i=0;i<listedItems.size();i++)
				{
					Double expPrice=Double.parseDouble(maxPriceForCod);
					Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
				if(actPrice<expPrice)
				{
					listedItems.get(i).click();
					break;
				}else{
					if(nextPaginationBottom.isDisplayed())
					{
					nextPaginationBottom.click();
					Thread.sleep(4000);
					clickOnProductForCod(orderType, maxPriceForCod);
					}else
					{
						throw new Exception("Please select other category to place an order for COD option");
					}
				}
				}
				break;
			case "Credit Card":
				for(int i=0;i<listedItems.size();i++)
				{
					Double expPrice=Double.parseDouble(maxPriceForCod);
					Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
				if(actPrice>expPrice)
				{
					listedItems.get(i).click();
					break;
				}else{
					if(nextPaginationBottom.isDisplayed())
					{
					nextPaginationBottom.click();
					Thread.sleep(4000);
					clickOnProductForCod(orderType, maxPriceForCod);
					}else {
						throw new Exception("Please select other category to place an order for COD option");
					}
				}
				}
				break;
			case "Debit Card":
				for(int i=0;i<listedItems.size();i++)
				{
					Double expPrice=Double.parseDouble(maxPriceForCod);
					Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
				if(actPrice>expPrice)
				{
					listedItems.get(i).click();
					break;
				}else{
					if(nextPaginationBottom.isDisplayed())
					{
					nextPaginationBottom.click();
					Thread.sleep(4000);
					clickOnProductForCod(orderType, maxPriceForCod);
					}else {
						throw new Exception("Please select other category to place an order for COD option");
					}
				}
				}
				break;
			case "Net Banking":
				for(int i=0;i<listedItems.size();i++)
				{
					Double expPrice=Double.parseDouble(maxPriceForCod);
					Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
				
				if(actPrice>expPrice)
				{
					listedItems.get(i).click();
					break;
				}else{
					if(nextPaginationBottom.isDisplayed())
					{
					nextPaginationBottom.click();
					Thread.sleep(4000);
					clickOnProductForCod(orderType, maxPriceForCod);
					}else {
						throw new Exception("Please select other category to place an order for COD option");
					}
				}
				}
				break;
			case "Wallet":
				for(int i=0;i<listedItems.size();i++)
				{
					Double expPrice=Double.parseDouble(maxPriceForCod);
					Double actPrice=Double.parseDouble(listedItemsPrice.get(i).getText().replace(",","").trim());
				if(actPrice>expPrice)
				{
					listedItems.get(i).click();
					break;
				}else{
					if(nextPaginationBottom.isDisplayed())
					{
					nextPaginationBottom.click();
					Thread.sleep(4000);
					clickOnProductForCod(orderType, maxPriceForCod);
					}else {
						throw new Exception("Please select other category to place an order for COD option");
					}
				}
				
			}
			
				break;
			
		}
*/
		return this;
	}

	private boolean assertVerifyItemsAvailability() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(listedItems.get(0).isDisplayed()){
				return true;
			}
			
		}catch(Exception e)
		{
			return false;
		}
		return false;
	}
	
	

}
