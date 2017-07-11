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

public class CheckoutPaymentPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Summary')]")
	private WebElement sumaaryPageName;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Shipping Address')]")
	private WebElement shippingPageName;
	
	@FindBy(xpath="//input[@value='Confirm Order']")
	private WebElement confirmOrderButtonInPaymentPage;
	
	@FindBy(xpath="//ol[@class='checkout-step-indicator']//a[contains(text(),'Payment')]")
	private WebElement paymentPageName;
	
	@FindAll(value={@FindBy(xpath="//img[contains(@src,'payu.png')]")})
	private List<WebElement> payuCardPaymentLocaror;
	
	
	
	
	//=====================================================
	
	@Step("verify payment page")
	public CheckoutPaymentPageObjects verifyPaymentPage() {
		Waiting.explicitWaitVisibilityOfElement(paymentPageName, 30);
		Assert.assertEquals(paymentPageName.getText().trim(), "3. Payment");
		return this;
	}
	@Step("select {0} payment option from the list")
	public CheckoutPaymentPageObjects selectPaymentMethod(String expPaymentOption) {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try{
		if(payuCardPaymentLocaror.get(0).isDisplayed())
		{
			WebElement paymentOption=driver.findElement(By.xpath("//div[@class='payment_option_block']//span[contains(text(),'"+expPaymentOption+"')]"));
			paymentOption.click();
		}
		}catch(Exception e)
		{

			driver.navigate().refresh();
			selectPaymentMethod(expPaymentOption);
			
		}
		return this;
	}
	@Step("click on confirm order button")
	public CheckoutPaymentPageObjects clickOnSubmitOrderButton() throws InterruptedException {
		Waiting.explicitWaitElementToBeClickable(confirmOrderButtonInPaymentPage, 30);
		confirmOrderButtonInPaymentPage.click();
		Thread.sleep(3500);

		return this;
	}
	@Step("verify {0} payment method")
	public CheckoutPaymentPageObjects verifyPaymentMethod(String expPaymentOption) {
		Assert.assertTrue(assertVerifyPaymentMethod(expPaymentOption), "selected payment option :"+expPaymentOption+"is not available");
		
		
		return this;
	}
	private boolean assertVerifyPaymentMethod(String expPaymentOption) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try
		{
		if( driver.findElement(By.xpath("//div[@class='payment_option_block']//span[contains(text(),'"+expPaymentOption+"')]")).isDisplayed())
		{
			return true;
			
		}
		}catch(Exception e)
		{
			return false;
		}
		return false;
	}
	
	
	

}
