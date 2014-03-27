package org.dawneye.xjrobot.util;

import org.dawneye.util.DateFormater;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by sandman on 14-3-8.
 */
public class TimeUtil {

    public static int getDaysNumOfTheYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static String getJsonpSuffix(){
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(getDaysNumOfTheYear() - 1);
        stringBuffer.append("-").append(DateFormater.dateToString(DateFormater.FORMART6, new Date()));
        return stringBuffer.toString();
    }

    public static String getJsonpTimeStampSuffix(){
        return String.valueOf(new Date().getTime());
    }
    public static String getJsonpTimeStampLaterSuffix(){
        return String.valueOf(new Date().getTime() + Math.abs(new Random(1000).nextInt()));
    }

    public static void main(String[] args){
        System.out.println(TimeUtil.getJsonpSuffix());
    }
}
