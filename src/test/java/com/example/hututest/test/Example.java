package com.example.hututest.test;

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
        Object o = Optional.ofNullable("null").orElse("");
        System.out.println(o);
    }

    public static Date minus(long miniSecconds) {
        Date date = new Date();
        date.setTime(date.getTime() - miniSecconds);
        return date;
    }


}
