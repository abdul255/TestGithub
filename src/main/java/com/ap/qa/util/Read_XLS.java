package com.ap.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// getting the information from the excell sheet and pushing to website= main reason of this class= read and write the information
public class Read_XLS {
	
	public String fileName;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr= null;
	private XSSFWorkbook wb= null;
	private XSSFSheet ws = null;
	
	
	List <String> list = new ArrayList <String> ();
	
	// this is a constructor. fileName: contains file name of the sheet
	// relativepath : relativepath of project where the file is 
	
	public Read_XLS(String fileName, String relativePath) {
		
	
	this.fileName=fileName;
	try {
		ipstr = new FileInputStream(relativePath+fileName);
		wb= new XSSFWorkbook(ipstr);
		ws= wb.getSheetAt(0);
		ipstr.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	// co relate to databuilder class
	// refferencing databuilder how many rows and column you have 
	// what information i have and send as a string 
	public int retrieveNoOfRows (String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return 0; // sheet will be 0, 1 , 2
		else {
			ws =wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum()+1;
			return rowCount;
		}
	}
	
	public int retrieveNoOfCols (String wsName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex ==-1)
			return 0;
		else {
			ws = wb.getSheetAt(sheetIndex);
			int colCount = ws.getRow(0).getLastCellNum();
			return colCount;
		}
	}
	
	//remove the spacee and send as string
	//converting into String/
	// null= if something null i like to handle as well
	//i do not want any empty cell- i want the cell which has data
	public String retrieveToRunFlag (String wsName, String colName, String rowName) {
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return null;
		else {
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
			int rowNumber = -1;
			int colNumber = -1;
			
			XSSFRow Suiterow = ws.getRow(0);
			for(int i=0; i<colNum; i++) {
				if(Suiterow.getCell(i).getStringCellValue().equals(rowName.trim())) {
					colNumber =i;
				}
			}
			if (colNumber ==-1) {
				return ""; // return will be string but i do not know what i have to provide
				
			}
			
			for(int j =0; j<rowNum; j++) {
				XSSFRow Suitecol =ws.getRow(j);	
				if(Suitecol.getCell(0).getStringCellValue().equals(rowName.trim())) {
					rowNumber =j;
				}
			}
			
			if(rowNumber == -1) {
				return "";
			}
			
			XSSFRow row = ws.getRow(rowNumber);
			XSSFCell cell = row.getCell(colNumber);
			if(cell==null) {
			return "";
		}
	
	String value = cellToString(cell);
	return value;
	
	}
}
	
	// making sure trying to get sheet index and make sure sheet has value then go rows and columns and loop through to grave that has information
	// celltype has to be string value. it cannot have null value, empty sheet value. not graving if anything empty
	// if empty i do not wanna perform
	
 @SuppressWarnings ("deprecation")
 public List <String> retrieveTestData1(String wsName){
	 int sheetIndex = wb.getSheetIndex(wsName);
	 if (sheetIndex ==-1)
		 return null;
	 else {
		 int rowNum = retrieveNoOfRows(wsName);
		 int colNum = retrieveNoOfCols(wsName);
		 
		 for(int i=0; i<rowNum;i++) {
			 XSSFRow row= ws.getRow(i);
			 for(int j=0; j<colNum;j++) {
			 if(row == null) {
				 list=null;
			 }
			 else {
				 XSSFCell cell = row.getCell(j);
						 if(cell == null) {
							 list=null;
						 }
						 //if cell has string value dont do anything.if not string convrt to string
						 else {
							 cell.setCellType(cell.CELL_TYPE_STRING); // check the latest update
							 String value = cellToString(cell);
							 System.out.println(value);
							 list.add(value);
						 }
			 }
		 }
	 }
	 return list;
 }
 }	
	
 @SuppressWarnings ("deprecation") //anything depricated to handle this= i can delete this line if i want
 
 //creating new method
public  Object [][] retrieveTestData (String wsName) {
	int sheetIndex = wb.getSheetIndex(wsName);// getting int sheetindex number
	//if null stop execution
	if(sheetIndex== -1)
		return null;
	else {
		int rowNum = retrieveNoOfRows(wsName); 
		int colNum = retrieveNoOfCols(wsName);
		
		Object data [][]= new Object [rowNum -1] [colNum];//-1 =to avoid title section
		for(int i=0; i<rowNum -1; i++) { //ist loop foor row 2nd loop for column
			XSSFRow row = ws.getRow(i +1);
			for(int j=0; j<colNum; j++) {
				if(row==null) { // if null return empty
				data[i][j]= "";
				
			} else {
				XSSFCell cell = row.getCell(j);
				
				if(cell== null) {
					data[i][j]="";
				}else {
					cell.setCellType(cell.CELL_TYPE_STRING); 
					String value = cellToString(cell);
					data[i][j]= value;
				}
			}
		}
	}
	
	return data;
}
}
//get the numeric and string value
//get the information and put break, pause and get next set of information
@SuppressWarnings ("deprecation")
public static String cellToString (XSSFCell cell) {
	int type;
	Object result;
	type = cell.getCellType();
	switch (type) {
	case 0:
		result = cell.getNumericCellValue();
		break;
	case 1:
		result = cell.getStringCellValue();
		break;
	default:
		throw new RuntimeException("Unsupported cell."); // if something not exist i like handle the situation; get error message
	}
	return result.toString();
}
}	
	


