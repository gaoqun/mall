package com.gaige.mall.dao.impl;

import com.gaige.mall.dao.OrderDao;
import com.gaige.mall.domain.Order;
import com.gaige.mall.domain.OrderIds;
import com.gaige.mall.domain.TempOrder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaige on 2017/9/18.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void createOrder(Order order) {
        sqlSession.insert(Order.class.getName() + ".createOrder", order);
    }

    @Override
    public void updateOrderStatus(Order order) {
        sqlSession.update(Order.class.getName() + ".updateOrderStatus", order);

    }

    @Override
    public void createOrderInTempTable(TempOrder tempOrder) {
        sqlSession.insert(Order.class.getName() + ".createOrderInTempTable", tempOrder);
    }

    @Override
    public void deleteTempOrder(OrderIds ids) {
        sqlSession.delete(Order.class.getName() + ".deleteTempOrder", ids);
    }

    @Override
    public List<Integer> getExpiredOrderIds() {
       return sqlSession.selectList(Order.class.getName() + ".getExpiredOrders");
    }

    @Override
    public void updateExpiredOrders(OrderIds ids) {
        sqlSession.update(Order.class.getName() + ".updateExpiredOrders",ids);
    }
}
