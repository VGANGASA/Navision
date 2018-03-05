package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunction {

	public static String FilePath = "../Navision/testData";

	public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getNumericCellValue() + "|| ");
			}

			System.out.println();

		}
	}

	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToEnter)
			throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount + 1);

		for (int j = 1; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToEnter[j]);
		}
		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();

	}

	public void readData() throws IOException {
		FileInputStream file;
		try {
			file = new FileInputStream(FilePath);

			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				System.out.println("Row Number : " + row.getRowNum());
				// For each row, iterate through each columns

				Iterator cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					System.out.println("Cell value : " + cell.getNumericCellValue() + " , ");
				}
				System.out.println("......................");
			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	
	
//	public static void main(String[] args) throws IOException {
//
//		String[] valueToWrite = { "Mr. V", "London" };
//		ExcelFunction ef = new ExcelFunction();
//		ef.writeExcel(FilePath, "Data.xlsx", "Sheet1", valueToWrite);
//	}

}
