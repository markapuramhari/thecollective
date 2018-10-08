package org.thecollective.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.thecollective.utils.ApplicationSetUpPropertyFile;
import org.thecollective.utils.ExcelLibrary;

public class DataDrivenTestingFromExcel {

	
	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	@DataProvider(name="aeContent")
	public static Object[][] aeContent(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/aeContent.xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	

		
		@DataProvider(name="feedFromExcel")
		public static Object[][] feedFromExcel(Method methodName) throws Exception{
			File file = new File("resources/ExcelSheetData/feedFromExcel.xlsx");
			 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
			return data;
		}
	
	
	@DataProvider(name="mutipleSheetsSingleWorkbook")
	public static Object[][] mutipleSheetsSingleWorkbook(Method methodName) throws Exception{
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		File file = new File("resources/ExcelSheetData/"+setUp.getProductName()+"TestData.xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}


	@DataProvider(name="SignUpNeg")
	public static Object[][] SearchV2KeywordExactMatching(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/SignUpNeg.xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
		return data;
	}
}