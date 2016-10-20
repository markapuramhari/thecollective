package org.etna.modules;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.PermittedCharacters;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
public class SaveCartModuleTest extends PageFactoryInitializer {
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	/*
@author: hemanth.bs
	 */
	public void saveCartDeleteAndVerify(String saveCartName) throws Exception{
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.saveCartPage()
		.clickOnTheCreatedSaveCart(saveCartName)
		.deleteSaveCart()
		.verifyAlertText(data.getDeleteSaveCartAlertText())
		.homePage()
		.clickOnUserAccountDropdown()
		.clickOnMySaveCartLink()
		.saveCartPage()
		.verifyDeletionOfSaveCart(saveCartName);
	}
	
	@Features("Save Cart Module")
	@Description("This is a test case which verifies the alert text when of every bulk option when no item is selected.")
	@TestCaseId("{0}")
	@Test(groups={"SaveCartModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void sC_BulkAlert_ItemNotChosen(String testcaseId,@Parameter("Bulk Option")String bulkOption,@Parameter("Expected Alert Text")String expectedAlertText) throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.myCartPage()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			myCartPage().verifySaveCartCreationMessage(saveCartName)
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.selectBulkActionsDropdown(bulkOption)
			.verifyAlertText(expectedAlertText);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	/*
	 * @author:Varsha.RL
	 */
	@Features("Save Cart Module")
	@Description("This Test Case Verifies saved cart breadcrumbs from My Account")
	@TestCaseId("TC_SavedCart_004")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyBreadCrumbFromMyAccount() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		String saveCartBreadCrumb = data.getSaveCartBreadcrumb();
		String myAccountBreadCrumb = data.getMyAccountBreadcrumb();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMyAccount()
			.myAccountsPage()
			.clickOnGroupsTab()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnMySavedCartCrumb()
			.verifyPageName(saveCartBreadCrumb)
			.clickOnMyAccountCrumb()
			.myAccountsPage()
			.verifyPageName(myAccountBreadCrumb);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies saved cart breadcrumbs from My Saved Cart")
	@TestCaseId("TC_SavedCart_005")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyBreadCrumbFromMySavedCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		String saveCartBreadcrumb = data.getSaveCartBreadcrumb();
		String myAccountBreadcrumb = data.getMyAccountBreadcrumb();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.verifyBreadCrumbAfterCreation(saveCartName,saveCartBreadcrumb,myAccountBreadcrumb);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Saved Cart Page Content")
	@TestCaseId("TC_SavedCart_006")
	@Test(groups={"SaveCartModule","regression"})
	public void verifySavedCartPageContent() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.saveCartPage()
			.verifyMySavedCartPage();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	/*
	 * @author: hemanth.sridhar
	 */
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Creating a New Saved Cart")
	@TestCaseId("TC_SavedCart_001,TC_SavedCart_021,TC_SavedCart_003")
	@Test(groups={"SaveCartModule","regression"})
	public void createAndDeleteNewSavedCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		String saveCartBreadcrump = data.getSaveCartBreadcrumb();
		try{
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
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			myCartPage().verifySaveCartCreationMessage(saveCartName);
			homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.verifybreadCrumbs(saveCartBreadcrump)
			.verifyPageName(saveCartBreadcrump)
			.verifySaveCartTitle()
			.clickOnTheCreatedSaveCart(saveCartName)
			.verifybreadCrumbs(saveCartName)
			.verifyPageName(saveCartName)
			.verifyTitleAfterClickingOnTheCartCreated();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	
	}
	

	
	@Features("Save Cart Module")
	@Description("This Test Case Adds Another Item to Existing Cart")
	@TestCaseId("TC_SavedCart_002")
	@Test(groups={"SaveCartModule","regression"})
	public void verifiesAddingItemsToExistingCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String searchAnotherText = data.getSearchTextForAnotherItem();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			
			String productName1 = homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.getProductName();
			
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			
			String productName2 = homePage()
			.searchText(searchAnotherText)
			.clickOnSearch()
			.productDetailsPage()
			.getProductName();
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.clickOnTheCreatedCartFromTheSaveCartDropdownList(saveCartName)
			
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName);
			
			String [] products = {productName1,productName2};
			
			saveCartPage()
			.verifyWhetherProductsAddedAreDisplayedInTheSaveCart(products);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk option to delete selected Items")
	@TestCaseId("TC_SavedCart_007")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyBulkOptionDeleteSelectedItems() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		String searchAnotherText = data.getSearchTextForAnotherItem();
		
		data.setBulkOption("Delete Selected Items");
		try{
			loginModule.loginAsASuperUser();
			
			String productName1 = homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.getProductName();
			
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			
			String productName2 = homePage()
			.searchText(searchAnotherText)
			.clickOnSearch()
			.productDetailsPage()
			.getProductName();
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.clickOnTheCreatedCartFromTheSaveCartDropdownList(saveCartName)
			
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName);
			
			String itemToBeDeleted = productName1;
			String [] products = {itemToBeDeleted};
			
			
			saveCartPage()
			.verifyWhetherProductsAddedAreDisplayedInTheSaveCart(products);
		
			saveCartPage()
			.selectSpecificCheckbox(products)
			.selectBulkActionsDropdown(data.getBulkOption())
			.myProductGroupsPage()
			.verifyAlertText(data.getAlertTextDeleteItemFromSavedCart())
			.verifyWhetherTheProductsAreDeletedFromTheSaveCart(products);
		
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk option to Update Items when Quantity is zero")
	@TestCaseId("TC_SavedCart_007")
	@Test(groups={"SaveCartModule","regression"})
	public void verifiesBulkOptionUpdateWhenQuantityIsZero() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			String partNumber = homePage()
					.searchText(searchText)
					.clickOnSearch()
					.productDetailsPage()
					.getPartNumber();
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation()
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.enterQuantity("0")
			.clickOnFirstSelectCheckbox()
			.verifyAlertText("Min Order Quantity is 1. For PN: "+partNumber+". To Continue with Min Order Qty click \"Ok\".To cancel this item click \"Cancel\"");
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk option to Update Items when Quantity is null")
	@TestCaseId("TC_SavedCart_011")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyBulkOptionUpdateWhenQuantityIsNull() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			homePage().logout();
			loginModule.loginAsASuperUser();
			String partNumber = homePage()
					.searchText(searchText)
					.clickOnSearch()
					.productDetailsPage()
					.getPartNumber();
			productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation()
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.enterQuantity("")
			.clickOnFirstSelectCheckbox()
			.verifyAlertText("Invalid Qty. For PN: "+partNumber+". To Continue with Min Order Qty click \"Ok\".To cancel this item click \"Cancel\"");
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk Option to Add Item From Saved Cart By Select Option")
	@TestCaseId("TC_SavedCart_013")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyBulkOptionAddingOneItemToCartWithSelectOption() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		data.setBulkOption("Add Selected Items to Cart");
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.saveCartPage()
			.verifyPageName(saveCartName)
			.clickOnFirstSelectCheckbox()
			.selectBulkActionsDropdown(data.getBulkOption())
			.verifyNumberAddedSuccessfullyMsg(1);
			
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			myCartPage()
			.clickOnCloseButtonInMyCartPopUp();
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk Option to Delete Selected Items From Saved Cart By Select All Option")
	@TestCaseId("TC_SavedCart_015")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyDeletingItemsFromSavedCartWithSelectAllOption() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String searchAnotherText = data.getSearchTextForAnotherItem();
		String saveCartName = data.getSaveCartName();
		data.setBulkOption("Delete Selected Items");
		try{
			
			data.setBulkOption("Delete Selected Items");
				loginModule.loginAsASuperUser();
				
				String productName1 = homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productDetailsPage()
				.getProductName();
				
				productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnSaveCartButton()
				.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
				.hitEnterForSaveCartCreation();
				
				String productName2 = homePage()
				.searchText(searchAnotherText)
				.clickOnSearch()
				.productDetailsPage()
				.getProductName();
				
				productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnSaveCartButton()
				.clickOnTheCreatedCartFromTheSaveCartDropdownList(saveCartName)
				
				.homePage()
				.clickOnUserAccountDropdown()
				.clickOnMySaveCartLink()
				.clickOnTheCreatedSaveCart(saveCartName);
				
				String [] products = {productName1,productName2};
				saveCartPage()
				.verifyWhetherProductsAddedAreDisplayedInTheSaveCart(products);
			
				saveCartPage()
				.clickOnSelectAllCheckBox()
				.selectBulkActionsDropdown(data.getBulkOption())
				.myProductGroupsPage()
				.verifyAlertText(data.getAlertTextDeleteItemFromSavedCart())
				.verifyWhetherTheProductsAreDeletedFromTheSaveCart(products);
		}
		
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
	}
	
	@Features("Save Cart Module")
	@Description("This is a test case which verifies editing of quantity and verifying change of extension price.")
	@TestCaseId("TC_SavedCart_009")
	@Test(groups={"regression"})
	public void verifyChangeOfExtensionPrice() throws Exception {
		data.setBulkOption("Update Selected Items");
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try
		{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName);
			Number currentExtnPrice = myProductGroupsPage().getExtensionPrice();
			myCartPage()
			.enterQuantityInShoppingCart(data.getQuantityForShoppingCartPageVerification())
			.myProductGroupsPage()
			.clickOnTheSpecificCheckbox(1)
			.selectBulkActionsDropdown(data.getBulkOption())
			.myCartPage()
			.verifyUpdateOfQuantityInShoppingCart(data.getQuantityForShoppingCartPageVerification())
			.myProductGroupsPage()
			.verifyExtPrice(data.getQuantityForShoppingCartPageVerification(),currentExtnPrice);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	/*   2nd sprint   */
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Bulk Option to Add Items From Saved Cart By Select All Option")
	@TestCaseId("TC_SavedCart_016")
	@Test(groups={"SaveCartModule","regression"},enabled=true)
	public void verifiesAddingItemsToCartWithSelectAllOption() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String searchAnotherText = data.getSearchTextForThirdItem();
		String saveCartName = data.getSaveCartName();
		data.setBulkOption("Add Selected Items to Cart");
		try{
			loginModule.loginAsASuperUser();
			myCartPage().clearCart();
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
			.homePage()
			.searchText(searchAnotherText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation()
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.clickOnTheCreatedSaveCart(saveCartName)
			.saveCartPage()
			.verifyPageName(saveCartName)
			.clickOnSelectAllCheckBox()
			.selectBulkActionsDropdown(data.getBulkOption())
			.verifyNumberAddedSuccessfullyMsg(2);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			myCartPage()
			.clickOnCloseButtonInMyCartPopUp();
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Edit Cart Name Functionality")
	@TestCaseId("TC_SavedCart_017,TC_SavedCart_018,TC_SavedCart_019")
	@Test(groups={"SaveCartModule","regression"},enabled=true,dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void verifyEditCartName_ES_PS(String testcaseId,@Parameter("Save Cart Name")String saveCartName,@Parameter("Save Cart Name")String editCartName,@Parameter("Expected Alert Text")String expectedAlertText) throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnEditCartName()
			.verifyEditCartNameElements()
			.editCartNameTextBox(editCartName)
			.clickOnSaveIconOfEditCartName()
			.verifyAlertText(expectedAlertText.trim());
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			try
			{
				saveCartDeleteAndVerify(saveCartName);
			}
			catch(NoSuchElementException | TimeoutException e)
			{
				driver.navigate().refresh();
				saveCartDeleteAndVerify(editCartName);
			}
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Edit Cart Name Functionality With Existing Cart Name")
	@TestCaseId("TC_SavedCart_020")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyEditCartNameFunctionalityWithExistingCartName() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		String editSaveCartName = data.getSaveCartName()+RandomGenerator.random(3, PermittedCharacters.ALPHABETS);
		try{
			loginModule.loginAsASuperUser();
			homePage().logout();
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
			.homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(editSaveCartName)
			.hitEnterForSaveCartCreation()
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnEditCartName()
			.editCartNameTextBox(editSaveCartName)
			.clickOnSaveIconOfEditCartName()
			.verifyAlertText(data.getAlertTextCartNameAlreadyExists());
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
			saveCartDeleteAndVerify(editSaveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Cancel Functionality Of Edit Cart Name")
	@TestCaseId("TC_SavedCart_017")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyCancelFunctionality() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnEditCartName()
			.clickOnCancelIconOfEditCartName()
			.verifyWhetherEditCartNameElementsAreNotDisplayedAfterCancel();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}

	//Better to have 3 tests to verify 3 different scenarios. Need to improve the test case.(FYI test case is right and works
	//absolutely fine IN AN IDEAL SITUATION.
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Search Functionality in Saved Cart")
	@TestCaseId("TC_SavedCart_022,TC_SavedCart_023,TC_SavedCart_024")
	@Test(groups={"SaveCartModule","regression"})
	public void verifySearchFunctionalityInMySavedCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String anotherSearchText = data.getSearchTextForThirdItem();
		String invalidText = data.getSearchTextForInvalidTestData();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			homePage().logout();
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
			.hitEnterForSaveCartCreation();
			homePage()
			.searchText(anotherSearchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.clickOnSaveCartButton()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation()
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.searchTextBoxInSavedCart(searchText)
			.clickOnGoButton()
			.verifyItemDisplay(searchText)
			.searchTextBoxInSavedCart(anotherSearchText)
			.clickOnGoButton()
			.verifyItemDisplay(anotherSearchText)
			.clickOnClearSearchButton()
			.searchTextBoxInSavedCart(invalidText)
			.clickOnGoButton()
			.verifyNoResultsFoundMsg()
			.clickOnClearSearchButton()
			.verifyItemDisplay(searchText)
			.verifyItemDisplay(anotherSearchText);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Sort By Dropdown in Saved Cart")
	@TestCaseId("TC_SavedCart_035")
	@Test(groups={"SaveCartModule","regression"})
	public void verifySortByDropdownInSavedCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnSortByDropDown()
			.verifySortByDropdown();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Expand View of Item Description")
	@TestCaseId("TC_SavedCart_034")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyExpandView() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		data.setViewType("Expand View");
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnViewLocator()
			.clickOnSpecificView(data.getViewType())
			.verifyDescriptionDisplayForExpandView();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Collapse View of Item Description")
	@TestCaseId("TC_SavedCart_033")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyCollapseView() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		data.setViewType("Collapse View");
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnViewLocator()
			.clickOnSpecificView(data.getViewType())
			.verifyDescriptionDisplayForCollapseView();
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	//hardcoded. better approach is to read from excel sheet for every item per page. FYI . test case works ideally.
	//The right approach is to add more than 50 different items into the cart.
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Item Per Page Functionality in Saved Cart")
	@TestCaseId("TC_SavedCart_032")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyItemPerPageFunctionalityInSavedCart() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCartLink()
			.saveCartPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.clickOnItemPerPage()
			.clickOnItemPerPageOption(12)
			.verifyDisplayOfItems(12)
			.clickOnItemPerPage()
			.clickOnItemPerPageOption(24)
			.verifyDisplayOfItems(24)
			.clickOnItemPerPage()
			.clickOnItemPerPageOption(48)
			.verifyDisplayOfItems(48);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	
	@Features("Save Cart Module")
	@Description("This Test Case Verifies Saved Cart List From Different Pages")
	@TestCaseId("TC_SavedCart_003")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyCreatedCartIsDisplayedInMyAccountsPage() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
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
			.homePage()
			.clickOnUserAccountDropdown()
			.clickOnMyAccount()
			.myAccountsPage()
			.clickOnGroupsTab()
			.verifyWhetherCreatedCartIsDisplayedUnderSaveCartSectionInGroupsTab(saveCartName);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
	@Features("Save Cart Module")
	@Description("This Test Case which verifies whether the created cart is getting displayed in Save Cart Button dropdown.")
	@TestCaseId("TC_SavedCart_003")
	@Test(groups={"SaveCartModule","regression"})
	public void verifyCreatedCartIsDisplayedInSaveCartDropdown() throws Exception {
		String searchText = data.getSearchTextForEnlargeImageTest();
		String saveCartName = data.getSaveCartName();
		try{
			loginModule.loginAsASuperUser();
			homePage().logout();
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
			.hitEnterForSaveCartCreation();
			driver.navigate().refresh();
			myCartPage()
			.clickOnSaveCartButton()
			.verifyWhetherCartCreatedInDisplayedInCartOptionsDropdown(saveCartName);
		}
		catch(UnhandledAlertException e){
			TestUtility.alertAccept();
			throw new Exception("Alert not handled.");
		}
		finally{
			saveCartDeleteAndVerify(saveCartName);
		}
	}
}