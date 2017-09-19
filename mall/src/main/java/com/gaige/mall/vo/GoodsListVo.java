package com.gaige.mall.vo;

import java.util.List;

/**
 * Created by gaige on 2017/9/14.
 */
public class GoodsListVo {
    private List<GoodsVo_S> goodsVo_sList;
    private Integer currentPage;

    public List<GoodsVo_S> getGoodsVo_sList() {
        return goodsVo_sList;
    }

    public void setGoodsVo_sList(List<GoodsVo_S> goodsVo_sList) {
        this.goodsVo_sList = goodsVo_sList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
