package org.mk.dev.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yybxsp.main.util.MD5Util;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;

//import org.apache.commons.lang.StringUtils;

//{"result":"{\"code\":\"000000\",\"data\":{\"bizOrderNumber\":\"95303098180329142554\",\"canUse\":\"t\",\"isSign\":\"t\",\"openHtml\":null,\"openUrl\":\"https://cash.yeepay.com/wap/request/10016127946/GfqJu1kYJ9aVSYkpZ7eKRw%3D%3D\",\"tn\":\"2018-03-29\",\"txnId\":0,\"txnStatus\":\"p\"},\"message\":\"预下单成功\"}","sign":"e52136d2d9546d6a345bf063332b5343"}


public class StatusTest {


    private final static String key = "d7a3bc0e54a6b56a4539a999f5f15d02";

    private final static String encryptId = "000020045000004";

    private final static Integer apiVersion = 1;

    private static final String serverUrl = "https://www.znyoo.com/oss-transaction/gateway/";

    public static void main(String[] args) throws Exception {
        JSONObject content = new JSONObject();
        JSONObject obj = new JSONObject();
        String method = "fastpayQuery";
        obj.put("encryptId", encryptId);
        obj.put("apiVersion", apiVersion);
        obj.put("method", method);
        obj.put("txnDate", Calendar.getInstance().getTimeInMillis());
        obj.put("mid", "000020045000004");
        obj.put("accountNumber", "6253634008552892");
        obj.put("tel", "13335709875");
        obj.put("cvv2", "892");
        obj.put("expired", "1124");
        obj.put("srcAmt", 100);

        obj.put("extraFee", 1);
        obj.put("bizOrderNumber", "80911325180329150756");


        obj.put("fastpayFee", 0.5);
        obj.put("holderName", "吴梦思远");
        obj.put("idcard", "330802199311075039");

        obj.put("agencyType", "shanglv");
        obj.put("settAccountNumber", "6236681470002067648");
        obj.put("settAccountTel", "13335709875");






        content.put("content", JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue));
        content.put("key", key);
        String signStr = JSON.toJSONString(content,SerializerFeature.WriteMapNullValue);
       // System.out.println("signStr=="+signStr);
        String sign = com.yybxsp.main.util.MD5Util.MD5(signStr, "utf-8");
        content.remove("key");
        content.put("sign", sign);
        String result = sendHttpsPost(serverUrl+method, JSON.toJSONString(content));
        JSONObject resultObj = JSONObject.parseObject(result);
        JSONObject resultSignObj = new JSONObject();
        resultSignObj.put("result", resultObj.getString("result"));
        resultSignObj.put("key", key);
        signStr = JSON.toJSONString(resultSignObj,SerializerFeature.WriteMapNullValue);
        //System.out.println("signStr=="+signStr);
        sign = MD5Util.MD5(signStr, "utf-8");
       // System.out.println(sign.equals(resultObj.getString("sign")));
        String resultStr = resultObj.getString("result");
        String html = JSONObject.parseObject(resultStr).getJSONObject("data").getString("openHtml");
        System.out.println(html);
    }

    public static String sendHttpsPost(String url, String params){
        DataOutputStream out = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        URL u = null;
        HttpsURLConnection con = null;
        //尝试发送请求
        try{
            System.out.println(params);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                    new java.security.SecureRandom());
            u = new URL(url);
            //打开和URL之间的连接
            con = (HttpsURLConnection)u.openConnection();
            //设置通用的请求属性
            con.setSSLSocketFactory(sc.getSocketFactory());
            con.setHostnameVerifier(new TrustAnyHostnameVerifier());
            //con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json"); //
            con.setUseCaches(false);
            //发送POST请求必须设置如下两行
            con.setDoOutput(true);
            con.setDoInput(true);

            con.connect();
            out = new DataOutputStream(con.getOutputStream());
            out.write(params.getBytes("utf-8"));
            // 刷新、关闭
            out.flush();
            out.close();
            //读取返回内容
            //InputStream is = con.getInputStream();
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String line;
            while((line = in.readLine()) != null) {
                result.append(line).append(System.lineSeparator());
            }
            System.out.println(result);
            return result.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
                if(con != null) {
                    con.disconnect();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }


    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }

    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }







}



