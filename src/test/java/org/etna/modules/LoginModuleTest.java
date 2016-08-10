package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	  public void loginAsASuperUser() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
	  }
	

		public void login(String userName,String password) throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUsernameRegression(userName)
		  .enterPasswordRegression(password)
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
		
		
	@Features("Login Module")
	@Test(groups={"LoginModule","smoke","regression"})
		public void TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
	  

	
	  
	  
	@Features("Login Module")
	@Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="mutipleSheetsSingleWorkbook", dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void loginAs_SU_PA_GU(String testCaseId,String userName,String password,String expectedMsg) throws Exception
			{
			   homePage()
			  .clickLoginLink()
			  .loginPopUp()
			  .enterUsernameRegression(userName)
			  .enterPasswordRegression(password)
			  .clickOnLoginButton()
			  .homePage()
			  .verifyWelcomeMsg(expectedMsg);
			}
	

	@Features("Login Module")
	@Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="mutipleSheetsSingleWorkbook", dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	  public void login_ErrorScenarios(String testCaseId,String userName, String password,String expectedMsg) throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUsernameRegression(userName)
		  .enterPasswordRegression(password)
		  .clickOnLoginButton()
		  .homePage()
		  .assertForErrorMessages(expectedMsg);	
	  }
	  
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TS_Login_001_TC_Login_008_Verify_Tab_focus() throws Exception
	  {
		  
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyDefaultTabFocus(data.getUserNameHTMLID());
		}

	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_009_010_RememberPassword_UserNameAndPasswordRefill() throws Exception
	  {
		  
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_011_AutofillLogin() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_012_uncheckRememberMeWhenInAutoFillForm() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_013_myProductGroupLoginPopupRememberMeClickUncheck() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  String searchText = data.getSearchText();
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnSpecificMyProductGroupButton(1)
		  .loginPopUp()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_015_rememberMeAsALink() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRememberText()
		  .verifyRememberMeCheckBoxSelected();
		}
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_016_TC_Login_017_TC_Login_018_rememberMeCheckboxTest() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckBoxSelected()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckboxNotSelected();
	}

	@Features("Login Module")
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_014_myProductGroupLoginPopupRememberMeClickCheck() throws Exception
	  {  
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  String searchText = data.getSearchText();
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnSpecificMyProductGroupButton(1)
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"})
	  public void TC_Login_021_loginVerifyTabOrderTopToBottom() throws Exception
	  {
		  
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyTabFocusTopToButtom(data.getUserNameHTMLID(),data.getPasswordHTMLId(),data.getForgotYourPasswordHTMLText(),data.getRememberMeHTMLId(),data.getLoginButtonHTMLId());
		}
	
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"})
	  public void TC_Login_021_loginVerifyTabOrderBottomToTop() throws Exception
	  {
		  
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyTabFocusButtomToTop(data.getUserNameHTMLID(),data.getPasswordHTMLId(),data.getForgotYourPasswordHTMLText(),data.getRememberMeHTMLId(),data.getLoginButtonHTMLId());
		}
	
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"})
	  public void TC_Login_020_verifyForgotPasswordPage() throws Exception
	  {
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnForgotYourPassword()
		  .forgotPasswordPage()
		  .verifyRetrievePasswordPage();
		}
	
	@Features("Login Module")
	@Test(groups={"LoginModule","regression"})
	  public void TC_Login_019_verifyRegisterPage() throws Exception
	  {

	 homePage()
	 .clickLoginLink()
	 .loginPopUp()
	 .clickOnSignUp()
	 .signUpPage()
	 .verifyBreadCrump(data.getRegistrationBreadCrump())
	 .verifyRegistrationPageName(data.getRegistrationBreadCrump())
	 .verifyWhetherNewCommercialCustomerIsEnabledFirstAndNewRetailCustomerIsNotEnabledFirst();
	  }
}
