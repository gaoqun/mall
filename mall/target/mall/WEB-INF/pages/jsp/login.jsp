<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<link href="/mall/res/css/login.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
    .input {
        width: 180px;
        height: 26px;
    }
</style>
<script type="text/javascript" src="/mall/res/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="/mall/res/js/login.js"></script>
<script type="text/javascript" charset="UTF-8" src="/mall/res/js/md5.js"></script>
<script type="text/javascript" charset="UTF-8">
    //check cookie cache
    $().ready(function () {
        var flag = check_cookie();
        if (flag) {
            var username = getCookie("username");
            var pwd = getCookie("pwd");
            login(username, pwd, false);
        }
    });

    //just check
    check = function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var is_save = $("#remember_input").prop('checked');
        if ("" == username || username == undefined) {
            alert("请输入用户名！");
            return false;
        }

        if ("" == password || password == undefined) {
            alert("请输入密码！");
            return false;
        }

        login(username, getHash(password),true);
    }
</script>
</head>
<title>login</title>
<body>

<h1 class="title">商城后台管理</h1>
<div class="div_container">
    <fieldset>
        <div class="div_inline" style="margin: 10px;clear: both">
            <label>用户名:</label>
            <div style="float: right">
                <input id="username" class="input" type="text" name="username" style="border: 1px solid #666; -webkit-border-radius: 2px;"/>
            </div>
        </div>

        <div class="div_inline" style="clear: both;margin: 10px">
            <label>密 码:</label>
            <div style="float: right">
                <input id="password" class="input" type="password" name="password" style="border: 1px solid #666; -webkit-border-radius: 2px;"/>
            </div>
        </div>

        <div class="div_inline" style="clear: both;margin: 10px">
            <button onclick="return check();" type="button" style="float: left;margin: 10px">登录</button>
            <button id="register" type="button" name="register" style="float: right;margin: 10px"
                    >注册
            </button>
        </div>

        <div class="div_inline" style="clear: both;text-align: left">
            <label id="remember_label" style="margin-left: 2px;font-size: medium">
                <input id="remember_input" type="checkbox" value="记住密码" name="remember_pwd" style="zoom: 120%">
                记住密码
            </label>
            <%--不启用超链接--%>
            <a href="javascript:void(0)" style="margin-left: 10px;">忘记密码</a>
        </div>
    </fieldset>
</div>
</body>
</html>