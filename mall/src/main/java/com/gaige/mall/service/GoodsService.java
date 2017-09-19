package com.gaige.mall.service;

import com.gaige.mall.vo.GoodsListVo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ShopCartVo;

import java.util.List;

/**
 * Created by gaige on 2017/9/13.
 */
public interface GoodsService {
    List<GoodsVo_S> getGoodsWithPage(int pageNumber, int pageSize);

    GoodsListVo getLastPageGoods(Integer pageSize);

    GoodsVo_S getGoods(Integer id);

    void add2shopCart(ShopCartVo shopCartVo);

}
