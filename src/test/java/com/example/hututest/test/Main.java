package com.example.hututest.test;

import com.example.hututest.config.Payment;
import com.example.hututest.io.UserController;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Payment> payment = Optional.empty();
        if (payment.isPresent()){

            System.out.println(payment.get());
        }
        Payment payment1 = payment.orElse(new Payment());
        System.out.println(payment1);

    }
}
