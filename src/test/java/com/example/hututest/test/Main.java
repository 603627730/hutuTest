package com.example.hututest.test;

import org.apache.catalina.AsyncDispatcher;
import org.apache.commons.compress.utils.Lists;
import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        String s = "32133333";
        s = s.replaceAll("(\\d{4}).*(\\d{4})", "$1****$2");
        System.out.println(s);


    }
}
