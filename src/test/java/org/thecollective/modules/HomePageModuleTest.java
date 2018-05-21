package org.thecollective.modules;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class HomePageModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@TestCaseId("TC_HomePage_001")
	@Features("Homepage Module")
	@Description("this test case verifies all the header links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageHeadersBeforeLogin() throws Exception
	  {
		
		homePage()
		.verifyHomePage();
		/*homePage()
		.clickOnSearchIcon()
		.enterSearchData("shirts");
		ExtractJSLogs();
		listPage()
		.clickOnSpecificProduct(2);
		ExtractJSLogs();
		 StopWatch pageLoad = new StopWatch();
	        pageLoad.start();
	       pdPage().getBrandName();
	       ExtractJSLogs();

	        pageLoad.stop();
	        //Get the time
	        long pageLoadTime_ms = pageLoad.getTime();
	        long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
	        System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
	        System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
	        
		*/
		
		/*LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry logEntry: logEntries.getAll()) {
			System.err.println("BrowserConsole: " + logEntry.toString());
		}*/
	  } 
	public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
	@TestCaseId("TC_HomePage_002")
	@Features("Homepage Module")
	@Description("this test case verifies all thestore branches")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyTheCollectiveStores() throws Exception
	  {
		homePage()
		.verifyStoresLink()
		.clickOnStoreLink()
		.storesPage()
		.verifyPageTitle()
		.verifyAvailableStores(data.getTheCollectiveBranches());
		
		
	  } 
	@TestCaseId("TC_HomePage_003")
	@Features("Homepage Module")
	@Description("this test case verifies all footer links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageFooters() throws Exception
	  {
		homePage()
		.clickOnMoreInfoLink()
		.verifyFooterHeaders(data.getExpFooterHeaders())
		.verifyFooterLinks(data.getFooterLinks());
	  } 
	@TestCaseId("TC_HomePage_004")
	@Features("Homepage Module")
	@Description("this test case verifies all the footer links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyFooterLinksFunctionality() throws Exception
	  {
		homePage()
		.clickOnMoreInfoLink()
		.verifyFooterHeaders(data.getExpFooterHeaders())
		.verifyFooterLinks(data.getFooterLinks())
		.clickOnEachLink(data.getFooterLinks());
	  } 
	@TestCaseId("TC_HomePage_005")
	@Features("Homepage Module")
	@Description("this test case verifies all the header links after login")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageAfterLogin() throws Exception
	  {
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.verifyUserProfile(data.getMyAccountPageTitle(),data.getProductName());
		
	  } 
	@TestCaseId("TC_HomePage_006")
	@Features("Homepage Module")
	@Description("this test case verifies all footer links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageFooterLinks() throws Exception
	  {
		homePage()
		.clickOnFooterToggleButton()
		.clickOnEachLink(data.getFooterLinks());
	  } 
	@TestCaseId("TC_HomePage_007")
	@Features("Homepage Module")
	@Description("this test case verifies all the men accessories category ")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyMensAccessoriesLinks() throws Exception
	  {
		
		homePage()
		.navigateToMenAccessoriesCategory();
		
	  }
	@TestCaseId("TC_HomePage_008")
	@Features("Homepage Module")
	@Test(enabled=false,groups={"HomePageModule","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	  public void verifyContentsOfHeaderLinks(String testCaseId,String specificHeaderLink,String specifiedNestedLink,String breadCrumb,String contentLocator,String expectedContent) throws Exception{
		homePage()
		.clickOnSpecificCategoryFromTopNavigation(specificHeaderLink,specifiedNestedLink)
		
		.homePage()
		.verifyContent(specificHeaderLink,contentLocator,expectedContent);
	}
	@TestCaseId("TC_HomePage_009")
	@Features("Homepage Module")
	@Description("this test case verifies the search functinaloty")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifySearchFunctionality() throws Exception
	  {
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("shirts")
		.listPage()
		.verifySearchResultsPage()
		.verifyPageTitle();
		
	  	}
	@TestCaseId("TC_HomePage_010")
	@Features("Homepage Module")
	@Description("this test case verifies the invalid search functinaloty")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyInvalidSearchFunctionality() throws Exception
		  {
			homePage()
			.clickOnSearchIcon()
			.enterSearchData("Jeans")
			.listPage()
			.verifyInvalidSearchResultsPage(data.getNoResultsFoundText())
			.verifyPageTitle();
			  }
	@TestCaseId("TC_HomePage_011")
	@Features("Homepage Module")
	@Description("this test case verifies the wish list icon")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyWishListIcon() throws Exception
		  {
			homePage()
			.verifyWishListIcon();
			
			
		  }
	@TestCaseId("TC_HomePage_012")
	@Features("Homepage Module")
	@Description("this test case verifies the wish list functionalities")

	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyWishListFunctionality() throws Exception
		  {
			homePage()
			.verifyWishListIcon()
			.clickOnLoginLink()
			.loginPage()
			.enterUserName(data.getUserName())
			.enterPassword(data.getPassword())
			.clickOnLoginButton()
			.homePage()
			.verifyWishListIcon()
			.clickOnWishListIcon()
			.myAccountPage()
			.verifySavedItemsPage();
			
		  }
	@TestCaseId("TC_HomePage_013")
	@Features("Homepage Module")
	@Description("this test case verifies all category links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllCategories() throws Exception
	  {
		homePage()
		.clickOnCategoryLink();
	  }
	@TestCaseId("TC_HomePage_014")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksInHomepage() throws Exception
	  {
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	@TestCaseId("TC_HomePage_019")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in login page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksInLoginPage() throws Exception
	  {
		homePage()
		.clickOnLoginLink()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	@TestCaseId("TC_HomePage_020")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in login page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksInSignUpPage() throws Exception
	  {
		homePage()
		.clickOnSignupLink()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	
	@TestCaseId("TC_HomePage_018")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links for product list page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksListPage() throws Exception
	  {
		homePage().clickOnSearchIcon().enterSearchData("shirt").listPage();
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
		
	  }
	@TestCaseId("TC_HomePage_015")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in pdp")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksPDP() throws Exception
	  {
		homePage().clickOnSearchIcon().enterSearchData("shirt").listPage();
		listPage().clickOnSpecificProduct(1);
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	@TestCaseId("TC_HomePage_015")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in checkout page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksCheckout() throws Exception
	  {
		homePage().clickOnSearchIcon().enterSearchData("shirt").listPage();
		listPage().clickOnSpecificProduct(1)
		.pdPage()
		.selectSize()
		.addToBageFromDetailsPage()
		.clickOnMyBag();
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	@TestCaseId("TC_HomePage_016")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in checkout shipping address page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksCheckoutShippingAddres() throws Exception
	  {
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.clickOnSearchIcon().enterSearchData("shirt").listPage();
		listPage().clickOnSpecificProduct(1)
		.pdPage()
		.selectSize()
		.addToBageFromDetailsPage()
		.clickOnMyBag()
		.summaryPage()
		.clickOnContinuePaymentsLink();
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	@TestCaseId("TC_HomePage_017")
	@Features("Homepage Module")
	@Description("this test case verifies all image path links in my orders history page")
	@Test(groups={"HomePageModule","smoke","regression"})
	  public void verifyAllImagePathLinksInMyOrderPage() throws Exception
	  {
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.clickOnMyOrders();
		homePage()
		.getAllHrefLinks("https://the-collective.imgix.net/");
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@BeforeTest
	public void beforetest1(){
		System.out.println("beforetest1 execution");
			}
	@BeforeTest
	public void beforetest2(){
		System.out.println("beforetest2 execution");
			}
	@AfterTest
	public void aftertest(){
		System.out.println("aftertest execution");
			}
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("BeforeMethod execution");
			}
	@AfterMethod
	public void AfterMethod(){
		System.out.println("AfterMethod execution");
			}
	@BeforeClass
	public void BeforeClass1(){
		System.out.println("BeforeClass1 execution");
			}
	@BeforeClass
	public void BeforeClass2(){
		System.out.println("BeforeClass2 execution");
			}
	@AfterClass
	public void AfterClass(){
		System.out.println("AfterClass execution");
			}
	
	@Test
	public void test1(){
		System.out.println("test1 execution");
			}
	@Test
	public void test2(){
		System.out.println("test2 execution");

			}*/
	

	
	
}