package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;

public class ShopByBrandsModuleTest extends PageFactoryInitializer{


	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	
	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_001_unsignedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
	
	
	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_002_TC_Brand_010_unsignedUser_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
	  {
				String brandName = homePage()
				.hoverOverBrandsLink()
				.getSpecificBrandLinkName(1);
				homePage()
				.clickOnASpecificBrand(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheBrandName(brandName);
				
	}
	

	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_003_unsignedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_005_unsignedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
	  {
		data.setSpecificBrandName("3M");
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	

	
	@Features("Shop By Brands Module")
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
	  {
		data.setSpecificBrandName("Aquatic");
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	

}
