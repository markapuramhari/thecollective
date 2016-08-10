package org.etna.modules;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

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
	@Test(groups={"HomePageModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void verifyContentsOfFooterLinks(String testCaseId,String specificFooterLink,String breadCrumb,String contentLocator,String expectedContent) throws Exception{
		homePage()
		.clickOnSpecificFooterLink(specificFooterLink)
		.productsPage()
		.verifyBreadcrump(breadCrumb)
		.verifyPagename(breadCrumb)
		.homePage()
		.verifyContent(specificFooterLink,contentLocator,expectedContent);
	}
	
	
	@Features("Homepage Module")
	@Test(groups={"HomePageModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void verifyContentsOfHeaderLinks(String testCaseId,String specificHeaderLink,String breadCrumb,String contentLocator,String expectedContent) throws Exception{
		homePage()
		.clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader(specificHeaderLink)
		.productsPage()
		.verifyBreadcrump(breadCrumb)
		.verifyPagename(breadCrumb)
		.homePage()
		.verifyContent(specificHeaderLink,contentLocator,expectedContent);
	}
	
	@Features("Homepage Module")
	@Test(groups="regression")
	public void quickOrderPadFooterLinkBeforeLogin(){
		homePage().clickOnQuickOrderPadLinkInFooter().loginPopUp().verifyLoginPopUp();
	}
	
	@Features("Homepage Module")
	@Test(groups="regression")
	public void quickOrderPadHeaderLink(){
		homePage().clickOnQuickOrderPadLinkInHeader().loginPopUp().verifyLoginPopUp();
	}
	
	@Features("Homepage Module")
	@Test(groups="regression",dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void verifyContactUsPositives(String testCaseId,String areaOfInterest,String firstName,String lastName,String phoneNumber,String emailAddress,String companyName,String country,String state,String city,String zipCode,String address,String questionsOrComments,String preferredMethodOfCommunication,String expectedSuccessMessage) throws InterruptedException{
			homePage().clickOnContactUsLink().contactUsPage()
			.selectAreaOfInterest(areaOfInterest)
			.enterFirstName(firstName)
			.enterLastName(lastName)
			.enterPhoneNumber(phoneNumber)
			.enterEmailAddress(emailAddress)
			.enterCompanyName(companyName)
			.selectCountry(country)
			.selectState(state)
			.enterCity(city)
			.enterZipCode(zipCode)
			.enterAddress(address)
			.enterQuestionsOrComments(questionsOrComments)
			.choosePreferredMethodOfCommunication(preferredMethodOfCommunication)
			.clickOnSubmitRequest()
			.verifySuccessCustomAlertMessage(expectedSuccessMessage);
	}
}
