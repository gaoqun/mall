package com.gaige.mall.dao;

import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ShopCartVo;

import java.util.List;

/**
 * Created by gaige on 2017/9/13.
 */
public interface GoodsDao {
    //get goods
    List<GoodsVo_S> getGoodsWithPage(int pageIndex, int pageSize);

    //count goods
    Integer getGoodsCounts();

    //goods detail
    GoodsVo_S getGoods(Integer id);

    ShopCartVo getShopCartsBy2Id(int userId,int goodsId);

    void insertShopCart(int userId,int goodsId,int goodsCount);

    void updateShopCart(int userId,int goodsId,int goodsCount);

}
