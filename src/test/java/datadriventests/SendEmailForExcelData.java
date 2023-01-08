package datadriventests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;


public class SendEmailForExcelData {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("D:\\Users\\Email.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);	
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<=rowcount;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			for(int j=0;j<=colcount;j++)
			{
				String value=currentrow.getCell(j).toString();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		
		
	}
	
	
	

}
