package org.thecollective.pageobjects.checkout;

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

public class CheckoutShippingPageObjects extends PageFactoryInitializer{

	
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Summary')]")
	private WebElement sumaaryPageName;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Shipping Address')]")
	private WebElement shippingPageName;
	
	@FindAll(value={@FindBy(xpath="//div[contains(@class,'checkout-address-main-block')]/descendant::div[contains(@class,'checkout-address-details-block')]")})
	private List<WebElement> savedShippingAddressList;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Payment')]")
	private WebElement paymentPageName;
	
	@FindBy(id="chkCustomerNewShippingAddress")
	private WebElement shipToNewAddressCheckbox;
	
	@FindBy(id="btnSubmitCustomerAddress")
	private WebElement continuePaymentLinkShipping;
	
	
	
	
	//========================================================
	
	@Step("verify shipping address page")
	public CheckoutShippingPageObjects verifyShippingPage() {
		verifyShippingAddressPageName();

		return this;
	}

	@Step("verify page name{0}")
	public CheckoutShippingPageObjects verifyShippingAddressPageName(){
		Waiting.explicitWaitVisibilityOfElement(shippingPageName, 30);
		Assert.assertEquals(shippingPageName.getText().trim(), "2. Shipping Address");
		
		return this;
	}
	@Step("verify saved shipping addresses")
	public CheckoutShippingPageObjects VerifySavedAddresses() {
		Assert.assertTrue(assertVerifySavedAddresses(), "saved addresses are not available, Please create a new shipping address");
		//savedShippingAddressList.get(0).click();
		return this;
	}

	private boolean assertVerifySavedAddresses() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
			if(savedShippingAddressList.get(0).isDisplayed())
			{
				return true;
			}
			
		}catch(Exception e)
		{
			return false;
		}
		return false;
	}
	@Step("select saved shipping address from the saved list")
	public CheckoutShippingPageObjects chooseSavedShippingAddressFromTheList() throws InterruptedException {
		savedShippingAddressList.get(0).click();
		Thread.sleep(1500);

		return this;
	}
	@Step("click on continue payments link in shipping address page")
	public CheckoutShippingPageObjects clickOnContinuePaymentLinkInShipping() {
		Waiting.explicitWaitElementToBeClickable(continuePaymentLinkShipping, 30);
		continuePaymentLinkShipping.click();
		return this;
	}

	@Step("get selected shipping address from the list")
	public String getSelectedShippingAddress() {
		String shippingAddress=driver.findElement(By.xpath("//div[@class='checkout-address-block active']//p[contains(@class,'checkout-address-name-text')]")).getText();

		return shippingAddress;
	}
	
}
