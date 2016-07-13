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
	  public void verifyHomePageBeforeLogin() throws Exception
	  {
		homePage()
		.verifyHomePage();
	  } 
	
	@Features("Homepage Module")
	@Test(enabled=false,groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageAfterLogin() throws Exception
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
	  public void verifyAllFooterLinks() throws Exception
	  {
		homePage()
		.verifyFooterLinks(data.getExpectedFooterLinks().split(","));
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void clickOnLogoNavigateBackToHomePage() throws Exception
	  {
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch();
		homePage()
		.clickOnLogo()
		.verifyHomePage();
	  }
	
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyAllDivisionsSubCategories() throws Exception
	  {
		homePage()
		.hoverOverDivisionsLink()
		.verifyDivisionsInHeader(data.getAllDivisionsInHeader().split(","));
	  } 

	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyPlumbingPageInFooterLink() throws Exception
	  {
		homePage()
		.clickOnPlumbingLinkInFooter()
		.verifyPlumbingPage(data.getPlumbingPageBreadcrumb(),data.getPlumbingPageContent());
	  } 
	
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyWaterWorksPageInFooterLink() throws Exception
	  {
		homePage()
		.clickOnWaterworksLinkInFooter()
		.verifyWaterworksPage(data.getWaterworksPageBreadcrumb(),data.getWaterworksPageContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyFireProtectionFooterLink() throws Exception
	  {
		homePage()
		.clickOnFireProtectionInFooter()
		.verifyFireProtectionPage(data.getFireProtectionBreadcrumb(),data.getFireProtectionContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyMunicipalFooterLink() throws Exception
	  {
		homePage()
		.clickOnMunicipalLinkInFooter()
		.verifyMunicipalPage(data.getMunicipalBreadcrumb(),data.getMunicipalContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyHVACFooterLink() throws Exception
	  {
		homePage()
		.clickOnHVACLinkInFooter()
		.verifyHVACPage(data.getHVACBreadcrumb(),data.getHVACContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyAboutUsFooterLink() throws Exception
	  {
		homePage()
		.clickOnAboutUsLinkInFooter()
		.verifyAboutUsPage(data.getAboutUsBreadcrumb(),data.getAboutUsContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyCareersFooterLink() throws Exception
	  {
		homePage()
		.clickOnCareersLinkInFooter()
		.verifyCareersPage(data.getCareersBreadcrumb(),data.getCareersContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyEtnaMissionFooterLink() throws Exception
	  {
		homePage()
		.clickOnEtnaMissionLinkInFooter()
		.verifyCareersPage(data.getEtnaMissionBreadcrumb(),data.getEtnaMissionContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyQuickOrderPadFooterLink() throws Exception
	  {
		homePage()
		.clickOnQuickOrderPadLinkInFooter()
		.loginPopUp()
		.verifyLoginPopUp();
	  } 
	

	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyLocationsFooterLink() throws Exception
	  {
		homePage()
		.clickOnLocationsLinkInFooter()
		.verifyLocationsPage(data.getLocationsBreadcrumb(),data.getLocationsContent());
	  } 

	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verifyVendorsFooterLink() throws Exception
	  {
		homePage()
		.clickOnVendorsLinkInFooter()
		.verifyLocationsPage(data.getVendorsBreadcrumb(),data.getVendorsContent());
	  } 
	
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verify_Header_Divisions_Plumbing_Link() throws Exception
	  {
		homePage()
		.hoverOverDivisionsLink()
		.clickOnPlumbingLinkInHeader()
		.verifyPlumbingPage(data.getPlumbingPageBreadcrumb(), data.getPlumbingPageContent())
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verify_Header_Divisions_Waterworks_Link() throws Exception
	  {
		homePage()
		.hoverOverDivisionsLink()
		.clickOnWaterworksLinkInHeader()
		.verifyWaterworksPage(data.getWaterworksPageBreadcrumb(),data.getWaterworksPageContent());
	  } 
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verify_Header_Divisions_FireProtection_Link() throws Exception
	  {
		homePage()
		.hoverOverDivisionsLink()
		.clickOnFireProtectionLinkInHeader()
		.verifyFireProtectionPage(data.getFireProtectionBreadcrumb(),data.getFireProtectionContent());
	  } 
	
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"})
	  public void verify_Header_Divisions_HAVC_Link() throws Exception
	  {
		homePage()
		.hoverOverDivisionsLink()
		.clickOnHAVCLinkInHeader()
		.verifyHVACPage(data.getHVACBreadcrumb(),data.getHVACContent());
	  } 
	
}
