package com.jgj.drools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JavaScoreExample {
    public static void main(String[] args) throws Exception {

        List<Order> orderList = getInitData();
        for (int i=0; i<orderList.size(); i++){
            Order order = orderList.get(i);
            if (order.getAmount() <= 100){
                order.setScore(0);
                addScore(order);
            }else if(order.getAmount() > 100 && order.getAmount() <= 500){
                order.setScore(100);
                addScore(order);
            }else if(order.getAmount() > 500 && order.getAmount() <= 1000){
                order.setScore(500);
                addScore(order);
            }else{
                order.setScore(1000);
                addScore(order);
            }
        }
    }

    private static void addScore(Order o){
        System.out.println("用户" + o.getUser().getName() + "享受额外增加积分: " + o.getScore());
    }

    private static List<Order> getInitData() throws Exception {
        List<Order> orderList = new ArrayList<Order>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        {
            Order order = new Order();
            order.setAmount(80);
            order.setBookingDate(df.parse("2020-11-01"));
            User user = new User();
            user.setLevel(1);
            user.setName("Name1");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmount(200);
            order.setBookingDate(df.parse("2020-11-01"));
            User user = new User();
            user.setLevel(2);
            user.setName("Name2");
            order.setUser(user);
            orderList.add(order);
        }

        return orderList;
    }
}
