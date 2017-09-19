package com.gaige.mall.service;

import com.gaige.mall.domain.GoodsInfo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ManagerVo;

import java.util.List;

/**
 * Created by gaige on 2017/9/11.
 */
public interface ManagerService {

    ManagerVo login(String name,String pwd);

    void addGoods(GoodsInfo goodsInfo);

    List<GoodsVo_S> getGoodsWithPage(int pageNumber,int pageSize);
}
