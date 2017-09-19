<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/9/5
  Time: 上午10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="/mall/res/css/base_css.css" type="text/css" rel="stylesheet">
    <script src="/mall/res/js/jquery-3.2.1.min.js"></script>
    <script src="/mall/res/js/login.js"></script>
    <title>goods</title>
    <style>
        label{
            numberoflines:1;
        }

        #goods_list {
            background: white;
            width: 1200px;
            height: 660px;
            padding-left: 50px;
            padding-right: 50px;
            margin-right: auto;
            margin-left: auto;
        }

        #goods_list ul {
            width: 1100px;
        }

        #goods_list ul li {
            width: 200px;
            height: 300px;
            float: left;
            list-style: none;
            border: solid #cdcdcd 1px;
            margin-right: 15px;
            margin-bottom: 20px;
            z-index: 10;
            box-shadow: 6px 6px 3px #cdcdcd;
        }

        .div_page {
            display: inline-block;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            height: 60px;
            line-height: 60px;
        }

        img {
            display: block;
            outline: none;
            border: 0;
            height: 100%;
            width: 100%;
        }

        .goods_name {
            margin: 2px;
        }

    </style>

    <script type="text/javascript">
        var current_page = 1;

        function login() {

        }

        function register() {

        }

        //首页
        function first_page() {
            window.location = path + "/mall/goods/index"
        }

        //上一页
        function previous_page() {
            if (current_page == 1) {
                window.location = path + "/mall/goods/index?pageSize=10&pageNumber=" + current_page;
            } else {
                window.location = path + "/mall/goods/index?pageSize=10&pageNumber=" + (current_page - 1);
            }
        }

        //下一页
        function next_page() {
            window.location = path + "/mall/goods/index?pageSize=10&pageNumber=" + (current_page + 1);
        }

        //尾页
        function last_page() {
            window.location = path + "/mall/goods/lastPage?pageSize=10";
        }

        //跳转到x页
        function jump_page() {
            var page_number = $("#page_number").val();
            current_page = page_number;
            window.location = path + "/mall/goods/index?pageSize=10&pageNumber="+current_page;
        }

        //商品详情
        function goods_detail(id) {
            window.location = path+"/mall/goods/"+id;
        }

    </script>
</head>
<body>

<div class="container">
    <div class="top">
        <div class="user_info">
            欢迎坎坎坷坷！
            <button id="btn_login" type="button" style="display: none">登录</button>
            <button id="btn_register" type="button" style="display: none">注册</button>
        </div>
    </div>
    <hr style="color: #666666;height: 1px;width: 100%;margin-top: 0"/>

    <div id="goods_list">
        <c:forEach items="${requestScope.goods}" var="item">
            <ul>
                <li id="${item.id}" onclick="goods_detail(${item.id})">
                    <img style="height: 250px;margin-top: 0px" src="${requestScope.filePath}/${item.pic}">
                    <div class="div_price">
                        <div>
                            <label class="goods_name"
                                   style="font-family: Sana;font-size: medium;color: #666">${item.name}</label>
                        </div>
                        <div>
                            <label style="font-size: medium;color: #333333">￥${item.price}</label>
                        </div>
                    </div>
                </li>
            </ul>
        </c:forEach>
    </div>

    <div class="div_page">
        <a href="javascript:void(0)" onclick="first_page()">首页</a>&nbsp
        <a href="javascript:void(0)" onclick="previous_page()">上一页</a>&nbsp
        <label>
            第<input type="number" name="page_size" id="page_number" style="width: 30px;text-align: center" value="${requestScope.pageNumber}"
                    min="1">页
        </label>&nbsp
        <a href="javascript:void(0)" onclick="jump_page()"> 跳转</a>&nbsp
        <a href="javascript:void(0)" onclick="next_page()"> 下一页</a>&nbsp
        <a href="javascript:void(0)" onclick="last_page()"> 尾页</a>&nbsp
    </div>
</div>

</body>
</html>
