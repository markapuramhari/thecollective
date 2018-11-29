package org.thecollective.modules;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class CheckoutModuleTest extends PageFactoryInitializer
{
	SearchDataPropertyFile data= new SearchDataPropertyFile();

	@Description("this test case verifies checkout page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_001")
	@Test
	public void veryfyCheckoutPageTest() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyCheckoutPage(productName);
		
	}
	
	@Description("this test case verifies shipping address page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_002")
	@Test(groups={"HomePageModule","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void veryfyShippingAddresTest() throws InterruptedException
	{
	try{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos")
		.listPage()
		.clickOnSpecificProduct(3);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyCheckoutPage(productName)
		.clickOnContinuePaymentsLink()
		.shippingPage()
		.verifyShippingPage();
	}finally
	{
		try{
		homePage()
		.clickLogo()
		.logout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	}
	@Description("this test case verifies removing items from the cart.")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_003")
	@Test(alwaysRun=true)
	public void veryfyRemoveProductsTest() throws InterruptedException{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		pdPage()
		.clickOnMyBag()
		.summaryPage()
		.removeProducts(data.getEmptyCartText())
		.verifyEmptyCartPage(data.getEmptyCartText());
		homePage()
		.clickLogo()
		.logout();
	}
	@Description("this test case verifies payment page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_004")
	@Test
	public void veryfyPaymentTest() throws InterruptedException{
	try{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyCheckoutPage(productName)
		.verifyProductName(productName)
		.clickOnContinuePaymentsLink()
		.shippingPage()
		.verifyShippingPage()
		.paymentPage()
		.verifyPaymentPage();
	}
	finally
	{
		try{
		homePage().logout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
	
	@Description("this test case verifies update quantity in checkout summary page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_005")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void updateQuantityTest() throws InterruptedException
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos")
		.listPage()
		.clickOnSpecificProduct(3);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyQuantityDropdown()
		.updateTheQuantity(data.getUpdatedQuantity())
		.verifyUpdatedQuanity(data.getUpdatedQuantity());
		
	}
	@Description("this test case verifies product price before update in checkout summary page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_006")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void verifyProductPriceBeforeUpdateTest() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice);
		
	
	}
	@Description("this test case verifies updated price in checkout summary page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_007")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void verifyUpdatePriceTest() throws InterruptedException
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyQuantityDropdown()
		.updateTheQuantity(data.getUpdatedQuantity())
		.verifyUpdatedQuanity(data.getUpdatedQuantity())
		.verifyUpdatedPrice(data.getUpdatedQuantity(),productPrice);
		}
	@Description("this test case verifies login link in coupons tab")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_008")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void verifyLoginLinkInCouponsTabTest() throws InterruptedException{
		try
		{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyCouponsTabBeforeLogin();
		}
		finally
		{
			try{
			homePage().logout();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	@Description("this test case verifies login page from coupons tab")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_009")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void verifyLoginPageFromCouponsTabTest() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyCouponsTabBeforeLogin()
		.clickOnLoginLinkInSummaryPage()
		.verifyLoginPageInCheckoutPage(data.getLoginPageNameText());
	}
	
	@Description("this test case verifies login functionality in coupons tab")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_010")
	@Test(groups={"HomePageModule","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void verifyLoginFunctionalityInCouponsTabTest() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyCouponsTabBeforeLogin()
		.clickOnLoginLinkInSummaryPage()
		.verifyLoginPageInCheckoutPage(data.getLoginPageNameText())
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.summaryPage()
		.verifyProductName(productName);
	}
	@Description("this test case verifies login page when user clicks on continue payments in summary page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_011")
	@Test(groups={"HomePageModule","smoke","regression"})
	public void verifyLoginByClickOnContinueInSummaryPage() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyCouponsTabBeforeLogin()
		.clickOnContinuePaymentsLink()
		.verifyLoginSectionInCheckoutPage()
		.verifyOrdrSummaryPrice(productPrice);
		
	}
	@Description("this test case verifies login functionality when user clicks on continue payments in summary page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_012")
	@Test(groups={"HomePageModule","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void verifyLoginFunctionalityInCheckoutPage() throws InterruptedException{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyCouponsTabBeforeLogin()
		.clickOnContinuePaymentsLink()
		.verifyLoginSectionInCheckoutPage()
		.verifyOrdrSummaryPrice(productPrice)
		.loginToSiteFromCheckoutPage(data.getUserName(),data.getPassword())
		.verifyCheckoutPage(productName)
		.verifyProductImage()
		.verifyProductName(productName)
		.verifyCouponsTabAfterLogin();
		
		
	}
	@Description("this test case verifies coupos section in checkout page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_013")
	@Test(groups={"HomePageModule","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void verifyCouponsSectionCheckoutPage() throws Exception{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct(2);
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyProductImage()
		.verifyCouponsTabAfterLogin()
		.clickOnCouponsLink()
		//.clickOnCouponsTab()
		.verifyCouponsSection(data.getCouponsTabOptions());
		
		
	}
	@Description("this test case verifies successful order placement by using cod")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_014")
	@Test(groups={"HomePageModule","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void verifyOrderPlacementByCod() throws Exception
	{
		
		data.setPaymentMethod("Cash on Delivery (COD)");
		String expPaymentMethod=data.getPaymentMethod().trim();
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos")
		.listPage()
		.clickOnProductForCod(expPaymentMethod,data.getMaxAllowedPriceForCod());
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyProductImage()
		.clickOnContinuePaymentsLink();
		String shippingAddress=shippingPage()
		.VerifySavedAddresses()
		.chooseSavedShippingAddressFromTheList()
		.getSelectedShippingAddress();
		shippingPage()
		.clickOnContinuePaymentLinkInShipping()
		.paymentPage()
		.verifyPaymentMethod(expPaymentMethod)
		.selectPaymentMethod(expPaymentMethod)
		.clickOnSubmitOrderButton();
		String orderNumber=orderConfirmation()
		.verifyOrderConfirmationPage(data.getThankingMessage())
		.getOrderNumber();
		orderConfirmation()
		.verifyShippingAddress(shippingAddress);
		homePage()
		.clickLogo()
		.clickOnMyOrders()
		.myAccountPage()
		.verifyOrderNumber(orderNumber);
		}
	@Description("this test case verifies successful order placement by using credit card")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_015")
	@Test(groups={"Checkout Module","smoke","regression"},dependsOnMethods="veryfyRemoveProductsTest")
	public void verifyOrderPlacementByCCO() throws Exception
	{
		try{
		data.setPaymentMethod("Credit Card");
		String expPaymentMethod=data.getPaymentMethod();
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Polos")
		.listPage()
		.clickOnProductForCod(expPaymentMethod,data.getMaxAllowedPriceForCod());
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		String productPrice=pdPage().getProductPrice();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyProductName(productName)
		.verifyProductPriceBeforeUpdate(productPrice)
		.verifyProductImage()
		.clickOnContinuePaymentsLink();
		String shippingAddress=shippingPage()
		.VerifySavedAddresses()
		.chooseSavedShippingAddressFromTheList()
		.getSelectedShippingAddress();
		shippingPage()
		.clickOnContinuePaymentLinkInShipping()
		.paymentPage()
		.verifyPaymentMethod(expPaymentMethod)
		.selectPaymentMethod(expPaymentMethod)
		.clickOnSubmitOrderButton();
		cardPayment().enterCardDetails(data.cardDetails());
		String orderNumber=orderConfirmation()
		.verifyOrderConfirmationPage(data.getThankingMessage())
		.getOrderNumber();
		orderConfirmation()
		.verifyShippingAddress(shippingAddress);
		homePage()
		.clickLogo()
		.clickOnMyOrders()
		.myAccountPage()
		.verifyOrderNumber(orderNumber);
		}finally{
			homePage()
			.clickLogo()
			.logout();
		}
		
	}
	@Description("verify item added to cart from the saved items page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_016")
	@Test(groups={"Checkout Module","Smoke", "Regression"})
	public void verifySavedItemsToShoppingCartTest() throws InterruptedException, AWTException{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.clickOnSearchIcon()
		.enterSearchData("Bags");
		String productName=listPage().getProductName(0);
		listPage().clickOnSpecificProduct(0);
		pdPage()
		.clickOnMyWishListIcon();
		homePage()
		.clickOnWishListIcon()
		.myAccountPage()
		.clickOnSavedItemsTab();
	}
}
