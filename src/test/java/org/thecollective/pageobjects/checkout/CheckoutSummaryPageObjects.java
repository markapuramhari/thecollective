package org.thecollective.pageobjects.checkout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;
import ru.yandex.qatools.allure.annotations.Step;

public class CheckoutSummaryPageObjects extends PageFactoryInitializer{
	
	@FindBy(xpath="//span[contains(@class,'brand_title')]")
	private WebElement ProductTitleInCheckoutPage;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continuePaymentsLinkInSummary;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Summary')]")
	private WebElement sumaaryPageName;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Shipping Address')]")
	private WebElement shippingPageName;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Payment')]")
	private WebElement paymentPageName;
	
	@FindAll(value={@FindBy(xpath="//button[contains(text(),'Delete')]")})
	private List<WebElement> deleteLinks;
	
	@FindBy(tagName="h1")
	private WebElement emptyCartPageText;
	
	@FindBy(xpath="//a[contains(.,'Add products to your cart')]")
	private WebElement addProductsToCartLink;

	@FindBy(id="cboQuantity")
	private WebElement qtyDropdown;
	
	@FindAll(value={@FindBy(xpath="//select[@id='cboQuantity']/option")})
	private List<WebElement> qtyDropdownOptions;
	
	@FindBy(xpath="//div[@class='discount-price-cont']/span")
	private WebElement itemPriceAfterDiscount;
	
	@FindBy(xpath="//div[@class='total_price']/span")
	private WebElement totalItemPrice;
	
	@FindBy(xpath="//div[@class='checkout_summary_block']//a[contains(text(),'Login to Avail')]")
	private WebElement loginLinkInCouponsTab;
	
	@FindBy(id="slecheckoutCustomerMobile")
	private WebElement usernameFieldCheckout;
	
	@FindBy(id="slePasswordData")
	private WebElement passwordFieldCheckout;
	
	@FindBy(id="aForgotPassword")
	private WebElement forgotPasswordLinkCheckout;
	
	@FindBy(name="checkoutsubmit")
	private WebElement loginAndContinueButtonCheckout;
	
	@FindBy(xpath="//a[contains(text(),'SIGN UP')]")
	private WebElement signUpLinkCheckout;
	
	@FindBy(id="btnSubmitGuestAddress")
	private WebElement continueToPaymentCheckout;
	
	@FindBy(xpath="//td[contains(@class,'order_val')]")
	private WebElement orderSummaryPriceInLoginSection;
	
	@FindBy(xpath="//a[contains(text(),'Apply Now')]")
	private WebElement couponsLinkAfterLogin;
	
	@FindBy(xpath="//a[text()='Coupons']")
	private WebElement couponsTabLink;
	
	@FindBy(xpath="//ul//a[text()='Coupons']")
	private WebElement couponHeaderLink;
	
	
	//===========================================================================//
	
	@Step("verify checkout page")
	public CheckoutSummaryPageObjects verifyCheckoutPage(String productName) {
		Waiting.explicitWaitVisibilityOfElement(ProductTitleInCheckoutPage, 30);
		Assert.assertEquals(ProductTitleInCheckoutPage.getText().trim().toLowerCase(), productName.trim().toLowerCase());
		return this;
	}
	@Step("verify product image displayed or not")
	public CheckoutSummaryPageObjects verifyProductImage() {
		
		return this;
	}
	@Step("click on continue payments link in checkout summary page")
	public CheckoutSummaryPageObjects clickOnContinuePaymentsLink() {
		Waiting.explicitWaitVisibilityOfElement(continuePaymentsLinkInSummary, 30);
		continuePaymentsLinkInSummary.click();

		return this;
	}
	@Step("remove products from bag")
	public CheckoutSummaryPageObjects removeProducts(String emptyCartText) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Assert.assertTrue(verifyProductavailability(emptyCartText), "products are not available");
		for(int i=0;i<deleteLinks.size();i++)
		{
			deleteLinks.get(i).click();
			Thread.sleep(2500);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(1500);
		}
		return this;
	}
	@Step("verify products in summary page")
	private boolean verifyProductavailability(String emptyCartText) throws InterruptedException {
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			if(deleteLinks.get(0).isDisplayed()){
				return true;
			}
			
		}catch(Exception e)
		{
			verifyEmptyCartText(emptyCartText);
			return true;
		}
		return false;
	}
	@Step("verify empty cart page")
	public CheckoutSummaryPageObjects verifyEmptyCartPage(String emptyCartText) throws InterruptedException {
		verifyEmptyCartText(emptyCartText);
		verifyAddProductsToCartLink();

		return this;
	}
	@Step("verify add products to cart link")
	public CheckoutSummaryPageObjects verifyAddProductsToCartLink() {
		Waiting.explicitWaitVisibilityOfElement(addProductsToCartLink, 15);
		Assert.assertTrue(assertVerifyAddProductsToCart(), "add products to cart link is not enabled.");

		return this;
	}
	private boolean assertVerifyAddProductsToCart() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(addProductsToCartLink.isDisplayed()){
				addProductsToCartLink.click();
				return true;
			}
		}catch(Exception e)
		{
			return false;
		}
		return false;
	}
	@Step("verify empty cart text")
	public CheckoutSummaryPageObjects verifyEmptyCartText(String emptyCartText) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2500);
		Waiting.explicitWaitVisibilityOfElement(emptyCartPageText, 10);
		Assert.assertEquals(emptyCartPageText.getText().trim(), emptyCartText);

		return this;
	}
	//13548
	@Step("verify qty drodown ")
	public CheckoutSummaryPageObjects updateTheQuantity(String updatedQty) {
		Waiting.explicitWaitVisibilityOfElement(qtyDropdown, 10);
		new Select(qtyDropdown).selectByVisibleText(updatedQty);
		return this;
	}
	@Step("verify prosuct name {0} in checkout summary page")
	public CheckoutSummaryPageObjects verifyProductName(String productName) 
	{
		Waiting.explicitWaitVisibilityOfElement(ProductTitleInCheckoutPage, 30);
		Assert.assertEquals(ProductTitleInCheckoutPage.getText().trim().toLowerCase(), productName.trim().toLowerCase());
		return this;
	}
	@Step("verify qty dropdown avaialability")
	public CheckoutSummaryPageObjects verifyQuantityDropdown() {
		Waiting.explicitWaitVisibilityOfElement(qtyDropdown, 30);
		Assert.assertTrue(qtyDropdown.isDisplayed(),"qty dropdown is not displayed");
		return this;
	}
	@Step("verify updated qty ")
	public CheckoutSummaryPageObjects verifyUpdatedQuanity(String updatedQty) {
		
		Assert.assertEquals(new Select(qtyDropdown).getFirstSelectedOption().getText().trim(),updatedQty);
		
		return this;		
	}
	@Step("verify product price {0} which is displayed in pdp")
	public CheckoutSummaryPageObjects verifyProductPriceBeforeUpdate(String productPrice) {
		Assert.assertEquals(totalItemPrice.getText().trim().replace(".00", ""),productPrice.trim().replace(".00", ""));
		return this;
	}
	@Step("verify product price{0} after update")
	public CheckoutSummaryPageObjects verifyUpdatedPrice(String updatedQuantity, String productPrice) {
		//driver.navigate().refresh();
		Waiting.explicitWaitVisibilityOfElement(totalItemPrice, 30);
		Float actualTotalPriceAfterUpdate=Float.parseFloat(totalItemPrice.getText().replace(",", "").trim());
		Float exptotalPriceAfterUpdate=Float.parseFloat(productPrice.replace(",", "").trim());
		int updatedQty=Integer.parseInt(updatedQuantity.trim());
		Assert.assertEquals(actualTotalPriceAfterUpdate, exptotalPriceAfterUpdate*updatedQty);
		

		return this;
	}
	@Step("verify coupons tab before login")
	public CheckoutSummaryPageObjects verifyCouponsTabBeforeLogin() 
		{
			Assert.assertTrue(assertVerifyLoginLink(), "Login link is not available in coupons tab");
			return this;
		}
	private boolean assertVerifyLoginLink() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			if(loginLinkInCouponsTab.isDisplayed())
				{
				return true;
				}
			
			}
		catch(Exception e)
			{
				return false;
			}
		return false;
	}
	@Step("click on Login link in summary page")
	public CheckoutSummaryPageObjects clickOnLoginLinkInSummaryPage()
	{
		loginLinkInCouponsTab.click();
		return this;
	}
	@Step("verify login page in summary page")
	public CheckoutSummaryPageObjects verifyLoginPageInCheckoutPage(String loginPageName) throws InterruptedException 
	{
		loginPage().verifyLoginPage(loginPageName);

		return this;
	}
	@Step("verify Login section by clicking on continue payments link")
	public CheckoutSummaryPageObjects verifyLoginSectionInCheckoutPage() {
		Waiting.explicitWaitVisibilityOfElement(usernameFieldCheckout, 30);
		Assert.assertTrue(usernameFieldCheckout.isDisplayed(), "user name field is not displayed.");
		Assert.assertTrue(passwordFieldCheckout.isDisplayed(), "password field is not displayed.");
		Assert.assertTrue(forgotPasswordLinkCheckout.isDisplayed(), "forgot password link is not displayed.");
		Assert.assertTrue(loginAndContinueButtonCheckout.isDisplayed(), "login and continue Button is not displayed.");
		Assert.assertTrue(signUpLinkCheckout.isDisplayed(), "signup Link is not displayed.");
		Assert.assertTrue(continueToPaymentCheckout.isDisplayed(), "continue to payment link is not displayed.");
		
		
		
		return this;
	}
	@Step("verify login functionality from checkout page")
	public CheckoutSummaryPageObjects loginToSiteFromCheckoutPage(String userName, String password) {
		Waiting.explicitWaitVisibilityOfElement(usernameFieldCheckout, 30);
		usernameFieldCheckout.clear();
		usernameFieldCheckout.sendKeys(userName);
		passwordFieldCheckout.clear();
		passwordFieldCheckout.sendKeys(password);
		loginAndContinueButtonCheckout.click();

		return this;
	}
	@Step("verify coupons tab after login")
	public CheckoutSummaryPageObjects verifyCouponsTabAfterLogin() {
		Assert.assertTrue(couponsLinkAfterLogin.isEnabled(),"coupons link is not enabled");

		return this;
	}
	@Step("verify order summary price in checkout login page")
	public CheckoutSummaryPageObjects verifyOrdrSummaryPrice(String productPrice) {
		Assert.assertEquals(orderSummaryPriceInLoginSection.getText().trim(), productPrice.trim());
		
		return this;
	}
	@Step("click on coupons link in checkout page")
	public CheckoutSummaryPageObjects clickOnCouponsLink() {
		Waiting.explicitWaitElementToBeClickable(couponsLinkAfterLogin, 30);
		couponsLinkAfterLogin.click();

		return this;
	}
	@Step("verify coupons page")

	public CheckoutSummaryPageObjects verifyCouponsSection(String couponsTabOptions) throws Exception {
		String options[]=couponsTabOptions.split(",");
		List<WebElement> e=driver.findElements(By.xpath("//ul[contains(@class,'checkout_cart_tabs')]//a"));
		for(int i=0;i>options.length;i++){
			
			Assert.assertEquals(e.get(i).getText().trim(), options[i].trim());
		
		}
		
		return this;

	}
	@Step("click on coupons tab")
	public CheckoutSummaryPageObjects clickOnCouponsTab() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		couponsTabLink.click();
		return this;
	}
	@Step("click on coupon header in coupons tab")
	public CheckoutSummaryPageObjects clickOnCouponsHeader() 
	{
		Waiting.explicitWaitElementToBeClickable(couponHeaderLink, 15);
		couponHeaderLink.click();

		return this;
	}
	@Step("enter coupon code{0}")
	public CheckoutSummaryPageObjects enterCouponCode(String couponCode) 
	{


		return this;
	}
	
}
