package com.gaige.mall.controller.client;

import com.gaige.mall.common.BaseException;
import com.gaige.mall.common.JsonResponse;
import com.gaige.mall.common.JsonResponseWarp;
import com.gaige.mall.service.UserService;
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
 * Created by gaige on 2017/9/1.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    /**
     * login
     *
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResponse login(@RequestParam String username,
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

    @RequestMapping("forgetPwd")
    public String forgetPwd() {
        return "/WEB-INF/pages/forgot_pwd.jsp";
    }

    /**
     * register action
     *
     * @param username
     * @param pwd
     * @param phone
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public JsonResponse registerUser(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "pwd", required = false) String pwd,
                                     @RequestParam(value = "phone", required = false) String phone,
                                     @RequestParam(value = "email", required = false) String email,
                                     @RequestParam(value = "nickName")String nickName) {
        JsonResponse response = new JsonResponse();
        if (null == username || "".equals(username) || null == pwd || "".equals(pwd) || null == phone || "".equals(phone) || null == email || "".equals(email)|| null == nickName || "".equals(nickName)) {
            JsonResponseWarp.warpBusinessException(new BaseException(), response, "参数错误!");
        }
        try {
            userService.register(username, pwd, phone, email,nickName);
            JsonResponseWarp.warpSuccess(response, null, "注册成功！");
        } catch (Exception e) {
            JsonResponseWarp.warpBusinessException(e, response, "注册失败！");
        }
        return response;
    }
}
