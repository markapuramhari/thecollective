package org.etna.modules;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;

public class SaveCartModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	

	public void saveCartDeleteAndVerify(String saveCartName) throws Exception{
		
		 homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCart()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.deleteSaveCart()
			.verifyAlertText(data.getDeleteSaveCartAlertText())
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCart()
			.saveCartPage()
			.verifyDeletionOfSaveCart(saveCartName);
	}
	
	
	
	@Features("Save Cart Module")
	@Test(groups={"SaveCartModule","smoke","regression"},enabled=true)
	  public void TC_ShoppingCart_011_CreateAndDeleteSaveCart() throws Exception
	  {
		  	String searchText = data.getSearchTextForEnlargeImageTest();
			String saveCartName = data.getSaveCartName();
			String saveCartBreadcrump = data.getSaveCartBreadcrump();
			loginModule.loginAsASuperUser();
		  	homePage().logout();
		  	loginModule.loginAsASuperUser();
			myCartPage().clearCart();
			String productName = homePage()
					.searchText(searchText)
					.clickOnSearch()
					.productDetailsPage()
					.getProductName();
					productDetailsPage()
					.clickOnAddToCartButton()
		 	.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.verifyNameOfTheProductInMyCartPage(productName)
			.myCartPage()
		 	.clickOnSaveCart()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			myCartPage().verifySaveCartCreationMessage(saveCartName);
			 homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCart()
			.saveCartPage()
			.verifyBreadCrumps(saveCartBreadcrump)
			.verifyPageName(saveCartBreadcrump)
			.verifySaveCartTitle()
			.clickOnTheCreatedSaveCart(saveCartName)	
			.verifyBreadCrumps(saveCartName)
			.verifyPageName(saveCartName)
			.verifyTitleAfterClickingOnTheCartCreated();
			 saveCartDeleteAndVerify(saveCartName);
			}

	@Features("Save Cart Module")
	@Description("This is a test case which verifies the alert text when of every bulk option when no item is selected.")
	@TestCaseId("{0}")
	@Test(groups={"SaveCartModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	public void SC_BulkAlert_ItemnotChosen(String testcaseId,@Parameter("Bulk Option")String bulkOption,@Parameter("Expected Alert Text")String expectedAlertText) throws Exception {

		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
		
		String searchText = data.getSearchTextForMPNTest();
		String saveCartName = data.getSaveCartName();

		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.myCartPage()
		.clickOnSaveCart()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		myCartPage().verifySaveCartCreationMessage(saveCartName);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCart()
		.saveCartPage()
		.clickOnTheCreatedSaveCart(saveCartName)
		.selectBulkActionsDropdown(bulkOption)
		.verifyAlertText(expectedAlertText);
		saveCartDeleteAndVerify(saveCartName);
		
	}	
}