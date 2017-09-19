package com.gaige.mall.dao;

import com.gaige.mall.domain.Order;
import com.gaige.mall.domain.OrderIds;
import com.gaige.mall.domain.TempOrder;

import java.util.List;

/**
 * Created by gaige on 2017/9/18.
 */
public interface OrderDao {

    void createOrder(Order order);

    void updateOrderStatus(Order order);

    void createOrderInTempTable(TempOrder tempOrder);

    void deleteTempOrder(OrderIds ids);

    List<Integer> getExpiredOrderIds();

    void updateExpiredOrders(OrderIds ids);

}
