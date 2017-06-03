package com.xidian.service.impl;

import com.xidian.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 文件描述：用户业务逻辑测试类
 * 创建作者：陈苗
 * 创建时间：2017/6/3 18:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getAge() throws Exception {
        Integer age = userService.getAge(1);
        Assert.assertEquals(age, new Integer(19));
    }
}