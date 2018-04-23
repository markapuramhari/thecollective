package org.thecollective.pageobjects.myaccount;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class MyAccountPageObjects extends PageFactoryInitializer{
	
	@FindBy(tagName="h2")
	private WebElement savedItemsPageName;
	
	@FindBy(tagName="h1")
	private WebElement orderHistoryPageName;
	
	@FindBy(xpath="//span[contains(text(),'MY ADDRESSES')]")
	private WebElement myAddressesTab;
	
	@FindBy(xpath="//h2[contains(text(),'Your Saved Items is empty')]")
	private WebElement emtyWishListText;
	
	@FindBy(xpath="//a[@id='pastorder']")
	private WebElement pastOrdersTabHeader;
	
	@FindBy(xpath="//a[@href='#recent_order']")
	private WebElement recentOrdersTabHeader;
	
	@FindAll(value={@FindBy(xpath="//input[@id='btnAddToBag']")})
	private List<WebElement> addToBagInWishLIst;
	
	@Step("verify saved items page")
	public MyAccountPageObjects verifySavedItemsPage() {
		Waiting.explicitWaitVisibilityOfElement(savedItemsPageName, 20);
		Assert.assertTrue(savedItemsPageName.isDisplayed(), "Page name is not displayed");
		Assert.assertTrue(savedItemsPageName.getText().contains("Saved Items"), "Page name is not correct");

		return this;
	}


	@Step("verify my orders page")
	public MyAccountPageObjects verifyMyOrdersPage() {
		Waiting.explicitWaitVisibilityOfElement(orderHistoryPageName, 20);
		Assert.assertTrue(orderHistoryPageName.isDisplayed(), "Page name is not displayed");
		Assert.assertEquals(orderHistoryPageName.getText(), "Order History");
		

		return this;
	}

	@Step("verify order history page tabs")
	public MyAccountPageObjects verifyMyOrdersPageTabs() {
		verifyRecentOrdersTab();
		verifyPastOrdersTab();

		return this;
	}
	@Step("verify past orders tab")
	public MyAccountPageObjects verifyPastOrdersTab() {
		Waiting.explicitWaitVisibilityOfElement(pastOrdersTabHeader, 20);
		Assert.assertEquals(pastOrdersTabHeader.getText().trim(), "Past Orders");

		return this;
	}


	@Step("verify recet orders page tab")
	public MyAccountPageObjects verifyRecentOrdersTab() {
		Waiting.explicitWaitVisibilityOfElement(recentOrdersTabHeader, 20);
		Assert.assertTrue(recentOrdersTabHeader.getText().contains("Recent"), "Invalid tab name");

		return this;
	}

	@Step("verify recently placed order number")
	public MyAccountPageObjects verifyOrderNumber(String orderNumber) 
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='recent_order']//a[contains(@id,'"+orderNumber+"')]")).isDisplayed(), "order number is not shown on recenty orders page");
		return this;
	}


	@Step("click on my addresses tab")
	public MyAccountPageObjects clickOnMyAddressTab() throws InterruptedException {
		Assert.assertTrue(assertVerifyMyAddressesTab(),"my addresses tab is not displayed");
		myAddressesTab.click();
		Thread.sleep(2000);
		return this;
	}


	private boolean assertVerifyMyAddressesTab() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(myAddressesTab.isDisplayed())
			{
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}

		
		return false;
	}

	@Step("verify my addresses page")
	public MyAccountPageObjects verifyMyAddressesPage() {
		

		return this;
	}

	@Step("get the my wish list product{0} count")
	public int getMyWishListCount() {
		int wishlistCount = 0;
		Waiting.explicitWaitVisibilityOfElement(emtyWishListText, 30);
		if (emtyWishListText.isDisplayed())
		{
			 wishlistCount=0;
		}
		else
		{
			int a=addToBagInWishLIst.size();
			wishlistCount=a;
		}
		return wishlistCount;
	}

}
