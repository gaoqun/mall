<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/9/8
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>管理菜单</title>
    <link href="/mall/res/css/base_css.css" rel="stylesheet" type="text/css">
    <script src="/mall/res/js/jquery-3.2.1.min.js"></script>
    <script src="/mall/res/js/md5.js"></script>
    <script src="/mall/res/js/login.js"></script>
    <script type="text/javascript">
        //check cookie cache
        function check_my_cookie() {
            var flag = check_cookie();
            if (flag) {
                $('#user_name').text('欢迎' + getCookie('username'));
                show_add_goods_page();
                return;
            } else {
                window.location = path + "/mall/manager/index";
            }
        }

        function show_add_goods_page() {
            $('#add_goods').show();
            $('#delete_goods').hide();
            $('#modify_goods').hide();
        }

        function show_delete_goods_page() {
            $('#add_goods').hide();
            $('#delete_goods').show();
            $('#modify_goods').hide();
        }

        function show_modify_goods_page() {
            $('#add_goods').hide();
            $('#delete_goods').hide();
            $('#modify_goods').show();
        }

        //        检测空
        function check() {
            add_goods_commit();
        }

        function add_goods_commit() {
            var data = new FormData();
            data.append('pic', $('#_input_goods_pics').get(0).files[0]);
            data.append('name', $('#_input_goods_name').val());
            data.append('count', $('#_input_goods_count').val());
            data.append('desc', $('#_input_goods_desc').val());
            data.append('price', $('#_input_goods_price').val());
            $.ajax({
                dataType:'json',
                url: '/mall/manager/goods/add',
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
                        alert((msg==undefined||msg=="")?'添加失败！':msg)
                    }
                },
                error:function () {
                    console.info(sys_error);
                }
            });
        }

        function delete_goods_coomit() {

        }

        function modify_goods_commit() {

        }

        $("#goods_list").click(function () {
            window.location = path+"/goods/index";
        });

    </script>
    <style type="text/css">

        hr {
            background: #97A9FF;
            width: 100%;
            height: 1px;
            margin: 0px;
            padding: 0px;
        }

        .nav1 {
            position: absolute;
            z-index: 10;
            height: 40px;
            width: 100%;
            text-align: center;
        }

        .nav {
            background-color: #EEEEEE;
            height: 40px;
            width: 400px;
            margin: 0 auto;
            text-align: center;
        }

        /*横向一级菜单样式设置*/
        ul {
            list-style: none;
        }

        ul li {
            float: left;
            line-height: 40px;
            text-align: center;
            position: relative;
        }

        a {
            text-decoration: none;
            color: #000000;
            display: block; /*将a行内元素转变成块级元素*/
            width: 90px;
            height: 40px;
        }

        a:hover {
            background-color: #666666;
            color: #FFFFFF;
        }

        /*二级下拉菜单样式设置*/
        ul li ul li {
            float: none;
            background-color: #EEEEEE;
        }

        ul li ul {
            position: absolute;
            top: 40px;
            left: 0px;
            display: none; /*默认状态下或鼠标离开时隐藏*/
            width: 90px;
        }

        /*为了兼容IE7写的CSS样式，但是必须写在a:hover前面*/
        ul li ul li a:link, ul li ul li a:visited {
            background-color: #EEEEEE;
        }

        ul li ul li a:hover {
            background-color: #009933;
        }

        /*鼠标滑过一级菜单的元素时显示下拉菜单*/
        ul li:hover ul {
            display: block;
        }

        .content_container {
            min-width: 1000px;
            height: 100%;
            position: relative;
            margin-top: 60px;
            margin-right: auto;
            margin-left: auto;
        }

        .content_container .goods_modify {
            position: absolute;
            width: 100%;
            height: 400px;
            border: #333333 1px solid;
            padding: 20px;
        }

        .add_title {
            width: 800px;
            height: 50px;
            background: white;
            margin: 0 auto;
            line-height: 50px;
        }

        .add_content {
            text-align: left;
            height: 100%;
            width: 100%;
        }

        ._line_content {
            display: inline-block;
            width: 100%;
            height: 60px;
            clear: both;
            line-height: 60px;
        }

        label {
            font-family: Sana;
            font-size: medium;
            font-style: normal;
        }
    </style>
</head>
<body onload="check_my_cookie();">
<div class="container">
    <div class="top">
        <div class="user_info">
            <label style="font-size: large;font-family: Sana;color: green;margin-left: 30px">
                后台管理系统
            </label>

            <label style="display: inline-block;float: right;padding-right: 20px">
                <label id="user_name"></label>
                <button type="button"
                        style="padding-left: 3px;padding-right: 3px;padding-bottom: 2px;padding-bottom: 2px">退出
                </button>
            </label>
        </div>
    </div>
    <hr/>
    <div class="nav1">
        <div id="nav" class="nav">
            <ul>
                <li><a href="#">后台首页</a></li>
                <li><a href="#">商品</a>
                    <ul>
                        <li><a href="#" onclick="show_add_goods_page()">添加商品</a></li>
                        <li><a href="#" onclick="show_delete_goods_page()">删除商品</a></li>
                        <li><a href="#" onclick="show_modify_goods_page()">修改商品</a></li>
                    </ul>
                </li>
                <li><a href="#" id="goods_list">商品列表</a></li>
            </ul>
        </div>
    </div>
    <div class="content_container">
        <%--modify goods--%>
        <div class="goods_modify" id="modify_goods">
            <label>修改商品</label>
        </div>
        <%--delete goods--%>
        <div class="goods_modify" id="delete_goods">
            <label>删除商品</label>
        </div>
        <%--add goods--%>
        <div class="goods_modify" id="add_goods">
            <div class="add_title">
                <h1 class="title">添加商品</h1>
            </div>
            <div class="add_content">
                <div>
                    <label class="_line_content">
                        请输入商品名称：
                        <input style="width: 200px;height: 30px;line-height: 30px;max-lines: 1;border: solid 1px #cdcdcd;margin-right: 30px;text-align: left"
                               type="text" id="_input_goods_name">
                    </label>
                </div>
                <div>
                    <label class="_line_content">
                        请输入商品数量：
                        <input style="width: 200px;height: 30px;line-height: 30px;max-lines: 1;border: solid 1px #cdcdcd;margin-right: 30px;text-align: left"
                               type="number" id="_input_goods_count">
                    </label>
                </div>
                <div>
                    <label class="_line_content">
                        请上传商品图片：
                        <input style="vertical-align:middle;width: 200px;height: 30px;line-height: 30px;max-lines: 1;border: solid 1px #cdcdcd;margin-right: 30px;text-align: left"
                               type="file" id="_input_goods_pics">
                    </label>
                </div>
                <div>
                    <label class="_line_content">
                        请输入商品描述：
                        <input style="width: 200px;height: 30px;line-height: 30px;max-lines: 1;border: solid 1px #cdcdcd;margin-right: 30px;text-align: left"
                               type="text" id="_input_goods_desc">
                    </label>
                </div>
                <div>
                    <label class="_line_content">
                        请输入商价格：
                        <input style="width: 200px;height: 30px;line-height: 30px;max-lines: 1;border: solid 1px #cdcdcd;margin-right: 30px;text-align: left"
                               type="number" id="_input_goods_price" step="any">
                    </label>
                </div>

                <button style="text-align: center;padding-top: 3px;padding-bottom: 3px;padding-left: 6px;padding-right: 6px;font-size: medium;margin:0 auto"
                        id="btn_commit" onclick="add_goods_commit();">提交
                </button>

            </div>
        </div>
    </div>
</div>
</body>
</html>
