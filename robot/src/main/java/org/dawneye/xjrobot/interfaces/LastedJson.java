package org.dawneye.xjrobot.interfaces;

import org.apache.log4j.Logger;
import org.dawneye.util.HttpClientHelper;
import org.dawneye.util.HttpParm;
import org.dawneye.xjrobot.util.Constant;
import org.dawneye.xjrobot.util.TimeUtil;

import java.util.Random;


/**
 * Created by sandman on 14-3-8.
 */
public class LastedJson {
    private static final Logger logger = Logger.getLogger(LastedJson.class);
    //�����ַ
//    String urlStr = ConfigManager.getValueFormFile(Constant.SERVER_PATH)
//            + ConfigManager.getValueFormFile(Constant.CARDEVENT_URL);
    String urlStr = "http://register.xianjian.com/lasted-json";
    //���뷽ʽ
    String charSetOfReq = Constant.CHAPTER_ENCODE_UTF8;
    String charSetOfResp = Constant.CHAPTER_ENCODE_UTF8;
    //�������
    String par1 = "cb";
    String par2 = "_";
    String val1 = "jsonp" + TimeUtil.getJsonpTimeStampSuffix();
    String val2 = TimeUtil.getJsonpTimeStampLaterSuffix();

    String h_par1 = "Accept";
    String h_par2 = "Accept-Encoding";
    String h_par3 = "Accept-Language";
    String h_par4 = "Connection";
    String h_par5 = "Cookie";
    String h_par6 = "Host";
    String h_par7 = "User-Agent";
    String h_par8 = "Cache-Control";
    String h_val1 = "Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8";
    String h_val2 = "gzip,deflate,sdch";
    String h_val3 = "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4";
    String h_val4 = "keep-alive";
    String h_val5 = "Hm_lvt_240ace018d641b41c0338847d7a72564=1390310970; Hm_lvt_29af9240ae31dd1dda2a695bbccc4c27=1390310969,1392542391; JSESSIONID=B4E2BDC2325E743DE8376E39A05F278F; txsf=df2b80dc43705d28db9be6f29fe58da3; regsiter=3674607788.20480.0000";
    String h_val6 = "register.xianjian.com";
    String h_val7 = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36";
    String h_val8 = "max-age=0";

    public String requestTheServer(){
        String response = "";
//		��������	����	�Ƿ����	����	��ע
//		v	String	��	v=������������0������-ʱ�䣨24Сʱ�ƣ�-����-�룬��ȡ�Ա���ϵͳʱ��
        HttpParm parms = new HttpParm();
        parms.addReq(par1, val1);
        parms.addReq(par2, val2);
        parms.addHeader(h_par1, h_val1);
        parms.addHeader(h_par2, h_val2);
        parms.addHeader(h_par3, h_val3);
        parms.addHeader(h_par4, h_val4);
        parms.addHeader(h_par5, h_val5);
        parms.addHeader(h_par6, h_val6);
        parms.addHeader(h_par7, h_val7);
        parms.addHeader(h_par8, h_val8);
        logger.info("�ӿ������ַ��" + urlStr);
        logger.info("�ӿ����������" + parms.getReqNvPairs());
        response = HttpClientHelper.request(urlStr, parms, HttpClientHelper.REQEST_TYPE_GET);
        logger.info("�ӿ���Ӧ������"+response);
        return response;
    }

    public static void main(String[] args) {
        LastedJson getLatestVersion = new LastedJson();
        System.out.println(getLatestVersion.requestTheServer());
    }
}
