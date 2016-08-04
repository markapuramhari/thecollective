package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;

public class PDPModuleTest extends PageFactoryInitializer {
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("PDP Module")
	@Test(groups={"PDPModule","regression"})
	  public void TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest() throws Exception
	  {
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
	  	//.verifyDisplayOfShipBranchName()
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
	  @Test(groups={"PDPModule","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	  public void TC_PDP_009_TC_PDP_010_ShareFunctionalityTest(String testCaseId,String friendName,String friendEmailAddress,String fromName,String fromEmailAddress,String subject) throws Exception{
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
	  @Test(groups={"PDPModule","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	  public void TC_PDP_009_TC_PDP_010_ShareFunctionalityTest_ErrorScenarios(String testCaseId,String friendName,String friendEmailAddress,String fromName,String fromEmailAddress,String subject,String errorMsg) throws Exception{
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
	  @Test(groups={"PDPModule","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	  public void signedUser_cpnCreateProductDetailsPage_ErrorScenariosTest(String testCaseId,@Parameter("CPN")String customerPartNumber,@Parameter("Expected Alert Text") String expectedAlertMsg) throws Exception{
	  	
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
	  
}
	