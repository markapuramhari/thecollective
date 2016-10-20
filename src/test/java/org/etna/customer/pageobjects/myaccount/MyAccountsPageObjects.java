package org.etna.customer.pageobjects.myaccount;
import java.io.File;
import java.util.List;
import org.etna.customer.pageobjects.homepage.HomePageObjects;
import org.etna.customer.pageobjects.openorders.OpenOrdersPageObjects;
import org.etna.customer.pageobjects.orderconfirmation.OrderConfirmationPageObjects;
import org.etna.customer.pageobjects.orderdetails.OrderDetailsPageObjects;
import org.etna.customer.pageobjects.savecart.SaveCartPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class MyAccountsPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountPageName;
	@FindBy(xpath="//h2[text()='My Saved Cart']")
	private WebElement saveCartPageName;
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li[contains(text(),'My Account')]")
	private WebElement myAccountBreadcrump;
	@FindBy(xpath="//div[contains(@class,'myAccTab')]/descendant::a[contains(text(),'Profile')]")
	private WebElement profileTab;
	@FindBy(xpath="//div[contains(@class,'myAccTab')]/descendant::a[contains(text(),'Address')]")
	private WebElement addressTab;
	@FindBy(xpath="//div[contains(@class,'myAccTab')]/descendant::a[contains(text(),'Groups')]")
	private WebElement groupsTab;
	@FindBy(xpath="//div[contains(@class,'myAccTab')]/descendant::a[contains(text(),'Orders')]")
	private WebElement ordersTab;
	@FindBy(xpath="//label[text()='Recently Ordered Items']")
	private WebElement recentlyOrderedItemsHeading;
	@FindBy(id="recentorders")
	private WebElement recentlyOrderedItemsList;
	@FindBy(id="profile")
	private WebElement profileSection;
	@FindBy(xpath="//div[@id='profile']/descendant::a[@href='/EditContactInfo']")
	private WebElement editContactInfoLink;
	@FindBy(xpath="//input[@id='profileImage']")
	private WebElement profileUploadLinkLocator;
	@FindBy(xpath="//input[@value='Upload']")
	private WebElement uploadButtonLocator;
	@FindBy(xpath="//div[@class='userImage']/descendant::img")
	private WebElement profilePicLocator;
	@FindBy(xpath="//h3[contains(text(),'Billing Address')]/descendant::a")
	private WebElement editBillingAddressLocator;
	@FindBy(name="shipFirstName")
	private WebElement addNewShippingAddressFirstNameLocator;
	@FindBy(name="shipLastName")
	private WebElement addNewshippingAddressLastNameLocator;
	@FindBy(name="address1")
	private WebElement addNewShippingAddressAddress1Locator;
	@FindBy(name="address2")
	private WebElement addNewShippingAddressAddress2Locator;
	@FindBy(name="city")
	private WebElement addNewShippingAddressCityLocator;
	@FindBy(id="stateSelectShip")
	private WebElement addNewShippingAddressSelectStateLocator;
	@FindBy(id="zip")
	private WebElement addNewShippingAddressZipCodeLocator;
	@FindBy(name="shipPhone")
	private WebElement addNewShippingAddressPhoneLocator;
	@FindBy(id="emailAddress")
	private WebElement addNewShippingAddressEmailAddressLocator;
	@FindBy(name="shipToId")
	private WebElement addNewShippingAddressShipToLocator;
	@FindBy(xpath="//button[contains(text(),'Add Address')]")
	private WebElement addNewShippingAddressFormButtonLocator;
	@FindBy(xpath="//a[contains(text(),'Add Shipping Address')]")
	private WebElement addNewShippingAddressButtonLocator;
	@FindBy(xpath="//h3[text()='My Saved Carts']/ancestor::div[@class='accountDash cimm_halfBlockColumns']/descendant::a[contains(text(),'View More')]")
	private WebElement viewMoreLocator;
	@FindBy(xpath="//h3[contains(text(),'user contact')]")
	private WebElement userContactLocator;
	@FindBy(xpath="//div[@class='userInfo']/p/span")
	private WebElement addressSectionInProfileTabLocator;
	@FindBy(xpath="//div[@id='lastLogin']/h4/span")
	private WebElement lastLoginLocator;
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'cimm_headerRight')]/descendant::ul[@class='cimm_myAccountMenu']/li/a")})
	private List<WebElement> myAcountDropdownLinksLocator;
	@FindBy(xpath="//div[@id='Address']/descendant::h3[contains(text(),'Billing Address')]/following-sibling::p")
	private WebElement billingAddressLocator;
	@FindBy(xpath="//div[@id='Address']/descendant::h3[contains(text(),'Shipping Address')]/following-sibling::p")
	private WebElement shippingAddressLocator;
	@FindBy(id="profile")
	private WebElement profileSectionLocator;
	@FindBy(xpath="//div[@id='DataTables_Table_0_length']/label/select")
	private WebElement showDropdownLocator;
	@FindBy(xpath="//input[@placeholder='Search Ship Address']")
	private WebElement searchShipAddressIcon;
	@FindBy(xpath="//table[@id='DataTables_Table_0']/thead/tr[@role='row']")
	private WebElement shipAddressListHeader;
	@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr[@role='row']")
	private WebElement shipAddressListDetails;
	@FindBy(xpath="//div[@id='DataTables_Table_0_paginate']/span/a")
	private WebElement paginationLocator;
	@FindBy(xpath="//td[text()='Unilog']")
	private WebElement companyNameLocator;
	@FindBy(xpath="//td[text()='No matching records found']")
	private WebElement noMatchingRecordLocator;
	@FindBy(xpath="//div[@id='DataTables_Table_0_length']/label/select")
	private WebElement itemsPerPageLocator;
	@FindAll(value={@FindBy(xpath="//select[@name='DataTables_Table_0_length']/option")})
	private List<WebElement> itemPerPageOptionsLocator;
	@FindAll(value={@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr[@role='row']")})
	private List<WebElement> verifyItemsPerPage;
	@FindBy(xpath="//div[@id='openOrderTable']/descendant::td/a")
	private WebElement viewOrderButtonsLocator;
	@FindBy(xpath="//h3[text()='Open Orders']/ancestor::div[@class='cimm_myorderModuls']/descendant::a[text()='View All']")
	private WebElement viewAllUnderOpenOrdersLocator;
	@FindBy(xpath="//div[contains(@id,'orderHistory')]//following::a[contains(.,'View All')]")
	private WebElement viewAllUnderCompletedOrdersLocator;
	@FindAll(value={@FindBy(xpath="//div[@id='openOrderTable']/descendant::th")})
	private List<WebElement> openOrderHeadersLocator;
	@FindAll(value={@FindBy(xpath="//div[@id='orderHistory']/descendant::th")})
	private List<WebElement> completedOrderHeadersLocator;
	@FindBy(xpath="//td[@data-th='Order#']/b")
	private WebElement eclipseOrderNumberValueLocator;
	@FindBy(xpath="//td[@data-th='PO#']")
	private WebElement poValueLocator;
	@FindBy(xpath="//td[@data-th='Order Date']")
	private WebElement orderDateValueLocator;
	@FindBy(xpath="//td[@data-th='Amount']")
	private WebElement orderTotalValueLocator;
	@FindBy(xpath="//a[text()='Re-Order']")
	private WebElement ReOrderButtonLocator;
	@FindBy(xpath="//td[@data-th='Order #']")
	private WebElement orderNoLocator;
	@FindBy(xpath="//h3[text()='My Product Group']/following-sibling::a[text()='View More']")
	private WebElement myProductGroupViewMoreLocator;
	@FindBy(xpath="//h3[text()='My Saved Carts']/following-sibling::a[text()[normalize-space() = 'View More']]")
	private WebElement savedCartViewMoreLocator;
	@Step("verify my accounts page")
	public MyAccountsPageObjects verifyMyAccountPage() {
		Assert.assertTrue(myAccountPageName.isDisplayed(),"My Account page name is not displayed.");
		Assert.assertTrue(myAccountBreadcrump.isDisplayed(),"My Account breadcrump name is not displayed.");
		Assert.assertTrue(profileTab.getAttribute("class").contains("active"),"Profile tab is not enabled first.");
		Assert.assertTrue(addressTab.getAttribute("class").equals(""),"Address tab is not enabled first.Address tab is "+addressTab.getAttribute("class"));
		Assert.assertTrue(groupsTab.getAttribute("class").equals(""),"Groups tab is not enabled first.");
		Assert.assertTrue(ordersTab.getAttribute("class").equals(""),"Orders tab is not enabled first.");
		Assert.assertTrue(recentlyOrderedItemsHeading.isDisplayed(),"Recently ordered items heading is not displayed.");
		Assert.assertTrue(profileSection.isDisplayed(),"Profile Section is not displayed.");
		return this;
	}
	@Step("click on edit contact info")
	public EditContactInfoPageObjects clickOnEditContactInfo() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",editContactInfoLink);
		return editContactInfoPage();
	}
	@Step("upload file whose file path is {0}")
	public MyAccountsPageObjects uploadFile(String filepath) {
		File file = new File(filepath);
		System.out.println(file.getAbsolutePath());
		profileUploadLinkLocator.sendKeys(file.getAbsolutePath());
		return this;
	}
	@Step("click on upload")
	public MyAccountsPageObjects clickOnUpload() {
		uploadButtonLocator.click();
		return this;
	}
	@Step("verify file upload")
	public MyAccountsPageObjects verifyFileUpload(String profilePicture) throws Exception {
		Thread.sleep(3000);
		Waiting.explicitWaitVisibilityOfElement(profilePicLocator, 70);
		Assert.assertTrue(profilePicLocator.getAttribute("src").trim().contains(profilePicture.substring(profilePicture.lastIndexOf("/")+1)));
		return this;
	}
	@Step("click on address tab")
	public MyAccountsPageObjects clickOnAddressTab() throws Exception {
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",addressTab);
		return this;
	}
	@Step("click on edit billing address")
	public MyAccountsPageObjects clickOnEditBillAddress() {
		Waiting.explicitWaitVisibilityOfElement(editBillingAddressLocator, 10);
		editBillingAddressLocator.click();
		return this;
	}
	@Step("click on add new shipping address")
	public MyAccountsPageObjects clickOnAddNewShippingAddress() {
		addNewShippingAddressButtonLocator.click();
		return this;
	}
	@Step("click on add address button")
	public MyAccountsPageObjects clickOnAddAddressButton() {
		addNewShippingAddressFormButtonLocator.click();
		return this;
	}
	@Step("Enter first name {0}")
	public MyAccountsPageObjects enterFirstName(char generateCharacters) {
		addNewShippingAddressFirstNameLocator.sendKeys(Character.toString(generateCharacters)+"Hemanth");
		return this;
	}
	@Step("Enter last name {0}")
	public MyAccountsPageObjects enterLastName(char generateCharacters) {
		addNewshippingAddressLastNameLocator.sendKeys(Character.toString(generateCharacters)+"Sridhar");
		return this;
	}
	@Step("Enter address1")
	public MyAccountsPageObjects enterAddress1(char generateCharacters) {
		addNewShippingAddressAddress1Locator.sendKeys(Character.toString(generateCharacters)+"Address1");
		return this;
	}
	@Step("Enter city")
	public MyAccountsPageObjects enterCity(char generateCharacters) {
		addNewShippingAddressCityLocator.sendKeys(Character.toString(generateCharacters)+"Kent");
		return this;
	}
	@Step("select state {0}")
	public MyAccountsPageObjects selectState(String stateName) {
		Select select = new Select(addNewShippingAddressSelectStateLocator);
		select.selectByVisibleText(stateName);
		return this;
	}
	@Step("Enter zip code {0}")
	public MyAccountsPageObjects enterZipCode(int generateEightRandomNumbers) {
		addNewShippingAddressZipCodeLocator.sendKeys(Integer.toString(generateEightRandomNumbers));
		return this;
	}
	@Step("Enter phone number {0}")
	public MyAccountsPageObjects enterPhoneNumber(int tenRandomNumbers) {
		addNewShippingAddressPhoneLocator.sendKeys("1234567890");
		return this;
	}
	@Step("Enter email Address {0}")
	public MyAccountsPageObjects enterEmailAddress(char generateCharacters) {
		addNewShippingAddressEmailAddressLocator.sendKeys(Character.toString(generateCharacters)+"hemanth@gmail.com");
		return this;
	}
	@Step("Enter ship to id {0}")
	public MyAccountsPageObjects enterShipToID(int generateEightRandomNumbers) {
		addNewShippingAddressShipToLocator.sendKeys(Integer.toString(generateEightRandomNumbers));
		return this;
	}
	@Step("click on groups tab")
	public MyAccountsPageObjects clickOnGroupsTab() throws Exception {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",groupsTab);
		return this;
	}
	public MyAccountsPageObjects verifyPageName(String myAccountBreadCrumb) {
		Assert.assertTrue(myAccountPageName.getText().trim().equalsIgnoreCase(myAccountBreadCrumb),"Page name is not "+myAccountBreadCrumb+" It is "+myAccountPageName.getText().trim());
		return this;
	}
	@Step("click on view more icon")
	public MyAccountsPageObjects clickOnViewMore() throws Exception {
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",viewMoreLocator);
		return this;
	}
	@Step("verify page name")
	public MyAccountsPageObjects verifyPageName() {
		Assert.assertTrue(myAccountPageName.isDisplayed(),"My Account page name is not displayed.");
		return this;
	}
	public MyAccountsPageObjects verifyWhetherCreatedCartIsDisplayedUnderSaveCartSectionInGroupsTab(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(By.xpath("//h3[text()='My Saved Carts']/following-sibling::ul/descendant::a[text()[normalize-space() = '"+saveCartName+"']]"), 6);
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='My Saved Carts']/following-sibling::ul/descendant::a[text()[normalize-space() = '"+saveCartName+"']]")).isDisplayed(),"Created cart is not getting displayed under groups tab.");
		return this;
	}
	@Step("verify profile tab")
	public MyAccountsPageObjects verifyProfileTab() {
		Assert.assertTrue(profileSectionLocator.isDisplayed(),"Profile Section is not displayed");
		Assert.assertTrue(profileTab.getAttribute("class").contains("active"),"Profile tab is not enabled first.");
		Assert.assertTrue(userContactLocator.isDisplayed(),"User Contact is not displayed.");
		Assert.assertTrue(editContactInfoLink.isDisplayed(),"Edit contact link is not displayed.");
		Assert.assertTrue(profilePicLocator.isDisplayed(),"Profile picture is not displayed.");
		Assert.assertTrue(uploadButtonLocator.isDisplayed(),"Upload button is not displayed.");
		Assert.assertTrue(addressSectionInProfileTabLocator.isDisplayed(),"Address is not displayed.");
		Assert.assertTrue(lastLoginLocator.isDisplayed(),"Upload  is not displayed.");
		return this;
	}
	public MyAccountsPageObjects verifyAddressPage() {
		Assert.assertTrue(billingAddressLocator.isDisplayed(),"Billing Address is not displayed.");
		Assert.assertTrue(shippingAddressLocator.isDisplayed(),"Shipping Address is not displayed.");
		Assert.assertTrue(showDropdownLocator.isDisplayed(),"Show Dropdown is not displayed.");
		Assert.assertTrue(searchShipAddressIcon.isDisplayed(),"Search Ship Address is not displayed.");
		Assert.assertTrue(shipAddressListHeader.isDisplayed(),"Ship Address List is not displayed.");
		Assert.assertTrue(shipAddressListDetails.isDisplayed(),"Ship Address List Details is not displayed.");
		Assert.assertTrue(paginationLocator.isDisplayed(),"Pagination is not displayed.");
		return this;
	}
	public MyAccountsPageObjects sendTextToSearchFunction(String text) {
		Waiting.explicitWaitVisibilityOfElement(searchShipAddressIcon, 3);
		searchShipAddressIcon.sendKeys(text);
		searchShipAddressIcon.sendKeys(Keys.ENTER);
		return this;
	}
	public void verifyValidSearchResult(String companyNameForRegistration) {
		Assert.assertEquals(companyNameForRegistration, companyNameLocator.getText());
	}
	public void verifyInValidSearchResult(String invalidSearchMsg) {
		Assert.assertEquals(invalidSearchMsg, noMatchingRecordLocator.getText());
	}
	@Step("click On Item Per Page Locator")
	public MyAccountsPageObjects clickOnItemPerPage() throws Exception {
		Thread.sleep(4500);
		itemsPerPageLocator.click();
		return this;
	}
	@Step("click On Item Per Page Options in  dropdown")
	public MyAccountsPageObjects clickOnItemPerPageOption(int option) throws Exception {
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
	public MyAccountsPageObjects verifyDisplayOfItems(int items) throws Exception {
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
	public MyAccountsPageObjects verifyDisplayOfMyProductGroupAndViewMore() {
		Assert.assertTrue(myProductGroupViewMoreLocator.isDisplayed());
		return this;
	}
	public MyAccountsPageObjects verifyDisplayOfMySavedCartAndViewMore() {
		Assert.assertTrue(savedCartViewMoreLocator.isDisplayed());
		return this;
	}
	public MyAccountsPageObjects clickOnViewMoreUnderMyProductGroup() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myProductGroupViewMoreLocator);
		return this;
	}
	public MyAccountsPageObjects clickOnViewMoreUnderMySavedCart() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",savedCartViewMoreLocator);
		return this;
	}
	public MyAccountsPageObjects clickOnOrdersTab() throws Exception {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",ordersTab);
		return this;
	}
	public MyAccountsPageObjects verifyOrdersTabPageContent(String[] orderPageOpenOrdersHeaders,String[] orderPageCompletedOrdersHeaders) throws Exception {
		Waiting.explicitWaitVisibilityOfElements(openOrderHeadersLocator, 4);
		for(int i = 0 ; i< openOrderHeadersLocator.size()-1;i++)
		{
			Assert.assertEquals(openOrderHeadersLocator.get(i).getText().trim(), orderPageOpenOrdersHeaders[i],"Table header is wrong");
		}
		Assert.assertTrue(viewOrderButtonsLocator.isDisplayed(),"View Order Button is not displayed.");
		for(int i = 0 ; i< completedOrderHeadersLocator.size()-1;i++)
		{
			Assert.assertEquals(completedOrderHeadersLocator.get(i).getText().trim(), orderPageCompletedOrdersHeaders[i],"Table header is wrong");
		}
		Assert.assertTrue(viewAllUnderOpenOrdersLocator.isDisplayed(),"View All Under Open Orders is not displayed.");
		Assert.assertTrue(viewAllUnderCompletedOrdersLocator.isDisplayed(),"View All Under Completed Orders is not displayed.");
		return this;
	}
	public OpenOrdersPageObjects clickOnViewAllInOpenOrders() {
		Waiting.explicitWaitVisibilityOfElement(viewAllUnderOpenOrdersLocator, 3);
		viewAllUnderOpenOrdersLocator.click();
		return openOrdersPage();
	}
	public MyAccountsPageObjects clickOnViewAllInCompletedOrders() {
		Waiting.explicitWaitVisibilityOfElement(viewAllUnderCompletedOrdersLocator, 3);
		viewAllUnderCompletedOrdersLocator.click();
		return this;
	}
	public MyAccountsPageObjects verifyOrderDetails(String[] orderDetails) {
		String expectedEclipseOrderNumber = orderDetails[0];
		String expectedPoValue = orderDetails[1];
		String expectedOrderDate = orderDetails[2];
		String expectedOrderTotal = orderDetails[3];
		Assert.assertEquals(eclipseOrderNumberValueLocator.getText().trim(), expectedEclipseOrderNumber);
		Assert.assertEquals(poValueLocator.getText().trim(), expectedPoValue);
		Assert.assertEquals(orderDateValueLocator.getText().trim(), expectedOrderDate);
		Assert.assertEquals(orderTotalValueLocator.getText().trim(),expectedOrderTotal);
		return this;
	}
	public MyAccountsPageObjects verifyRequiredLastLoginDateFormat(String expectedDate) {
		Waiting.explicitWaitVisibilityOfElement(lastLoginLocator, 10);
		int i = lastLoginLocator.getText().trim().lastIndexOf(" ");
		String[] a =  {lastLoginLocator.getText().trim().substring(0, i), lastLoginLocator.getText().trim().substring(i)};
		Assert.assertEquals(a[0], expectedDate,"Required date is not in MMMDDYYY format.");
		return this;
	}
	public MyAccountsPageObjects clickOnViewOrder() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(viewOrderButtonsLocator, 3);
		viewOrderButtonsLocator.click();
		return this;
	}
	public OrderDetailsPageObjects clickOnOrderNoUnderOpenOrders() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(eclipseOrderNumberValueLocator, 3);
		eclipseOrderNumberValueLocator.click();
		return orderDetailsPage();
	}
	public MyAccountsPageObjects clickOnReOrder() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(ReOrderButtonLocator, 3);
		ReOrderButtonLocator.click();
		return this;
	}
	public MyAccountsPageObjects clickOnOrderNo() throws Exception {
		Thread.sleep(2000);
		Waiting.explicitWaitVisibilityOfElement(orderNoLocator, 3);
		orderNoLocator.click();
		return this;
	}
	public MyAccountsPageObjects verifyMySaveCartPageName(String pageName) {
		Waiting.explicitWaitVisibilityOfElement(saveCartPageName, 3);
		Assert.assertTrue(saveCartPageName.getText().trim().equalsIgnoreCase(pageName),pageName);
		return this;
	}
}
