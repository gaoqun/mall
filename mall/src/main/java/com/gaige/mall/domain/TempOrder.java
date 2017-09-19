package com.gaige.mall.domain;

import java.util.Date;

/**
 * Created by gaige on 2017/9/18.
 */
public class TempOrder {
    private Integer orderId;
    private String expiredTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
}
