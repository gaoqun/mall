
package com.gaige.mall.common;

import com.alibaba.fastjson.JSON;
import com.gaige.mall.util.ControllerUtil;
import com.gaige.mall.util.ReflectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by raolin on 17/4/7.
 */
public class LogUtils {
    protected static final Logger COMMENT = LoggerFactory.getLogger("comment-logger");
    protected static final Logger COMMENT_ERROR = LoggerFactory.getLogger("comment-logger-error");
    public static final Logger ERROR_LOG = LoggerFactory.getLogger("health-manager-error");
    public static final Logger ACCESS_LOG = LoggerFactory.getLogger("health-manager-access");

    public static void logAccess(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            String jsessionId = request.getRequestedSessionId();
            String ip = ControllerUtil.getRemoteHost(request);
            String accept = request.getHeader("accept");
            String userAgent = request.getHeader("User-Agent");
            String url = request.getRequestURI();
            String params = getParams(request);
            String headers = getHeaders(request);
            String payload = getRequestPayload(request);
            Object status = ReflectionUtils.getFieldValue(httpServletResponse, "status");
            StringBuilder s = new StringBuilder();
            s.append(getBlock(jsessionId));
            //默认为200
            s.append(getBlock("0".equals(String.valueOf(status))?200:status));
            s.append(getBlock(ip));
            s.append(getBlock(accept));
            s.append(getBlock(userAgent));
            s.append(getBlock(url));
            s.append(getBlock(params));
            s.append(getBlock(headers));
            s.append(getBlock(payload));
            s.append(getBlock(request.getHeader("Referer")));
            ACCESS_LOG.info(s.toString());
        }catch (Exception e){
            ERROR_LOG.error("logAccess方法出错！", e);
        }
    }

    /**
     * 记录异常错误
     * 格式 [exception]
     *
     * @param message
     * @param e
     */
    public static void logError(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append(getBlock("exception"));
        s.append(getBlock(message));
        ERROR_LOG.error(s.toString(), e);
    }
    private static String  getRequestPayload(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = req.getReader();) {
            char[]buff = new char[1024];
            int len;
            while((len = reader.read(buff)) != -1) {
                sb.append(buff,0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private static String getHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = Maps.newHashMap();
        Enumeration<String> namesEnumeration = request.getHeaderNames();
        while(namesEnumeration.hasMoreElements()) {
            String name = namesEnumeration.nextElement();
            Enumeration<String> valueEnumeration = request.getHeaders(name);
            List<String> values = Lists.newArrayList();
            while(valueEnumeration.hasMoreElements()) {
                values.add(valueEnumeration.nextElement());
            }
            headers.put(name, values);
        }
        return JSON.toJSONString(headers);
    }
    protected static String getParams(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        return JSON.toJSONString(params);
    }
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }


    public static void commentError(String message, Throwable e) {
        COMMENT_ERROR.error(message, e);
    }
    public static void commentError(String message) {
        COMMENT_ERROR.error(message);
    }
    public static void commentInfo(String message) {
        COMMENT.info(message);
    }
   
}
