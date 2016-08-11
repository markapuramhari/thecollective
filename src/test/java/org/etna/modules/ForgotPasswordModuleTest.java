package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ForgotPasswordModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	  
	@Features("Forgot Password Module")
	@TestCaseId("TC_Forgot_Password_001 To TC_Forgot_Password_004")
	@Description("This is a test case which verifies forgot password error scenarios")
	@Test(groups={"ForgotPasswordModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	public void forgotPassword_ES(String testCaseId,String userName,String emailId,String expectedErrorMessage) throws Exception
		{

		homePage()
		.clickLoginLink()
		.clickOnForgotYourPassword()
		.enterUserName(userName)
		.enterEmailId(emailId)
		.clickOnGetNewPassword()
		.verifyErrorMessage(expectedErrorMessage);	  		
		}
	
	
	/*@Features("Forgot Password Module")
	@TestCaseId("TC_Forgot_Password_005")
	@Description("This is a test case which verifies forgot password positive scenario")
	@Test(groups={"ForgotPasswordModule","regression"},enabled=false)
	public void verifyForgotPasswordPositiveScenario(String testCaseId,String userName,String emailId,String expectedErrorMessage) throws Exception
		{

		homePage()
		.clickLoginLink()
		.clickOnForgotYourPassword()
		.enterUserName(userName)
		.enterEmailId(emailId)
		.clickOnGetNewPassword()
		.verifyErrorMessage(expectedErrorMessage);	  		
		}
*/
}
