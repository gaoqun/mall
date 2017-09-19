<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/9/14
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods Detail</title>
    <script type="text/javascript" src="/mall/res/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/mall/res/js/login.js"></script>
    <script type="text/javascript">
        var username =   getCookie('username');
        var password =   getCookie('password');
        var id =   getCookie('id');

        //加入购物车
        function add_2_shop_cart() {
//           if(check_cookie()){
               //登录过了
//               alert("加入购物车！")
//           }else {
//               //显示登录框
//               $('#login').show();
//           }

            var data = new FormData();
            data.append('userId', 1);
            data.append('goodsId', ${requestScope.id});
            data.append('goodsCount', 1);
            $.ajax({
                dataType:'json',
                url: '/mall/goods/addToShopCar',
                type: 'POST',
                processData: false,
                contentType: false,
                data: data,
                success: function (callback) {
                    console.info(callback);
                    var code = callback.code;
                    var msg = callback.msg;
                    if (code=="200"){
                        alert(msg);
                    }else {
                        alert((msg==undefined||msg=="")?'加入失败！':msg)
                    }
                },
                error:function () {
                    console.info(sys_error);
                }
            });

        }
//        $(document).ready(function () {
//            jQuery.fn.extend({
//                center: function (width, height) {
//                    return $(this).css("left", ($(window).width() - width) / 2 + $(window).scrollLeft()).css("top", ($(window).height() - height) / 2 + $(window).scrollTop()).css("width", width).css("height", height);
//                }
//            });
//        });

        $(".btn_add_shop_cart").click(function () {
            $("#login").show().center(350, 250);//展现登陆框
        });

        $("#btn_login").click(function () {
            login($("#username").val(),$("#password").val(),true);
        });

        $(document).ready(function () {
           $("#login").hide();
        });

        function order() {
            $.ajax({
                url: path+"/mall/order/create/1",
                type: "GET",
                dataType:'json',
                success:function (callback) {
                    alert("1111");
                },
                error:function(er){
                    BackErr(er);}
            });
        }

    </script>

    <style type="text/css" rel="stylesheet">
        #login {
            width: 350px;
            height: 250px;
            border: 1px solid #ccc;
            position: absolute;
            display: block;
            z-index: 9999;
            background: #fff;
        }

        #login h2 {
            height: 40px;
            line-height: 40px;
            text-align: center;
            font-size: 14px;
            letter-spacing: 1px;
            color: #666;
            background: #97A9FF;
            margin: 0;
            padding: 0;
            border-bottom: 1px solid #ccc;
            cursor: move;
        }

        #login h2 img {
            float: right;
            position: relative;
            top: 14px;
            right: 8px;
            cursor: pointer;
        }

        #login div.user, #login div.pass {
            font-size: 14px;
            color: #666;
            padding: 5px 0;
            text-align: center;
        }

        #login input.text {
            width: 200px;
            height: 25px;
            border: 1px solid #ccc;
            background: #fff;
            font-size: 14px;
        }

        #login .button {
            text-align: center;
            padding: 15px 0;
        }

    </style>
</head>
<body>
<div id="login">
    <h2><img src="/mall/res/image/close.png" alt="" class="close"/>网站登录</h2>
    <form id="loginForm">
        <div class="info"></div>
        <div class="user">帐 号：<input type="text" name="user" class="username"/></div>
        <div class="pass">密 码：<input type="password" name="pass" class="password"/></div>
        <div class="button">
            <button type="button" id="btn_login"/>
            登录
        </div>
    </form>
</div>

<h1>${requestScope.goods.id}--${requestScope.goods.name}</h1>

<button type="button" onclick="add_2_shop_cart()" id="btn_add_shop_cart">加入购物车</button>
<button type="button" onclick="order()">下单</button>
</body>
</html>
