package com.kotak.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class TestData {
	
	 public double Principal;
	public double rate;
	 public double year;
		
	public TestData() throws Exception
	{
   FileInputStream fis=new FileInputStream("F:\\KotakDemo\\kotakWeb\\datafiles\\loanData.xlsx");
		
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheet("Book1");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
				
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			 Principal=(Double)row.getCell(0).getNumericCellValue();
			 rate=(Double)row.getCell(1).getNumericCellValue();
			 year=(Double)row.getCell(2).getNumericCellValue();
			
		}
	}
}




































































//			if(Principal.equals("Principal"))
//			{
//				 Principal=Principal;
//			}
//			else
//				{
//				if(rate.equals("Rate"))
//					 rate=rate;
//				else if(year.equals("Year"))
//						 year=year;
//				}
//			
			//		}		
		
//		String Principal= String.valueOf(Principal);
//		String rate= String.valueOf(rate);
//		String year=String.valueOf(year);
		//}
//		System.out.println("principal amount="+Principal);
//		System.out.println("rate="+rate);
//		System.out.println("year="+year);
	
	//}

//}


















//FileInputStream fis=new FileInputStream("C:\\Users\\RESHMA\\git\\Kotak\\DataFiles\\Book1.xlsx");
//XSSFWorkbook wrk=new XSSFWorkbook(fis);
//XSSFSheet sht=wrk.getSheet("Book1");
//DataFormatter dff=new DataFormatter();
//
//int rows=sht.getLastRowNum();	
//int cols=sht.getRow(0).getLastCellNum();
//System.out.println("rows="+rows);
//System.out.println("cols="+cols);
//String[][] data=new String[rows][cols];
//
//
//for(int r=0;r<rows;r++)
//{
//	XSSFRow row=sht.getRow(r); //due to index of row of array and Excel sheet 
//	for(int c=0;c<cols;c++)
//	{
//		data[r][c]=dff.formatCellValue(row.getCell(c));				
//		System.out.print(data[r][c]+"    ");
//		System.out.println("excel data"+data[r][c]);
//	}
//}
//fis.close();
//wrk.close();
//System.out.println("Done!!");
////	return data;
//				
//