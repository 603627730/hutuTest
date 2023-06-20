package com.example.hututest.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;


public class Example {

    public static final String MM_YY = "MMYY";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String TIMEZONE_NEWYORK = "America/New_York";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        String fingerprint = "dfasfsafasfas";
        String regex = "(?<=\\w{4}).*(?=\\w{4})";
        System.out.println(fingerprint.replaceAll(regex, "**"));


//        Example example = new Example();
//
//        System.out.println(example.getTime(1));
    }

    public String getTime(int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return df.format(date) + " ~ " + df.format(new Date());
    }

    public static Date minus(long miniSecconds) {
        Date date = new Date();
        date.setTime(date.getTime() - miniSecconds);
        return date;
    }


}
