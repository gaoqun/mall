package com.gaige.mall.job;

import com.gaige.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaige on 2017/9/19.
 */
@Service
public class JobService {

    @Autowired
    private OrderService service;

    //轮询临时订单
    public void updateOrders() {
        service.updateExpiredOrdersStatus();
    }
}
