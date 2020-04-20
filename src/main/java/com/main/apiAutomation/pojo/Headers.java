
package com.main.apiAutomation.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {

    @JsonProperty("x-forwarded-proto")
    private String xForwardedProto;
    private String host;
    private String accept;
    @JsonProperty("accept-encoding")
    private String acceptEncoding;
    @JsonProperty("user-agent")
    private String userAgent;
    @JsonProperty("x-forwarded-port")
    private String xForwardedPort;

    public String getXForwardedProto() {
        return xForwardedProto;
    }

    public void setXForwardedProto(String xForwardedProto) {
        this.xForwardedProto = xForwardedProto;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getXForwardedPort() {
        return xForwardedPort;
    }

    public void setXForwardedPort(String xForwardedPort) {
        this.xForwardedPort = xForwardedPort;
    }

}
