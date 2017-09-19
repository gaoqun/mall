package com.gaige.mall.dao;

import com.gaige.mall.domain.GoodsInfo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ManagerVo;

import java.util.List;

/**
 * Created by gaige on 2017/9/11.
 */
public interface ManagerDao {

    //管理员登录
    ManagerVo login(String name, String pwd);

    //add goods
    void  addGoods(GoodsInfo goodsInfo);

    //get goods
    List<GoodsVo_S> getGoodsWithPage(int pageIndex,int pageSize);
}
