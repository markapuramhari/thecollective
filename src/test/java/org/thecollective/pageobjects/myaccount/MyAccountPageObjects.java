package org.thecollective.pageobjects.myaccount;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringEscapeUtils;
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
	
	
	
	
	@FindBy(xpath="//a[@rel='myaccountpassword']")
	private WebElement changePasswordTab;
	
	@FindBy(xpath="//input[@id='oldPwd']")
	private WebElement oldPasswordFiled;
	
	@FindBy(xpath="//input[@id='newPwd']")
	private WebElement NewPasswordFiled;
	
	@FindBy(xpath="//input[@id='confirmPwd']")
	private WebElement ConfirmPasswordFiled;
	
	@FindBy(xpath="//button[contains(.,'Submit')]")
	private WebElement changePasswordSubmitButton;
	
	
	@FindBy(xpath="//div[@class='msg_display']/*[not(self::a)]")
	private WebElement pswChangeSuccessMsg;
	
	@FindBy(xpath="//span[(.='LOGOUT')]")
	private WebElement logutLinkInMyAccountPage;
	
	@FindBy(xpath="//a[@rel='myaccountwishlist']")
	private WebElement savedItemsTabLinkInMyAccountPage;
	
	
	
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


	@Step("click on change password tab")
	public MyAccountPageObjects clickOnChangePasswordTab() {
		Assert.assertTrue(assertVerifyChangePAsswordTab(),"change password tab is not shown");
		//Waiting.explicitWaitVisibilityOfElement(changePasswordTab, 20);
		changePasswordTab.click();

		return this;
	}


	private boolean assertVerifyChangePAsswordTab() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(changePasswordTab.isDisplayed())
		{
			return true;
		}
		return false;
	}

	@Step("update current password {0} to {1}")
	public MyAccountPageObjects updateCurrentPassword(String oldPassword, String newPassword) throws InterruptedException {
		Waiting.explicitWaitElementToBeClickable(oldPasswordFiled, 15);
		oldPasswordFiled.clear();
		oldPasswordFiled.sendKeys(oldPassword);
		NewPasswordFiled.clear();
		NewPasswordFiled.sendKeys(newPassword);
		ConfirmPasswordFiled.clear();
		ConfirmPasswordFiled.sendKeys(newPassword);
		changePasswordSubmitButton.click();
		Thread.sleep(1500);
		return this;
	}

	@Step("verify change password success message as {0}")
	public MyAccountPageObjects verifyPasswordUpdateSuccessMessage(String expSuccessMsg) {
		Assert.assertTrue(assertVerifyPwdChangeSucMsg(),"change password success message is not displayed");
		String a=pswChangeSuccessMsg.getText().trim().replaceAll("[\r\n]+", " ");
		String clean = StringEscapeUtils.unescapeHtml4(a).replaceAll("[^\\x20-\\x7e]", "");
		Assert.assertEquals(clean.replace("Ã—", " ").trim(), expSuccessMsg);
		return this;
	}


	private boolean assertVerifyPwdChangeSucMsg() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if(pswChangeSuccessMsg.isDisplayed())
		{
			return true;
		}
		return false;
	}

	@Step("click on logout link in my account page")
	public MyAccountPageObjects clickOnLogoutLinkInMyAccountPage() {
		Assert.assertTrue(assertVerifyLogoutLink(),"logout link not shown in my account page");
		logutLinkInMyAccountPage.click();
		return this;
	}


	private boolean assertVerifyLogoutLink() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(logutLinkInMyAccountPage.isDisplayed())
		{
			return true;
		}
		return false;
	}

	@Step("click on saved items tab")
	public MyAccountPageObjects clickOnSavedItemsTab() throws InterruptedException {
		Assert.assertTrue(savedItemsTabLinkInMyAccountPage.isDisplayed(), "Saved items tab is not available");
		savedItemsTabLinkInMyAccountPage.click();
		Thread.sleep(1500);
		return this;
	}


}
