<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>校友管理系统</title>
	<link href="/AlumiManagementSystem/images/icon.png" type="image/x-icon" rel="shortcut icon"/>
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/indexframe.css" />
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/left/sdmenu.css" />
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/backstage.css"/>
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/shadeBlock.css"/>
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/jquery.spinbox.css"/>
	<#--以上是后台架构的CSS和js-->
	<script type="text/javascript" src="/AlumiManagementSystem/js/jquery.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/jquery.form.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/framework/sdmenu.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/framework/jquery.spinbox.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/framework/shadeBlock.js"></script>

	
	<script type="text/javascript" src="/AlumiManagementSystem/js/my_97/DatePicker/WdatePicker.js"></script> <#--my97 js-->
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/common.js"></script>	<#--页面通用的一些js方法-->
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/classes.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/major.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/admin/admin.js"></script>
	<script type="text/javascript" src="/AlumiManagementSystem/js/que.js"></script>
	
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/admin/search_box/search_box.css"/><#--搜索框的样式-->
	<script type="text/javascript" src="/AlumiManagementSystem/FCKeditor/fckeditor.js"></script><#-- 引入js文件 -->
	<#-- 样卷视图样式 
	<link rel="stylesheet" type="text/css" href="/AlumiManagementSystem/css/surveyCss.css"/>-->
	
	<script type="text/javascript">
		var myMenu;
		var current_page=0;
		var totle_size=0;
		var check_class,check_project;
		var url;
		window.onload = function() {		//页面加载后初始化
			myMenu = new SDMenu("my_menu");
			myMenu.init();	
		};
		
		$(document).ready(function(){
		    $("#left a").click(function(){
		        $("#middle").empty();
		        $('#middle').block({ 
                	message: '<h1><img src="/AlumiManagementSystem/images/admin/loading.gif"/></h1>'
            	});
		        $("#middle").load($(this).attr("href"),{
					sendTime : (new Date()).getTime()
				});
		        return false;
		    });
		    
		 });
		 
	</script>
</head>
<body>
    <div id="left">
    		<div id="lefttop"><span style="font-size:14px;font-weight:bold">管理目录</span></div>
			<div style="float: left" id="my_menu" class="sdmenu">
				<#if Session.adminType == "普通管理员">
				<div>
					<span>校友信息管理</span>
					<a href="inforListAction.action">学生信息列表</a>
					<a href="showInforAddAction.action">添加学生信息</a>
					<a href="showSpreadAction.action">显示就业分布</a>
					<a href="showEnrollmentSpreadAction.action">显示生源分布</a>
					<a href="showBachAddAction.action">批量上传[excel]</a>
				</div>
				<div>
					<span>班级与专业管理</span>
					<a href="classesListAction.action">班级管理</a>
					<a href="majorListAction.action">专业管理</a>
				</div>
				<div>
					<span>系统工具</span>
					<a href="showUploadPage.action">图片上传</a>
					<a href="showSelectPage.action">图片筛选</a>
				</div>
				<div>
					<span>问卷调查</span>
					<a href="showUploadPage.action">问卷调查题库</a>
					<a style="display:none"></a>
				</div>
				<#elseif Session.adminType == "高级管理员">
				<div>
					<span>校友信息管理</span>
					<a href="inforListAction.action">学生信息列表</a>
					<a href="showInforAddAction.action">添加学生信息</a>
					<a href="showSpreadAction.action">显示就业分布</a>
					<a href="showEnrollmentSpreadAction.action">显示生源分布</a>
					<a href="showEnrollmentSpreadAction.action">简历信息列表</a>
					<a href="showBachAddAction.action">批量上传[excel]</a>
				</div>
				<div>
					<span>班级与专业管理</span>
					<a href="classesListAction.action">班级管理</a>
					<a href="majorListAction.action">专业管理</a>
				</div>
				<div>
					<span>普通管理员管理</span>
					<a href="adminListAction.action">普通管理员列表</a>
					<a style="display:none"></a>
				</div>
				<div>
					<span>系统工具</span>
					<a href="logList.action">日志信息</a>
					<a href="showUploadPage.action">图片上传</a>
					<a href="showSelectPage.action">图片筛选与上传</a>
				</div>
				<div>
					<span>问卷调查</span>
					<a href="showQueBankList.action">问卷调查题库</a>
					<a href="setQuestionnaire.action">制定调查问卷</a>
					<a href="questionnaireList.action">已出问卷列表</a>
				</div>
				<#elseif Session.adminType == "理事">
				<div>
					<span>校友信息查看</span>
					<a href="inforListAction.action">学生信息列表</a>
					<a href="showSpreadAction.action">显示就业分布</a>
					<a href="showEnrollmentSpreadAction.action">显示生源分布</a>
				</div>
				<div>
					<span>我的信息</span>
					<a href="myInforDetailAction.action">我的信息</a>
					<a href="showMyInforUpdateAction.action">信息修改</a>
				</div>
				<#-- 暂时联络员和普通校友权限一样 -->
				<#elseif Session.adminType == "联络员">
				<#--<div>
					<span>联络员权限查看</span>
					<a href="javascript:common();">查看权限</a>
				</div>-->
				<div>
					<span>本班校友信息</span>
					<a href="sameClassesInforListAction.action">学生信息列表</a>
					<a href="showSpreadAction.action">显示就业分布</a>
					<a href="showEnrollmentSpreadAction.action">显示生源分布</a>
				</div>
				<div>
					<span>我的信息</span>
					<a href="myInforDetailAction.action">我的信息</a>
					<a href="showMyInforUpdateAction.action">信息修改</a>
				</div>
				<#else>
				<div>
					<span>本班校友信息</span>
					<a href="sameClassesInforListAction.action">学生信息列表</a>
					<a href="showSpreadAction.action">显示就业分布</a>
					<a href="showEnrollmentSpreadAction.action">显示生源分布</a>
				</div>
				<div>
					<span>我的信息</span>
					<a href="myInforDetailAction.action">我的信息</a>
					<a href="showMyInforUpdateAction.action">信息修改</a>
					<a href="myContactsList.action">我的通讯录</a>
				</div>
				</#if>
			</div>
	</div>
	
	
	<div id="header">
			<img src="/AlumiManagementSystem/images/admin/banner.png" />
			<div id="userinfo">
				登陆用户：${Session.adminName}
				 　|　身份：${Session.adminType}
			</div>
			<div id="changepass">
				<span onclick="seeDetail(0, this, 300, 450, 'showAdminChangePwAction.action');" style="cursor:pointer;">
				<img src="/AlumiManagementSystem/images/admin/changepass.png" style="border:none;"/>
				</span>
			</div>
			<div id="exitbtn">
				<a href="exitAdmin.action">
				<img src="/AlumiManagementSystem/images/admin/exit.png" style="border:none;"/>
				</a>
			</div>
	</div>
	
		
	<div id="middle">
		<div class="controltitle">当前操作：欢迎登录！</div>
		<div id="middlebg">
			<img src="/AlumiManagementSystem/images/admin/indexbg.jpg" style="border:none;">
		</div>
	</div>
</body>
</html>