package org.thecollective.modules;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

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
		.clickOnEachFooterLink(data.getFooterLinks());
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
		.verifyUserProfile(data.getMyAccountPageTitle());
		
	  } 
	@TestCaseId("TC_HomePage_006")
	@Features("Homepage Module")
	@Description("this test case verifies all footer links")
	@Test(enabled=false,groups={"HomePageModule","smoke","regression"})
	  public void verifyHomePageFooterLinks() throws Exception
	  {
		homePage()
		.clickOnFooterToggleButton()
		.clickOnEachFooterLink(data.getexpFooterLInkFun());
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
			.enterSearchData("abkjsjd")
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
		listPage().clickOnSpecificProduct(2)
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
		listPage().clickOnSpecificProduct(3)
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
		homePage().logout();
	  }
	
	@Test(enabled =false)
	public void logoComparision() throws IOException, InterruptedException
	{
		
		List<WebElement> images=driver.findElements(By.xpath("//img"));
		WebElement logoImage = driver.findElement(By.cssSelector("img[alt='logo']"));
		WebElement image1 = driver.findElement(By.xpath("//section[@data-index='1']//img"));
		WebElement image2 = driver.findElement(By.xpath("//section[@data-index='2']//img"));
		
		for(int i=0;i<images.size();i++){
		Screenshot screenshot = new AShot().takeScreenshot(driver,images.get(i));
	       ImageIO.write(screenshot.getImage(),"PNG",new File("D:\\Thiruveedhi\\Implementation\\thecollective\\resources\\tc-logo"+System.currentTimeMillis()+".jpg"));
	       Thread.sleep(3000);
		}
        BufferedImage expectedImage = ImageIO.read(new File("D:\\Thiruveedhi\\Implementation\\thecollective\\resources\\tc-logo.jpg"));
        /*Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
        BufferedImage actualImage = logoImageScreenshot.getImage();
                 
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        Assert.assertTrue(diff.hasDiff(),"Images are not Same");*/
        
        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, image1);
        BufferedImage actualImage = logoImageScreenshot.getImage();
                 
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        Assert.assertTrue(diff.hasDiff(),"Images not are Same");
        
       // getImagePercentage(expectedImage, actualImage) { // start of the function getImagePercentage

            int percentage = 0;
           // BufferedImage biA = ImageIO.read(actualImage); // reads fileA into bufferedImage
            DataBuffer dbA = expectedImage.getData().getDataBuffer();
            int sizeA = dbA.getSize();
          //  BufferedImage biB = ImageIO.read(expectedImage); // reads fileA into bufferedImage
            DataBuffer dbB = expectedImage.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            int count = 0;
            // compare data-buffer objects 
            if (sizeA == sizeB) { // checks the size of the both the bufferedImage

                for (int i = 0; i < sizeA; i++) {

                    if (dbA.getElem(i) == dbB.getElem(i)) { // checks bufferedImage array is same in both the image
                        count = count + 1;
                    }
                }
                percentage = (count * 100) / sizeA; // calculates matching percentage
            } else {
                System.out.println("Both the images are not of same size");
            }
            System.out.println( percentage); // returns the matching percentage value
        }
		
}