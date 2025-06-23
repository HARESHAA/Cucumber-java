package SelPractice.SelPractice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWriteExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\suveerab\\eclipse-workspace\\SelPractice\\src\\test\\java\\SelPractice\\SelPractice\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Testing");
		
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Marks");
		row1.createCell(2).setCellValue("Subjects");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Hare");
		row2.createCell(1).setCellValue("80");
		row2.createCell(2).setCellValue("Maths");
		
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Aisha");
		row3.createCell(1).setCellValue("90");
		row3.createCell(2).setCellValue("English");
		
		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(0).setCellValue("Durga");
		row4.createCell(1).setCellValue("95");
		row4.createCell(2).setCellValue("Science");
		
		XSSFRow row5 = sheet.createRow(4);
		row5.createCell(0).setCellValue("Kothai");
		row5.createCell(1).setCellValue("97");
		row5.createCell(2).setCellValue("History");
		
		System.out.println("Success");
		
		workbook.write(file);
		workbook.close();
		file.close();

	}


	}


