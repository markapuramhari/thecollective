package org.etna.modules;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;


import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;

public class APAModuleTest extends PageFactoryInitializer {

	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	String addNewPurchasingAgentBreadcrump = data.getAddNewPurchasingAgentBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("APA Module")
	@Description("This is a test case which verifies whether Add new Purchasing Agent, Manage Purchasing Agent and Delete Purchasing Agent is displayed in the user account dropdown.")
	@TestCaseId("TC_APA_001")
	@Test(groups={"regression"})
	public void verifyDisplayOfManageAddDisablePAafterSuperUserLogin() throws Exception{
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.verifyAddManageDisablePANewPurchasingAgentIsDisplayedInUserAccountDropdown();	
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies the Add new Purchasing Agent page.")
	@TestCaseId("TC_APA_002,TC_APA_050")
	@Test(groups={"regression"})
	 public void verifyAddNewPA_afterSuperUserLogin_VerifyBreadcrumpOfAddNewPurchasingAgent() throws Exception{
		
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.verifyAddNewPurchasingAgentPageName(addNewPurchasingAgentBreadcrump)
		.verifyAddNewPurchasingAgentInstructions()
		.verifyAddNewPurchasingEmailAddressTextbox()
		.verifyMandatoryFields()
		.verifyDisplayOfEmailAddressInstruction()
		.verifyDisplayOfFirstNameTextbox()
		.verifyDisplayOfLastNameTextbox()
		.verifyDisplayOfPasswordTextbox()
		.verifyDisplayOfConfirmPasswordTextbox()
		.verifyDisplayOfAddress1Textbox()
		.verifyDisplayOfAddress2Textbox()
		.verifyDisplayOfCityTextbox()
		.verifyDisplayOfZipCodeTextbox()
		.verifyDisplayOfPhoneNumberTextbox()
		.verifyDisplayOfFaxNumberTextbox()
		.verifyDisplayOfWebsiteTextbox()
		.verifyDisplayOfSubmitButton()
		.verifyUseEntityAddressCheckbox()
		.verifyRoleChosenDropdown()
		.verifyCountryDropdown()
		.verifyStateDropdown()
		.verifyAddNewPurchasingAgentBreadcrump(addNewPurchasingAgentBreadcrump);
}
	
	@Features("APA Module")
	@Description("These are a bunch of test cases that tests the error scenarios involved during Add New Purchasing Agent.")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void addAndDeleteNew_GU_SU_APA(String testCaseId,@Parameter("Email ID") String emailId,@Parameter("First Name") String firstName,@Parameter("Last Name") String lastName,@Parameter("Password") String password,@Parameter("Confirm Password") String confirmPassword,@Parameter("Address 1") String address1,@Parameter("Address 2") String address2,@Parameter("City") String city,@Parameter("State") String state,@Parameter("Zip Code") String zipCode,@Parameter("Phone Number") String phoneNumber,@Parameter("Role Assignment") String roleAssignment,@Parameter("Fax Number") String faxNumber,@Parameter("Website") String website) throws Exception
	{
		String emailIdSplit []  = emailId.split("@");
		String email = emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1];
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.enterEmailIdForSuccessfulCreation(email)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.enterAddress1(address1)
		.etnerAddress2(address2)
		.enterCity(city)
		.enterZipCode(zipCode)
		.enterPhoneNumber(phoneNumber)
		.enterFaxNumber(faxNumber)
		.website(website)
		.chooseRoleAssignment(roleAssignment)
		.chooseState(state)
		.clickOnSubmit()
		.verifyCreationOfAddNewPurchasingAgent(email,firstName,lastName)
		.homePage()
		.clickOnManagePurchasingAgent()
		.searchForTheEmailId(email)
		.clickOnSpecificDisableButton(email)
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForDisableOfUser());
		Thread.sleep(4000);
		managePurchasingAgentPage()
		.searchForTheEmailId(email)
		.verifyDisableOfUser(email);
		
	}
	
	@Features("APA Module")
	@TestCaseId("TC_APA_004")
	@Description("This is a test case which makes sure that for a general user the checkout button is not displayed.")
	@Test(groups={"regression"})
	public void generalUserLoginCheckoutButtonNotDisplayedInCart() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage()
		.searchText(data.getSearchTextForUPCLabelTest())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.verifyMyCartBreadcrump(data.getMyCartBreadcrump())
		.verifyMyCartPagename(data.getMyCartBreadcrump())
		.verifyMyCartTitle(data.getMyCartBreadcrump())
		.verifyCheckoutButtonNotDisplayedInMyCartPage()
		.verifyButtonsAvailableForGeneralUserInMyCart();
	}
	
	@Features("APA Module")
	@Description("These are a bunch of test cases that tests the error scenarios involved during Add New Purchasing Agent.")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void addNewPA_errorScenarios(String testCaseId,@Parameter("Email ID") String emailId,@Parameter("First Name") String firstName,@Parameter("Last Name") String lastName,@Parameter("Password") String password,@Parameter("Confirm Password") String confirmPassword,@Parameter("Address 1") String address1,@Parameter("Address 2") String address2,@Parameter("City") String city,@Parameter("State") String state,@Parameter("Zip Code") String zipCode,@Parameter("Phone Number") String phoneNumber,@Parameter("Role Assignment") String roleAssignment,@Parameter("Fax Number") String faxNumber,@Parameter("Website") String website,@Parameter("Error Message") String expectedErrorMsg) throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.enterEmailId(emailId)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.enterAddress1(address1)
		.etnerAddress2(address2)
		.enterCity(city)
		.enterZipCode(zipCode)
		.enterPhoneNumber(phoneNumber)
		.enterFaxNumber(faxNumber)
		.website(website)
		.chooseRoleAssignment(roleAssignment)
		.chooseState(state)
		.clickOnSubmit()
		.verifyErrorMsg(expectedErrorMsg);
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies the cancelling funcationality after we click on disable button in manage purchasing agent.")
	@Test(groups={"regression"})
	@TestCaseId("TC_PA_087")
	public void cancel_afterClickingOnDisableButton_ManagePurchaseAgent() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String emailId = homePage()
		.clickOnUserAccountDropdown()
		.clickOnManagePurchasingAgent()
		.getSpecficEmailId(1);
		managePurchasingAgentPage()
		.clickOnSpecificDisableButton(1);
		TestUtility.alertDismiss();
		Thread.sleep(2500);
		managePurchasingAgentPage()
		.verifyDisplayOfEmailId(emailId);
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies the cancelling funcationality after we click on disable button in disable purchasing agent.")
	@Test(groups={"regression"})
	@TestCaseId("TC_PA_087")
	public void cancel_afterClickingOnDisableButton_DisablePurchaseAgent() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String emailId = homePage()
		.clickOnUserAccountDropdown()
		.clickOnDisablePurchasingAgent()
		.getSpecficEmailId(1);
		disablePurchaseAgentPage()
		.clickOnSpecificDisableButton(1);
		TestUtility.alertDismiss();
		Thread.sleep(2500);
		disablePurchaseAgentPage()
		.verifyDisplayOfEmailId(emailId);
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies disable purchase agent page.")
	@Test(groups={"regression"})
	@TestCaseId("TC_PA_086")
	public void verify_Disable_Purchase_Agent_Page() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().clickOnDisablePurchasingAgent().verifyDisablePurchaseAgentPage();
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies disabling searching and disabling a purchase agent in purchase agent page.")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("TC_PA_088")
	public void verify_Disable_PADPA(String testCaseId,@Parameter("Email ID") String emailId,@Parameter("First Name") String firstName,@Parameter("Last Name") String lastName,@Parameter("Password") String password,@Parameter("Confirm Password") String confirmPassword,@Parameter("Address 1") String address1,@Parameter("Address 2") String address2,@Parameter("City") String city,@Parameter("State") String state,@Parameter("Zip Code") String zipCode,@Parameter("Phone Number") String phoneNumber,@Parameter("Role Assignment") String roleAssignment,@Parameter("Fax Number") String faxNumber,@Parameter("Website") String website) throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser();
		String emailIdSplit []  = emailId.split("@");
		String email = emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1];

		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.enterEmailIdForSuccessfulCreation(email)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.enterAddress1(address1)
		.etnerAddress2(address2)
		.enterCity(city)
		.enterZipCode(zipCode)
		.enterPhoneNumber(phoneNumber)
		.enterFaxNumber(faxNumber)
		.website(website)
		.chooseRoleAssignment(roleAssignment)
		.chooseState(state)
		.clickOnSubmit()
		.verifyCreationOfAddNewPurchasingAgent(email,firstName,lastName)
		.homePage()
		.clickOnDisablePurchasingAgent()
		.searchForTheEmailId(email)
		.clickOnSpecificDisableButton(email)
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForDisableOfAPA());
		Thread.sleep(4000);
		managePurchasingAgentPage()
		.searchForTheEmailId(email)
		.verifyDisableOfUser(email);
	}
	
	
	@Features("APA Module")
	@Description("This is a test case which verifies approval cart functionality which is verified by a super user.")
	@Test(groups={"regression"})
	@TestCaseId("TC_PA_089")
	public void verifyApprovalCartFunctionality_SuperUser() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		int purchaseOrder = RandomGenerator.generateEightRandomNumbers();
		homePage()
		.searchText(data.getSearchText())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSubmitCartForApproval()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForSubmitCartForApproval())
		.homePage()
		.logout();
		loginModule.loginAsASuperUser();
		String productName = homePage()
		.clickOnUserAccountDropdown()
		.clickOnApprovalCartList()
		.clickOnLatestGeneralUserAccountLinkWhileSubmmitedCartForApproval(data.getGeneralUserEmailID())
		.getSpecificProductNameInShoppingCart();
		myProductGroupsPage()
		.clickOnSelectAllCheckbox()
		.approvedCartPage()
		.clickOnApproveCart();
		checkoutPage()
		.enterPhoneNumber(data.getPhoneNumber())
		.clickOnNextButton()
		.enterEmailId(data.getUserName())
		.enterShippingPhoneNumber(data.getPhoneNumber())
		.clickOnNextButton()
		.selectOrderType(data.getOrderType())
		.enterOrderedBy(data.getCompanyNameForRegistration())
		.enterPurchaseOrderNumber(Integer.toString(purchaseOrder))
		.selectShipMethod(data.getShipVia())
		.enterShippingInstructions(data.getShippingInstructions())
		.enterOrderNotes(data.getOrderNote())
		.clickOnNextButton()
		.verifyNameOfTheProductInItemDetailsTab(productName)
		.clickOnSubmitOrderButton()
		.verifyOrderConfirmationPage(productName,data.getOrderInfoLabelsInOrderConfirmationPage().split(","),Integer.toString(purchaseOrder),data.getCompanyNameForRegistration(),data.getShipVia());	
		}
	
	@Features("APA Module")
	@Description("This is a test case which verifies approval cart functionality which is verified by a Authorizing purchase agent.")
	@Test(enabled=false,groups={"regression"})
	@TestCaseId("TC_PA_090")
	public void verifyApprovalCartFunctionality_APA() throws Exception {
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		int purchaseOrder = RandomGenerator.generateEightRandomNumbers();
		homePage()
		.searchText(data.getSearchText())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSubmitCartForApproval()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForSubmitCartForApproval())
		.homePage()
		.logout();
		loginModule.login(data.getAPAUserID(), data.getAPAPassword());
		String productName = homePage()
		.clickOnUserAccountDropdown()
		.clickOnApprovalCartList()
		.clickOnLatestGeneralUserAccountLinkWhileSubmmitedCartForApproval(data.getGeneralUserEmailID())
		.getSpecificProductNameInShoppingCart();
		myProductGroupsPage()
		.clickOnSelectAllCheckbox()
		.approvedCartPage()
		.clickOnApproveCart();
		checkoutPage()
		.clickOnNextButton()
		.enterEmailId(data.getUserName())
		.clickOnNextButton()
		.selectOrderType(data.getOrderType())
		.enterOrderedBy(data.getCompanyNameForRegistration())
		.enterPurchaseOrderNumber(Integer.toString(purchaseOrder))
		.selectShipMethod(data.getShipVia())
		.enterShippingInstructions(data.getShippingInstructions())
		.enterOrderNotes(data.getOrderNote())
		.clickOnNextButton()
		.verifyNameOfTheProductInItemDetailsTab(productName)
		.clickOnSubmitOrderButton()
		.verifyOrderConfirmationPage(productName,data.getOrderInfoLabelsInOrderConfirmationPage().split(","),Integer.toString(purchaseOrder),data.getCompanyNameForRegistration(),data.getShipVia());	
}
	
	
	@Features("APA Module")
	@Description("This is a test case which verifies reject cart functionality")
	@Test(groups={"regression"})
	@TestCaseId("TC_PA_091")
	public void verifyRejectCartFunctionality() throws Exception {
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage()
		.searchText(data.getSearchText())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSubmitCartForApproval()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForSubmitCartForApproval())
		.homePage()
		.logout();
		loginModule.loginAsASuperUser();
		String cartToBeRejected = homePage()
		.clickOnUserAccountDropdown()
		.clickOnApprovalCartList()
		.getSpecificNameOfTheApprovalCartToBeClicked(data.getGeneralUserEmailID(),1);
		approvalCartListPage()
		.clickOnLatestGeneralUserAccountLinkWhileSubmmitedCartForApproval(data.getGeneralUserEmailID())
		.clickOnRejectCart()
		.enterReason(data.getReasonForRejectCart())
		.clickOnSubmit()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForApprovalCartReject())
		.approvalCartListPage()
		.verifyDeletionOfApprovalCart(cartToBeRejected);
	}
	
	/*@Features("APA Module")
	@Description("This is a test case which verifies reject cart functionality")
	@Test(groups={"regression"})
	@TestCaseId("TC_APA_092")
	public void clickingOnUpdateSelectedItemsFunctionalityWithoutSelectingAnItem() throws Exception {
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage()
		.searchText(data.getSearchText())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSubmitCartForApproval()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForSubmitCartForApproval())
		.homePage()
		.logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnApprovalCartList()
		.approvalCartListPage()
		.clickOnLatestGeneralUserAccountLinkWhileSubmmitedCartForApproval(data.getGeneralUserEmailID())
		.clickOnUpdateSelectedItems()
		.myProductGroupsPage()
		.verifyAlertText(data.getAlertTextForClickingOnUpdateSelectedItemsWithoutSelectingAnyItem());
	}*/
}
