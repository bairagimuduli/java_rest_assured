package com.main.apiAutomation;

import com.main.apiAutomation.data_provider.MPocketDP;
import com.main.apiAutomation.pojo.mPocket.CreateEmployeeDataResponsePojo;
import com.main.apiAutomation.pojo.mPocket.Data;
import com.main.apiAutomation.pojo.mPocket.EmployeeDeleteResponsePojo;
import com.main.apiAutomation.pojo.mPocket.get_employee.EmployeeDataResponsePojo;
import com.main.apiAutomation.service_helpers.MPocketHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MPocketTest {
    MPocketHelper mPocketHelper = new MPocketHelper();

    @Test(description = "create, get and delete employee data", dataProvider = "create_employee", dataProviderClass = MPocketDP.class)
    public void testMPocket(String name, int age, long salary) throws IOException {
        CreateEmployeeDataResponsePojo employeeData = mPocketHelper.createEmployeeData(name, age, salary);
        Integer employeeId = employeeData.getData().getId();
        EmployeeDataResponsePojo employeeById = mPocketHelper.getEmployeeById(employeeId);
        Data employeeByIdData = employeeById.getData();
        Assert.assertNotNull(employeeByIdData);
        Assert.assertEquals(name,employeeByIdData.getName(), "name is wrong");
        Assert.assertEquals(age,employeeByIdData.getAge(), "age is wrong");
        Assert.assertEquals(salary,employeeByIdData.getSalary(), "salary is wrong");
        EmployeeDeleteResponsePojo deleteEmployeeById = mPocketHelper.deleteEmployeeById(employeeId);
    }
}
