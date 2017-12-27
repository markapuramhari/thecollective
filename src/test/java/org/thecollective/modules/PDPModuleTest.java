package org.thecollective.modules;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class PDPModuleTest extends PageFactoryInitializer{
	
	SearchDataPropertyFile data= new SearchDataPropertyFile();
	
	@TestCaseId("TC_PDP_001")
	@Features("PDPModule")
	@Description("this test case verifies Product details page")
	@Test(groups={"PDPModule","smoke","regression"})
	public void verifyProductDetailsPageTest() throws AWTException, InterruptedException{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans");
		String productNameListPage=listPage()
		.getProductName(2);
		listPage()
		.clickOnSpecificProduct(2);
		
		String productNamePDP =	pdPage().getTheProductName();
		String brandNamePDP =	pdPage().getBrandName();
		pdPage()
		.verifyPageTitle(productNamePDP,brandNamePDP)
		.verifyProductName(productNameListPage);
		pdPage().verifyMyWishListIcon();
	}
	@TestCaseId("TC_PDP_002")
	@Features("PDPModule")
	@Description("this test case verifies my wish list functionality from PDP")
	@Test(groups={"PDPModule","smoke","regression"})
	public void verifyMyWishListFunctionality() throws AWTException, InterruptedException{
		
		try{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans");
		String 	productNameListPage=listPage()
		.getProductName(0);
		listPage()
		.clickOnSpecificProduct(0)
		.pdPage()
		.verifyMyWishListIcon()
		.clickOnMyWishListIcon()
		.loginPage()
		.verifyLoginPage(data.getLoginPageNameText());
		loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		pdPage().verifyProductName(productNameListPage);
		int previousCount=homePage().getSavedItemsCount();
		pdPage().verifyMyWishListFunctionality(previousCount);
	}
	finally
	{
		try{
		homePage().logout();
		}catch(Exception e)
		{
			
		}
	}
		
		
	}
	@TestCaseId("TC_PDP_003")
	@Features("PDPModule")
	@Description("this test case verifies my wish list functionality from PDP after login")
	@Test(groups={"PDPModule","smoke","regression"})
	public void verifyMyWishListFunctionalityAfterLogin() throws AWTException, InterruptedException{
		try
		{
		homePage()
		.clickOnLoginLink()
		.loginPage()
		.enterUserName(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton();
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans");
		String 	productNameListPage=listPage()
		.getProductName(0);
		listPage()
		.clickOnSpecificProduct(0)
		.pdPage()
		.verifyMyWishListIcon();
		pdPage().verifyProductName(productNameListPage);
		int previousCount=homePage().getSavedItemsCount();
		pdPage().verifyMyWishListFunctionality(previousCount);
		
		}
		finally
		{
			try{
			homePage().logout();
			}catch(Exception e)
			{
				
			}
		}
	}
	@TestCaseId("TC_PDP_002")
	@Features("PDPModule")
	@Description("this test case verifies my wish list functionality from PDP")
	@Test(groups={"PDPModule","smoke","regression"})
	public void verifyProductId() throws AWTException, InterruptedException{
		
		
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans");
		String 	productNameListPage=listPage()
		.getProductName(0);
		listPage();
		
		}
}
