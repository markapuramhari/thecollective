package org.thecollective.modules;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class PLPModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data= new SearchDataPropertyFile();
	
	@TestCaseId("TC_PLP_001")
	@Features("Product List Page")
	@Test()
	@Description("verifies product list page before login by using search")
	public void verifyProductListPageBySearch() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifySortByOptions(data.getSortByOptions());
		//homePage().mouseHoverOverOnMyAccount().verifyUserProfile(expAccountName, productName)
	}
	@TestCaseId("TC_PLP_002")
	@Features("Product List Page")
	@Test()
	@Description("verifies product list page before login by using category navigation")
	public void verifyProductListByCatNavigation() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men","Sports")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifySortByOptions(data.getSortByOptions());
	}
	@TestCaseId("TC_PLP_003")
	@Features("Product List Page")
	@Test()
	@Description("verifies filter attributes before login by using category navigation")
	public void verifyLeftNavFilters() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men","Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection();
	}
	
	@TestCaseId("TC_PLP_004")
	@Features("Product List Page")
	@Test()
	@Description("verification of apply single filter functionality by using search")
	public void verifyFilterFunctionalityForSearch() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applySingleFilter()
		.verifySingleCheckedFilter();
	}
	@TestCaseId("TC_PLP_005")
	@Features("Product List Page")
	@Test()
	@Description("verification of apply single filter functionality by using search")
	public void verifySingleFilterFunWithPageRefresh() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applySingleFilter();
		driver.navigate().refresh();
		listPage()
		.verifySingleCheckedFilter();
	}
	@TestCaseId("TC_PLP_006")
	@Features("Product List Page")
	@Test()
	@Description("verification of multiple filter functionality before login by using search")
	public void verifyMultipleFilterFunctionalityForSearch() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applyMultipleFilters(2)
		.verifyMultipleCheckedFilter(2);
	}
	@TestCaseId("TC_PLP_007")
	@Features("Product List Page")
	@Description("verify multiple filter functionality with page refresh")
	@Test()
	public void verifyMultipleFilterWithPageRefresh() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applyMultipleFilters(2);
		driver.navigate().refresh();
		listPage()
		.verifyMultipleCheckedFilter(2);
	}
	@TestCaseId("TC_PLP_008")
	@Features("Product List Page")
	@Test()
	@Description("verification of apply single filter functionality by changing sortby option")
	public void verifySingleFilterByChangingSortByOption() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applySingleFilter()
		.changeSortByOptionBasedOnIndex(1)
		.verifySingleCheckedFilter();
		}
	@TestCaseId("TC_PLP_009")
	@Features("Product List Page")
	@Test()
	@Description("verification of applied multiple filter functionality by changing sortby option")
	public void verifyMultipleFilterByChnagingSortByOption() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applyMultipleFilters(2)
		.changeSortByOptionBasedOnIndex(1)
		.verifyMultipleCheckedFilter(2);
		
	}
	@Description("verification of apply single filter for category navigation")
	@TestCaseId("TC_PLP_010")
	@Features("Product List Page")
	@Test
	public void verifySingleFilterForCatNavigation() throws InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.verifyListedProducts()
		.verifyFilterSection()
		.verifySortByText()
		.applySingleFilter()
		.verifySingleCheckedFilter();
		
	}
	@Description("verification of apply single filter page refresh for category navigation")
	@TestCaseId("TC_PLP_011")
	@Features("Product List Page")
	@Test
	public void verifySingleFilterPageRefreshForCatNavigation() throws InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.verifyListedProducts()
		.verifyFilterSection()
		.verifySortByText()
		.applySingleFilter();
		driver.navigate().refresh();
		listPage()
		.verifySingleCheckedFilter();
	}
	@TestCaseId("TC_PLP_012")
	@Features("Product List Page")
	@Test()
	@Description("verifies filter attributes before login by using search")
	public void verifyLeftNavFiltersForSearch() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection();
	}
	@TestCaseId("TC_PLP_013")
	@Features("Product List Page")
	@Test()
	@Description("verifies filter attributes for category navigation")
	public void verifyLeftNavFiltersForCatNavigation() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection();
	}
	@TestCaseId("TC_PLP_014")
	@Features("Product List Page")
	@Test()
	@Description("verifies mutliple filter for category navigation")
	public void verifyMultiFiltersForCatNavigation() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applyMultipleFilters(2);
		listPage()
		.verifyMultipleCheckedFilter(2);
	}
	@TestCaseId("TC_PLP_015")
	@Features("Product List Page")
	@Test()
	@Description("verifies mutliple filter refresh by category navigation")
	public void verifyMultiFiltersRefreshForCatNavigation() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "Jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifyFilterSection()
		.applyMultipleFilters(2);
		driver.navigate().refresh();
		listPage()
		.verifyMultipleCheckedFilter(2);
	}
	@TestCaseId("TC_PLP_016")
	@Features("Product List Page")
	@Test()
	@Description("verifies brand search within option")
	public void verifyBrandsSubFilterSection() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("shirt")
		.listPage()
		.verifyFilterSection()
		.verifyBrandSubFilter();
		
	
	}
	@TestCaseId("TC_PLP_017")
	@Features("Product List Page")
	@Test()
	@Description("verifies brand search within option functionality")
	public void verifyBrandsSubFilterFun() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation("Men", "T-Shirts")
		.listPage()
		.verifyBrandSubFilter()
		.enterSearchKeyWord("a")
		.verifySearchWithinFun('3');
		
		
	}
}
