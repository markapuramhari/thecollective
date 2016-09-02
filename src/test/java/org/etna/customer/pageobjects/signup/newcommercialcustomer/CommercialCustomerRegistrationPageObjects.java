package org.etna.customer.pageobjects.signup.newcommercialcustomer;
import java.util.List;

import org.etna.customer.pageobjects.signup.retailuser.RetailCustomerRegistrationPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.RandomGenerator;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CommercialCustomerRegistrationPageObjects extends PageFactoryInitializer{


	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='firstName2AB']")
	private WebElement firstNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='lastName2AB']")
	private WebElement lastNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='companyName2AB']")
	private WebElement companyNameLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='emailAddress2AB']")
	private WebElement emailAddressLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='password2AB']")
	private WebElement passwordLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='confirmPassword2AB']")
	private WebElement confirmPasswordLocator;
	
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='billingAddress2AB']")
	private WebElement address1Locator;
	
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='suiteNo2AB']")
	private WebElement address2Locator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='cityName2AB']")
	private WebElement cityLocator;
	
	
	@FindBy(xpath="//span[@id='changeState']/select[@id='stateName1B']")
	private WebElement stateDropdownLocator;
	
	@FindBy(xpath="//div[@id='countrySelect_chosen']/a")
	private WebElement countryLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='phoneNo2AB']")
	private WebElement phoneNumberLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@id='zipCode2AB']")
	private WebElement zipCodeLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::input[@value='I Accept']")
	private WebElement iAcceptLocator;
	
	@FindBy(xpath="//form[contains(@action,'CommercialReg')]/descendant::div[@class='center']")
	private WebElement agreementLocator;
	
	@FindBy(xpath="//span[@id='errorMsg']")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//div[@id='registrationComplete']")
	private WebElement registrationSuccessMessageLocator;
	
	@FindBy(xpath="//div[@id='stateName1B_chosen']/descendant::a")
	private WebElement stateDropdown;
	
	
	@FindAll(value={@FindBy(xpath="//div[@id='stateName1B_chosen']/div/descendant::li")})
	private List<WebElement> stateDrodpdownOptions;
	
	@Step("verify new commercial customer tab")
	public CommercialCustomerRegistrationPageObjects verifyNewCommercialCustomerTab() throws Exception{
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
	public CommercialCustomerRegistrationPageObjects enterEmailId(String emailId) {
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
		emailAddressLocator.sendKeys(emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1]);
		}
		return this;
	}


	@Step("Enter first name {0}")
	public CommercialCustomerRegistrationPageObjects enterFirstName(String firstName) {
		firstNameLocator.sendKeys(firstName);
		return this;
	}


	@Step("Enter last name {0}")
	public CommercialCustomerRegistrationPageObjects enterLastName(String lastName) {
		lastNameLocator.sendKeys(lastName);
		return this;
	}

	@Step("Enter company name {0}")
	public CommercialCustomerRegistrationPageObjects enterCompanyName(String companyName) {
		companyNameLocator.sendKeys(companyName);
		return this;
	}

	@Step("Enter password {0}")
	public CommercialCustomerRegistrationPageObjects enterPassword(String password) {
		passwordLocator.sendKeys(password);
		return this;
	}

	@Step("Enter confirm password {0}")
	public CommercialCustomerRegistrationPageObjects enterConfirmPassword(String confirmPassword) {
		confirmPasswordLocator.sendKeys(confirmPassword);
		return this;
	}

	@Step("Enter address1 {0}")
	public CommercialCustomerRegistrationPageObjects enterAddress1(String address1) {
		address1Locator.sendKeys(address1);
		return this;
	}

	@Step("Enter address2 {0}")
	public CommercialCustomerRegistrationPageObjects etnerAddress2(String address2) {
		address2Locator.sendKeys(address2);
		return this;
	}

	@Step("Enter city {0}")
	public CommercialCustomerRegistrationPageObjects enterCity(String city) {
		cityLocator.sendKeys(city);
		return this;
	}

	@Step("Enter Zip Code {0}")
	public CommercialCustomerRegistrationPageObjects enterZipCode(String zipCode) {
		zipCodeLocator.sendKeys(zipCode);
		return this;
	}

	@Step("Enter Phone Number {0}")
	public CommercialCustomerRegistrationPageObjects enterPhoneNumber(String phoneNumber) {
		phoneNumberLocator.sendKeys(phoneNumber);
		return this;
	}

	@Step("Enter State {0}")
	public CommercialCustomerRegistrationPageObjects chooseState(String state) throws Exception {
		
		Thread.sleep(3000);
		if(state.equals(""))
		{
				
		}
		else
		{
			
			stateDropdown.click();
		Waiting.explicitWaitVisibilityOfElements(stateDrodpdownOptions, 3);
		for(WebElement stateOption : stateDrodpdownOptions)
		{
			if(stateOption.getText().trim().equals(state))
			{
				stateOption.click();
				break;
			}
		}
		/*Select select = new Select(stateDropdownLocator);
		select.selectByVisibleText(state);*/
		}
		return this;
		
	}

	@Step("click I Accept")
	public CommercialCustomerRegistrationPageObjects clickOnIAccept() {
		iAcceptLocator.click();
		return this;
	}

	@Step("verify Expected error message to be {0}")
	public CommercialCustomerRegistrationPageObjects verifyErrorMsg(String expectedErrorMsg) throws Exception{
		Thread.sleep(1500);
		Assert.assertEquals(errorMsgLocator.getText().replace("\n", "").trim(), expectedErrorMsg.trim());
		return this;
	}

	public CommercialCustomerRegistrationPageObjects verifySuccessMsg(String emailId,String successMsg) throws InterruptedException {
		Thread.sleep(3000);
		Waiting.explicitWaitVisibilityOfElement(registrationSuccessMessageLocator, 10);
		Assert.assertTrue(registrationSuccessMessageLocator.isDisplayed(),"Retail Registration success Message is not displayed.");
		Assert.assertEquals(registrationSuccessMessageLocator.getText().replace("\n", "").trim(),emailId + " "+successMsg);
		return this;
		
	}

	public CommercialCustomerRegistrationPageObjects enterEmailIdForPositiveFlow(String emailId) {
		emailAddressLocator.sendKeys(emailId);
		return this;
	}
}
