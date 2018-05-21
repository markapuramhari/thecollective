package org.thecollective.modules;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.thecollective.dataprovider.DataDrivenTestingFromExcel;
import org.thecollective.maincontroller.PageFactoryInitializer;

public class AeContent extends PageFactoryInitializer{
	
	@Test(dataProvider="aeContent",dataProviderClass=DataDrivenTestingFromExcel.class)
	public void aeWriteContent(String id) throws AWTException, InterruptedException
	{	
		aeSite().acceptCoockies();
		aeSite().enterSearchData(id);
		aeSite().acceptCoockies();
		aeSite().clickOnProduct(id);
		aeSite().acceptCoockies();
		String theDeatils=aeSite().getTheDetails();
		String materialCare=aeSite().getMaterialsAndCare();
		String sizeAndFit=aeSite().getSizeAndFit();
		
		
		
		
		
		ExcelFileReadAndWrite write =new ExcelFileReadAndWrite();
		write.writeData(id,theDeatils,materialCare,sizeAndFit);
		
	}

}
