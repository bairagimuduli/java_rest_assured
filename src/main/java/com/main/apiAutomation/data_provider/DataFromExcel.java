package com.main.apiAutomation.data_provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.main.apiAutomation.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

import java.util.List;

public class DataFromExcel extends ExcelUtil {
    String file = "src/main/resources/temp_test_case_new.xlsx";
    String sheetName = "Sheet1";
    Sheet sheet = ExcelUtil.getSheet(file, sheetName);

    /**
     * It takes data from the excel sheet
     *
     * @return
     * @throws JsonProcessingException
     */

    @DataProvider(name = "getVerseFromChapter")
    public Object[][] getVerseFromChapter() throws JsonProcessingException {

        List rowData = ExcelUtil.getRowData(sheet, 1);
        List rowData1 = ExcelUtil.getRowData(sheet, 2);

        return new Object[][]{
                rowData.toArray(),
                rowData1.toArray()
        };

    }
}
