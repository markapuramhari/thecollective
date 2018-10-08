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
		
		//aeSite().acceptCoockies();
		driver.get("https://www.ae.com/search/"+id+"?cm=sIN-cINR");
		aeSite().acceptCoockies();
		//aeSite().enterSearchData(id);
		//aeSite().acceptCoockies();
		aeSite().clickOnProduct(id);
		//aeSite().acceptCoockies();
		try{
		
		String theDeatils=aeSite().getTheDetails();
		
		String materialCare=aeSite().getMaterialsAndCare();
		String sizeAndFit=aeSite().getSizeAndFit();
		String productName=aeSite().getProductName();
		String color=aeSite().getColor();

		ExcelFileReadAndWrite write =new ExcelFileReadAndWrite();
		write.writeData(id,productName,color,theDeatils,materialCare,sizeAndFit);
		}catch(Exception e)
		{
			ExcelFileReadAndWrite write =new ExcelFileReadAndWrite();
			write.writeData(id,"No Results found","No Results found","No Results found","No Results found","No Results found");
		}
		
		
	}

}
