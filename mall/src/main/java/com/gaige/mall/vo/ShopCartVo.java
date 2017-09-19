package com.gaige.mall.vo;

/**
 * Created by gaige on 2017/9/14.
 */
public class ShopCartVo {
    private int userId;
    private int goodsId;
    private int goodsCount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "ShopCartVo{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
