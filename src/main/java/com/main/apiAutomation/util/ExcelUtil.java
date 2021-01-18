package com.main.apiAutomation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    private static FileInputStream inputStream;
    private static Workbook workbook;
    private static Sheet sheet;
    static Logger logger = LogManager.getLogger(ExcelUtil.class);

    /**
     * getSheet
     * get sheet from the excel file
     *
     * @param excelFIle
     * @param sheetName
     * @return
     */
    public static Sheet getSheet(String excelFIle, String sheetName) {
        try {
            File file = new File(excelFIle);
            if (!file.exists()) {
                logger.info("File does not exist, so existing function");
            }
            logger.info("going inside {}", file.getAbsolutePath());
            inputStream = new FileInputStream(file.getAbsolutePath());
            if (excelFIle.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);

            } else if (excelFIle.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else {
                System.out
                        .println("FILE EXTENSION COULD NOT BE IDENTIFIED.... EXTITING");
                System.exit(0);
            }
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    /**
     * getCellValue
     *
     * @param sheet
     * @param rowId
     * @param columnId
     * @return
     */
    public static String getCellValue(Sheet sheet, int rowId, int columnId) {
        String cellValue = null;
        Cell cell = sheet.getRow(rowId).getCell(columnId);
        if (null != cell.toString()) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
            }
        }
        return cellValue;
    }

    /**
     * allValueOfColumn
     *
     * @param sheet
     * @param columnId
     * @return
     */
    public static List allValueOfColumn(Sheet sheet, int columnId) {
        List allValueOfColumn = new ArrayList();
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            allValueOfColumn.add(getCellValue(sheet, i, columnId));
        }
        return allValueOfColumn;
    }

    /**
     * getColumnIdFromName
     *
     * @param sheet
     * @param columnName
     * @return
     */
    public static int getColumnIdFromName(Sheet sheet, String columnName) {
        int columnId = 0;
        for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            if (columnName.equalsIgnoreCase(sheet.getRow(0).getCell(i).toString())) {
                columnId = i;
            }
            ;
        }
        return columnId;
    }

    /**
     * @param sheet
     * @param rowNo
     * @return
     */
    public static List getRowData(Sheet sheet, int rowNo) {
        List rowData = new ArrayList();
        for (int i = 0; i < sheet.getRow(rowNo).getPhysicalNumberOfCells(); i++) {
            rowData.add(sheet.getRow(rowNo).getCell(i).getStringCellValue());
        }
        return rowData;
    }
}
