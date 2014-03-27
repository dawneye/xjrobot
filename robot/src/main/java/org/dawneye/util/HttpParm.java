package org.dawneye.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpParm {

	private static final String HEADER = "headers";
	private static final String REQUEST = "request";
	
	private List<String[]> headers = null;
	private List<String[]> req = null;
	private String charset = "";
	
	public HttpParm(){
		headers = new ArrayList<String[]>();
		req = new ArrayList<String[]>();
		charset = "UTF-8";
	}
	
	public void addReq(String key, String value){
		addParm(REQUEST,key,value);
	}
	
	public void addHeader(String key, String value){
		addParm(HEADER,key,value);
	}
	
	public void addParm(String source, String... str){
		if(HEADER.equals(source)){
			headers.add(str);			
		}else if (REQUEST.equals(source)){
			req.add(str);
		}else{
			//TODO do nothing
		}
	}
	
	public List<String[]> getHeader(){
		return headers;
	}
	
	public String getReqNvPairs(){
		return getReqNvPairs(charset);
	}
	
    public String getReqNvPairs(String charSet){
        if(req==null || req.size()==0){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<req.size(); i++){
            String[] nvPairStr = req.get(i);
            try{
                if(i>0){
                    stringBuffer.append("&");
                }
                stringBuffer.append(URLEncoder.encode(nvPairStr[0], charSet)).append("=").append(URLEncoder.encode(nvPairStr[1], charSet));
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
                return null;
            }
        }
        return stringBuffer.toString();
    }
}
