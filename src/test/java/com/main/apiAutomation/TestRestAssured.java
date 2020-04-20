package com.main.apiAutomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.main.apiAutomation.pojo.GetRequest;
import com.main.apiAutomation.service_helpers.BhagavadGitaHelper;
import com.main.apiAutomation.service_helpers.PostmanEchoHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRestAssured {

    PostmanEchoHelper postmanEchoHelper=new PostmanEchoHelper();
    BhagavadGitaHelper bhagavadGitaHelper= new BhagavadGitaHelper();

    @Test
    public void testGita() throws JsonProcessingException {
        //https://bhagavadgita.io/api/v1/chapters/1/verses/2?access_token={{token}}&language=hi

        Response verseFromChapter = bhagavadGitaHelper.getVerseFromChapter(BhagavadGitaHelper.Language.hi, 1, 2);

    }

    @Test
    public void testName() throws JsonProcessingException {
        int test=123;
        GetRequest getRequest = postmanEchoHelper.getRequest(test);
        Assert.assertEquals(getRequest.getArgs().getTest(),String.valueOf(test),"test failed");

//        postmanEchoHelper.postRequest();
    }

    @Test
    public void testPost() throws IOException {

        String body="Duis posuere augue vel cursus pharetra. In luctus a ex nec pretium. Praesent neque quam, tincidunt nec leo eget, rutrum vehicula magna.\n" +
                "Maecenas consequat elementum elit, id semper sem tristique et. Integer pulvinar enim quis consectetur interdum volutpat.";

        postmanEchoHelper.postRawText(body);


//        RestAssured.baseURI="https://postman-echo.com";
//        Response post = given().contentType(ContentType.TEXT)
//                .body(new File(System.getProperty("user.dir") + File.separator + "Data/post"))
//                .when()
//                .post("post");
//        post.prettyPrint();

    }

    @Test
    public void testNameee() {
        String baseURI="https://bhagavadgita.io";
        String path="auth/oauth/token";

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("client_id","9gP4e4LU8fqltGiAM9WA4Roaz7QIBZNqrwOOwwAe");
        parametersMap.put("client_secret","s3ZjaLFQCnJqDAoBL14PCe0Q1mbIi3UdlbJzbrzwNONbUoLdEO");
        parametersMap.put("grant_type","client_credentials");
        parametersMap.put("scope","verse chapter");

        RestAssured.baseURI=baseURI;

        Response response = given().contentType(ContentType.URLENC).urlEncodingEnabled(true).formParams(parametersMap).post(path);

//        Header header=new Header("Content-Type", ContentType.TEXT.toString());
//        Response response = baseHelper.post(baseURI, path, header);
        response.prettyPrint();
        response.then().statusCode(200);
    }
}