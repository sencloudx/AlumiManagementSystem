function common(){
	alert("火热开发中");
	return false;
}

function require(){
	if($("#require").attr("checked")==true){
		/**
		 * 选中该复选框前必须有学生已经被选中
		 * */
		if($("input[name='id']:checked").size()==0){
			alert("选定前请先选中你要导出的学生");
			$("#shield").fadeOut(400);
			$("#subDetailWrapper").fadeOut(400);
		}
	}else{
		return;
	}
}

//邮件的发送
function sendMail(tagAction){
	var subject = $("#subject").val(); 
	var planoEditor = FCKeditorAPI.GetInstance("message");
	var content = planoEditor.EditorDocument.body.innerHTML;
	var idStr = $("#idStr").val(); 
	alert(subject+content+idStr);
	$.ajax({
		url:tagAction,
		data:{
			sendTime:(new Date()).getTime(),
			idStr:idStr,
			subject:subject,
			message:content
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				alert("发送成功！！！");
			}else{
				alert("发送失败，请联系开发人员！！！");
			}
		}
	});
}
//反选
function invertSelect(name){
	var ids=$("input[name='"+name+"']");
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked==true){
			ids[i].checked="";
		}else{
			ids[i].checked="checked"; 
		}
	}
}
//全选
function allSelect(name){
	var ids=$("input[name='"+name+"']");
	for(var i=0;i<ids.length;i++){
		ids[i].checked="checked"; 
	}
}

//根据省份来进行显示
function show(tagAction, city, sourceCity){
	//alert(city+sourceCity);
	$("#shield").fadeOut(400);
	$("#subDetailWrapper").fadeOut(400);
	//js控制css的更改，感觉自己js跟jquery有点混了
	//document.getElementById("dataMap").style.display = "none"
	$("#dataMap").css("display", "none");
	$("#showMap").css("display", "block");
	$("#detail").empty();
	$("#detail").load(tagAction,
		{
			sendTime:(new Date()).getTime(),
			city: city,
			sourceCity:sourceCity
		}
	);
	//以下两种方式是控制滚动条滚动的
	//$("html,body").animate({scrollTop: $("#detail").offset().top}, 1000);
	//window.scrollTo(100, 200);
	
}

function showMap(){
	$("#dataMap").css("display", "block");
	$("#showMap").css("display", "none");
}
//查看详细，查看修改
function seeDetail(Id,obj,width,height,tagAction){
	$(obj).shadeBlock(width, height, "#subDetail", "相关操作");
	if(Id == 0){
		$(".shadeBlockContent").empty();
		$(".shadeBlockContent").load(tagAction,
				{
					sendTime:(new Date()).getTime()
				}
		);
	}
	else{
		$(".shadeBlockContent").empty();
		$(".shadeBlockContent").load(tagAction,
				{
					sendTime:(new Date()).getTime(),
					tagId:Id
				}
		);
	}
}

//批量删除
function batchDelete(delTagAction, listTagAction){
	var currentPage=$("#currentPage").val();  //获取当前页
	//alert(currentPage);
	var ids=new Array();
	if($("input[name='id']:checked").size()==0){
		alert("请先选择要删除的学生！");
		return false;
	}
	$("input[name='id']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	//var idStr=ids.join("-");
	//alert(idStr);
	//return false;
	if(currentPage == undefined){
		currentPage = 0;
	}
	if (confirm("彻底删除后将不能恢复，请慎重！")) {
	$.ajax({
		url:delTagAction,
		data:{
			sendTime:(new Date()).getTime(),
			ids:ids
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				$("#shield").fadeOut(400);
				$("#subDetailWrapper").fadeOut(400);
				$("#middle").load(listTagAction,
						{
							sendTime:(new Date()).getTime(),
							currentPage:currentPage
						}
				)
				alert("操作成功！！！");
			}else{
				alert("操作失败，请联系开发人员！！！");
			}
		}
	});
	}else{
		return false;
	}
}

//修改
function update(delTagAction, listTagAction){
	var tagId = $("#examId").val(); 
	var currentPage=$("#currentPage").val();  //获取当前页
	//alert(currentPage);
	var ids=new Array();
	if($("input[name='id']:checked").size()==0){
		alert("请先勾取选项！");
		return false;
		
	}
	$("input[name='id']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	$.ajax({
		url:delTagAction,
		data:{
			sendTime: (new Date()).getTime(),
			idStr: idStr,
			tagId: tagId
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			if(data.success){
				$("#middle").load(listTagAction,
						{
							sendTime:(new Date()).getTime(),
							currentPage:currentPage
						}
				)
				alert("操作成功！！！");
			}else{
				alert("操作失败，请联系开发人员！！！");
			}
		}
	});
}

//伪删除与还原
function fakeDelete(id, delTagAction, listTagAction, type){
	if(id == 0){
		var currentPage=$("#currentPage").val();  //获取当前页
		//alert(currentPage);
		var ids=new Array();
		if($("input[name='id']:checked").size()==0){
			alert("请先选择要放入回收站的学生！");
			return false;
		}
		$("input[name='id']:checked").each(function(i,obj){
			ids[i]=$(obj).val();
		});
		var idStr=ids.join("-");
	}else{
		var currentPage=$("#currentPage").val();  //获取当前页
		var idStr= id;
	}
	
//	alert(idStr+type);
//	return false;
	if(type == "删除"){
		if (confirm("放入回收站的学生在数据上将不予支持，到回收站还原后仍可正常，确定！")) {
			$.ajax({
				url:delTagAction,
				data:{
					sendTime:(new Date()).getTime(),
					idStr:idStr,
					type:type
				},
				type:"post",
				async:false,
				dataType:"json",
				success:function(data){
					if(data.success){
						$("#middle").load(listTagAction,
								{
									sendTime:(new Date()).getTime(),
									currentPage:currentPage
								}
						)
						alert(data.msg);
					}else{
						alert(data.msg);
					}
				}
			});
			}else{
				return false;
			}
	}else{
		$.ajax({
			url:delTagAction,
			data:{
				sendTime:(new Date()).getTime(),
				idStr:idStr,
				type:type
			},
			type:"post",
			async:false,
			dataType:"json",
			success:function(data){
				if(data.success){
					$("#middle").load(listTagAction,
							{
								sendTime:(new Date()).getTime(),
								currentPage:currentPage
							}
					)
					alert("恭喜：已成功还原");
				}else{
					alert("sorry:还原失败");
				}
			}
		});
	}
}


//常规的显示
function commonShow(obj,width,height,tagAction){
	/*if($("input[name='id']:checked").size() == 0){
		alert("请先选择需要的项！");
		return false;
	}*/
	$(obj).shadeBlock(width, height, "#subDetail", "相关操作");
	$(".shadeBlockContent").empty();
	$(".shadeBlockContent").load(tagAction,
			{
				sendTime:(new Date()).getTime()
			}
	);
}

//显示授权界面
function authorizationShow(obj,width,height,tagAction){
	if($("input[name='id']:checked").size() == 0){
		alert("请先选择要被授权的校友，可以选择多个同时进行授权！");
		return false;
	}
	var ids=new Array();
	$("input[name='id']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	//alert(idStr);
	$(obj).shadeBlock(width, height, "#subDetail", "相关操作");
	$(".shadeBlockContent").empty();
	$(".shadeBlockContent").load(tagAction,
			{
				sendTime:(new Date()).getTime(),
				idStr: idStr
			}
	);
}
//进行授权
function authorization(){
	var authorization = $("#authorization").val();
	if(authorization == 0){
		alert("选择要授予的权限");
		return false;
	}
	var ids=new Array();
	$("input[name='id']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	//alert(idStr+authorization);
	$.ajax({
		url:'authorizationAction.action',
		data:{
			sendTime: (new Date()).getTime(),
			authorization: authorization,
			idStr: idStr
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			$("#shield").fadeOut(400);
			$("#subDetailWrapper").fadeOut(400);
			if(data.success){
				alert("权限授予成功");
			}else{
				alert("sorry,权限授予失败");
			}
		}
	});
	
}

//显示批量导入的页面,可以通用
function showAddBatchSub(id, tagAction){
	if(id == 0){									//表示无参数
		$("#middle").empty();
		$("#middle").load(tagAction,
			{
				sendTime:(new Date()).getTime()
			}
		);
	}else{											//表示有参数
		$("#middle").empty();
		$("#middle").load(tagAction,
			{
				sendTime:(new Date()).getTime(),
				tagId: id
			}
		);
	}
	
}
//显示邮件发送界面
function showEmailSend(tagAction){
	alert("进来了");
	if($("input[name='id']:checked").size() == 0){
		alert("请先选择需要发送邮件的对象！");
		return false;
	}
	var ids=new Array();
	$("input[name='id']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr=ids.join("-");
	$("#middle").empty();
	$("#middle").load(tagAction,
		{
			sendTime:(new Date()).getTime(),
			idStr: idStr
		}
	);
}
//显示批量导入的页面,可以通用
function showPrint(tagAction){
	var showType = $("#showType").val();				//显示的类型
	var major = $("#major").val();
	var address = $("#address").val();
	var searchType = $("#searchType").val();
	var searchContext = $("#searchinput").val();	//查询的内容
	var classesId = $("#classes").val();
	var sourceCity = $("#sourceCity").val();
	if(showType == undefined){
		showType = 0;
	}
	if(major == undefined){
		major = 0;
	}
	if(classesId == undefined){
		classesId = 0;
	}
	if(address == undefined){
		address = 0;
	}
	if(sourceCity == undefined){
		sourceCity = 0;
	}
	$("#middle").empty();
	$("#middle").load(tagAction,
		{
			sendTime:(new Date()).getTime(),
			showType: showType,
			major: major,
			address: address,
			searchType: searchType,
			searchContext: searchContext,
			classesId: classesId,
			sourceCity: sourceCity
		}
	);
}

//
function showAddOneSub(width,height,tagAction){
	$(obj).shadeBlock(width, height, "#subDetail","添加新题");
	$(".shadeBlockContent").empty();
	$(".shadeBlockContent").load(tagAction,
			{
				sendTime:(new Date()).getTime()
			}
	);
}

//视图变换
function showChange(tagAction){
	var showType = $("#showType").val();				//显示的类型
	var docProtitleId = $("#docProtitleId").val();
	var teaProtitleId = $("#teaProtitleId").val();
	var major = $("#major").val();
	var classesId = $("#classes").val();
	var address = $("#address").val();
	var sourceCity = $("#sourceCity").val();
	var city = $("#city").val();
	var searchType = $("#searchType").val();
	var searchContext = $("#searchinput").val();	//查询的内容
	//alert(city);
	if(showType == undefined){
		showType = 0;
	}
	if(major == undefined){
		major = 0;
	}
	if(docProtitleId == undefined){
		docProtitleId = 0;
	}
	if(teaProtitleId == undefined){
		teaProtitleId = 0;
	}
	if(classesId == undefined){
		classesId = 0;
	}
	if(address == undefined){
		address = 0;
	}
	if(city == undefined){
		city = 0;
	}
	if(sourceCity == undefined){
		sourceCity = 0;
	}
	
	if(city == 0){
		$("#middle").load(tagAction,{
			sendTime: (new Date()).getTime(),
			showType: showType,
			major: major,
			address: address,
			searchContext: searchContext,
			searchType: searchType,
			classesId: classesId,
			sourceCity: sourceCity,
			teaProtitleId:teaProtitleId,
			docProtitleId:docProtitleId
			
	});
	}else{
		$("#detail").load(tagAction,{
			sendTime: (new Date()).getTime(),
			city: city,
			major: major
	});
	}
	
}
/**
 * 所有查询相关的js
 * 
 * **/
function searchInfor(tagAction){
	var showType = $("#showType").val();				//显示的类型
	var major = $("#major").val();
	var address = $("#address").val();
	var searchType = $("#searchType").val();
	var searchContext = $("#searchinput").val();	//查询的内容
	var classesId = $("#classes").val();
	var sourceCity = $("#sourceCity").val();
	if(searchContext == "- - -关键字- - -"){
		alert("输入查找内容！");
		return false;
	}
	if(showType == undefined){
		showType = 0;
	}
	if(major == undefined){
		major = 0;
	}
	if(classesId == undefined){
		classesId = 0;
	}
	if(address == undefined){
		address = 0;
	}
	if(sourceCity == undefined){
		sourceCity = 0;
	}
	//alert("类型和内容： " + searchType + "  "+ searchContext);
	$("#middle").load(tagAction,{
		sendTime: (new Date()).getTime(),
		searchContext: searchContext,
		searchType: searchType,
		showType:showType,
		major: major,
		address: address,
		classesId: classesId,
		sourceCity: sourceCity
	});
}

//管理员修改密码
function changePw(){
	var newPw = $("#newPw").val();
	var newPwRepeat = $("#newPwRepeat").val();
	if(newPw == ""|| newPwRepeat == ""){
		alert("信息填写完整");
		return false;
	}
	if(newPw != newPwRepeat){
		alert("两次输入的密码不一样，请重输");
		return false;
	}
	//alert(newPw+newPwRepeat);
	$.ajax({
		url:'changeAdminPwAction.action',
		data:{
			sendTime: (new Date()).getTime(),
			newPw: newPw,
			newPwRepeat: newPwRepeat
		},
		type:"post",
		async:false,
		dataType:"json",
		success:function(data){
			$("#shield").fadeOut(400);
			$("#subDetailWrapper").fadeOut(400);
			if(data.success){
				alert("修改成功");
			}else{
				alert("修改失败");
			}
		}
	});
}
/**
 * 导出excel
 * */
function exportExcel(tagAction){
	//获取当前视图
	var showType = $("#showType").val();
	var major = $("#major").val();
	var address = $("#address").val();
	var searchType = $("#searchType").val();
	var searchContext = $("#searchinput").val();	//查询的内容
	var classesId = $("#classes").val();
	//alert(classesId);
	var sourceCity = $("#sourceCity").val();
	if($("#require").attr("checked")==true){					//选定导出
		var ids1=new Array();
		if($("input[name='id']:checked").size()==0){
			alert("选择需要导出的学生！");
			return false;
		}
		$("input[name='id']:checked").each(function(i,obj){
			ids1[i]=$(obj).val();
		});
		var idStuStr = ids1.join("-");
	}
	//获取要导出的项
	var ids=new Array();
	if($("input[name='stu']:checked").size()==0){
		alert("选择需要导出的项！");
		return false;
	}
	$("input[name='stu']:checked").each(function(i,obj){
		ids[i]=$(obj).val();
	});
	var idStr = ids.join("-");
	if(showType == undefined){
		showType = 0;
	}
	if(major == undefined){
		major = 0;
	}
	if(address == undefined){
		address = 0;
	}
	if(idStuStr == undefined){
		idStuStr = 0;
	}
	//alert(idStr+major + showType+ idStuStr);
	//return false;
	//进行乱码处理，进行两次encodeURI包装,这里默认传递的都是String类型的，后台必须使用String类型的字符串
	window.location.href=""+tagAction+"?idStr="+encodeURI(encodeURI(idStr))+"&showType="+encodeURI(encodeURI(showType))+"&major="+major+"&address="+encodeURI(encodeURI(address))+"&idStuStr="+encodeURI(encodeURI(idStuStr))+"&searchType="+encodeURI(encodeURI(searchType))+"&searchContext="+encodeURI(encodeURI(searchContext))+"&classesStr = "+classesId+"&sourceCity="+encodeURI(encodeURI(sourceCity))+""; 
}
/**
 * 以下是上传excel的一系列方法
 * */
function validateuploadInforFile(form){
		if(!validateExcelUpLoadFile(form)) return false;
		var options = { 
			dataType: 'json',
			success: showResponse 
		};
		$("#uploadInfor").ajaxSubmit(options); 
		return false;
}

function showResponse(responseText){
  $("#excelUploadMsg").empty();
  $("#excelUploadMsg").append(responseText.msg);
  
}
//导入考试时进行文件格式校验
function validateExcelUpLoadFile(form) {
	var fileName = form.uploadExcel.value;
	
	if (fileName != "" ) {
		var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
		var suppotFile = ["xls", "XLS", "xlsx", "XLSX"];
		for (var i = 0; i < suppotFile.length; i++) {
			if (suppotFile[i] == fileType) {
				return true;
			} else {
				continue;
			}
		}
		alert("文件格式不正确,必须为[xls, XLS, xlsx, XLSX]中一种!");
		return false;
	} else {
		alert("请选择你需要的导入 的文件");
		return false;
	}
}

/**
 * 添加通讯录
 * @param userId
 */
function add2Contact(userId){
	$.ajax({
		url: 'add2Contact.action',
		type: "post",
		data: {
			userId:userId
		},
		dataType: "json",
		cache: false,
		async: false,
		success: function(data) {
			if(data.success){
				alert("添加成功！");
			}else{
				alert("添加失败");
			}
		}
	});
}

/**
 * 删除通讯录
 * @param contactsId
 */
function deleteContacts(contactsId){
	if(confirm("是否确认删除")){
		$.ajax({
			url:'deleteContacts.action',
			type:'post',
			data:{
				contactsId:contactsId
			},
			dataType: "json",
			cache: false,
			async: false,
			success:function(data){
				if(data.success){
					alert("删除成功！");
					$("#middle").load('myContactsList.action',
					{
						sendTime:(new Date()).getTime()
					});
				}else{
					alert("删除失败");
				}
			}
		});
	}else{
		return false;
	}
	
}

/**
 * 添加通讯录
 */
function addContacts(){
	var left = ($("#middle").width() - $(".contactsWindow").width())/2;
	$(".widowTitle span").text("新增通讯录");
	$(".contactsWindow").css({'left':left+'px'});
	$(".overbg").fadeIn("normal");
	$(".contactsWindow").fadeIn("normal");
}

/**
 * 关闭弹出窗
 */
function closeWindow(){
	$(".contactsWindow").fadeOut("normal");
	$(".overbg").fadeOut("normal");
	reset();
}

function checkContacts(){
	var userName = $("#userName").val();
	var contactPhoneNum = $("#contactPhoneNum").val();
	var regular = /1[3-8]+\d{9}/;
	if(!userName){
		$("#errorUserName").text("用户名不能为空");
		$("#errorUserName").fadeIn("normal");
		$("#userName").focus();
		return false;
	}else if(!contactPhoneNum){
		$("#errorUserName").text("");
		$("#errorUserName").fadeOut("normal");
		$("#errorPhoneNum").text("手机号码不能为空");
		$("#errorPhoneNum").fadeIn("normal");
		$("#contactPhoneNum").focus();
		return false;
	}else if(!regular.test(contactPhoneNum)){
		$("#errorUserName").text("");
		$("#errorUserName").fadeOut("normal");
		$("#errorPhoneNum").text("手机号码格式不对");
		$("#errorPhoneNum").fadeIn("normal");
		$("#contactPhoneNum").focus();
		return false;
	}
	return true;
}

/**
 * 添加通讯录提交
 * @returns {Boolean}
 */
function addContactsSubmit(){
	var userName = $("#userName").val();
	var contactPhoneNum = $("#contactPhoneNum").val();
	var contactAddress = $("#contactAddress").val();
	if(checkContacts()){
		$.ajax({
			url:'addContacts.action',
			type:'post',
			data:{
				userName:userName,
				contactPhoneNum:contactPhoneNum,
				contactAddress:contactAddress
			},
			dataType: "json",
			cache: false,
			async: false,
			success:function(data){
				if(data.success){
					closeWindow();
					alert("添加成功成功！");
					$("#middle").load('myContactsList.action',
					{
						sendTime:(new Date()).getTime()
					});
				}else{
					alert("删除失败");
				}
			}
		});
	}
}

function reset(){
	$("#userName").val("");
	$("#contactPhoneNum").val("");
	$("#contactAddress").val();
	$("#errorPhoneNum").text("");
	$("#errorUserName").text("");
	$("#contactAddress").val("");
}

/**
 * 批量删除通讯录
 */
function batchDeleteContacts(){
	var ids = new Array();
	if($("input[name='id']:checked").size()==0){
		alert("请先选择要删除的学生！");
		return false;
	}
	$("input[name='id']:checked").each(function(i,obj){
		ids.push($(obj).val());
	});
	if(confirm("是否确认删除")){
		$.ajax({
			url:'batchDeleteContacts.action',
			type:'post',
			data:{
				ids:ids
			},
			dataType: "json",
			cache: false,
			async: false,
			success:function(data){
				if(data.success){
					alert("删除成功！");
					$("#middle").load('myContactsList.action',
					{
						sendTime:(new Date()).getTime()
					});
				}else{
					alert("删除失败");
				}
			}
		});
	}else{
		return false;
	}
	
}
/**
 * 全选
 */
function checkAll(){
	if($("#checkAll").checked){
		$("input[name='id']").each(function(){
			this.checked = true;
		});
	}else{
		$("input[name='id']").each(function(){
			this.checked = false;
		});
	}
}

/**
 * 修改通讯录
 * @param contactsId
 */
function modifyContacts(contactsId){
	var left = ($("#middle").width() - $(".contactsWindow").width())/2;
	$(".contactsWindow").css({'left':left+'px'});
	$(".widowTitle span").text("修改通讯录");
	var userName = $("#userName_" + contactsId).html();
	var contactPhoneNum = $("#contactPhoneNum_" + contactsId).html();
	var contactAddress = $("#contactAddress_" + contactsId).html();
	$("#userName").val(userName);
	$("#contactPhoneNum").val(contactPhoneNum);
	$("#contactAddress").val(contactAddress);
	$("#contactsId").val(contactsId);
	$(".editBtn").fadeIn("normal");
	$(".addBtn").fadeOut("normal");
	$(".overbg").fadeIn("normal");
	$(".contactsWindow").fadeIn("normal");
}

/**
 * 修改通讯录提交
 * @param contactsId
 */
function eidtContactsSubmit(){
	var userName = $("#userName").val();
	var contactPhoneNum = $("#contactPhoneNum").val();
	var contactAddress = $("#contactAddress").val();
	var contactsId = $("#contactsId").val();
	if(checkContacts()){
		$.ajax({
			url:'updataContacts.action',
			type:'post',
			data:{
				userName:userName,
				contactPhoneNum:contactPhoneNum,
				contactAddress:contactAddress,
				contactsId:contactsId
			},
			dataType: "json",
			cache: false,
			async: false,
			success:function(data){
				if(data.success){
					alert("修改成功");
					$("#middle").load('myContactsList.action',
					{
						sendTime:(new Date()).getTime()
					});
				}else{
					alert("修改失败");
				}
			}
		});
	}
}

function bathAdd2Contacts(currentId){
	var ids = new Array();
	if($("input[name='id']:checked").size()==0){
		alert("请先选择需要加入通讯录的校友！");
		return false;
	}
	$("input[name='id']:checked").each(function(i,obj){
		if($(obj).val() != currentId){
			ids.push($(obj).val());
		}
	});
	$.ajax({
		url:'batchAdd2Contacts.action',
		type:'post',
		data:{
			ids:ids
		},
		dataType: "json",
		cache: false,
		async: false,
		success:function(data){
			if(data.success){
				alert("加入成功！");
			}else{
				alert("加入失败");
			}
		}
	});
}


function add_Resume(){
	var start_time = $("#start_time").val();
	var end_time = $("#end_time").val();
	var company = $("#company").val();
	var post = $("#post").val();
	var desc = $("#desc").val();
	$.ajax({
		url:'addResume.action',
		type:'post',
		data:{
			start_time:start_time,
			end_time:end_time,
			company:company,
			post:post,
			desc:desc
		},
		dataType: "json",
		cache: false,
		async: false,
		success:returnResumeId
	});
}	
var count_for_resume=0;	
function returnResumeId(responseText){
	alert("履历添加成功");
	//alert(encodeURI(responseText.id));
	var backResumeId=encodeURI(responseText.id)+",";
	var oldList=$("#resumeIdList").val();
	$("#resumeIdList").val(oldList+backResumeId);
	$("#start_time").val("");
	$("#end_time").val("");
	$("#company").val("");
	$("#post").val("");
	$("#desc").val("");
	count_for_resume++;
	var content="已创建"+count_for_resume+"份履历";
	$("#countForResume").html(content);
}


//履历修改
function update_Resume(id){
	var start_time = $("#startTM_"+id).val();
	//alert(start_time);
	var end_time = $("#endTM_"+id).val();
	var company = $("#resumeCompany_"+id).val();
	var post = $("#resumePost_"+id).val();
	var desc = $("#resumeDesc_"+id).val();
	var resumeId = $("#resumeId_"+id).val();
	//alert(resumeId);
	$.ajax({
		url:'updateResume.action',
		type:'post',
		data:{
			resumeId:resumeId,
			start_time:start_time,
			end_time:end_time,
			company:company,
			post:post,
			desc:desc
		},
		dataType: "json",
		cache: false,
		async: false,
		success:alert("修改成功")
	});
}

