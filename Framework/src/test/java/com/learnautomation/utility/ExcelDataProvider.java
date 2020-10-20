package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File file= new File("./TestData/TestData.xlsx");
		
		try 
		{
			FileInputStream fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read excel file."+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheetName, int row, int cell)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	public String getStringData(int sheetIndex, int row, int cell)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}
	public double getNumericData(String sheetName, int row, int cell)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
	}

}
