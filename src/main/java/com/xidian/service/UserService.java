package com.xidian.service;

/**
 * 文件描述：用户业务逻辑接口
 * 创建作者：陈苗
 * 创建时间：2017/6/3 14:24
 */
public interface UserService {
    /**
     * 获取年龄
     * @param id
     * @throws Exception
     * @return
     */
    Integer getAge(Integer id) throws Exception;
}
