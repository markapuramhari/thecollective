package org.thecollective.modules;

import java.io.File;

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
		.clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct();
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyCheckoutPage(productName);
		
	}
	@Description("this test case verifies removing items from the cart.")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_003")
	@Test
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
	}
	@Description("this test case verifies shipping address page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_002")
	@Test
	public void veryfyShippingAddresTest() throws InterruptedException{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct();
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
		
	}
	@Description("this test case verifies payment page")
	@Features("Checkout Module")
	@TestCaseId("TC_Checkout_004")
	@Test
	public void veryfyPaymentTest() throws InterruptedException{
		homePage()
		.clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader("Men", "Jeans")
		.listPage()
		.clickOnSpecificProduct();
		String productName=pdPage()
		.selectSize()		
		.addToBageFromDetailsPage()
		.getTheProductName();
		pdPage().clickOnMyBag()
		.summaryPage()
		.verifyCheckoutPage(productName)
		.clickOnContinuePaymentsLink()
		.shippingPage()
		.verifyShippingPage()
		.paymentPage()
		.verifyPaymentPage();
		
	}
	
	
	
	
	
	
	
	
	
}
