package org.thecollective.modules;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SignupModuleTest extends PageFactoryInitializer
{
	SearchDataPropertyFile data= new SearchDataPropertyFile();
	
@TestCaseId("TC_SIGNUP_001")
@Description("verification of signup link in landing page")
@Test(groups={"Smoke", "Regression","Signup"})
public void VerifySignUpLandingPage()
{
	homePage()
	.mouseHoverOverUserProfileBeforeLogin()
	.verifySignupLink();
	
}
@TestCaseId("TC_SIGNUP_002")
@Description("verification of signup link in product list page")
@Test(groups={"Smoke", "Regression","Signup"})
public void VerifySignUpListPage() throws AWTException, InterruptedException
{
	homePage()
	.clickOnSearchIcon()
	.enterSearchData("shirt");
	homePage()
	.mouseHoverOverUserProfileBeforeLogin()
	.verifySignupLink();
	
}
@TestCaseId("TC_SIGNUP_003")
@Description("verification of signup link in product details page")
@Test(groups={"Smoke", "Regression","Signup"})
public void VerifySignUpPDPage() throws AWTException, InterruptedException
{
	homePage()
	.clickOnSearchIcon()
	.enterSearchData("shirt")
	.listPage()
	.clickOnSpecificProduct(0);
	homePage()
	.mouseHoverOverUserProfileBeforeLogin()
	.verifySignupLink();
	
}
@TestCaseId("TC_SIGNUP_004")
@Description("verification of signup link functionality")
@Test(groups={"Smoke", "Regression","Signup"})
public void VerifySignUpFunctionlity() throws InterruptedException
{
	homePage()
	.mouseHoverOverUserProfileBeforeLogin()
	.verifySignupLink()
	.clickOnSignupLink()
	.verifySignupPageTitle(data.getSignupPageTitle())
	.verifySignUpPageName(data.getSignUpPageName());
	
}

@Description("verification of signup link functionality")
@Test(groups={"Smoke", "Regression","Signup"},dataProvider="SignUpNeg",dataProviderClass=DataDrivenTestingFromExcel.class)
public void VerifySignUpFuncNeg() throws InterruptedException
{
	homePage()
	.mouseHoverOverUserProfileBeforeLogin()
	.verifySignupLink()
	.clickOnSignupLink()
	.verifySignupPageTitle(data.getSignupPageTitle())
	.verifySignUpPageName(data.getSignUpPageName());
	
}
}
