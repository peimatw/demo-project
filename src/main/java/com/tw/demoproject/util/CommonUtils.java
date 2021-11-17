package com.tw.demoproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }


}
