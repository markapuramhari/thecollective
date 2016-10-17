package org.etna.modules;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;


public class ChangePasswordTest extends PageFactoryInitializer {

	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest login = new LoginModuleTest();
	
	
	@Features("Change Password Module")
	@Description("Verify the fields in 'Change Password' page")
	@Test(groups={"regression"})
	@TestCaseId("TC_ChangePwd_01,TC_ChangePwd_12,TC_ChangePwd_13,TC_ChangePwd_14")
	public void verifyChangePasswordFields() throws Exception {
			
			login.login(data.getUserNameForPasswordChange(), data.getPasswordForPasswordChange());
			homePage().clickOnUserAccountDropdown().clickOnChangePassword().verifyUserNamePrefill(data.getUserNameForPasswordChange())
			.verifyChangePasswordPage(data.getPleaseNoteTextInChangePasswordPage())
			.verifyMandatoryFields(data.getChangePasswordMandatoryFieldsIds().split(","));
	}
}
