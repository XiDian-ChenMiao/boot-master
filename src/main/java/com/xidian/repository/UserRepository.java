package com.xidian.repository;

import com.xidian.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文件描述：用户数据库访问仓库接口
 * 创建作者：陈苗
 * 创建时间：2017/6/3 13:59
 */
public interface UserRepository extends JpaRepository<UserDomain, Integer> {
}
