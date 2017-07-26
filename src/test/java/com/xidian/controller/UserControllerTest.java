package com.xidian.controller;

import com.xidian.domain.UserDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 文件描述：控制器测试类
 * 创建作者：陈苗
 * 创建时间：2017/6/3 18:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void find() {
        int userid = 1;
        UserDomain userDomain = restTemplate.getForObject("http://localhost:" + port + "/boot/users/" + userid, UserDomain.class);
        Assert.assertEquals(userDomain.getAge(), Integer.valueOf(25));
    }
}