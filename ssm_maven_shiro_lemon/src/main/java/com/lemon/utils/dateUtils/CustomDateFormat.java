package com.lemon.utils.dateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormat  {

    public static String dateFormat(Date date,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat (format);
        String da = simpleDateFormat.format ( date );
            return da;
    }


}
