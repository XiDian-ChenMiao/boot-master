package com.xidian.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * 文件描述：用户实体
 * 创建作者：陈苗
 * 创建时间：2017/6/3 13:48
 */
@Entity(name = "tb_user")
public class UserDomain {
    /**
     * 主键ID，自增
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    @Min(value = 18, message = "未成年人不准注册")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDomain() {
    }

    public UserDomain(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDomain(Integer id, String username, String password) {
        this(username, password);
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
