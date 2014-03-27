package org.dawneye.xjrobot.interfaces;

import org.apache.log4j.Logger;
import org.dawneye.util.HttpClientHelper;
import org.dawneye.util.HttpParm;
import org.dawneye.xjrobot.util.Constant;
import org.dawneye.xjrobot.util.HtmlParserUtil;
import org.dawneye.xjrobot.util.TimeUtil;

import java.util.List;


/**
 * Created by sandman on 14-3-8.
 */
public class Client {
    private static final Logger logger = Logger.getLogger(Client.class);
    //�����ַ
//    String urlStr = ConfigManager.getValueFormFile(Constant.SERVER_PATH)
//            + ConfigManager.getValueFormFile(Constant.CARDEVENT_URL);
    String urlStr = "http://www.xianjian.com/client";
    private static String path = "D:\\projects\\xjRobot\\temp\\";
    //���뷽ʽ
    String charSetOfReq = Constant.CHAPTER_ENCODE_UTF8;
    String charSetOfResp = Constant.CHAPTER_ENCODE_UTF8;
    //�������
    String par1 = "";
    String par2 = "channel";
    String val1 = TimeUtil.getJsonpSuffix();
    String val2 = "xinxianjian_v1.12.exe";

    String h_par1 = "user-Agent";
    String h_par2 = "cookie";
    String h_val1 = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0)";
    String h_val2 = "com.d2.wdaccountlist=dakeshuichong";

    public String requestTheServer(){
        String response = "";
//		��������	����	�Ƿ����	����	��ע
//		v	String	��	v=������������0������-ʱ�䣨24Сʱ�ƣ�-����-�룬��ȡ�Ա���ϵͳʱ��
        HttpParm parms = new HttpParm();
        parms.addReq(par1, val1);
        parms.addReq(par2, val2);
        parms.addHeader(h_par1, h_val1);
//        parms.addHeader(h_par2, h_val2);
        logger.info("�ӿ����������" + parms.getReqNvPairs());
        response = HttpClientHelper.request(urlStr, parms, HttpClientHelper.REQEST_TYPE_GET);
        logger.info("�ӿ���Ӧ������"+response);
        if(null != response && !"".equals(response)){/**����ҳ����Դ*/
            //1. ��ȡ����ҳ�����Դ�б�
            List<String> resourcesUrlList = HtmlParserUtil.findAllResources(urlStr, response);
            //2. ������Դ
            for(String url: resourcesUrlList){
                //3. ������Դ��ָ��λ��
                String fileName = url.substring(url.lastIndexOf("/"),url.length());
                HttpClientHelper.downloadResourceFile(url, path + fileName);
            }
        }
        return response;
    }

    public static void main(String[] args) {
        Client getLatestVersion = new Client();
        System.out.println(getLatestVersion.requestTheServer());
    }
}
