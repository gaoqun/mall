package com.gaige.mall.common;

import java.io.Serializable;

/**
 * warp the returned json data
 * @param <T>
 */
public class JsonResponse<T> implements Serializable{

    private String msg;

    private ResponseStatus status;

    private String code;

    public String getMsg() {
        return msg;
    }

    private T data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
