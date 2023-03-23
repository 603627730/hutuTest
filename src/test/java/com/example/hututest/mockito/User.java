package com.example.hututest.mockito;

import java.util.ArrayList;

public class User {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.remove("1");
        System.out.println(s.size());
    }
}
