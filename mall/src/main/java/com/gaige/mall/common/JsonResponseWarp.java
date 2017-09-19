package com.gaige.mall.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JsonResponseWarp {
    private static final Log log = LogFactory.getLog(JsonResponseWarp.class);

    /**
     * warp exception data
     */
    public static void warpBusinessException(Exception e,JsonResponse jsonResponse,String exceptionMsg){
        jsonResponse.setMsg(exceptionMsg);

        if (e!=null && e instanceof BusinessException){
            jsonResponse.setMsg(e.getMessage());
        }

        jsonResponse.setStatus(ResponseStatus.BIZ_ERR);
        jsonResponse.setCode("202");
    }

    /**
     * warp the normal returned json data
     */
    public static void warpSuccess(JsonResponse jsonResponse,Object result,String msg){
        jsonResponse.setData(result);
        jsonResponse.setMsg(msg);
        jsonResponse.setCode("200");
        jsonResponse.setStatus(ResponseStatus.Ok);
    }
}
