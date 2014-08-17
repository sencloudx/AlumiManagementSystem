<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生信息更改</title>
	<link type="text/css" rel="stylesheet" href="/AlumiManagementSystem/css/common.css" />
	<script type="text/javascript">
		function checkAdd(form){
			var currentPage=$("#currentPage").val();  //获取当前页
			var options = { 
				dataType: 'json',
				success: inforUpdateResponse 
			};
			$("#inforUpdateForm").ajaxSubmit(options); 
			return false;
		}
		//回调
		function inforUpdateResponse(responseText){
			//alert("页面"+currentPage);
		  	alert(responseText.msg);
		  	$("#middle").empty();
			$("#middle").load('myInforDetailAction.action',
			{
				sendTime:(new Date()).getTime()
			}
			);
			$("#shield").fadeOut(400);
			$("#subDetailWrapper").fadeOut(400);
		}
	</script>
	</head>
	<body>
	<form action ="myInforUpdateAction.action" method ="POST" name="inforUpdate" enctype="multipart/form-data" id="inforUpdateForm" 
			onsubmit="return checkAdd(this);">
	<#if stuInfor?exists>
	<div class="out_ba_examinee_table_outa">
		<div class="out_ba_examinee_table_one" style="margin:0 auto">
		<div class="table_bordre">
		      <span>修改信息</span>
		</div>
		<table  class="bs_examinee_table">
		   <col class="bs_examinee_fir"/>
		   <col class="bs_examinee_second"/>
		   <col class="bs_examinee_third"/>
		   <col class="bs_examinee_forth"/>
			<tr>
				<td>姓名:</td>
				<input type = "hidden" name = "stuInfor.stuId" id = "stu_name" value = ${stuInfor.stuId}>
				<input type = "hidden" name = "stuInfor.deleteType" id = "stu_name" value = ${stuInfor.deleteType}>
				<td><input type = "text" name = "stuInfor.stuName" id = "stu_name" value = "${stuInfor.stuName}"></td>
				<td  rowspan="8" colspan="2" style=" text-align:center">
				<input type = "file" name = "upload" id = "upload">
				</td>
			</tr>
			<tr>
			    <td>学号:</td>
				<td><input type = "text" name = "stuInfor.stuNum" id = "stu_name" value = ${stuInfor.stuNum}></td>
			</tr>
			<tr>
			    <td>性别:</td>
			    <#if stuInfor.stuSex == "男">
				<td><input type="radio"  name = "stuInfor.stuSex"  id="stu_sex" value = "男" checked>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
	            	<input type="radio"  name = "stuInfor.stuSex"  id="stu_sex" value = "女">&nbsp;女</td>
	            <#else>
	            <td><input type="radio"  name = "stuInfor.stuSex"  id="stu_sex" value = "男">&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
	            	<input type="radio"  name = "stuInfor.stuSex"  id="stu_sex" value = "女" checked>&nbsp;女</td>
	            </#if>
			</tr>
			<tr>
			    <td>籍贯:</td>
				<td><input type = "text" name = "stuInfor.stuJg" id = "stu_name" value = ${stuInfor.stuJg}></td>
			</tr>
			<tr>
			    <td>专业:</td>
				<td>
				<select name = "major" id = "classes">
					<option value=${stuInfor.major.majorId} selected = selected>${stuInfor.major.majorName}</option>
					<#if majorList?exists>
				   	<#list majorList as major>
				   		<option value=${major.majorId}>${major.majorName}</option>
				   	</#list>
				   	</#if>
				</select>
				</td>
			</tr>
			<tr>
			    <td>邮编:</td>
				<td><input type = "text" name = "stuInfor.stuPostcode" id = "stu_name" value = ${stuInfor.stuPostcode}></td>
			</tr>
			<tr>
			    <td>入学时间:</td>
				<td><input type="text" id="newsTime" name ="stuInfor.stuStartTime" onFocus="WdatePicker()" value = ${stuInfor.stuStartTime}></td>
			</tr>
			<tr>
			    <td>毕业时间:</td>
				<td><input type="text" id="newsTime" name ="stuInfor.stuEndTime" onFocus="WdatePicker()" value = ${stuInfor.stuEndTime}></td>
			</tr>
			<tr>
			    <td>工作省市:</td>
			    <td><input type = "text" name = "stuInfor.stuWorkAddress" id = "stu_name" value = ${stuInfor.stuWorkAddress}></td>
				<td>工作单位:</td>
				<td><input type = "text" name = "stuInfor.stuWorkPlace" id = "stu_name" value = ${stuInfor.stuWorkPlace}></td>
			</tr>
			<tr>
			    <td>工作岗位:</td>
				<td><input type = "text" name = "stuInfor.stuWorkPost" id = "stu_name" value = ${stuInfor.stuWorkPost}></td>
				<td>工作职称:</td>
				<td><input type = "text" name = "stuInfor.stuWorkZc" id = "stu_name" value = ${stuInfor.stuWorkZc}></td>
			</tr>
			<tr>
			    <td>办公电话:</td>
				<td><input type = "text" name = "stuInfor.stuPhone" id = "stu_name" value = ${stuInfor.stuPhone}></td>
			    <td>移动电话:</td>
				<td><input type = "text" name = "stuInfor.stuTelephone" id = "stu_name" value = ${stuInfor.stuTelephone}></td>
			</tr>
			<tr>
			    <td>QQ号码:</td>
				<td><input type = "text" name = "stuInfor.stuQq" id = "stu_name" value = ${stuInfor.stuQq}></td>
			    <td>邮箱:</td>
				<td><input type = "text" name = "stuInfor.stuEmail" id = "stu_name" value = ${stuInfor.stuEmail}></td>
			</tr>
			<tr>
			    <td>通信地址:</td>
				<td><input type = "text" name = "stuInfor.stuCommAddress" id = "stu_name" value = "${stuInfor.stuCommAddress}"></td>
			    <td>家庭地址:</td>
				<td><input type = "text" name = "stuInfor.stuAddress" id = "stu_name" value = ${stuInfor.stuAddress}></td>
			</tr>
			<tr>
			    <td>生源地:</td>
			    <td><input type = "text" name = "stuInfor.stuBirth" id = "stu_name" value = "${stuInfor.stuBirth}"></td>
			    <td>所属班级:</td>
			    <td>
			    <select name = "classesId" id = "classes">
			    	<option value=${stuInfor.classes.classesId} selected = selected>${stuInfor.classes.classesName}</option>
					<#if classesList?exists>
				   	<#list classesList as class>
				   		<option value=${class.classesId}>${class.classesName}</option>
				   	</#list>
				   	</#if>
				</select>
			    </td>
			</tr>
			<tr>
			    <td>所在国家:</td>
			    <td><input type = "text" name = "stuInfor.stuNation" id = "stu_name" value = "${stuInfor.stuNation}"></td>
			    <td>身份证号:</td>
			    <td><input type = "text" name = "stuInfor.stuSfzh" id = "stu_name" value = "${stuInfor.stuSfzh}"></td>
			</tr>
			<tr>
			    <td>最终学历与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXl" id = "stu_name" value = "${stuInfor.lastXl}"></td>
			    <td>最终学位与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXw" id = "stu_name" value = "${stuInfor.lastXw}"></td>
			</tr>
			<tr>
			    <td>获奖情况:</td>
			    <td colspan="3">
			    <textarea name = "stuInfor.sruHonour" id = "stu_name" rows = "6" cols = "60">${stuInfor.sruHonour}</textarea>
			    </td>
			</tr>
			<tr>
				<td>个人简历:</td>
			    <td colspan="3">
			    <textarea name = "stuInfor.stuResume" id = "stu_name" rows = "6" cols = "60">${stuInfor.stuResume}</textarea>
			    </td>
			</tr>
			<tr>
			    <td>校友类型:</td>
			    <td>
			    <input name = "stuInfor.stuType" type = "hidden" value = "${stuInfor.stuType}">
			    ${stuInfor.stuType}
			    </td>
			</tr>
		</table>
		<input type = "submit" name = "test" value = "确定修改">	
		</div>
	</div>
	</#if>
	
	</form>
	</body>
</html>
