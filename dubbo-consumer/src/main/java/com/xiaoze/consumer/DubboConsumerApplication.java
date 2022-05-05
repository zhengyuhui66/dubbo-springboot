package com.xiaoze.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboConsumerApplication
 * 消费者启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "com.xiaoze.consumer.dao")
//@ComponentScan
public class DubboConsumerApplication {

    public static void main(String[] args) {
            SpringApplication.run(DubboConsumerApplication.class, args);
//        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
//        AnnotationConfigApplicationContext acf= new AnnotationConfigApplicationContext(DubboConsumerApplication.class);
//        Car car=(Car) acf.getBean("dataMoveDatasource");
//        Car2 car2=(Car2) acf.getBean("dataMoveDatasource2");
//        System.out.println( "color:"+car.getColor()+",name:"+car.getName()+",price:"+car.getPrice());
    }
}
