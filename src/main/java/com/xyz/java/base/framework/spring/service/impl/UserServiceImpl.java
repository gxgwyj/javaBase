package com.xyz.java.base.framework.spring.service.impl;

import com.xyz.java.base.framework.spring.dao.UserDao;
import com.xyz.java.base.framework.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author gaoxugang
 * @data 2020/2/16 0016 19:46
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 使用Inject注解（JSR330标准注解）
     */
    @Inject
    private UserDao userDao;

    @Override
    public void addUser() {
        userDao.insertUser();
    }
}
