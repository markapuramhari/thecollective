package org.etna.modules;
import org.etna.utils.*;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import org.etna.maincontroller.PageFactoryInitializer;


public class ShareCartModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	String addNewPurchasingAgentBreadcrumb = data.getAddNewPurchasingAgentBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	SaveCartModuleTest saveCart = new SaveCartModuleTest();
	
	@Features("Share Cart Module")
	@Description("Verification of 'Saved cart list'")
	@TestCaseId("TC_ShareCart_01")
	@Test(groups={"regression"})
	public void verifySaveCartList() throws Exception{
	
		
		saveCart.TC_ShoppingCart_011_CreateAndDeleteSaveCart();
	}
	
	@Features("Share Cart Module")
	@Description("Click on the Saved Cart link in the Customer Services List.")
	@TestCaseId("TC_ShareCart_02")
	@Test(groups={"regression"})
	public void verifyShareCartLink() throws Exception{
	
		loginModule.loginAsASuperUser();
		
		String saveCartName = data.getSaveCartName();
		try
		{
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		 homePage().searchText(searchText).clickOnSearch()
		.productDetailsPage().clickOnAddToCartButton().myCartPage().
		clickOnCheckoutInMyCartPopup()
		.myCartPage().clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName).hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		myCartPage().verifySaveCartCreationMessage(saveCartName);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.saveCartPage()
		.clickOnTheCreatedSaveCart(saveCartName)
		.verifyDisplayOfShareCartLink();
		}
		
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of Share cart fields")
	@TestCaseId("TC_ShareCart_03")
	@Test(groups={"regression"})
	public void verifyShareCartFields() throws Exception{
		
		loginModule.loginAsASuperUser();
		String saveCartName = data.getSaveCartName();
		String shareInstructions = data.getShareInstructions();
		String sharePopUpHeading = data.getSharePopUpHeading();
		
		try
		{
		String searchText = data.getSearchTextForEnlargeImageTest();
		 homePage().searchText(searchText).clickOnSearch()
			.productDetailsPage().clickOnAddToCartButton().myCartPage().
			clickOnCheckoutInMyCartPopup()
					.myCartPage().clickOnSaveCartButton()
					.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName).hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			myCartPage().verifySaveCartCreationMessage(saveCartName);
			homePage().clickOnUserAccountDropdown().clickOnMySaveCartLink().saveCartPage().clickOnTheCreatedSaveCart(saveCartName)
			.clickOnShareCartLink()
			.verifySharePopUp(sharePopUpHeading,shareInstructions);
		}
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButton();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of Share cart functionality when any key word is not entered.")
	@TestCaseId("TC_ShareCart_04")
	@Test(groups={"regression"})
	public void verifyErrorNoKeywordEntered() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		try
		{
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.clickOnTheCreatedSaveCart(saveCartName)
		.clickOnShareCartLink()
		.clickOnSearchButton()
		.verifyErrorMsg(data.getErrorMsgNoKeywordEntered().trim());
		}
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButton();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of share cart search")
	@TestCaseId("TC_ShareCart_05")
	@Test(groups={"regression"})
	public void shareCartKeywordSearch() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		try
		{
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.clickOnTheCreatedSaveCart(saveCartName)
		.clickOnShareCartLink()
		.enterKeyword(data.getValidKeywordForShareCart())
		.clickOnSearchButton()
		.verifySearchResult(data.getValidKeywordForShareCart());
		}
		
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButton();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of 'Reset' functionality in Share cart pop up.")
	@TestCaseId("TC_ShareCart_06")
	@Test(groups={"regression"})
	public void shareCartResetFunctionality() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		try
		{
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.clickOnTheCreatedSaveCart(saveCartName)
		.clickOnShareCartLink()
		.enterKeyword(data.getValidKeywordForShareCart())
		.clickOnSearchButton()
		.verifySearchResult(data.getValidKeywordForShareCart())
		.clickOnTheSpecificCheckbox(data.getValidKeywordForShareCart(),1)
		.verifyWhetherCheckboxesAreClicked()
		.clickOnResetButton()
		.verifyWhetherCheckboxesAreNotClicked();
		}
		
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButton();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	
	@Features("Share Cart Module")
	@Description("Verification of 'share' functionality in Share cart pop up , When check box are not checked.")
	@TestCaseId("TC_ShareCart_07")
	@Test(groups={"regression"})
	public void shareWithoutSelectingUser() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		try
		{
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.clickOnSaveCartButton()
		.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
		.hitEnterForSaveCartCreation();
		Thread.sleep(1000);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.clickOnTheCreatedSaveCart(saveCartName)
		.clickOnShareCartLink()
		.enterKeyword(data.getValidKeywordForShareCart())
		.clickOnSearchButton()
		.clickOnShareButton()
		.productListPage()
		.verifyAlertMessage(data.getAlertTextForShareFunctionalityWhenUserIsNotSelected());
		}
		
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButton();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of share cart for not existing User(s) in pop up.")
	@TestCaseId("TC_ShareCart_09")
	@Test(groups={"regression"})
	public void shareCartVerifyInvalidUserSearch() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		try
		{
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnShareCartLink()
			.enterKeyword(RandomGenerator.random(13, PermittedCharacters.ALPHANUMERIC))
			.clickOnSearchButton()
			.verifyNoSearchResults(data.getNoSearchResultsMessage());
			

		}
		
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			sharePopUp().clickOnCloseButtonForUserNotFound();
			saveCart.saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Share Cart Module")
	@Description("Verification of share cart for not existing User(s) in pop up.")
	@TestCaseId("TC_ShareCart_09")
	@Test(groups={"regression"})
	public void shareCartFunctionality() throws Exception{
		String saveCartName = data.getSaveCartName();
		loginModule.loginAsASuperUser();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		try
		{
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnShareCartLink()
			.enterKeyword(data.getValidKeywordForShareCart())
			.clickOnSearchButton()
			.clickOnTheSpecificCheckbox(data.getValidKeywordForShareCart(), 1)
			.clickOnShareButton()
			.clickOnCloseButton()
			.homePage()
			.logout();
			loginModule.login(data.getUserNameForWhichCartIsShared(), data.getPasswordForWhichCartIsShared());
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCart()
			.verifyWhetherTheCartIsShared(saveCartName)
			.clickOnSharedCart(saveCartName)
			.verifyPageName(saveCartName)
			.verifybreadCrumbs(saveCartName)
			.verifyCompleteBreadcrumb(data.getSharedCartCompleteBreadcrumb()+saveCartName);

		}
		
		catch(UnhandledAlertException e){
			
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
	}
}