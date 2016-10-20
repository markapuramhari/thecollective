package org.etna.modules;

import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.testng.SkipException;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.TestUtility;
import org.openqa.selenium.UnhandledAlertException;

public class SearchV2ModuleTest extends PageFactoryInitializer {

	LoginModuleTest loginModule = new LoginModuleTest();

	@Features("Search V2")
	@Stories(value = { "1a.  Keywords (Part Number , Manufacturer Part Number, UPC) - Exact Matches" })
	@Description("This is a test case which verifies exact matching of the search keyword for part number.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_PN(String testCaseId, @Parameter("Part Number") String searchKeyword)
			throws Exception {

		homePage().searchText(searchKeyword).clickOnSearch().productDetailsPage()
				.verifyPartNumberInProductDetailsPage(searchKeyword);
	}

	@Features("Search V2")
	@Stories(value = { "1a.  Keywords (Part Number , Manufacturer Part Number, UPC) - Exact Matches" })
	@Description("This is a test case which verifies exact matching of the search keyword for manufacturer part number.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_MPN(String testCaseId, @Parameter("MPN") String searchKeyword) throws Exception {

		homePage().searchText(searchKeyword).clickOnSearch().productDetailsPage()
				.verifyManufacturerPartNumberInProductDetailsPage(searchKeyword);
	}

	@Features("Search V2")
	@Stories(value = { "1a.  Keywords (Part Number , Manufacturer Part Number, UPC) - Exact Matches" })
	@Description("This is a test case which verifies exact matching of the search keyword for UPC.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keywords_exactMatching_UPC(String testCaseId, @Parameter("UPC") String searchKeyword) throws Exception {

		homePage().searchText(searchKeyword).clickOnSearch().productDetailsPage()
				.verifyUPCInProductDetailsPage(searchKeyword);
	}

	@Features("Search V2")
	@Stories("1a.  Keywords (Part Number , Manufacturer Part Number, UPC) - Exact Matches")
	@Description("This is a test case which verifies exact matching of the search keyword for brand name or "
			+ "MPN when given together. Since it is an exact match scenario it should navigate to product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_Searchv2_001")
	public void keyword_ExactMatching_BNOrMPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("MPN") String mpn) throws Exception {

		homePage().searchText(brandName.trim() + " OR " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(brandName.trim())
				.verifyBrandNameOrMPNInNameOfTheProduct(mpn.trim())
				.verifyManufacturerPartNumberInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Part Number or Manufacturer Part Number.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_Searchv2_002")
	public void keyword_ExactMatch_PNOrMPN(String testCaseId, @Parameter("Part Number") String partNumber,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(partNumber.trim() + " OR " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(mpn.trim())
				.verifyPartNumberInProductDetailsPage(partNumber.trim())
				.verifyManufacturerPartNumberInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or Part Number.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatch_BNOrPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("Part Number") String pn) throws Exception {

		homePage().searchText(brandName.trim() + " OR " + pn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim()).verifyPartNumberInProductListPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for Brand Name or UPC.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatch_BNOrUPC(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {
		try {
			homePage().searchText(brandName.trim() + " OR " + upc.trim()).clickOnSearch().productDetailsPage()
					.verifyBrandNameOrMPNInNameOfTheProduct(brandName.trim()).verifyUPCInProductDetailsPage(upc.trim());
		} catch (UnhandledAlertException e) {
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");

		}
	}

	@Features("Search V2")
	@Description("This is a test case which verifies exact matching of the search keyword for UPC OR Part Number.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_ExactMatching_UPCOrPN(String testCaseId, @Parameter("UPC") String upc,
			@Parameter("Part Number") String partNumber) throws Exception {
		try {
			homePage().searchText(upc.trim() + " OR " + partNumber.trim()).clickOnSearch().productDetailsPage()
					.verifyUPCInProductDetailsPage(upc.trim()).verifyPartNumberInProductDetailsPage(partNumber.trim());
		} catch (UnhandledAlertException e) {
			TestUtility.alertAccept();
			throw new Exception("Unhandled alert");

		}
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Part Number and Manufacturer Part Number for the same product. The control should be navigated to Product Details Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wildCard_PN_MPN_SingleProduct(String testCaseId, @Parameter("Part Number") String partNumber,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(partNumber.trim() + " " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyWildCardPartNumber(partNumber.replace("*", "").trim())
				.verifyWildCardManufacturerPartNumber(mpn.replace("*", "").trim());
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Brand Name and Part Number. The control should be navigated to Product Details Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wildCard_BN_PN_SingleProduct(String testCaseId, @Parameter("Brand Name") String bn,
			@Parameter("PN") String partNumber) throws Exception {
		homePage().searchText(bn.trim() + " " + partNumber.trim()).clickOnSearch().productDetailsPage()
				.verifyWildCardBrandName(bn.replace("*", "").trim())
				.verifyWildCardPartNumber(partNumber.replace("*", "").trim());
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Brand Name and UPC for the same product. The control should be navigated to Product Details Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wildCard_BN_UPC_SingleProduct(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {
		homePage().searchText(brandName.trim() + " " + upc.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(brandName.replace("*", "").trim())
				.verifyWildCardUPC(upc.replace("*", "").trim());
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Brand Name and UPC for the same product. The control should be navigated to Product List Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wc_BN_UPC_MultipleProducts(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {
		homePage().searchText(brandName.trim() + " " + upc.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.replace("*", ""))
				.verifyWildCardUPC(upc.replace("*", "").trim());
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Brand Name and Part Number. The control should be navigated to Product List Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wc_BN_PN_MultipleProducts(String testCaseId, @Parameter("Brand Name") String bn,
			@Parameter("Part Number") String partNumber) throws Exception {
		homePage().searchText(bn.trim() + " " + partNumber.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(bn.replace("*", "").trim())
				.verifyWildCardPartNumber(partNumber.replace("*", "").trim());
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. Part Number and Manufacturer Part Number. The control should be navigated to Product List Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wc_PN_MPN_MultipleProducts(String testCaseId, @Parameter("Part Number") String partNumber,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(partNumber.trim() + " " + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(mpn.replace("*", ""))
				.verifyWildCardPartNumber(partNumber.replace("*", ""));
	}

	@Features("Search V2")
	@Description("Wild Card Scenario. UPC and PN for the same product. The control should be navigated to Product Details Page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void wildCard_UPC_PN_SameProduct(String testCaseId, @Parameter("UPC") String upc, @Parameter("PN") String pn)
			throws Exception {
		throw new SkipException("No Support for this feature");
	}

	@Features("Search V2")
	@Description("This is a test case which verifies Or condition of the search keyword for Brand Name or MPN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BrandNameOrMPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("MPN") String mpn) throws Exception {

		homePage().searchText(brandName.trim() + " OR " + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyBrandNameOrMPNInProductListPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies Or condition of the search keyword for MPN or PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_MPNOrPN(String testCaseId, @Parameter("MPN") String mpn, @Parameter("PN") String pn)
			throws Exception {

		homePage().searchText(mpn.trim() + " OR " + pn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(mpn.trim()).verifyPartNumberInProductListPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN or PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BNOrPN(String testCaseId, @Parameter("Brad Name") String brandName,
			@Parameter("PN") String pn) throws Exception {

		homePage().searchText(brandName.trim() + " OR " + pn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim()).verifyPartNumberInProductListPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN or UPC in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_BNOrUPC(String testCaseId, @Parameter("BN Or UPC") String brandName,
			@Parameter("UPC") String upc) throws Exception {

		homePage().searchText(brandName.trim() + " OR " + upc.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim()).verifyUPCInProductListPage(upc.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for UPC Or PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_OrCond_UPCOrPN(String testCaseId, @Parameter("UPC") String upc, @Parameter("PN") String pn)
			throws Exception {

		homePage().searchText(upc.trim() + " OR " + pn.trim()).clickOnSearch().productListPage()
				.verifyUPCInProductListPage(upc.trim());
		driver.navigate().refresh();
		productListPage().verifyPartNumberInProductListPage(pn.trim());

	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndMPN(String testCaseId, @Parameter("BrandName") String brandName,
			@Parameter("MPN") String mpn) throws Exception {

		homePage().searchText(brandName.trim() + " AND " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(brandName.trim())
				.verifyManufacturerPartNumberInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for PN AND MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_PNAndMPN(String testCaseId, @Parameter("Part Number") String pn,
			@Parameter("Part Number") String mpn) throws Exception {

		homePage().searchText(pn.trim() + " AND " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyPartNumberInProductDetailsPage(pn.trim())
				.verifyManufacturerPartNumberInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND PN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("Part Number") String pn) throws Exception {

		homePage().searchText(brandName.trim() + " AND " + pn.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(brandName.trim())
				.verifyPartNumberInProductDetailsPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN AND UPC in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_BNAndUPC(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {

		homePage().searchText(brandName.trim() + " AND " + upc.trim()).clickOnSearch().productDetailsPage()
				.verifyBrandNameOrMPNInNameOfTheProduct(brandName.trim()).verifyUPCInProductDetailsPage(upc.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for PN AND UPC in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_AndCond_PNAndUPC(String testCaseId, @Parameter("PN") String pn, @Parameter("UPC") String upc)
			throws Exception {

		homePage().searchText(pn.trim() + " AND " + upc.trim()).clickOnSearch().productDetailsPage()
				.verifyPartNumberInProductDetailsPage(pn.trim()).verifyUPCInProductDetailsPage(upc.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN - MPN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusMPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("MPN") String mpn) throws Exception {

		homePage().searchText(brandName.trim() + " -" + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyBrandNameOrMPNIsNotDisplayedInProductListPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for PN - MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_PNMinusMPN(String testCaseId, @Parameter("PN") String pn, @Parameter("MPN") String mpn)
			throws Exception {

		homePage().searchText(pn.trim() + " -" + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyPartNumberInProductDetailsPage(pn.trim())
				.verifyMPNIsNotDisplayedInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN - PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("Part Number") String partNumber) throws Exception {

		homePage().searchText(brandName.trim() + " -" + partNumber.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyPartNumberNotDisplayedInProductListPage(partNumber.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for BN - UPC in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BNMinusUPC(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {

		homePage().searchText(brandName.trim() + " -" + upc.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyUPCNotDisplayedInProductListPage(upc.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for MPN - PN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_MPNMinusPN(String testCaseId, @Parameter("MPN") String mpn, @Parameter("Part Number") String pn)
			throws Exception {

		homePage().searchText(mpn.trim() + " -" + pn.trim()).clickOnSearch().productDetailsPage()
				.verifyManufacturerPartNumberInProductDetailsPage(mpn.trim())
				.verifyPartNumberIsNotDisplayedInProductDetailsPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for UPC - PN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_UPCMinusPN(String testCaseId, @Parameter("UPC") String upc, @Parameter("Part Number") String pn)
			throws Exception {
		homePage().searchText(upc.trim() + " -" + pn.trim()).clickOnSearch().productDetailsPage()
				.verifyUPCInProductDetailsPage(upc.trim())
				.verifyPartNumberIsNotDisplayedInProductDetailsPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name + MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BrandNamePlusMPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(brandName.trim() + " +" + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyBrandNameOrMPNInProductListPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Part Number + MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_PartNumberPlusMPN(String testCaseId, @Parameter("Part Number") String partNumber,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(partNumber.trim() + " +" + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(mpn.trim()).verifyPartNumberInProductListPage(partNumber.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name + Part Number in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BNPlusPN(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("Part Number") String pn) throws Exception {
		homePage().searchText(brandName.trim() + " +" + pn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim()).verifyPartNumberInProductListPage(pn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name + UPC in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BNPlusUPC(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {
		homePage().searchText(brandName.trim() + " +" + upc.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim()).verifyUPCInProductListPage(upc);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name + UPC in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_UPCPlusPN(String testCaseId, @Parameter("UPC") String upc, @Parameter("PN") String pn)
			throws Exception {
		homePage().searchText(upc.trim() + " +" + pn.trim()).clickOnSearch().productListPage()
				.verifyUPCInProductListPage(upc).verifyPartNumberInProductListPage(pn);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Parenthesis short description in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_Parenthesis(String testCaseId, @Parameter("Parenthesis") String parenthesis) throws Exception {
		homePage().searchText(parenthesis.trim()).clickOnSearch().productDetailsPage()
				.verifyShortDescription(parenthesis.replace("\"", "").replace("&Reg;", "®").trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name NOT MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_BrandNameNOTMpn(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(brandName.trim() + " NOT " + mpn.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName)
				.verifyBrandNameOrMPNIsNotDisplayedInProductListPage(mpn).verifyMPNIsNotDisplayedInProductListPage(mpn);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name NOT MPN in product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_partNumberNOTMpn(String testCaseId, @Parameter("Part Number") String partNumber,
			@Parameter("MPN") String mpn) throws Exception {
		homePage().searchText(partNumber.trim() + " NOT " + mpn.trim()).clickOnSearch().productDetailsPage()
				.verifyPartNumberInProductDetailsPage(partNumber.trim())
				.verifyMPNIsNotDisplayedInProductDetailsPage(mpn.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name NOT PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_brandNameNOTPn(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("Part Number") String partNumber) throws Exception {
		homePage().searchText(brandName.trim() + " NOT " + partNumber.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyPartNumberNotDisplayedInProductListPage(partNumber.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name NOT PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_brandNameNOTUpc(String testCaseId, @Parameter("Brand Name") String brandName,
			@Parameter("UPC") String upc) throws Exception {
		homePage().searchText(brandName.trim() + " NOT " + upc.trim()).clickOnSearch().productListPage()
				.verifyBrandNameOrMPNInProductListPage(brandName.trim())
				.verifyUPCNotDisplayedInProductListPage(upc.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies for Brand Name NOT PN in product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void keyword_uPCNOTPn(String testCaseId, @Parameter("UPC") String upc,
			@Parameter("Part Number") String partNumber) throws Exception {
		homePage().searchText(upc.trim() + " NOT " + partNumber.trim()).clickOnSearch().productDetailsPage()
				.verifyUPCInProductDetailsPage(upc.trim())
				.verifyPartNumberIsNotDisplayedInProductDetailsPage(partNumber.trim());
	}

	@Features("Search V2")
	@Description("This is a test case which verifies partial part number search for a product that has SKU mode. This search functionality should navigate to product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void partialPNSearch_SKU(String testCaseId, @Parameter("Part Number") String partNumber) throws Exception {
		homePage().searchText(partNumber.trim()).clickOnSearch().productListPage()
				.verifyPartialPartNumberSKUMode(partNumber);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies partial part number search for a product that has product mode. This search functionality should navigate to product details page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void partialPNSearch_ProductMode(String testCaseId, @Parameter("Part Number") String partNumber)
			throws Exception {
		homePage().searchText(partNumber.trim()).clickOnSearch().productDetailsPage()
				.verifyPartialPartNumberProductMode(partNumber);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies partial short description that is in product mode and sku mode. This search functionality should navigate to product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void partialShortDescriptionSearch(String testCaseId,
			@Parameter("Partial Short Description") String shortDescription) throws Exception {
		homePage().searchText(shortDescription.trim()).clickOnSearch().productListPage()
				.verifyPartialShortDescription(shortDescription);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies full short description. This search functionality should navigate to product list page.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void fullShortDescriptionSearch(String testCaseId, @Parameter("Short Description") String shortDescription)
			throws Exception {
		homePage().searchText(shortDescription.trim()).clickOnSearch().productDetailsPage()
				.verifyExactShortDescription(shortDescription);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies category search of the last level which navigates to product list page. We have to search without selecting from  without selecting from Auto Suggest List")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void categoryNamesLastLevel(String testCaseId, @Parameter("Category Name") String categoryNameToSearch)
			throws Exception {

		String[] nameOfTheItems = homePage().clickOnProductsLink()
				.clickOnSpecificCategoryUnderTheProductsLink(categoryNameToSearch).productListPage()
				.getNamesOfTheItems();

		homePage().searchText(categoryNameToSearch.trim()).clickOnSearch().productListPage()
				.verifyNamesOfTheProducts(nameOfTheItems);
	}

	@Features("Search V2")
	  @Description("Click on category(except the last level) & verifies names of all categories")
	  @Test(groups={"regression"},dataProvider="SearchV2",dataProviderClass=DataDrivenTestingFromExcel.class)
	  @TestCaseId("{0}")
	  public void categoryNamesExceptLastLevel(String testCaseId,@Parameter("Category Name") String categoryNameToSearch) throws Exception
	  {
	   
	   String [] nameOfTheItems = homePage()
	   .clickOnProductsLink()
	   .clickOnSpecificCategory(categoryNameToSearch)
	   .productsPage()
	   .getNamesOfTheCategories();
	   
	   homePage()
	   .searchText(categoryNameToSearch.trim())
	   .clickOnSearch()
	   .productsPage()
	   .verifyNamesOfAllCategories(nameOfTheItems);
	  }
	
	@Features("Search V2")
	@Description("This is a test case which verifies auto suggest feature of categories.")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void autoSuggest(String testCaseId, @Parameter("Search text") String searchText) throws Exception {

		GeneralSearchModuleTest generalSearch = new GeneralSearchModuleTest();
		generalSearch.verifyInvalidSearch();
		homePage().searchText(searchText).verifyAutoCompleteList(searchText);
	}

	@Features("Search V2")
	@Description("This is a test case which verifies auto suggest feature of categories.")
	@Test(enabled = false, groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void partialAutoSuggest(String testCaseId, @Parameter("Search text") String partialSearchText,
			@Parameter("Search text") String expectedTextToComeInDropdown) throws Exception {
		throw new SkipException("test incomplete. No ready for automation");

		/*
		 * GeneralSearchModuleTest generalSearch = new
		 * GeneralSearchModuleTest(); generalSearch.verifyInvalidSearch();
		 * homePage() .searchText(partialSearchText)
		 * .verifyAutoCompleteList(expectedTextToComeInDropdown); throw new
		 * SkipException("partial auto suggest is pending.");
		 */
	}

	@Features("Search V2")
	@Description("General Search and Search within - Attribute Name (ie Filter name)")
	@Test(groups = { "regression" }, dataProvider = "SearchV2", dataProviderClass = DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	public void searchWithinAttributeName(String testCaseId, @Parameter("Search text") String searchText,
			@Parameter("Filter Name") String filterName, @Parameter("Attribute Name") String attributeName)
			throws Exception {

		String numberOfItemsAssociatedWithTheAttribute = homePage().searchText(searchText).clickOnSearch()
				.productListPage().clickOnSpecificFilter(filterName).getNumberOfItemsInTheAttribute(attributeName);
		productListPage().enterSearchTextInNarrowFilterTextbox(attributeName).clickOnNarrowSearchButton()
				.verifyNumberOfItemsInThePage(numberOfItemsAssociatedWithTheAttribute);

	}
}
