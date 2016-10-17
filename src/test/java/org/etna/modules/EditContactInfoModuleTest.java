package org.etna.modules;
import org.etna.dataprovider.DataDrivenTestingFromExcel;
import org.etna.utils.PermittedCharacters;
import org.testng.annotations.Test;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.RandomGenerator;
import org.etna.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class EditContactInfoModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest login = new LoginModuleTest();
	

	@Features("Edit Contact Info Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_ECI_001,TC_ECI_014")
	@Description("Verification of fields in Edit Contact Page,Verify the breadcrumbs' of Edit contact info")
		public void verifyEditContactInfoPage() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnEditContactLinkInUserAccountDropdown()
		  .editContactInfoPage()
		  .verifyEditContactInfoPageTitle(data.getEditContactInfoTitle().trim()+" | "+setUp.getProductName().toUpperCase())
		  .verifyEditContactInfoPageName(data.getEditContactInfoTitle().trim())
		  .verifyDisplayOfMyAccountLinkInBreadCrumb(data.getMyAccountBreadcrumb())
		  .verifyEditContactInfoBreadcrumb(data.getEditContactInfoTitle().trim())
		  .verifyDisplayOfEntityAddressCheckbox()
		  .verifyDisplayOfUpdateButton();
		}
	
	@Features("Edit Contact Info Module")
	@Test(groups={"regression"})
	@TestCaseId("{0}")
	@Description("Verification of Edit Contact functionality")
		public void verifyEditContactFunctionality() throws Exception
		{
		String phoneNumber = RandomGenerator.random(10, PermittedCharacters.NUMERIC);
		login.loginAsASuperUser();
		homePage().logout();
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnEditContactLinkInUserAccountDropdown()
		  .editContactInfoPage()
		  .enterPhoneNumber(phoneNumber)
		  .clickOnUpdateButton()
		  .verifySuccessMessage(data.getExpectedContactInfoUpdateSuccessMessage())
		  .homePage().clickOnUserAccountDropdown().clickOnEditContactLinkInUserAccountDropdown()
		  .verifyUpdationOfPhoneNumber(phoneNumber);
		}
	
	@Features("Edit Contact Info Module")
	@Test(groups={"regression"},dataProvider="mutipleSheetsSingleWorkbook",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("{0}")
	@Description("{1}")
		public void editContact_ES(String testCaseId,String description,String firstName,String lastName,String address1,String address2,String city,String state,String zipCode,String phoneNumber,String expectedErrorMessage) throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .clickOnUserAccountDropdown()
		  .clickOnEditContactLinkInUserAccountDropdown()
		  .editContactInfoPage()
		  .enterFirstName(firstName)
		  .enterLastName(lastName)
		  .enterPhoneNumber(phoneNumber)
		  .enterAddress1(address1)
		  .enterCity(city)
		  .selectState(state)
		  .enterZipCode(zipCode)
		  .editContactInfoPage()
		  .clickOnUpdateButton()
		  .verifyErrorMessage(expectedErrorMessage);
		  }
	
	
	@Features("Edit Contact Info Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_ECI_11")
	@Description("Verify whether user is able to search for the country through the search field present in the Country field drop down.")
		public void countryFieldSearch() throws Exception
		{
		 login.loginAsASuperUser();
		 homePage()
		 .clickOnUserAccountDropdown()
		 .clickOnEditContactLinkInUserAccountDropdown()
		 .clickOnCountry()
		 .enterCountry(data.getCountry())
		 .verifyCountryIsDisplayedInTheCountryDropdown(data.getCountry());
		 }
	
	@Features("Edit Contact Info Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_ECI_12")
	@Description("Verify whether user is able to search for the 'State' through the search field present in the ' State Field' dropdown.")
		public void stateFieldSearch() throws Exception
		{
		 login.loginAsASuperUser();
		 homePage()
		 .clickOnUserAccountDropdown()
		 .clickOnEditContactLinkInUserAccountDropdown()
		 .clickOnState()
		 .enterState(data.getState())
		 .verifyStateIsDisplayedInTheCountryDropdown(data.getState());
		 }
	
	@Features("Edit Contact Info Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_ECI_13")
	@Description("Verify if 'Entity Address Checkbox is unchecked then user has to fill address1, City, state, country and zip code & Phone number")
		public void useEntityAddress() throws Exception
		{
		 login.loginAsASuperUser();
		 homePage()
		 .clickOnUserAccountDropdown()
		 .clickOnEditContactLinkInUserAccountDropdown()
		 .clickOnUseEntityAddress()
		 .verifyWhetherUseEntityAddressIsNotSelected()
		 .verifyWhetherAddress1CityStatePhoneNumberIsEmpty()
		 .clickOnUseEntityAddress()
		 .verifyWhetherAddress1CityStatePhoneNumberIsNotEmpty();
		 }
}
