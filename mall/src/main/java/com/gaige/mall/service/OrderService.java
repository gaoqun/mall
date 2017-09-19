package com.gaige.mall.service;

/**
 * Created by gaige on 2017/9/18.
 */
public interface OrderService {

    void createOrder(int userId);

    void deleteExpiredOrder();

    void updateExpiredOrdersStatus();

}
