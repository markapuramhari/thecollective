package org.etna.customer.pageobjects.orderconfirmation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class OrderConfirmationPageObjects  extends PageFactoryInitializer{

	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li[contains(text(),'Order Confirmation')]")
	private WebElement orderConfirmationBreadcrumbLocator;
	
	@FindBy(xpath="//h2[contains(text(),'Order Confirmation')]")
	private WebElement orderConfirmationPageNameLocator;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_orderInfo']/descendant::b")})
	private List<WebElement> orderInfoLocator;
	
	@FindBy(xpath="//div[@class='orderStatus']/h3")
	private WebElement orderConfirmationThankYouMessage;
	
	@FindBy(xpath="//b[contains(text(),'PO Number')]/following-sibling::span")
	private WebElement poValueLocator;
	
	@FindBy(xpath="//b[contains(text(),'Ordered Date')]/following-sibling::span")
	private WebElement orderedDateLocator;
	

	@FindBy(xpath="//b[contains(text(),'Ordered By')]/following-sibling::span")
	private WebElement orderedByLocator;
	
	@FindBy(xpath="//b[contains(text(),'Ship Via')]/following-sibling::span")
	private WebElement shipViaLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Billing Address')]/ancestor::div/p")
	private WebElement billingAddressLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Shipping Address')]/ancestor::div/p")
	private WebElement shippingAddressLocator;
	
	@FindBy(xpath="//p[@class='orderConfTitle']/strong")
	private WebElement productNameLocator;
	
	@Step("verify order confirmation page.")
	public OrderConfirmationPageObjects verifyOrderConfirmationPage(String productName,String[] orderInfoLabels, String purchaseOrder,String orderedBy,String shipVia) {
		Waiting.explicitWaitVisibilityOfElement(orderConfirmationBreadcrumbLocator, 10);
		Assert.assertTrue(orderConfirmationBreadcrumbLocator.isDisplayed(),"Order confirmation breadcrump is not displayed.");
		Assert.assertTrue(orderConfirmationPageNameLocator.isDisplayed(),"Order confirmation page name is not displayed.");
		Assert.assertTrue(orderConfirmationThankYouMessage.getText().replace("\n", "").trim().equalsIgnoreCase("YOUR ORDER HAS BEEN RECEIVEDTHANK YOU!"),"Thank you message is not right in order confirmation page. Getting "+orderConfirmationThankYouMessage.getText().replace("\n", "").trim());
		
		for(int i = 0 ; i < orderInfoLocator.size(); i++)
		{
			Assert.assertEquals(orderInfoLocator.get(i).getText().replace(":", "").trim(), orderInfoLabels[i],"Expecting order info labels to be "+orderInfoLabels[i]+" but found "+orderInfoLocator.get(i).getText().replace(":", "").trim());
			
		}
		
		Assert.assertEquals(poValueLocator.getText().trim(), purchaseOrder);
		Assert.assertEquals(orderedDateLocator.getText().trim(),getDate());
		Assert.assertEquals(orderedByLocator.getText().trim(), orderedBy);
		System.out.println(shipViaLocator.getText().toLowerCase().trim());
		System.out.println(shipVia.toLowerCase());
		Assert.assertTrue(shipVia.toLowerCase().trim().contains(shipViaLocator.getText().toLowerCase().trim()),"Expected : "+shipVia.toLowerCase()+" but found "+shipViaLocator.getText().toLowerCase().trim());
		Assert.assertTrue(billingAddressLocator.isDisplayed(), "Billing address section is not displayed.");
		Assert.assertTrue(shippingAddressLocator.isDisplayed(), "Shipping address section is not displayed.");
		Assert.assertEquals(productNameLocator.getText().trim(), productName);
		return this;
	}
	
	 //to get date if needed
    public static String getDate()
    {
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	Date date = new Date();
    	String DateForReport = dateFormat.format(date);
    	return DateForReport;
    }
    
}
