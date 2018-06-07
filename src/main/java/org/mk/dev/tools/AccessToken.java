package org.mk.dev.tools;

public class AccessToken {

    private String accessToken;
    private int tokenExpire;


    public String getAccessToken() {
        return this.accessToken;
    }

    public int getTokenExpire() {
        return tokenExpire;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenExpire(int tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

}
