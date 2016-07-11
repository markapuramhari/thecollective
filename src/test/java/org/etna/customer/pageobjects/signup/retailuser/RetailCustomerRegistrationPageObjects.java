package org.etna.customer.pageobjects.signup.retailuser;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.RandomGenerator;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class RetailCustomerRegistrationPageObjects extends PageFactoryInitializer{


	
	@FindBy(xpath="//input[@id='firstName2B']")
	private WebElement firstNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='lastName2AB']")
	private WebElement lastNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='companyName2AB']")
	private WebElement companyNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='emailAddress2AB']")
	private WebElement emailAddressLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='password2AB']")
	private WebElement passwordLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='confirmPassword2AB']")
	private WebElement confirmPasswordLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='billingAddress2AB']")
	private WebElement address1Locator;
	
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='suiteNo2AB']")
	private WebElement address2Locator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='cityName2AB']")
	private WebElement cityLocator;
	
	
	@FindBy(xpath="//span[@id='changeState']/select[@id='stateSelect']")
	private WebElement stateDropdownLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@id='stateSelect_chosen']/div/descendant::li")})
	private List<WebElement> stateDrodpdownOptions;
	
	@FindBy(xpath="//div[@id='countrySelect_chosen']/a")
	private WebElement countryLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='phoneNo2AB']")
	private WebElement phoneNumberLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@id='zipCode2AB']")
	private WebElement zipCodeLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::div[@class='center']")
	private WebElement agreementLocator;
	
	@FindBy(xpath="//form[contains(@action,'RetailReg')]/descendant::input[@value='I Accept']")
	private WebElement iAcceptLocator;
	
	@FindBy(xpath="//span[@id='errorMsg']")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//div[@id='retailRegistrationComplete']")
	private WebElement retailRegistrationSuccessMessageLocator;
	
	
	@FindBy(xpath="//div[@id='retailRegistrationComplete']/descendant::p")
	private WebElement retailUserSuccessMsgTextLocator;
	
	@Step("verify new retail customer tab")
	public RetailCustomerRegistrationPageObjects verifyNewRetailCustomerTab() throws Exception {
		Thread.sleep(1500);
		Assert.assertTrue(firstNameLocator.isDisplayed(), "first name is not displayed.");
		Assert.assertTrue(lastNameLocator.isDisplayed(), "last name is not displayed.");
		Assert.assertTrue(companyNameLocator.isDisplayed(), "company name is not displayed.");
		Assert.assertTrue(emailAddressLocator.isDisplayed(), "email address is not displayed.");
		Assert.assertTrue(passwordLocator.isDisplayed(), "password is not displayed.");
		Assert.assertTrue(confirmPasswordLocator.isDisplayed(), "confirm password is not displayed.");
		Assert.assertTrue(address1Locator.isDisplayed(), "address1 is not displayed.");
		Assert.assertTrue(address2Locator.isDisplayed(), "address2 is not displayed.");
		Assert.assertTrue(cityLocator.isDisplayed(), "city is not displayed.");
		Assert.assertTrue(phoneNumberLocator.isDisplayed(), "phone number is not displayed.");
		Assert.assertTrue(zipCodeLocator.isDisplayed(), "zipcode is not displayed.");
		Assert.assertTrue(agreementLocator.isDisplayed(), "agreement is not displayed.");
		return this;
	}

	@Step("Enter email Id {0}")
	public RetailCustomerRegistrationPageObjects enterEmailId(String emailId) throws InterruptedException {
		if(emailId.equals(""))
		{
			
		}
		else if(!emailId.contains("@"))
		{
		emailAddressLocator.sendKeys(emailId);
		}
		else
		{
		String emailIdSplit []  = emailId.split("@");
		System.out.println(emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1]);
		emailAddressLocator.sendKeys(emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1]);
		
		}
	
		return this;
	}

	@Step("Enter first name {0}")
	public RetailCustomerRegistrationPageObjects enterFirstName(String firstName) {
		Waiting.explicitWaitVisibilityOfElement(firstNameLocator, 6);
		firstNameLocator.sendKeys(firstName);
		return this;
	}

	@Step("Enter last name {0}")
	public RetailCustomerRegistrationPageObjects enterLastName(String lastName) {
		lastNameLocator.sendKeys(lastName);
		return this;
	}

	@Step("Enter company name {0}")
	public RetailCustomerRegistrationPageObjects enterCompanyName(String companyName) {
		companyNameLocator.sendKeys(companyName);
		return this;
	}

	@Step("Enter password {0}")
	public RetailCustomerRegistrationPageObjects enterPassword(String password) {
		passwordLocator.sendKeys(password);
		return this;
	}

	@Step("Enter confirm password {0}")
	public RetailCustomerRegistrationPageObjects enterConfirmPassword(String confirmPassword) {
		confirmPasswordLocator.sendKeys(confirmPassword);
		return this;
	}

	@Step("Enter address1 {0}")
	public RetailCustomerRegistrationPageObjects enterAddress1(String address1) {
		address1Locator.sendKeys(address1);
		return this;
	}

	@Step("Enter address2 {0}")
	public RetailCustomerRegistrationPageObjects etnerAddress2(String address2) {
		address2Locator.sendKeys(address2);
		return this;
	}

	@Step("Enter city {0}")
	public RetailCustomerRegistrationPageObjects enterCity(String city) {
		cityLocator.sendKeys(city);
		return this;
	}

	@Step("Enter Zip Code {0}")
	public RetailCustomerRegistrationPageObjects enterZipCode(String zipCode) {
		zipCodeLocator.sendKeys(zipCode);
		return this;
	}

	@Step("Enter Phone Number {0}")
	public RetailCustomerRegistrationPageObjects enterPhoneNumber(String phoneNumber) {
		phoneNumberLocator.sendKeys(phoneNumber);
		return this;
	}

	@Step("Enter State {0}")
	public RetailCustomerRegistrationPageObjects chooseState(String state) {
	

		if(state.equals(""))
		{
				
		}
		else
		{
		Select select = new Select(stateDropdownLocator);
		select.selectByVisibleText(state);
		}
		return this;
		
	}

	@Step("click I Accept")
	public RetailCustomerRegistrationPageObjects clickOnIAccept() {
		iAcceptLocator.click();
		return this;
	}

	@Step("verify Expected error message to be {0}")
	public RetailCustomerRegistrationPageObjects verifyErrorMsg(String expectedErrorMsg) throws Exception{
		Thread.sleep(1500);
		Assert.assertEquals(errorMsgLocator.getText().replace("\n", "").trim(), expectedErrorMsg.trim());
		return this;
	}

	@Step("verify success message is {0}")
	public RetailCustomerRegistrationPageObjects verifySuccessMsg(String successMsg) throws Exception{
		Thread.sleep(3000);
		Waiting.explicitWaitVisibilityOfElement(retailRegistrationSuccessMessageLocator, 10);
		Assert.assertTrue(retailRegistrationSuccessMessageLocator.isDisplayed(),"Retail Registration success Message is not displayed.");
		Assert.assertEquals(retailUserSuccessMsgTextLocator.getText().replace("\n", "").trim(),successMsg);
		return this;
	}
}
