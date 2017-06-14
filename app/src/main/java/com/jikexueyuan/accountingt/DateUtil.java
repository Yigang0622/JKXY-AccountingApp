package com.jikexueyuan.accountingt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mike on 14/06/2017.
 */

public class DateUtil {

    public  static String getFormattedTime(long timeStamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date (timeStamp));
    }


    public static String getDateStr(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        return formatter.format(curDate);
    }


}
