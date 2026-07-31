package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {


    private static final String FILE_PATH =
            "C:\\Users\\CODECLOUDS-RAHUL\\IdeaProjects\\loctor-practice-sel\\src\\testdata\\datadrive.xlsx";

    public static List<Object[]> getDataFromExcel(String sheetName) {
        List<Object[]> myData = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();   // turns any cell into a clean String

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int totalRows = sheet.getLastRowNum();              // last index, header excluded by loop
            int totalCols = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= totalRows; i++) {              // skip header row 0
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Object[] rowData = new Object[totalCols];
                for (int j = 0; j < totalCols; j++) {
                    rowData[j] = formatter.formatCellValue(row.getCell(j));  // null-safe, all types
                }
                myData.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }
}