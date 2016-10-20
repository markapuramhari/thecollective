package org.etna.modules;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

public class OrderHistoryModuleTest extends PageFactoryInitializer {
	
	/*
	 * @author:Varsha.RL
	 */
	
	
		SearchDataPropertyFile data = new SearchDataPropertyFile();
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		LoginModuleTest loginModule = new LoginModuleTest();
		
		
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Page Title and breadcrumb")
		@TestCaseId("TC_OrderHistory_001,TC_OrderHistory_002")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifyOrderHistoryPage() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.verifyOrderHistoryPage();
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Completed Order Table")
		@TestCaseId("TC_OrderHistory_003")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifyCompletedOrderTable() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.verifyCompletedOrderTable(data.getCompletedOrderTableHeaders().split(","))
			;
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature without providing PO no")
		@TestCaseId("TC_OrderHistory_004")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithoutPO_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectPoNoInDropdown()
			.clickOnSearchIcon()
			.verifyAlertText(data.getAlertTextForWithoutSearchKeyword());
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature without providing Order no")
		@TestCaseId("TC_OrderHistory_007")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithoutOrder_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectOrderNoInDropdown()
			.clickOnSearchIcon()
			.verifyAlertText(data.getAlertTextForWithoutSearchKeyword());
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature with valid PO#")
		@TestCaseId("TC_OrderHistory_005")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithValidPO_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectPoNoInDropdown()
			.enterTextInSearchBox(data.getSearchTextForEnlargeImageTest())
			.clickOnSearchIcon()
			.verifyDisplayOfPOnoOrOrderNo(data.getSearchTextForEnlargeImageTest());
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature with Invalid PO#")
		@TestCaseId("TC_OrderHistory_006")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithInValidPO_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectPoNoInDropdown()
			.enterTextInSearchBox(data.getZipCodeForRegistration())
			.clickOnSearchIcon()
			.verifyNoDataText(data.getTextMsgForInvalidPoNoOrOrderNo());
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature with valid Order#")
		@TestCaseId("TC_OrderHistory_008")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithValidOrder_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectOrderNoInDropdown()
			.enterTextInSearchBox(data.getSearchTextForEnlargeImageTest())
			.clickOnSearchIcon()
			.verifyDisplayOfPOnoOrOrderNo(data.getSearchTextForEnlargeImageTest());
		}
		@Features("Order History Module")
		@Description("This Test Case Verifies Order History Search feature with Invalid Order#")
		@TestCaseId("TC_OrderHistory_009")
		@Test(groups={"OrderHistoryModule","smoke","regression"})
		public void verifySearchWithInValidOrder_No() throws Exception{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnOrderHistory()
			.orderHistoryPage()
			.clickOnSelectDropdown()
			.selectOrderNoInDropdown()
			.enterTextInSearchBox(data.getZipCodeForRegistration())
			.clickOnSearchIcon()
			.verifyNoDataText(data.getTextMsgForInvalidPoNoOrOrderNo());
		}


}
