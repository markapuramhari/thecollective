package org.thecollective.modules;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class MyAccountModuleTest extends PageFactoryInitializer{
	
	SearchDataPropertyFile data= new SearchDataPropertyFile();
	
	
	@Description("this test case verifies the my account page details")
	@TestCaseId("TC_MyAct_001")
	@Features("MyAccountModule")
	@Test(enabled=true,groups={"MyAccountModule","smoke","regression"})
	public void verifyMyAccountPage() throws InterruptedException
	{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.mouseHoverOverOnMyAccount()
		.verifyWelcomeMessage();
		homePage().logout();
	}
	@Description("this test case verifies the saved items page details")
	@TestCaseId("TC_MyAct_002")
	@Features("MyAccountModule")
	@Test(enabled=true,groups={"MyAccountModule","smoke","regression"})
	public void verifySavedItems() throws InterruptedException
	{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.navigateToSavedItemsPage()
		.myAccountPage()
		.verifySavedItemsPage();
		homePage().logout();
	}

	@Description("this test case verifies order History page details")
	@TestCaseId("TC_MyAct_003")
	@Features("MyAccountModule")
	@Test(enabled=true,groups={"MyAccountModule","smoke","regression"})
	public void verifyMyOrdersPage() throws InterruptedException
	{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.navigateToMyOrdersPage()
		.myAccountPage()
		.verifyMyOrdersPage();
		homePage().logout();
	}
	@Description("this test case verifies recent, past order tabs")
	@TestCaseId("TC_MyAct_004")
	@Features("MyAccountModule")
	@Test(enabled=true,groups={"MyAccountModule","smoke","regression"})
	public void verifyMyOrdersPageTabs() throws InterruptedException
	{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.navigateToMyOrdersPage()
		.myAccountPage()
		.verifyMyOrdersPage()
		.verifyMyOrdersPageTabs();
		homePage().logout();
		
	}
	@Description("this test case verifies recent, past order tabs")
	@TestCaseId("TC_MyAct_004")
	@Features("MyAccountModule")
	@Test(enabled=true,groups={"MyAccountModule","smoke","regression"})
	public void verifyUpdateAddress() throws InterruptedException
	{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.navigateToMyOrdersPage()
		.myAccountPage()
		.clickOnMyAddressTab()
		.verifyMyAddressesPage();
		
	}
}
