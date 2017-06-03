package com.xidian.service.impl;

import com.xidian.domain.UserDomain;
import com.xidian.enumeration.ResultEnum;
import com.xidian.exception.BusinessException;
import com.xidian.repository.UserRepository;
import com.xidian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件描述：用户业务逻辑实现类
 * 创建作者：陈苗
 * 创建时间：2017/6/3 17:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * 获取年龄
     *
     * @param id
     * @throws Exception
     */
    @Override
    public Integer getAge(Integer id) throws Exception {
        UserDomain userDomain = userRepository.findOne(id);
        if (userDomain == null)
            throw new BusinessException(ResultEnum.SUCCESS);
        else {
            Integer age = userDomain.getAge();
            if (age < 10)
                throw new BusinessException(ResultEnum.PRIMARY_SCHOOL);
            else if (age > 10 && age < 16)
                throw new BusinessException(ResultEnum.MIDDLE_SCHOOL);
            return age;
        }
    }
}
