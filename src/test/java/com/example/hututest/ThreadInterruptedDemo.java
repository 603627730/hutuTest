package com.example.hututest;


import com.example.hututest.io.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ThreadInterruptedDemo {

    @Test
    public void test() throws IOException {
        assertDoesNotThrow(() -> {
            this.toString(1);
        });
    }

    public String toString(int a) {
        if (a == 0){
            throw new RuntimeException("abc");
        }
        return "abc";
    }
}