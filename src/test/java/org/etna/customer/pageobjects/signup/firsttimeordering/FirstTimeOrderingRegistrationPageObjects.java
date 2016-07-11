package org.etna.customer.pageobjects.signup.firsttimeordering;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.RandomGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class FirstTimeOrderingRegistrationPageObjects extends PageFactoryInitializer{


	
	@FindBy(id="accountNo1B")
	private WebElement accountNumberLocator;

	@FindBy(id="firstName1B")
	private WebElement firstNameLocator;
	
	@FindBy(id="lastName1B")
	private WebElement lastNameLocator;
	
	@FindBy(id="emailAddress1B")
	private WebElement emailAddressLocator;
	
	@FindBy(id="newPassword1B")
	private WebElement passwordLocator;
	
	@FindBy(id="newPasswordConfirm1B")
	private WebElement passwordConfirmationLocator;
	
	@FindBy(xpath="//form[contains(@action,'OnAccountReg')]/descendant::input[@value='I Accept']")
	private WebElement iAcceptLocator;
	
	@FindBy(xpath="//form[contains(@action,'OnAccountReg')]/descendant::div[@class='center']")
	private WebElement agreementLocator;
	
	@FindBy(xpath="//span[@id='errorMsg']")
	private WebElement errorMsgLocator;
	
	
	@Step("verify new retail customer tab")
	public FirstTimeOrderingRegistrationPageObjects verifyFirstTimeOrderingTab() {
		Assert.assertTrue(accountNumberLocator.isDisplayed(), "account number locator is not displayed.");
		Assert.assertTrue(lastNameLocator.isDisplayed(), "last name is not displayed.");
		Assert.assertTrue(firstNameLocator.isDisplayed(), "company name is not displayed.");
		Assert.assertTrue(emailAddressLocator.isDisplayed(), "email address is not displayed.");
		Assert.assertTrue(passwordLocator.isDisplayed(), "password is not displayed.");
		Assert.assertTrue(passwordConfirmationLocator.isDisplayed(), "confirm password is not displayed.");
		return this;
	}
	
	@Step("click I Accept")
	public FirstTimeOrderingRegistrationPageObjects clickOnIAccept() {
		iAcceptLocator.click();
		return this;
	}
	
	@Step("Enter email Id {0}")
	public FirstTimeOrderingRegistrationPageObjects enterEmailId(String emailId) {
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
		emailAddressLocator.sendKeys(emailIdSplit[0]+"+"+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1]);
		}
		return this;
	}
	
	@Step("verify Expected error message to be {0}")
	public FirstTimeOrderingRegistrationPageObjects verifyErrorMsg(String expectedErrorMsg) throws Exception{
		Thread.sleep(1500);
		Assert.assertEquals(errorMsgLocator.getText().replace("\n", "").trim(), expectedErrorMsg.trim());
		return this;
	}
	
	@Step("Enter first name {0}")
	public FirstTimeOrderingRegistrationPageObjects enterFirstName(String firstName) {
		firstNameLocator.sendKeys(firstName);
		return this;
	}

	@Step("Enter last name {0}")
	public FirstTimeOrderingRegistrationPageObjects enterLastName(String lastName) {
		lastNameLocator.sendKeys(lastName);
		return this;
	}
	
	@Step("Enter password {0}")
	public FirstTimeOrderingRegistrationPageObjects enterPassword(String password) {
		passwordLocator.sendKeys(password);
		return this;
	}

	@Step("Enter confirm password {0}")
	public FirstTimeOrderingRegistrationPageObjects enterConfirmPassword(String confirmPassword) {
		passwordConfirmationLocator.sendKeys(confirmPassword);
		return this;
	}
}
