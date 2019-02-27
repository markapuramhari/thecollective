package org.thecollective.pageobjects.pdp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.pageobjects.homepage.HomePageObjects;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class PDPageObjects  extends PageFactoryInitializer
{
	@FindBy(id="btnAddToBag")
	private WebElement addToBagButton;

	@FindBy(className="wishlist active orange-heart")
	private WebElement addedToWishListIcon;

	@FindBy(xpath="//a[@class='wishlist_icon']/span")
	private WebElement myWishListCount;
	
	@FindBy(xpath="//div[@id='product_details']/a")
	private WebElement myWishListIconInPDP;
	
	@FindBy(xpath="//a[@title='My Bag']")
	private WebElement myBagIcon;
	
	@FindBy(tagName="h5")
	private WebElement shortDescription;
	
	@FindBy(xpath="//h2[contains(@class,'product_title')]")
	private WebElement  productName;
	
	@FindAll(value={@FindBy(xpath="//a[@id='online-size-list']")})
	private List<WebElement> sizeOptions;
	
	@FindBy(xpath="//div[@id='product_details']/p[@class='product_price_collective']/span[not (contains(@class,'price'))and  not(contains(@class,'discount'))]")
	private WebElement itemPriceWithDiscount;
	
	@FindBy(xpath="//h1[@itemprop='price']")
	private WebElement itemPriceWithoutDiscount;
	
	@FindBy(xpath="//div[contains(@class,'online-size-collective')]/button")
	private WebElement sizeDropdownLocator;
	
	@FindBy(xpath="//div[@id='product_details']/h2")
	private WebElement brandNamePdp;
	
	
	
	//======================================================
	
	@Step("click on add to bag button")
	public PDPageObjects addToBageFromDetailsPage() throws InterruptedException {
		Thread.sleep(2500);
		Waiting.explicitWaitElementToBeClickable(addToBagButton, 30);
		addToBagButton.click();
		Thread.sleep(2500);
		return this;
	}
	@Step("click on my bag icon")
	public PDPageObjects clickOnMyBag() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(myBagIcon, 20);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2500);
		myBagIcon.click();
		return this;
		}
	@Step("get the product name {0} from the pdp")
	public String getTheProductName() 
	{
		Waiting.explicitWaitVisibilityOfElement(productName, 30);
		String brandName = productName.getText();
		
		return brandName;
	}
	@Step("select size from listd options")
	public PDPageObjects selectSize() throws InterruptedException 
	{
		Waiting.explicitWaitVisibilityOfElement(sizeDropdownLocator, 30);
		Thread.sleep(3500);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		sizeDropdownLocator.click();
		sizeOptions.get(0).click();

		return this;
	}
	@Step("return product price from pdp")
	public String getProductPrice() {
		String itemPriceInPDP;
		try{
			itemPriceInPDP=itemPriceWithoutDiscount.getText().trim();
		}catch(Exception e)
		{
			 itemPriceInPDP=itemPriceWithDiscount.getText().trim();
		}
		
		return itemPriceInPDP;
	}
	@Step("verify page title for pdp")
	public PDPageObjects verifyPageTitle(String productNamePDP, String brandNamePDP) {
		String title=driver.getTitle();
		Assert.assertTrue(title.contains(productNamePDP), "pdp title is not correct");
		
		return this;
	}
	@Step("verify product name list page:{0} with pdp: {1}")
	public PDPageObjects verifyProductName(String productNameListPage) {
		Waiting.explicitWaitVisibilityOfElement(shortDescription, 40);
		Assert.assertEquals(shortDescription.getText().trim().toLowerCase(), productNameListPage.toLowerCase().trim());

		return this;
	}
	@Step("return brand name from pdp")
	public String getBrandName() {
		String brandName=brandNamePdp.getText().trim();
		return brandName;
	}
	@Step("verify my wish list icon in pdp")
	public PDPageObjects verifyMyWishListIcon() {
		//Waiting.explicitWaitVisibilityOfElement(myWishListIconInPDP, 20);
		Assert.assertTrue(assertVerifyMyWishListIcon(), "my wish list icon is not avaialable");

		return this;
	}
	private boolean assertVerifyMyWishListIcon() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		try{
			if(myWishListIconInPDP.isDisplayed())
			{
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}

		return false;
	}
	@Step("click on my wish list icon in PDP")
	public PDPageObjects clickOnMyWishListIcon()
	{
		myWishListIconInPDP.click();
		return this;
	}
	@Step("verify my wish list functionality")
	public PDPageObjects verifyMyWishListFunctionality(int previousCount) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3500);
		try{
			if(addedToWishListIcon.isDisplayed())
			{
				int updatedCount=Integer.parseInt(myWishListCount.getText().trim());
				Assert.assertEquals(updatedCount,previousCount-1);
				}
			else{
					
				myWishListIconInPDP.click();
				Thread.sleep(3500);
				int updatedCount=Integer.parseInt(myWishListCount.getText().trim());
				Assert.assertEquals(updatedCount,previousCount-1);
			}
		}
		catch(Exception e){
				myWishListIconInPDP.click();
				Thread.sleep(4500);
				int updatedCount=Integer.parseInt(myWishListCount.getText().trim());
				Assert.assertEquals(updatedCount,previousCount+1);
			}
		return this;
	}
	
	

}
