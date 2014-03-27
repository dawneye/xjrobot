package org.dawneye.xjrobot.interfaces;

import org.apache.log4j.Logger;
import org.dawneye.util.HttpClientHelper;
import org.dawneye.util.HttpParm;
import org.dawneye.xjrobot.util.Constant;
import org.dawneye.xjrobot.util.TimeUtil;


/**
 * Created by sandman on 14-3-8.
 */
public class VersionInfo {
    private static final Logger logger = Logger.getLogger(VersionInfo.class);
    //服务地址
//    String urlStr = ConfigManager.getValueFormFile(Constant.SERVER_PATH)
//            + ConfigManager.getValueFormFile(Constant.CARDEVENT_URL);
    String urlStr = "http://wan.xianjian.com/client/Application/versionInfo.txt";
    //编码方式
    String charSetOfReq = Constant.CHAPTER_ENCODE_UTF8;
    String charSetOfResp = Constant.CHAPTER_ENCODE_UTF8;
    //请求参数
    String par1 = "v";
    String val1 = TimeUtil.getJsonpSuffix();

    String h_par1 = "user-Agent";
    String h_par2 = "cookie";
    String h_val1 = "Mozilla/4.0 (compatible; MSIE 5.00; Windows 98)";
    String h_val2 = "com.d2.wdaccountlist=dakeshuichong";

    public String requestTheServer(){
        String response = "";
//		参数名称	类型	是否必填	描述	备注
//		v	String	是	v=本年天数（从0计数）-时间（24小时制）-分钟-秒，均取自本地系统时间
        HttpParm parms = new HttpParm();
        parms.addReq(par1, val1);
        parms.addHeader(h_par1, h_val1);
//        parms.addHeader(h_par2, h_val2);
        logger.info("接口请求地址：" + urlStr);
        logger.info("接口请求参数：" + parms.getReqNvPairs());
        response = HttpClientHelper.request(urlStr, parms, HttpClientHelper.REQEST_TYPE_GET);
        logger.info("接口响应参数："+response);
        return response;
    }

    public static void main(String[] args) {
        VersionInfo getLatestVersion = new VersionInfo();
        System.out.println(getLatestVersion.requestTheServer());
    }
}
