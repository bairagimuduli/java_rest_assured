package com.main.apiAutomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseHelper {

    Logger logger = LogManager.getLogger(BaseHelper.class);

    /**
     * get
     *
     * @param baseURI
     * @param pathParam
     * @return
     */
    public Response get(String baseURI, String pathParam) {
        RestAssured.baseURI = baseURI;
        logger.info("==============================================================");
        logger.info(baseURI + "/" + pathParam);
        Response response = RestAssured.get(pathParam);
        logger.info("==============================================================");
        return response;
    }

    /**
     * get
     * @param baseURI
     * @param pathParam
     * @param queryParamsMap
     * @return
     */
    public Response get(String baseURI, String pathParam, Map<String,?> queryParamsMap) {
        RestAssured.baseURI = baseURI;
        logger.info("==============================================================");
        logger.info(baseURI + "/" + pathParam);
        Response response = RestAssured.given().queryParams(queryParamsMap).get(pathParam);
        logger.info("==============================================================");
        return response;
    }

    /**
     * post
     *
     * @param baseURI
     * @param pathParam
     * @param contentType
     * @return
     * @throws IOException
     */
    public Response post(String baseURI, String pathParam, ContentType contentType, String body) throws IOException {
        RestAssured.baseURI = baseURI;
        logger.info("==============================================================");
        logger.info(baseURI + "/" + pathParam);
//        File file = new File(System.getProperty("user.dir") + File.separator + "Data/" + pathParam);
//        printFile(file);
        Response response = RestAssured.given()
                .contentType(contentType)
                .body(body)
                .when().post();
        response.prettyPrint();

        logger.info("==============================================================");
        return response;
    }

    /**
     * post
     * for "x-www-form-urlencoded" body type
     * @param baseURI
     * @param pathParam
     * @param parametersMap
     * @return
     */
    public Response post(String baseURI, String pathParam, Map<String, String> parametersMap) {
        RestAssured.baseURI = baseURI;
        logger.info("==============================================================");
        logger.info(baseURI + "/" + pathParam);
        Response response = given().contentType(ContentType.URLENC).urlEncodingEnabled(true).formParams(parametersMap).post(pathParam);
        response.prettyPrint();


        logger.info("==============================================================");
        return response;
    }

    /**
     * printFile
     *
     * @param file
     * @throws IOException
     */
    public void printFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            logger.info(line);
        }
    }
}
