	package org.thecollective.pageobjects.homepage;
	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.verifier.VerificationResult;
import org.apache.bcel.verifier.exc.VerificationException;
import org.apache.poi.hssf.record.PrintSetupRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
	import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.pageobjects.listpage.ListPageObjects;
import org.thecollective.pageobjects.myaccount.MyAccountPageObjects;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
	import org.thecollective.utils.SearchDataPropertyFile;
import org.thecollective.utils.TestUtility;
import org.thecollective.utils.Waiting;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;
import ru.yandex.qatools.allure.annotations.Step;
	
	/*
	 * 
	 * @author Thiruveedhi Chinna
	 *
	 */
	public class HomePageObjects extends PageFactoryInitializer {
		
		
		 SearchDataPropertyFile data = new SearchDataPropertyFile();
		 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		 Actions action = new Actions(driver);
		 
		 @FindBy(xpath="//img[contains(@src,'tc-logo.jpg')]")
		 private WebElement logo;
		 
		 @FindBy(xpath="//li[@class='search-icon']")
		 private WebElement searchIcon;
		 
		 @FindBy(xpath="//input[@id='top_search']")
		 private WebElement searchInputTextField;
		 
		 
		@FindAll(value={@FindBy(xpath="//nav[contains(@class,'navbar')]/descendant::ul")})
		 private List<WebElement> headerLinks;
		 
		 @FindAll(value={@FindBy(xpath="//li[contains(@class,'menuonly')]//a")})
		 private List<WebElement> megaMenuLinks;
		 
		 @FindAll(value={@FindBy(xpath="//img")})
		 private List<WebElement> imagePaths;
		 
		 @FindAll(value={@FindBy(xpath="//ul[@id='nav-bar']//a")})
		 private List<WebElement> staticCategoryLinks;
		 
		 @FindBy(xpath="//a[@class='my-account-icon-link']")
		 private WebElement userIcon;
		 
		 @FindBy(xpath="//a[@title='Login']")
		 private WebElement loginLink;
		 
		 @FindBy(xpath="//span[contains(.,'Logout')]")
		 private WebElement logoutLink;
		 
		 @FindBy(xpath="//a[@title='Sign Up']")
		 private WebElement signUpLink;
				 
		 @FindBy(xpath="//li[@id='mencollection']/a")
		 private WebElement menHeaderLink;
		 
		 @FindBy(xpath="//li[@id='womencollection']/a")
		 private WebElement womenHeaderLink;
		 
		 @FindBy(xpath="//a[contains(@class,'store-icon')]/span[contains(text(),'Stores')]")
		 private WebElement storeLocatorLink;
		
		@FindBy(xpath="//a[contains(text(),'My Account')]")
		private WebElement myAccountOption;
		
		@FindAll(value={@FindBy(xpath="//ul[contains(@class,'navbar-nav')]/li/a")})
		private List<WebElement> megaMenusHeaderLinks;		
		
		@FindAll(value={@FindBy(xpath="//div[contains(@class,'footer__menu')]//span")})
		private List<WebElement> footerHeaders;
		
		@FindAll(value={@FindBy(xpath="//div[contains(@class,'footer__menu')]//a")}) 
		private List<WebElement> footerLinks;
	   
		@FindBy(xpath="//div[contains(.,'More Information')]//i")
		private WebElement moreInfoLink;
		
		@FindBy(xpath="//a[contains(.,'Stores')]")
		private WebElement storesLinkLocator;
	
		@FindAll(value={@FindBy(xpath="")})
		private List<WebElement> mensMegaLinks;
		
		@FindAll(value={@FindBy(xpath="//li[@class='menu-large menuonly dropdown-toggle accessories-menu-large']//div[@id='custom-menu-bar-men']//a")})
		private List<WebElement> mensAccesssoriesMegaLinks;
		
		@FindAll(value={@FindBy(xpath="//li[@id='mencollection']//h4[text()='BRANDS']/following-sibling::ul//a[ not (contains(text(),'View All Brands'))]")})
		private List<WebElement> menStaticBrands;
		
		
		
		
		@FindAll(value={@FindBy(xpath="//li[@id='womencollection']//h4[text()='BRANDS']/following-sibling::ul//a[ not (contains(text(),'View All Brands'))]")})
		private List<WebElement> womenStaticBrands;
		
		
		@FindAll(value={@FindBy(xpath="")})
		private List<WebElement> womensMegaLinks;
		
		@FindAll(value={@FindBy(xpath="//li[@class='menu-large menuonly dropdown-toggle accessories-menu-large']//div[@id='custom-menu-bar-women']//a")})
		private List<WebElement> womensAccessoriesMegaLinks;
		
		@FindBy(xpath="//a[text()='Saved Items']")
		private WebElement savedItemsHeaderLink;
		
		
		@FindBy(xpath="//a[text()='My Orders']")
		private WebElement myOrdersHeaderLink;
		
		@FindBy(xpath="//a[@class='wishlist_icon']")
		private WebElement myWishListIcon;
		
		@FindBy(xpath="//a[@class='wishlist_icon']/span")
		private WebElement myWishListCount;

		@FindBy(xpath="//div[@class='more-info footerslide']//i")
		private WebElement moreInformationLink;

		
		@FindBy(xpath="//a[@title='My Bag']")
		private WebElement myBagIcon;
		
		@FindAll(value={@FindBy(xpath="//a[contains(@onclick,'L3 click')]")})
		private List<WebElement> ASMegaLinks;
		
		@FindAll(value={@FindBy(xpath="//div[@class='product-views-container']")})
		private List<WebElement> images;
		
		
		
		//=============================================================
	@Step("verify product logo")
	 public HomePageObjects verifyLogo(){
		 Assert.assertEquals(logo.getAttribute("src").trim(),data.getLogo());
		 return this;
	 }
	@Step("click on my bag icon")
	public HomePageObjects clickOnMyBag() throws InterruptedException {
		Thread.sleep(3000);
		myBagIcon.click();
		return this;
		}
	 @Step("verify header links")
	 public HomePageObjects verifyHeaderLinks()
	 {
		 for(WebElement w: headerLinks){
			 Assert.assertTrue(w.isEnabled(),"Header link :"+w.getText()+" is not enabled");
		 }
		 return this;
	 }
	 @Step("verify menu links")
	 public HomePageObjects verifyMegaMenuLinks() throws InterruptedException{
		 Thread.sleep(2000);
		 String currentUrl=driver.getCurrentUrl();
		 String newUrl="";
	 //Waiting.explicitWaitVisibilityOfElements(megaMenuLinks, 10);
	 for(WebElement w:megaMenuLinks)
	 {
		 driver.navigate().refresh();
		 //Waiting.explicitWaitVisibilityOfElement(w, 15);
		 try{
			 
		 w.click();
		 Thread.sleep(1500);
		 newUrl= driver.getCurrentUrl();
		 if(!newUrl.equals(currentUrl))
		 {
			 System.out.println(w.getText());
		 }
		 else
		 {
			 //System.out.println(w.getText());
		 }
		 logo.click();
		 
		
		 }
		 catch(Exception e)
		 
		 {
			e.printStackTrace();
				 System.out.println(w.getText());
				
				 //Verify.verifyNotNull(driver.getPageSource());
						
					 
				 }
			 }
			 
			 return this;
		 }
	 @Step("verify stores link")
	 public HomePageObjects verifyStoresLink()
	 {
		 Assert.assertTrue(storesLinkLocator.isDisplayed(), "store locatoe is not available");
		 
	  return this;
	 }
	 @Step("verify home page before login")
	   public HomePageObjects verifyHomePage() throws InterruptedException {
		verifyLogo();
		verifyHeaderLinks();
		verifyStoresLink();
		verifyMegamenus();
		
			 
	
		return this;
	}
	 @Step("verify all the mega menu's {0}")
	   public HomePageObjects verifyMegamenus() {
		 String[] s=data.getMegaMenusHeaderLinks().split(",");
		 for(int i=0;i<megaMenusHeaderLinks.size();i++)
		 {
			 
			 Assert.assertTrue(megaMenusHeaderLinks.get(i).isDisplayed(),"Mega menu's are not displayed :"+megaMenusHeaderLinks.get(i).getText()+"");
			 megaMenusHeaderLinks.get(i).click();
			 
			 }

		 
		   return this;
	}
	@Step("click on login link")
	public HomePageObjects clickOnLoginLink() throws InterruptedException {
		   action.moveToElement(userIcon);
		   action.moveToElement(loginLink).click().build().perform();
		   Thread.sleep(2500);
		
		return this;
	}
	   @Step("verify user profile dropdown in home page")
	public HomePageObjects verifyUserProfile(String expAccountName, String productName) {
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		   action.moveToElement(userIcon).moveToElement(myAccountOption).click().build().perform();
		  // Waiting.explicitWaitVisibilityOfElement(userIcon, 15);
		  // System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(),expAccountName, "unable to login to site with the entered credentials");
	
		return this;
	}
	   @Step("verify footer headers")
	   public HomePageObjects verifyFooterHeaders(String foorerHeaders) {
		  String expFooterHeader[]=foorerHeaders.split(",");
		Waiting.explicitWaitVisibilityOfElements(footerHeaders, 15);
		for(int i=0;i<footerHeaders.size();i++)
		{
			Assert.assertEquals(footerHeaders.get(i).getText(),expFooterHeader[i]);
		}
		return this;
	}
	   @Step("verify all footer links")
	   public HomePageObjects verifyFooterLinks(String footerLink) {
		  String expFooterLinks[]=footerLink.split(",");
			//Waiting.explicitWaitVisibilityOfElements(footerLinks, 20);
			for(int i=0;i<expFooterLinks.length;i++)
			{
				
				WebElement ele=driver.findElement(By.xpath("//div[contains(@class,'footer__menu')]//a[text()='"+expFooterLinks[i]+"']"));
				Assert.assertEquals(ele.getText().trim(),expFooterLinks[i]);
			}
		   
		   return this;
	}
	   @Step("click on more infomation link to see footer section")
	public HomePageObjects clickOnMoreInfoLink() throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreInfoLink);
		return this;
	}
	   @Step("click on each footer link(s)")
	public HomePageObjects clickOnEachFooterLink(String expFooterLinkText) throws Exception 
	   {
		  // throw new Exception("needs to write footer links functionality, sice page titles needs to be update from dev team");
		String expFooter[]=  expFooterLinkText.split(",");
		for(int i=0;i<expFooter.length;i++)
			
		  {
			 WebElement ele=driver.findElement(By.xpath("//div[contains(@class,'footer__menu')]//a[text()='"+expFooter[i]+"']"));
			  try
			  {				 
				  switch (ele.getText()) {
					case "The Collective":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "About Us | The Collective");
					//	driver.navigate().back();
						break;
					case "Careers":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Careers | The Collective");
						driver.navigate().back();
						break;
					case "FAQs":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "FAQs | The Collective");
						driver.navigate().back();
						break;
					case "Shipping Policy":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Shipping Policy | The Collective");
						driver.navigate().back();
						break;
					case "Return Policy":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Return Policy | The Collective");
						driver.navigate().back();
						break;
					case "Made To Measure":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Made to Measure | The Collective");
						driver.navigate().back();
						break;
					case "Privacy Policy":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Privacy Policy | The Collective");
						driver.navigate().back();
						break;
					case "Store Locator":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Store Locator | The Collective");
						driver.navigate().back();
						break;

					case "Brand Directory":
						ele.click();
						Assert.assertEquals(driver.getTitle().trim(), "Brand Directory | The Collective");
						driver.navigate().back();
						break;

					default: throw new Exception("Link is not displayed");
						
					} 
					
					
					
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
				//  System.out.println(footerHeaders.get(i).getAttribute("innerText"));
			  }
		  }
		return this;
			
	   }
	   @Step("click on stores page")
	public HomePageObjects clickOnStoreLink() {
		   Waiting.explicitWaitElementToBeClickable(storesLinkLocator, 15);
		   storesLinkLocator.click();

		return this;
	}
	   public HomePageObjects clickOnSpecificCategoryFromTopNavigation(String specificHeaderLink,String specifiedListLink) throws InterruptedException 
	   {
		  List< WebElement> l=driver.findElements(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='Men']/following-sibling::div//a"));
		  for(int i=0;i<l.size()-1;i++)
		  {
			  System.out.println(l.get(i).getText());
		  }
		   action.moveToElement(driver.findElement(By.xpath("//div[@class='container']//a[text()='"+specificHeaderLink+"' and contains(@onclick,'L1 click')]"))).moveToElement(driver.findElement(By.xpath("//div[@class='container']//a[text()='"+specificHeaderLink+"' and contains(@onclick,'L1 click')]/following-sibling::div//li/a[text()='"+specifiedListLink+"' and contains(@onclick,'L3 click')]"))).click().build().perform();
			//((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='"+specifiedListLink+"']")));
			Thread.sleep(2000);
		   return this;
		}
	   public HomePageObjects verifyContent(String specificFooterLink,String contentLocator,String expectedContent) throws Exception {
			
			Assert.assertEquals(driver.findElement(By.xpath(contentLocator)).getText().replace("\n", "").trim(),expectedContent);
		
			return this;
		}
	public HomePageObjects megaNestedLinks() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		List< WebElement> links=driver.findElements(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='Men']/following-sibling::div//a"));
		for(int i=0; i>links.size();i++)
		{ 
			//Assert.assertTrue(availableLinks.isDisplayed(), "child links are not displayed");
			String linkName=links.get(i).getText().toString();
			System.out.println(linkName);
			action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'menuonly')]//a[text()='"+linkName+"']"))).click().build().perform();
			//availableLinks.click();
		Thread.sleep(2500);
		}
		return this;
	}
	@Step("navigate to each category by the mega menu")
	public HomePageObjects navigateToEachCategory() {
		
		return this;
	}
	@Step("navigate to each mens accessories category page")
	public HomePageObjects navigateToMenAccessoriesCategory() throws InterruptedException {
		for(int i=0;i<mensAccesssoriesMegaLinks.size();i++)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", mensAccesssoriesMegaLinks.get(i));
			Thread.sleep(3000);
			//listPage().verifyBreadcrumbs(wb.getText());
			driver.navigate().back();
		}
		return this;
	}
	@Step("mousehover over on my account link")
	public HomePageObjects mouseHoverOverOnMyAccount() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		new Actions(driver).moveToElement(userIcon).moveToElement(myAccountOption).click().build().perform();

		return this;
	}
	@Step("verify welcome message")
	public HomePageObjects verifyWelcomeMessage() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Waiting.explicitWaitVisibilityOfElement(myAccountOption, 25);
		action.moveToElement(userIcon).moveToElement(myAccountOption).build().perform();
		Assert.assertTrue(myAccountOption.isDisplayed(),"unable to login to site");
		return this;
	}
	@Step("click on logo")
	public HomePageObjects clickLogo() {
		logo.click();
		return this;
	}
	@Step("click on saved items link")
	public MyAccountPageObjects navigateToSavedItemsPage() {
		//Waiting.explicitWaitElementToBeClickable(savedItemsHeaderLink, 20);
		 new Actions(driver).moveToElement(userIcon).moveToElement(savedItemsHeaderLink).click().build().perform();

		return new MyAccountPageObjects();
	}
	@Step("navigate to my orders page")
	public MyAccountPageObjects navigateToMyOrdersPage() {
		 new Actions(driver).moveToElement(userIcon).moveToElement(myOrdersHeaderLink).click().build().perform();

		return new MyAccountPageObjects();
	}
	@Step("click on search icon")
	public HomePageObjects clickOnSearchIcon() throws InterruptedException {
		Waiting.explicitWaitElementToBeClickable(searchIcon, 15);
		searchIcon.click();
		Thread.sleep(2500);
		return this;
	}
	@Step("enter search key")
	public HomePageObjects enterSearchData(String searchdata) throws AWTException {
		searchInputTextField.click();
		searchInputTextField.clear();
		searchInputTextField.sendKeys(searchdata);
		searchInputTextField.sendKeys(Keys.ENTER);
		
		return this;
	}
	@Step("verify wish list icon in home page")
	public HomePageObjects verifyWishListIcon() {
		Waiting.explicitWaitVisibilityOfElement(myWishListIcon, 15);
		Assert.assertTrue(myWishListIcon.isDisplayed(),"my wish list icon is not displayed");
		return this;
	}
	@Step("click on my wish list icon")
	public HomePageObjects clickOnWishListIcon() {
		Waiting.explicitWaitElementToBeClickable(myWishListIcon, 15);
		myWishListIcon.click();

		return this;
	}
	@Step("logout from the site")
	public HomePageObjects logout() throws InterruptedException 
	{
		
			
		new Actions(driver).moveToElement(userIcon).moveToElement(logoutLink).click().build().perform();
		Thread.sleep(2500);
		
		
		return this;
	}
	@Step("click on my orders link")
	public HomePageObjects clickOnMyOrders() throws InterruptedException {
		new Actions(driver).moveToElement(userIcon).moveToElement(myOrdersHeaderLink).click().build().perform();
		
		Thread.sleep(2500);
		return this;
	}
	@Step("Mouse hover over on Men's link")
	public HomePageObjects mouseHoverOverOnMenLink() {
		new Actions(driver).moveToElement(menHeaderLink).build().perform();

		return this;
	}
	@Step("Mouse hover over on women's link")
	public HomePageObjects mouseHoverOverOnWomenLink() {
		new Actions(driver).moveToElement(womenHeaderLink);

		return this;
	}
	@Step("click on view all brands link")
	public HomePageObjects clickOnViewAllBrandsLink(String gender) throws InterruptedException {
		//Assert.assertTrue(assertVerifyViewAllBrandsLink(gender), "view All brands link is not displayed");
		clickOnGenderViewAllBrandsLink(gender);
		return this;
	}
	@Step("click view all brands link for {0} category")
	public HomePageObjects clickOnGenderViewAllBrandsLink(String gender) throws InterruptedException {
		WebElement e=driver.findElement(By.xpath("//a[text()='"+gender+"']/following-sibling::div//a[contains(text(),'View All Brands')]"));
		switch(gender){
		
		case "Women":
			action.moveToElement(womenHeaderLink).moveToElement(e).click().build().perform();
			//action.click().build().perform();
			//((JavascriptExecutor)driver).executeScript("arguments[0].click()", e)).build().perform();
			Thread.sleep(2500);
			break;
		case "Men":
			action.moveToElement(menHeaderLink).moveToElement(e).click().build().perform();
			//action.moveToElement(menHeaderLink).moveToElement((WebElement) ((JavascriptExecutor)driver).executeScript("arguments[0].click()", e)).build().perform();
			Thread.sleep(2500);
			break;
		}
		
		return this;
		
	}
	private boolean assertVerifyViewAllBrandsLink(String gender) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(driver.findElement(By.xpath("//a[text()='"+gender+"']/following-sibling::div//a[contains(text(),'View All Brands')]")).isDisplayed())
			{
				return true;
			}
		}catch(Exception e){
			return false;
		}
		return false;
	}
	@Step("get my wishList count")
	public int getSavedItemsCount()
	{
		int count;
		try{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Waiting.explicitWaitVisibilityOfElement(myWishListCount, 40);
	int savedItemsCount=Integer.parseInt(myWishListCount.getText().trim());
	return savedItemsCount;
		}
	catch(Exception e)
		{
		homePage().clickOnWishListIcon();
		count=myAccountPage().getMyWishListCount();
	}
	return count;
	}
	public HomePageObjects clickHeaderLogo() {
		
		
		return this;
		
	}
	@Step("click on all the static brands")
	public HomePageObjects clickOnMenBrandLinks() throws InterruptedException {
		int n;
		//Waiting.explicitWaitVisibilityOfElement(menHeaderLink, 20);
		mouseHoverOverOnMenLink();
		n=menStaticBrands.size();
		//System.out.println(n);
		for(int i=0;i<menStaticBrands.size();i++)
		{
			
			new Actions(driver).moveToElement(menHeaderLink).moveToElement(menStaticBrands.get(i)).click().build().perform();
			Thread.sleep(3000);
			listPage()
			.verifySearchResultsPage();
			clickLogo();
		}
		return this;
	}
	@Step("click on all the static brands")
	public HomePageObjects clickOnWomenBrandLinks() throws InterruptedException {
		int n;
		//Waiting.explicitWaitVisibilityOfElement(menHeaderLink, 20);
		mouseHoverOverOnWomenLink();
		n=womenStaticBrands.size();
		//System.out.println(n);
		for(int i=0;i<womenStaticBrands.size();i++)
		{
			
			new Actions(driver).moveToElement(womenHeaderLink).moveToElement(womenStaticBrands.get(i)).click().build().perform();
			Thread.sleep(3000);
			listPage()
			.verifySearchResultsPage();
			clickLogo();
		}
		return this;
	}
	@Step("click on each and every category link")
	public HomePageObjects clickOnCategoryLink() throws Exception {
		
		for(int i=0;i<staticCategoryLinks.size();i++)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", staticCategoryLinks.get(i));
			Thread.sleep(1500);
			listPage().verifyListedProduct();
		}
		return this;
	}
	public void getAllHrefLinks(String path) {
		//Waiting.explicitWaitVisibilityOfElements(imagePaths, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for(int i=0;i< imagePaths.size();i++){
			String a=imagePaths.get(i).getAttribute("src").toString();
			//System.out.println("pass : "+a);
			
			if(a.contains(path))
			{
				
				System.out.println("pass : "+a);
			}
				
			else{
				
				System.out.println("failed : "+a);
			}
		}
	}
	@Step("click on signup link")
	public HomePageObjects clickOnSignupLink() throws InterruptedException {
		 action.moveToElement(userIcon);
		   action.moveToElement(signUpLink).click().build().perform();
		   Thread.sleep(2500);
		return this;
	}
	@Step("click on footer link toggle button")
	public HomePageObjects clickOnFooterToggleButton() {
		Assert.assertTrue(assertVerifyMoreInfoLink(), "");
		moreInformationLink.click();

		return this;
	}
	private boolean assertVerifyMoreInfoLink() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(moreInfoLink.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	@Step("mouse hover over on user profile before login")
	public HomePageObjects mouseHoverOverUserProfileBeforeLogin() {
		Waiting.explicitWaitVisibilityOfElement(userIcon, 30);
		action.moveToElement(userIcon).click().build().perform();
		return this;
	}
	@Step("verify {0} link")
	public HomePageObjects verifyLoginLink(String expLoginLinkName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		action.moveToElement(userIcon).click().moveToElement(loginLink).build().perform();
		
		Assert.assertTrue(loginLink.isDisplayed());
		return this;
	}
	
	
	}
	
	
	
