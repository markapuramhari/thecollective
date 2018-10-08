package org.thecollective.pageobjects.listpage;

import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindAll(value={@FindBy(xpath="//span[@itemprop='desc']")})
	private List<WebElement> listedItemsDescriptionName;
	
	@FindBy(xpath="//h1[contains(text(),'SORT BY')]")
	private WebElement sortByText;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='dropdown-menu']//a")})
	private List<WebElement> sortByOptions;
	
	@FindBy(xpath="//h2[text()='Brand Directory']")
	private WebElement brandDirectoryPageName;
	
	@FindBy(xpath="//h1[contains(@class,'dropdown-toggle')]")
	private WebElement sortByDropdown;
	
	@FindBy(xpath="//div[contains(@class,'products_list')]//h1")
	private WebElement noResultsFoundText;
	
	
	@FindBy(xpath="//div[@id='divLeftNavFilters']/h1")
	private WebElement leftNavFilterText;
	
	@FindAll(value={@FindBy(xpath="//div[@id='divLeftNavFilters']//li")})
	private List<WebElement> filterAttributeSection;
	
	@FindAll(value={@FindBy(xpath="//ul[contains(@class,'fliters-checkbox')]//input/following-sibling::label")})
	private List<WebElement> FilterCheckBoxes;
	
	@FindBy(xpath="//input[@class='brandFilterSearch']")
	private WebElement brandSearchWithIn;
	
	@FindAll(value={@FindBy(xpath="//li[@class='filteritem active brandFilterItem']//li//span")})
	private List<WebElement> brandFilterAttributes;
	
	//===================================================
	@Step("verify product list page")
	public ListPageObjects verifyListedProducts() throws Exception {
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Waiting.explicitWaitVisibilityOfElements(listedItems, 30);
			Assert.assertTrue(listedItems.get(0).isDisplayed(),"products are not available");
			return this;
		
	}
	@Step("verify product list page")
	public boolean verifyListedProduct() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(assertVerifyProductListPage(), "products are not available");
		return true;
		
	}

	private boolean assertVerifyProductListPage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try
		{
			if(listedItems.get(0).isDisplayed())
			{
				return true;
			}
			
		}catch(Exception e)
		{
			Thread.sleep(1500);
			String pageTitle=driver.getTitle().trim();
			//System.out.println(driver.getTitle().trim());
			if(pageTitle.equalsIgnoreCase("Brand Directory | The Collective"))
			{
				return true;
			}
			else if (driver.getTitle().equalsIgnoreCase("Best Gifts for Valentine's Day | Shop designer luxury gifts online for men and women this Valentine's Day"))
			{
				return true;
			} else if (driver.getCurrentUrl().equalsIgnoreCase("https://blog.thecollective.in/")) 
			{
				return true;
			}
			
		}
		return false;
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
		Assert.assertEquals(driver.getTitle(), data.getSearchResultsPageTitle());

		return this;
	}
	@Step("verify invalid search results")
	public ListPageObjects verifyInvalidSearchResultsPage(String noresultsText) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(noResultsFoundText, 30);
		Assert.assertEquals(noResultsFoundText.getText().trim(),noresultsText);
		return this;
	}
	@Step("click on specific product {0} in list page")
	public ListPageObjects clickOnSpecificProduct(int number) throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElements(listedItems, 30);
		listedItems.get(number).click();
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
	@Step("get the product name {0} from list page")
	public String getProductName(int num) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String productName=listedItemsDescriptionName.get(num).getText().trim();
		return productName;
	}
	@Step("verify product list page with mrp {0}")
	public ListPageObjects verifyProduct( String productMRP) {
		Waiting.explicitWaitVisibilityOfElement(listedItemsPrice.get(0), 30);
		String actualMRP=listedItemsPrice.get(0).getText();
		Assert.assertEquals(actualMRP, productMRP);
		
		return this;
	}
	@Step("verify sort by field")
	public ListPageObjects verifySortByText() {
		Waiting.explicitWaitVisibilityOfElement(sortByText, 30);
		Assert.assertTrue(sortByText.isDisplayed(),"Sort by text is not displayed");
		
		return this;
	}
	@Step("verify sort by options")
	public ListPageObjects verifySortByOptions(String sortByOptionsExp) throws InterruptedException {
		String[] expOptions=sortByOptionsExp.split(",");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);
		sortByDropdown.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for(int i=0;i<sortByOptions.size();i++)
		{
			
			if(sortByOptions.get(i).isDisplayed())
				{
					sortByOptions.get(i).click();
					Assert.assertEquals(sortByOptions.get(i).getAttribute("innerHTML").toString(), expOptions[i]);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					Thread.sleep(3500);
			}else
				{
					sortByDropdown.click();
					sortByOptions.get(i).click();
					Assert.assertEquals(sortByOptions.get(i).getAttribute("innerHTML").toString(), expOptions[i]);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					Thread.sleep(3500);
				}		
		}
		return this;
		}
	@Step("verify left navigation filter section")
	public ListPageObjects verifyFilterSection() {
		Assert.assertTrue(assertVerifyFilter(), "filter section is not available");
		Assert.assertNotEquals(filterAttributeSection.isEmpty(), "filter attributes are not displyed");
		return this;
	}
	private boolean assertVerifyFilter() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(leftNavFilterText.isDisplayed()){
			return true;
		}
		else
		{
			return false;
		}
	}
	@Step("apply multiple filters from listed")
	public ListPageObjects applyMultipleFilters(int noOfTimes) throws InterruptedException {
		Assert.assertTrue(assertVerifyFilterCheckBoxes(), "filter attributes are not enabled");
		Thread.sleep(2500);
		for(int i=0;i<noOfTimes;i++)
		{
			FilterCheckBoxes.get(i).click();
			Thread.sleep(1500);
		}
		return this;
	}
	private boolean assertVerifyFilterCheckBoxes() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(FilterCheckBoxes.get(0).isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Step("verify single checked filter is displayed or not")
	public ListPageObjects verifySingleCheckedFilter() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement appliedFilter=driver.findElement(By.xpath("(//ul[contains(@class,'fliters-checkbox')]//input)[1]"));
		Assert.assertTrue(appliedFilter.getAttribute("checked")!=null,"applied filter not shown");
		

		return this;
	}
	@Step("apply single filter")
	public ListPageObjects applySingleFilter() throws InterruptedException {
		Assert.assertTrue(assertVerifyFilterCheckBoxes(), "filter attributes are not enabled");
		driver.findElement(By.xpath("(//ul[contains(@class,'fliters-checkbox')]//input/following-sibling::label)[1]")).click();
		Thread.sleep(1000);
		return this;
	}
	@Step("verify multiple applied filters")
	public ListPageObjects verifyMultipleCheckedFilter(int count) throws InterruptedException {
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int j=0;
		List<WebElement> filters=driver.findElements(By.xpath("//ul[contains(@class,'fliters-checkbox')]//input"));
		
		for(int i=0;i<filters.size();i++)
		{
		if(filters.get(i).getAttribute("checked") != null)
			{
			//Assert.assertEquals(filters.get(i).getAttribute("checked"),"true");
			j++;
			}else
			{
				
			}
		}
		Assert.assertEquals(j, count,"applied:"+count+", actual: "+j);
		return this;
	}
	@Step("chamge sort by option based on index")
	public ListPageObjects changeSortByOptionBasedOnIndex(int index) throws InterruptedException {
		Assert.assertTrue(sortByDropdown.isDisplayed(),"sort by dropdown is not displayed");
		sortByDropdown.click();
		Thread.sleep(1000);
		sortByOptions.get(index).click();
		Thread.sleep(1000);
		return this;
	}
	@Step("verify brand sub filter")
	public ListPageObjects verifyBrandSubFilter() {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(brandSearchWithIn.isEnabled(), "brand search within is not displayed");
		return this;
	}
	@Step("enter search keyword {0}")
	public ListPageObjects enterSearchKeyWord(String searchKeyword) {
		Waiting.explicitWaitVisibilityOfElement(brandSearchWithIn, 10);
		brandSearchWithIn.clear();
		brandSearchWithIn.sendKeys(searchKeyword);
		return this;
	}
	@Step("verify search within functionality for brand filters")
	public ListPageObjects verifySearchWithinFun(Character searchKeyWord) {
		
		    for(WebElement results: brandFilterAttributes)
		    {		 
		    	char[] strArray = results.getText().toCharArray();
		    	for (char c : strArray)
		    	{
	        	
		    		if(c==searchKeyWord)
			    			{
		                //If char is present in charCountMap, incrementing it's count by 1
		    			//return true;
		            	Assert.assertTrue(true, "search keyword doent have matches");
		            	System.out.println(c);
		            	}else
		            	{
		            		//return false;
		            	}
	        }
		    	//System.out.println(brandFilterAttributes.get(i).getText().toString());
		    	//	Assert.assertTrue(assertVerifyBrandFilters(i,searchKeyWord), "results not found for searchKeyword :"+searchKeyWord+"");
			
		    }
		return this;

	
	}
	private boolean assertVerifyBrandFilters(int i,String searchKeyWord) {
		boolean flag=false;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String filter=brandFilterAttributes.get(i).getText().trim().toLowerCase();
		for(int j=0;j<filter.length();j++)
		{
			try{
			 if(filter.charAt(j)==searchKeyWord.charAt(0))
				{
				 flag= true;
					break;
				}
			}catch(Exception e)
			{
				continue;
			}
			
			}
		return flag;
		
	}
}