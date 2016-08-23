package org.etna.customer.pageobjects.savecart;
import java.util.List;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
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
	public List<WebElement> breadCrumps;

	@FindBy(xpath="//li/descendant::i[contains(@class,'home')]")
	private WebElement homeBreadCrumbLinkLocator;

	@FindBy(xpath="//input[@id='searchKey']")
	private WebElement searchBoxLocator;

	@FindBy(xpath="//a[text()='3M TestMPN']/ancestor::td[@data-th='Item Description']/following-sibling::td[@data-th='select']/label[@class='customCheckBox2']")
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

	@FindBy(id="sortByBrand")
	private WebElement sortByLocator;

	@FindBy(id="resultPage")
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()[normalize-space() = '"+saveCartName+"']]")).click();
		return this;
	}

	@Step("verify breadcrumb is {0} ")
	public SaveCartPageObjects verifyBreadCrumps(String mySaveCartBreadCrumb) {

		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(mySaveCartBreadCrumb.trim()),"Breadcrump is not "+mySaveCartBreadCrumb+". It is :"+saveCartPage().breadCrumps.get(saveCartPage().breadCrumps.size()-1).getText().replace("/", "").trim());
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
	public SaveCartPageObjects verifyPageName(String saveCartBreadcrump) {
		Assert.assertTrue(mySavedCartpageName.getText().trim().equalsIgnoreCase(saveCartBreadcrump),"Page name is not "+saveCartBreadcrump);
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
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
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
		Thread.sleep(1500);

		Assert.assertTrue(assertAlertText(expectedAlertText),"Alert text is invalid");
		return this;

	}

	public SaveCartPageObjects verifyNumberAddedSuccessfullyMsg(int expectedNumberOfAddedSuccessfullyMessages) throws Exception{
		Thread.sleep(1500);
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
		Assert.assertTrue(saveCartPage().breadCrumps.get(saveCartPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(mySavedCart));
		return this;
	}

	public SaveCartPageObjects verifyBreadCrumpAfterCreation(String saveCartName, String mySaveCartBreadCrumb,String myAccountBreadcrumb) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(homeBreadCrumbLinkLocator.isDisplayed(),"home link is not displayed in the breadcrumb navigation");
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-3).getText().replace("/", "").trim().equalsIgnoreCase(myAccountBreadcrumb.trim()),"Breadcrump is not "+myAccountBreadcrumb+". It is :"+saveCartPage().breadCrumps.get(saveCartPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-2).getText().replace("/", "").trim().equalsIgnoreCase(mySaveCartBreadCrumb.trim()),"Breadcrump is not "+mySaveCartBreadCrumb+". It is :"+saveCartPage().breadCrumps.get(saveCartPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(saveCartName.trim()),"Breadcrump is not "+saveCartName+". It is :"+saveCartPage().breadCrumps.get(saveCartPage().breadCrumps.size()-1).getText().replace("/", "").trim());
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
		Waiting.explicitWaitVisibilityOfElement(sortByLocator, 10);
		Assert.assertTrue(sortByLocator.isDisplayed(),"sortBy is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(itemsPerPageLocator, 10);
		Assert.assertTrue(itemsPerPageLocator.isDisplayed(),"itemsPerPage is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(collapseViewLocator, 10);
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
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+searchText+"']")).isDisplayed());
		return this;
	}

	@Step("verifies the item is not displayed for inavlid search in saved cart ")
	public SaveCartPageObjects verifyNoResultsFoundMsg() throws Exception {
		Thread.sleep(2000);
		Assert.assertTrue(noResultsFoundMsg.isDisplayed());
		return this;
	}

	@Step("click On Clear Search Button in Saved Cart")
	public SaveCartPageObjects clickOnClearSearchButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(clearSearchBtnLocator, 15);
		clearSearchBtnLocator.click();
		return this;
	}

}

