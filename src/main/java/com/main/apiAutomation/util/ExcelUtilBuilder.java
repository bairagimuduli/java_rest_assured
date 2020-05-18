package com.main.apiAutomation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtilBuilder {
    Logger logger = LogManager.getLogger(ExcelUtilBuilder.class);

    private String excelFile;
    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;

    public ExcelUtilBuilder(String excelFile, Workbook workbook, Sheet sheet, Row row, Cell cell) {
        this.excelFile = excelFile;
        this.workbook = workbook;
        this.sheet = sheet;
        this.row = row;
        this.cell = cell;
    }

    public static class Builder{
        private String excelFile;
        private Workbook workbook;
        private Sheet sheet;
        private Row row;
        private Cell cell;

        public String getExcelFile() {
            return excelFile;
        }

        public Builder setExcelFile(String excelFile) {
            this.excelFile = excelFile;
            return this;
        }

        public Workbook getWorkbook() {
            return workbook;
        }

        public Builder setWorkbook(Workbook workbook) {
            this.workbook = workbook;
            return this;
        }

        public Sheet getSheet() {
            return sheet;
        }

        public Builder setSheet(Sheet sheet) {
            this.sheet = sheet;
            return this;
        }

        public Row getRow() {
            return row;
        }

        public Builder setRow(Row row) {
            this.row = row;
            return this;
        }

        public Cell getCell() {
            return cell;
        }

        public Builder setCell(Cell cell) {
            this.cell = cell;
            return this;
        }

        public Builder() {
        }

        public ExcelUtilBuilder build(){
            return new ExcelUtilBuilder(excelFile,workbook,sheet,row,cell);
        }
    }
}
