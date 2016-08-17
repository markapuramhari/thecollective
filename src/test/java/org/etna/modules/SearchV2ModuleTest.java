package org.etna.modules;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;

public class SearchV2ModuleTest extends PageFactoryInitializer {
	
	LoginModuleTest loginModule = new LoginModuleTest();
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for part number.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_PN(String testCaseId,@Parameter("Search Keyword Part Number") String searchKeyword) throws Exception
	{
		 
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyPartNumberInProductDetailsPage(searchKeyword);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for manufacturer part number.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_MPN(String testCaseId,@Parameter("Search Keyword MPN") String searchKeyword) throws Exception
	{
		 
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyword);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for UPC.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_UPC(String testCaseId,@Parameter("Search Keyword UPC") String searchKeyword) throws Exception
	{
		 
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyUPCInProductDetailsPage(searchKeyword);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for brand name or MPN when given together.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("TC_Searchv2_001")
	public void keyword_ExactMatching_BNOrMPN(String testCaseId,@Parameter("Brand Name Or MPN") String searchKeyword) throws Exception
	{
		 String [] searchKeyWordArray = searchKeyword.split(" ");
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0])
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[1])
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyWordArray[1]);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Part Number or Manufacturer Part Number.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("TC_Searchv2_002")
	public void keyword_ExactMatch_PNOrMPN(String testCaseId,@Parameter("Part Number Or MPN") String searchKeyword) throws Exception
	{
		String [] searchKeyWordArray = searchKeyword.split(" ");
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[1])
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[0])
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyWordArray[1]);
	}
	
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or Manufacturer Part Number.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatch_BNOrPN(String testCaseId,@Parameter("Brand Name Or Part Number") String searchKeyword) throws Exception
	{
		String [] searchKeyWordArray = searchKeyword.split(" ");
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0])
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[1]);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatch_BNOrUPC(String testCaseId,@Parameter("Brand Name Or UPC") String searchKeyword) throws Exception
	{
		String [] searchKeyWordArray = searchKeyword.split(" ");
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0])
		.verifyUPCInProductDetailsPage(searchKeyWordArray[1]);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatching_UPCOrPN(String testCaseId,@Parameter("UPC Or Part Number") String searchKeyword) throws Exception
	{
		String [] searchKeyWordArray = searchKeyword.split(" ");
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyUPCInProductDetailsPage(searchKeyWordArray[0])
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[1]);
	}
}

