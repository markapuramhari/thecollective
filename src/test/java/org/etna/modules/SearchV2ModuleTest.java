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
	
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(enabled=false,groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_WC_ExactMatch_PNOrMPN(String testCaseId,@Parameter("PN Or MPN") String searchKeyword) throws Exception
	{
		
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(enabled=false,groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_WC_ExactMatch_BNOrPN(String testCaseId,@Parameter("BN Or MPN") String searchKeyword) throws Exception
	{
		
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(enabled=false,groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_WC_ExactMatch_BNOrUPC(String testCaseId,@Parameter("BN Or UPC") String searchKeyword) throws Exception
	{
		
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(enabled=false,groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_WC_ExactMatch_UPCOrPN(String testCaseId,@Parameter("UPC Or PN") String searchKeyword) throws Exception
	{
	
	}	
	
	
	@Features("Search V2")
	@Description("This is a test case which verifies Or condition of the search keyword for Brand Name or MPN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BrandNameOrMPN(String testCaseId,@Parameter("BN Or MPN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("OR");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("OR","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0])
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[1]);
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies Or condition of the search keyword for MPN or PN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_MPNOrPN(String testCaseId,@Parameter("MPN Or PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("OR");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("OR","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim())
		.verifyPartNumberInProductListPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN or PN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BNOrPN(String testCaseId,@Parameter("BN Or PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("OR");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("OR","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim())
		.verifyPartNumberInProductListPage(searchKeyWordArray[1].trim());
	}
	
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN or UPC in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BNOrUPC(String testCaseId,@Parameter("BN Or UPC") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("OR");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("OR","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim());
		productListPage()
		.verifyUPCInProductListPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for UPC Or PN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_PNOrUPC(String testCaseId,@Parameter("UPC Or PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("OR");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("OR","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyUPCInProductListPage(searchKeyWordArray[0].trim());
		driver.navigate().refresh();
		productListPage().verifyPartNumberInProductListPage(searchKeyWordArray[1].trim());
		
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND MPN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndMPN(String testCaseId,@Parameter("BN And MPN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("AND");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("AND","").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0].trim())
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for PN AND MPN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_PNAndMPN(String testCaseId,@Parameter("PN And MPN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("AND");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("AND","").trim()};
		
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[0].trim())
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	

	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND PN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndPN(String testCaseId,@Parameter("BN And PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("AND");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("AND","").trim()};
		
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0].trim())
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND UPC in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndUPC(String testCaseId,@Parameter("BN And UPC") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("AND");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("AND","").trim()};
		
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyBrandNameOrMPNInNameOfTheProduct(searchKeyWordArray[0].trim())
		.verifyUPCInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for PN AND UPC in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_PNAndUPC(String testCaseId,@Parameter("PN And UPC") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf("AND");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replace("AND","").trim()};
		
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[0].trim())
		.verifyUPCInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN - MPN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusMPN(String testCaseId,@Parameter("BN - MPN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.indexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim())
		.verifyBrandNameOrMPNIsNotDisplayedInProductListPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for PN - MPN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_PNMinusMPN(String testCaseId,@Parameter("PN - MPN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.indexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyPartNumberInProductDetailsPage(searchKeyWordArray[0].trim())
		.verifyMPNIsNotDisplayedInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN - PN in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusPN(String testCaseId,@Parameter("BN - PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.indexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim())
		.verifyPartNumberNotDisplayedInProductListPage(searchKeyWordArray[1].trim());
	}
	
	
	@Features("Search V2")
	@Description("This is a test case which verifies for BN - UPC in product list page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusUPC(String testCaseId,@Parameter("BN - UPC") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.indexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productListPage()
		.verifyBrandNameOrMPNInProductListPage(searchKeyWordArray[0].trim())
		.verifyUPCNotDisplayedInProductListPage(searchKeyWordArray[1].trim());
	}
	
	@Features("Search V2")
	@Description("This is a test case which verifies for MPN - PN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_MPNMinusPN(String testCaseId,@Parameter("MPN - PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyManufacturerPartNumberInProductDetailsPage(searchKeyWordArray[0].trim())
		.verifyPartNumberIsNotDisplayedInProductDetailsPage(searchKeyWordArray[1].trim());
	}
	

	@Features("Search V2")
	@Description("This is a test case which verifies for UPC - PN in product details page.")
	@Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void keyword_UPCMinusPN(String testCaseId,@Parameter("UPC - PN") String searchKeyword) throws Exception
	{
		int splitViaIndex = searchKeyword.lastIndexOf(" ");
		String[] searchKeyWordArray =  {searchKeyword.substring(0, splitViaIndex).trim(), searchKeyword.substring(splitViaIndex).replaceFirst("-", "").trim()};
		homePage()
		.searchText(searchKeyword)
		.clickOnSearch()
		.productDetailsPage()
		.verifyUPCInProductDetailsPage(searchKeyWordArray[0].trim())
		.verifyPartNumberIsNotDisplayedInProductDetailsPage(searchKeyWordArray[1].trim());
	}
}

