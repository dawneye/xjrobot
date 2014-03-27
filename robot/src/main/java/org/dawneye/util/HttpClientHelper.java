package org.dawneye.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientHelper {
	
	//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Í£ï¿½POST
	public static final String REQEST_TYPE_POST = "POST";
	//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Í£ï¿½GET
	public static final String REQEST_TYPE_GET = "GET";
	//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	private static final String REQEST_CHARSET = "UTF-8";
	//ï¿½ï¿½ï¿½Ø½ï¿½ï¿½ï¿½ï¿½ï¿½
	private static final String RESPONSE_CHARSET = "UTF-8";	
	//ï¿½ï¿½Ê±Ê±ï¿½ï¿½ 50000ms
	private static final String TIMEOUT = "50000";

	public static String request(String url){
		return request(url, new HttpParm());
	}
	
	public static String request(String url, HttpParm parms){
		return request(url, parms, REQEST_TYPE_POST);
	}
	
	public static String request(String url, HttpParm parms, String method){
		return request(url, parms, method, REQEST_CHARSET);
	}
	
	public static String request(String url, HttpParm parms, String method, String reqCharset){
		return request(url, parms, method, reqCharset, TIMEOUT);
	}
	
	public static String request(String url, HttpParm parms, String method, String reqCharset, String timeOut){
		return request(url, parms, method, reqCharset, timeOut, RESPONSE_CHARSET);
	}
	
	public static String request(String url, HttpParm parms, String method, String reqCharset, String timeOut, String respCharset){
		return HttpClientHelperImpl.doHttp(url, method, parms.getHeader(), reqCharset, parms.getReqNvPairs(), timeOut, respCharset);
	}

    public static void downloadResourceFile(String fileURL, String filePath){
        try
        {
            File file=new File(filePath);
            file.createNewFile();
            StringBuffer sb = new StringBuffer();
            URL url = new URL(fileURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0)");//è®¾ç½®å®¢æˆ·çš„æµè§ˆå™¨ä¸ºIE9
            byte[] buffer = new byte[1024];
            InputStream is = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);
            int len = 0;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            fos.close();
            is.close();
            connection.disconnect();
        }catch (IOException e)
        {
            System.out.println("¸ÃÎÄ¼ş²»´æÔÚ£º"+fileURL);
        }
    }
}
