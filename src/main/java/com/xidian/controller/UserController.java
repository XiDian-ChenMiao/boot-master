package com.xidian.controller;

import com.xidian.domain.ResultDomain;
import com.xidian.domain.UserDomain;
import com.xidian.repository.UserRepository;
import com.xidian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 文件描述：用户控制器
 * 创建作者：陈苗
 * 创建时间：2017/6/3 13:47
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/users")
    public List<UserDomain> get() {
        return userRepository.findAll();
    }

    /**
     * 通过用户主键获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public UserDomain getById(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    /**
     * 生成用户
     * @return
     */
    @PostMapping("/users")
    public ResultDomain<UserDomain> userAdd(@ModelAttribute("user") @Valid UserDomain user, BindingResult result) {
        if (result.hasErrors()) {
            return ResultDomain.failure(1, result.getFieldError().getDefaultMessage());
        }
        return ResultDomain.success(userRepository.save(user));
    }

    /**
     * 修改用户
     * @param id
     * @param name
     * @param password
     * @return
     */
    @PutMapping("/users/{id}")
    public UserDomain userModify(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("password") String password) {
        return userRepository.save(new UserDomain(id, name, password));
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/users/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userRepository.delete(id);
    }

    /**
     * 获取指定用户的年龄
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "/users/age/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        userService.getAge(id);
    }
}
