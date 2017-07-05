	package org.thecollective.pageobjects.homepage;
	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
	import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.pageobjects.myaccount.MyAccountPageObjects;
import org.thecollective.pageobjects.pdp.PDPage;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
	import org.thecollective.utils.SearchDataPropertyFile;
import org.thecollective.utils.TestUtility;
import org.thecollective.utils.Waiting;

import com.google.common.base.Verify;

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
		 
		 @FindBy(xpath="//img[@alt='usericon']")
		 private WebElement userIcon;
		 
		 @FindBy(xpath="//a[@title='Login']")
		 private WebElement loginLink;
		 
		 @FindBy(xpath="//span[contains(.,'Logout')]")
		 private WebElement logoutLink;
		 
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
	  Assert.assertEquals(driver.getTitle(),expAccountName+" | "+productName, "unable to login to site with the entered credentials");
	
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
			Waiting.explicitWaitVisibilityOfElements(footerLinks, 15);
			for(int i=0;i<footerLinks.size();i++)
			{
				
				Assert.assertEquals(footerLinks.get(i).getText(),expFooterLinks[i]);
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
	public HomePageObjects clickOnEachLink() 
	   {
		   String previousURL="";
		   String currentURL="";
		   Waiting.explicitWaitVisibilityOfElements(footerLinks, 15);
			for(int i=0;i<footerLinks.size();i++)
			{
				try{
					previousURL=driver.getCurrentUrl();
				footerLinks.get(i).click();
				currentURL=driver.getCurrentUrl();
				if(!currentURL.toLowerCase().contains(footerLinks.get(i).getText().toLowerCase()))
					{
					System.out.println(footerLinks.get(i).getText());
					}
				}
				catch(Exception e)
				{
					
				}
				System.out.println(i);
				if(!previousURL.equals(currentURL)){
				logo.click();
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
	   public HomePageObjects clickOnSpecificSubDivisionLinkUnderDivisionsSectionInHeader(String specificHeaderLink,String specifiedListLink) throws InterruptedException 
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
		Thread.sleep(2500);
		List< WebElement> links=driver.findElements(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='Men']/following-sibling::div//a"));
		for(WebElement availableLinks: links)
		{ 
			//Assert.assertTrue(availableLinks.isDisplayed(), "child links are not displayed");
			String linkName=availableLinks.getText();
			System.out.println(linkName);
			action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='"+linkName+"']"))).moveToElement(driver.findElement(By.xpath("//li[contains(@class,'menuonly ')]/a[text()='"+availableLinks+"']"))).click().build().perform();
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
	public HomePageObjects enterSearchData() throws AWTException {
		searchInputTextField.clear();
		searchInputTextField.sendKeys("shirt");
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
	
		
	
	}
		
