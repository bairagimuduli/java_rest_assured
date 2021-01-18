package com.main.apiAutomation.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class WireMockUtil {

    @Test
    public void startMockServer() {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8081));
        WireMock.configureFor("localhost", 8081);
        if(wireMockServer.isRunning()) {
            System.out.print("Here in if loop." + wireMockServer.toString());
            wireMockServer.stop();
        }
        wireMockServer.start();

    }

    public void stopMockServer() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.stop();
    }

    public void setupStub(String uri, int statusCode, String contentType, String body) {
        stubFor(get(urlMatching(".*/" + uri + ".*"))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", contentType)
                        .withBody(body)));
    }
}
