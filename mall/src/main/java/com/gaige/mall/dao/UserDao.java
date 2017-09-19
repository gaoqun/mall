package com.gaige.mall.dao;

import com.gaige.mall.vo.UserVo;

/**
 * Created by gaige on 2017/9/1.
 */
public interface UserDao {

    UserVo login(String username,String password);

    void register(String username,String pwd,String phone,String email,String nickName);

    void updateUser(Integer shopCartId);

}
