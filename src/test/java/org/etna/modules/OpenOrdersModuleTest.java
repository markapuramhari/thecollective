package org.etna.modules;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

public class OpenOrdersModuleTest extends PageFactoryInitializer {
	
	/*
	 * @author:Varsha.RL
	 */
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Open Order Page Title and breadcrumb")
	@TestCaseId("TC_OrderHistory_001")
	@Test(groups={"OpenOrdersModule","smoke","regression"})
	public void verifyOpenOrdersPage() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.verifyOpenOrdersPageName();
	}
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Open Order Page Dispaly from MyAccount")
	@TestCaseId("TC_OrderHistory_002")
	@Test(groups={"OpenOrdersModule","smoke","regression"})
	public void verifyOpenOrdersFromMyAccountPage() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		String title = homePage()
				.clickOnUserAccountDropdown()
				.clickOnOpenOrders()
				.getTitle();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.clickOnOrdersTab()
		.clickOnViewAllInOpenOrders()
		.verifyOpenOrdersTitle(title);
	}
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Open Order Table Headers")
	@TestCaseId("TC_OrderHistory_003")
	@Test(groups={"OpenOrdersModule","smoke","regression"})
	public void verifyOpenOrdersTableHeaders() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.verifyOpenOrdersPageName()
		.verifyHeaders(data.getOrderPageOpenOrdersHeaders().split(","))
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_AccountDashboard_004")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifyNewOpenOrderEntry(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception
	{
		LoginModuleTest loginModule = new LoginModuleTest();
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage().getProductName();
		String	orderDetails [] =
				productDetailsPage()
				.clickOnAddToCartButton().myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnCheckoutInMyCartPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.verifyOrderDetails(orderDetails)
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_OpenOrders_005")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifyFunctionalityOfOrderNo(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception
	{
		LoginModuleTest loginModule = new LoginModuleTest();
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage().getProductName();
		String	orderDetails [] =
				productDetailsPage()
				.clickOnAddToCartButton().myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnCheckoutInMyCartPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.verifyOrderDetails(orderDetails)
		.clickOnOrderNoUnderOpenOrders()
		.verifyPageName(data.getOrderNumberBreadCrumb(),orderDetails)
		.verifyOrderDetails(data.getOrderNumberBreadCrumb(),orderDetails);
	}
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Search Functionality for Order No")
	@TestCaseId("TC_OrderHistory_006")
	@Test(groups={"OpenOrdersModule","smoke","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifySearchFunc_OrderNo(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage().getProductName();
		String	orderDetails [] =
				productDetailsPage()
				.clickOnAddToCartButton().myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnCheckoutInMyCartPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.sendTextToSearchBox(orderDetails[0])
		.verifyTextDisplayForOrderNo(orderDetails[0])
		;
	}
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Search Functionality for PO No")
	@TestCaseId("TC_OrderHistory_007")
	@Test(groups={"OpenOrdersModule","smoke","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifySearchFunc_POno(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage().getProductName();
		String	orderDetails [] =
				productDetailsPage()
				.clickOnAddToCartButton().myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnCheckoutInMyCartPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.sendTextToSearchBox(orderDetails[1])
		.verifyTextDisplayForPONo(orderDetails[1])
		;
	}
	@Features("Open Orders Module")
	@Description("This Test Case Verifies Search Functionality for Ship Date")
	@TestCaseId("TC_OrderHistory_008")
	@Test(groups={"OpenOrdersModule","smoke","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifySearchFunc_ShipDate(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage().getProductName();
		String	orderDetails [] =
				productDetailsPage()
				.clickOnAddToCartButton().myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnCheckoutInMyCartPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.sendTextToSearchBox(orderDetails[2])
		.verifyTextDisplayForShipDate(orderDetails[2])
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_OpenOrders_009,TC_OpenOrders_010")
	@Test(groups={"Open Orders Module","regression"})
	public void verifyItemPerPageDropdown() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.clickOnCountPerPageDown()
		.clickOnItemPerPageOption(10)
		.verifyDisplayOfItems(10)
		.clickOnCountPerPageDown()
		.clickOnItemPerPageOption(25)
		.verifyDisplayOfItems(25)
		.clickOnCountPerPageDown()
		.clickOnItemPerPageOption(50)
		.verifyDisplayOfItems(50)
		.clickOnCountPerPageDown()
		.clickOnItemPerPageOption(100)
		.verifyDisplayOfItems(100)
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_OpenOrders_011")
	@Test(groups={"Open Orders Module","regression"})
	public void verifyReOrderWithoutSelectingItems() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.clickOnReorder()
		.clickOnReorderInOrderDetailsPage()
		.verifyAlertText(data.getAlertForReorderWithNoItemSelected())
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_OpenOrders_012")
	@Test(groups={"Open Orders Module","regression"})
	public void verifyReOrderFunctionality() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.clickOnReorder()
		.clickOnSelectItem()
		.clickOnReorderInOrderDetailsPage()
		.verifyPageName()
		;
	}
	@Features("Open Orders Module")
	@TestCaseId("TC_OpenOrders_013")
	@Test(groups={"Open Orders Module","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifyReOrderFuncAndCheckout(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.clickOnReorder()
		.clickOnSelectItem()
		.clickOnReorderInOrderDetailsPage()
		.verifyPageName();
		String productName = openOrdersPage().getProductName();
		openOrdersPage()
		.clickOnCheckout();
		String	orderDetails [] =
				checkoutPage()
				.enterPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.enterEmailId(emailIdForConfirmation)
				.enterShippingPhoneNumber(phoneNumber)
				.clickOnNextButton()
				.selectOrderType(orderType)
				.selectShipMethod(shipVia)
				.enterOrderedBy(companyName)
				.enterPurchaseOrderNumber(purchaseOrder)
				.enterShippingInstructions(shippingInstructions)
				.enterOrderNotes(orderNote)
				.clickOnNextButton()
				.verifyNameOfTheProductInItemDetailsTab(productName)
				.clickOnSubmitOrderButton()
				.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia)
				.getOrderDetails();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnOpenOrders()
		.openOrdersPage()
		.verifyOrderDetails(orderDetails)
		.clickOnOrderNoUnderOpenOrders()
		.verifyPageName(data.getOrderNumberBreadCrumb(),orderDetails)
		.verifyOrderDetails(data.getOrderNumberBreadCrumb(),orderDetails);
	}
}
