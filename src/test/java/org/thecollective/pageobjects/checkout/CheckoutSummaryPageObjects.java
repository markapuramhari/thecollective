package org.thecollective.pageobjects.checkout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(verifyProductavailability(emptyCartText), "products are not available");
		for(int i=0;i<deleteLinks.size();i++)
		{
			deleteLinks.get(i).click();
			Thread.sleep(3500);
			driver.navigate().refresh();
		}

		return this;
	}
	@Step("verify products in summary page")
	private boolean verifyProductavailability(String emptyCartText) {
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
	public CheckoutSummaryPageObjects verifyEmptyCartPage(String emptyCartText) {
		verifyEmptyCartText(emptyCartText);
		verifyAddProductsToCartLink();

		return this;
	}
	@Step("verify add products to cart link")
	public CheckoutSummaryPageObjects verifyAddProductsToCartLink() {
		Waiting.explicitWaitVisibilityOfElement(addProductsToCartLink, 30);
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
	public CheckoutSummaryPageObjects verifyEmptyCartText(String emptyCartText) {
		Waiting.explicitWaitVisibilityOfElement(emptyCartPageText, 30);
		Assert.assertEquals(emptyCartPageText.getText().trim(), emptyCartText);

		return this;
	}

}
