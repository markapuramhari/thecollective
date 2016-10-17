package org.etna.customer.pageobjects.changepassword;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ChangePasswordPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//span[contains(text(),'User Name')]/following-sibling::b")
	private WebElement userNameLabelLocator;
	
	@FindBy(id="oldPassword")
	private WebElement oldPasswordLocator;

	
	@FindBy(id="newPassword")
	private WebElement newPasswordLocator;
	
	@FindBy(id="confirmPassword")
	private WebElement confirmPasswordLocator;
	
	@FindBy(id="updateBtn")
	private WebElement saveButtonLocator;
	
	@FindBy(id="message")
	private WebElement successMsgLocator;
	
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButtonLocator;
	
	@FindBy(xpath="//h2[text()='Change Password']")
	private WebElement changePasswordHeadingLocator;
	
	@FindBy(xpath="//li[text()='Change Password']")
	private WebElement changePasswordBreadcrumbLocator;
	
	
	@FindAll(value={@FindBy(xpath="//span[@class='required']/ancestor::li/input")})
	private List<WebElement> mandatoryFieldsLocator;
	
	
	@FindBy(xpath="//div[@class='cimm_caption']")
	private WebElement pleaseNoteLocator;

    @FindBy(xpath = "//span[@id='errorMsg']")
    private WebElement errorMsgLocator;
	
	
	
	@Step("verify username label {0}")
	public ChangePasswordPageObjects verifyUserNamePrefill(String userNameForPasswordChange) {
		Assert.assertEquals(userNameLabelLocator.getText().trim(), userNameForPasswordChange,"User name is not prefilled");
		return this;
	}



	public ChangePasswordPageObjects verifyChangePasswordPage(String pleaseNoteText) throws Exception {
		Assert.assertTrue(oldPasswordLocator.isDisplayed(),"Old Password text box is not displayed.");
		Assert.assertTrue(newPasswordLocator.isDisplayed(),"New Password text box is not displayed.");
		Assert.assertTrue(confirmPasswordLocator.isDisplayed(),"Confirm Password text box is not displayed.");
		Assert.assertTrue(saveButtonLocator.isDisplayed(),"Save Button is not displayed.");
		Assert.assertTrue(cancelButtonLocator.isDisplayed(),"Cancel Button is not displayed.");
		Assert.assertTrue(changePasswordHeadingLocator.isDisplayed(),"Change Password Heading is not displayed.");
		Assert.assertTrue(changePasswordBreadcrumbLocator.isDisplayed(),"Change Password Breadcrumb is not displayed.");
		Assert.assertEquals(pleaseNoteLocator.getText().trim(),pleaseNoteText,"Please note is not displayed.");
		Assert.assertEquals(driver.getTitle().trim(),"Change Password | "+setUp.getProductName());
		return this;
	}


	@Step("verify Mandatory fields")
	public ChangePasswordPageObjects verifyMandatoryFields(String changePasswordMandatoryFields[]) {
		for(int i =0 ; i<mandatoryFieldsLocator.size() ; i++)
		{
		Assert.assertEquals(mandatoryFieldsLocator.get(i).getAttribute("id"), changePasswordMandatoryFields[i],"Mandatory field is not "+changePasswordMandatoryFields[i]);	
		}
		
		return this;
	}


    @Step("enter old password {0}")
    public ChangePasswordPageObjects enterOldPassword(String oldPassword) {
        oldPasswordLocator.sendKeys(oldPassword);
        return this;
    }

    @Step("enter new password {0}")
    public ChangePasswordPageObjects enterNewPassword(String newPassword) {
        newPasswordLocator.sendKeys(newPassword);
        return this;
    }

    @Step("enter confirm password {0}")
    public ChangePasswordPageObjects enterConfirmPassword(String confirmPassword) {

        confirmPasswordLocator.sendKeys(confirmPassword);
        return this;
    }

    @Step("verify whether error msg is {0}")
    public ChangePasswordPageObjects verifyErrorMsg(String expectedErrorMessage) {
    	Waiting.explicitWaitVisibilityOfElement(errorMsgLocator, 10);
        Assert.assertEquals(errorMsgLocator.getText().replace("\n","").trim(),expectedErrorMessage,"Error message is wrong.!");
        return this;
    }

    @Step("click on save button")
    public ChangePasswordPageObjects clickOnSaveButton() {
        saveButtonLocator.click();
        return this;
    }



	public ChangePasswordPageObjects verifyTabFocusTopToBottom(String oldPasswordId, String newPasswordId, String confirmPasswordId,
			String saveButtonId, String cancelButtonText) {
		oldPasswordLocator.click();
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),oldPasswordId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),newPasswordId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),confirmPasswordId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),saveButtonId);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getText().trim(),cancelButtonText);
		return this;
	}



	public ChangePasswordPageObjects hitTopToToBottom(int numberOfTimesToHitTab) {
		oldPasswordLocator.click();
		for(int i = 0 ; i<numberOfTimesToHitTab ; i++)
		{
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
		}
		return this;
	}



	public ChangePasswordPageObjects verifyTabFocusBottomToTop(String cancelButtonText, String saveButtonId, String confirmPasswordId,
			String newPasswordId, String oldPasswordId) {
		
		String tabBehind = Keys.chord(Keys.SHIFT,Keys.TAB);
		Assert.assertEquals(driver.switchTo().activeElement().getText().trim(),cancelButtonText);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),saveButtonId);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),confirmPasswordId);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),newPasswordId);
		driver.switchTo().activeElement().sendKeys(tabBehind);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),oldPasswordId);
		return this;
	}



	public ChangePasswordPageObjects verifySuccessMsg(Object passwordChangeSuccessMsg) {
		Waiting.explicitWaitVisibilityOfElement(successMsgLocator, 8);
		Assert.assertEquals(successMsgLocator.getText().trim(), passwordChangeSuccessMsg,"Success message is wrong.");
		return this;
		
	}
}