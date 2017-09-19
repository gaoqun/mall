<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/9/1
  Time: 下午4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link href="/mall/res/css/login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/mall/res/js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        .label {
            margin-left: 12px;
            margin-right: 12px;
            margin-top: 20px;
            margin-top: 20px;
        }
    </style>

    <script type="text/javascript">
        var path = location.protocol + "//" + location.hostname + ":" + location.port;
        function check() {
         var username = $('#username').val();
         var pwd = $('#pwd').val();
         var phone = $('#phone_number').val();
         var email = $('#email').val();
         var nick_name = $('#nick_name').val();
         if (''==username||undefined==username){
             alert("请输入用户名！");
             return false;
         }
         if (''==pwd||undefined==pwd){
             alert("请输入密码！");
             return false;
         }
         if (''==nick_name||undefined==nick_name){
             nick_name = username;
         }
         if (''==phone||undefined==phone){
             alert('请输入手机号!');
             return false;
         }
         if (''==email||undefined==email){
             alert('请输入邮箱!');
             return false;
         }
         register(username,pwd,nick_name,phone,email);
        }

        //register
        function register(username,pwd,nick_name,phone,email) {
            $.ajax({
                dataType:'json',
                type: 'POST',
                url: "/mall/user/register",
                contentType: "application/x-www-form-urlencoded",
                async: true,
                data: {
                    'username': username,
                    'pwd': pwd,
                    'nickName':nick_name,
                    'phone':phone,
                    'email':email
                },
                success:function (callback) {
                    console.info(callback.toString());
                    window.location = path+"/mall/user/loginPage"
                },
                error:function () {
                    alert('注册失败！');
                }

            });
        }
    </script>

</head>
<body style="background: #ffffff url(/res/image/bg.jpg) no-repeat fixed center">
<h1 class="title">商城系统</h1>
<div style="width: 360px;height: 340px;margin-left:auto;margin-right:auto;background: #97A9FF;-webkit-border-radius: 4px;margin-top: 128px;padding: 5px">
    <fieldset>
        <div class="label">
            <label>
                用户名：
                <input type="text" name="username" id="username"
                       style="float: right;border: 1px solid #666; -webkit-border-radius: 2px;width: 220px;height: 30px"/>
            </label>
        </div>
        <div class="label">
            <label>
                密码：
                <input type="password" name="pwd" id="pwd"
                       style="float: right;border: 1px solid #666; -webkit-border-radius: 2px;width: 220px;height: 30px"/>
            </label>
        </div>
        <div class="label">
            <label>
                昵称：
                <input type="text" name="nick_name" id="nick_name"
                       style="float: right;border: 1px solid #666; -webkit-border-radius: 2px;width: 220px;height: 30px"/>
            </label>
        </div>
        <div class="label">
            <label>
                手机号：
                <input type="number" name="phone_number" id="phone_number"
                       style="float: right;border: 1px solid #666; -webkit-border-radius: 2px;width: 220px;height: 30px"/>
            </label>
        </div>
        <div class="label">
            <label>
                Email：
                <input type="text" name="email" id="email"
                       style="float: right;border: 1px solid #666; -webkit-border-radius: 2px;width: 220px;height: 30px"/>
            </label>
        </div>

        <div class="label">
            <button onclick="return check()" type="button" value="注册" style="text-align:center;background: #ffffff;-webkit-border-radius: 4px;font-family: 'DejaVu Sans Mono', monospace;font-size: large;
               color: #000000;padding: 5px 10px 5px 10px;background-clip: padding-box;background-size: auto;width: 100%;height: 42px;margin-top: 25px">
                注册
            </button>
        </div>
    </fieldset>
</div>

</body>
</html>
