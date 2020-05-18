package com.main.apiAutomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.main.apiAutomation.data_provider.DataFromExcel;
import com.main.apiAutomation.data_provider.GItaDataProvider;
import com.main.apiAutomation.service_helpers.BhagavadGitaHelper;
import com.main.apiAutomation.service_helpers.PostmanEchoHelper;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRestAssured {

    PostmanEchoHelper postmanEchoHelper=new PostmanEchoHelper(); //created the instance
    BhagavadGitaHelper bhagavadGitaHelper= new BhagavadGitaHelper();

    @Test(dataProviderClass = GItaDataProvider.class, dataProvider = "getVerseFromChapter")
    public void testGetVerseFromChapter(String token, BhagavadGitaHelper.Language language,int chapter, int verse) throws JsonProcessingException {

        Response verseFromChapter = bhagavadGitaHelper.getVerseFromChapter(language,chapter,verse,token);
        JsonPathConfig jsonPathConfig= new JsonPathConfig();
        String chapter_number = verseFromChapter.jsonPath(jsonPathConfig).get("chapter_number").toString();
        Assert.assertEquals(chapter_number,"1","we are doing it wrong");
    }

    @Test(dataProviderClass = DataFromExcel.class, dataProvider = "getVerseFromChapter")
    public void testGetVerseFromChapterExcel(String clientId, String clientSecret,String grantType , String scope) throws JsonProcessingException {
        int chapter=1;
        int verse=1;
        BhagavadGitaHelper.Language language= BhagavadGitaHelper.Language.hi;
        String token = bhagavadGitaHelper.loginGita(clientId, clientSecret, grantType, scope);
        Response verseFromChapter = bhagavadGitaHelper.getVerseFromChapter(language,chapter,verse,token);
        JsonPathConfig jsonPathConfig= new JsonPathConfig();
        String chapter_number = verseFromChapter.jsonPath(jsonPathConfig).get("chapter_number").toString();
        Assert.assertEquals(chapter_number,"1","we are doing it wrong");
    }
}