package com.gaige.mall.service.impl;

import com.gaige.mall.dao.OrderDao;
import com.gaige.mall.domain.Order;
import com.gaige.mall.domain.OrderIds;
import com.gaige.mall.domain.TempOrder;
import com.gaige.mall.service.OrderService;
import com.gaige.mall.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by gaige on 2017/9/18.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    private static SimpleDateFormat sdfSimple = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void createOrder(int userId) {
        if (userId<=0){
            throw new IllegalArgumentException("参数错误！");
        }
        Order order = new Order();
        Calendar calendar = Calendar.getInstance();
        String preCode = sdfSimple.format(calendar.getTime());
        String random12Bits = Util.getStringRandom(12);
        String code = preCode+random12Bits;
        order.setCode(code);
        order.setStatus(1);
        order.setUserId(userId);
        calendar.set(Calendar. HOUR , Calendar. HOUR +24 );
        String expiredTime = sdf.format(calendar.getTime());
        order.setExpiredTime(expiredTime);
        orderDao.createOrder(order);
        TempOrder tempOrder = new TempOrder();
        System.out.println("order_id===="+order.getOrderId());
        tempOrder.setOrderId(order.getOrderId());
        tempOrder.setExpiredTime(expiredTime);
        orderDao.createOrderInTempTable(tempOrder);
    }

    @Override
    public void deleteExpiredOrder() {
        List<Integer> ids = orderDao.getExpiredOrderIds();
        OrderIds orderIds = new OrderIds(0, ids);
        orderDao.deleteTempOrder(orderIds);
    }

    @Override
    public void updateExpiredOrdersStatus() {
        List<Integer> ids = orderDao.getExpiredOrderIds();
        OrderIds orderIds = new OrderIds(0, ids);
        orderDao.deleteTempOrder(orderIds);//删除临时表过期数据
        orderDao.updateExpiredOrders(orderIds);//更新订单表订单状态为过期
    }

}
