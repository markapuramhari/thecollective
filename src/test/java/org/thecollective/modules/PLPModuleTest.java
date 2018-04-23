package org.thecollective.modules;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.thecollective.maincontroller.PageFactoryInitializer;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
import org.thecollective.utils.SearchDataPropertyFile;

import ru.yandex.qatools.allure.annotations.Description;

public class PLPModuleTest extends PageFactoryInitializer{
	SearchDataPropertyFile data= new SearchDataPropertyFile();
	
	
	@Test()
	@Description("verifies product list page before login")
	public void verifyProductListPageSortByOptions() throws AWTException, InterruptedException, Exception
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData("jeans")
		.listPage()
		.verifyListedProducts()
		.verifySortByText()
		.verifySortByOptions(data.getSortByOptions());
		//homePage().mouseHoverOverOnMyAccount().verifyUserProfile(expAccountName, productName)
	}

}
