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
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;

public class MyProductGroupModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	public void productGroupDeleteAndVerify(String myProductGroupName) throws Exception{
		
		 homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText())
			. homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
	}
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies creation, item addition and deletion of My Product Group from Product List page.")
	@TestCaseId("TC_ProductGroup_001,TC_ProductGroup_002,TC_ProductGroup_032,TC_ProductGroup_028,TC_ProductGroup_035")
	@Test(groups={"regression"})
	public void verifyCreationAndDeletionOfMyProductGroup_ProductListPage() throws Exception{
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
	}
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies whether on clicking the success message when creating a product group, My Product Group page should be opened with the group created and the respective item added to the group.")
	@TestCaseId("TC_ProductGroup_003,TC_ProductGroup_004")
	@Test(groups={"regression"})
	public void verifyClickingOnSuccessMessageOnGroupCreation_ProductListPage() throws Exception{
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
		.clickOnSuccessMessage()
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
		
}	
	

	@Features("My Product Group Module")
	@Description("This is a test case which verifies whether a product group is created when the product list page is in Grid view.")
	@TestCaseId("TC_ProductGroup_005")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_GridView_ProductListPage() throws Exception {
	
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.clickOnChangeView()
		.hoverOverSpecificProduct(1)
		.clickOnSpecificMyProductGroupButton(1)
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.hoverOverSpecificProduct(1)
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnSuccessMessage()
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
	}	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies for the alert text when we hit enter without providing any data.")
	@TestCaseId("TC_ProductGroup_007")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_errorMessage_BlankText() throws Exception {
		try
		{
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.hoverOverSpecificProduct(1)
		.clickOnSpecificMyProductGroupButton(1)
		.enterGroupName("")
		.hitEnter()
		.verifyAlertMessage(data.getExpectedAlertMessageForBlankData());
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
	}	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies for the alert text when we hit enter without providing any data.")
	@TestCaseId("TC_ProductGroup_008")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_errorMessage_JustSpaces() throws Exception {
		try
		{
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.hoverOverSpecificProduct(1)
		.clickOnSpecificMyProductGroupButton(1)
		.enterGroupName("")
		.hitEnter()
		.verifyAlertMessage(data.getExpectedAlertMessageForBlankData());
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		
	}	
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies adding product to an existing my product group in list view.")
	@TestCaseId("TC_ProductGroup_010")
	@Test(groups={"regression"})
	public void verifyAddingProductToExsistingMyProductGroup_ListView() throws Exception {
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
		.verifyMyProductCreationSuccessMsg(myProductGroupName);
		driver.navigate().refresh();
		productListPage()
		.clickOnSpecificMyProductGroupButton(1)
		.chooseGroupNameFromTheDropdownList(myProductGroupName)
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnSuccessMessage()
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
	}
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies adding product to an existing my product group in grid view.")
	@TestCaseId("TC_ProductGroup_010")
	@Test(groups={"regression"})
	public void verifyAddingProductToExistingMyProductGroup_GridView() throws Exception {
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		
		try
		{
			loginModule.loginAsASuperUser(); 
			homePage().clickOnUserAccountDropdown().logout();
			loginModule.loginAsASuperUser(); 
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.clickOnChangeView()
		.hoverOverSpecificProduct(1)
		.clickOnSpecificMyProductGroupButton(1)
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.hoverOverSpecificProduct(1)
		.verifyMyProductCreationSuccessMsg(myProductGroupName);
		driver.navigate().refresh();
		productListPage()
		.hoverOverSpecificProduct(1)
		.clickOnSpecificMyProductGroupButton(1)
		.chooseGroupNameFromTheDropdownList(myProductGroupName)
		.hoverOverSpecificProduct(1)
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnSuccessMessage()
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
	}	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies My Product groups landing page and also the page which is displayed after clicking on my product group.")
	@TestCaseId("TC_ProductGroup_013,TC_ProductGroup_030,TC_ProductGroup_031,TC_ProductGroup_032,TC_ProductGroup_033")
	@Test(groups={"regression"})
	public void verifyMyProductGroupPage() throws Exception {
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageTitle(data.getMyProductGroupLandingPageTitle(),setUp.getProductName())
			.verifyPageNameOfMyProductGroupLandingPage(data.getMyProductGroupsPageName())
			.verifyBreadCrumpOfMyProductGroupLandingPage(data.getMyProductGroupsPageName())
			.clickOnTheGroupCreated(myProductGroupName)
			.verifyPageName(myProductGroupName)
			.verifyBreadCrump(myProductGroupName)
			.verifyPageTitle(data.getMyProductGroupsPageName().replace("My", "").replace("s", "").trim(), setUp.getProductName())
			.verifyMyProductGroupPageAfterClickingOnTheProduct();
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
		
	}
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies deleting items bulk action scenario.")
	@TestCaseId("TC_ProductGroup_014")
	@Test(groups={"regression"})
	public void myProductGroup_bulkAction_Delete() throws Exception{
		
		data.setBulkOption("Delete Selected Items");
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName)
		.clickOnTheSpecificCheckbox(1)
		.selectBulkActionsDropdown(data.getBulkOption());
		myProductGroupsPage()
		.verifyAlertText(data.getDeleteItemFromProductGroupAlertText().trim());
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
	}
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies editing of group quantity.")
	@TestCaseId("TC_ProductGroup_015")
	@Test(groups={"regression"})
	public void myProductGroup_editGroupName_BlankText() throws Exception {
		
		data.setBulkOption("Update Selected Items");
	
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
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
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName)
		.clickOnEditButton()
		.enterEditGroupName("")
		.clickOnSave()
		.verifyAlertText(data.getPleaseEnterGroupNameALertText());
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");
		}
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
	}
	


	 

		@Features("My Product Group Module")
		@Description("This is a test case which verifies editing of group quantity and verifying changing of extension price.")
		@TestCaseId("TC_ProductGroup_016")
		@Test(groups={"regression"})
		public void verifyChangingOfExtensionPrice() throws Exception {
			
			data.setBulkOption("Update Selected Items");
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			try
			{
			loginModule.loginAsASuperUser(); 
			homePage().logout();
			loginModule.loginAsASuperUser(); 
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificMyProductGroupButton(1)
			.enterGroupName(myProductGroupName)
			.hitEnter()
			.verifyMyProductCreationSuccessMsg(myProductGroupName)
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.verifyBreadCrump(myProductGroupName)
			.verifyPageName(myProductGroupName);
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
			 catch(UnhandledAlertException e)
				{
					TestUtility.alertAccept();
					throw new Exception("Unhandled alert");
				}
				finally
				{
				productGroupDeleteAndVerify(myProductGroupName);
				}
		}
	
			
			
		@Features("My Product Group Module")
		@Description("This is a test case which verifies whether giving quantity 0 empties/removes the item from the cart.")
		@TestCaseId("TC_ProductGroup_019")
		@Test(groups={"regression"})
		public void quantityZeroBulkUpdate() throws Exception {
			
			String searchText = data.getSearchTextForEnlargeImageTest();
			String myProductGroupName = data.getMyProductGroupName();
		try
		{
		data.setBulkOption("Update Selected Items");
		
		loginModule.loginAsASuperUser(); 
		homePage().logout();
		loginModule.loginAsASuperUser(); 
		
		String partNumber = homePage().searchText(searchText).clickOnSearch().productDetailsPage().getPartNumber();
		
		productDetailsPage()
		.clickOnMyProductGroupButton()
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		
		myCartPage()
		.enterQuantityInShoppingCart("0")
		.myProductGroupsPage()
		.clickOnTheSpecificCheckbox(1)
		.verifyAlertText("Min Order Quantity is 1. For PN: "+partNumber+". To Continue with Min Order Qty click \"Ok\".To cancel this item click \"Cancel\"");
		}
		catch(UnhandledAlertException e)
		{
			TestUtility.alertAccept();
			throw new Exception("Unhandled Alert");
			
		}
		
		finally
		{
		productGroupDeleteAndVerify(myProductGroupName);
		}
		}
		
		
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies adding item to cart from my product group.")
		@TestCaseId("TC_ProductGroup_020")
		@Test( groups={"regression"})
		public void addItemToCartFromMyProductGroup() throws Exception {
			
		data.setBulkOption("Add Selected Items to Cart");
		String searchText = data.getSearchTextForEnlargeImageTest();
		String myProductGroupName = data.getMyProductGroupName();
		try
		{
		loginModule.loginAsASuperUser(); 
		homePage().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnMyProductGroupButton()
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName);
		String nameOfTheProductInProductGroup = myProductGroupsPage().getProductNameInShoppingCart();
		
		 myCartPage()
		.enterQuantityInShoppingCart(data.getQuantityForShoppingCartPageVerification());
		 String getQuantityInOfTheProductInMyProductGroup = myProductGroupsPage().getQuantity();
		 myProductGroupsPage()
		.clickOnTheSpecificCheckbox(1)
		.selectBulkActionsDropdown(data.getBulkOption())
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.verifyNameOfTheProductInMyCartPage(nameOfTheProductInProductGroup)
		.verifyUpdateOfQuantityInShoppingCart(getQuantityInOfTheProductInMyProductGroup);
		}
		 catch(UnhandledAlertException e)
			{
				TestUtility.alertAccept();
				throw new Exception("Unhandled alert");
			}
			finally
			{
			productGroupDeleteAndVerify(myProductGroupName);
			}

		}
		

		@Features("My Product Group Module")
		@Description("This is a test case which verifies clicking on my product group in list page when not logged in, provides login pop up.")
		@TestCaseId("TC_ProductGroup_021")
		@Test(groups={"regression"})
		public void createProductGroup_LoginPopUp_Unsigned_ProductListPage() throws Exception {
			loginModule.loginAsASuperUser(); 
			homePage().clickOnUserAccountDropdown().logout();	
		String searchText = data.getSearchText();
		
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.clickOnSpecificMyProductGroupButton(1)
		.loginPopUp()
		.verifyLoginPopUp();
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies clicking on my product group in details page when not logged in, provides login pop up.")
		@TestCaseId("TC_ProductGroup_022")
		@Test(groups={"regression"})
		public void createProductGroup_LoginPopUp_Unsigned_ProductDetailsPage() throws Exception {
			loginModule.loginAsASuperUser(); 
			homePage().clickOnUserAccountDropdown().logout();
		String searchText = data.getSearchTextForEnlargeImageTest();
		
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnMyProductGroupButton()
		.loginPopUp()
		.verifyLoginPopUp();
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies editing the group name.")
		@TestCaseId("TC_ProductGroup_022,TC_ProductGroup_025")
		@Test(groups={"regression"})
		public void editGroupName() throws Exception {
	
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			String editGroupName = myProductGroupName+RandomGenerator.generateCharacters();
		
			try
			{
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
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.verifyBreadCrump(myProductGroupName)
			.verifyPageName(myProductGroupName)
			.clickOnEditButton()
			.enterEditGroupName(editGroupName)
			.clickOnSave()
			 .verifyAlertText(data.getEditGroupNameSuccessAlertText());
			}
			catch(UnhandledAlertException e)
			{
				TestUtility.alertAccept();
				throw new Exception("Unhandled alert");
			}
			finally
			{
			productGroupDeleteAndVerify(editGroupName);
			}
		}	
		
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the error alert message that is provided when an existing group name is edited.")
		@TestCaseId("TC_ProductGroup_023")
		@Test(groups={"regression"})
		public void editGroupName_whenGroupNameIsAlreadyExisting() throws Exception {
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			String editGroupName = data.getMyProductGroupName()+RandomGenerator.generateCharacters();
			try
			{
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
			.verifyMyProductCreationSuccessMsg(myProductGroupName);
			driver.navigate().refresh();
			productListPage().clickOnSpecificMyProductGroupButton(1)
			.enterGroupName(editGroupName)
			.hitEnter();
			homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnEditButton()
			.enterEditGroupName(editGroupName)
			.clickOnSave()
			 .verifyAlertText(data.getGroupNameAlreadyExistsAlertText());
			}
			 catch(UnhandledAlertException e)
				{
					TestUtility.alertAccept();
					throw new Exception("Unhandled alert");
				}
				finally
				{
				productGroupDeleteAndVerify(myProductGroupName);
				}
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the alert message when we click on save while we edit the group name without actually editing it.")
		@TestCaseId("TC_ProductGroup_024")
		@Test(groups={"regression"})
		public void editGroupName_noChangesYetClickingOnSave() throws Exception {
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			try
			{
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
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnEditButton()
			.clickOnSave()
			 .verifyAlertText(data.getNoChangesToGroupNameAlertText());
			}
			 catch(UnhandledAlertException e)
				{
					TestUtility.alertAccept();
					throw new Exception("Unhandled alert");
				}
				finally
				{
				productGroupDeleteAndVerify(myProductGroupName);
				}
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies sort by dropdown after clicking on a my product group.")
		@TestCaseId("TC_ProductGroup_026")
		@Test(groups={"regression"})
		public void verifySortByInMyProductGroups() throws Exception {
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			try
			{
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
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.verifySortByDrodown(data.getExpectedSortByOptionsInMyProductGroups().split(","));
			}
			 catch(UnhandledAlertException e)
				{
					TestUtility.alertAccept();
					throw new Exception("Unhandled alert");
				}
				finally
				{
				productGroupDeleteAndVerify(myProductGroupName);
				}
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies that while creating a group name, the textbox takes only 25 characters.")
		@TestCaseId("TC_ProductGroup_027")
		@Test(groups={"regression"})
		public void verifyGroupNameCreation_Is_Limited_To_25_Characters() throws Exception {
			 
			
			String searchText = data.getSearchText();
	
			String myProductGroupName = data.getMyProductGroupName()+Integer.toString(RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers());
			String groupNameCreationVerification = myProductGroupName.substring(0, Math.min(myProductGroupName.length(), 25));
			try
			{
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
			.verifyMyProductCreationSuccessMsg(groupNameCreationVerification)
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(groupNameCreationVerification)
			.verifyPageName(groupNameCreationVerification)
			.verifyBreadCrump(groupNameCreationVerification);
			}
			 catch(UnhandledAlertException e)
				{
					TestUtility.alertAccept();
					throw new Exception("Unhandled alert");
				}
				finally
				{
				productGroupDeleteAndVerify(myProductGroupName);
				}
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies select all checkbox and update quantity using the update selected items checkbox.")
		@TestCaseId("TC_ProductGroup_028")
		@Test( groups={"regression"})
		public void verifyGroupNameSelectAllItemsAndUpdate() throws Exception {
	
			data.setBulkOption("Update Selected Items");
			String searchText = data.getSearchTextForEnlargeImageTest();
			String myProductGroupName = data.getMyProductGroupName();
			try
			{
			loginModule.loginAsASuperUser(); 
			homePage().logout();	
			loginModule.loginAsASuperUser(); 
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnMyProductGroupButton()
			.enterGroupName(myProductGroupName)
			.hitEnter()
			.verifyMyProductCreationSuccessMsg(myProductGroupName)
			.homePage()
			.searchText(data.getSearchTextForAnotherItem())
			.clickOnSearch()
			.productDetailsPage()
			.clickOnMyProductGroupButton()
			.enterGroupName(myProductGroupName)
			.hitEnter()
			.verifyMyProductCreationSuccessMsg(myProductGroupName)
			.homePage()
			.clickOnUserAccountDropdown()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.verifyBreadCrump(myProductGroupName)
			.verifyPageName(myProductGroupName)
			.myCartPage()
			.enterQuantitiesInShoppingCartForMultipleItems(data.getQuantityForShoppingCartPageVerification())
			.myProductGroupsPage()
			.clickOnSelectAllCheckbox()
			.selectBulkActionsDropdown(data.getBulkOption())
			.myCartPage()
			.verifyQuantitiesInShoppingCartForMultipleItems(data.getQuantityForShoppingCartPageVerification());
			}
			catch(UnhandledAlertException e)
			{
				TestUtility.alertAccept();
				throw new Exception("Unhandled alert");
			}
			finally
			{
			productGroupDeleteAndVerify(myProductGroupName);
			}
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the alert text when of every bulk option when no item is selected.")
		@TestCaseId("TC_ProductGroup_029")
		@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
		public void pG_bulkAlert_ItemNotChosen(String testcaseId,String bulkOption,String expectedAlertText) throws Exception {
			
			
			
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			try
			{
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
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.selectBulkActionsDropdown(bulkOption)
			.verifyAlertText(expectedAlertText);
			}
			catch(UnhandledAlertException e)
			{
				TestUtility.alertAccept();
				throw new Exception("Unhandled alert");
			}
			finally
			{
			productGroupDeleteAndVerify(myProductGroupName);
			}
			
		}	
}