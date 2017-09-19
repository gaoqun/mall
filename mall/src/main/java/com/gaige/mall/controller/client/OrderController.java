package com.gaige.mall.controller.client;

import com.gaige.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaige on 2017/9/18.
 * 下单
 */
@RequestMapping("order")
@Controller
public class OrderController {

    @Autowired
    private OrderService service;
    //生成订单
    @RequestMapping("create/{userId}")
    public void createOrder(@PathVariable("userId") int userId){
     service.createOrder(1);
    }

    //修改订单
    @RequestMapping("modify")
    public void modifyOrder(){

    }

}
