package org.etna.customer.pageobjects.requestforquote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class RequestForQuotePageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::li[contains(text(),'Request for Quote')]")
	private WebElement requestForQuoteBreadcrumbLocator;
	
	@FindBy(xpath="//h2")
	private WebElement requestForQuotePageNameLocator;

	@FindBy(id="rfnpName")
	private WebElement requestForQuoteFirstNameLocator;
	

	@FindBy(id="rfnpName2")
	private WebElement requestForQuoteLastNameLocator;
	

	@FindBy(id="rfnpPhone")
	private WebElement requestForQuotePhoneNumberLocator;
	

	@FindBy(id="rfnpEmail")
	private WebElement requestForQuoteEmailIdLocator;
	
	
	@FindBy(id="submitBtn")
	private WebElement requestForQuoteSubmitButtonLocator;
	
	@FindBy(id="comments")
	private WebElement commentsSectionLocator;
	
	@FindBy(id="reqDate")
	private WebElement requiredDateLocator;
	
	@FindAll(value={@FindBy(name="PARTNUMARR")})
	private List<WebElement> mpnTextboxLocator;
	
	@FindAll(value={@FindBy(name="BRANDNAMEARR")})
	private List<WebElement> brandOrMFRNameTextboxLocator;
	
	@FindAll(value={@FindBy(name="ITEMQTYARR")})
	private List<WebElement> itemQuantityTextboxLocator;
	
	@FindAll(value={@FindBy(name="DESCARR")})
	private List<WebElement> shortDescriptionTextboxLocator;
	
	@FindBy(xpath="//button[@value='Add Row']")
	private WebElement addRowButtonLocator;
	
	@FindBy(id="popup_message")
	private WebElement popUpMessageLocator;
	
	@FindBy(id="popup_ok")
	private WebElement okButtonLocator;
	
	@FindBy(id="errorMsg")
	private WebElement errorMsgLocator;
	
	@FindBy(id="removeRowBtn")
	private WebElement removeRowButtonLocator;
	
	@Step("verify request for quote breadcrumb")
	public RequestForQuotePageObjects verifyRequestForQuoteBreadCrumb() {
		Assert.assertTrue(requestForQuoteBreadcrumbLocator.isDisplayed(),"Request for quote breadcrumb is inavlid.");
		return this;
	}

	@Step("verify request for quote page name")
	public RequestForQuotePageObjects verifyRequestForQuotePageName() {
		Assert.assertTrue(requestForQuotePageNameLocator.getText().trim().equalsIgnoreCase("Request For Quote"),"Request for quote page name is inavlid");
		return this;
	}

	@Step("verify request for quote page completely.")
	public RequestForQuotePageObjects verifyRequestForQuotePage(String productName,int expectedNumberOfTextboxes) {
		Assert.assertTrue(requestForQuoteFirstNameLocator.isDisplayed(),"Request for quote first name textbox is not displayed.");
		Assert.assertTrue(requestForQuoteLastNameLocator.isDisplayed(),"Request for quote last name textbox is not displayed.");
		Assert.assertTrue(requestForQuotePhoneNumberLocator.isDisplayed(),"Request for quote phone number textbox is not displayed.");
		Assert.assertTrue(requestForQuoteEmailIdLocator.isDisplayed(),"Request for quote email id textbox is not displayed.");
		Assert.assertTrue(requestForQuoteSubmitButtonLocator.isDisplayed(),"Request for quote submit button is not displayed.");
		verifyNumberOfTextboxesDisplayed(expectedNumberOfTextboxes);
		Assert.assertTrue(addRowButtonLocator.isDisplayed(),"Add row button is not displayed.");
		Assert.assertEquals(driver.getTitle().trim(),"Request For Quote | "+productName);
		return this;
	}
	
	public RequestForQuotePageObjects verifyNumberOfTextboxesDisplayed(int expectedNumberOfTextboxes)
	{
		Assert.assertEquals(mpnTextboxLocator.size(),expectedNumberOfTextboxes,"Number of mpn textboxes is not 3");
		Assert.assertEquals(brandOrMFRNameTextboxLocator.size(),expectedNumberOfTextboxes,"Number of brand textboxes is not 3");
		Assert.assertEquals(itemQuantityTextboxLocator.size(),expectedNumberOfTextboxes,"Number of quantity textboxes is not 3");
		Assert.assertEquals(shortDescriptionTextboxLocator.size(),expectedNumberOfTextboxes,"Number of short description textboxes is not 3");
		return this;
	}

	@Step("enter MPN as '{0}'")
	public RequestForQuotePageObjects enterManufacturerPartNumber(String manufacturerPartNumber) {
		if(manufacturerPartNumber.equals(null))
		{
			
		}
		else
		{
		mpnTextboxLocator.get(0).sendKeys(manufacturerPartNumber);
	}
		return this;
}
	
	@Step("enter brand or mpn with '{0}'")
	public RequestForQuotePageObjects enterBrandOrManufacturerName(String brandOrManufacturerName) {
		if(brandOrManufacturerName.equals(null))
		{
			
		}
		else
		{
		brandOrMFRNameTextboxLocator.get(0).sendKeys(brandOrManufacturerName);
		}
		return this;
	}

	@Step("enter quantity as '{0}'")
	public RequestForQuotePageObjects enterQuantity(String quantity) {
		if(quantity.equals(null))
		{
			
		}
		else
		{
		itemQuantityTextboxLocator.get(0).sendKeys(quantity);
		}
		return this;
	}

	@Step("enter short description as '{0}'")
	public RequestForQuotePageObjects enterShortDescription(String shortDescription) {
		if(shortDescription.equals(null))
		{
			
		}
		else
		{
		shortDescriptionTextboxLocator.get(0).sendKeys(shortDescription);
		}
		return this;
	}

	@Step("enter comments as '{0}'")
	public RequestForQuotePageObjects enterComments(String comments) {
		if(comments.equals(null))
		{
			
		}
		else
		{
		commentsSectionLocator.sendKeys(comments);
		}
		return this;
	}

	@Step("click on submit request for quote button.")
	public RequestForQuotePageObjects clickOnSubmit() {
		requestForQuoteSubmitButtonLocator.click();
		return this;
	}


	public boolean assertRequestForQuoteSuccessMessage(){
		boolean t = popUpMessageLocator.getText().trim().equals("RFQ Submitted Successfully");
		okButtonLocator.click();
		return t;
		
	}
	
	@Step("verify request for quote success message.")
	public RequestForQuotePageObjects verifyRequestForQuoteSuccessMessage() {
		Waiting.explicitWaitVisibilityOfElement(popUpMessageLocator, 10);
		Assert.assertTrue(assertRequestForQuoteSuccessMessage(),"Request for quote success message is not displayed/Is not successful.");
		return this;
	}

	@Step("enter first name as {0}")
	public RequestForQuotePageObjects enterFirstName(String firstName) {
		requestForQuoteFirstNameLocator.clear();
		requestForQuoteFirstNameLocator.sendKeys(firstName);
		return this;
	}

	@Step("enter last name as {0}")
	public RequestForQuotePageObjects enterLastName(String lastName) {
		requestForQuoteLastNameLocator.clear();
		requestForQuoteLastNameLocator.sendKeys(lastName);
		return this;
	}

	@Step("enter phone number as {0}")
	public RequestForQuotePageObjects enterPhoneNumber(String phoneNumber) {
		requestForQuotePhoneNumberLocator.clear();
		requestForQuotePhoneNumberLocator.sendKeys(phoneNumber);
		return this;
	}

	@Step("enter email id as {0}")
	public RequestForQuotePageObjects enterEmailId(String emailId) {
		requestForQuoteEmailIdLocator.clear();
		requestForQuoteEmailIdLocator.sendKeys(emailId);
		return this;
	}

	@Step("verify pop up message has {0}")
	public RequestForQuotePageObjects verifyErrorMessage(String expectedErrorMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgLocator, 10);
		Assert.assertEquals(errorMsgLocator.getText().replace("\n", "").trim(), expectedErrorMsg);
		return this;
	}

	@Step("verify quantity textbox has {0}")
	public RequestForQuotePageObjects verifyQuantityTextbox(String expectedQuantity) {
		Assert.assertEquals(itemQuantityTextboxLocator.get(0).getAttribute("value"), expectedQuantity);
		return this;
	}

	@Step("enter required by date has {0}")
	public RequestForQuotePageObjects verifyRequiredByDateFormat(String expectedDate) {
		Waiting.explicitWaitVisibilityOfElement(requiredDateLocator, 10);
		Assert.assertEquals(requiredDateLocator.getAttribute("value").trim(), expectedDate,"Required by date is not in MMDDYYY format.");
	   return this;
	}

	@Step("click on required by date button")
	public RequestForQuotePageObjects clickOnRequiredByDate() {
		requiredDateLocator.click();
		return this;	
	}

	@Step("click on {0} day in the required by date calender")
	public RequestForQuotePageObjects clickOnSpecificDateInRequiredDate(int day) throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[contains(text(),'"+day+"')]")).click();;
		return this;
	}


	public boolean assertClickingOnPreviousDate(int previousDay) throws InterruptedException {
			
			try
			{
				clickOnSpecificDateInRequiredDate(previousDay);
			
				
			}
			catch(NoSuchElementException e)
			{
				return true;
			}
			return false;
			
	}

	@Step("verify after clicking on previous date, date clicked is {0}")
	public RequestForQuotePageObjects verifyClickingOnPreviousDate(int previousDay) throws InterruptedException {
		Assert.assertTrue(assertClickingOnPreviousDate(previousDay),"Able to click previous date in required by date.");
		
		return this;
	}

	@Step("click on add row button")
	public RequestForQuotePageObjects clickOnAddRowButton() {
		addRowButtonLocator.click();
		return this;
		
	}

	@Step("click on remove row button")
	public RequestForQuotePageObjects clickOnRemoveRowButton() {
		removeRowButtonLocator.click();
		return this;	
	}

	@Step("verify tab focus")
	public RequestForQuotePageObjects verifyTabFocusOrderIsFromLeftToRight() throws Exception{
		mpnTextboxLocator.get(0).click();
		
		for(int i = 0 ; i < mpnTextboxLocator.size() ; i++)
		{
		Thread.sleep(500);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),"MPN"+Integer.toString(i));
		
		mpnTextboxLocator.get(i).sendKeys(Keys.TAB);
		Thread.sleep(500);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),"BN"+Integer.toString(i));
		
		
		brandOrMFRNameTextboxLocator.get(i).sendKeys(Keys.TAB);
		Thread.sleep(500);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),"QTY"+Integer.toString(i));
		
		itemQuantityTextboxLocator.get(i).sendKeys(Keys.TAB);
		Thread.sleep(500);
		Assert.assertEquals(driver.switchTo().activeElement().getAttribute("id"),"DESC"+Integer.toString(i));
	
		shortDescriptionTextboxLocator.get(i).sendKeys(Keys.TAB);
		
		}
		return this;
	}


	@Step("verify whether the contact details textboxes are auto populated")
	public RequestForQuotePageObjects verifyWhetherFirstNameLastNameEmailPhoneNumberTextboxesAreAutopopulated(String[] contactDetails) {
		Assert.assertEquals(requestForQuoteFirstNameLocator.getAttribute("value").trim(),contactDetails[0]);
		Assert.assertEquals(requestForQuoteLastNameLocator.getAttribute("value").trim(),contactDetails[1]);
		Assert.assertEquals(requestForQuotePhoneNumberLocator.getAttribute("value").trim(),contactDetails[2]);
		Assert.assertEquals(requestForQuoteEmailIdLocator.getAttribute("value").trim(),contactDetails[3]);
	return this;	
	}
}
