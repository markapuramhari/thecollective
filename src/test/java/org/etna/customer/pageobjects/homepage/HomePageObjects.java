package org.etna.customer.pageobjects.homepage;
import java.util.List;

import org.etna.customer.pageobjects.approvalcartlist.ApprovalCartListPageObjects;
import org.etna.customer.pageobjects.brands.ShopByBrandsPageObjects;
import org.etna.customer.pageobjects.changepassword.ChangePasswordPageObjects;
import org.etna.customer.pageobjects.loginpopup.LoginPopUpPageObjects;
import org.etna.customer.pageobjects.manufacturers.ShopByManufacturersPageObjects;
import org.etna.customer.pageobjects.myaccount.EditContactInfoPageObjects;
import org.etna.customer.pageobjects.myaccount.MyAccountsPageObjects;
import org.etna.customer.pageobjects.openorders.OpenOrdersPageObjects;
import org.etna.customer.pageobjects.orderhistory.OrderHistoryPageObjects;
import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.customer.pageobjects.products.ProductPageObjects;
import org.etna.customer.pageobjects.purchasingagent.AddNewPurchasingAgentPageObjects;
import org.etna.customer.pageobjects.purchasingagent.DisablePurchasingAgentPageObjects;
import org.etna.customer.pageobjects.purchasingagent.ManagePurchasingAgentPageObjects;
import org.etna.customer.pageobjects.quickorder.QuickOrderPageObjects;
import org.etna.customer.pageobjects.requestforquote.RequestForQuotePageObjects;
import org.etna.customer.pageobjects.savecart.SaveCartPageObjects;
import org.etna.customer.pageobjects.signup.SignUpPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.PropertyFileReader;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */
public class HomePageObjects extends PageFactoryInitializer {
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
   Actions action = new Actions(driver);
   
	@FindBy(id="pLoginErr")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//div[@class='cimm_headerRight hideForDevices']/descendant::a[contains(text(),'Login')]")
	private WebElement loginLinkLocator;
	
	@FindBy(xpath="//li[@class='welcomeUser']")
	private WebElement welcomeLocator;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(.,'Log Out')]")
	public WebElement logoutButton;
	
	@FindBy(xpath="//input[@id='txtSearch']")
	private WebElement searchTextbox;

	@FindBy(xpath="//li[@class='ui-menu-item']")
	private List<WebElement> searchResultsLocator;
	
	@FindBy(xpath="//button[@id='performSearchBtn']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[contains(@class,'myaccountDropDown')]/following-sibling::ul/descendant::a[contains(@href,'Dashboard')]")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	private WebElement myAccountInHeader;
	
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Order Status')]")
	private WebElement orderStatusLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement orderPadLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Resources')]")
	private WebElement resourcesLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Help')]")
	private WebElement helpLinkHeader;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_footAccordion_head']")})
	private List<WebElement> everyFooterHeader;
	
	@FindBy(xpath="//a[contains(text(),'Customer Service')]")
	private WebElement customerServiceLink;
	
	@FindBy(xpath="//a[contains(text(),'Help Center')]")
	private WebElement helpCenterLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	private WebElement contactUsFooterLink;
	
	@FindBy(xpath="//a[contains(text(),'Returns')]")
	private WebElement returnsLink;
	
	@FindBy(xpath="//a[contains(text(),'Shipping Policy')]")
	private WebElement shippingPolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'Order Status')]")
	private WebElement orderStatusLink;
	
	@FindBy(xpath="//a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderpadLink;
	
	@FindBy(xpath="//a[contains(text(),'My Cart')]")
	private WebElement myCartLink;
	
	@FindBy(xpath="//a[contains(text(),'Trade Partners')]")
	private WebElement tradePartnersLink;
	
	@FindBy(xpath="//a[contains(text(),'Learning Center')]")
	private WebElement learningCenterLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	private WebElement blogLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Security & Privacy')]")
	private WebElement securityAndPrivacyLink;
	
	@FindBy(xpath="//a[contains(text(),'Terms of Use')]")
	private WebElement termsOfUseLink;

	
	@FindBy(xpath="//a[contains(text(),'Branch Locations')]")
	private WebElement branchLink;
	
	@FindBy(xpath="//a[contains(text(),'Branch Locations')]")
	private WebElement careersLink;
	
	@FindBy(xpath="//a[contains(text(),'Site Map')]")
	private WebElement siteMapLink;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='splitTaxonomy']/li")})
	private List<WebElement> taxonomiesInHeader;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_locateSubContent']/descendant::li/p[not(contains(.,'Contact Us'))]")})
	private List<WebElement> firstBlockOfEveryAddress;
	
	@FindBy(xpath="//input[@id='selectedZipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//select[@id='selectedMiles']")
	private WebElement selectMiles;
	
	@FindBy(xpath="//input[@id='findNowButton']")
	private WebElement findNowButton;
	
	@FindBy(xpath="//ul[contains(@class,'myAccountMenu')]/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderPadLink;
	
	@FindBy(css="")
	private WebElement focusTab;
	
	@FindBy(xpath="//a[@class='cimm_myaccountDropDown']")
	public WebElement userAccountDropdown;
	
	
	@FindBy(xpath="//img[@alt='Logo']")
	private WebElement logo;
	
	String faviconURL = "//link[@href='/ASSETS/WEB_THEMES//ETNA_SUPPLY_COMPANY/images/favicon.ico']";
	//for mks	String faviconURL="//link[@href='/ASSETS/WEB_THEMES//MISSOURI_KANSAS_SUPPLY/images/favicon.ico']";
	
	
	@FindBy(xpath="//label[contains(.,'Featured Manufacturers')]")
	private WebElement featuredManufacturersHeading;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'cimm_headerRight')]/descendant::ul[@class='cimm_myAccountMenu']/li/a")})
	private List<WebElement> myAcountDropdownLinksLocator;

	
	@FindBy(xpath="//ul[@id='featuredBrands']")
	private WebElement featuredBrandsList;
	
	
	@FindBy(xpath="//ul[@id='featuredManufacturers']")
	private WebElement featuredManufacturers;
	
	@FindBy(xpath="//span[@class='foot_copy halfBlokWrap']")
	private WebElement copyRightsOfUnilog;
	
	@FindAll(value={@FindBy(xpath="//div[@class='Widget_slideJssor']/descendant::img")})
	private List<WebElement> carouselImages;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='clearAfter']/li/a")})
	private List<WebElement> mainSectionOptions;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='clearAfter']/descendant::a")})
	private List<WebElement> allSections;
	
	@FindBy(className="cartCountDisplayLi")
	private WebElement cartCountLink;
	
	@FindBy(className="cartTotalDisplayLi")
	private WebElement cartTotalLink;
	
	@FindBy(xpath="//a[contains(.,'Sign Up')]")
	private WebElement signUpLink;
	
	@FindAll(value={@FindBy(xpath="//div[@class='footerCol']/descendant::a")})
	private List<WebElement> footerSection;
	
	@FindBy(css="a[href='/SavedGroups/Products']")
	private WebElement myProductGroupsLinkInUserDropdown;
	
	@FindBy(css="ul[class='clearAfter']>li>a[href='/Brands']")
	private WebElement brandsLink;
	
	@FindBy(css="ul[class='clearAfter']>li>a[href='/Manufacturers']")
	private WebElement manufacturersLink;
	
	@FindBy(xpath="//h3[contains(text(),'Shop By Brands')]")
	private WebElement shopByBrandsHeading;
	
	@FindBy(xpath="//p[contains(text(),'Use the Shop By Brands to choose the particular brand related product list.')]")
	private WebElement brandsDropdownInstructions;
	
	@FindAll(value={@FindBy(xpath="//li[@id='brandLink']/descendant::li/a")})
	private List<WebElement> brandDropdownLinks;
	
	@FindAll(value={@FindBy(xpath="//li[@id='manufacturerLink']/descendant::li/a")})
	private List<WebElement> manufacturersDropdownLinks;
	
	@FindBy(xpath="//div[@class='cimm_shopByBrand']/descendant::a[@href='/Brands']")
	private WebElement viewAllBrandsLink;
	
	@FindBy(xpath="//div[@class='cimm_shopByManufacturer']/descendant::a[@href='/Manufacturers']")
	private WebElement viewAllManufacturersLink;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Add New Purchasing Agent')]")
	private WebElement addNewPurchasingAgentInUserAccountDropdown;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Manage Purchasing Agent')]")
	private WebElement managePurchasingAgentInUserAccountDropdown;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Disable Purchasing Agent')]")
	private WebElement disablePurchasingAgentInuserAccountDropdown;
	
	@FindBy(xpath="//a[@href='Products']")
	private WebElement productsLink;

	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[@href='/SavedGroups/Cart']")
	private WebElement mySaveCartLink;
	
	@FindAll(value={@FindBy(xpath="//span[contains(text(),'Use this address')]")})
	private List<WebElement> useThisAddressButton;
	
	@FindBy(xpath="//ul[@class='cimm_signWrap cimm_signWrapSpace']/descendant::a[contains(text(),'Sign Up')]")
	private WebElement signUpLinkLocator;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Services']")
	private WebElement servicesLink;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Industries Served']")
	private WebElement industriesServedLink;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Events']")
	private WebElement eventsLink;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='About Us']")
	private WebElement aboutUsLink;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	@FindBy(xpath="//h2")
	private WebElement pageNameLocator;
	
	@FindBy(xpath="//div[@class='searchZero']/h3")
	private WebElement errorMessageForSearchResultsLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='ac_results']/descendant::strong")})
	private List<WebElement> autoCompleteResultsLocator;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(@href,'ManagePurchaseAgent')]")
	private WebElement managePurchasingAgentLinkLocator;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Request for Quote')]")
	private WebElement requestForQuoteLinkLocator;
	
	@FindBy(css="a[href='/EditContactInfo']")
	private WebElement editContactLinkLocator;
	
	@FindBy(css="a[href='/DisablePurchaseAgent'")
	private WebElement disablePurchaseAgentLinkLocator;
	
	@FindBy(xpath="//ul[contains(@class,'myAccountMenu')]/descendant::a[contains(text(),'Approval Cart List')]")
	private WebElement approveCartListLinkLocator;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'footerCol')]/descendant::a")})
	private List<WebElement> footerLinksLocator;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeLinkLocator;
	
	@FindBy(xpath="//a[text()='Quick Order Pad']")
	private WebElement quickOrderPadLinkLocator;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Divisions']")
	private WebElement divisionsLinkLocator;
	
	@FindBy(xpath="//ul[contains(@class,'headerNavBar')]/descendant::a[text()='Locations']")
	private WebElement locationsLinkLocator;
	
	@FindBy(xpath="//a[@title='View cart']")
	private WebElement cartLinkLocator;
	
	@FindBy(xpath="//label[text()='Recent News']")
	private WebElement recentNewsHeadingLocator;
	
	@FindBy(xpath="//div[@class='recentNews']")
	private WebElement recentNewsSectionLocator;
	
	@FindBy(xpath="//label[text()='Upcoming Events']")
	private WebElement eventsSectionLocator;

	@FindBy(xpath="//div[contains(@class,'cimm_homeLeftMenu')]")
	private WebElement leftMenuLocator;
	
	@FindAll(value={@FindBy(xpath="//a[text()='Divisions']/ancestor::li/descendant::ul[contains(@class,'hideForDevices')]/li")})
	private List<WebElement> divisionsOptionsLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Divisions']")
	private WebElement divisionsLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Plumbing']")
	private WebElement plumbingInFooterLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Waterworks']")
	private WebElement waterworksInFooterLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Fire Protection']")
	private WebElement fireProtectionLinkInFooterLocator;
	
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Municipal']")
	private WebElement municipalLinkInFooterLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='HVAC']")
	private WebElement hvacLinkInFooterLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='About Us']")
	private WebElement aboutUsLinkInFooterLocator;
	
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Careers']")
	private WebElement careersLinkInFooterLocator;
	
	@FindBy(xpath="//ul[contains(@class,'hideForDevices')]/descendant::a[text()='Etna Mission']")
	private WebElement etnaMissionLinkInFooterLocator;
	
	@FindBy(xpath="//div[contains(@class,'footer')]/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderPadLinkInFooterLocator;
	
	@FindBy(xpath="//div[contains(@class,'header')]/descendant::ul[contains(@class,'headerNavBar')]/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderPadLinkInHeaderLocator;
	
	@FindBy(xpath="//ul[contains(@class,'header')]/descendant::a[contains(text(),'Divisions')]")
	private WebElement divisionsLinkInHeaderLocator;
	
	
	@FindBy(xpath="//ul[contains(@class,'header')]/descendant::a[contains(text(),'Contact Us')]")
	private WebElement contactUsInHeaderLocator;
	
	@FindBy(xpath="//ul[contains(@class,'myAccountMenu')]/descendant::a[text()='Change Password']")
	private WebElement changePasswordLinkLocator;
	
	
	@FindAll(value={@FindBy(xpath="//a[text()='Products']/following-sibling::ul/li/a")})
	private List<WebElement> levelOneCategoriesUnderProductsLinkLocator;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[text()='Edit Contact']")
	private WebElement editContactInfoInUserAccountDropdownLocator;

	@FindBy(xpath="//a[contains(@class,'myaccountDropDown')]/following-sibling::ul/descendant::a[contains(@href,'OrderHistory')]")
	private WebElement orderHistoryLink;
	
	
	@FindBy(xpath="//a[contains(@class,'myaccountDropDown')]/following-sibling::ul/descendant::a[contains(text(),'Open Orders')]")
	private WebElement openOrdersLinkLocator;
	
	
	
	
	public HomePageObjects errorScenarios(String expectedMsg) {
		System.out.println(expectedMsg);
		Assert.assertEquals(errorMsgLocator.getText().trim(), expectedMsg);
		return this;
	}

	public LoginPopUpPageObjects clickLoginLink() throws Exception {
		if(setUp.getBrowser().equals("firefox"))
		{
			Thread.sleep(2000);
		}
		else
		{
			Waiting.explicitWaitElementToBeClickable(loginLinkLocator, 6);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginLinkLocator);
		return loginPopUp();
	}
	
	public boolean checkForUseThisAddress(){
		try
		{
		homePage().verifyUseThisAddressButtonIsDisplayedAndIfDisplayedClickIt();
			return true;
		}
		catch(Exception e)
		{
			return true;
		}
	}
	public HomePageObjects verifyWelcomeMsg() throws Exception{
		try
		{
		Thread.sleep(3000);
		Assert.assertTrue(checkForUseThisAddress());	
		Thread.sleep(1500);
		Waiting.explicitWaitElementToBeClickable(userAccountDropdown, 8);
		Assert.assertTrue(userAccountDropdown.isDisplayed(),"user dropdown is not displayed");
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyWelcomeMsg();
		}
		return this;
		
	}

	public HomePageObjects assertForErrorMessages(String expectedMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgLocator, 10);
		Assert.assertEquals(errorMsgLocator.getText().trim(),expectedMsg,errorMsgLocator.getText().trim()+" is displayed");
		return this;
	}

	public HomePageObjects logout() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",logoutButton);
		return this;
	}
	
	public HomePageObjects verifyDisplayOfLoginLink(){
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 4);
		Assert.assertTrue(loginLinkLocator.isDisplayed(), "Login Link is not displayed");
		return this;
	}

	@Step("Enter search text {0}")
	public HomePageObjects searchText(String searchText) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(searchTextbox, 20);
		searchTextbox.clear();
		searchTextbox.sendKeys(searchText);
		return this;
	}

	public void chooseOption(String textToChoose) {
		Waiting.explicitWaitVisibilityOfElements(searchResultsLocator, 10);
		for(WebElement option : searchResultsLocator)
		{
		if(option.getText().trim().equals(textToChoose))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",option);
		}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Step("click on search button")
	public HomePageObjects clickOnSearch() {
		Waiting.explicitWaitElementToBeClickable(searchButton, 25);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",searchButton);
		return this;
	}

	

	@Step("click on my account")
	public MyAccountsPageObjects clickOnMyAccount() {
		Waiting.explicitWaitVisibilityOfElement(myAccountLink, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myAccountLink);
		return new MyAccountsPageObjects();
		
	}

	public HomePageObjects verifyDisplayOfMyAccountsInHeader() {
		Assert.assertTrue(myAccountInHeader.isDisplayed(), "My Account link is not displayed");
		return this;
	}

	
	@Step("verify heading of every footer link")
	public HomePageObjects verifyHeadingOfEverySectionInFooter() throws Exception {
		String footerHeadings[] =data.getFooterHeadings().split(",");
		for(int i=0;i<everyFooterHeader.size();i++)
		{ 
			Assert.assertEquals(everyFooterHeader.get(i).getText().trim().toLowerCase(),footerHeadings[i].toLowerCase().trim());
			
		}
		return this;
		}

	public HomePageObjects verifyCustomerServiceLinkInFooter() {
		Assert.assertTrue(customerServiceLink.isDisplayed(), "customer service link is not displayed");
		return this;
		
	}

	public HomePageObjects verifyHelpCenterInFooter() {
		Assert.assertTrue(helpCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyHelpContactUsInFooter() {
		Assert.assertTrue(contactUsFooterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyReturnsInFooter() {
		Assert.assertTrue(returnsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyShippingPolicyInFooter() {
		Assert.assertTrue(shippingPolicyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	

	public HomePageObjects verifyMyAccountInFooter() {
		Assert.assertTrue(myAccountLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyOrderStatusInFooter() {
		Assert.assertTrue(orderStatusLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	public HomePageObjects verifyQuickOrderpadInFooter() {
		Assert.assertTrue(quickOrderpadLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyMyCartInFooter() {
		Assert.assertTrue(myCartLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyTradePartnersInFooter() {
		Assert.assertTrue(tradePartnersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyLearningCenterInFooter() {
		Assert.assertTrue(learningCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyManufacturersInFooter() {
		Assert.assertTrue(manufacturersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyBlogInFooter() {
		Assert.assertTrue(blogLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifySecurityAndPrivacyInFooter() {
		Assert.assertTrue(securityAndPrivacyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyTermsOfUseInFooter() {
		Assert.assertTrue(termsOfUseLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyAboutUsInFooter() {
		Assert.assertTrue(aboutUsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyEventsInFooter() {
		Assert.assertTrue(eventsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyBranchLocationInFooter() {
		Assert.assertTrue(branchLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyCareersInFooter() {
		Assert.assertTrue(careersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifySiteMapInFooter() {
		Assert.assertTrue(siteMapLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	@Step("verify taxonomies")
	public HomePageObjects verifyTaxonomies() throws Exception {
		String taxonomies[] = data.getTaxonomies().split(",");
		for(int i=0;i<taxonomiesInHeader.size();i++)
		{
			Assert.assertEquals(taxonomiesInHeader.get(i).getText().replace("\n", "").trim(), taxonomies[i].trim().toUpperCase(),taxonomies[i]+" is not displayed");
		}
		return this;
		
	}

	@Step("click on quick order pad link")
	public QuickOrderPageObjects clickOnQuickOrderPadLink() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(quickOrderPadLink, 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",quickOrderPadLink);
		Thread.sleep(6000);
		return quickOrderPadPage();
		
	}

	
	@Step("wait and verify display of user account dropdown link")
	public HomePageObjects waitForProfileDropdownLink() {
		try
		{
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertTrue(userAccountDropdown.isDisplayed(), "user account dropdown is not displayed");
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			waitForProfileDropdownLink();
		}
		return this;
	}

	@Step("verify welcome message has {0} as the username")
	public HomePageObjects verifyWelcomeMsg(String expectedMsg) {
		checkForUseThisAddress();
		try
		{
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertEquals(userAccountDropdown.getText().trim(), expectedMsg);
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyWelcomeMsg(expectedMsg);
		}
		return this;
	}

	@Step("verify logo")
	public HomePageObjects verifyLogo() {
		Assert.assertEquals(logo.getAttribute("src").trim(),data.getLogo());
		return this;
	}

	@Step("verify favicon")
	public HomePageObjects verifyFavicon() throws Exception {
		Assert.assertEquals(driver.findElement(By.xpath(faviconURL)).getAttribute("href").trim(), data.getFaviconURL());
		return this;
	}
	
	@Step("verify featurered manufacturers heading")
	public HomePageObjects verifyFeaturedManufacturersHeading() {
		Assert.assertTrue(featuredManufacturersHeading.isDisplayed(),"featured manufacturers heading is not displayed");
		return this;
	}

	
	@Step("verify featurered manufacturers list")
	public HomePageObjects verifyFeaturedManufacturersList() {
		Assert.assertTrue(featuredManufacturers.isDisplayed(),"featured products list is not displayed");
		return this;
	}
	
	@Step("verify copy rights of Unilog")
	public HomePageObjects verifyCopyRightsOfUnilog() {
		Assert.assertEquals(copyRightsOfUnilog.getText().trim(),data.getCopyRightsOfUnilogText());
		return this;
	}
	
	
	@Step("verify featurered manufacturer section")
	public HomePageObjects verifyFeaturedManufacturersSection() {
		verifyFeaturedManufacturersHeading();
		return this;
	}

	@Step("verify carousel")
	public HomePageObjects verifyCarousel() throws Exception {
		String [] expectedCarouselImages = data.getCarouselImages().split(",");
		
		for(int i=0;i<carouselImages.size();i++)
		{
		Assert.assertEquals(carouselImages.get(i).getAttribute("src").trim(),setUp.getURL()+expectedCarouselImages[i]);
		
	}
		return this;
	}

	@Step("verify main section options")
	public HomePageObjects verifyMainSectionOptions() throws Exception {
		String [] expectedMainSectionOptions = data.getMainSectionOptions().split(",");
		for(int i=0;i<mainSectionOptions.size();i++)
		{
		Assert.assertEquals(mainSectionOptions.get(i).getText().toUpperCase().trim(),expectedMainSectionOptions[i].toUpperCase());
		
	}
		return this;
	}
	
	
	public HomePageObjects verifyHomePage() throws Exception {
		verifyLogo();
		verifyCopyRightsOfUnilog();
		verifyFavicon();
		verifyCarousel();
		verifyFeaturedManufacturersHeading();
		verifyFeaturedManufacturersList();
		verifyDisplayOfSearchTextboxButton();
		verifyHeaderSection();
		verifyProductsLink();
		verifyBrandsLink();
		verifyCartLink();
		verifyEventsSection();
		verifyRecentNewsSection();
		verifyLeftMenu();
		return this;
	}
	
	private void verifyLeftMenu() {
		Assert.assertTrue(leftMenuLocator.isDisplayed(),"Left menu section is not displayed.");	
	}

	private void verifyRecentNewsSection() {
		Assert.assertTrue(recentNewsSectionLocator.isDisplayed(),"Recent news section is not displayed.");
		
	}

	private void verifyEventsSection() {
		
		Assert.assertTrue(eventsSectionLocator.isDisplayed(),"Events section is not displayed.");
	}

	private void verifyCartLink() {
		Assert.assertTrue(cartLinkLocator.isDisplayed(),"Cart link is not displayed.");
		
	}

	private void verifyBrandsLink() {
		Assert.assertTrue(brandsLink.isDisplayed(),"Brands Link is not displayed.");
		
	}

	private void verifyProductsLink() {
		Assert.assertTrue(productsLink.isDisplayed(),"Products Link is not displayed.");
	}

	@Step("verify featurered brands list")
	private HomePageObjects verifyFeaturedBrandsList() {
		Assert.assertTrue(featuredBrandsList.isDisplayed(),"featured brands list is not displayed");
		return this;
	}

	
	public HomePageObjects verifyHeaderSection() {
		verifyDisplayOfLoginLink();
		verifySignUpLink();
		verifyDisplayOfContactUsLink();
		verifyDisplayOfLocationsLink();
		verifyDisplayOfDivisionsLink();
		verifyDisplayOfQuickOrderPadLink();
		verifyDisplayOfHomeLink();
		return this;
		
	}

	
	private void verifyDisplayOfHomeLink() {
		
		Assert.assertTrue(homeLinkLocator.isDisplayed(),"home link locator is not displayed.");
	}

	private void verifyDisplayOfQuickOrderPadLink() {
		Assert.assertTrue(quickOrderPadLinkLocator.isDisplayed(),"quick order pad link locator is not displayed.");
		
		
	}

	private void verifyDisplayOfDivisionsLink() {
		Assert.assertTrue(divisionsLinkLocator.isDisplayed(),"quick order pad link locator is not displayed.");
		
	}

	private void verifyDisplayOfLocationsLink() {
		Assert.assertTrue(locationsLinkLocator.isDisplayed(),"quick order pad link locator is not displayed.");
	}

	private HomePageObjects verifyDisplayOfEventsLink() {
		Assert.assertTrue(eventsLink.isDisplayed(),"events link is not displayed");
		return this;
	}
	
	
	private HomePageObjects verifyDisplayOfContactUsLink() {
		Assert.assertTrue(contactUsLink.isDisplayed(),"contact us link is not displayed");
		return this;
	}
	

	@Step("verify display of services link")
	private HomePageObjects verifyDisplayOfServicesLink() {
		Assert.assertTrue(servicesLink.isDisplayed(),"services link is not displayed");
		return this;
	}

	@Step("verify display of services link")
	public HomePageObjects verifySignUpLink() {
		Assert.assertTrue(signUpLink.isDisplayed(), "sign up link is not displayed");;
		return this;
	}
	
	@Step("verify display of services link")
	public HomePageObjects verifyCartCountLink() {
		Assert.assertTrue(cartCountLink.isDisplayed(), "cart count link is not displayed");;
		return this;
	}
	
	@Step("verify display of services link")
	public HomePageObjects verifyCartTotalLink() {
		Assert.assertTrue(cartTotalLink.isDisplayed(), "cart total link is not displayed");;
		return this;
	}

	@Step("verify display of search textbox and search button")
	public boolean verifyDisplayOfSearchTextboxButton() {
		Assert.assertTrue(searchTextbox.isDisplayed(), "search Textbox is not displayed");
		Assert.assertTrue(searchButton.isDisplayed(),"search Button is not displayed");
		return true;
		
	}

	@Step("verify options in the main section")
	public HomePageObjects verifyMainSectionOptionPages() {
		String [] expectedMainSectionOptions = data.getMainSectionOptions().split(",");
		for(int i=0;i<mainSectionOptions.size();i++)
		{
		Assert.assertEquals(mainSectionOptions.get(i).getText().toUpperCase().trim(),expectedMainSectionOptions[i].toUpperCase());
		
	}
		return this;
	}

	@Step("verify sections and sub sections")
	public HomePageObjects verifySectionsAndSubsections() {
		
		String[] s = data.getAllSectionsText().split(",");
		for(int i=0;i<allSections.size();i++)
		{
			String x = allSections.get(i).getAttribute("href").trim();
			String y = x.substring(x.lastIndexOf("/")+1);
		Assert.assertEquals(y, s[i]);
		}
		return this;
	}

	@Step("click on the logo")
	public HomePageObjects clickOnLogo() {
		logo.click();
		return this;
	}

	@Step("navigate to my product groups page")
	public MyProductGroupsPageObjects navigateToMyProductGroups() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myProductGroupsLinkInUserDropdown);
		return new MyProductGroupsPageObjects();
	}

	@Step("hover over brands link")
	public HomePageObjects hoverOverBrandsLink() {
		try
		{
		action.moveToElement(brandsLink).build().perform();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			hoverOverBrandsLink();
		}
		return this;	
	}

	@Step("verify shop by brands heading in brands dropdown")
	public HomePageObjects verifyShopByBrandsHeadingInBrandsDropdown(){
		Waiting.explicitWaitVisibilityOfElement(shopByBrandsHeading, 10);
		Assert.assertTrue(shopByBrandsHeading.isDisplayed(),"Shop by Brands Heading is not displayed.");
		return this;
	}
	
	@Step("verify brands dropdown instructions")
	public HomePageObjects brandsDropdownInstructions(){
		Assert.assertTrue(brandsDropdownInstructions.isDisplayed(),"Brands dropdown instructions is not displayed.");
		return this;
	}
	
	@Step("verify brands dropdown links")
	public HomePageObjects verifyBrandsDropdownLinks() throws Exception{
	
		for(WebElement brandLinkDropdown : brandDropdownLinks)
		{
		Assert.assertTrue(brandLinkDropdown.isDisplayed(), "Brand dropdown Link is not displayed.");
		}
		Assert.assertTrue(viewAllBrandsLink.isDisplayed(),"View All Brands link is not displayed.");
		return this;
	}
	
	
	public HomePageObjects verifyBrandsDropdown() throws Exception {
		verifyShopByBrandsHeadingInBrandsDropdown();
		brandsDropdownInstructions();
		verifyBrandsDropdownLinks();
		return this;
	}

	@Step("click on the {0} st/nd/3rd brand")
	public HomePageObjects clickOnASpecificBrand(int specificBrand) {
		brandDropdownLinks.get(specificBrand-1).click();
		return this;
	}
	
	@Step("click on the {0} st/nd/3rd manufacturer")
	public HomePageObjects clickOnASpecificManufacturer(int specificManufacturer) {
		manufacturersDropdownLinks.get(specificManufacturer-1).click();
		return this;
	}
	
	@Step("click on the {0} st/nd/3rd manufacturer")
	public HomePageObjects clickOnASpecificManufacturer(String specificManufacturer) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//ul[contains(@class,'Manufacturer')]/descendant::a[text()='"+specificManufacturer+"']")));
	
		return this;
	}
	
	
	
	public String getSpecificBrandLinkName(int specificBrand) {
		
		Waiting.explicitWaitVisibilityOfElements(brandDropdownLinks, 10);
		String brandName = brandDropdownLinks.get(specificBrand-1).getText().trim();
		return brandName;
	}
	
	public String getSpecificManufacturersLinkName(int specificManufacturer) {
		Waiting.explicitWaitVisibilityOfElements(manufacturersDropdownLinks, 10);
		String brandName = manufacturersDropdownLinks.get(specificManufacturer-1).getText().trim();
		return brandName;
	}

	@Step("verify whether title and breadcrump has the manufacturer name : {0}")
	public HomePageObjects verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(String manufacturerName) throws Exception{
		Thread.sleep(2000);
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().
				breadCrumbs.size()-1).getText().replace("/", "").trim().
				contains(manufacturerName),
				"breadcrump is not the same as the manufacturer name clicked. BreadCrump is -"
				+ " "+productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1)
				.getText().replace("/", "").trim()+" , but manufacturer name is - "+manufacturerName+".");
		Assert.assertTrue(driver.getTitle().trim().contains(manufacturerName), "Title does not contain the manufacturer name.");
		return this;
	}
	
	@Step("verify whether title and breadcrump has the brand name : {0}")
	public HomePageObjects verifyWhetherTitleAndBreadcrumpHaveTheBrandName(String brandName) throws Exception{
		Thread.sleep(2000);
		Assert.assertTrue(productDetailsPage().breadCrumbs.get(productDetailsPage().
				breadCrumbs.size()-1).getText().replace("/", "").trim().
				contains(brandName),
				"breadcrump is not the same as the brand name clicked. BreadCrump is -"
				+ " "+productDetailsPage().breadCrumbs.get(productDetailsPage().breadCrumbs.size()-1)
				.getText().replace("/", "").trim()+" , but brand name is - "+brandName+".");
		Assert.assertTrue(driver.getTitle().trim().contains(brandName), "Title does not contain the brand name.");
		return this;
	}

	@Step("click on view all brands link")
	public ShopByBrandsPageObjects clickOnViewAllBrandsLink() {
		Waiting.explicitWaitVisibilityOfElement(viewAllBrandsLink,3);
		try
		{
		viewAllBrandsLink.click();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			clickOnViewAllBrandsLink();
		}
		return new ShopByBrandsPageObjects();
	}

	@Step("click on brands link")
	public ShopByBrandsPageObjects clickOnBrandsLink() {
		Waiting.explicitWaitVisibilityOfElement(brandsLink, 6);
		brandsLink.click();
		return new ShopByBrandsPageObjects();
	}

	@Step("hover over manufacturers link")
	public HomePageObjects hoverOverManufacturersLink() {
		try
		{
	action.moveToElement(manufacturersLink).build().perform();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			hoverOverManufacturersLink();
		}
		return this;
	}

	@Step("verify manufacturers dropdown")
	public HomePageObjects verifyManufacturersDropdown() {
		Waiting.explicitWaitVisibilityOfElements(manufacturersDropdownLinks, 10);
		for(WebElement manufacturerLinkDropdown : manufacturersDropdownLinks)
		{
		Assert.assertTrue(manufacturerLinkDropdown.isDisplayed(), "Manufacturers dropdown Links are not displayed.");
		}
		Assert.assertTrue(viewAllManufacturersLink.isDisplayed(),"View All Manufacturers link is not displayed.");
		return this;
	}

	@Step("click on view all manufacturers link")
	public ShopByManufacturersPageObjects clickOnViewAllManufacturersLink() {
		Waiting.explicitWaitVisibilityOfElement(viewAllManufacturersLink, 4);
		viewAllManufacturersLink.click();
		return new ShopByManufacturersPageObjects();
	}

	@Step("click on manufacturers link")
	public ShopByManufacturersPageObjects clickOnManufacturersLink() {
		Waiting.explicitWaitVisibilityOfElement(manufacturersLink, 6);
		manufacturersLink.click();
		return new ShopByManufacturersPageObjects();
	}

	@Step("click on user account dropdown")
	public HomePageObjects clickOnUserAccountDropdown() throws Exception {
		Thread.sleep(1500);
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",userAccountDropdown);
		return this;
	}

	@Step("verify add manage disable purchasing agent options is displayed in user account dropdown.")
	public HomePageObjects verifyAddManageDisablePANewPurchasingAgentIsDisplayedInUserAccountDropdown() throws Exception {
		addNewPurchasingAgentInUserAccountDropdown();
		managePurchasingAgentInUserAccountDropdown();
		disablePurchasingAgentInuserAccountDropdown();
		return this;
	}
	
	public HomePageObjects addNewPurchasingAgentInUserAccountDropdown() throws Exception
	{
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			Thread.sleep(1000);
		}
		else
		{
		Waiting.explicitWaitVisibilityOfElement(addNewPurchasingAgentInUserAccountDropdown, 10);
		}
		Assert.assertTrue(addNewPurchasingAgentInUserAccountDropdown.isDisplayed(),"add new purchasing agent is not present in user account dropdown.");
		return this;
	}
	
	public HomePageObjects managePurchasingAgentInUserAccountDropdown()
	{
		Assert.assertTrue(managePurchasingAgentInUserAccountDropdown.isDisplayed(),"manage new purchasing agent is not present in user account dropdown.");
return this;
	}
	
	public HomePageObjects disablePurchasingAgentInuserAccountDropdown()
	{
		Assert.assertTrue(disablePurchasingAgentInuserAccountDropdown.isDisplayed(),"disable new purchasing agent is not present in user account dropdown.");
		return this;
	}

	@Step("click on add new purchasing agent")
	public AddNewPurchasingAgentPageObjects clickOnAddNewPurchasingAgent() {
		Waiting.explicitWaitVisibilityOfElement(addNewPurchasingAgentInUserAccountDropdown, 10);
		addNewPurchasingAgentInUserAccountDropdown.click();
		return addNewPurchasingAgentPage();	
	}

	@Step("click on products link")
	public ProductPageObjects clickOnProductsLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",productsLink);
		return productsPage();
	}

	@Step("click on my save cart")
	public SaveCartPageObjects clickOnMySaveCart() {
		Waiting.explicitWaitVisibilityOfElement(mySaveCartLink, 3);
		mySaveCartLink.click();
		return saveCartPage();
	}
	
	
	@Step("verify use this address button locator")
	public HomePageObjects verifyUseThisAddressButtonIsDisplayedAndIfDisplayedClickIt() throws Exception {
		Waiting.explicitWaitVisibilityOfElements(useThisAddressButton,5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",useThisAddressButton.get(0));
		return this;
	}

	@Step("click on sign up link.")
	public SignUpPageObjects clickOnSignUpLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",signUpLinkLocator);
		return new SignUpPageObjects();
	}

	@Step("verify placeholder of search textbox")
	public HomePageObjects verifyPlaceHolderOfSearchTextbox(String expectedSearchTextboxPlaceholder) {
		Assert.assertEquals(searchTextbox.getAttribute("value").trim(),expectedSearchTextboxPlaceholder);
		return this;
	}

	@Step("verify whether the invalid search message contains We found 0 results for  {0} . You may try some other search ")
	public HomePageObjects verifyMessageForInvalidSearchData(String searchTextForInvalidTestData) {
		Waiting.explicitWaitVisibilityOfElement(pageNameLocator, 10);
		Assert.assertTrue(pageNameLocator.getText().trim().equalsIgnoreCase("Site Results"),"Expecting site results as the heading but found "+pageNameLocator.getText().trim());
		Assert.assertEquals(errorMessageForSearchResultsLocator.getText().replace("\n", "").trim(), "We found 0 results for  "+searchTextForInvalidTestData+" . You may try some other search");
		return this;
	}

	public boolean assertAlertMessage(String alertMessageWhenGoButtonIsClickedWithProvidingSearchText)
	{
		boolean t = TestUtility.getAlertText().trim().equals(alertMessageWhenGoButtonIsClickedWithProvidingSearchText.trim());
		TestUtility.alertAccept();
		return t;
	}
	
	@Step("verify whether alert message is {0}")
	public HomePageObjects verifyAlertMessage(String alertMessageWhenGoButtonIsClickedWithProvidingSearchText) {
	Assert.assertTrue(assertAlertMessage(alertMessageWhenGoButtonIsClickedWithProvidingSearchText),"Alert Text is not "+alertMessageWhenGoButtonIsClickedWithProvidingSearchText);
	return this;	
	}

	@Step("verifying autocomplete suggestions has {0}")
	public HomePageObjects verifyAutoCompleteList(String partialSubCategory) throws Exception {
		Waiting.explicitWaitVisibilityOfElements(autoCompleteResultsLocator, 10);
		for(WebElement autoCompleteResult : autoCompleteResultsLocator)
		{
			Assert.assertTrue(autoCompleteResult.getText().trim().equalsIgnoreCase(partialSubCategory),"Search auto complete list does not contain "+partialSubCategory);
		}
		return this;
	}

	@Step("click on manage purchasing agent.")
	public ManagePurchasingAgentPageObjects clickOnManagePurchasingAgent() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",managePurchasingAgentLinkLocator);
		return managePurchasingAgentPage();
	}
	
	@Step("click on request for quote link")
	public RequestForQuotePageObjects clickOnRequestForQuote() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",requestForQuoteLinkLocator);
		return requestForQuotePage();
	}

	@Step("click on edit contact link")
	public EditContactInfoPageObjects clickOnEditContactLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",editContactLinkLocator);
		return editContactInfoPage();
	}

	@Step("click on disable purchasing agent")
	public DisablePurchasingAgentPageObjects clickOnDisablePurchasingAgent() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",disablePurchaseAgentLinkLocator);
		return disablePurchaseAgentPage();
	}

	@Step("click on approval cart list")
	public ApprovalCartListPageObjects clickOnApprovalCartList() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",approveCartListLinkLocator);
		return approvalCartListPage();
	}

	public HomePageObjects verifyFooterLinks(String[] expectedFooterLinks) {
		for(int i = 0 ; i<footerLinksLocator.size() ; i++)
		{
			Assert.assertEquals(footerLinksLocator.get(i).getText().trim(), expectedFooterLinks[i]);
		}
		return this;
	}

	public HomePageObjects verifyHomePageAfterLogin() throws Exception {
		verifyHomePage();
		
		return this;
	}

	public HomePageObjects verifyDivisionsInHeader(String[] allDivisionsInHeader) {
		
		for(int i = 0 ; i< divisionsOptionsLocator.size() ; i++)
		{
			Assert.assertEquals(divisionsOptionsLocator.get(i).getText().trim(),allDivisionsInHeader[i]);
		}
		return this;
	}


	public HomePageObjects clickOnQuickOrderPadLinkInFooter() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",quickOrderPadLinkInFooterLocator);
		return this;
	}

	public HomePageObjects clickOnSpecificFooterLink(String specificFooterLink) {
		driver.findElement(By.xpath("//ul[contains(@class,'hideForDevices')]/descendant::a[text()='"+specificFooterLink+"']")).click();
		return this;
	}

	public HomePageObjects verifyContent(String specificFooterLink,String contentLocator,String expectedContent) throws Exception {
		
		Assert.assertEquals(driver.findElement(By.xpath(contentLocator)).getText().replace("\n", "").trim(),expectedContent);
	
		return this;
	}

	public HomePageObjects clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader(
			String specificHeaderLink) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//ul[contains(@class,'headerNavBar')]/descendant::a[contains(text(),'"+specificHeaderLink+"')]")));
		return this;
	}

	public HomePageObjects clickOnQuickOrderPadLinkInHeader() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",quickOrderPadLinkInHeaderLocator);
		return this;
	}

	public ContactUsPageObjects clickOnContactUsLink() {
		contactUsInHeaderLocator.click();
		return contactUsPage();
	}

	public HomePageObjects hoverOverDivisionsLink() {
	action.moveToElement(divisionsLinkInHeaderLocator).build().perform();
		return this;
	}

	@Step("click on my save cart link")
	public SaveCartPageObjects clickOnMySaveCartLink() {
		Waiting.explicitWaitVisibilityOfElement(mySaveCartLink, 3);
		mySaveCartLink.click();
		return saveCartPage();
	}

	@Step("click on {0} category")
	public HomePageObjects clickOnSpecificCategory(String categoryNameToSearch) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text()='"+categoryNameToSearch+"']")));
		return this;
	}

	@Step("hover over products link")
	public HomePageObjects hoverProductsLink() {
		action.moveToElement(productsLink).build().perform();
		return this;
	}

	public HomePageObjects verifyFirstLevelCategories(String[] productNames) throws InterruptedException {
		Thread.sleep(2000);
		for(int i = 0 ; i < levelOneCategoriesUnderProductsLinkLocator.size();i++)
		{
			
			Assert.assertTrue(levelOneCategoriesUnderProductsLinkLocator.get(i).getText().toLowerCase().replace(".","").trim().contains(productNames[i].replace(".", "").toLowerCase()), "Expected : "+productNames[i].toLowerCase()+ " Actual : "+levelOneCategoriesUnderProductsLinkLocator.get(i).getText().toLowerCase().replace(".","").trim());	
		}
		return this;
}

    @Step("click on edit contact link")
	public EditContactInfoPageObjects clickOnEditContactLinkInUserAccountDropdown() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",editContactInfoInUserAccountDropdownLocator);
		return editContactInfoPage();
	}

	@Step("click on change password")
	public ChangePasswordPageObjects clickOnChangePassword() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",changePasswordLinkLocator);
		return changePasswordPage();
	}

	@Step("click on Open Orders")
	public OpenOrdersPageObjects clickOnOpenOrders() {
		Waiting.explicitWaitVisibilityOfElement(openOrdersLinkLocator, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",openOrdersLinkLocator);
		return openOrdersPage();
	}

	@Step("click on Order history")
	public OrderHistoryPageObjects clickOnOrderHistory() {
		Waiting.explicitWaitVisibilityOfElement(orderHistoryLink, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",orderHistoryLink);
		return orderHistoryPage();
	}

	public HomePageObjects verifyMyAccountDropdown(String[] expectedDropdownLinks) throws Exception {
		Thread.sleep(1500);
		Waiting.explicitWaitVisibilityOfElements(myAcountDropdownLinksLocator, 10);
		for(int i = 0 ; i<myAcountDropdownLinksLocator.size() ; i++)
		{
			Assert.assertEquals(myAcountDropdownLinksLocator.get(i).getText().trim(), expectedDropdownLinks[i]);
		}
		return this;
	}

	
}
	
