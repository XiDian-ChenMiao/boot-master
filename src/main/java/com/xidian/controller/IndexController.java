package com.xidian.controller;

import com.xidian.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文件描述：首页控制器
 * 创建作者：陈苗
 * 创建时间：2017/6/3 13:03
 */
@RestController
public class IndexController {
    @Autowired
    private UserProperties userProperties;

    @GetMapping(value = {"/", "/index/{name}"})
    public String index(@PathVariable(value = "name", required = false) String name) {
        return "Hello Spring Boot, Please contact " + (name != null ? name : userProperties.getName()) + ", " + userProperties.getEmail();
    }
}
