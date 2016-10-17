package org.etna.customer.pageobjects.changepassword;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
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
	
}