package org.etna.modules;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.testng.SkipException;

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
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		productGroupDeleteAndVerify(myProductGroupName);
	}
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies whether on clicking the success message when creating a product group, My Product Group page should be opened with the group created and the respective item added to the group.")
	@TestCaseId("TC_ProductGroup_003,TC_ProductGroup_004")
	@Test(groups={"regression"})
	public void verifyClickingOnSuccessMessageOnGroupCreation_ProductListPage() throws Exception{
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		productGroupDeleteAndVerify(myProductGroupName);
		
}	
	

	@Features("My Product Group Module")
	@Description("This is a test case which verifies whether a product group is created when the product list page is in Grid view.")
	@TestCaseId("TC_ProductGroup_005")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_GridView_ProductListPage() throws Exception {
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		productGroupDeleteAndVerify(myProductGroupName);
	}	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies for the alert text when we hit enter without providing any data.")
	@TestCaseId("TC_ProductGroup_007")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_errorMessage_BlankText() throws Exception {
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
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies for the alert text when we hit enter without providing any data.")
	@TestCaseId("TC_ProductGroup_008")
	@Test(groups={"regression"})
	public void verifyMyProductCreation_errorMessage_JustSpaces() throws Exception {
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
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies adding product to an existing my product group in list view.")
	@TestCaseId("TC_ProductGroup_010")
	@Test(groups={"regression"})
	public void verifyAddingProductToExsistingMyProductGroup_ListView() throws Exception {
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		productGroupDeleteAndVerify(myProductGroupName);
	}
	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies adding product to an existing my product group in grid view.")
	@TestCaseId("TC_ProductGroup_010")
	@Test(groups={"regression"})
	public void verifyAddingProductToExsistingMyProductGroup_GridView() throws Exception {
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		productGroupDeleteAndVerify(myProductGroupName);
	}	
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies My Product groups landing page and also the page which is displayed after clicking on my product group.")
	@TestCaseId("TC_ProductGroup_013,TC_ProductGroup_030,TC_ProductGroup_031,TC_ProductGroup_032,TC_ProductGroup_033")
	@Test(groups={"regression"})
	public void verifyMyProductGroupPage() throws Exception {
		loginModule.loginAsASuperUser(); 
		
		String myProductGroupNameThatWasClicked = 
		homePage()
		.navigateToMyProductGroups()
		.myProductGroupsPage()
		.verifyPageTitle(data.getMyProductGroupLandingPageTitle(),setUp.getProductName())
		.verifyPageNameOfMyProductGroupLandingPage(data.getMyProductGroupsPageName())
		.verifyBreadCrumpOfMyProductGroupLandingPage(data.getMyProductGroupsPageName())
		.clickOnSpecficProductGroupAndGetProductName(1);
		myProductGroupsPage()
		.verifyPageName(myProductGroupNameThatWasClicked)
		.verifyBreadCrump(myProductGroupNameThatWasClicked)
		.verifyPageTitle(data.getMyProductGroupsPageName().replace("My", "").replace("s", "").trim(), setUp.getProductName())
		.verifyMyProductGroupPageAfterClickingOnTheProduct();
	}
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies deleting items bulk action scenario.")
	@TestCaseId("TC_ProductGroup_014")
	@Test(groups={"regression"})
	public void myProductGroup_bulkAction_Delete() throws Exception{
		data.setBulkOption("Delete Selected Items");
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();

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
	
	@Features("My Product Group Module")
	@Description("This is a test case which verifies editing of group quantity.")
	@TestCaseId("TC_ProductGroup_015")
	@Test(groups={"regression"})
	public void myProductGroup_editGroupName_BlankText() throws Exception {
		data.setBulkOption("Update Selected Items");
		loginModule.loginAsASuperUser(); 
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		
		productGroupDeleteAndVerify(myProductGroupName);
	}
	


	 

		@Features("My Product Group Module")
		@Description("This is a test case which verifies editing of group quantity and verifying changing of extension price.")
		@TestCaseId("TC_ProductGroup_016")
		@Test(enabled=false,groups={"regression"})
		public void verifyChangingOfExtensionPrice() throws Exception {
			
			data.setBulkOption("Update Selected Items");
			
			loginModule.loginAsASuperUser(); 
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			
			
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
			 productGroupDeleteAndVerify(myProductGroupName);
		}
	
			
			
		@Features("My Product Group Module")
		@Description("This is a test case which verifies whether giving quantity 0 empties/removes the item from the cart.")
		@TestCaseId("TC_ProductGroup_019")
		@Test(enabled=false,groups={"regression"})
		public void quantityZeroBulkUpdate() throws Exception {
			
		data.setBulkOption("Update Selected Items");
		
		loginModule.loginAsASuperUser(); 
		
		
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();

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
		.myCartPage()
		.enterQuantityInShoppingCart("0")
		.myProductGroupsPage()
		.clickOnTheSpecificCheckbox(1)
		.selectBulkActionsDropdown(data.getBulkOption())
		.verifyNoItemsInGroupMessage();
		}
		
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies adding item to cart from my product group.")
		@TestCaseId("TC_ProductGroup_020")
		@Test(enabled=false,groups={"regression"})
		public void addItemToCartFromMyProductGroup() throws Exception {
			
		data.setBulkOption("Add Selected Items to Cart");
		String searchText = data.getSearchText();
		String myProductGroupName = data.getMyProductGroupName();
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
		String nameOfTheProductInProductGroup = myProductGroupsPage().getProductNameInShoppingCart();
		
		 myCartPage()
		.enterQuantityInShoppingCart(data.getQuantityForShoppingCartPageVerification());
		 String getQuantityInOfTheProductInMyProductGroup = myProductGroupsPage().getQuantity();
		 myProductGroupsPage()
		.clickOnTheSpecificCheckbox(1)
		.selectBulkActionsDropdown(data.getBulkOption())
		.myCartPage()
		.verifyNameOfTheProductInMyCartPage(nameOfTheProductInProductGroup)
		.verifyUpdateOfQuantityInShoppingCart(getQuantityInOfTheProductInMyProductGroup);
		productGroupDeleteAndVerify(myProductGroupName);

		}
		

		@Features("My Product Group Module")
		@Description("This is a test case which verifies clicking on my product group in list page when not logged in, provides login pop up.")
		@TestCaseId("TC_ProductGroup_021")
		@Test(groups={"regression"})
		public void createProductGroup_LoginPopUp_Unsigned_ProductListPage() throws Exception {
			
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
	
			
			loginModule.loginAsASuperUser(); 
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			String editGroupName = myProductGroupName+RandomGenerator.generateCharacters();
		
			
			
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
			  
			productGroupDeleteAndVerify(editGroupName);
			
		}	
		
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the error alert message that is provided when an existing group name is edited.")
		@TestCaseId("TC_ProductGroup_023")
		@Test(groups={"regression"})
		public void editGroupName_whenGroupNameIsAlreadyExisting() throws Exception {
	
			loginModule.loginAsASuperUser(); 
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			
			String editGroupName = homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificMyProductGroupButton(1)
			.enterGroupName(myProductGroupName)
			.hitEnter()
			.verifyMyProductCreationSuccessMsg(myProductGroupName)
			.clickOnMyProductGroups()
			.myProductGroupsPage()
			.getSpecificGroupName(1);
			myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnEditButton()
			.enterEditGroupName(editGroupName)
			.clickOnSave()
			 .verifyAlertText(data.getGroupNameAlreadyExistsAlertText())
			 .homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText())
			.homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the alert message when we click on save while we edit the group name without actually editing it.")
		@TestCaseId("TC_ProductGroup_024")
		@Test(groups={"regression"})
		public void editGroupName_noChangesYetClickingOnSave() throws Exception {
	
			loginModule.loginAsASuperUser(); 
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			
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
			 .verifyAlertText(data.getNoChangesToGroupNameAlertText())
			 .homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText())
			.homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies sort by dropdown after clicking on a my product group.")
		@TestCaseId("TC_ProductGroup_026")
		@Test(groups={"regression"})
		public void verifySortByInMyProductGroups() throws Exception {
	
			loginModule.loginAsASuperUser(); 
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();
			
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
			.verifySortByDrodown(data.getExpectedSortByOptionsInMyProductGroups().split(","))
			 .homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText())
			.homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies that while creating a group name, the textbox takes only 25 characters.")
		@TestCaseId("TC_ProductGroup_027")
		@Test(groups={"regression"})
		public void verifyGroupNameCreation_Is_Limited_To_25_Characters() throws Exception {
	
			loginModule.loginAsASuperUser(); 
			
			String searchText = data.getSearchText();
	
			String myProductGroupName = data.getMyProductGroupName()+Integer.toString(RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers()+RandomGenerator.generateEightRandomNumbers());
			String groupNameCreationVerification = myProductGroupName.substring(0, Math.min(myProductGroupName.length(), 25));
			
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
			.verifyBreadCrump(groupNameCreationVerification)
			.homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.clickOnTheGroupCreated(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText())
			.homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies select all checkbox and update quantity using the update selected items checkbox.")
		@TestCaseId("TC_ProductGroup_028")
		@Test(enabled=false,groups={"regression"})
		public void verifyGroupNameSelectAllItemsAndUpdate() throws Exception {
	
			data.setBulkOption("Update Selected Items");
			
			loginModule.loginAsASuperUser(); 

			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();

			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificMyProductGroupButton(1)
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
			.verifyQuantitiesInShoppingCartForMultipleItems(data.getQuantityForShoppingCartPageVerification())
			.myProductGroupsPage()
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText());
			homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
		
		@Features("My Product Group Module")
		@Description("This is a test case which verifies the alert text when of every bulk option when no item is selected.")
		@TestCaseId("TC_ProductGroup_029")
		@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
		public void verifyEveryBulkOptionAlertTextWhenNoItemIsSelected(String testcaseId,String bulkOption,String expectedAlertText) throws Exception {
	
			
			loginModule.loginAsASuperUser(); 
			
			
			String searchText = data.getSearchText();
			String myProductGroupName = data.getMyProductGroupName();

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
			.verifyAlertText(expectedAlertText)
			.myProductGroupsPage()
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText());
			homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			
		}	
}