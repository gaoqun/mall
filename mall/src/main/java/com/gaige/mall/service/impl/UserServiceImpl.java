package com.gaige.mall.service.impl;

import com.gaige.mall.dao.UserDao;
import com.gaige.mall.service.UserService;
import com.gaige.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaige on 2017/9/4.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public UserVo login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public void register(String username, String pwd, String phone, String email,String nickName) {
        userDao.register(username,pwd,phone,email,nickName);
    }
}
