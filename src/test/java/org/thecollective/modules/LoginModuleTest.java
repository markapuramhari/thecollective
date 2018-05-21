package org.thecollective.modules;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{
	
	SearchDataPropertyFile data=new SearchDataPropertyFile();
	
	@TestCaseId("TC_LOGIN_001")
	@Features("Login Module")
	@Description("verify login link in landing page")
	@Test
	public void verifyLoginLinkInLandingPage()
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

}
