package org.thecollective.pageobjects.checkout;

import org.openqa.selenium.WebElement;
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
	

	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Payment')]")
	private WebElement paymentPageName;
	
	
	
	
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
}
