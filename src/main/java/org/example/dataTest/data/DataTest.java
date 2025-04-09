package org.example.dataTest.data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataTest {
    public Object[][] readSheet() throws IOException, InvalidFormatException {
        File myfile = new File("src\\main\\java\\resources\\dataTest.xlsx");
        FileInputStream fis = new FileInputStream(myfile);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = sheet.getRow(0).getLastCellNum();
        Object[][] myarray = new Object[rowNum - 1][colNum];

        for (int i = 1; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(j);

                if (cell == null) {
                    myarray[i - 1][j] = "";
                } else {
                    switch (cell.getCellType()) {
                        case STRING:
                            myarray[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            myarray[i - 1][j] = String.valueOf((int) cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            myarray[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            myarray[i - 1][j] = cell.getCellFormula();
                            break;
                        default:
                            myarray[i - 1][j] = "";
                    }
                }
            }
        }
        wb.close();
        fis.close();
        return myarray;
    }
}