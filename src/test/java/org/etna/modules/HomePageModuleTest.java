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
	  public void tc008_verifyHomePageBeforeLogin() throws Exception
	  {
		homePage()
		.verifyHomePage();
	  } 
	
	@Features("Homepage Module")
	@Test(enabled=false,groups={"HomePageModule","smoke","regression"})
	  public void tc008_verifyHomePageAfterLogin() throws Exception
	  {
		homePage()
		.clickLoginLink()
		.enterUserName()
		.enterPassword()
		.clickOnLoginButton()
		.homePage()
		.verifyHomePageAfterLogin();
	  } 


	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void tc010_verifyAllFooterSectionPages() throws Exception
	  {
		homePage()
		.verifyFooterLinks(data.getExpectedFooterLinks().split(","));
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
		.verifyHomePage();
	  }
}
