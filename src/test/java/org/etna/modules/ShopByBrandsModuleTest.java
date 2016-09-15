package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ShopByBrandsModuleTest extends PageFactoryInitializer{


	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	String shopByBrandBreadcrumb = data.getShopByBrandsBreadcrump();
	
	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_001")
	@Description("Verification of Brands Quick view mode")
	  public void unsignedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
	
	
	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_003")
	@Description("Verification of brands from Brands Quick view mode")
	  public void unsignedUser_clickOnOneOfTheBrandLinks_Verify_Brand() throws Exception
	  {
				String brandName = homePage()
				.hoverOverBrandsLink()
				.getSpecificBrandLinkName(1);
				homePage()
				.clickOnASpecificBrand(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheBrandName(brandName);
				
	}
	

	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_004")
	@Description("Verify the functionality of 'View All Brands' link from brand Quick view")
	  public void unsignedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrumb)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrumb);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_002,TC_Brand_008,TC_Brand_009,TC_Brand_010")
	@Description("Verify the content of Shop by Brands page. Verify the page title of shop by brands page.Verify breadcrumb in Shop By Brand page.Verify page name displaying in Shop By Brand page")
	  public void unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrumb)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrumb);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_005")
	@Description("Verify the functionality of Alphabets of each brands in Shop by brands page")
	  public void unsignedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(enabled=false,groups={"ShopByBrandsModule","regression"})
	@TestCaseId("TC_Brand_011")
	@Description("Verify the functionality of clicking on brand name in Shop by brands page to navigate to Product Detail page after clicking on the brands from the left brands section dropdown. Please choose a brand that has only one product.")
	  public void verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
	  {
		data.setSpecificBrandName("3M");
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		productDetailsPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_Brand_012")
	@Description("Verify the functionality of clicking on brand name in Shop by brands page to navigate to Product List page after clicking on the brands from the left brands section dropdown. Please choose a brand that has multiple products.")
	  public void unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
	  {
		data.setSpecificBrandName("Aquatic");
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		productListPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}

	
	@Features("Shop By Brands Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_Brand_006")
	@Description("Verify the functionality of brand name link in Shop by brands page after clicking on one of the alphabets. Please choose a brand that has only product.")
	  public void verifyBN_ClickingFromAlphabetsSectionPLP() throws Exception
	  {
		data.setSpecificAlphabetToClickInShopByBrandsPage("3");
		data.setSpecificBrandName("3M");
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnSpecificAlphabet(data.getSpecificAlphabetToClickInShopByBrandsPage())
		.clickOnSpecificBrandUnderAlphabets(data.getSpecificBrandname())
		.productListPage()
		.verifyBrandBreadCrump(data.getSpecificBrandname())
		.verifyTitleOfTheBrand(data.getSpecificBrandname());
	}
	
	@Features("Shop By Brands Module")
	@Test(enabled=false,groups={"regression"})
	@TestCaseId("TC_Brand_013")
	@Description("Verify the functionality of brand name link in Shop by brands page after clicking on one of the alphabets.Please choose a brand that has a single product")
	  public void verifyBN_ClickingFromAlphabetsSectionPDP() throws Exception
	  {
		data.setSpecificAlphabetToClickInShopByBrandsPage("3");
		data.setSpecificBrandName("3M");
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnSpecificAlphabet(data.getSpecificAlphabetToClickInShopByBrandsPage())
		.clickOnSpecificBrandUnderAlphabets(data.getSpecificBrandname())
		.productDetailsPage()
		.verifyBrandBreadCrump(data.getSpecificBrandname())
		.verifyTitleOfTheBrand(data.getSpecificBrandname());
	}
	
	@Features("Shop By Brands Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_Brand_007")
	@Description("Verification of breadcrumbs functionality")
	  public void breadCrumbFunctionality() throws Exception
	  {
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyDisplayOfHomeIconInBreadcrumb()
		.verifyShopByBreadcrump(shopByBrandBreadcrumb)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrumb);
		
		shopByBrandsPage().clickOnHomeIconInBreadcrumb().homePage().verifyHomePage();
		
		homePage().clickOnBrandsLink().shopByBrandsPage().clickOnShopByBrandsCrumb().verifyShopByBrandsPageName();
		
	}
}
