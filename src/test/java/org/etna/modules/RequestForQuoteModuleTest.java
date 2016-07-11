package org.etna.modules;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Issues;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

public class RequestForQuoteModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	int expectedNumberOfTextboxesToDisplay = data.getNumberOfTextboxesToDisplayForMPNQtyShortDescriptionBrOrManfrNameEach();
	
	@Test(groups={"smoke","regression"})
	@Features("Request For Quote Module")
	@TestCaseId("TC_RFQ_001,TC_RFQ_008,TC_RFQ_024,TC_RFQ_025,TC_RFQ_026")
	public void verifyRequestForQuotePage() throws Exception
	{
		
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.verifyRequestForQuoteBreadCrumb()
		.verifyRequestForQuotePageName()
		.verifyRequestForQuotePage(setUp.getProductName(),expectedNumberOfTextboxesToDisplay);
	}
	
	@Test(groups={"smoke","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	@Features("Request For Quote Module")
	@TestCaseId("{0}")
	@Description("{1}")
	public void requestForQuotePage_PositiveFlow(String testCaseId,String description,String manufacturerPartNumber,String brandOrManufacturerName,String quantity,String shortDescription,String comments) throws Exception
	{
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.enterManufacturerPartNumber(manufacturerPartNumber)
		.enterBrandOrManufacturerName(brandOrManufacturerName)
		.enterQuantity(quantity)
		.enterShortDescription(shortDescription)
		.enterComments(comments)
		.clickOnSubmit()
		.verifyRequestForQuoteSuccessMessage()
		.verifyRequestForQuoteBreadCrumb()
		.verifyRequestForQuotePageName();
		//verify clearing of all the fields
	}
	
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	@Features("Request For Quote Module")
	@TestCaseId("{0}")
	@Description("{1}")
	public void requestForQuotePage_FirstName_LastName_PhoneNumber_Email_errorScenarios(String testCaseId,String description,String firstName,String lastName,String phoneNumber,String emailId,String manufacturerPartNumber, String expectedErrorMsg) throws Exception
	{
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPhoneNumber(phoneNumber)
		.enterEmailId(emailId)
		.enterManufacturerPartNumber(manufacturerPartNumber)
		.clickOnSubmit()
		.verifyErrorMessage(expectedErrorMsg);
	}
	
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	@Features("Request For Quote Module")
	@TestCaseId("{0}")
	@Description("{1}")
	public void requestForQuotePage_quantityField_errorScenarios(String testCaseId,String description,String actualQuantity,String expectedQuantity) throws Exception
	{
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.enterQuantity(actualQuantity)
		.verifyQuantityTextbox(expectedQuantity);
	}
	
	@Test(groups={"regression"})
	@Features("Request For Quote Module")
	@TestCaseId("TC_RFQ_015,TC_RFQ_016")
	public void requestForQuotePage_verifyRequiredByDateFormatMMDDYYYY() throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
    	Date date = new Date();
    	String dateForRequiredByDate = dateFormat.format(date);
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.verifyRequiredByDateFormat(dateForRequiredByDate);
	}
	
	@Test(groups={"regression"})
	@Features("Request For Quote Module")
	@TestCaseId("TC_RFQ_017")
	public void requestForQuotePage_verifyEditingRequiredByDate() throws Exception
	{
		DateFormat dateFormatDay = new SimpleDateFormat("dd");
    	Date date = new Date();
    	String day = dateFormatDay.format(date);
    	
    	
    	DateFormat dateFormatMonth = new SimpleDateFormat("MM");
    	Date dateMonth = new Date();
    	String month = dateFormatMonth.format(dateMonth);
    	
    	
    	DateFormat dateFormatYear = new SimpleDateFormat("YYYY");
    	Date dateYear = new Date();
    	String year = dateFormatYear.format(dateYear);
   
    	int nextDay = Integer.parseInt(day)+1;
    	loginModule.loginAsASuperUser();
    	homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.clickOnRequiredByDate()
		.clickOnSpecificDateInRequiredDate(nextDay)
		.verifyRequiredByDateFormat(month+"/"+Integer.toString(nextDay)+"/"+year);
	}
	
	@Test(groups={"regression"})
	@Features("Request For Quote Module")
	@TestCaseId("TC_RFQ_018")
	public void requestForQuotePage_verifyDisablingOfRequiredByDate() throws Exception
	{
		DateFormat dateFormatDay = new SimpleDateFormat("dd");
    	Date date = new Date();
    	String day = dateFormatDay.format(date);
  
   
    	int previousDay = Integer.parseInt(day)-1;
    	loginModule.loginAsASuperUser();
    	
    	homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.clickOnRequiredByDate()
		.verifyClickingOnPreviousDate(previousDay);
	}
	
	@Test(groups={"regression"})
	@Features("Request For Quote Module")
	@TestCaseId("TC_RFQ_014")
	@Description("Verification add row and remove row Request for quote page.")
	public void requestForQuotePage_addRow_RemoveRow() throws Exception
	{
		
		verifyRequestForQuotePage();
		requestForQuotePage()
		.clickOnAddRowButton();
		Thread.sleep(1000);
		requestForQuotePage()
		.verifyNumberOfTextboxesDisplayed(expectedNumberOfTextboxesToDisplay+1)
		.clickOnRemoveRowButton();
		Thread.sleep(1000);
		requestForQuotePage()
		.verifyNumberOfTextboxesDisplayed(expectedNumberOfTextboxesToDisplay);
	}
	
	@Test(groups={"regression"})
	@TestCaseId("TC_RFQ_027")
	@Description("Verification of Tab Order whether it from right to left")
	@Features("Request For Quote Module")
	public void requestForQuotePage_tabOrder() throws Exception
	{
		verifyRequestForQuotePage();
		requestForQuotePage()
		.verifyTabFocusOrderIsFromLeftToRight();
	}
	

	@Test(groups={"regression"})
	@TestCaseId("TC_RFQ_002,TC_RFQ_003,TC_RFQ_004")
	@Description("Verification of auto population of first name, last name, phone number, email textboxes in Request For Quote page")
	@Features("Request For Quote Module")
	public void verifyFirstNameLastNamePhoneNumberEmailIsAutoPopulated() throws Exception
	{
		loginModule.loginAsASuperUser();
		String contactDetails[] = homePage()
				.clickOnUserAccountDropdown()
				.clickOnEditContactLink()
				.getContactDetails();
		
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnRequestForQuote()
		.verifyWhetherFirstNameLastNameEmailPhoneNumberTextboxesAreAutopopulated(contactDetails);
	}
	
}

