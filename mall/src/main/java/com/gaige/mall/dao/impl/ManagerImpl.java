package com.gaige.mall.dao.impl;

import com.gaige.mall.dao.ManagerDao;
import com.gaige.mall.domain.GoodsInfo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ManagerVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaige on 2017/9/11.
 */
@Repository
public class ManagerImpl implements ManagerDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ManagerVo login(String name, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("password", pwd);
        return sqlSession.selectOne(ManagerVo.class.getName()+".manager_login",map);
    }

    @Override
    public void addGoods(GoodsInfo goodsInfo) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",goodsInfo.getName());
        map.put("count",goodsInfo.getCount());
        map.put("desc",goodsInfo.getDesc());
        map.put("pic",goodsInfo.getPic().getOriginalFilename());
        map.put("price",goodsInfo.getPrice());
        sqlSession.insert(GoodsVo_S.class.getName()+".add_goods",map);
    }

    @Override
    public List<GoodsVo_S> getGoodsWithPage(int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        return sqlSession.selectList(GoodsVo_S.class.getName()+".getGoodsWithPage",map);
    }
}
