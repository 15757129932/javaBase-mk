package org.mk.dev.tools;



public class TokenUtil {


    public static AccessToken getAccessToken(String app_key, String app_secret) {

        String salt = RandomUtil.getRandomStr(50);

        String tokenStr = app_key + app_secret + System.currentTimeMillis() + salt;

        String access_token_str = MD5Util.MD5(tokenStr,"utf-8");

        AccessToken accessToken = new AccessToken();

        accessToken.setTokenExpire(86400);//默认一天失效

        accessToken.setAccessToken(access_token_str);

        return accessToken;
    }


}
