package SelPractice.SelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File; // <--- ADD THIS IMPORT

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DataDrivenExcelTestng {

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	@BeforeClass
	void setUp() throws IOException
	{
        String filePath = "C:\\Users\\suveerab\\eclipse-workspace\\CucumberPractise\\TestDataCucu.xlsx";

        // *** START CRITICAL DEBUGGING LINES ***
        File excelFile = new File(filePath);
        
        System.out.println("--- Debugging File Path ---");
        System.out.println("Attempting to open Excel file at: " + excelFile.getAbsolutePath());
        
        if (!excelFile.exists()) {
            System.err.println("ERROR: File DOES NOT EXIST at the specified path.");
            throw new IOException("File not found at: " + excelFile.getAbsolutePath());
        }
        System.out.println("File exists: " + excelFile.exists());
        
        if (!excelFile.canRead()) {
            System.err.println("ERROR: File EXISTS, but is NOT READABLE (permissions issue?).");
            throw new IOException("File not readable at: " + excelFile.getAbsolutePath());
        }
        System.out.println("File readable: " + excelFile.canRead());
        System.out.println("File size (bytes): " + excelFile.length());
        System.out.println("--- End Debugging File Path ---");
        // *** END CRITICAL DEBUGGING LINES ***


		file = new FileInputStream(filePath); // This is line 26 where the error is pointed
		workbook = new XSSFWorkbook(file);
		
        // Add a null check for the sheet - it's good practice
        sheet = workbook.getSheet("Sheet1");
        if (sheet == null) {
            System.err.println("ERROR: Sheet named 'Sheet1' was NOT FOUND in the Excel file.");
            System.err.println("Please open 'TestDataCucu.xlsx' and verify the exact sheet name (case-sensitive, no extra spaces).");
            throw new IOException("Sheet 'Sheet1' not found.");
        }
	}
	
	@Test
	public void Test()
	{
		System.out.print("hi");
		// Add checks for rowData and cell too to prevent NullPointerExceptions later
		int rowCount = sheet.getLastRowNum(); 
		if (rowCount < 0) {
            System.out.println("No data rows found in the sheet.");
            return;
        }

		XSSFRow firstRow = sheet.getRow(0);
		if (firstRow == null) {
			System.out.println("First row (row 0) is null. The sheet might be entirely empty.");
			return;
		}
		int cellCount = firstRow.getLastCellNum();

		for(int i = 0; i<= rowCount; i++)
		{
			XSSFRow rowData = sheet.getRow(i);
			if (rowData == null) { // Skip null rows (e.g., empty rows between data in Excel)
				continue;
			}
			for(int j = 0; j < cellCount; j++)
			{
				XSSFCell cell = rowData.getCell(j);
				if (cell != null) {
					System.out.print(cell.toString() + " ");
				} else {
					System.out.print("[BLANK] ");
				}
			}
			System.out.println();
		}
	}
		
	@AfterClass
	void tearUp() throws IOException
	{
        // Add null checks before closing
		if (workbook != null) {
			workbook.close();
		}
		if (file != null) {
			file.close();
		}
	}
}