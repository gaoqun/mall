package com.gaige.mall.controller.server;

import com.gaige.mall.common.BaseException;
import com.gaige.mall.common.JsonResponse;
import com.gaige.mall.common.JsonResponseWarp;
import com.gaige.mall.service.ManagerService;
import com.gaige.mall.service.UserService;
import com.gaige.mall.vo.ManagerVo;
import com.gaige.mall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by gaige on 2017/9/8.
 */
@RequestMapping("manager")
@Controller
public class ManagerController {
    @Autowired
    private HttpServletRequest request;


    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService service;

    @RequestMapping("index")
    public String loginPage() {
        return "/WEB-INF/pages/login.jsp";
    }

    @RequestMapping("menu")
    public String managerMenu() {
        return "/WEB-INF/pages/menu.jsp";
    }

    /**
     * login
     *
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResponse login(@RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password,
                              HttpSession httpSession) {
        JsonResponse jsonResponse = new JsonResponse();
        try {
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "参数错误！");
            } else {
                ManagerVo vo = service.login(username, password);
                if (vo == null) {
                    JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "密码错误！");
                } else {
                    if (vo.getIdentity() == 0) {
                        JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "没有权限！");
                    } else {
                        httpSession.setAttribute("userInfo", vo);
                        JsonResponseWarp.warpSuccess(jsonResponse, vo, "获取信息成功！");
                    }
                }
            }
        } catch (Exception e) {
            JsonResponseWarp.warpBusinessException(e, jsonResponse, "获取信息失败！");
        }
        return jsonResponse;
    }


    @ResponseBody
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public JsonResponse login1(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession httpSession) {
        JsonResponse jsonResponse = new JsonResponse();
        try {
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "参数错误！");
            } else {
                UserVo vo = userService.login(username, password);
                if (vo==null){
                    JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "密码错误！");
                }else {
                    httpSession.setAttribute("userInfo", vo);
                    JsonResponseWarp.warpSuccess(jsonResponse, vo, "获取信息成功！");
                }
            }
        } catch (Exception e) {
            JsonResponseWarp.warpBusinessException(e, jsonResponse, "获取信息失败！");
        }
        return jsonResponse;
    }

}
