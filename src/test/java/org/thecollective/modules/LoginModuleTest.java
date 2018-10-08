package org.thecollective.modules;

import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{
	
	SearchDataPropertyFile data=new SearchDataPropertyFile();
	SearchDataPropertyFile searchData= new SearchDataPropertyFile();
	
	@TestCaseId("TC_LOGIN_001")
	@Features("Login Module")
	@Description("verify login link in landing page")
	@Test
	public void verifyLoginLinkInLandingPage() throws InterruptedException
	{
		homePage()
		.mouseHoverOverUserProfileBeforeLogin()
		.verifyLoginLink(data.getLoginLinkName());
	}
	@TestCaseId("TC_LOGIN_002")
	@Features("Login Module")
	@Description("verify login link in product list page")
	@Test
	public void verifyLoginLinkInPListPage() throws InterruptedException
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos");
		homePage()
		.mouseHoverOverUserProfileBeforeLogin()
		.verifyLoginLink(data.getLoginLinkName());
		
	}
	
	
@TestCaseId("TC_LOGIN_003")
@Features({"Login","TheCollective"})
@Description("this test case verifies login functionality with valid credentials")
@Test(groups={"HomePageModule","smoke","regression"})
public void loginValid() throws Exception{
	homePage()
	.clickOnLoginLink()
	.loginPage()
	.verifyLoginPage(data.getLoginPageNameText())
	.enterUserName(data.getUserName())
	.enterPassword(data.getPassword())
	.clickOnLoginButton()
	.homePage()
	.verifyUserProfile(data.getProductName(), "My Information"); 
	
}@TestCaseId("TC_LOGIN_004")
@Features({"Login","TheCollective"})
@Description("this test case verifies login functionality with invalid mobile/email")
@Test(groups={"HomePageModule","smoke","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
public void loginInvalid(String tcId,String userName, String password, String mobileOrEmail, String expErrorMessage) throws InterruptedException{
	homePage()
	.clickOnLoginLink()
	.loginPage()
	.verifyLoginPage("Welcome back! Login for seamless shopping.");
	driver.navigate().refresh();
	loginPage()
	.enterUserName(userName)
	.enterPassword(password)
	.clickOnLoginButton()
	.verifyLoginErrorMessage(mobileOrEmail,expErrorMessage);
	
}

}
