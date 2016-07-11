package org.etna.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.etna.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class SearchData {

	
	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	
	@DataProvider(name="SearchV2KeywordExactMatching")
	public static Object[][] SearchV2KeywordExactMatching(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/SearchV2/SearchV2KeywordExactMatching/"+methodName.getName()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
	
	@DataProvider(name="SearchV2KeywordExactMatchingAbcOrXyz")
	public static Object[][] SearchV2KeywordExactMatchingAbcOrXyz(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/SearchV2/SearchV2KeywordExactMatchingAbcOrXyz/"+methodName.getName()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
}