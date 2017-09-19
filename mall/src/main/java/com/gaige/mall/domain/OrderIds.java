package com.gaige.mall.domain;

import java.util.List;

/**
 * Created by gaige on 2017/9/19.
 */
public class OrderIds {

    private int status;

    private List<Integer> ids;

    public OrderIds(int status, List<Integer> ids) {
        this.status = status;
        this.ids = ids;
    }

    public List<Integer> getIds() {
        if (ids!=null&&ids.isEmpty())return null;
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
