<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<#if (Session.adminName)?exists>
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=adminloginaction.action">
</#if>
<title>用户登录</title>
<link  href="css/login_style.css" type="text/css" rel="stylesheet"/>
<script type = "text/javascript">
	function check(){
		var admName = document.getElementById("admName").value;
		var admPsw = document.getElementById("admPsw").value;
		if(admName == ""|| admPsw == ""){
			alert("请将登录信息填写完整");
			return false;
		}
	}
</script>
</head>
<body>
<form method="post" action="adminloginaction.action" onsubmit = "return check();">
	<div class="login_wrap">
    	<div class="login_top">
        	<img src="images/login/logo.png"></img>
        </div>
        <div class="login_left">
        </div>
        <div class="login_right">
            <div class="login_main">
            	<div style="position:absolute;left:830px; top:145px; width:170px; height:20px; color:#FF0000; text-align:center;"><#if errorMsg?exists>${errorMsg}</#if></div>
            	<p>
                	<span class="user">用户名：</span>
                    <span style="float:left;"><input name="admName" id = "admName" type="text" class="text_style"/></span>
                </p>
                <p>
                	<span class="password">密&nbsp;&nbsp;&nbsp;码：</span>
                    <span style="float:left;"><input name="admPsw" id = "admPsw" type="password" class="text_style"/></span>
                </p>
                <br/>
                <!--
                <p>
                	<span class="security">验证码：</span>
                    <span style="float:left;"><input type="text" class="text_style" style="width:75px;"/></span>
                    <span style="float:left; padding-left:5px;"><img src="images/login/authImg.jpg"/></span>
                </p>
                -->
                <p>
                	<span style="margin-left:70px; float:left;"><input type="radio" name = "userType" checked="checked" value=0></input>管理员</span>
                    <span style="margin-left:37px; float:left;"><input type="radio" name = "userType" value=1></input>校友</span>
                </p>
                <p>
                	<span style="margin-left:68px; float:left;"><input type="submit" class="but_submit" value="" name="button1"/></span>
                    <span style="margin-left:15px; float:left;"><input type="reset" class="but_reset" value="" name="button2"/></span>
                </p>
            </div>
        </div>
    </div>
</form>
</body>
</html>
