package com.gaige.mall.dao.impl;

import com.gaige.mall.dao.GoodsDao;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ShopCartVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaige on 2017/9/13.
 */
@Repository
public class GoodsDaoImpl implements GoodsDao{
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<GoodsVo_S> getGoodsWithPage(int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        return sqlSession.selectList(GoodsVo_S.class.getName()+".getGoodsWithPage",map);
    }

    @Override
    public Integer getGoodsCounts() {
        return sqlSession.selectOne(GoodsVo_S.class.getName()+".goodsCount");
    }

    @Override
    public GoodsVo_S getGoods(Integer id) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        return sqlSession.selectOne(GoodsVo_S.class.getName()+".goods",map);
    }

    @Override
    public ShopCartVo getShopCartsBy2Id(int userId, int goodsId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        return sqlSession.selectOne(ShopCartVo.class.getName() + ".getShopCartsBy2Id", map);
    }

    @Override
    public void insertShopCart(int userId, int goodsId, int goodsCount) {
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        map.put("goodsCount",goodsCount);
        sqlSession.insert(ShopCartVo.class.getName()+".insertShopCart",map);
    }

    @Override
    public void updateShopCart(int userId, int goodsId, int goodsCount) {
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",userId);
        map.put("goodsId",goodsId);
        map.put("goodsCount",goodsCount);
        sqlSession.update(ShopCartVo.class.getName()+".updateShopCart",map);
    }

}
