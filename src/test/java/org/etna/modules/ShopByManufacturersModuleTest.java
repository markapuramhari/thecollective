package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;

public class ShopByManufacturersModuleTest extends PageFactoryInitializer{

	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_001_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
				homePage()
				.hoverOverManufacturersLink()
				.verifyManufacturersDropdown();
	}
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_001_signedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
		loginModule.loginAsASuperUser();
			homePage()
			.hoverOverManufacturersLink()
			.verifyManufacturersDropdown();		
	}
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_002_TC_Manufacturers_010_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
	  {
				String manufacturerName = homePage()
				.hoverOverManufacturersLink()
				.getSpecificManufacturersLinkName(1);
				homePage()
				.clickOnASpecificManufacturer(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(manufacturerName);
				
	}
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_002_TC_Manufacturers_010_signedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
	  {
		loginModule.loginAsASuperUser();
				String manufacturerName = homePage()
				.hoverOverManufacturersLink()
				.getSpecificManufacturersLinkName(1);
				homePage()
				.clickOnASpecificManufacturer(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(manufacturerName);
				
	}
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_003_unsignedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	
	@Features("Shop By Manufacturers Module")
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_003_signedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);
	}
	
		@Features("Shop By Manufacturers Module")
		@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_signedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
	
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_005_unsignedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
	  {
		data.setSpecificManufacturerName("3M");
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
	  {
		data.setSpecificManufacturerName("3M");
		loginModule.loginAsASuperUser();
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
	  {
		data.setSpecificManufacturerName("Ansell");
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
		@Features("Shop By Manufacturers Module")
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
	  {
		data.setSpecificManufacturerName("Ansell");
		loginModule.loginAsASuperUser();
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
}
