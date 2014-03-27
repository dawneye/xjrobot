package org.dawneye.util;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class HttpX509TrustManager implements X509TrustManager{

    public HttpX509TrustManager(){
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s){
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s){
    }

    public X509Certificate[] getAcceptedIssuers(){
        return null;
    }
}
