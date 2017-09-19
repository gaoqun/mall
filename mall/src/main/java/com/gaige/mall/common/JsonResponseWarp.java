package com.gaige.mall.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonResponseWarp {
    private static final Logger log = LoggerFactory.getLogger(JsonResponseWarp.class);

    /**
     * warp exception data
     */
    public static void warpBusinessException(Exception e,JsonResponse jsonResponse,String exceptionMsg){
        jsonResponse.setMsg(exceptionMsg);

        if (e!=null && e instanceof BusinessException){
            jsonResponse.setMsg(e.getMessage());
            log.debug(e.getMessage());
        }

        jsonResponse.setStatus(ResponseStatus.BIZ_ERR);
        LogUtils.logError(exceptionMsg, e);
        jsonResponse.setCode("202");
    }

    /**
     * warp the normal returned json data
     */
    public static void warpSuccess(JsonResponse jsonResponse,Object result,String msg){
        jsonResponse.setData(result);
        jsonResponse.setMsg(msg);
        jsonResponse.setCode("200");
        log.info(JSON.toJSONString(result));
        jsonResponse.setStatus(ResponseStatus.Ok);
    }
}
