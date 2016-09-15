package org.etna.customer.pageobjects.myaccount;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */

public class EditContactInfoPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);
	
	@FindBy(xpath="//h2")
	private WebElement editContactInfoPageName;
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	
	
	@FindBy(id="address1")
	private WebElement address1;
	
	
	
	@FindBy(id="address2")
	private WebElement address2;
	
	
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	
	
	@FindBy(id="countrySelectShip")
	private WebElement country;
	
	
	
	@FindBy(id="stateSelectShip")
	private WebElement state;
	
	
	
	@FindBy(id="zip")
	private WebElement zip;
	
	
	
	@FindBy(id="billPhone")
	private WebElement phoneNumber;
	
	
	@FindBy(id="email")
	private WebElement email;	
	
	
	@FindBy(xpath="//span[contains(text(),'Use Entity Address')]")
	private WebElement useEntityAddress;
	
	@FindBy(id="updateBtn")
	private WebElement updateButton;
	
	@FindBy(xpath="//ul[contains(@class,'breadcrumbs')]/descendant::a[text()[normalize-space()='My Account']]")
	private WebElement myAccountInBreadcrumbLocator;
	
	@FindBy(xpath="//span[@id='message']")
	private WebElement confirmationMessageLocator;
	
	@FindBy(id="errorMsg")
	private WebElement errorMessageLocator;
	
	@FindBy(xpath="//div[@id='stateSelectShip_chosen']/a")
	private WebElement selectStateAfterPluginLoadLocator;
	
	@FindBy(xpath="//div[@id='stateSelectShip_chosen']/descendant::input")
	private WebElement stateInputTextLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@id='stateSelectShip_chosen']/descendant::li")})
	private List<WebElement> stateResultsLocator;
	
	@FindBy(xpath="//div[@id='countrySelectShip_chosen']/descendant::a")
	private WebElement countryAfterPluginLoadLocator;
	
	@FindBy(xpath="//div[@id='countrySelectShip_chosen']/descendant::input")
	private WebElement countryInputTextLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@id='countrySelectShip_chosen']/descendant::li")})
	private List<WebElement> countryResultsLocator;
	
	@FindBy(xpath="//label[@for='getentityAddress']/input[@id='getentityAddress' and @type='checkbox']")
	private WebElement useEntityAddressCheckboxLocator;
	
	@FindBy(xpath="//div[@id='stateSelectShip_chosen']/descendant::span")
	private WebElement defaultValueOfSelectDropdownLocator;
	
	@Step("verify edit contact info page title contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoPageTitle(String editContactInfoPageName) {
		Assert.assertEquals(driver.getTitle().trim(), editContactInfoPageName);
		return this;
	}
	
	@Step("verify edit contact info page name contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoPageName(String editContactInfoPageName) {
		Assert.assertEquals(editContactInfoPageName.trim().toUpperCase(), editContactInfoPageName.toUpperCase());
		return this;
	}
	
	@Step("verify edit contact info breadcrumb contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoBreadcrumb(String editContactInfoPageName) {
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equalsIgnoreCase(editContactInfoPageName),"Breadcrump is not "+editContactInfoPageName+". It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim()+".");
		return this;
	}

	@Step("verify entity address checkbox")
	public EditContactInfoPageObjects verifyDisplayOfEntityAddressCheckbox() {
		Assert.assertTrue(useEntityAddress.isDisplayed(),"Use entity checkbox is not displayed.");
		return this;
	}

	@Step("verify update button")
	public EditContactInfoPageObjects verifyDisplayOfUpdateButton() {
		Assert.assertTrue(updateButton.isDisplayed(),"Update button is not displayed");
		return this;
	}

	public String getFirstName() {
		
		return firstName.getAttribute("value").trim();
	}

	public String getLastName() {
		
		return lastName.getAttribute("value").trim();
	}

	public String getPhoneNumber() {

		return phoneNumber.getAttribute("value").trim();
	}

	public String getEmailAddress() {

		return email.getAttribute("value").trim();
	}

	
	public String[] getContactDetails() {
		String[] str = {getFirstName(),getLastName(),getPhoneNumber(),getEmailAddress()};
		return str;
	}

	public EditContactInfoPageObjects verifyDisplayOfMyAccountLinkInBreadCrumb(String myAccountBreadcrumb) {
		Assert.assertTrue(myAccountInBreadcrumbLocator.isDisplayed(),"My Account in Breadcrumb is not displayed.");
		return this;
	}

	public EditContactInfoPageObjects enterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		return this;
	}

	public EditContactInfoPageObjects enterLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		return this;
	}

	public EditContactInfoPageObjects enterAddress1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
		return this;
	}

	public EditContactInfoPageObjects enterCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
		return this;
	}

	public EditContactInfoPageObjects enterZipCode(String zipcode) {
		zip.clear();
		zip.sendKeys(zipcode);
		return this;
	}

	public EditContactInfoPageObjects enterPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
		return this;
	}

	public EditContactInfoPageObjects clickOnUpdateButton() {
		updateButton.click();
		return this;
	}

	public EditContactInfoPageObjects verifySuccessMessage(String expectedSuccessMessage) {
		Waiting.explicitWaitVisibilityOfElement(confirmationMessageLocator, 3);
		Assert.assertEquals(confirmationMessageLocator.getText().trim(), expectedSuccessMessage,"Contact info is not updated successfully");
		return this;
	}

	public EditContactInfoPageObjects verifyUpdationOfPhoneNumber(String phoneNumber) {
		Assert.assertEquals(this.phoneNumber.getAttribute("value").trim(),phoneNumber,"Phone number is not updated.");
		return this;
	}

	public EditContactInfoPageObjects verifyErrorMessage(String expectedErrorMessage) {
		Waiting.explicitWaitVisibilityOfElement(errorMessageLocator, 5);
		Assert.assertEquals(errorMessageLocator.getText().replace("\n", "").trim(), expectedErrorMessage);
	return this;	
	}

	public EditContactInfoPageObjects selectState(String state) throws InterruptedException {
		Thread.sleep(4000);
		selectStateAfterPluginLoadLocator.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='stateSelectShip_chosen']/descendant::li[text()='"+state+"']")).click();
		return this;
	}

	public EditContactInfoPageObjects clickOnCountry() throws InterruptedException {
		Thread.sleep(3000);
		countryAfterPluginLoadLocator.click();
		return this;
	}

	public EditContactInfoPageObjects enterCountry(String country) throws Exception {
		Thread.sleep(1500);
		countryInputTextLocator.sendKeys(country);
		return this;
	}

	public EditContactInfoPageObjects verifyCountryIsDisplayedInTheCountryDropdown(String country) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(countryResultsLocator.get(0).getText().trim(),country);
		return this;
	}

	public EditContactInfoPageObjects clickOnState() throws InterruptedException {
		Thread.sleep(3000);
		selectStateAfterPluginLoadLocator.click();
		return this;
	}

	public EditContactInfoPageObjects enterState(String state) throws InterruptedException {
		Thread.sleep(1500);
		stateInputTextLocator.sendKeys(state);
		return this;
	}

	public EditContactInfoPageObjects verifyStateIsDisplayedInTheCountryDropdown(String country) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(stateResultsLocator.get(0).getText().trim(),country);
		return this;
	}

	public EditContactInfoPageObjects clickOnUseEntityAddress() throws InterruptedException {
		Thread.sleep(2500);
		useEntityAddressCheckboxLocator.click();
		return this;
	}

	public EditContactInfoPageObjects verifyWhetherUseEntityAddressIsNotSelected() {
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#getentityAddress').attr('checked');"),null,"remember me checkbox is not checked");
		return this;
	}

	public EditContactInfoPageObjects verifyWhetherAddress1CityStatePhoneNumberIsEmpty() throws InterruptedException {
		Assert.assertEquals(address1.getAttribute("value").trim(), "", "Address1 is not empty");
		Assert.assertEquals(city.getAttribute("value").trim(),"", "City is not empty");
		Assert.assertEquals(phoneNumber.getAttribute("value").trim(),"", "Phone Number is not empty");
		Thread.sleep(1500);
		Assert.assertEquals(defaultValueOfSelectDropdownLocator.getText().trim(), "Select State","Dropdown default value did not set to Select State.");
		return this;
	}

	public EditContactInfoPageObjects verifyWhetherAddress1CityStatePhoneNumberIsNotEmpty() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertNotEquals(address1.getAttribute("value").trim(), "", "Address1 is empty");
		Assert.assertNotEquals(city.getAttribute("value").trim(),"", "City is empty");
		Assert.assertNotEquals(defaultValueOfSelectDropdownLocator.getText().trim(), "Select State","Dropdown default value did not set to Select State.");
		Assert.assertNotEquals(phoneNumber.getAttribute("value").trim(),"", "Phone Number is empty");
	return this;	
	}
}
	
	
