package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static File file;
	
	
	public ExcelReader(String filepath,String sheetname) throws IOException {
	
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		
	}
	
	public int getRowCount() {
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
	
	public int getColumnCount() {
		row=sheet.getRow(1);
		int colCount=row.getLastCellNum();
		return colCount;
	}
	
	public String getCellData(int rowNum,int cellNum) {
		
		String celldata=sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return celldata;
		
	}
	
	/*public static void main(String[] args) throws IOException {
		
		ExcelReader er=new ExcelReader("B:\\april\\datadrivernframework\\src\\test\\java\\files\\FormData.xlsx", "form");
		System.out.println(er.getRowCount());
		System.out.println(er.getColumnCount());
		String s=er.getCellData(1, 1);
		System.out.println(s);
		
	}*/
}
