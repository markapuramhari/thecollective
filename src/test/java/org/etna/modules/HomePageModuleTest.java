package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;

public class HomePageModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void tc008_verifyHomePage() throws Exception
	  {
		  
		homePage()
		.verifyHomePage();
		
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void tc009_verifyAllSectionOptionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		
			/*verification of breadcrumps all the sections and subsections irrespective of whether it is a parent or a child,
	 	 	filter sections,page name,search box for filter */
			/*	homePage()
				.verifyAllSectionOptionPages();*/
	  } 	
		
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void tc010_verifyAllFooterSectionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		//verification of breadcrumps,pagename and etc. for the footer links
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void tc011_clickOnLogoNavigateBackToHomePage() throws Exception
	  {
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch();
		homePage()
		.clickOnLogo()
		.verifyCarousel()
		.verifyFeaturedManufacturersSection();
	  }
	
}
