package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;

public class MyAccountDashboardModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Features("AccountDashboard Module")
	@Test(groups={"Account Dashboard Module","regression"})
		public void verifyMyAccountDashboardPage() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnMyAccount()
		  .myAccountsPage()
		  .verifyMyAccountPage();
		}
	
	@Features("AccountDashboard Module")
	@Test(groups={"Account Dashboard Module","regression"})
		public void verifyEditContactInfoPage() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnMyAccount()
		  .myAccountsPage()
		  .clickOnEditContactInfo()
		  .editContactInfoPage()
		  //.verifyEditContactInfoPageTitle(data.getEditContactInfoTitle().trim()+" | "+setUp.getProductName().toUpperCase())
		  .verifyEditContactInfoPageName(data.getEditContactInfoTitle().trim())
		  .verifyEditContactInfoBreadcrumb(data.getEditContactInfoTitle().trim())
		  .verifyEntityAddressCheckbox()
		  .verifyUpdateButton();
		}
	
	@Features("AccountDashboard Module")
	@Test(groups={"Account Dashboard Module","regression"})
		public void verifyImageUpload() throws Exception
		{
		homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnMyAccount()
		  .myAccountsPage()
		  .uploadFile(data.getImagePath().trim())
		  .clickOnUpload()
		  .verifyFileUpload(data.getImagePath().trim());
		}
}
