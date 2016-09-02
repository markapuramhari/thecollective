package org.etna.customer.pageobjects.productlist;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.etna.customer.pageobjects.productdetails.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */
public class ProductsListPageObjects extends PageFactoryInitializer{
 SearchDataPropertyFile data = new SearchDataPropertyFile();
 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
   Actions action = new Actions(driver);
	
	@FindBy(xpath="//p[@class='cimm_productDetailBrand']")
	private WebElement productDetailsBrandHeading;


	@FindAll(@FindBy(xpath="//ul[@class='listGridContainer']/li"))
	private List<WebElement> listOfProductsLocator;

	
	@FindBy(xpath="//div[contains(@class,'gridListControler')]/a")
	private WebElement changeViewButtonLocator;
	
	@FindBy(xpath="//div[@class='searchResults']/h2")
	private WebElement searchResultsHeaderLocator;
	
	@FindBy(xpath="//div[@class='searchResults']/p")
	private WebElement searchResultsSectionOnTopLocator;
	
	@FindBy(xpath="//a[contains(text(),'Advanced Search')]")
	private WebElement advancedSearchLinkLocator;
	
	@FindBy(xpath="//div[@class='cimm_leftMenuEnclosure']")
	public WebElement filterSectionLocator;
	
	@FindBy(xpath="//input[@id='keyWordTxt']")
	private WebElement filterSearchTextLocator;
	
	@FindBy(xpath="//button[@id='searchWithInBtn']")
	private WebElement filterSearchButtonLocator;
	
	@FindBy(xpath="//h3[contains(text(),'Refine Results')]")
	private WebElement filterRefineResultsHeadingLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Category')]/following-sibling::span")
	public WebElement filterCategoryDropdownToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Category')]")
	public WebElement filterCategoryHeadingLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Brands')]/following-sibling::span")
	public WebElement filterBrandsDropdownToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Brands')]")
	public WebElement filterBrandsHeadingLocator;
	
	@FindAll(value={@FindBy(xpath="//dl[@id='bulkAction']/dd/descendant::li/descendant::span")})
	private List<WebElement> addDropdownLocator;
	
	
	@FindAll(value={@FindBy(xpath="//ul[@class='chosen-results']/li")})
	private List<WebElement> sortByDropdownOptionsLocator;
	
	@FindAll(value={@FindBy(css="select[id='resultPerPage']>option")})
	private List<WebElement> resultsPerPageDropdownOptionsLocator;
	
	@FindBy(xpath="//div[@class='searchMatchPaginatnEncl']/descendant::a[@onclick='compareItems();']")
	private WebElement compareLinkLocator;
	
	@FindAll(value={@FindBy(xpath="//span[contains(text(),'My Product Groups')]")})
	private List<WebElement> myProductGroupsLocator;
	
	/*@FindAll(value={@FindBy(xpath="//a[contains(@id,'enableCart') and not(contains(@class,'disable'))]/ancestor::li/following-sibling::div[contains(@class,'selectCompareGroupBlock')]/descendant::span[text()='My Product Groups']")})
	private List<WebElement> myProductGroupsLocator;*/
	
	@FindBy(xpath="//form[@id='ItemsperPageForm']/descendant::select[@id='resultPerPage']")
	private WebElement resultsPerPageDrodownLocator;
	
	@FindBy(id="sortBy")
	private WebElement sortByDrodownLocator;
	
	
	
	@FindAll(value={@FindBy(xpath="//a[text()='Add To Cart']/ancestor::li/descendant::ul/descendant::h4/a")})
	private List<WebElement> items;
	
/*	@FindAll(value={@FindBy(xpath="//a[contains(@id,'enableCart') and not(contains(@class,'disable'))]/ancestor::ul/preceding-sibling::ul/descendant::a")})
	private List<WebElement> items;*/
	
	@FindAll(value={@FindBy(xpath="//a[contains(@id,'enableCart')]/ancestor::ul/preceding-sibling::ul/descendant::a")})
	private List<WebElement> skuItemsWithCallForPriceLocator;
	
	@FindBy(xpath="//p[@class='searchMatches']/b")
	private WebElement searchItem;
	
	@FindBy(xpath="//div[@id='sortBy_chosen']/a")
	private WebElement sortByDropdownLocator;
	
	@FindBy(id="resultPerPage")
	private WebElement showLocator;
	

	@FindBy(xpath="//div[@id='drpdwnDiv']/descendant::li/input")
	private WebElement myProductGroupTextbox;
	
	
	@FindBy(xpath="//div[@id='popSelector']/descendant::a")
	private WebElement productGroupCreationMsg;
	
	@FindAll(value={@FindBy(xpath="//div[@id='drpdwnDiv']/descendant::a")})
	private List<WebElement> myProductGroupOptionsLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='itemCountList']/button")})
	private List<WebElement> moreChoicesButtonLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='itemCountGrid']/a")})
	private List<WebElement> moreChoicesButtonInGridViewLocator;
	
	@FindAll(value={@FindBy(xpath="//td[@title='Compare']/descendant::input")})
	private List<WebElement> compareCheckboxesUnderMoreChoicesLocator;
	
	@FindAll(value={@FindBy(xpath="//td[contains(@class,'details-control')]/descendant::span[not(contains(@class,'imgForSend')) and not(contains(@id,'quantityBreakPricingDetails'))]")})
	private List<WebElement> itemIdsUnderMyChoicesLocator;
	
	@FindBy(xpath="//span[contains(@class,'compareControls')]/descendant::a[contains(@onclick,'clearCookie')]")
	private WebElement clearCompareButtonLocator;

	@FindAll(value={@FindBy(xpath="//a[@class='log-addTocart-btn addToCart']/ancestor::li/following-sibling::div/descendant::span[contains(text(),'ADD TO COMPARE')]")})
	private List<WebElement> addToCompareCheckboxesInSKUModeAndNoCallForPriceLocator;
	
	@FindAll(value={@FindBy(xpath="//span[text()='ADD TO COMPARE']")})
	private List<WebElement> addToCompareCheckboxesInSKUModeLocator;
	
	@FindAll(value={@FindBy(xpath="//a[@class='log-addTocart-btn btns-disable']/ancestor::li/following-sibling::li[contains(@class,'Compare')]/descendant::span[text()='ADD TO COMPARE']")})
	private List<WebElement> addToCompareCheckboxesInSKUModeCallForPriceLocator;
	
	@FindAll(value={@FindBy(xpath="//td[@class='tabelImage details-control']/img")})
	private List<WebElement> moreChoicesProductModeImagesLocator;
	
	@FindBy(xpath="//li[@id='mPartNo']/descendant::span")
	private WebElement mpnValueInProductModeLocator;
	
	@FindBy(xpath="//li[@id='sitePartNo']/b/following-sibling::span")
	private WebElement partNumberValueInProductModeLocator;
	
	@FindBy(xpath="//li[@id='upcNo']/b/following-sibling::span")
	private WebElement upcValueInProductModeLocator;
	
	@FindAll(value={@FindBy(xpath="//b[contains(text(),'UPC')]/following-sibling::span")})
	private List<WebElement> upcValueInSKUModeLocator;

	@FindAll(value={@FindBy(xpath="//span[contains(@id,'partNumber')]")})
	private List<WebElement> partNumberValueInSKUModeLocator;
	
	@FindAll(value={@FindBy(xpath="//td[@class='tabelImage details-control']/span[@class='partNum']")})
	private List<WebElement> partNumbersAboveLocators;
	
	@FindBy(xpath="//div[@id='resultPerPage_chosen']/a")
	private WebElement showResultsDropdownLocator;
	
	@FindAll(value={@FindBy(xpath="//b[contains(text(),'MPN')]/following-sibling::span")})
	private List<WebElement> mpnValueInSKUModeLocator;
	
	@FindAll(value = { @FindBy(xpath="//p[contains(@id,'ShortDesc')]") })
	private List<WebElement> shortDescriptionLocator;
	
	@FindBy(xpath="//select[contains(@id,'multipleUom')]")
	private WebElement multipleUOMDropdownsLocator;
	
	
	@FindAll(value={@FindBy(xpath="//select[contains(@id,'multipleUom')]/ancestor::ul/preceding-sibling::ul/descendant::h4/a")})
	private List<WebElement> itemsWithMultipleUOMsLocator;
	
	

	@FindBy(xpath="//li[@class='price']/span[@class='priceSpan']")
	private WebElement priceInSKUModeLocator;
	
	
	@FindBy(xpath="//select[@class='multipleUom']")
	private WebElement multipleUOMDropdownLocator;
	
	
	@FindBy(xpath="//select[contains(@id,'Uom')]/ancestor::li[contains(@class,'productQty')]/preceding-sibling::li[@class='price']/descendant::span")
	private WebElement priceInSKUModeWhoseProductHasMultipleUOMLocator;
	
	
	
	@Step("verify header contains {0}")
	public ProductsListPageObjects verifyHeader(String searchText) {
		String productsHeader = "//b[contains(text(),'"+searchText+"')]";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement productHeaderLocator = driver.findElement(By.xpath(productsHeader));
		Waiting.explicitWaitVisibilityOfElement(productHeaderLocator, 15);
		Assert.assertEquals(productHeaderLocator.getText().trim().toLowerCase(), searchText.toLowerCase(),"products page search header is not displayed");
		return this;
		
	}


	@Step("verify grid view")
	public ProductsListPageObjects verifyGridView() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
			Thread.sleep(3000);
		}
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).getAttribute("class").equals("gridView"),"class name is not grid view. Class name is "+listOfProductsLocator.get(i).getAttribute("class")+". This is for the "+i+" product.");
		
	}
		return this;
	}
	
	@Step("verify list view")
	public ProductsListPageObjects verifyListView() {
	
		Waiting.explicitWaitVisibilityOfElements(listOfProductsLocator, 10);
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).getAttribute("class").equals("listView"),"class name is not list view");
		}
		return this;
	}

	@Step("verify whether products are displayed in the product list page")
	public ProductsListPageObjects verifyListOfProducts() {
		Waiting.explicitWaitVisibilityOfElements(listOfProductsLocator, 15);
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).isDisplayed(), "products are not displayed"); 
		}
		return this;
	}
	
	@Step("click on change view")
	public ProductsListPageObjects clickOnChangeView() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(1500);
		changeViewButtonLocator.click();
		}
		else
		{
		Thread.sleep(1000);
		changeViewButtonLocator.click();
		}
		return this;
		
	}

	@Step("verify alert message is {0}")
	public ProductsListPageObjects verifyAlertMessageForComparingMoreThan3Items(String expectedAlertMessageForComaringMoreThan3Items) {
		Waiting.explicitWaitForAlert(15);
		Assert.assertEquals(TestUtility.getAlertText().trim(),expectedAlertMessageForComaringMoreThan3Items,"getting wrong alert message. "+TestUtility.getAlertText()+" . ");
		TestUtility.alertAccept();
		return this;
		
	}

	@Step("verify 'no item in compare list' text is displayed in the alert message")
	public ProductsListPageObjects verifyClearListFunctionalityWhenNoItemsAreThereForComparing() {
		
		Waiting.explicitWaitForAlert(5);
		Assert.assertEquals(TestUtility.getAlertText(), "No Item in Compare List.");
		TestUtility.alertAccept();
		return this;
		
	}

	@Step("select filter {0}")
	public ProductsListPageObjects selectSpecificFilter(int specificFilterNumber) {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		WebElement specificFilter = driver.findElement(By.xpath("(//dt[contains(.,'Brands')]/following-sibling::dd/descendant::ol/li)["+specificFilterNumber+"]/descendant::span[@class='customCheckBox']"));
		specificFilter.click();
		return this;
	}


	public String getFilterName(int specificFilterNumber) {
		String specficFilterName = "(//dt[contains(.,'Brands')]/following-sibling::dd/descendant::ol/li)[1]/descendant::span[@class='customCheckBox']";
		String nameOfTheFilter = driver.findElement(By.xpath(specficFilterName)).getText().trim();
		return nameOfTheFilter;
	}

	@Step("verify search header {0}")
	public ProductsListPageObjects verifySearchHeader(String searchText) {
		Waiting.explicitWaitVisibilityOfElement(searchResultsHeaderLocator, 6);
		Assert.assertEquals(searchResultsHeaderLocator.getText().toLowerCase().replace("search results for: ","").trim(),searchText.toLowerCase());
		return this;
	}

	@Step("verify search section")
	public ProductsListPageObjects verifySearchSection() {
		String actual = searchResultsSectionOnTopLocator.getText().replace("\n","").trim();
		Assert.assertTrue(assertSearchSection(actual));
		Assert.assertTrue(advancedSearchLinkLocator.isDisplayed(),"advanced search link is not displayed in the serach section.");
		return this;
	}
	
	
	public boolean assertSearchSection(String actual){
		String toGetInteger = actual.replace("We found", "").replace("\n", "").replace("results for work overallstNot finding what you want, try our Advanced Search.", "");
		boolean t = (actual.contains("We found")&& actual.contains("results for work overallsNot finding what you want, try our Advanced Search.") && toGetInteger.trim().matches("\\d+"));
		return t;
	}
	
	@Step("verify whether filter section is displayed.")
	public ProductsListPageObjects verifyFilterSection() {
		Assert.assertTrue(filterSectionLocator.isDisplayed(), "filter section is not displayed.");
	//	Assert.assertTrue(filterSearchTextLocator.isDisplayed(),"filter search textbox is not displayed.");
	//	Assert.assertTrue(filterSearchButtonLocator.isDisplayed(),"filter search button is not displayed.");
	//	Assert.assertTrue(filterRefineResultsHeadingLocator.isDisplayed(),"filter refine results heading is not displayed." );
	//	Assert.assertTrue(filterCategoryDropdownToggleButtonLocator.isDisplayed(),"Category Filter toggle button is not displayed.");
	//	Assert.assertTrue(filterCategoryHeadingLocator.isDisplayed(),"Category Filter heading is not displayed.");
	//	Assert.assertTrue(filterBrandsDropdownToggleButtonLocator.isDisplayed(),"filter brands dropdown is not displayed.");
		return this;
	}
	
	@Step("verify whether compare link locator is displayed.")
	public ProductsListPageObjects verifyCompareLinkLocator() {
		Assert.assertTrue(compareLinkLocator.isDisplayed());
		return this;
	}

	@Step("click on {0}st/2nd/rd My Product group button")
	public ProductsListPageObjects clickOnSpecificMyProductGroupButton(int specificProductGroup) throws Exception {
		Thread.sleep(1500);
		myProductGroupsLocator.get(specificProductGroup-1).click();
		return this;
	} 

	@Step("verify add dropdown")
	public ProductsListPageObjects verifyAddDropdown() throws Exception{
		for(int i=0 ;i<addDropdownLocator.size();i++)
		{
			System.out.println(addDropdownLocator.get(i).getText().trim());
		}
		return this;
	}
	
	@Step("verify display of sort by dropdown")
	public ProductsListPageObjects verifyDisplaySortByDropdown() throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertTrue(sortByDropdownLocator.isDisplayed());
		return this;
	}
	@Step("verify sort by dropdown is displayed.")
	public ProductsListPageObjects verifySortByDropdown(String [] expectedSortByOptions) throws Exception{
		Waiting.explicitWaitVisibilityOfElement(sortByDropdownLocator, 5);
		sortByDropdownLocator.click();
		Thread.sleep(1000);
		for(int i=0 ;i<sortByDropdownOptionsLocator.size();i++)
		{
		Assert.assertEquals(sortByDropdownOptionsLocator.get(i).getText().trim(),expectedSortByOptions[i]);
		}
		return this;
	}


	@Step("verify results per page drop down is displayed.")
	public ProductsListPageObjects verifyResultsPerPageDropdown() {
		String [] expectedResultsPerPageOptions = data.getExpectedResultsPerPageOptions().split(",");
		for(int i=0 ;i<resultsPerPageDropdownOptionsLocator.size();i++)
		{
		Assert.assertEquals(Integer.parseInt(resultsPerPageDropdownOptionsLocator.get(i).getAttribute("value").trim()),Integer.parseInt(expectedResultsPerPageOptions[i]));
		}
		return this;
	}

	@Step("verify number of items in the page is less that or equal to {0}")
	public ProductsListPageObjects verifyShowItemsPerPage(int showItemsPerPage) throws Exception {
		clickOnShowResultsDropdown();
		selectShowResults(showItemsPerPage);
		Thread.sleep(3000);
		Assert.assertTrue(verifyNoOfItemsDisplayedIsLessThanOrEqualToTheNumberOfItemsSelected(showItemsPerPage),"number of items in the page is NOT less than or equal ");
		return this;
		
	}


	private boolean verifyNoOfItemsDisplayedIsLessThanOrEqualToTheNumberOfItemsSelected(int showItemsPerPage) {
		if(listOfProductsLocator.size()<=showItemsPerPage)
		{
			return true;
		}
		else
		{
		return false;
	}
}
	@Step("click on {0} st/nd/rd item")
	public ProductsListPageObjects clickOnSpecificItem(int specificItemNumber) {
		items.get(specificItemNumber-1).click();
		return this;
	}

	@Step("verify breadcrumb to have {0}")
	public ProductsListPageObjects verifyBreadCrump(String lastBreadcrump) {
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim(), lastBreadcrump);
		return this;
	}

	@Step("verify title contains {0}")
	public ProductsListPageObjects verifyTitle(String lastBreadcrump) throws Exception {
	
		Assert.assertEquals(driver.getTitle().trim(),lastBreadcrump+" | "+setUp.getProductName().toUpperCase());
		return this;
	}

	@Step("verify search matches link {0}")
	public ProductsListPageObjects verifySearchMatchesLink(String getSpecificCategory3) {
		Assert.assertEquals(searchItem.getText().trim(),getSpecificCategory3);
		return this;
	}



	
	@Step("Click on {0}st/nd/rd item")
	public ProductsListPageObjects clickOnSpecificItem(String specificItem) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'"+specificItem+"')]"));
		return this;
	}

	
	@Step("Enter {0} in narrow filter textbox")
	public ProductsListPageObjects enterSearchTextInNarrowFilterTextbox(String searchTextForEnlargeImageTest) {
		filterSearchTextLocator.sendKeys(searchTextForEnlargeImageTest);
		return this;
	}

	@Step("Click on narrow search button")
	public ProductsDetailsPageObjects clickOnNarrowSearchButton() {
		filterSearchButtonLocator.click();
		return productDetailsPage();
	}


	@Step("enter group name {0}")
	public ProductsListPageObjects enterGroupName(String myProductGroupName) throws Exception{
		Waiting.explicitWaitVisibilityOfElement(myProductGroupTextbox, 6);
		myProductGroupTextbox.sendKeys(myProductGroupName);
		return this;
		
	}


	@Step("hit enter")
	public ProductsListPageObjects hitEnter() {
		myProductGroupTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	@Step("verify My Product Group creation success message contains {0}")
	public ProductsListPageObjects verifyMyProductCreationSuccessMsg(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElement(productGroupCreationMsg, 5);
		Assert.assertEquals(productGroupCreationMsg.getText().trim(), items.get(0).getText().trim()+" Added To Group - "+myProductGroupName);
		return this;
	}


	@Step("click on my product groups")
	public MyProductGroupsPageObjects clickOnMyProductGroups() throws Exception {
		homePage()
		.clickOnUserAccountDropdown()
		.navigateToMyProductGroups();
		return new MyProductGroupsPageObjects();
	}

	@Step("click on the success message")
	public MyProductGroupsPageObjects clickOnSuccessMessage() {
		productGroupCreationMsg.click();
		return myProductGroupsPage();
	}

	@Step("hover over a sku product")
	public ProductsListPageObjects hoverOverSpecificProduct(int specificAddToCart) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(items.get(specificAddToCart-1)).build().perform();
		Thread.sleep(1500);
		return this;
	}

	
	public boolean assertAlertMessage(String expectedAlertMessageForBlankData)
	{
	boolean t = TestUtility.getAlertText().trim().equals(expectedAlertMessageForBlankData);
	TestUtility.alertAccept();
	return t;
	}

	@Step("verify alert text is {0}")
	public ProductsListPageObjects verifyAlertMessage(String expectedAlertMessageForBlankData) throws Exception{
		Thread.sleep(3000);
		Waiting.explicitWaitForAlert(5);
		Assert.assertTrue(assertAlertMessage(expectedAlertMessageForBlankData));
		return this;
	}


	@Step("choose {0} group name from dropdown list")
	public ProductsListPageObjects chooseGroupNameFromTheDropdownList(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElements(myProductGroupOptionsLocator, 5);
		for(WebElement everyProductGroup : myProductGroupOptionsLocator)
		{
			if(everyProductGroup.getText().trim().equals(myProductGroupName))
			{
				everyProductGroup.click();
				break;
			}
		}
		return this;
	}


	@Step("click on compare link")
	public ProductsListPageObjects clickOnCompareLink() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareLinkLocator);
		
		return this;
	}

	
	@Step("click on {0} st/nd/rd More Choices link")
	public ProductsListPageObjects clickOnSpecificMoreChoices(int specificMoreChoices) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreChoicesButtonLocator.get(specificMoreChoices-1));
		return this;
	}


	@Step("click on {0} Compare checkboxes under More Choices ")
	public ProductsListPageObjects clickOnCompareCheckboxesUnderMoreChoices(int numberOfCheckboxesToBeClicked) throws Exception {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		for(int i = 0 ; i<=numberOfCheckboxesToBeClicked-1 ; i++)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",compareCheckboxesUnderMoreChoicesLocator.get(i));
		}
		
		return this;
	}


	public String[] getItemIds(int numberOfItems) {
		
		String itemIds [] = new String[numberOfItems];
		for(int i=0; i<=numberOfItems-1 ; i++)
		{
			 itemIds[i] = itemIdsUnderMyChoicesLocator.get(i).getText().trim();
	
	}		
	return itemIds;
	}

	@Step("verify compare text contains {0} items")
	public ProductsListPageObjects verifyCompareText(int expectedItemsInCompareLink) {
		Assert.assertEquals(Integer.parseInt(compareLinkLocator.getText().replace("Compare", "").replace("Item(s)", "").trim()), expectedItemsInCompareLink);
		return this;
	}

	@Step("click on clear compare button")
	public ProductsListPageObjects clickOnClearCompareButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",clearCompareButtonLocator);
		return this;
	}

	@Step("verify clear compare link contains {0}")
	public ProductsListPageObjects verifyClearFunctionality(int expectedItemsInCompareLink) {
		Assert.assertEquals(Integer.parseInt(compareLinkLocator.getText().replace("Compare", "").replace("Item(s)", "").trim()), expectedItemsInCompareLink);
		return this;
	}


	public String getItemId(int specificItemId) {
		
			 String partNumber = itemIdsUnderMyChoicesLocator.get(specificItemId-1).getText().trim();
			 return partNumber;
	}

	@Step("click on {0} st/nd/rd add to compare checkbox which is in SKU mode")
	public ProductsListPageObjects clickOnAddToCompareCheckboxWhichIsInSKUMode(int specificSKUModeCompareCheckbox) {
		addToCompareCheckboxesInSKUModeLocator.get(specificSKUModeCompareCheckbox-1).click();
		return this;
	}


	@Step("click on {0} st/nd/rd more choices in grid view")
	public ProductsDetailsPageObjects clickOnSpecificMoreChoicesInGridView(int specificMoreChoices) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreChoicesButtonInGridViewLocator.get(specificMoreChoices-1));
		return productDetailsPage() ;
	}

	@Step("click on {0} st/nd/rd page")
	public ProductsListPageObjects clickOnSpecificPage(int specficPage) {
			try
			{
			
				WebElement specificPageLocator = driver.findElement(By.xpath("//a[@title='Go to page "+specficPage+"']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",specificPageLocator);
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
		return this;
	}

	
	@Step("click on {0} st/nd/rd add to compare checkbox which is in SKU mode and also has call for price")
	public ProductsListPageObjects clickOnAddToCompareCheckboxWhichIsInSKUModeCallForPrice(int specificSKUModeCompareCheckbox) {
		addToCompareCheckboxesInSKUModeCallForPriceLocator.get(specificSKUModeCompareCheckbox-1).click();
		return this;
	}
	
	@Step("click on {0} compare checkboxes")
	public ProductsListPageObjects clickOnSpecificAddToCompareCheckboxInSKUMode(int specificCheckboxInSKUMode)
	{
		addToCompareCheckboxesInSKUModeLocator.get(specificCheckboxInSKUMode-1).click();
		return this;
	}



	
	
	public boolean assertForBrandNameOrMPNInProductListPage(String searchKeyword)
	{
		for(int i = 0 ; i < listOfProductsLocator.size() ; i++)
		{

			if(listOfProductsLocator.get(i).getText().toLowerCase().trim().contains(searchKeyword.toLowerCase().trim()))
			{
				return true;
			}
		
		}
		return false;
}



	public ProductsListPageObjects clickOnShowResultsDropdown() {
		showResultsDropdownLocator.click();
		return this;
	}


	public ProductsListPageObjects selectShowResults(int showItemsPerPage) throws Exception {
		String showItemsPerPageString = Integer.toString(showItemsPerPage);
		Thread.sleep(1500);
		switch(showItemsPerPageString)
		{
		
		case "12":
			
			driver.findElement(By.xpath("//ul/li[contains(text(),'12')]")).click();
			break;
		case "24":
			driver.findElement(By.xpath("//ul/li[contains(text(),'24')]")).click();
			break;
		case "48":	
			driver.findElement(By.xpath("//ul/li[contains(text(),'48')]")).click();
			break;
		case "60":	
			driver.findElement(By.xpath("//ul/li[contains(text(),'60')]")).click();
			break;
		default : throw new Exception("Invalid input");	
		}
		return this;
	}


	public ProductsListPageObjects clickOnSpecificMoreChoicesAndTheCompareCheckboxesWhereMoreChoicesIsGreaterThan3(int numberOfCheckboxesToBeClicked) throws Exception {
		for(int i = 0 ; i < moreChoicesButtonLocator.size() ; i++)
		{
			moreChoicesButtonLocator.get(i).click();
			Thread.sleep(1500);
			
			if(compareCheckboxesUnderMoreChoicesLocator.size() > 2)
			{
				clickOnCompareCheckboxesUnderMoreChoices(numberOfCheckboxesToBeClicked);
				break;
			}
		}
		return this;
	}


	public ProductsListPageObjects verifyBrandNameOrMPNInProductListPage(String brandNameOrMPN) {
		Assert.assertTrue(assertForBrandNameOrMPNInProductListPage(brandNameOrMPN),"Brand Name Or MPN is not displayed in the product list page.");
		return this;
	}

	public boolean assertPartNumberInSKUModeInProductListPage(String partNumber)
	{
		for(int i = 0 ; i<partNumberValueInSKUModeLocator.size() ; i++)
		{
			if(partNumberValueInSKUModeLocator.get(i).getText().trim().equalsIgnoreCase(partNumber))
			{
				return true;
			}
		}
		return false;
	}
	public ProductsListPageObjects verifyPartNumberInProductListPage(String partNumber) throws InterruptedException {
		try
		{
			if((assertPartNumberInSKUModeInProductListPage(partNumber)))
			{
				Assert.assertTrue(assertPartNumberInSKUModeInProductListPage(partNumber),"Part Number is not displayed in product list page.");
			}
			else
			{
			Assert.assertTrue(verifyPartNumberInProductMode(partNumber),"Part number is not displayed in product list page.");
			}
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(verifyPartNumberInProductMode(partNumber),"Part number is not displayed in product list page.");
		}
		return this;
	}


	private boolean verifyPartNumberInProductMode(String partNumber) throws InterruptedException {
		for(int i = 0 ; i < moreChoicesButtonLocator.size() ; i++)
		{
			moreChoicesButtonLocator.get(i).click();
			Thread.sleep(3000); 
			for(int j = 0 ; j <  partNumbersAboveLocators.size() ; j++)
			{
				if(partNumbersAboveLocators.get(j).getText().trim().equals(partNumber.trim()))
				{
				return true;
				}
				
			}
		}
		return false;
	}


	public ProductsListPageObjects verifyUPCInProductListPage(String upc) throws InterruptedException {
		
		try
		{
			if((assertUPCInSKUModeInProductListPage(upc)))
			{
				Assert.assertTrue(assertUPCInSKUModeInProductListPage(upc),"UPC Number is not displayed in product list page.");
			}
			Assert.assertTrue(verifyUPCInProductMode(upc),"UPC is not displayed in product list page.");
		}
		catch(NoSuchElementException e)
		{
			Assert.assertTrue(verifyUPCInProductMode(upc),"UPC is not displayed in product list page.");
		}
		return this;
	}


	private boolean verifyUPCInProductMode(String upc) throws InterruptedException {
		for(int i = 0 ; i < moreChoicesButtonLocator.size() ; i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreChoicesButtonLocator.get(i));
			Thread.sleep(3000); 
			for(int j = 0 ; j <  moreChoicesProductModeImagesLocator.size() ; j++)
			{
				
				moreChoicesProductModeImagesLocator.get(j).click();
				Thread.sleep(1500); 
				if(upcValueInProductModeLocator.getText().trim().equals(upc))
				{
					return true;
				}
					
			}
		}
		return false;
	}


	private boolean assertUPCInSKUModeInProductListPage(String upc) {
		for(int i = 0 ; i<upcValueInSKUModeLocator.size() ; i++)
		{
			if(upcValueInSKUModeLocator.get(i).getText().trim().equalsIgnoreCase(upc))
			{
				return true;
			}
		}

		return false;
	}


	public ProductsListPageObjects verifyBrandNameOrMPNIsNotDisplayedInProductListPage(String brandNameOrMPN) {
		Assert.assertFalse(assertForBrandNameOrMPNInProductListPage(brandNameOrMPN),"Searched MPN or Brand is displayed in product list page. It should not get displayed! ");
		return this;
	}


	public ProductsListPageObjects verifyPartNumberNotDisplayedInProductListPage(String partNumber) throws InterruptedException {
		try
		{
			if((assertPartNumberInSKUModeInProductListPage(partNumber)))
			{
				Assert.assertFalse(assertPartNumberInSKUModeInProductListPage(partNumber),"Part Number is  displayed in product list page.");
			}
			Assert.assertFalse(verifyPartNumberInProductMode(partNumber),"Part number is  displayed in product list page.");
		}
		catch(NoSuchElementException e)
		{
			Assert.assertFalse(verifyPartNumberInProductMode(partNumber),"Part number is  displayed in product list page.");
		}
		return this;
	}


	public ProductsListPageObjects verifyUPCNotDisplayedInProductListPage(String upc) throws InterruptedException {
		try
		{
			if((assertUPCInSKUModeInProductListPage(upc)))
			{
				Assert.assertFalse(false,"UPC Number is displayed in product list page.");
			}
			Assert.assertFalse(verifyUPCInProductMode(upc),"UPC is displayed in product list page.");
		}
		catch(NoSuchElementException e)
		{
			Assert.assertFalse(verifyUPCInProductMode(upc),"UPC is displayed in product list page.");
		}
		
		return this;
	}



	private boolean verifyMPNInProductMode(String mpn) throws InterruptedException {
		
		for(int i = 0 ; i < moreChoicesButtonLocator.size() ; i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreChoicesButtonLocator.get(i));
			Thread.sleep(3000); 
			for(int j = 0 ; j <  moreChoicesProductModeImagesLocator.size() ; j++)
			{
				
				moreChoicesProductModeImagesLocator.get(j).click();
				Thread.sleep(1500); 
				if(mpnValueInProductModeLocator.getText().trim().equals(mpn))
				{
					return true;
				}
					
			}
		}
		return false;
	}


	private boolean assertMPNInSKUModeInProductListPage(String mpn) {
		for(int i = 0 ; i<mpnValueInSKUModeLocator.size() ; i++)
		{
			if(mpnValueInSKUModeLocator.get(i).getText().trim().equalsIgnoreCase(mpn))
			{
				return true;
			}
		}

		return false;
	}
	
	
	public ProductsListPageObjects verifyMPNIsNotDisplayedInProductListPage(String mpn) throws InterruptedException {
		try
		{
			if((assertMPNInSKUModeInProductListPage(mpn)))
			{
				Assert.assertFalse(false,"MPN Number is displayed in product list page.");
			}
			Assert.assertFalse(verifyMPNInProductMode(mpn),"MPN is displayed in product list page.");
		}
		catch(NoSuchElementException e)
		{
			Assert.assertFalse(verifyMPNInProductMode(mpn),"MPN is displayed in product list page.");
		}
		
		return this;
		
	}


	public ProductsListPageObjects verifyPartialPartNumberSKUMode(String partNumber) {
		for(int i = 0 ; i < partNumberValueInSKUModeLocator.size() ; i++)
		{
			Assert.assertTrue(partNumberValueInSKUModeLocator.get(i).getText().trim().contains(partNumber),"Part Number does not contain "+partNumber+" .Part Number is "+partNumberValueInSKUModeLocator.get(i).getText().trim());
		}
		return this;
	}


	public ProductsListPageObjects verifyPartialShortDescription(String shortDescription) {
		for(int i = 0 ; i < shortDescriptionLocator.size() ; i++)
		{
		Assert.assertTrue(shortDescriptionLocator.get(i).getText().trim().contains(shortDescription),"Partial short description search is not working. Searched short description: "+shortDescription+" Short description from web application is "+shortDescriptionLocator.get(i).getText().trim());
		}
		return this;
	}


	public ProductsListPageObjects verifyUOMDropdown(String[] expectedOptionsFromUOMDropdown) {
		Waiting.explicitWaitVisibilityOfElement(multipleUOMDropdownsLocator, 5);
		Select select = new Select(multipleUOMDropdownsLocator);
		for(int i = 0 ; i < expectedOptionsFromUOMDropdown.length ; i++)
		{
		Assert.assertEquals(select.getOptions().get(i).getText().trim(),expectedOptionsFromUOMDropdown[i],"Multiple UOMs are not displaying properly.");
		}
		return this;
	}


	public ProductsDetailsPageObjects clickOnSpecificItemWhichHasUOM(int specificProductThatHasUOM) {
		Waiting.explicitWaitVisibilityOfElements(itemsWithMultipleUOMsLocator, 6);
		itemsWithMultipleUOMsLocator.get(specificProductThatHasUOM-1).click();
		return productDetailsPage();
	}


	public Number getPriceForSingleItem() throws ParseException {
		String priceLocatorArray [] = priceInSKUModeLocator.getText().split("/");
		Number price = NumberFormat.getCurrencyInstance(Locale.US).parse(priceLocatorArray[0].replace("\n", "").replace(" ", ""));
		return price;
	}

	public void checkLatestPrice(Number priceForSingleItem,String quantity) throws Exception {
		Thread.sleep(1000);
		String priceLocatorArray [] = priceInSKUModeLocator.getText().split("/");
		Number afterUpdatePrice = NumberFormat.getCurrencyInstance(Locale.US).parse(priceLocatorArray[0].replace("\n", "").replace(" ", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(priceForSingleItem,afterUpdatePrice,quantityValue),"extension price is not getting updated.");
	}

	private boolean checkForExtnPrice(Number priceForSingleItem, Number afterUpdatePrice, int quantityValue) {
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
		String previous = oneDigit.format(priceForSingleItem.doubleValue()*quantityValue);
		String after = oneDigit.format(afterUpdatePrice.doubleValue());

		if(previous.equals(after))
		{	
			return true;
		}
		return false;
	}

	public ProductsListPageObjects selectSpecificUOM(String specificUOM) {
		Select select = new Select(multipleUOMDropdownLocator);
		select.selectByVisibleText(specificUOM);
		return this;
	}


	public Number getPriceForSingleItemWhichHasMultipleUOM() throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(priceInSKUModeWhoseProductHasMultipleUOMLocator, 5);
		String priceLocatorArray [] = priceInSKUModeWhoseProductHasMultipleUOMLocator.getText().split("/");
		Number price = NumberFormat.getCurrencyInstance(Locale.US).parse(priceLocatorArray[0].replace("\n", "").replace(" ", ""));
		return price;
	}


	public ProductsListPageObjects checkLatestPriceForItemThatHasMultipleUOM(Number priceForSingleItem, String quantity) throws Exception {
		Thread.sleep(1000);
		String priceLocatorArray [] = priceInSKUModeWhoseProductHasMultipleUOMLocator.getText().split("/");
		Number afterUpdatePrice = NumberFormat.getCurrencyInstance(Locale.US).parse(priceLocatorArray[0].replace("\n", "").replace(" ", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(priceForSingleItem,afterUpdatePrice,quantityValue),"extension price is not getting updated.");
		return this;
	}


	
	public ProductsListPageObjects checkUOMChange(String uomName) {
		String priceLocatorArray [] = priceInSKUModeWhoseProductHasMultipleUOMLocator.getText().split("/");
		String actualUOMName[] = priceLocatorArray[1].split("\\(");
		Assert.assertEquals(actualUOMName[0].replace("\n", "").trim(), uomName);
		return this;
	}
}