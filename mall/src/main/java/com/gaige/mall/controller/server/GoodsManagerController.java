package com.gaige.mall.controller.server;

import com.gaige.mall.common.BaseException;
import com.gaige.mall.common.JsonResponse;
import com.gaige.mall.common.JsonResponseWarp;
import com.gaige.mall.domain.GoodsInfo;
import com.gaige.mall.service.ManagerService;
import com.gaige.mall.vo.GoodsVo_S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by gaige on 2017/9/12.
 */
@RequestMapping("/manager/goods")
@Controller
public class GoodsManagerController {

    @Autowired
    private ManagerService service;

    @Autowired
    private HttpServletRequest request;

    //获取商品列表
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    private JsonResponse fetchGoods(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
        JsonResponse jsonResponse = new JsonResponse();
        try {
            List<GoodsVo_S> goodsVo_s = service.getGoodsWithPage(pageNumber, pageSize);
            if (null == goodsVo_s || goodsVo_s.isEmpty()) {
                JsonResponseWarp.warpBusinessException(new BaseException("没有获取到商品"), jsonResponse, "获取商品失败！");
            } else {
                JsonResponseWarp.warpSuccess(jsonResponse, goodsVo_s, "获取商品成功！");
            }
        } catch (Exception e) {
            JsonResponseWarp.warpBusinessException(new BaseException(e), jsonResponse, "获取商品失败！");
        }
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping("add")
    public JsonResponse addGoods(GoodsInfo goodsInfo) throws Exception {
        System.out.println(goodsInfo.toString());
        JsonResponse jsonResponse = new JsonResponse();
        if (checkObject(goodsInfo)) {
            try {
                service.addGoods(goodsInfo);
                JsonResponseWarp.warpSuccess(jsonResponse, null, "添加成功！");
                uploadFile(goodsInfo.getPic());
            } catch (Exception e) {
                JsonResponseWarp.warpBusinessException(e, jsonResponse, "添加失败！");
                System.out.println(e.getMessage());
            }
        } else {
            JsonResponseWarp.warpBusinessException(new BaseException(), jsonResponse, "参数错误！");
        }
        return jsonResponse;
    }

    private boolean checkObject(GoodsInfo info) {
        if (null == info)
            return false;
        if (info.getCount() == 0) {
            return false;
        }
        if (info.getDesc() == null || "".equals(info.getDesc()))
            return false;
        if (info.getName() == null || "".equals(info.getName()))
            return false;
        if (info.getPrice() == null)
            return false;
        if (info.getPic() == null || "".equals(info.getPic()))
            return false;
        return true;
    }

    private void uploadFile(MultipartFile file) throws IOException{
        //获取文件路径
        String path =request.getServletContext().getRealPath("/myFile/");
        //获取文件名字
        String fileName = file.getOriginalFilename();
        File filePath = new File(path,fileName);
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        //将文件读取到里头
        file.transferTo(new File(path+"/"+fileName));
    }
}
