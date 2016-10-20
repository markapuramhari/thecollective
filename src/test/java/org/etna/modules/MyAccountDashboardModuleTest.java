package org.etna.modules;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
public class MyAccountDashboardModuleTest extends PageFactoryInitializer{
	
	/*
	 * @author:Hemanth.Sridhar
	 * @author:Varsha.RL
	 */
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	SaveCartModuleTest saveCart = new SaveCartModuleTest();
	MyProductGroupModuleTest myGroup= new MyProductGroupModuleTest();
	LoginModuleTest login = new LoginModuleTest();
	
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_003,TC_AccountDashboard_004")
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
		.verifyEditContactInfoPageTitle(data.getEditContactInfoTitle().trim()+" | "+setUp.getProductName().toUpperCase())
		.verifyEditContactInfoPageName(data.getEditContactInfoTitle().trim())
		.verifyEditContactInfoBreadcrumb(data.getEditContactInfoTitle().trim())
		.verifyDisplayOfEntityAddressCheckbox()
		.verifyDisplayOfUpdateButton();
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
	
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_002")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyMyAccountDropdown() throws Exception
	{
		login.loginAsASuperUser();
		homePage().logout();
		login.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.verifyMyAccountDropdown(data.getExpectedSuperUserAccountDropdown().split(","));
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_005")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyProfileTabPage() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.verifyProfileTab();
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_009")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyLastLoginTimeInProfileTabPage() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, YYYY");
		Date date = new Date();
		String dateForRequiredByDate = dateFormat.format(date);
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.verifyRequiredLastLoginDateFormat(dateForRequiredByDate);
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_010")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyAddressTabPage() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnAddressTab()
		.verifyAddressPage()
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_011")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyValidSearchInAddressTab() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnAddressTab()
		.sendTextToSearchFunction(data.getCompanyNameForRegistration())
		.verifyValidSearchResult(data.getCompanyNameForRegistration())
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_012")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyInValidSearchInAddressTab() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnAddressTab()
		.sendTextToSearchFunction(data.getCustomerPartNumber())
		.verifyInValidSearchResult(data.getInvalidSearchMsg().trim())
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_013")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyItemPerPageDropdown() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnAddressTab()
		.clickOnItemPerPage()
		.clickOnItemPerPageOption(10)
		.verifyDisplayOfItems(10)
		.clickOnItemPerPage()
		.clickOnItemPerPageOption(25)
		.verifyDisplayOfItems(25)
		.clickOnItemPerPage()
		.clickOnItemPerPageOption(50)
		.verifyDisplayOfItems(50)
		.clickOnItemPerPageOption(100)
		.verifyDisplayOfItems(100)
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_014")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyGroupsTabPageContent() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnGroupsTab()
		.verifyDisplayOfMyProductGroupAndViewMore()
		.verifyDisplayOfMySavedCartAndViewMore()
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_015")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyMyProductFunctionalityUnderGroupsTab() throws Exception{
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		LoginModuleTest loginModule = new LoginModuleTest();
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.clickOnSpecificMyProductGroupButton(1)
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnGroupsTab()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		myGroup.productGroupDeleteAndVerify(myProductGroupName)
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_016")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyViewMoreUnderMyProductGroup() throws Exception
	{
		String expectedPageName=data.getMyProductGroupsPageName().toUpperCase();
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnGroupsTab()
		.clickOnViewMoreUnderMyProductGroup()
		.myProductGroupsPage()
		.verifyPageName(expectedPageName.trim());
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_017")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyMySavedCartFunctionalityUnderGroupsTab() throws Exception{
		String searchText = data.getSearchTextForMPNTest();
		String saveCartName = data.getSaveCartName();
		LoginModuleTest loginModule = new LoginModuleTest();
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation()
		.verifySaveCartCreationMessage(saveCartName)
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnGroupsTab()
		.saveCartPage()
		.clickOnTheCreatedSaveCart(saveCartName.trim())
		.verifybreadCrumbs(saveCartName)
		.verifyPageName(saveCartName);
		saveCart.saveCartDeleteAndVerify(saveCartName)
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_018")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyViewMoreUnderMySavedCart() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnGroupsTab()
		.clickOnViewMoreUnderMySavedCart()
		.verifyMySaveCartPageName(data.getSaveCartBreadcrumb())
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_019")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyOrdersTabPageContent() throws Exception
	{
		login.loginAsASuperUser();
		homePage().logout();
		login.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnOrdersTab()
		.verifyOrdersTabPageContent(data.getOrderPageOpenOrdersHeaders().split(","),data.getOrderPageCompletedOrdersHeaders().split(","))
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_020")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifyViewOrderUnderOrdersTab(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception
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
		.clickOnMyAccount()
		.clickOnOrdersTab()
		.verifyOrderDetails(orderDetails)
		.clickOnViewOrder()
		.orderDetailsPage()
		.verifyPageName(data.getOrderNumberBreadCrumb(),orderDetails)
		.verifyOrderDetails(data.getOrderNumberBreadCrumb(),orderDetails);
		;
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_021")
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
		.clickOnMyAccount()
		.clickOnOrdersTab()
		.verifyOrderDetails(orderDetails)
		.clickOnOrderNoUnderOpenOrders()
		.verifyPageName(data.getOrderNumberBreadCrumb(),orderDetails)
		.verifyOrderDetails(data.getOrderNumberBreadCrumb(),orderDetails);
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_022")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyViewAllFunctionalityUnderOpenOrders() throws Exception
	{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.verifyLoginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnOrdersTab()
		.clickOnViewAllInOpenOrders()
		.verifyOpenOrdersPageName();
	}
	@Features("AccountDashboard Module")
	@TestCaseId("TC_AccountDashboard_025")
	@Test(groups={"Account Dashboard Module","regression"})
	public void verifyViewAllFunctionalityUnderCompletedOrders() throws Exception
	{
		login.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		login.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMyAccount()
		.myAccountsPage()
		.clickOnOrdersTab()
		.clickOnViewAllInCompletedOrders()
		.completedOrdersPage()
		.verifyCompletedOrdersPagename();
	}
}
