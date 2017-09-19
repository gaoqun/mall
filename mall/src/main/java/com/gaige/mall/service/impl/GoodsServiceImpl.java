package com.gaige.mall.service.impl;

import com.gaige.mall.dao.GoodsDao;
import com.gaige.mall.service.GoodsService;
import com.gaige.mall.vo.GoodsListVo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ShopCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaige on 2017/9/13.
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo_S> getGoodsWithPage(int pageNumber, int pageSize) {
        int pageIndex = (pageNumber-1)*pageSize;
        return goodsDao.getGoodsWithPage(pageIndex, pageSize);
    }

    @Override
    public GoodsListVo getLastPageGoods(Integer pageSize) {
        GoodsListVo vo = new GoodsListVo();
        int pageCount = goodsDao.getGoodsCounts();
        pageCount = pageCount == 0 ? 1 : pageCount;
        int mod = pageCount % pageSize;
        int totalPage = pageCount / pageSize;
        int pageNumber = mod == 0 ? totalPage : totalPage + 1;
        vo.setCurrentPage(pageNumber);
        int pageIndex = (pageNumber-1)*pageSize;
        List<GoodsVo_S> vos = goodsDao.getGoodsWithPage(pageIndex, pageSize);
        vo.setGoodsVo_sList(vos);
        return vo;
    }

    @Override
    public GoodsVo_S getGoods(Integer id) {
        return goodsDao.getGoods(id);
    }

    @Override
    public void add2shopCart(ShopCartVo shopCartVo) {
        int userId = shopCartVo.getUserId();
        int goodsId = shopCartVo.getGoodsId();
        int goodsCount = shopCartVo.getGoodsCount();

        if (userId <= 0 || goodsId <= 0 || goodsCount <= 0) {
            throw new IllegalArgumentException("参数错误！");
        }
        ShopCartVo vo = goodsDao.getShopCartsBy2Id(userId, goodsId);
        if (null == vo) {
            goodsDao.insertShopCart(userId, goodsId, goodsCount);
        } else {
            goodsDao.updateShopCart(userId, goodsId, goodsCount);
        }
    }


}
