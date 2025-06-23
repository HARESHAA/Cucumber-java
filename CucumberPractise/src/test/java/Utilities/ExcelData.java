package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	@DataProvider(name = "Field Data")
	public Object[][] getData() throws IOException
	{
		file = new FileInputStream("C:\\Users\\suveerab\\eclipse-workspace\\CucumberPractise\\FrameworkDataxlsx.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
		int r = sheet.getLastRowNum();
		int c = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[r][c];
		for(int i = 1; i<=r; i++)
		{
			row = sheet.getRow(i);
			
			if(row != null) {
				for(int j = 0;j < c; j++)
				{
					cell = row.getCell(j);
					
					if(cell == null)
					{
						data[i-1][j] = "";
					}else
					{
						data[i-1][j] = cell.toString();
					}
				}
			}
			
		}
		
		workbook.close();
		file.close();
		return data;
		
		}

}



/*package Utilities; // Or dataProviders; or any other suitable package

import org.testng.annotations.DataProvider;

public class ExcelData {

    @DataProvider(name = "Field Data")
    public Object[][] getLoginData() {
        return new Object[][] {
            // Mail,               Pwd,      Result
            {"admin@yourstore.com", "admin",  "Valid"},
            {"wrong@email.com",   "admin",  "Invalid"},
            {"admin@yourstore.com", "wrongpwd", "Invalid"},
            {"",                    "",       "Invalid"} // Empty credentials
        };
    }

  
}
*/


