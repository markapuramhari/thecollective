package org.etna.modules;
import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class RegistrationModuleTest extends PageFactoryInitializer{


	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();

	@Features("Sign Up Module")
	@TestCaseId("TC_Registration_001")
	@Description("This is a test case which verifies retail customer registration tab in the user signup page.")
	@Test(alwaysRun=true,groups={"Sign Up Module","regression"})
	  public void verifyNewRetailCustomerTab() throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickNewRetailCustomerTab()
	  .retailUserRegistrationPage()
	  .verifyNewRetailCustomerTab();
	  }
	
	
	
	@Features("Sign Up Module")
	@TestCaseId("TC_Registration_002")
	@Description("This is a test case which verifies commercial customer registration tab in the user signup page.")
	@Test(enabled=true,groups={"Sign Up Module","regression"})
	  public void verifyNewCommercialCustomerTab() throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickNewCommercialCustomerTab()
	  .newCommercialCustomerPage()
	  .verifyNewCommercialCustomerTab();
	  }
	
	@Features("Sign Up Module")
	@TestCaseId("TC_Registration_004")
	@Description("This is a test case which verifies sign up page")
	@Test(enabled=false,groups={"Sign Up Module","regression"})
	  public void verifyFirstTimeOrderingTab() throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .verifyBreadCrump(data.getRegistrationBreadCrump())
	  .verifyRegistrationPageName(data.getRegistrationBreadCrump())
	  .verifyWhetherFirstTimeOrderingIsEnabledFirst()
	  .verifyWhetherNewCommercialCustomerIsEnabledFirstAndNewRetailCustomerIsNotEnabledFirst();
	  }
	
	@Features("Sign Up Module")
	@Description("This is a test case which verifies error scenarios while registering for new retail customer.")
	@Test(alwaysRun=true,groups={"Sign Up Module","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}") 
	public void verifyNewRURegistrationES(String testCaseId,@Parameter("First Name")String firstName,@Parameter("Last Name")String lastName,@Parameter("Company Name")String companyName,@Parameter("Email Address")String emailAddress,@Parameter("Password")String password,@Parameter("Confirm Password")String confirmPassword,@Parameter("Address1")String address1,@Parameter("Address2")String address2,@Parameter("City")String city,@Parameter("State")String state,@Parameter("Zip Code")String zipCode,@Parameter("Phone Number")String phoneNumber,@Parameter("Expected Error Message")String expectedErrorMsg) throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickNewRetailCustomerTab()
	  .retailUserRegistrationPage()
	  .enterFirstName(firstName)
	  .enterLastName(lastName)
	  .enterEmailId(emailAddress)
	  .enterPassword(password)
	  .enterConfirmPassword(confirmPassword)
	  .enterAddress1(address1)
	  .etnerAddress2(address2)
	  .enterCity(city)
	  .chooseState(state)
	  .enterZipCode(zipCode)
	  .enterPhoneNumber(phoneNumber)
	  .clickOnIAccept()
	  .verifyErrorMsg(expectedErrorMsg);
	  }
	
	@Features("Sign Up Module")
	@Description("This is a test case which verifies error scenarios while registering for new commercial customer.")
	@Test(groups={"Sign Up Module","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	public void verifyNewCCUserRegistrationES(String testCaseId,@Parameter("First Name")String firstName,@Parameter("Last Name")String lastName,@Parameter("Company Name")String companyName,@Parameter("Email Address")String emailAddress,@Parameter("Password")String password,@Parameter("Confirm Password")String confirmPassword,@Parameter("Address1")String address1,@Parameter("Address2")String address2,@Parameter("City")String city,@Parameter("State")String state,@Parameter("Zip Code")String zipCode,@Parameter("Phone Number")String phoneNumber,@Parameter("Expected Error Message")String expectedErrorMsg) throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickNewCommercialCustomerTab()
	  .newCommercialCustomerPage()
	  .enterFirstName(firstName)
	  .enterLastName(lastName)
	  .enterCompanyName(companyName)
	  .enterEmailId(emailAddress)
	  .enterPassword(password)
	  .enterConfirmPassword(confirmPassword)
	  .enterAddress1(address1)
	  .etnerAddress2(address2)
	  .enterCity(city)
	  .chooseState(state)
	  .enterZipCode(zipCode)
	  .enterPhoneNumber(phoneNumber)
	  .clickOnIAccept()
	  .verifyErrorMsg(expectedErrorMsg);
	  }
	
	

	
	@Features("Sign Up Module")
	@Description("This is a test case which verifies error scenarios while registering in first time ordering tab.")
	@Test(enabled=false,groups={"Sign Up Module","regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=SearchData.class)
	@TestCaseId("{0}")
	  public void verifyFirstTimeOrderingRegES(String testCaseId,@Parameter("Account Number")String accountNumber,@Parameter("First Name")String firstName,@Parameter("Last Name")String lastName,@Parameter("Email Address")String emailAddress,@Parameter("Password")String password,@Parameter("Confirm Password")String confirmPassword,@Parameter("Expected Error Message")String expectedErrorMsg) throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickFirstTimeOrderingTab()
	  .firstTimeOrderingPage()
	  .enterFirstName(firstName)
	  .enterLastName(lastName)
	  .enterEmailId(emailAddress)
	  .enterPassword(password)
	  .clickOnIAccept()
	  .verifyErrorMsg(expectedErrorMsg);
	  }
	
	@Features("Sign Up Module")
	@TestCaseId("TC_Registration_021")
	@Description("This is a test case which verifies new retail customer registration functionality in the user signup page.")
	@Test(groups={"Sign Up Module","regression"})
	  public void verifyNewRetailRegistrationCustomerFunctionality() throws Exception
	  {
	  homePage()
	  .clickOnSignUpLink()
	  .signUpPage()
	  .clickNewRetailCustomerTab()
	  .retailUserRegistrationPage()
	  .enterFirstName(data.getfirstNameForRegistration())
	  .enterLastName(data.getLastNameForRegistration())
	  .enterEmailId(data.getEmailIdForRegistration())
	  .enterPassword(data.getPasswordForRegistration())
	  .enterConfirmPassword(data.getPasswordForRegistration())
	  .enterAddress1(data.getAddress1ForRegistration())
	  .etnerAddress2(data.getAddress2ForRegistration())
	  .enterCity(data.getCityForRegistration())
	  .chooseState(data.getStateForRegistration())
	  .enterZipCode(data.getZipCodeForRegistration())
	  .enterPhoneNumber(data.getPhoneNumberForRegistration())
	  .clickOnIAccept()
	  .verifySuccessMsg(data.getRetailUserRegistrationSuccessMsg());

	  }
	
	@Features("Sign Up Module")
	@TestCaseId("TC_Registration_022")
	@Description("This is a test case which verifies new commercials customer registration functionality in the user signup page.")
	@Test(groups={"Sign Up Module","regression"})
	  public void verifyNewCommercialRegistrationCustomerFunctionality() throws Exception
	  {
		String emailIdSplit []  = data.getEmailIdForRegistration().split("@");
		String emailId = emailIdSplit[0]+RandomGenerator.generateEightRandomNumbers()+"@"+emailIdSplit[1];
	  homePage()
	  .clickOnSignUpLink()
	  .newCommercialCustomerPage()
	  .enterFirstName(data.getfirstNameForRegistration())
	  .enterLastName(data.getLastNameForRegistration())
	  .enterCompanyName(data.getCompanyNameForRegistration())
	  .enterEmailIdForPositiveFlow(emailId)
	  .enterPassword(data.getPasswordForRegistration())
	  .enterConfirmPassword(data.getPasswordForRegistration())
	  .enterAddress1(data.getAddress1ForRegistration())
	  .etnerAddress2(data.getAddress2ForRegistration())
	  .enterCity(data.getCityForRegistration())
	  .chooseState(data.getStateForRegistration())
	  .enterZipCode(data.getZipCodeForRegistration())
	  .enterPhoneNumber(data.getPhoneNumberForRegistration())
	  .clickOnIAccept()
	  .verifySuccessMsg(emailId,data.getCommercialUserRegistrationSuccessMsg());
	  }
}
