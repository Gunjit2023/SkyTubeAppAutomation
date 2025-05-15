package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private String filePath;
    private String sheetName;

    // Constructor to initialize the Excel file path and sheet name
    public ExcelReader(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    // Method to read all test cases from the specified sheet
    public Map<String, Map<String, String>> readAllTestCases() {
        Map<String, Map<String, String>> allTestCases = new HashMap<>();
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            // Load the Excel file
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);

            // Get the specified sheet
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' does not exist in the file.");
            }

            // Iterate through each row in the sheet, starting from row 1 to skip headers
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    String testCaseName = row.getCell(0) != null ? row.getCell(0).getStringCellValue() : "UnnamedTestCase";
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        String header = sheet.getRow(0).getCell(i) != null ? sheet.getRow(0).getCell(i).getStringCellValue() : "";
                        String value = "";

                        // Handle numeric values properly
                        if (row.getCell(i) != null) {
                            if (row.getCell(i).getCellType() == CellType.NUMERIC) {
                                if (DateUtil.isCellDateFormatted(row.getCell(i))) {
                                    // If it's a date, convert to string
                                    value = row.getCell(i).getDateCellValue().toString();
                                } else {
                                    // If it's a number, check if it has decimals or is an integer
                                    value = String.valueOf(row.getCell(i).getNumericCellValue());
                                }
                            } else if (row.getCell(i).getCellType() == CellType.STRING) {
                                value = row.getCell(i).getStringCellValue();
                            } else {
                                value = row.getCell(i).toString();
                            }
                        }

                        testData.put(header, value);
                    }
                    allTestCases.put(testCaseName, testData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return allTestCases;
    }
}
