package com.main.apiAutomation.data_provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.main.apiAutomation.service_helpers.BhagavadGitaHelper;
import org.testng.annotations.DataProvider;

public class GItaDataProvider {

    @DataProvider(name = "getVerseFromChapter")
    public Object[][] getVerseFromChapter() throws JsonProcessingException {

        String clientIdB="9gP4e4LU8fqltGiAM9WA4Roaz7QIBZNqrwOOwwAe";
        String clientSecretB="s3ZjaLFQCnJqDAoBL14PCe0Q1mbIi3UdlbJzbrzwNONbUoLdEO";
        String grantTypeB="client_credentials";
        String scopeB="verse chapter";

        BhagavadGitaHelper bhagavadGitaHelper=new BhagavadGitaHelper();
        String tokenBantu = bhagavadGitaHelper.loginGita(clientIdB,clientSecretB,grantTypeB,scopeB);//expire
        BhagavadGitaHelper.Language language= BhagavadGitaHelper.Language.hi;
        int chapterB=1;
        int verseB=1;

        String clientIdM="rebgCVP1adIBrRMJpzreU6kuuOQ3pK6Ndw6qhGfA";
        String clientSecretM="kgEZvP5c4miW2UbWdFAE1ZIh3CofFidc0Zs1eHfQOS5usg1KV7";
        String grantTypeM="client_credentials";
        String scopeM="verse chapter";

        String tokenMeera=bhagavadGitaHelper.loginGita(clientIdM,clientSecretM,grantTypeM,scopeM);
        BhagavadGitaHelper.Language languageM= BhagavadGitaHelper.Language.hi;
        int chapterM=1;
        int verseM=1;


        return new Object[][]{
            {tokenBantu,language,chapterB,verseB},
                {tokenMeera,languageM, chapterM,verseM}
        };

    }
}
