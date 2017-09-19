package com.gaige.mall.dao.impl;

import com.gaige.mall.dao.UserDao;
import com.gaige.mall.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaige on 2017/9/4.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserVo login(String username, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("name", username);
        map.put("password", password);
        return sqlSession.selectOne(UserVo.class.getName() + ".login", map);
    }

    @Override
    public void register(String username, String pwd, String phone, String email,String nickName) {
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",pwd);
        map.put("phone",phone);
        map.put("email",email);
        map.put("nickName",nickName);
        sqlSession.insert(UserVo.class.getName()+".register",map);
    }

    @Override
    public void updateUser(Integer shopCartId) {

    }


}
