package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;

public class QuickOrderPadModuleTest extends PageFactoryInitializer {
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void verifyQuickOrderLandingPage() throws Exception{
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.verifyQuickOrderPage();
	}
	
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUpload() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		int addedToCartCount = homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.uploadFile(data.getCartFileUploadPath().trim())
		.clickOnUpload()
		.getAddedToCartCount();
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
	}
	
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void copyPasteCSVFile() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
				int addedToCartCount = homePage()
				.clickLoginLink()
				.loginPopUp()
				.enterUserName()
				.enterPassword()
				.clickOnLoginButton()
				.homePage()
				.verifyWelcomeMsg()
				.clickOnUserAccountDropdown()
				.clickOnQuickOrderPadLink()
				.quickOrderPadPage()
				.clickOnCopyPasteTab()
				.copyPasteFile(data.getCSVFilePath().trim())
				.clickOnAddToCartButton()
				.getAddedToCartCount();
				quickOrderPadPage()
				.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression",enabled=false)
	public void copyPasteTabDelimitedFile() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		int addedToCartCount = homePage()
				.clickLoginLink()
				.loginPopUp()
				.enterUserName()
				.enterPassword()
				.clickOnLoginButton()
				.homePage()
				.verifyWelcomeMsg()
				.clickOnUserAccountDropdown()
				.clickOnQuickOrderPadLink()
				.quickOrderPadPage()
				.clickOnCopyPasteTab()
				.copyPasteTxtFile(data.getTabDelimitedFilePath().trim())
				.clickOnAddToCartButton()
				.getAddedToCartCount();
				quickOrderPadPage()
				.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
	}
	

	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void copyPasteEmptyValues() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
				homePage()
				.clickLoginLink()
				.loginPopUp()
				.enterUserName()
				.enterPassword()
				.clickOnLoginButton()
				.homePage()
				.verifyWelcomeMsg()
				.clickOnUserAccountDropdown()
				.clickOnQuickOrderPadLink()
				.quickOrderPadPage()
				.clickOnCopyPasteTab()
				.clickOnAddToCartButton()
				.verifyAlertMessage(data.getSpeedEntryEmptyValuesAlertMessage());			
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	@Issues(value = { @Issue(value = "NEST-160") })
	public void copyPasteImproperValues() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
				homePage()
				.clickLoginLink()
				.loginPopUp()
				.enterUserName()
				.enterPassword()
				.clickOnLoginButton()
				.homePage()
				.verifyWelcomeMsg()
				.clickOnUserAccountDropdown()
				.clickOnQuickOrderPadLink()
				.quickOrderPadPage()
				.clickOnCopyPasteTab()
				.copyPasteTxtFile(data.getTabDelimitedFilePath().trim())
				.clickOnAddToCartButton()
				.verifyAlertMessage(data.getCopyPasteInvalidFormatAlertMessage());			
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void fileUploadNoFileSelectedAtFirst() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.clickOnUpload()
		.verifyAlertMessage(data.getSelectFileToUploadAlertMessage());			
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUploadDifferentFormatTxt() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.uploadFile(data.getTabDelimitedFilePath().trim())
		.clickOnUpload()
		.verifyAlertMessage(data.getSelectXLSXFileToUploadAlertMessage().trim());	
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUploadDifferentFormatImg() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.uploadFile(data.getImagePath().trim())
		.clickOnUpload()
		.verifyAlertMessage(data.getSelectXLSXFileToUploadAlertMessage().trim());	
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUploadCombine() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		int addedToCartCount = homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload()
		.getAddedToCartCount();
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
		quickOrderPadPage()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload();
		Thread.sleep(3000);
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(1)
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(1)
		.verifyQuantitiesInShoppingCartForMultipleItems("2");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUpload_Seperate() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		int addedToCartCount = homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.clickOnSeperateButton()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload()
		.getAddedToCartCount();
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
		quickOrderPadPage()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload();
		Thread.sleep(3000);
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(2)
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(2)
		.verifyQuantitiesInShoppingCartForMultipleItems("1");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	public void cartFileUpload_Remove() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		int addedToCartCount = homePage()
		.clickLoginLink()
		.loginPopUp()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyWelcomeMsg()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.quickOrderPadPage()
		.clickOnFileUploadTab()
		.clickOnRemoveButton()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload()
		.getAddedToCartCount();
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(addedToCartCount);
		quickOrderPadPage()
		.uploadFile(data.getXlsxFileForDifferentCartFileUploadScenarios())
		.clickOnUpload();
		Thread.sleep(3000);
		quickOrderPadPage()
		.verifyCartCountEqualToAddedToCartCount(1)
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(1)
		.verifyQuantitiesInShoppingCartForMultipleItems("2");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"speed entry","smoke","regression"})
	public void speedEntrySmoke() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		data.setNumberOfRowsToEnter(2);
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.enterPartNumberOrUPCForSpeedEntry(data.getPartNumberOrUPCForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(2);
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"speed entry","regression"})
	public void speedEntryCombine() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		data.setNumberOfRowsToEnter(2);
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(1)
		.verifyQuantitiesInShoppingCartForMultipleItems("2");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"speed entry","regression"})
	public void speedEntrySeperate() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		data.setNumberOfRowsToEnter(2);
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.clickOnSeperateButtonSpeedEntry()
		.clickOnAddToCartButtonSpeedEntry()
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(2)
		.verifyQuantitiesInShoppingCartForMultipleItems("1");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"speed entry","regression"})
	public void speedEntryRemove() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		data.setNumberOfRowsToEnter(10);
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntryForCombine(data.getPartNumberOrUPCForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.clickOnRemoveButtonSpeedEntry()
		.clickOnAddToCartButtonSpeedEntry()
		.myCartPage()
		.clickOnCartIcon()
		.verifyNumberOfItemsInShoppingCart(1)
		.verifyQuantitiesInShoppingCartForMultipleItems("1");
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"speed entry","regression"})
	public void speedEntryInvalidQuantity() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		data.setNumberOfRowsToEnter(2);
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntry(data.getInvalidQuantityForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.verifyInvalidQuantityColour(data.getSpeedEntryInvalidQuantityColour());
	}
}
