package com.xiaoze.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.xiaoze.api.service.DemoService;
import com.xiaoze.provider.dao.UserMapper;
import com.xiaoze.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
/**
 * DemoServiceImpl
 * 服务提供类
 * @author xiaoze
 * @date 2018/6/7
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String sayHello(String name) {
        List<User> list= userMapper.selectUser();
        return "Hello, " + name + " (from Spring Boot)"+ JSONObject.toJSONString(list);
    }
}
