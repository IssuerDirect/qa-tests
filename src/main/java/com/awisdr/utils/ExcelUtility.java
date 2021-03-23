package com.awisdr.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Map<String, String> readDataMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	static FileInputStream inputFileName = null;

	public static void readExcelFile(String testDataLocation) {
		try {
			inputFileName = new FileInputStream(testDataLocation);
			workbook = new XSSFWorkbook(inputFileName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Map<String, String> getTestData(String sheetName, String testCaseID) {
		try {
			sheet = workbook.getSheet(sheetName);
			int updatedRowNumber = 0;
			List<String> listOfTestCases = new ArrayList<String>();
			int lastCellNumber = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				listOfTestCases.add(sheet.getRow(i).getCell(0).getStringCellValue());
			}
			for (int j = 0; j < listOfTestCases.size(); j++) {
				if (listOfTestCases.get(j).equalsIgnoreCase(testCaseID)) {
					updatedRowNumber = j;
					updatedRowNumber = updatedRowNumber + 1;
				}
			}
			for (int k = 1; k < lastCellNumber; k++) {
				readDataMap.put(sheet.getRow(0).getCell(k).getStringCellValue(),
						sheet.getRow(updatedRowNumber).getCell(k).getStringCellValue());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
//		TestdataImplemen.getInstance.setExcelCellData(readDataMap)
		return readDataMap;
	}
}
