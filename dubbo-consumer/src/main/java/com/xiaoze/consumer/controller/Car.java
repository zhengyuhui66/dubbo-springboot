package com.xiaoze.consumer.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

@Component("dataMoveDatasource")
public class Car implements InitializingBean {
    private String name;
    private double price;
    private String color;

    @PostConstruct
    public void stest(){
        System.out.println("car:init");
    }
//
//    public Car(String name, double price, String color) {
//        this.name = name;
//        this.price = price;
//        this.color = color;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------------------1");
    }

    public static void main(String[] args) {
        BigDecimal i1=switchs(2021,2,8,2021,11,25,BigDecimal.valueOf(10000));
        BigDecimal i2=switchs(2021,3,6,2021,10,26,BigDecimal.valueOf(20000));
        BigDecimal i3=switchs(2021,3,6,2021,10,10,BigDecimal.valueOf(50000));
        BigDecimal i4=switchs(2021,3,6,2022,1,27,BigDecimal.valueOf(20000));

        System.out.println(" i1:"+i1);
        System.out.println(" i2:"+i2);
        System.out.println(" i3:"+i3);
        System.out.println(" i4:"+i4);
        BigDecimal m=i1.add(i2).add(i3).add(i4);
        System.out.println("总利息:"+m);


    }

    private static BigDecimal switchs(int year1,int month1,int day1,int year2,int month2,int day2,BigDecimal money){
        Calendar calendar1=Calendar.getInstance();
        calendar1.set(year1,month1,day1);
        Calendar calendar2=Calendar.getInstance();
        calendar2.set(year2,month2,day2);
        long beginTime = calendar1.getTime().getTime();
        long endTime = calendar2.getTime().getTime();
        long betweenDays = (long)((endTime - beginTime) / (1000 * 60 * 60 *24));
        BigDecimal yearRate=new BigDecimal("0.0325");
        BigDecimal rate=yearRate.divide(BigDecimal.valueOf(365),10, RoundingMode.HALF_DOWN);
        BigDecimal totalRate=rate.multiply(BigDecimal.valueOf(betweenDays));
        BigDecimal bigDecimal=money.multiply(totalRate);
        return bigDecimal;
    }
}
