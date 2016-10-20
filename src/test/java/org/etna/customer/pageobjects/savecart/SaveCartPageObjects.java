package org.etna.customer.pageobjects.savecart;
import java.util.ArrayList;
import java.util.List;

import org.etna.customer.pageobjects.sharepopup.SharePopUpPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class SaveCartPageObjects extends PageFactoryInitializer{

	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@FindBy(xpath="//h2")
	private WebElement mySavedCartpageName;


	@FindAll(value={@FindBy(xpath="//h3[text()='My Saved Carts']/ancestor::div[@class='accountDash cimm_halfBlockColumns']/descendant::ul")})
	private List<WebElement> mySavedCartListFromAccounts;

	@FindAll(value={@FindBy(xpath="//div[@class='cimm_listEnclosure']/ul")})
	private List<WebElement> mySavedCartList;

	@FindAll(value={@FindBy(xpath="//span[text()='Save Cart']/ancestor::dt/following-sibling::dd/ul")})
	private List<WebElement> mySavedCartListFromSaveIcon;

	@FindBy(xpath="//button[@id='groupNameSaveBtn']")
	private WebElement deleteSaveCartButton;

	@FindBy(xpath="//dl[@id='bulkOptions']/dt/a")
	private WebElement bulkOptionsCLickLocator;

	@FindAll({@FindBy(xpath="//dl[@id='bulkOptions']/dd/descendant::li/descendant::span")})
	private List<WebElement> bulkOptionsValuesLocator;

	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li/a[text()=' My Saved Cart']")
	private WebElement mySavedCartCrumbLocator;

	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li/a[text()='My Account']")
	private WebElement myAccountCrumbLocator;

	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	public List<WebElement> breadCrumbs;

	@FindBy(xpath="//li/descendant::i[contains(@class,'home')]")
	private WebElement homeBreadCrumbLinkLocator;

	@FindBy(xpath="//input[@id='searchKey']")
	private WebElement searchBoxLocator;

	@FindBy(xpath="//tr/td[@data-th='select']")
	private WebElement selectOneCheckboxLocator;

	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement searchBtnLocator;

	@FindBy(xpath="//input[@id='clearsearchBtn']")
	private WebElement clearSearchBtnLocator;

	@FindBy(xpath="//button[contains(text(),'Edit Cart Name')]")
	private WebElement editCartNameLocator;

	@FindBy(xpath="//button[contains(text(),'Delete Cart')]")
	private WebElement deleteCartLocator;

	@FindBy(xpath="//button[contains(text(),'Share')]")
	private WebElement shareLocator;

	@FindBy(id="sortByBrand_chosen")
	private WebElement sortByLocator;

	@FindBy(xpath="//div[@id='resultPage_chosen']/a")
	private WebElement itemsPerPageLocator;

	@FindBy(name="views")
	private WebElement collapseViewLocator;

	@FindBy(xpath="//td[@data-th='Image']")
	private WebElement itemImageLocator;

	@FindBy(xpath="//div[@class='cimm_tableDescSection left']")
	private WebElement itemDescriptionLocator;

	@FindBy(xpath="//input[@name='shoppingCartQty']")
	private WebElement quantityTextBoxLocator;

	@FindBy(xpath="//span[@class='priceSpan']/ancestor::td[@data-th='Your Price']")
	private WebElement yourPriceLocator;

	@FindBy(xpath="//span[@class='priceSpan']/ancestor::td[@data-th='Ext Price']")
	private WebElement extPriceLocator;

	@FindBy(xpath="//label[@class='customCheckBox']")
	private WebElement selectAllLocator;

	@FindBy(xpath="//ul[@id='bulkActionClick']/descendant::span[text()='Update Selected Items']")
	private WebElement updateSelectItemsLocator;

	@FindAll(value={@FindBy(xpath="//p[contains(text(),'Added Successfully.')]")})
	private List<WebElement> addedSuccessfullyMsgLocator;

	@FindBy(xpath="//input[@id='editedName']")
	private WebElement editCartNameTextBoxLocator;

	@FindBy(xpath="//input[@value='Save']")
	private WebElement editCartNameSaveIconLocator;

	@FindBy(xpath="//div[@id='editBox']/descendant::input[@value='Cancel']")
	private WebElement editCartNameCancelIconLocator;

	@FindBy(xpath="//button[contains(text(),'Delete Cart')]")
	private WebElement deleteCartIconLocator;

	@FindBy(xpath="//input[@id='searchKey']")
	private WebElement searchTextBoxInSavedCartLocator;

	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement goButtonInSavedCartLocator;

	@FindBy(xpath="//input[@id='clearsearchBtn']")
	private WebElement clearSearchButtonLocator;

	@FindBy(xpath="//td[text()='No results found']")
	private WebElement noResultsFoundMsg;

	@FindBy(xpath="//div[@class='expndCollapseViews']/descendant::a")
	private WebElement changeViewAfterPluginLoadLocator;

	@FindAll(value={@FindBy(xpath="//div[@class='expndCollapseViews']/descendant::li")})
	private List<WebElement> changeViewOptionsLocator;

	@FindBy(xpath="//li[@class='hideForCollapse']/p")
	private WebElement descriptionLocator;

	@FindBy(xpath="//div[@class='chosen-drop']/descendant::li[text()='Part Number (Asc)']")
	private WebElement partNumberAscLocator;

	@FindBy(xpath="//div[@class='chosen-drop']/descendant::li[text()='Part Number (Desc)']")
	private WebElement partNumberDescLocator;

	@FindBy(xpath="//div[@class='chosen-drop']/descendant::li[text()='Manf Part# (Asc)']")
	private WebElement manfPartNoAscLocator;

	@FindBy(xpath="//div[@class='chosen-drop']/descendant::li[text()='Manf Part# (Desc)']")
	private WebElement manfPartNoDescLocator;

	@FindAll(value={@FindBy(xpath="//div[@id='resultPage_chosen']/div/ul/li")})
	private List<WebElement> itemPerPageOptionsLocator;

	@FindAll(value={@FindBy(xpath="//table[@class='cimm_siteTable cimm_pgTable rwd-table rwd-Tab']/descendant::tbody/tr")})
	private List<WebElement> verifyItemsPerPage;


	@Step("click on mysavedcart ")
	public SaveCartPageObjects clickOnMySavedCartCrumb() {
		mySavedCartCrumbLocator.click();
		return this;
	}

	@Step("click on myAccount ")
	public SaveCartPageObjects clickOnMyAccountCrumb() {
		myAccountCrumbLocator.click();
		return this;
	}

	@Step("verify page name  is {0} ")
	public SaveCartPageObjects verifyPageName() {
		Assert.assertTrue(mySavedCartpageName.isDisplayed(),"My Cart page name is not displayed.");
		return this;
	}

	@Step("click on cart name : {0} ")
	public SaveCartPageObjects clickOnTheCreatedSaveCart(String saveCartName) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(By.xpath("//a[text()[normalize-space() = '"+saveCartName+"']]"), 4);
		driver.findElement(By.xpath("//a[text()[normalize-space() = '"+saveCartName+"']]")).click();
		return this;
	}

	@Step("verify breadcrumb is {0} ")
	public SaveCartPageObjects verifybreadCrumbs(String mySaveCartBreadCrumb) {

		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumbs, 10);
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(mySaveCartBreadCrumb.trim()),"Breadcrump is not "+mySaveCartBreadCrumb+". It is :"+saveCartPage().breadCrumbs.get(saveCartPage().breadCrumbs.size()-1).getText().replace("/", "").trim());
		return this;
	}

	@Step("verify saved Cart list ")
	public SaveCartPageObjects verifySavedCartList() {

		Waiting.explicitWaitVisibilityOfElements(mySavedCartList, 20);

		Assert.assertEquals(mySavedCartList.listIterator(), mySavedCartList.listIterator());
		return this;
	}
	@Step("verify saved Cart list From My Accounts ")
	public SaveCartPageObjects verifySavedCartListFromMyAccounts() {

		Waiting.explicitWaitVisibilityOfElements(mySavedCartListFromAccounts, 20);

		Assert.assertEquals(mySavedCartListFromAccounts.listIterator(), mySavedCartList.listIterator());
		return this;
	}


	@Step("verify saved Cart list From My Accounts ")
	public SaveCartPageObjects verifySavedCartListFromSaveIcon() {

		Waiting.explicitWaitVisibilityOfElements(mySavedCartListFromSaveIcon, 20);

		Assert.assertEquals(mySavedCartListFromSaveIcon.listIterator(), mySavedCartList.listIterator());
		return this;
	}


	@Step("verify page name  is {0} ")
	public SaveCartPageObjects verifyPageName(String saveCartBreadcrumb) {
		Assert.assertTrue(mySavedCartpageName.getText().trim().equalsIgnoreCase(saveCartBreadcrumb),"Page name is not "+saveCartBreadcrumb);
		return this;
	}

	@Step("verify cart title contains saved groups ")
	public SaveCartPageObjects verifySaveCartTitle() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Groups" +" | "+setUp.getProductName().trim());
		return this;
	}

	@Step("click on delete save cart ")
	public SaveCartPageObjects deleteSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(deleteSaveCartButton, 15);
		deleteSaveCartButton.click();
		return this;
	}

	@Step("verify deletion of save cart is {0} ")
	public SaveCartPageObjects verifyDeletionOfSaveCart(String saveCartName)
	{
		Assert.assertTrue(assertDeletionOfSaveCart(saveCartName),"Cart is not deleted yet.");
		return this;
	}
	public boolean  assertDeletionOfSaveCart(String saveCartName) {

		try
		{
			Assert.assertFalse(driver.findElement(By.xpath("//a[contains(text(),'"+saveCartName+"')])")).isDisplayed());
		}
		catch(Exception e)
		{
			return true;
		}
		return false;
	}

	@Step("verify title is {0} ")
	public SaveCartPageObjects verifyTitleAfterClickingOnTheCartCreated() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Cart" +" | "+setUp.getProductName().trim());
		return this;
	}

	@Step("select {0} from bulk actions dropdown")
	public SaveCartPageObjects selectBulkActionsDropdown(String bulkOption) throws Exception {
		bulkOptionsCLickLocator.click();
		switch(bulkOption)
		{
		case "Delete Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Delete Selected Items']")).click();
			break;
		case "Update Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Update Selected Items']")).click();
			break;
		case "Add Selected Items to Cart":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Add Selected Items to Cart']")).click();
			break;
		default: throw new Exception("invalid input");
		}
		return this;
	}

	@Step("verify whether alert text is {0}")
	public SaveCartPageObjects verifyAlertText(String expectedAlertText) throws Exception{


		Assert.assertTrue(assertAlertText(expectedAlertText),"Alert text is invalid");
		return this;

	}

	public SaveCartPageObjects verifyNumberAddedSuccessfullyMsg(int expectedNumberOfAddedSuccessfullyMessages) throws Exception{

		Assert.assertEquals(addedSuccessfullyMsgLocator.size(), expectedNumberOfAddedSuccessfullyMessages);
		return this;

	}

	public boolean assertAlertText(String expectedAlertText) throws Exception
	{
		boolean t = TestUtility.getAlertText().trim().equals(expectedAlertText);
		TestUtility.alertAccept();

		return t;
	}
	@Step("click on select checkbox ")
	public SaveCartPageObjects clickOnFirstSelectCheckbox() {
		Waiting.explicitWaitVisibilityOfElement(selectOneCheckboxLocator, 15);
		selectOneCheckboxLocator.click();
		return this;
	}

	@Step("verify whether breadcrumb is {0} ")
	public SaveCartPageObjects verifyBreadCrumpOfMySavedCart(String mySavedCart) {
		Assert.assertTrue(saveCartPage().breadCrumbs.get(saveCartPage().breadCrumbs.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(mySavedCart));
		return this;

	}

	public SaveCartPageObjects verifyBreadCrumpAfterCreation(String saveCartName, String mySaveCartBreadCrumb,String myAccountBreadcrumb) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumbs, 10);
		Assert.assertTrue(homeBreadCrumbLinkLocator.isDisplayed(),"home link is not displayed in the breadcrumb navigation");
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-3).getText().replace("/", "").trim().equalsIgnoreCase(myAccountBreadcrumb.trim()),"Breadcrump is not "+myAccountBreadcrumb+". It is :"+saveCartPage().breadCrumbs.get(saveCartPage().breadCrumbs.size()-1).getText().replace("/", "").trim());
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-2).getText().replace("/", "").trim().equalsIgnoreCase(mySaveCartBreadCrumb.trim()),"Breadcrump is not "+mySaveCartBreadCrumb+". It is :"+saveCartPage().breadCrumbs.get(saveCartPage().breadCrumbs.size()-1).getText().replace("/", "").trim());
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(saveCartName.trim()),"Breadcrump is not "+saveCartName+". It is :"+saveCartPage().breadCrumbs.get(saveCartPage().breadCrumbs.size()-1).getText().replace("/", "").trim());
		return this;
	}

	@Step("verify my saved cart page")
	public SaveCartPageObjects verifyMySavedCartPage() {
		Assert.assertTrue(mySavedCartpageName.isDisplayed(),"My Saved Cart page name is not displayed.");
		Assert.assertTrue(bulkOptionsCLickLocator.isDisplayed(),"Bulk Options is not displayed.");
		Assert.assertTrue(searchBoxLocator.isDisplayed(),"Search Box is not displayed.");
		Assert.assertTrue(searchBtnLocator.isDisplayed(),"Search Button is not displayed.");
		Assert.assertTrue(clearSearchBtnLocator.isDisplayed(),"clearSearchBtn is not displayed.");
		Assert.assertTrue(editCartNameLocator.isDisplayed(),"editCartName is not displayed.");
		Assert.assertTrue(deleteCartLocator.isDisplayed(),"deleteCart is not displayed.");
		Assert.assertTrue(shareLocator.isDisplayed(),"share is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(sortByLocator, 15);
		sortByLocator.click();
		Assert.assertTrue(sortByLocator.isDisplayed(),"sortBy is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(itemsPerPageLocator, 15);
		Assert.assertTrue(itemsPerPageLocator.isDisplayed(),"itemsPerPage is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(collapseViewLocator, 15);
		Assert.assertTrue(collapseViewLocator.isDisplayed(),"collapseView is not displayed.");
		Assert.assertTrue(itemImageLocator.isDisplayed(),"itemImage is not displayed.");
		Assert.assertTrue(itemDescriptionLocator.isDisplayed(),"itemDescription is not displayed.");
		Assert.assertTrue(quantityTextBoxLocator.isDisplayed(),"quantity is not displayed.");
		Assert.assertTrue(yourPriceLocator.isDisplayed(),"yourPrice is not displayed.");
		Assert.assertTrue(extPriceLocator.isDisplayed(),"extPrice is not displayed.");
		Assert.assertTrue(selectAllLocator.isDisplayed(),"selectAll is not displayed.");


		return this;
	}

	@Step("click on selectAll checkbox ")
	public SaveCartPageObjects clickOnSelectAllCheckBox() {
		Waiting.explicitWaitVisibilityOfElement(selectAllLocator, 15);
		selectAllLocator.click();
		return this;
	}


	@Step("enter {0} as Quantity")
	public SaveCartPageObjects enterQuantity(String quantity) {
		Waiting.explicitWaitVisibilityOfElement(quantityTextBoxLocator, 6);
		quantityTextBoxLocator.clear();
		quantityTextBoxLocator.sendKeys(quantity);
		return this;
	}

	@Step("click On Edit Cart Name")
	public SaveCartPageObjects clickOnEditCartName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(editCartNameLocator, 15);
		editCartNameLocator.click();
		return this;
	}

	@Step("Verify Edit Cart Name Elements")
	public SaveCartPageObjects verifyEditCartNameElements() throws Exception {
		Assert.assertTrue(editCartNameTextBoxLocator.isDisplayed(),"editCartNameTextBox not displayed.");
		Assert.assertTrue(editCartNameSaveIconLocator.isDisplayed(),"editCartNameSaveIcon not displayed.");
		Assert.assertTrue(editCartNameCancelIconLocator.isDisplayed(),"editCartNameCancelIcon not displayed.");
		return this;
	}
	@Step("Send Text in Edit Cart name Text Box")
	public SaveCartPageObjects editCartNameTextBox(String editCartName) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(editCartNameTextBoxLocator, 15);
		editCartNameTextBoxLocator.clear();
		editCartNameTextBoxLocator.sendKeys(editCartName);
		return this;
	}
	@Step("click On Save Icon of Edit Cart Name")
	public SaveCartPageObjects clickOnSaveIconOfEditCartName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(editCartNameSaveIconLocator, 15);
		editCartNameSaveIconLocator.click();
		return this;
	}
	@Step("click On Cancel Icon of Edit Cart Name")
	public SaveCartPageObjects clickOnCancelIconOfEditCartName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(editCartNameCancelIconLocator, 15);
		editCartNameCancelIconLocator.click();
		return this;
	}
	@Step("Verify Edit Cart Name Elements are not displayed when Cancel Icon is clicked")
	public SaveCartPageObjects verifyWhetherEditCartNameElementsAreNotDisplayedAfterCancel() throws Exception {
		Assert.assertFalse(editCartNameTextBoxLocator.isDisplayed(),"editCartNameTextBox is displayed.");
		Assert.assertFalse(editCartNameSaveIconLocator.isDisplayed(),"editCartNameSaveIcon is displayed.");
		Assert.assertFalse(editCartNameCancelIconLocator.isDisplayed(),"editCartNameCancelIcon is displayed.");


		return this;
	}

	@Step("click On Delete Cart")
	public SaveCartPageObjects clickOnDeleteCart() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(deleteCartIconLocator, 15);
		deleteCartIconLocator.click();
		return this;
	}

	@Step("enter search text in saved cart")
	public SaveCartPageObjects searchTextBoxInSavedCart(String text) {
		Waiting.explicitWaitVisibilityOfElement(searchTextBoxInSavedCartLocator, 6);
		searchTextBoxInSavedCartLocator.clear();
		searchTextBoxInSavedCartLocator.sendKeys(text);
		return this;
	}

	@Step("click On Go Button in Saved Cart")
	public SaveCartPageObjects clickOnGoButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(goButtonInSavedCartLocator, 15);
		goButtonInSavedCartLocator.click();
		return this;
	}

	@Step("verifies the item displayed when searched in saved cart ")
	public SaveCartPageObjects verifyItemDisplay(String searchText) throws Exception {

		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+searchText+"']")).isDisplayed());
		return this;
	}

	@Step("verifies the item is not displayed for inavlid search in saved cart ")
	public SaveCartPageObjects verifyNoResultsFoundMsg() throws Exception {

		Assert.assertTrue(noResultsFoundMsg.isDisplayed());
		return this;
	}

	@Step("click On Clear Search Button in Saved Cart")
	public SaveCartPageObjects clickOnClearSearchButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clearSearchBtnLocator, 15);
		clearSearchBtnLocator.click();
		return this;
	}
	@Step("click On Sort By Drop Down")
	public SaveCartPageObjects clickOnSortByDropDown() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(sortByLocator, 15);
		sortByLocator.click();
		return this;
	}
	@Step("click On Collapse View")
	public SaveCartPageObjects clickOnViewLocator() throws Exception {
		Thread.sleep(4500);
		changeViewAfterPluginLoadLocator.click();
		return this;
	}


	@Step("click on {0}")
	public SaveCartPageObjects clickOnSpecificView(String specificView) throws Exception {

		Thread.sleep(1500);


		for(int i = 0 ; i < changeViewOptionsLocator.size() ; i++)
		{
			if(changeViewOptionsLocator.get(i).getText().trim().equals(specificView))
			{

				changeViewOptionsLocator.get(i).click();
				break;
			}
		}
		return this;
	}

	@Step("verifies display of description for expand view ")
	public SaveCartPageObjects verifyDescriptionDisplayForExpandView() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(descriptionLocator, 15);
		Assert.assertTrue(descriptionLocator.isDisplayed());
		return this;
	}

	@Step("verifies there is no display of description for collapse view ")
	public SaveCartPageObjects verifyDescriptionDisplayForCollapseView() throws Exception {

		Assert.assertFalse(descriptionLocator.isDisplayed(),"Description is displayed");
		return this;
	}

	@Step("verifies display of sort by dropdown ")
	public SaveCartPageObjects verifySortByDropdown() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(partNumberAscLocator, 15);
		Assert.assertTrue(partNumberAscLocator.isDisplayed());
		Waiting.explicitWaitVisibilityOfElement(partNumberDescLocator, 15);
		Assert.assertTrue(partNumberDescLocator.isDisplayed());
		Waiting.explicitWaitVisibilityOfElement(manfPartNoAscLocator, 15);
		Assert.assertTrue(manfPartNoAscLocator.isDisplayed());
		Waiting.explicitWaitVisibilityOfElement(manfPartNoDescLocator, 15);
		Assert.assertTrue(manfPartNoDescLocator.isDisplayed());
		return this;
	}

	@Step("click On Item Per Page Locator")
	public SaveCartPageObjects clickOnItemPerPage() throws Exception {
		Thread.sleep(4500);
		itemsPerPageLocator.click();
		return this;
	}

	@Step("click On Item Per Page Options in  dropdown")
	public SaveCartPageObjects clickOnItemPerPageOption(int option) throws Exception {

		for(int i = 0 ; i < itemPerPageOptionsLocator.size() ; i++)
		{
			if(itemPerPageOptionsLocator.get(i).getText().trim().equals(option))
			{

				itemPerPageOptionsLocator.get(i).click();
				break;
			}
		}
		return this;
	}

	@Step("verify display of items per page")
	public SaveCartPageObjects verifyDisplayOfItems(int items) throws Exception {


		for(int i = 0 ; i <=verifyItemsPerPage.size() ; i++)
		{
			if(verifyItemsPerPage.size()<=items)
			{

				Assert.assertTrue(true);
				break;
			}
		}
		return this;
	}

	public SaveCartPageObjects verifyWhetherCreatedCartIsDisplayedInSaveCartListPage(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(By.xpath("//a[text()[normalize-space() = '"+saveCartName+"']]"), 6);
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()[normalize-space() = '"+saveCartName+"']]")).isDisplayed(),"Created cart is not getting displayed in Save Cart List Page.");
		return this;
	}

	public SaveCartPageObjects verifyDisplayOfShareCartLink() {
		Waiting.explicitWaitVisibilityOfElement(shareLocator, 6);
		Assert.assertTrue(shareLocator.isDisplayed(),"Share Cart Link is not displayed");
		return this;
	}
	public SharePopUpPageObjects clickOnShareCartLink() {
		Waiting.explicitWaitVisibilityOfElement(shareLocator, 6);
		shareLocator.click();
		return sharePopUp();
	}

	public SaveCartPageObjects verifyWhetherTheCartIsShared(String saveCartName) {
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'"+saveCartName+"') and contains(@href,'SharedCart')]")).isDisplayed(),"Cart is which was shared is not displayed");
		return this;
	}

	public SaveCartPageObjects clickOnSharedCart(String saveCartName) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[contains(@href,'"+saveCartName+"') and contains(@href,'SharedCart')]")));
		return this;
	}


	public SaveCartPageObjects verifyCompleteBreadcrumb(String completeBreadcrumb) {
		String[] str = completeBreadcrumb.split("/");
		for(int i = 0 ; i < breadCrumbs.size() ; i++)
		{
			Assert.assertEquals(breadCrumbs.get(i).getText().replace("/", "").trim(), str[i]);
		}
		return this;
	}

}

