package com.xiaoze.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoze.api.service.DemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * DemoConsumerController
 * 消费者控制层
 * @author xiaoze
 * @date 2018/6/7
 */
@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name, HttpServletResponse servletResponse) {
        servletResponse.setStatus(10000);
        String str=demoService.sayHello(name);
        return str;
    }

    public static void main(String[] args) {
        try {
            ServerSocket ServerSocket=new ServerSocket(9091,100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
