package org.dawneye.xjrobot.service;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.dawneye.xjrobot.util.TimeUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandman on 14-3-12.
 */
public class GameClientInit {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.err.println("Usage: java CookieDemoApp <url>");
//            System.err.println("<url> The url of a webpage");
//            System.exit(1);
//        }
        GameClientInit gci = new GameClientInit();
        List<String> urls = new ArrayList<String>();
        urls.add("http://wan.xianjian.com/client/Application/versionInfo.txt?v=" + TimeUtil.getJsonpSuffix());
        urls.add("http://www.xianjian.com/client?=" + TimeUtil.getJsonpSuffix() + "&channel=xinxianjian_v1.12.exe");
        urls.add("http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix());
        urls.add("http://register.xianjian.com/plugins/xjlogin?screenName=dakeshuichong&password=qq361972238&channel=xinxianjian_v1.12.exe&callbackparam=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix());
        urls.add("http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix());
        urls.add("http://www.xianjian.com/client/server.html");
        urls.add("http://register.xianjian.com/lasted-json?cb=" + "jsonp" + TimeUtil.getJsonpTimeStampSuffix() + "&_=" + TimeUtil.getJsonpTimeStampLaterSuffix());
        gci.request(urls);
    }

    public void request(List<String> strURLs) throws IOException {
        // Get target URL
//        String strURL = args[0];
//        String strURL = "http://wan.xianjian.com/client/Application/versionInfo.txt";
        System.out.println("Target URL: " + strURLs);

        // Get initial state object
        HttpState initialState = new HttpState();
        // Initial set of cookies can be retrieved from persistent storage and
        // re-created, using a persistence mechanism of choice,
//        Cookie mycookie = new Cookie("", "", "", "/", null, false);
//        Cookie mycookie = new Cookie();
        // and then added to your HTTP state instance
//        initialState.addCookie(mycookie);

        // Get HTTP client instance
        HttpClient httpclient = new HttpClient();
        httpclient.getHttpConnectionManager().
                getParams().setConnectionTimeout(30000);
        httpclient.setState(initialState);

        // RFC 2101 cookie management spec is used per default
        // to parse, validate, format & match cookies
        httpclient.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
        // A different cookie management spec can be selected
        // when desired
        for(String strURL: strURLs){
            requestAndPrint(strURL, httpclient);
        }
        //httpclient.getParams().setCookiePolicy(CookiePolicy.NETSCAPE);
        // Netscape Cookie Draft spec is provided for completeness
        // You would hardly want to use this spec in real life situations
        //httppclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        // Compatibility policy is provided in order to mimic cookie
        // management of popular web browsers that is in some areas
        // not 100% standards compliant



    }

    public void requestAndPrint(String strURL, HttpClient httpclient) throws IOException {
// Get HTTP GET method
        GetMethod httpget = new GetMethod(strURL);
        httpget.setRequestHeader("","");
        // Execute HTTP GET
        int result = httpclient.executeMethod(httpget);
        // Display status code
        System.out.println("Response status code: " + result);
        if(HttpStatus.SC_OK == result){
            String response = httpget.getResponseBodyAsString();
            System.out.println("Response context as text: " + response);
        }
        // Get all the cookies+
        Cookie[] cookies = httpclient.getState().getCookies();
        // Display the cookies
        System.out.println("Present cookies: ");
        for (int i = 0; i < cookies.length; i++) {
            System.out.println(" - " + cookies[i].toExternalForm());
        }
        // Release current connection to the connection pool once you are done
//        httpget.releaseConnection();
    }
}
