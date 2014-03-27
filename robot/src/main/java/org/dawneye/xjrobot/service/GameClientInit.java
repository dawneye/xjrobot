package org.dawneye.xjrobot.service;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.dawneye.xjrobot.util.TimeUtil;

import java.io.IOException;

/**
 * Created by sandman on 14-3-12.
 */
public class GameClientInit {
    private static final Logger logger = Logger.getLogger(GameClientInit.class);
    private HttpClient httpclient;

    public GameClientInit(HttpClient httpclient) {
        this.httpclient = httpclient;
    }

    public static void main(String[] args) throws Exception {
        HttpClient myHttpClient = new HttpClient();
        myHttpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);//浏览器兼容模式
        GameClientInit gci = new GameClientInit(myHttpClient);
        gci.httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);//超时时间30秒(3000毫秒)

        gci.request1();
        gci.request2();
        gci.request3();
        gci.request4();
        gci.request5();
        gci.request6();
        gci.request7();
    }

    public void request1() throws IOException {
        //版本检查
        String strURL = "http://wan.xianjian.com/client/Application/versionInfo.txt?v=" + TimeUtil.getJsonpSuffix();
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request2() throws IOException {
        //版本检查
        String strURL = "http://www.xianjian.com/client?=" + TimeUtil.getJsonpSuffix() + "&channel=xinxianjian_v1.12.exe";
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request3() throws IOException {
        //版本检查
        String strURL = "http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix();
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request4() throws IOException {
        //版本检查
        String strURL = "http://register.xianjian.com/plugins/xjlogin?screenName=dakeshuichong&password=qq361972238&channel=xinxianjian_v1.12.exe&callbackparam=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix();
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request5() throws IOException {
        //版本检查
        String strURL = "http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix();
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request6() throws IOException {
        //版本检查
        String strURL = "http://www.xianjian.com/client/server.html";
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }

    public void request7() throws IOException {
        //版本检查
        String strURL = "http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix();
        logger.info("request url: " + strURL);
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        logger.info("request parameters: " + httpget);
        int result = this.httpclient.executeMethod(httpget);
        logger.info("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            logger.info("Response context as text: " + response);
            Cookie[] cookies = this.httpclient.getState().getCookies();
            logger.info("Present cookies: ");
            for (int i = 0; i < cookies.length; i++) {
                logger.info(" - " + cookies[i].toExternalForm());
            }
        }
    }
}
