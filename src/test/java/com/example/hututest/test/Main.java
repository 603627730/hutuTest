package com.example.hututest.test;

import com.example.hututest.config.Payment;
import com.example.hututest.io.UserController;
import com.example.hututest.mockito.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.formatPhoneNumber("+1", "1234567890"));
        System.out.println(main.formatPhoneNumber("+1", "1234"));
        System.out.println(main.formatPhoneNumber("+1", null));
        System.out.println(main.formatPhoneNumber(null, "1234567890"));
        System.out.println(main.formatPhoneNumber(null, "4322"));

    }

    public String formatPhoneNumber(String countryCode, String phoneNumber) {
        StringBuilder number = new StringBuilder();
        if (StringUtils.isNotBlank(countryCode)) {
            number.append(countryCode);
        }
        if (StringUtils.isNotBlank(phoneNumber)) {
            if (phoneNumber.length() < 7) {
                number.append(phoneNumber);
            }
            else {
                number.append("(").append(phoneNumber.substring(0, 3)).append(")").append(phoneNumber.substring(3, 6)).append("-").append(phoneNumber.substring(6));
            }
        }

        return number.toString();
    }


    public String getTime(int days) {
        Date dateStart = getCurrentDateZeroTime();
        System.out.println(dateStart);
        Date dateEnd = DateUtils.addDays(dateStart, -days);
        dateEnd = DateUtils.addSeconds(dateEnd, 1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return df.format(dateEnd) + " ~ " + df.format(dateStart);
    }

    private Date getCurrentDateZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }
    private static Date getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        return calendar.getTime();
    }
}
