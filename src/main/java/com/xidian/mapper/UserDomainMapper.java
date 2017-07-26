package com.xidian.mapper;

import com.xidian.domain.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 文件描述：
 * 创建作者：陈苗
 * 创建时间：2017/7/25 19:25
 */
@Mapper
@Repository
public interface UserDomainMapper {

    UserDomain find(@Param("id") Integer id);
}
