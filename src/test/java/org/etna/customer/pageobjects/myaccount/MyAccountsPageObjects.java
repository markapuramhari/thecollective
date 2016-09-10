package org.etna.customer.pageobjects.myaccount;
import java.io.File;

import org.etna.customer.pageobjects.savecart.SaveCartPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//h2")
	private WebElement myAccountPageName;
	
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
	
	@FindBy(css="a[href='/EditContactInfo']")
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
	private WebElement viewMore;
	
	
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
	public MyAccountsPageObjects clickOnAddressTab() {
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
		Thread.sleep(4000);
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

		((JavascriptExecutor) driver).executeScript("arguments[0].click();",viewMore);
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

}
	
	
