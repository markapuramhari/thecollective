package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class ShopByManufacturersModuleTest extends PageFactoryInitializer{

	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByManufacturersBreadcrumb = data.getShopByManufacturersBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("Shop By Manufacturers Module")
	@Test(groups={"regression"})
	@Description("Verify the functionality of 'Manufacturer' link while mouse hover")
	@TestCaseId("TC_Manufacturer_001")
	  public void hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
				homePage()
				.hoverOverManufacturersLink()
				.verifyManufacturersDropdown();
	}
	

	
	@Features("Shop By Manufacturers Module")
	@Test( groups={"ShopByManufacturersModule","regression"})
	@Description("Verify the functionality of Manufacturer name in shop by Manufacturer list")
	@TestCaseId("TC_Manufacturer_002")
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
	@Test( groups={"ShopByManufacturersModule","regression"})
	@Description("Verify the functionality of 'view All Manufacturers' link")
	@TestCaseId("TC_Manufacturer_003")
	  public void unsignedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrumb)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrumb);	
	}
	
	
	
		@Features("Shop By Manufacturers Module")
		@Test( groups={"regression"})
		@Description("Verify the functionality of 'Manufacturers' link,Verify the functionality of breadcrumbs,Verification of Page Title,Verification of Page Name.")
		@TestCaseId("TC_Manufacturer_004,TC_Manufacturer_007,TC_Manufacturer_008,TC_Manufacturer_009")
	  public void unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrumb)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrumb);	
	}
	
		
		@Features("Shop By Manufacturers Module")
	    @Test( groups={"regression"})
		@Description("Verify the functionality of Manufacturer first letter link in shop by manufacturer page")
		@TestCaseId("TC_Manufacturer_005")
	  public void unsignedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
		@Features("Shop By Manufacturers Module")
	    @Test( groups={"regression"})
		@Description("Verify the functionality of Manufacturer name link in shop by manufacturer page")
		@TestCaseId("TC_Manufacturer_010")
	  public void verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
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
	    @Test( groups={"regression"})
		@Description("")
		@TestCaseId("")
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
	  @Test( groups={"regression"})
	  @Description("")
	  @TestCaseId("")
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
}
