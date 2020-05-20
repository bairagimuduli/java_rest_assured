package com.main.apiAutomation.service_helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.apiAutomation.BaseHelper;
import com.main.apiAutomation.pojo.BhagwatGitaPojo;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class BhagavadGitaHelper {

    BaseHelper baseHelper=new BaseHelper();
    String baseURI="https://bhagavadgita.io";

//    public GetRequest login() throws IOException {
//
//        String path="auth/oauth/token";
//
//        Map<String, String> parametersMap = new HashMap<>();
//        parametersMap.put("client_id","9gP4e4LU8fqltGiAM9WA4Roaz7QIBZNqrwOOwwAe");
//        parametersMap.put("client_secret","s3ZjaLFQCnJqDAoBL14PCe0Q1mbIi3UdlbJzbrzwNONbUoLdEO");
//        parametersMap.put("grant_type","client_credentials");
//        parametersMap.put("scope","verse chapter");
//
//        RestAssured.baseURI=baseURI;
//
//        Response response = given().contentType(ContentType.URLENC).urlEncodingEnabled(true).formParams(parametersMap).post(path);
//
////        Header header=new Header("Content-Type", ContentType.TEXT.toString());
////        Response response = baseHelper.post(baseURI, path, header);
//        response.prettyPrint();
//        response.then().statusCode(200);
//        ObjectMapper objectMapper=new ObjectMapper();
//        GetRequest getRequest = objectMapper.readValue(response.prettyPrint(), GetRequest.class);
//        return getRequest;
//    }

    public String loginGita() throws JsonProcessingException {
        String path="auth/oauth/token";

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("client_id","9gP4e4LU8fqltGiAM9WA4Roaz7QIBZNqrwOOwwAe");
        parametersMap.put("client_secret","s3ZjaLFQCnJqDAoBL14PCe0Q1mbIi3UdlbJzbrzwNONbUoLdEO");
        parametersMap.put("grant_type","client_credentials");
        parametersMap.put("scope","verse chapter");

        Response response = baseHelper.post(baseURI, path, parametersMap);
        ObjectMapper objectMapper=new ObjectMapper();
        BhagwatGitaPojo bhagwatGitaPojo = objectMapper.readValue(response.prettyPrint(), BhagwatGitaPojo.class);
        String accessToken = bhagwatGitaPojo.getAccessToken();
        return accessToken;
    }

    public String loginGita(String clientId, String clientSecret, String grandType, String scope) throws JsonProcessingException {
        String path="auth/oauth/token";

        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("client_id",clientId);
        parametersMap.put("client_secret",clientSecret);
        parametersMap.put("grant_type",grandType);
        parametersMap.put("scope",scope);

        Response response = baseHelper.post(baseURI, path, parametersMap);
        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();
        BhagwatGitaPojo bhagwatGitaPojo = objectMapper.readValue(response.prettyPrint(), BhagwatGitaPojo.class);
        String accessToken = bhagwatGitaPojo.getAccessToken();
        System.out.println("access token= "+accessToken);
        return accessToken;
    }

    public Response getVerseFromChapter(Language language, int chapter, int verse, String token) throws JsonProcessingException {

//        String token = loginGita();  //loca; varibale
        String path="api/v1/chapters/";

        //https://bhagavadgita.io/api/v1/chapters/1/verses/2?access_token={{token}}&language=hi
        Map<String, String> paramMap= new HashMap<String, String>();
        paramMap.put("access_token",token);
        paramMap.put("language",language.name());

        Response response = baseHelper.get(baseURI, path + chapter + "/verses/" + verse, paramMap);
        response.prettyPrint();
        return response;
    }

    public Response getVerseFromChapterViaPathAsQuery(Language language, int chapter, int verse) throws JsonProcessingException {

        String token = loginGita();
        String path="api/v1/chapters/";

        String newPath= path + chapter + "/verses/" + verse +"?access_token="+token+"&language="+language.name();

        Response response = baseHelper.get(baseURI, newPath);
        response.prettyPrint();
        return response;
    }


    public enum Language {
        hi
    }

}
