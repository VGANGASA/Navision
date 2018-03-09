package com.Navision.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunction {

	public static String FilePath = "../Navision/testData";
	public XSSFCell Cell;
	public String CellData;
	public static String result;

	public String readexcelData(String path, String fileName, String sheet) throws IOException {

		File file = new File(path + "//" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
		XSSFSheet xs = wbook.getSheet(sheet);

		// int rowCount = xs.getLastRowNum() - xs.getFirstRowNum();

		int norows = xs.getLastRowNum();
		int nocol = xs.getRow(0).getLastCellNum();
		String[][] data = new String[norows][nocol];

		for (int i = 1; i < norows + 1; i++) {
			Row row = xs.getRow(i);
			for (int j = 0; j < nocol; j++) {
				Cell = (XSSFCell) row.getCell(j);

				CellType type = Cell.getCellTypeEnum();

				if (type == CellType.STRING) {
					CellData = Cell.getStringCellValue();
					System.out.println("Cell value 1 :: " + CellData);
				} else if (type == CellType.STRING.NUMERIC) {
					CellData = new Double(Cell.getNumericCellValue()).toString();
					System.out.println("Cell value 2 :: " + CellData);
				} else if (type == CellType.BLANK) {
					System.out.println("Cell Value is blank");
					break;
				}
				data[i][j] = CellData;
			}
		}
		wbook.close();
		inputStream.close();
		return CellData;
	}

	public String[][] readData1(String path, String fileName, String sheet) throws IOException {

		File file = new File(path + "//" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wbook = new XSSFWorkbook(inputStream);
		XSSFSheet ws = wbook.getSheet(sheet);

		int rowNum = ws.getPhysicalNumberOfRows();
		int colNum = ws.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowNum][colNum];

		for (int i = 1; i < rowNum; i++) {
			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data[i][j] = value;
			}
		}
		return data;
	}

	public static String cellToString(XSSFCell cell) {

		CellType type = cell.getCellTypeEnum();
		// String result;

		switch (type) {

		case NUMERIC:
			result = new Double(cell.getNumericCellValue()).toString();
			break;
		case STRING:
			result = cell.getStringCellValue();
			break;
		default:
			throw new RuntimeException("There is no support for this type of cell");
		}

		return result;
	}

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
//		ExcelFunction ef = new ExcelFunction();
//		String data[][] = ef.readData1("../Navision/testData/", "Data.xlsx", "sheet1");
//
//		System.out.println("data is ::::" + data.length);
//
//		for (int i = 1; i < data.length; i++) {
//			System.out.println(data[i].length);
//			for(int j = 0;j<data[i].length;j++) {
//				System.out.println(data[i][j]);
//			}
//		}
//	}

}
