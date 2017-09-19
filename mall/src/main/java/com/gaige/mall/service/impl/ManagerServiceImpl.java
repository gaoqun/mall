package com.gaige.mall.service.impl;

import com.gaige.mall.dao.ManagerDao;
import com.gaige.mall.domain.GoodsInfo;
import com.gaige.mall.service.ManagerService;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ManagerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaige on 2017/9/11.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerDao managerDao;
    @Override
    public ManagerVo login(String name, String pwd) {
        return managerDao.login(name,pwd);
    }

    @Override
    public void addGoods(GoodsInfo goodsInfo) {
        managerDao.addGoods(goodsInfo);
    }

    @Override
    public List<GoodsVo_S> getGoodsWithPage(int pageNumber, int pageSize) {
        int pageIndex = (pageNumber-1)*pageSize;
        return managerDao.getGoodsWithPage(pageIndex, pageSize);
    }
}
