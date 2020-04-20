package com.main.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HelloWorld {

    @Test
    public void testName() {
        System.out.println("Hello world");

    }

    @Test
    public void testName1() {
        RestAssured.baseURI="https://postman-echo.com";
        Response response = RestAssured.get("get?test=123");
        response.prettyPrint();
    }
}