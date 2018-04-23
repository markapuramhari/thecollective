package org.thecollective.modules;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class ExcelFileUpdateExample {
 
 
    public  void writeData(String StyleCode,String theDetails, String materialsCare, String sizeAndFit) {
    	  System.out.println("start");
        String excelFilePath = "D:/Thiruveedhi/Implementation/thecollective/resources/ExcelSheetData/aeContent.xlsx"; 
         //D:\Thiruveedhi\Implementation\thecollective\resources\ExcelsheetData
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath).getAbsolutePath());
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(1);
 
            Object[][] bookData = {
                    {StyleCode,theDetails,materialsCare,sizeAndFit}
            };
 
            int rowCount = sheet.getLastRowNum();
 
            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 
            }
 
            inputStream.close();
            File file= new File("D:/Thiruveedhi/Implementation/thecollective/resources/ExcelSheetData/aeContent.xlsx");
            FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
           
             
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
 
}
