package org.etna.modules;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;

import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;

public class OrderFulFillmentModuleTest extends PageFactoryInitializer {
	
	LoginModuleTest loginModule = new LoginModuleTest();
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@Features("Order FullFillment Module")
	@Description("This is test case which verifies order fullfillment flow completely.")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void orderFullFillmentFlow(String testCaseId,String emailId,String password,String searchText,String phoneNumber,String orderType,String shipVia,String companyName,String emailIdForConfirmation, String purchaseOrder,String shippingInstructions,String orderNote,String orderInfoLabels) throws Exception
	{
		loginModule.login(emailId, password);
		homePage()
		.logout();
		loginModule.login(emailId, password);
		String productName = homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage().getProductName();
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
		.verifyOrderConfirmationPage(productName,orderInfoLabels.split(","),purchaseOrder,companyName,shipVia);	
	}
	
	@Features("My Cart Module")
	   @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	   public void TC_ShoppingCart_004_signedUser_ShoppingCartQuanitityUpdateWithZero() throws Exception
	   {
	  String searchText = data.getSearchTextForEnlargeImageTest();
	     loginModule.loginAsASuperUser();
	      myCartPage()
	    .clearCart();
	     Thread.sleep(1500);
	     homePage()
	   .searchText(searchText)
	   .clickOnSearch()
	    .productDetailsPage()
	    .clickOnAddToCartButton()
	   .myCartPage()
	   .clickOnCheckoutInMyCartPopup()
	    .enterQuantityInShoppingCart("0")
	    .clickOnUpdateButton()
	    .productListPage()
	    .verifyAlertMessage(data.getInvalidNumberAlertText());
	   }
	
	@Features("Order FullFillment Module")
	@Description("This is test case which verifies message when email address in not provided in shipping details ")
	@Test(groups={"regression"})
	@TestCaseId("TC_ORDERFULLFILLMENT_002")
	public void orderFullFillmentFlow_ErrorScenario_WhenEmailIdIsNotProvidedInShippingDetails() throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().searchText(data.getSearchTextForEnlargeImageTest()).clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnCheckoutInMyCartPage()
		.enterPhoneNumber(data.getPhoneNumber())
		.clickOnNextButton()
		.enterShippingPhoneNumber(data.getPhoneNumber());
		Thread.sleep(1000);
		checkoutPage()
		.clickOnNextButton()
		.verifyEmailAddressRequiredErrorMessage();
	}
	
	@Features("Order FullFillment Module")
	@Description("This is test case which verifies message when email address in not provided in shipping details ")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void orderFullFillmentFlow_ErrorScenariosInOrderDetails(String testCaseId, String orderType,String orderedBy,String purchaseOrder,String errorMessage) throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage().searchText(data.getSearchTextForEnlargeImageTest()).clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnCheckoutInMyCartPage()
		.enterPhoneNumber(data.getPhoneNumber())
		.clickOnNextButton()
		.enterEmailId(data.getUserName())
		.enterShippingPhoneNumber(data.getPhoneNumber())
		.clickOnNextButton();
		Thread.sleep(800);
		checkoutPage()
		.selectOrderType(orderType)
		.enterOrderedBy(orderedBy)
		.enterPurchaseOrderNumber(purchaseOrder)
		.clickOnNextButton()
		.verifyErrorMessage(errorMessage);
	}
}

