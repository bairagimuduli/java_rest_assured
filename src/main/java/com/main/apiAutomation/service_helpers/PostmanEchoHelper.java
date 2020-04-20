package com.main.apiAutomation.service_helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.apiAutomation.BaseHelper;
import com.main.apiAutomation.pojo.GetRequest;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostmanEchoHelper {

    BaseHelper baseHelper=new BaseHelper();

    String baseURI = "https://postman-echo.com";

    public GetRequest getRequest(int test) throws JsonProcessingException {
        String path="get?test="+test;
        Response response = baseHelper.get(baseURI, path);
        response.then().statusCode(200);
        ObjectMapper objectMapper=new ObjectMapper();
        GetRequest getRequest = objectMapper.readValue(response.prettyPrint(), GetRequest.class);
        return getRequest;
    }

    public GetRequest getRequestByParam(int test) throws JsonProcessingException {
        String path="get";
        Map<String, Integer> queryParam = new HashMap<>();
        queryParam.put("test", test);
        Response response = baseHelper.get(baseURI, path,queryParam);
        response.then().statusCode(200);
        ObjectMapper objectMapper=new ObjectMapper();
        GetRequest getRequest = objectMapper.readValue(response.prettyPrint(), GetRequest.class);
        return getRequest;
    }

    public GetRequest postRawText(String body) throws IOException {
        String path="post";
        Response response = baseHelper.post(baseURI, path, ContentType.TEXT,body);
        response.prettyPrint();
        response.then().statusCode(200);
        ObjectMapper objectMapper=new ObjectMapper();
        GetRequest getRequest = objectMapper.readValue(response.prettyPrint(), GetRequest.class);
        return getRequest;
    }
}
