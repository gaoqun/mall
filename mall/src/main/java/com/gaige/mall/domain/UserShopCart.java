package com.gaige.mall.domain;

/**
 * Created by gaige on 2017/9/14.
 */
public class UserShopCart {

    private Integer userId;
    private Integer shopCartId;
    private Integer goodsCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Integer shopCartId) {
        this.shopCartId = shopCartId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "UserShopCart{" +
                "userId=" + userId +
                ", shopCartId=" + shopCartId +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
