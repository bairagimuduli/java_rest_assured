package com.main.apiAutomation.data_provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;

public class MPocketDP {

    @DataProvider(name = "create_employee")
    public Object[][] getVerseFromChapter() throws JsonProcessingException {

        return new Object[][]{
                {"Bantu", 23, 1200000l},
                {"Muduli", 35, 1250000l},
                {"Bairagi",26,  2320000l},
        };

    }
}
