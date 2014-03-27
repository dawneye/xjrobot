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
    //�����ַ
//    String urlStr = ConfigManager.getValueFormFile(Constant.SERVER_PATH)
//            + ConfigManager.getValueFormFile(Constant.CARDEVENT_URL);
    String urlStr = "http://wan.xianjian.com/client/Application/versionInfo.txt";
    //���뷽ʽ
    String charSetOfReq = Constant.CHAPTER_ENCODE_UTF8;
    String charSetOfResp = Constant.CHAPTER_ENCODE_UTF8;
    //�������
    String par1 = "v";
    String val1 = TimeUtil.getJsonpSuffix();

    String h_par1 = "user-Agent";
    String h_par2 = "cookie";
    String h_val1 = "Mozilla/4.0 (compatible; MSIE 5.00; Windows 98)";
    String h_val2 = "com.d2.wdaccountlist=dakeshuichong";

    public String requestTheServer(){
        String response = "";
//		��������	����	�Ƿ����	����	��ע
//		v	String	��	v=������������0������-ʱ�䣨24Сʱ�ƣ�-����-�룬��ȡ�Ա���ϵͳʱ��
        HttpParm parms = new HttpParm();
        parms.addReq(par1, val1);
        parms.addHeader(h_par1, h_val1);
//        parms.addHeader(h_par2, h_val2);
        logger.info("�ӿ������ַ��" + urlStr);
        logger.info("�ӿ����������" + parms.getReqNvPairs());
        response = HttpClientHelper.request(urlStr, parms, HttpClientHelper.REQEST_TYPE_GET);
        logger.info("�ӿ���Ӧ������"+response);
        return response;
    }

    public static void main(String[] args) {
        VersionInfo getLatestVersion = new VersionInfo();
        System.out.println(getLatestVersion.requestTheServer());
    }
}
