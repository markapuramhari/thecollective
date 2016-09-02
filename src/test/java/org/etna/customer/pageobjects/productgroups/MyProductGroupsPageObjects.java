package org.etna.customer.pageobjects.productgroups;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.etna.customer.pageobjects.mycart.MyCartPageObjects;
import org.etna.customer.pageobjects.productdetails.ProductsDetailsPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */
public class MyProductGroupsPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	Actions action = new Actions(driver);
	
	ProductsDetailsPageObjects productDetailsPage = new ProductsDetailsPageObjects();
	
	@FindBy(id="groupName")
	private WebElement groupName;
	
	@FindBy(xpath="//h2")
	public WebElement pageName;
	
	@FindBy(xpath="//button[contains(@onclick,'deleteSavedProductGroup')]")
	private WebElement deleteGroupButtonLocator;
	
	@FindBy(xpath="//li[contains(text(),'No Product Group Available')]")
	private WebElement noProductGroupsAvailableText;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_listEnclosure']/descendant::a")})
	private List<WebElement> listOfMyProductGroupsLocator;
	
	@FindBy(xpath="//button[contains(text(),'Edit Group Name')]")
	private WebElement editGroupNameButtonLocator;
	
	@FindBy(xpath="//dl[@id='bulkOptions']")
	private WebElement bulkOptionsLocator;
	
	@FindBy(xpath="//input[@id='searchKey']")
	private WebElement searchTextboxLocator;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement serachGoButtonLocator;
	
	@FindBy(xpath="//input[@id='clearsearchBtn']")
	private WebElement clearSearchButtonLocator;


	@FindBy(id="sortByBrand")
	private WebElement sortByLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@id='sortByBrand_chosen']/descendant::li")})
	private List<WebElement> sortByOptionsTextLocator;
	
	
	@FindBy(id="resultPage")
	private WebElement resultsPerPageLocator;
	
	@FindBy(name="views")
	private WebElement changeViewLocator;
	
	@FindBy(xpath="//table")
	public WebElement myProductGroupCartSection;
	
	@FindAll(value={@FindBy(xpath="//table[contains(@class,'cimm_siteTable')]/descendant::label[@class='customCheckBox2']/input")})
	private List<WebElement> checkboxesLocator;
	
	@FindBy(xpath="//dl[@id='bulkOptions']/dt/a")
	private WebElement bulkOptionsCLickLocator;
	
	@FindAll({@FindBy(xpath="//dl[@id='bulkOptions']/dd/descendant::li/descendant::span")})
	private List<WebElement> bulkOptionsValuesLocator;
	
	@FindBy(xpath="//div[contains(@class,'mainContentEnclosure')]/descendant::p")
	private WebElement noSaveGroupAvailableTextLocator;
	
	@FindBy(id="editedName")
	private WebElement editGroupNameTextboxLocator;
	
	@FindBy(id="groupNameSaveBtn")
	private WebElement groupNameSaveButton;
	
	@FindBy(xpath="//td[@data-th='Ext Price']/span")
	private WebElement extensionPriceLocator;
	
	@FindAll( value = { @FindBy (xpath="//div[@class='cimm_tableDescSection']/descendant::a")})
	private List<WebElement> productNamesLocator;
	
	@FindAll(value={@FindBy(name="shoppingCartQty")})
	private List<WebElement> shoppingCartQuantityLocator;
	
	@FindBy(xpath="//table/descendant::span[contains(text(),'Select All')]")
	private WebElement selectAllTextLocator;
	
	
	@FindBy(xpath="//table/descendant::input[contains(@id,'chkSelectall')]")
	private WebElement selectAllCheckboxLocator;
	
	@FindBy(xpath="//div[@id='sortByBrand_chosen']/a")
	private WebElement sortByDropdownLocator;
	
	@Step("click on {0} group")
	public MyProductGroupsPageObjects clickOnTheGroupCreated(String myProductGroupName) {
		String productGroup = "//a[text()[normalize-space() = '"+myProductGroupName+"']]";
		Waiting.explicitWaitVisibilityOfElement((By.xpath(productGroup)), 20);
		WebElement myProductGroup = driver.findElement(By.xpath(productGroup));
		myProductGroup.click();
		return this;
	}
	
	@Step("verify whether breadcrumb is {0} ")
	public MyProductGroupsPageObjects verifyBreadCrump(String myProductGroupName) throws Exception
	{
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(3500);
		}
		else
		{
			Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		}
	String lastBreadCrump = productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().trim();
	Assert.assertEquals(myProductGroupName, lastBreadCrump.replace("/", "").trim(),"item name and the last breadcrump is not the same. Item name is : "+myProductGroupName +" and the last breadcrump is : "+ lastBreadCrump);
	return this;

	}

	@Step("verify page name")
	public MyProductGroupsPageObjects verifyPageName() {
		Assert.assertEquals(pageName.getText().trim(), data.getMyProductGroupsPageName().toUpperCase());
		return this;
	}
	
	@Step("verify whether page name {0}")
	public MyProductGroupsPageObjects verifyPageName(String myProductGroupName) {
		Assert.assertEquals(groupName.getText().trim(), myProductGroupName.toUpperCase());
		return this;
	}

	@Step("click on delete")
	public MyProductGroupsPageObjects clickOnDelete() {
		deleteGroupButtonLocator.click();
		return this;	
	}

	public boolean assertAlertText(String expectedAlertText) throws Exception
	{
		boolean t = TestUtility.getAlertText().trim().equals(expectedAlertText);
		TestUtility.alertAccept();
		return t;
	}
	
	@Step("verify whether alert text is {0}")
	public MyProductGroupsPageObjects verifyAlertText(String expectedAlertText) throws Exception{
	
		Thread.sleep(1500);
		Assert.assertTrue(assertAlertText(expectedAlertText),"Alert text is invalid.");
		return this;
		
	}

	@Step("verify No Product Group Available text is displayed")
	public MyProductGroupsPageObjects verifyNoProductGroupAvailableText() {
		Assert.assertTrue(noProductGroupsAvailableText.isDisplayed());
		return this;
		
	}
	
	@Step("verify whether {0} group is deleted")
	public MyProductGroupsPageObjects verifyWhetherGroupIsDeleted(String myProductGroupName)
	{
		Assert.assertTrue(assertGroupdIsDeleted(myProductGroupName),"group is not deleted.");
		return this;
	}

	public boolean assertGroupdIsDeleted(String myProductGroupName) {
		try
		{
		String productGroup = "//a[text()='"+myProductGroupName+"')]";
		Waiting.explicitWaitVisibilityOfElement( driver.findElement(By.xpath(productGroup)), 10);
		WebElement myProductGroup = driver.findElement(By.xpath(productGroup));
		Assert.assertTrue(myProductGroup.isDisplayed(),"group is not deleted yet.");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	}

	@Step("verify whether breadcrumb is {0} ")
	public MyProductGroupsPageObjects verifyBreadCrumpOfMyProductGroupLandingPage(String myProductGroupsPageName) {
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(myProductGroupsPageName));
		return this;
	}

	@Step("verify whether page name is {0}")
	public MyProductGroupsPageObjects verifyPageNameOfMyProductGroupLandingPage(String myProductGroupsPageName) {
		Assert.assertTrue(pageName.getText().trim().equalsIgnoreCase(myProductGroupsPageName),"Page name is "+pageName.getText().trim()+" but expecting the page name to be "+myProductGroupsPageName+".");
		return this;
	}


	@Step("verify whether page title is {0}")
	public MyProductGroupsPageObjects verifyPageTitle(String myProductGroupLandingPageTitle,String productName) {
		
		Assert.assertEquals(driver.getTitle().trim(), myProductGroupLandingPageTitle+" | "+productName);
		return this;
	}
	
	
	public String clickOnSpecficProductGroupAndGetProductName(int specificMyProductGroup) {
		String nameOfTheProductGroupToBeClicked = listOfMyProductGroupsLocator.get(specificMyProductGroup-1).getText().trim();
		listOfMyProductGroupsLocator.get(specificMyProductGroup-1).click();
		return nameOfTheProductGroupToBeClicked;
	}

	@Step("verify my product group page after clicking on the product")
	public MyProductGroupsPageObjects verifyMyProductGroupPageAfterClickingOnTheProduct() throws InterruptedException {
		Assert.assertTrue(changeViewLocator.isDisplayed(),"Change view dropdown is not displayed.");
		Assert.assertTrue(sortByLocator.isDisplayed(),"Sort By options is not displayed.");
		Assert.assertTrue(resultsPerPageLocator.isDisplayed(),"Results Per page is not displayed.");
		Assert.assertTrue(myProductGroupCartSection.isDisplayed(),"My Product Group Cart Section is not displayed.");
		Assert.assertTrue(clearSearchButtonLocator.isDisplayed(),"Clear search is not displayed.");		
		Assert.assertTrue(serachGoButtonLocator.isDisplayed(),"Search Go button is not displayed.");		
		Assert.assertTrue(searchTextboxLocator.isDisplayed(),"Search textbox is not displayed.");
		Assert.assertTrue(bulkOptionsLocator.isDisplayed(),"Bulk options is not displayed.");
		Assert.assertTrue(editGroupNameButtonLocator.isDisplayed(),"Edit group name button is not displayed.");
		Assert.assertTrue(deleteGroupButtonLocator.isDisplayed(),"Delete group name button is not displayed.");
		return this;
	}

	@Step("click on the {0}st/nd/rd checkbox")
	public MyProductGroupsPageObjects clickOnTheSpecificCheckbox(int specificCheckbox) {
		checkboxesLocator.get(specificCheckbox-1).click();
		return this;
	}

	@Step("select {0} from bulk actions dropdown")
	public MyProductGroupsPageObjects selectBulkActionsDropdown(String bulkOption) throws Exception {
		bulkOptionsCLickLocator.click();
		switch(bulkOption)
		{
		case "Delete Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Delete Selected Items']")).click();
			break;
		case "Update Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Update Selected Items']")).click();
			break;
		case "Add Selected Items to Cart":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Add Selected Items to Cart']")).click();
			break;
		default: throw new Exception("invalid input");	
		}
		
		/*for(WebElement bulkOptionValue : bulkOptionsValuesLocator)
		{
			if(bulkOptionValue.getText().trim().equals(bulkOption))
					{
						bulkOptionValue.click();
						break;
					}
		}*/
		return this;
	}

	public boolean assertDeleteOfMyProductGroup(){
		try
		{
		if(myProductGroupCartSection.isDisplayed())
		{
			return false;
		}
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;
	}
	
	@Step("verify empty group message")
	public MyProductGroupsPageObjects verifyDeleteOfItemMyProductGroup(String expectedEmptyGroupMessage) {
		Waiting.explicitWaitVisibilityOfElement(noSaveGroupAvailableTextLocator, 10);
		Assert.assertEquals(noSaveGroupAvailableTextLocator.getText().trim(), expectedEmptyGroupMessage);
		Assert.assertTrue(assertDeleteOfMyProductGroup(), "item is still present in the cart even after deleting the item.");
		return this;
	}

	@Step("click on edit button")
	public MyProductGroupsPageObjects clickOnEditButton() {
		editGroupNameButtonLocator.click();
		return this;
	}

	@Step("edit group name as {0}")
	public MyProductGroupsPageObjects enterEditGroupName(String groupName) {
		Waiting.explicitWaitVisibilityOfElement(editGroupNameTextboxLocator, 10);
		editGroupNameTextboxLocator.clear();
		editGroupNameTextboxLocator.sendKeys(groupName);
		return this;
	}

	@Step("click on save")
	public MyProductGroupsPageObjects clickOnSave() {
		groupNameSaveButton.click();
		return this;
	}

	public Number getExtensionPrice() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(extensionPriceLocator, 5);
		Number price = NumberFormat.getCurrencyInstance(Locale.US).parse(extensionPriceLocator.getText().replace("\n", "").replace(" ", "").trim());
		return price;
	}
	
	@Step("verify update of extension price")
	public MyProductGroupsPageObjects verifyExtPrice(String quantity, Number currentExtnPrice) throws ParseException {
		Number afterUpdateExtensionPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(extensionPriceLocator.getText().replace("\n", "").replace(" ", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(currentExtnPrice,afterUpdateExtensionPrice,quantityValue),"extension price is not getting updated.");
		return this;
	}
	
	private boolean checkForExtnPrice(Number previousPrice,Number afterPrice,int quantityValue)
	{
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
		String previous = oneDigit.format(previousPrice.doubleValue()*quantityValue);
		String after = oneDigit.format(afterPrice.doubleValue());

		if(previous.equals(after))
		{	
			return true;
		}
		return false;
	}

	public String getProductNameInShoppingCart() {
	
		return productNamesLocator.get(0).getText().trim();
	}

	public String getQuantity() {
		
		return shoppingCartQuantityLocator.get(0).getAttribute("value").trim();
	}

	public String getSpecificGroupName(int specificGroupName) {
		return listOfMyProductGroupsLocator.get(specificGroupName-1).getText().trim();
	}

	@Step("verify no items in group message.")
	public MyProductGroupsPageObjects verifySortByDrodown(String[] expectedSortByDropdownOptions) throws InterruptedException {
		Thread.sleep(3500);
		sortByDropdownLocator.click();
		for(int i = 0 ; i<sortByOptionsTextLocator.size() ; i++)
		{
		Assert.assertEquals(sortByOptionsTextLocator.get(i).getText().trim(), expectedSortByDropdownOptions[i]);
		}
		return this;
	}

	@Step("click on select all checkbox")
	public MyProductGroupsPageObjects clickOnSelectAllCheckbox() {
		selectAllTextLocator.click();
		return this;
	}

	public boolean assertNoItemsInGroupMessage(){
		try
		{
		if (driver.findElement(By.xpath("//p[contains(text(),'No items present in the group')]")).isDisplayed())
		{
			return true;
		}
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return false;
	}
	
	@Step("verify no items in group message.")
	public MyProductGroupsPageObjects verifyNoItemsInGroupMessage() throws Exception {
		Thread.sleep(1500);
		Assert.assertTrue(assertNoItemsInGroupMessage(),"No items in group message is not displayed.");
		return this;
	}


	

}