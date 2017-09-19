package com.gaige.mall.controller.client;

import com.gaige.mall.common.BaseException;
import com.gaige.mall.common.JsonResponse;
import com.gaige.mall.common.JsonResponseWarp;
import com.gaige.mall.service.GoodsService;
import com.gaige.mall.vo.GoodsListVo;
import com.gaige.mall.vo.GoodsVo_S;
import com.gaige.mall.vo.ShopCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaige on 2017/9/8.
 */
@RequestMapping("goods")
@Controller
public class GoodsController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodsService service;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String getGoods(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<GoodsVo_S> goodsVo_s = new ArrayList<>();
        try {
            List<GoodsVo_S> goodsVoS = service.getGoodsWithPage(pageNumber, pageSize);
            if (goodsVoS != null) {
                goodsVo_s.addAll(goodsVoS);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("goods", goodsVo_s);
            request.setAttribute("filePath", "file:" + request.getServletContext().getRealPath("/myFile/"));
        }
        return "index";
    }

    //跳转到最后一页
    @RequestMapping(value = "lastPage", method = RequestMethod.GET)
    public String jump2LastPage(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<GoodsVo_S> goodsVo_s = null;
        int totalPage = 1;
        try {
            GoodsListVo vo = service.getLastPageGoods(pageSize);
            List<GoodsVo_S> vos = vo.getGoodsVo_sList();
            if (vo != null) {
                totalPage = vo.getCurrentPage();
                if (vos != null) {
                    goodsVo_s = new ArrayList<>();
                    goodsVo_s.addAll(vos);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            request.setAttribute("pageNumber", totalPage);
            request.setAttribute("goods", goodsVo_s);
            request.setAttribute("filePath", "file:" + request.getServletContext().getRealPath("/myFile/"));
        }
        return "index";
    }

    @RequestMapping("{id}")
    public String goodsDetail(@PathVariable("id")Integer id){
        GoodsVo_S goodsVo_s = null;
        try {
            goodsVo_s = service.getGoods(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            request.setAttribute("goods",goodsVo_s);
        }
        return "goods_detail";
    }

    //添加到购物车
    @ResponseBody
    @RequestMapping(value = "addToShopCar", method = RequestMethod.POST)
    public JsonResponse add2ShopCart(ShopCartVo shopCartVo) {
        System.out.println(shopCartVo.toString());
        JsonResponse jsonResponse = new JsonResponse();
        try {
            service.add2shopCart(shopCartVo);
            JsonResponseWarp.warpSuccess(jsonResponse,null,"添加成功！");
        }catch (Exception e){
            JsonResponseWarp.warpBusinessException(new BaseException(e.getMessage()),jsonResponse,"添加失败！");
        }
        return jsonResponse;
    }

}
