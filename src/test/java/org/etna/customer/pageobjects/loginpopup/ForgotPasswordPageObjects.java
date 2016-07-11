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
	
	@FindBy(id="username")
	private WebElement userNameTextbox;
	
	@FindBy(id="emailAddress")
	private WebElement emailAddressTextBox;
	
	@FindBy(id="submitBtn")
	private WebElement getNewPasswordButton;
	
	@FindBy(className="cimm_caption")
	private WebElement forgotYourPasswordInstructions;
	
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
}
