package com.main.apiAutomation.service_helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.apiAutomation.BaseHelper;
import com.main.apiAutomation.pojo.mPocket.CreateEmployeeDataPojo;
import com.main.apiAutomation.pojo.mPocket.CreateEmployeeDataResponsePojo;
import com.main.apiAutomation.pojo.mPocket.EmployeeDeleteResponsePojo;
import com.main.apiAutomation.pojo.mPocket.EmployeesDataResponsePojo;
import com.main.apiAutomation.pojo.mPocket.get_employee.EmployeeDataResponsePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static com.main.apiAutomation.constants.MPocketEndPoints.*;

public class MPocketHelper {

    BaseHelper baseHelper=new BaseHelper();
    ObjectMapper objectMapper=new ObjectMapper();


    /**
     *
     * @param name
     * @param age
     * @param salary
     * @return
     * @throws IOException
     */
    public CreateEmployeeDataResponsePojo createEmployeeData(String name, int age, long salary) throws IOException {

        CreateEmployeeDataPojo createEmployeeDataPojo = new CreateEmployeeDataPojo();
        createEmployeeDataPojo.setName(name);
        createEmployeeDataPojo.setAge(String.valueOf(age));
        createEmployeeDataPojo.setSalary(String.valueOf(salary));

        String employeeData = objectMapper.writeValueAsString(createEmployeeDataPojo);

        Response response = baseHelper.post(dummyUri, createEmployeeData, ContentType.JSON, employeeData);
        CreateEmployeeDataResponsePojo createEmployeeDataResponse = objectMapper.readValue(response.prettyPrint(), CreateEmployeeDataResponsePojo.class);
        return  createEmployeeDataResponse;
    }

    /**
     * get all the employee
     *
     * @return
     * @throws JsonProcessingException
     */
    public EmployeesDataResponsePojo getEmployees() throws JsonProcessingException {
        Response response = baseHelper.get(dummyUri, getEmployeesData);
        EmployeesDataResponsePojo employeeDataResponse = objectMapper.readValue(response.prettyPrint(), EmployeesDataResponsePojo.class);
        return employeeDataResponse;
    }

    /**
     * get employee by id
     *
     * @param id
     * @return
     * @throws JsonProcessingException
     */
    public EmployeeDataResponsePojo getEmployeeById(int id) throws JsonProcessingException {
        Response response = baseHelper.get(dummyUri, getEmployeeData +id);
        EmployeeDataResponsePojo employeeDataResponse = objectMapper.readValue(response.prettyPrint(), EmployeeDataResponsePojo.class);
        return employeeDataResponse;
    }

    /**
     * update employee data
     *
     * @param id
     * @param name
     * @param age
     * @param salary
     * @return
     * @throws IOException
     */
    public EmployeeDataResponsePojo updateEmployee(int id, String name, int age, long salary) throws IOException {
        CreateEmployeeDataPojo createEmployeeDataPojo = new CreateEmployeeDataPojo();
        createEmployeeDataPojo.setName(name);
        createEmployeeDataPojo.setAge(String.valueOf(age));
        createEmployeeDataPojo.setSalary(String.valueOf(salary));

        String employeeData = objectMapper.writeValueAsString(createEmployeeDataPojo);
        Response response = baseHelper.put(dummyUri, updateEmployeeData+id, ContentType.JSON, employeeData);
        EmployeeDataResponsePojo employeeDataResponse = objectMapper.readValue(response.prettyPrint(), EmployeeDataResponsePojo.class);
        return employeeDataResponse;
    }

    /**
     * delete employee data
     * @param id
     * @return
     * @throws JsonProcessingException
     */
    public EmployeeDeleteResponsePojo deleteEmployeeById(int id) throws JsonProcessingException {
        Response response = baseHelper.delete(dummyUri, deleteEmployeeData +id);
        EmployeeDeleteResponsePojo employeeDataResponse = objectMapper.readValue(response.prettyPrint(), EmployeeDeleteResponsePojo.class);
        return employeeDataResponse;
    }


}
