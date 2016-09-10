package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.SkipException;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class PDPModuleTest extends PageFactoryInitializer {
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	MyProductGroupModuleTest myProductGroup = new MyProductGroupModuleTest();
	@Features("PDP Module")
	@Test(groups={"PDPModule","regression"})
	  public void TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest() throws Exception
	  {
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	String searchText = data.getSearchTextForGeneralSearch();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.verifyPDPPageTitle()
	  	.verifyPDPFilterSectionToggleButtons()
	  	.verifyDisplayOfItemName(searchText)
	  	.verifyDisplayOfPartNumber()
	  	.verifyDisplayOfMPN()
	  	.verifyDisplayOfMinimumOrderQuantity()
	  	.verifyDisplayOfQuantityInterval()
	  	.verifyDisplayOfYourPrice()
	  	.verifyDisplayOfQuantity()
	  	.verifyDisplayOfPrintLink()
	  	.verifyToolTipOfPrintLink()
	  	.verifyDisplayOfShare()
	  	.verifyDisplayOfAccordians()
	  	.verifyDisplayOfCustomerPartNumberButton()
	  	.verifyAddToCartButton()
	  	.verifyDisplayOfAddMyProductGroupButton()
	  	.verifyBreadCrump();
	  }

	@Features("PDP Module")
	@Test(alwaysRun=true,groups={"smoke","regression"})
	  public void TC_PD_002_TC_PD_004_signedUser_verifyProductDetailsPageTest() throws Exception
	  {
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	String searchText = data.getSearchTextForGeneralSearch();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.verifyPDPPageTitle()
	  	.verifyPDPFilterSectionWhenLoggedIn()
	  	.verifyPDPFilterSectionToggleButtons()
	  	.verifyDisplayOfItemName(searchText)
	  	.verifyDisplayOfPartNumber()
	  	.verifyDisplayOfMPN()
	  	.verifyDisplayOfMinimumOrderQuantity()
	  	.verifyDisplayOfQuantityInterval()
	  	.verifyDisplayOfYourPrice()
	  	.verifyDisplayOfQuantity()
	  	.verifyDisplayOfPrintLink()
	  	.verifyToolTipOfPrintLink()
	  	.verifyDisplayOfShare()
	  	.verifyDisplayOfAccordians()
	  	.verifyDisplayOfCustomerPartNumberButton()
	  	.verifyAddToCartButton()
	  	.verifyDisplayOfAddMyProductGroupButton()
	  	.verifyBreadCrump();
	  }


	@Features("PDP Module")
	 @Test(groups={"PDPModule","regression"})
	  public void TC_PDP_006_enlargeImageFunctionalityTest() throws Exception
	  	{
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	String searchText = data.getSearchTextForEnlargeImageTest();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage();
	  	int height = productDetailsPage().getHeightOfTheImage();
	  	int width = productDetailsPage().getWidthOfTheImage();
	  	productDetailsPage()
	  	.clickOnEnlargeIcon()
	  	.verifyImageHeightAndWidthAfterEnlarge(height,width);
	  	}


	@Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void TC_PDP_008_PrintFunctionalityTest(){
	  	throw new SkipException("Feature not yet completely developed.");
	  }


	@Features("PDP Module")
	  @Test(groups={"PDPModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	  public void ShareFunctionality(String testCaseId,String friendName,String friendEmailAddress,String fromName,String fromEmailAddress,String subject) throws Exception{
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(data.getSearchTextForMPNTest())
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.clickOnShareLink()
	  	.enterFriendName(friendName)
	  	.enterFriendEmailAddress(friendEmailAddress)
	  	.enterFromName(fromName)
	  	.enterFromEmailAddress(fromEmailAddress)
	  	.enterSubject(subject)
	  	.clickOnSend();
	  }
	
	@Features("PDP Module")
	  @Test(groups={"PDPModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	  public void ShareFunctionality_ES(String testCaseId,String friendName,String friendEmailAddress,String fromName,String fromEmailAddress,String subject,String errorMsg) throws Exception{
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(data.getSearchTextForMPNTest())
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.clickOnShareLink()
	  	.enterFriendName(friendName)
	  	.enterFriendEmailAddress(friendEmailAddress)
	  	.enterFromName(fromName)
	  	.enterFromEmailAddress(fromEmailAddress)
	  	.enterSubject(subject)
	  	.clickOnSend()
	  	.verifyErrorMessage(errorMsg);
	  }


	@Features("PDP Module")
	  @Test(groups={"PDPModule","smoke","regression"})
	  public void createAndDeleteCPNInProductDetailsPageTest() throws Exception{
	  	
	  	String searchText = data.getSearchTextForEnlargeImageTest();
	  	String customerPartNumber = data.getCustomerPartNumber();
	  	loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()  
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.clickOnCheckbox(customerPartNumber)
	  	.clickOnRemove()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.verifyDeletionOfCPN(customerPartNumber);
	  	}

	@Features("PDP Module")
	  @Test(groups={"PDPModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	  public void signedUser_cpnPDP_ES(String testCaseId,@Parameter("CPN")String customerPartNumber,@Parameter("Expected Alert Text") String expectedAlertMsg) throws Exception{
	  	
		String searchText = data.getSearchTextForEnlargeImageTest();
	 	loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddOrRemoveCustomerPartNumber()
		.enterCPN(customerPartNumber)
		.clickOnAddButton()
		.myProductGroupsPage()
		.verifyAlertText(expectedAlertMsg);
	  	}
	
      
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void cpn_clickAdd_ErrorScenarioTest() throws Exception{
	  
		String searchText = data.getSearchTextForEnlargeImageTest();
	  	String customerPartNumber = data.getCustomerPartNumber();
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()  
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.clickOnAddButton()
		.myProductGroupsPage()
		.verifyAlertText(data.getExpectedAlertTextCPNForAddButton())
		.productDetailsPage()
		.clickOnCheckbox(customerPartNumber)
		.clickOnRemove()
		.clickOnAddOrRemoveCustomerPartNumber()
		.verifyDeletionOfCPN(customerPartNumber);
	  	}
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void cpn_clickRemove_ErrorScenarioTest() throws Exception{
	  	
		String searchText = data.getSearchTextForEnlargeImageTest();
	  	String customerPartNumber = data.getCustomerPartNumber();
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()  
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.clickOnRemove()
		.myProductGroupsPage()
		.verifyAlertText(data.getExpectedAlertTextCPNForRemoveButton())
		.productDetailsPage()
		.clickOnCheckbox(customerPartNumber)
		.clickOnRemove()
		.clickOnAddOrRemoveCustomerPartNumber()
		.verifyDeletionOfCPN(customerPartNumber);
	  	}
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void creating_Same_CPN_ErrorScenarioTest() throws Exception{
	  	
		String searchText = data.getSearchTextForEnlargeImageTest();
	  	String customerPartNumber = data.getCustomerPartNumber();
		loginModule.loginAsASuperUser();
	  	homePage().logout();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()  
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.myProductGroupsPage()
	  	.verifyAlertText(data.getAlertTextForCPNAlreadyExists())
	  	.productDetailsPage()
	  	.clickOnCheckbox(customerPartNumber)
	  	.clickOnRemove()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.verifyDeletionOfCPN(customerPartNumber);
	  	}
	  
		@Features("PDP Module")
		@Test(groups={"PDPModule","smoke","regression"})
		public void TC_PDP_011_signedUser_createAndDeleteMyProductGroupInProductDetailsPage() throws Exception{
			if(setUp.getBrowser().equalsIgnoreCase("safari"))
			{
				throw new SkipException("The SafariDriver developed by Selenium unfortunately does not support interacting with modal dialogs.");
			}
			else
			{
			String searchText = data.getSearchTextForUPCLabelTest();
			String myProductGroupName = data.getMyProductGroupName();
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
			.verifyPageName(myProductGroupName)
			.clickOnDelete()
			.verifyAlertText(data.getDeleteGroupAlertText());
			homePage()
			.navigateToMyProductGroups()
			.myProductGroupsPage()
			.verifyPageName()
			.verifyWhetherGroupIsDeleted(myProductGroupName);
			}
		}
	  
	@Features("PDP Module")
	  @Test(groups={"PDPModule","smoke","regression"})
	  public void tc005_ListViewGridView() throws Exception
	  {
		loginModule.loginAsASuperUser();
	  	homePage().logout();
		  String searchText = data.getSearchText();
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .verifyListView()
		  .clickOnChangeView()
		  .verifyGridView();
	  }
	
	@Features("PDP Module")
	  @Test(groups={"PDPModule","smoke","regression"})
	  public void tc006_verifyProductListPage_ShowResultsPerPage() throws Exception
	  {
		loginModule.loginAsASuperUser();
	  	homePage().logout();
		  		String searchText = data.getSearchTextForProductListPage();
		  		data.setShowItemsPerPage(24);
		  		int showItemsPerPage = data.getShowItemsPerPage();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.verifyListOfProducts()
				.verifyFilterSection()
				.verifyCompareLinkLocator()
				.verifySortByDropdown(data.getExpectedSortByOptions().split(","))
				.verifyResultsPerPageDropdown()
				.verifyShowItemsPerPage(showItemsPerPage);
	  }
	
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void multiple_UOM_ProductListPage() throws Exception
	  {
		
		  		loginModule.loginAsASuperUser();
	  			homePage().logout();
	  			loginModule.loginAsASuperUser();
		  		String searchText = data.getSearchText();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.verifyUOMDropdown(data.getExpectedOptionsFromUOMDropdown().split(","));
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  public void multiple_UOM_ProductDetailPage() throws Exception
	  {
		
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		String searchText = data.getSearchTextForThirdItem();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificItemWhichHasUOM(1)
				.verifyUOMDropdown(data.getExpectedOptionsFromUOMDropdown().split(","));
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void multiple_UOM_PDP_PriceUpdate() throws Exception
	  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		data.setSpecificUOM("bx(25)");	
		  		String uomArray[] = data.getSpecificUOM().split("\\(");
		  		String uomName = uomArray[0];
		  		String quantity = uomArray[1];
				Number priceForSingleItem = homePage()
				.searchText(data.getSearchTextForThirdItem())
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificItemWhichHasUOM(1)
				.getPriceForSingleItem();
				productDetailsPage()
				.selectSpecificUOM(data.getSpecificUOM())
				.checkUOMChange(uomName)
				.checkLatestPrice(priceForSingleItem,quantity.replace("(", "").replace(")", ""));
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void multiple_UOM_PLP_PriceUpdate() throws Exception
	  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		data.setSpecificUOM("pl(450)");	
		  		String uomArray[] = data.getSpecificUOM().split("\\(");
		  		String uomName = uomArray[0];
		  		String quantity = uomArray[1];
				Number priceForSingleItem = homePage()
				.searchText(data.getSearchText())
				.clickOnSearch()
				.productListPage()
				.getPriceForSingleItemWhichHasMultipleUOM();
				productListPage()
				.selectSpecificUOM(data.getSpecificUOM())
				.checkUOMChange(uomName)
				.checkLatestPriceForItemThatHasMultipleUOM(priceForSingleItem,quantity.replace("(", "").replace(")", ""));
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void multiple_UOM_PLP_MyCartVerification() throws Exception
	  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		data.setSpecificUOM("pl(450)");	
		  		
		  		String priceForSingleItemWithUOM = homePage()
						.searchText(data.getSearchText())
						.clickOnSearch()
						.productListPage()
						.getPriceForSingleItemWhichHasMultipleUOMWithTheUOM();
				
				productListPage()
				.selectSpecificUOM(data.getSpecificUOM());
				
				Number priceAfterUOMSelection = productListPage().getPriceForSingleItemWhichHasMultipleUOM();
				
				productListPage()
				.clickOnAddToCartBWhichHasMultipleUOM(1)
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.verifyPerUnitPrice(priceForSingleItemWithUOM)
				.verifyUOM(data.getSpecificUOM())
				.verifyExtPrice(priceAfterUOMSelection)
				.verifyTotalPrice(priceAfterUOMSelection);
	  }
	  
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void multiple_UOM_PDP_MyCartVerification() throws Exception
	  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		data.setSpecificUOM("pl(450)");	
		  		
		  		String priceForSingleItemWithUOM = homePage()
						.searchText(data.getSearchTextForThirdItem())
						.clickOnSearch()
						.productListPage()
						.clickOnSpecificItem(1)
						.getPriceForSingleItemWhichHasMultipleUOMWithTheUOM();
				
				productDetailsPage()
				.selectSpecificUOM(data.getSpecificUOM());
				
				Number priceAfterUOMSelection = productDetailsPage().getPriceForSingleItemWhichHasMultipleUOM();
				
				productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.verifyPerUnitPrice(priceForSingleItemWithUOM)
				.verifyUOM(data.getSpecificUOM())
				.verifyExtPrice(priceAfterUOMSelection)
				.verifyTotalPrice(priceAfterUOMSelection);
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void createPGPLPInPopUp() throws Exception
	  {
		  try
		  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificSelectItemOfAProductInSKUMode(1)
		  		.clickOnAddToMyProductGroupFromSlider()
		  		.myProductGroupPopUp()
		  		.enterProductGroupName(data.getMyProductGroupName())
		  		.clickOnAddNewGroup()
		  		.clickOnAddButton()
		  		.verifySuccessMsg()
		  		.clickOnTheCreatedProductGroup(data.getMyProductGroupName())
		  		.myProductGroupsPage()
		  		.verifyPageName(data.getMyProductGroupName())
		  		.verifyBreadCrump(data.getMyProductGroupName());
		  }
		  catch(UnhandledAlertException e){
				TestUtility.alertAccept();
				throw new Exception("Alert not handled.");
			}
			finally{
				myProductGroup.productGroupDeleteAndVerify(data.getMyProductGroupName());
			}
	  }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"},dataProvider="mutipleSheetsSingleWorkbook", dataProviderClass=SearchData.class)
	  @TestCaseId("{0}")
	  public void pG_PLPInPopUp_ES(String testCaseId,String productGroupName,String expectedAlertText) throws Exception
	  {
		  try
		  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificSelectItemOfAProductInSKUMode(1)
		  		.clickOnAddToMyProductGroupFromSlider()
		  		.myProductGroupPopUp()
		  		.enterProductGroupName(productGroupName)
		  		.clickOnAddNewGroup()
		  		.myProductGroupsPage()
		  		.verifyAlertText(expectedAlertText);
		  }
		  catch(UnhandledAlertException e){
				TestUtility.alertAccept();
				throw new Exception("Alert not handled.");
			}
	 }
	  
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void pG_PLP_CreatingPGSameName() throws Exception
	  {
		  try
		  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificSelectItemOfAProductInSKUMode(1)
		  		.clickOnAddToMyProductGroupFromSlider()
		  		.myProductGroupPopUp()
		  		.enterProductGroupName(data.getMyProductGroupName())
		  		.clickOnAddNewGroup()
		  		.enterProductGroupName(data.getMyProductGroupName())
		  		.clickOnAddNewGroup()
		  		.myProductGroupsPage()
		  		.verifyAlertText(data.getGroupNameAlreadyExistsInPGPopUpAlertText());
		  }
		  catch(UnhandledAlertException e){
				TestUtility.alertAccept();
				throw new Exception("Alert not handled.");
			}
	 }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void pG_PLP_NoGroupSelected_ES() throws Exception
	  {
		  try
		  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificSelectItemOfAProductInSKUMode(1)
		  		.clickOnAddToMyProductGroupFromSlider()
		  		.myProductGroupPopUp()
		  		.enterProductGroupName(data.getMyProductGroupName())
		  		.clickOnAddNewGroup()
		  		.clickOnTheGroupCreatedInTheList(data.getMyProductGroupName())
		  		.clickOnAddButton()
		  		.myProductGroupsPage()
		  		.verifyAlertText(data.getAlertTextNoGroupSelected());
		  }
		  catch(UnhandledAlertException e){
				TestUtility.alertAccept();
				throw new Exception("Alert not handled.");
			}
	 }
	  
	  @Features("PDP Module")
	  @Test(groups={"PDPModule","regression"})
	  @TestCaseId("{0}")
	  public void pG_PLP_PGCheckbox() throws Exception
	  {
		  try
		  {
		  		loginModule.loginAsASuperUser();
		  		homePage().logout();
		  		loginModule.loginAsASuperUser();
		  		
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnSpecificSelectItemOfAProductInSKUMode(1)
		  		.clickOnAddToMyProductGroupFromSlider()
		  		.myProductGroupPopUp()
		  		.enterProductGroupName(data.getMyProductGroupName())
		  		.clickOnAddNewGroup()
		  		.verifyCheckboxAssociatedWithTheProductGroupIsSelected();
		  }
		  catch(UnhandledAlertException e){
				TestUtility.alertAccept();
				throw new Exception("Alert not handled.");
			}
	 }
}

	