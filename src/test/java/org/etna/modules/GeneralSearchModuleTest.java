package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class GeneralSearchModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	@Features("General Search Module")
	@TestCaseId("TC_General Search_001")
	@Description("This is a test case which verifies the placeholder and search button of the search field.")
	@Test(groups={"GeneralSearchModule","regression"})
	public void verifySearchPlaceHolderAndGoButton() throws Exception
		  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
					
			  		homePage()
			  		.verifyPlaceHolderOfSearchTextbox(data.getExpectedSearchTexboxPlaceholder())
			  		.verifyDisplayOfSearchTextboxButton();
			  		
		}
	
	
	
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_003")
	@Description("This is a test case which verifies the product details/list page when part number is provided.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifySearchFunctionality_PartNumber() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		homePage()
  		.searchText(data.getSearchTextForEnlargeImageTest())
  		.clickOnSearch()
  		.productDetailsPage()
  		.verifyPartNumberInProductDetailsPage(data.getSearchTextForEnlargeImageTest()); 	
	}
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_004")
	@Description("This is a test case which verifies the product details/list page when partial part number is provided.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifySearchFunctionality_PartialPartNumber() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
				String partNumber = data.getPartialPartNumber();
				String partialPartNumber = partNumber.substring(0, 2);
		  		homePage()
		  		.searchText(partialPartNumber)
		  		.clickOnSearch()
		  		.productListPage()
		  		.verifyListOfProducts()
				.verifyFilterSection()
				.verifyCompareLinkLocator()
				.verifyResultsPerPageDropdown();
	}
	
	

	@Features("General Search Module")
	@TestCaseId("TC_General Search_005")
	@Description("This is a test case which verifies searching of for manufacturer part number.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifySearchFunctionality_MPN() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchTextForMPNTest())
		  		.clickOnSearch()
		  		.productDetailsPage()
		  		.verifyManufacturerPartNumberInProductDetailsPage(data.getSearchTextForMPNTest()); 		
	}
	
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_006")
	@Description("This is a test case which verifies searching of for UPC.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifySearchFunctionality_UPC() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchTextForUPCLabelTest())
		  		.clickOnSearch()
		  		.productDetailsPage()
		  		.verifyUPCInProductDetailsPage(data.getSearchTextForUPCLabelTest());
	}
	
	
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_007")
	@Description("This is a test case which verifies the product details/list page when keywords is provided.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifyPDPNavigationOfSearchFunctionality_Keyword() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchTextKeyword())
		  		.clickOnSearch()
		  		.productListPage()
		  		.verifyListOfProducts()
				.verifyFilterSection()
				.verifyCompareLinkLocator()
				.verifyDisplaySortByDropdown()
				.verifyResultsPerPageDropdown();
	}
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_008")
	@Description("This is a test case which verifies the alert message when clicking on go without providing any searchtext.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifyAlertMessageWhenGoButtonIsClickedWithoutProvidingSearchText() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
				homePage()
		  		.clickOnSearch()
		  		.verifyAlertMessage(data.getAlertMessageWhenGoButtonIsClickedWithProvidingSearchText());
	}
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_009")
	@Description("This is a test case which verifies the text message  that is displayed when search input is invalid.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifyInvalidSearch() throws Exception
	  {
				homePage()
		  		.searchText(data.getSearchTextForInvalidTestData())
		  		.clickOnSearch()
		  		.verifyMessageForInvalidSearchData(data.getSearchTextForInvalidTestData());
	}
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_010")
	@Description("This is a test case which verifies the narrow search for part number.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifySearchFunctionality_narrowSearch_partNumber() throws Exception
	  
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.enterSearchTextInNarrowFilterTextbox(data.getSearchTextForEnlargeImageTest())
		  		.clickOnNarrowSearchButton()
		  		.productDetailsPage()
		  		.verifyPartNumberInProductDetailsPage(data.getSearchTextForEnlargeImageTest());
		  		
	}
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_010")
	@Description("This is a test case which verifies the narrow search for manufacturer part number.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifyPDPNavigationOfSearchFunctionality_narrowSearch_MPN() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.enterSearchTextInNarrowFilterTextbox(data.getSearchTextForMPNTest())
		  		.clickOnNarrowSearchButton()
		  		.productDetailsPage()
		  		.verifyManufacturerPartNumberInProductDetailsPage(data.getSearchTextForMPNTest()); 		
	}
	
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_010")
	@Description("This is a test case which verifies the narrow search for UPC.")
	@Test(groups={"GeneralSearchModule","regression"})
	  public void verifyPDPNavigationOfSearchFunctionality_narrowSearch_UPC() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchText())
		  		.clickOnSearch()
		  		.productListPage()
		  		.enterSearchTextInNarrowFilterTextbox(data.getSearchTextForUPCLabelTest())
		  		.clickOnNarrowSearchButton()
		  		.productDetailsPage()
		  		.verifyUPCInProductDetailsPage(data.getSearchTextForUPCLabelTest()); 		
	}
	
	
	@Features("General Search Module")
	@TestCaseId("TC_General Search_011")
	@Description("This is a test case which verifies the product details/list page when manufacturer name is provided.")
	@Test(groups={"GeneralSearchModule","smoke","regression"})
	  public void verifyPDPNavigationOfSearchFunctionality_ManufacturerName() throws Exception
	  {
		loginModule.loginAsASuperUser(); 
		homePage().clickOnUserAccountDropdown().logout();
		loginModule.loginAsASuperUser(); 
		  		homePage()
		  		.searchText(data.getSearchTextForGeneralSearch())
		  		.clickOnSearch()
		  		.productDetailsPage()
		  		.verifyPDPPageTitle()
		  		.verifyDisplayOfItemName(data.getSearchTextForGeneralSearch());
	}	
}
