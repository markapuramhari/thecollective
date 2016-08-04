package org.etna.customer.pageobjects.checkout;
import java.util.List;

import org.etna.customer.pageobjects.orderconfirmation.OrderConfirmationPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class CheckoutPageObjects extends PageFactoryInitializer{

	@FindBy(xpath="//li[contains(.,'Checkout')]")
	private WebElement checkoutBreadCrumpLocator;
	
	@FindBy(xpath="//h2[contains(.,'Checkout')]")
	private WebElement checkoutPageNameLocator;
	
	@FindBy(xpath="//a[@class='buttonNext']")
	private WebElement nextButtonLocator;
	
	@FindBy(id="shipEmail")
	private WebElement emailIdForShippingAddressLocator;
	
	@FindBy(xpath="//div[@id='orderType_chosen']/preceding-sibling::select")
	private WebElement orderTypeLocator;
	
	@FindBy(id="orderedBy")
	private WebElement orderedByLocator;
	
	@FindBy(id="poNumberTxt")
	private WebElement purchaseOrderNumberLocator;
	
	@FindBy(xpath="//div[@id='shipVia_chosen']/a")
	private WebElement shipViaLocator;
	
	@FindBy(id="shippingInstruction")
	private WebElement shippingInstructionsLocator;
	
	@FindBy(id="orderNotes")
	private WebElement orderNotesLocator;
	
	@FindBy(xpath="//div[contains(@class,'cimm_tableDescSection')]/descendant::a")
	private WebElement productNameLocator;
	
	@FindBy(xpath="//a[@class='buttonFinish']")
	private WebElement submitOrderButtonLocator;
	
	@FindBy(id="errorMsg")
	private WebElement errorMessageLocator;
	
	@FindBy(id="billPhoneNo")
	private WebElement phoneNumberLocator;
	
	@FindBy(id="shipPhoneNo")
	private WebElement shipPhoneNumberLocator;
	
	
	@Step("verify checkout page")
	public CheckoutPageObjects verifyCheckoutPage(){
		Waiting.explicitWaitVisibilityOfElement(checkoutBreadCrumpLocator, 20);
		Assert.assertTrue(checkoutBreadCrumpLocator.isDisplayed(),"checkout page breadcrump is not displayed");
		Assert.assertTrue(checkoutPageNameLocator.isDisplayed(),"checkout page name is not displayed");
		return this;
	}

	@Step("click on next")
	public CheckoutPageObjects clickOnNextButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(nextButtonLocator, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",nextButtonLocator);
		return this;
	}


	@Step("enter email id {0}")
	public CheckoutPageObjects enterEmailId(String userName) throws Exception{
		Thread.sleep(1500);
		emailIdForShippingAddressLocator.sendKeys(userName);
		return this;
	}

	@Step("select order type {0}")
	public CheckoutPageObjects selectOrderType(String orderType) throws Exception {
		Thread.sleep(800);
		driver.findElement(By.xpath("//div[@id='orderType_chosen']/a")).click();
		Thread.sleep(500);
		List <WebElement> orderTypeOptions = driver.findElements(By.xpath("//ul[@class='chosen-results']/li"));
		
		switch(orderType)
		{
		case "Credit card Payment": driver.findElement(By.xpath("//div[@id='orderType_chosen']/descendant::li[contains(text(),'Credit card Payment')]")).click();
			break;
		case "Purchase Order": driver.findElement(By.xpath("//div[@id='orderType_chosen']/descendant::li[contains(text(),'Purchase Order')]")).click();
			break;		
	}
		
		for(WebElement orderTypeOption : orderTypeOptions)
		{
			if(orderTypeOption.getText().trim().equals(orderType.trim()))
			{
				orderTypeOption.click();
				break;
			}
		}
		return this;
		
	}

	@Step("enter ordered by {0}")
	public CheckoutPageObjects enterOrderedBy(String companyNameForRegistration) {
		orderedByLocator.sendKeys(companyNameForRegistration);
		return this;
		
	}

	@Step("enter purchase order number {0}")
	public CheckoutPageObjects enterPurchaseOrderNumber(String purchaseOrder) {
		purchaseOrderNumberLocator.sendKeys(purchaseOrder);
		return this;
	}

	@Step("select ship via {0}")
	public CheckoutPageObjects selectShipMethod(String shipVia) throws Exception {
		shipViaLocator.click();
		Thread.sleep(2000);
		switch(shipVia)
		{
		case "OT OUR TRUCK": driver.findElement(By.xpath("//div[@id='shipVia_chosen']/descendant::li[text()='OT OUR TRUCK']")).click();
			break;
		case "PICK UP": driver.findElement(By.xpath("//div[@id='shipVia_chosen']/descendant::li[text()='PICK UP']")).click();
			break;
		case "UPS 1 DAY": driver.findElement(By.xpath("//div[@id='shipVia_chosen']/descendant::li[text()='UPS 1 DAY']")).click();
			break;
		case "UPS Ground": driver.findElement(By.xpath("//div[@id='shipVia_chosen']/descendant::li[text()='UPS Ground']")).click();
			break;
		default : throw new Exception("invalid shipping method");			
	}
		return this;
	}

	@Step("enter shipping instructions {0}")
	public CheckoutPageObjects enterShippingInstructions(String shippingInstructions) {
		shippingInstructionsLocator.sendKeys(shippingInstructions);
		return this;
	}

	@Step("enter order notes {0}")
	public CheckoutPageObjects enterOrderNotes(String orderNote) {
		orderNotesLocator.sendKeys(orderNote);
		return this;
	}

	@Step("verify whether name of the product in item details tab is {0}")
	public CheckoutPageObjects verifyNameOfTheProductInItemDetailsTab(String productName) {
		Waiting.explicitWaitVisibilityOfElement(productNameLocator, 15);
		Assert.assertEquals(productNameLocator.getText().trim(), productName);
		return this;	
	}

	@Step("click on submit order button")
	public OrderConfirmationPageObjects clickOnSubmitOrderButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",submitOrderButtonLocator);
		return orderConfirmationPage();
	}

	@Step("verify email address required error message is Please Enter Email Address.")
	public CheckoutPageObjects verifyEmailAddressRequiredErrorMessage() {
		Assert.assertEquals(errorMessageLocator.getText().trim(),"Please Enter Email Address.");
		return this;
	}

	@Step("verify email address required error message is {0}")
	public CheckoutPageObjects verifyErrorMessage(String errorMessage) {
		Assert.assertEquals(errorMessageLocator.getText().replace("\n", "").trim(),errorMessage);
		return this;
	}

	public CheckoutPageObjects enterPhoneNumber(String phoneNumber) {
		Waiting.explicitWaitVisibilityOfElement(phoneNumberLocator, 10);
		phoneNumberLocator.clear();
		phoneNumberLocator.sendKeys(phoneNumber);
		return this;
	}

	public CheckoutPageObjects enterShippingPhoneNumber(String phoneNumber) {
		Waiting.explicitWaitVisibilityOfElement(shipPhoneNumberLocator, 3);
		shipPhoneNumberLocator.clear();
		shipPhoneNumberLocator.sendKeys(phoneNumber);
		return this;
	}

}
