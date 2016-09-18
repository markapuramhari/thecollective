package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class QuickOrderPadModuleTest extends PageFactoryInitializer {
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	
	@Features("Quick Order Pad Module")
	@Test(groups="regression")
	@TestCaseId("TC_QOP_001")
	@Description("Verification of 'Quick Order Pad' page")
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
	@TestCaseId("TC_QOP_002")
	@Description("Verification of 'Speed Entry' tab in  'Quick Order Pad' page.")
	public void verifySpeedEntryTab() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink()
		.verifySpeedEntryTab(data.getSpeedEntryInstructions());
		
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
	@Test(groups="regression")
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
	@Test(groups="regression",enabled=false)
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
	@Test(groups="regression",enabled=false)
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
				.clickOnFileUploadTab()
				.clickOnCopyPasteTab()
				.copyPasteTxtFile(data.getTabDelimitedFilePathForImproperValues().trim())
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
	@Test(groups={"smoke","regression"})
	@Description("Verification of add to cart functionality in 'Speed Entry' tab")
	@TestCaseId("TC_QOP_003")
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
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_004")
	@Description("Verification of 'Combine' functionality in 'Speed Entry' tab")
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
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_005")
	@Description("Verification of 'Separate' functionality in 'Speed Entry' tab")
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
	@Test(groups={"regression"})
	@Description("Verification of 'Remove' functionality in 'Speed Entry' tab")
	@TestCaseId("TC_QOP_006")
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
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_011")
	@Description("Verification of Add to cart functionality in 'Speed Entry' tab for Invalid Quantity.")
	public void speedEntryInvalidQuantity() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		data.setNumberOfRowsToEnter(1);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntry(data.getInvalidQuantityForSpeedEntry().split(","),data.getNumberOfRowsToEnter())
		.verifyInvalidQuantityColour(data.getSpeedEntryInvalidQuantityColourChrome(),data.getSpeedEntryInvalidQuantityColourFirefox())
		.clickOnAddToCartButtonSpeedEntry()
		.verifyAlertText(data.getAlertTextForInvalidQuantityInSpeedEntry()+Integer.toString(data.getNumberOfRowsToEnter()));
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_007")
	@Description("Verification of Add to cart functionality when Quantity field is left blank in speed entry tab")
	public void speedEntryQtyFieldBlank() throws Exception{
		String keyword[] = data.getPartNumberOrUPCForSpeedEntry().split(",");
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		data.setNumberOfRowsToEnter(1);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterKeywordOrQtyBut1FieldIsEmpty(keyword[0].split(":"),"Keyword",data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.verifyAlertText(data.getAlertTextForInvalidQuantityInSpeedEntry()+Integer.toString(data.getNumberOfRowsToEnter()));
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_008")
	@Description("Verification of Add to cart functionality when Keyword field is left blank in speed entry tab")
	public void speedEntryKeywordFieldBlank() throws Exception{
		String keyword[] = data.getPartNumberOrUPCForSpeedEntry().split(",");
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		data.setNumberOfRowsToEnter(1);
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterKeywordOrQtyBut1FieldIsEmpty(keyword[0].split(":"),"Quantity",data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.verifyAlertText(data.getAlertTextForInvalidQuantityInSpeedEntry()+Integer.toString(data.getNumberOfRowsToEnter()));
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_009")
	@Description("Verification of 'Add to cart' functionality when item price is unavailable in speed entry tab.")
	public void speedEntryNoPriceItem() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		data.setNumberOfRowsToEnter(2);
		int actualItemsWithException = homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntry(data.getPartNumberOrUPCForSpeedEntryWhichHasCallForPrice().split(","), data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.verifyCartCountEqualToAddedToCartCount(0)
		.getItemsWithExceptionsSection();
		quickOrderPadPage().verifyNumberOfItemsWithExceptions(actualItemsWithException,data.getNumberOfRowsToEnter())
		.verifyWhetherTheItemsAddedHaveCallForPrice(data.getNumberOfRowsToEnter());
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_010")
	@Description("Verification of Add to cart functionality in 'Speed Entry' tab for Invalid PartNumber.")
	public void speedEntryInvalidPartNumber() throws Exception{
		String jibberishKeywords[] = {"asdajkdhsjadha:1"}; 
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		data.setNumberOfRowsToEnter(1);
		int actualItemsWithNoMatches = homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.enterPartNumberOrUPCForSpeedEntry(jibberishKeywords, data.getNumberOfRowsToEnter())
		.clickOnAddToCartButtonSpeedEntry()
		.verifyCartCountEqualToAddedToCartCount(0)
		.getItemsWithNoMatches();
		quickOrderPadPage()
		.verifyNumberOfWithNoMatches(actualItemsWithNoMatches,data.getNumberOfRowsToEnter());
	}
	
	@Features("Quick Order Pad Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_QOP_012")
	@Description("Verification of table cell extension in 'Speed Entry' ")
	public void speedEntryCellExtension() throws Exception{
		loginModule.loginAsASuperUser();
		homePage().logout();
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnQuickOrderPadLink().quickOrderPadPage()
		.clickOnSpeedEntry()
		.rightClickOnASpecificCell("Keyword",1)
		.verifyRightClickOptions(data.getSpeedEntryCellExtensionOptions().split(","));
	}
}
