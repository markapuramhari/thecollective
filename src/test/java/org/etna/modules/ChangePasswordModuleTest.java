package org.etna.modules;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.PermittedCharacters;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;

public class ChangePasswordModuleTest extends PageFactoryInitializer {

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest login = new LoginModuleTest();

	@Features("Change Password Module")
	@Description("Verify the fields in 'Change Password' page")
	@Test(groups = { "regression" })
	@TestCaseId("TC_ChangePwd_01,TC_ChangePwd_12,TC_ChangePwd_13,TC_ChangePwd_14")
	public void verifyChangePasswordFields() throws Exception {

		login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnChangePassword()
		.verifyUserNamePrefill(data.getUserNameForPasswordChange())
		.verifyChangePasswordPage(data.getPleaseNoteTextInChangePasswordPage())
		.verifyMandatoryFields(data.getChangePasswordMandatoryFieldsIds().split(","));
	}

	@Features("Change Password Module")
	@Test(groups = {
			"regression" }, dataProvider = "mutipleSheetsSingleWorkbook", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	@Description("{1}")
	public void verifyChangePasswordES(String testCaseId, String description,
			String oldPassword, String newPassword, String confirmPassword, String expectedErrorMessage)
			throws Exception {
		
		login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnChangePassword()
		.enterOldPassword(oldPassword)
		.enterNewPassword(newPassword).enterConfirmPassword(confirmPassword).clickOnSaveButton()
		.verifyErrorMsg(expectedErrorMessage.trim());
	}

	@Features("Change Password Module")
	@Test(groups = {
			"regression" }, dataProvider = "mutipleSheetsSingleWorkbook", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	@Description("Verify tab order top to bottom")
	public void cPVerifyTabOrder(String testCaseId, String description, String order, String oldPasswordId,
			String newPasswordId, String confirmPasswordId, String saveButtonId, String cancelButtonText) throws Exception {

		switch (order) {
		
		case "Top to Bottom":
			login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnChangePassword()
			.verifyTabFocusTopToBottom(oldPasswordId,newPasswordId, confirmPasswordId, saveButtonId, cancelButtonText);
			break;
			
		case "Bottom To Top":
			login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnChangePassword()
			.hitTopToToBottom(4)
			.verifyTabFocusBottomToTop(cancelButtonText, saveButtonId, confirmPasswordId, newPasswordId,oldPasswordId);
			break;
		default:
			throw new Exception("Invalid focus option");

		}
		
		throw new Exception("Raise an issue IF old password button is not enabled by default.");

	}
	
	@Features("Change Password Module")
	@Test(priority=1,groups = {"regression" })
	@TestCaseId("TC_ChangePwd_04")
	@Description("Verification of 'Change Password' with valid values")
	public void changePassword() throws Exception {
		String newPassword = RandomGenerator.random(9, PermittedCharacters.ALPHANUMERIC);
		System.out.println(newPassword);
		try
		{
		login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
		homePage().logout();
		login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnChangePassword()
		.enterOldPassword(data.getPasswordForPasswordChange())
		.enterNewPassword(newPassword)
		.enterConfirmPassword(newPassword)
		.clickOnSaveButton()
		.verifySuccessMsg(data.getPasswordChangeSuccessMsg())
		.homePage()
		.logout();
		login.login(data.getUserNameForPasswordChange(), newPassword);
		homePage().verifyWelcomeMsg();
		
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertDismiss();
			throw new Exception("Unhandled Alert");
		}
		finally{
			FileInputStream in = new FileInputStream(searchData);
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(searchData);
			props.setProperty("passwordForPasswordChange", newPassword);
			props.store(out, null);
			out.close();
		}
	}
}
