package com.example.hututest.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateConversionExample {
    public static void main(String[] args) {
        String dateString = "4/30/2023";
        Date date = convertToDate(dateString);
        System.out.println(date);
        Date date1 = new Date();
        System.out.println(convertToString(date1));
    }

    public static Date convertToDate(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH);
        String dateString = format.format(date);
        String amPm = dateString.substring(dateString.length() - 2);
        return dateString.replace(amPm, amPm.toUpperCase());
    }
    public String getTime(int days) {
        Date dateStart = getCurrentDateZeroTime();
        Date dateEnd = DateUtils.addDays(dateStart, -days);
        dateEnd = DateUtils.addSeconds(dateEnd, 1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return df.format(dateEnd) + " ~ " + df.format(dateStart);
    }

    private Date getCurrentDateZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }
}
