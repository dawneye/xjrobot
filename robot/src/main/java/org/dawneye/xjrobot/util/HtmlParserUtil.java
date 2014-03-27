package org.dawneye.xjrobot.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sandman on 14-3-9.
 */
public class HtmlParserUtil {

    private static final String REGX_CSS = "<link href=\\\"([^<|\\s]+)\\\"";
    private static final String REGX_JS = "<script.*src=\\\"([^<|\\s]+)\\\"";
    private static final String REGX_IMG = "<img.*src=\\\"([^<|\\s]+)\\\"";
    private static final String REGX_HTML_PROTOCOL = "http://";

    public static List<String> findAllResources(String url, String htmlCode){
        List<String> result = new ArrayList<String>();
        result.addAll(findCSSResources(url, htmlCode));
        result.addAll(findJSResources(url, htmlCode));
        result.addAll(findIMGResources(url, htmlCode));
        return result;
    }
    public static List<String> findCSSResources(String url, String htmlCode){
        return findResourcesByRegx(url, REGX_CSS, htmlCode);
    }
    public static List<String> findJSResources(String url, String htmlCode){
        return findResourcesByRegx(url, REGX_JS, htmlCode);
    }
    public static List<String> findIMGResources(String url, String htmlCode){
        return findResourcesByRegx(url, REGX_IMG, htmlCode);
    }

    private static List<String> findResourcesByRegx(String url, String regx, String htmlCode){
        boolean intactUrlFlag = false;//默认不返回完整的url地址
        String url_domain = "";
        if(null != url && !"".equals(url)){
            if(url.endsWith("/")){//去除url后的`/`字符
                url = url.substring(0, url.length() - 1);
            }
            intactUrlFlag = true;//送入了url，则拼装完整的url返回
            url_domain = findBaseDomain(url);//查找basedomain
        }

        return findResourcesByRegx(intactUrlFlag, url_domain, url, regx, htmlCode);
    }

    private static String findBaseDomain(String url){
        Pattern httpProtocolPattern = Pattern.compile(REGX_HTML_PROTOCOL);//正则表达式
        Matcher httpProtocolMatcher = httpProtocolPattern.matcher(url);
        if(httpProtocolMatcher.find()){//由http://开头
            return url.substring(0, url.indexOf("/", REGX_HTML_PROTOCOL.length()));
        }else{
            return url.substring(0, url.indexOf("/"));
        }
    }

    private static List<String> findResourcesByRegx(boolean intactUrlFlag, String url_domain, String url, String regx, String htmlCode){
        List<String> result = new ArrayList<String>();
        Pattern cssPattern = Pattern.compile(regx);//正则表达式
        Matcher cssMatcher = cssPattern.matcher(htmlCode);

        while(cssMatcher.find()){//如果匹配到则加入数组
            String path = cssMatcher.group();
            path = path.substring(0, path.length() - 1);//去除后面的引号
            path = path.substring(path.lastIndexOf("\"") + 1);//去除引号前面的字符及引号自身
            if(intactUrlFlag){//拼装完整的资源地址
                if(path.startsWith("/")){//若以`/`开头，则使用domain地址拼装
                    path = url_domain + path;
                }else{//若无前缀，则以当前url拼装
                    path = url + "/" + path;
                }
            }
            result.add(path);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String path = "D:\\projects\\xjRobot\\mydoc\\data\\login.html";
        String cssRegxPrefix = "<link href=";
        String valueRegx = "\\\"([^<|\\s]+)\\\"";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        StringBuffer stringBuffer = new StringBuffer("");
        String str = null;
        do{
            str = bufferedReader.readLine();
            stringBuffer.append(str).append("\r\n");
        }while(null != str);

        String htmlData = stringBuffer.substring(0, stringBuffer.length() - "\r\nnull\r\n".length());

//        System.out.println("文件 " + path + "中的内容：\r\n" + htmlData);
        List<String> cssPaths = HtmlParserUtil.findAllResources("http://www.xianjian.com/client/", htmlData);
        for(String string: cssPaths){
            System.out.println(string);
        }
//        String url = "http://www.xianjian.com/client/";
//        String url_domain = "";
//        if(null != url && !"".equals(url)){
//            Pattern httpProtocolPattern = Pattern.compile(REGX_HTML_PROTOCOL);//正则表达式
//            Matcher httpProtocolMatcher = httpProtocolPattern.matcher(url);
//            if(httpProtocolMatcher.find()){//由http://开头
//                url_domain = url.substring(0, url.indexOf("/", REGX_HTML_PROTOCOL.length()));
//            }else{
//                url_domain = url.substring(0, url.indexOf("/"));
//            }
//
//            if(url.endsWith("/")){
//                url = url.substring(0, url.length() - 1);
//            }
//        }
//        System.out.println(url);
//        System.out.println(url_domain);
    }
}
