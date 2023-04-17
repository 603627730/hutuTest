package com.example.hututest.config;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author yantonghui
 * @date 2023/4/13 9:39 AM
 */
@Data
public class Payment {
    private String id;
    private String name;
    private String type;
    private String status;
    private String amount;
    private String currency;


}
