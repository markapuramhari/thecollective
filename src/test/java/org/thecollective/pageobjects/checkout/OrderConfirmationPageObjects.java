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

public class OrderConfirmationPageObjects extends PageFactoryInitializer{

	@FindBy(tagName="h1")
	private WebElement thankingMessage;
	
	@FindBy(xpath="//div[contains(@class,'order-no-view')]/a")
	private WebElement orderNumberLocator;
	
	@FindAll(value={@FindBy(xpath="//div[@class='order-detail-view']/descendant::div[contains(@class,'text-left')]/span")})
	private List<WebElement> shippingAddressText;
	
	
	@Step("vefiry order confirmation page")
	public OrderConfirmationPageObjects verifyOrderConfirmationPage(String expThankingText) {
		Waiting.explicitWaitVisibilityOfElement(thankingMessage, 30);
		Assert.assertEquals(thankingMessage.getText().trim(),expThankingText.trim());

		return this;
	}


	@Step("get order number")
	public String getOrderNumber() {
		String orderNumber=orderNumberLocator.getText().trim();
		return orderNumber;
	}

	@Step("verify shipping address {0}")
	public OrderConfirmationPageObjects verifyShippingAddress(String shippingAddress) {
		Assert.assertTrue(assertVerifyAddress(shippingAddress), "selected shipping address is not matching");
		return this;
	}


	private boolean assertVerifyAddress(String shippingAddress) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		for(WebElement e: shippingAddressText)
		{
			if(e.getText().contains(shippingAddress))
			{
				return true;
			}
		}
		return false;
	}

}
