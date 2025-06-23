package SelPractice.SelPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;


public class DataDrivenExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\suveerab\\eclipse-workspace\\SelPractice\\src\\test\\java\\SelPractice\\SelPractice\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		System.out.println("hi");
		XSSFSheet sheet = workbook.getSheet("Testing");
		int rowCount = sheet.getLastRowNum(); 
		int cellCount = sheet.getRow(0).getLastCellNum();
		for(int i = 0; i<= rowCount; i++)
		{
			XSSFRow rowData = sheet.getRow(i);
			for(int j = 0; j < cellCount; j++)
			{
				XSSFCell cell = rowData.getCell(j);
				System.out.print(cell.toString() + " ");
			}
			System.out.println();
		}
		workbook.close();
		file.close();	
		
	}


}

