package org.thecollective.modules;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;

public class NewBatchFeedChecks extends PageFactoryInitializer{
	
	
	@Test(dataProvider="feedFromExcel",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void checkNewBatchFeedInFO(String tc,String searchKeyword, String ProductMRP, String sizes) throws AWTException, InterruptedException
	{
		homePage()
		.clickOnSearchIcon()
		.enterSearchData(searchKeyword)
		.listPage()
		.verifyProduct(ProductMRP);
		
		
		
	}
	@Test
	public void testAllTheProducts(){
		
	}

}
