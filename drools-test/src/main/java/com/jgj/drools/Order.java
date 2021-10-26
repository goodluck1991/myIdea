package com.jgj.drools;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer amount;

    private Integer score;

    private Date bookingDate;

    private User user;
}
