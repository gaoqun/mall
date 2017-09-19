var sys_error = "系统异常！";
var path = location.protocol + "//" + location.hostname + ":" + location.port;

function login(username, password,is_show_alert) {
    $(document).ready(function () {
        $.ajax({
            dataType: 'json',
            type: 'POST',
            url: "/mall/manager/login1",
            contentType: "application/x-www-form-urlencoded",
            async: false,
            data: {
                'username': username,
                'password': password
            },
            success: function (callback) {
                var code = callback.code;
                if ("200" == code) {
                    saveCookie("username", username, 7);
                    saveCookie("pwd", password, 7);
                    saveCookie("id",callback.data.id,7);
                    window.location = path + "/mall/manager/menu";
                } else {
                    window.top.location = path + "/mall/manager/index";
                    if (is_show_alert){
                        alert(callback.msg);
                    }
                    deleteCookie("username");
                    deleteCookie("pwd");
                    deleteCookie("id");
                }
            },
            error: function () {
                alert(sys_error);
                location.reload();
            }
        });
    });
}

//保存Cookie
function saveCookie(name, value, day) {
    var data = new Date();
    data.setDate(data.getDate() + day);
    document.cookie = name + '=' + encodeURIComponent(value) + ";expires=" + data;
};

//获取Cookie
function getCookie(name) {
    var arr = document.cookie.split('; ');
    var i = 0;
    for (i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split('=');
        if (arr2[0] == name) {
            var getC = decodeURIComponent(arr2[1]);
            return getC;
        }
    }
    return '';
};

//删除Cookie
function deleteCookie(name) {
    saveCookie(name, '', -1);
};

//加密
function getHash(origin_pwd) {
    return md5(origin_pwd);
}

//check cookie cache
function check_cookie() {
    var username = getCookie("username");
    var pwd = getCookie("pwd");
    var id = getCookie("id");
    if (username == "" || username == undefined || pwd == "" || pwd == undefined || id == "" || id == undefined) {
        deleteCookie("username");
        deleteCookie("pwd");
        deleteCookie("id");
        return false;
    } else {
        return true;
    }
}
