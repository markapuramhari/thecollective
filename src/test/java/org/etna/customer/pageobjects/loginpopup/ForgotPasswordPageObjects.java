package org.etna.customer.pageobjects.loginpopup;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ForgotPasswordPageObjects extends PageFactoryInitializer {
	
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//span[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameTextbox;
	
	@FindBy(xpath="//input[@id='emailAddress']")
	private WebElement emailAddressTextBox;
	
	@FindBy(id="submitBtn")
	private WebElement getNewPasswordButton;
	
	@FindBy(className="cimm_caption")
	private WebElement forgotYourPasswordInstructions;
	
	@FindBy(id="errorMsgForgotPassord")
	private WebElement errorMessageLocator;
	
	@Step("verify retrieve password page")
	public ForgotPasswordPageObjects verifyRetrievePasswordPage() {
		Waiting.explicitWaitVisibilityOfElement(loginPopUp().pageName, 5);
		Assert.assertEquals(loginPopUp().pageName.getText().trim(), "FORGOT PASSWORD" , "Page name is not right. I am getting "+loginPopUp().pageName.getText().trim());
		Assert.assertTrue(userNameTextbox.isDisplayed(),"user name textbox is not displayed");
		Assert.assertTrue(emailAddressTextBox.isDisplayed(),"email address text box is not displayed");
		Assert.assertTrue(getNewPasswordButton.isDisplayed(), "retrieve password button is not displayed");
		Assert.assertEquals(getNewPasswordButton.getAttribute("value"),"Get New Password");
		Assert.assertEquals(forgotYourPasswordInstructions.getText().trim(),data.getForgotYourPasswordInstructions());
		return this;
	}
	
	@Step("enter username as {0}")
	public ForgotPasswordPageObjects enterUserName(String userName){
		Waiting.explicitWaitVisibilityOfElement(userNameTextbox, 4);
		userNameTextbox.click();
		userNameTextbox.sendKeys(userName);
		return this;
	}
	
	@Step("enter email id as {0}")
	public ForgotPasswordPageObjects enterEmailId(String emailId){
		emailAddressTextBox.click();
		emailAddressTextBox.sendKeys(emailId);
		return this;
	}
	
	@Step("click on get new password button")
	public ForgotPasswordPageObjects clickOnGetNewPassword(){
		getNewPasswordButton.click();
		return this;
	}

	public ForgotPasswordPageObjects verifyErrorMessage(String expectedErrorMessage) {
		Assert.assertEquals(errorMessageLocator.getText().replace("\n", "").trim(),expectedErrorMessage);	
		return this;
	}
}
