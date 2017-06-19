package org.thecollective.pageobjects.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.Waiting;

import ru.yandex.qatools.allure.annotations.Step;

public class CheckoutPaymentPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Summary')]")
	private WebElement sumaaryPageName;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Shipping Address')]")
	private WebElement shippingPageName;
	

	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Payment')]")
	private WebElement paymentPageName;
	
	@Step("verify payment page")
	public CheckoutPaymentPageObjects verifyPaymentPage() {
		Waiting.explicitWaitVisibilityOfElement(paymentPageName, 30);
		Assert.assertEquals(paymentPageName.getText().trim(), "3. Payment");
		return this;
	}
	
	
	
	

}
