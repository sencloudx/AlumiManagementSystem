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
			$("#middle").load('inforListAction.action',
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
	<form action ="inforUpdateAction.action" method ="POST" name="inforUpdate" enctype="multipart/form-data" id="inforUpdateForm" 
			onsubmit="return checkAdd(this);">
	<#if stuInfor?exists>
	<div class="out_ba_examinee_table_outa">
		<div class="out_ba_examinee_table_one">
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
				<input type = "hidden" name = "stuInfor.deleteType" id = "stu_name" value = ${stuInfor.deleteType?default("")}>
				<input type = "hidden" name = "password" id = "stu_name" value = ${stuInfor.password?default("")}>
				<td><input type = "text" name = "stuInfor.stuName" id = "stu_name" value = "${stuInfor.stuName?default("")}"></td>
				<td  rowspan="8" colspan="2" style=" text-align:center">
				<input type = "file" name = "upload" id = "upload">
				</td>
			</tr>
			<tr>
			    <td>学号:</td>
				<td><input type = "text" name = "stuInfor.stuNum" id = "stu_name" value = ${stuInfor.stuNum?default("")}></td>
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
				<td><input type = "text" name = "stuInfor.stuJg" id = "stu_name" value = ${stuInfor.stuJg?default("")}></td>
			</tr>
			<tr>
			    <td>专业:</td>
				<td>
				<select name = "major" id = "classes">
					<option value=${stuInfor.major.majorId!} selected = selected>${stuInfor.major.majorName?default("")}</option>
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
				<td><input type = "text" name = "stuInfor.stuPostcode" id = "stu_name" value = ${stuInfor.stuPostcode?default("")}></td>
			</tr>
			<tr>
			    <td>入学时间:</td>
				<td><input type="text" id="newsTime" name ="stuInfor.stuStartTime" onFocus="WdatePicker()" value = ${stuInfor.stuStartTime?default("")}></td>
			</tr>
			<tr>
			    <td>毕业时间:</td>
				<td><input type="text" id="newsTime" name ="stuInfor.stuEndTime" onFocus="WdatePicker()" value = ${stuInfor.stuEndTime?default("")}></td>
			</tr>
			<tr>
			    <td>工作省市:</td>
			    <td><input type = "text" name = "stuInfor.stuWorkAddress" id = "stu_name" value = ${stuInfor.stuWorkAddress?default("")}></td>
				<td>工作单位:</td>
				<td><input type = "text" name = "stuInfor.stuWorkPlace" id = "stu_name" value = ${stuInfor.stuWorkPlace?default("")}></td>
			</tr>
			<tr>
			    <td>工作岗位:</td>
				<td><input type = "text" name = "stuInfor.stuWorkPost" id = "stu_name" value = ${stuInfor.stuWorkPost?default("")}></td>
				<td>工作职务:</td>
				<td><input type = "text" name = "stuInfor.stuWorkZc" id = "stu_name" value = ${stuInfor.stuWorkZc?default("")}></td>
			</tr>
			<!--
				<tr>
				    <td>医师职称:</td>
					<td>
						<select name = "docProtitleId" id = "docProtitle">
						<option value=${(stuInfor.docProtitle.docProtitleId)?default(0)} selected = selected>${(stuInfor.docProtitle.docProtitleName)?default("")}</option>
						<#if docProtitleList?exists>
					   		<#list docProtitleList as doc>
					   			<option value=${doc.docProtitleId}>${doc.docProtitleName}</option>
					   		</#list>
					   	</#if>
						</select>
					<td>教师职称:</td>
					<td>
						<select name = "teaProtitleId" id = "teaProtitle">
						<option value=${(stuInfor.teaProtitle.teaProtitleId)?default(0)} selected = selected>${(stuInfor.teaProtitle.teaProtitleName)?default("")}</option>
						<#if teaProtitleList?exists>
					   		<#list teaProtitleList as tea>
					   			<option value=${tea.teaProtitleId}>${tea.teaProtitleName}</option>
					   		</#list>
					   	</#if>
						</select>
					</td>
				</tr>
			<tr>
			-->
			    <td>办公电话:</td>
				<td><input type = "text" name = "stuInfor.stuPhone" id = "stu_name" value = ${stuInfor.stuPhone?default("")}></td>
			    <td>移动电话:</td>
				<td><input type = "text" name = "stuInfor.stuTelephone" id = "stu_name" value = ${stuInfor.stuTelephone?default("")}></td>
			</tr>
			<tr>
			    <td>QQ号码:</td>
				<td><input type = "text" name = "stuInfor.stuQq" id = "stu_name" value = ${stuInfor.stuQq?default("")}></td>
			    <td>邮箱:</td>
				<td><input type = "text" name = "stuInfor.stuEmail" id = "stu_name" value = ${stuInfor.stuEmail?default("")}></td>
			</tr>
			<tr>
			    <td>通信地址:</td>
				<td><input type = "text" name = "stuInfor.stuCommAddress" id = "stu_name" value = "${stuInfor.stuCommAddress?default("")}"></td>
			    <td>家庭地址:</td>
				<td><input type = "text" name = "stuInfor.stuAddress" id = "stu_name" value = ${stuInfor.stuAddress?default("")}></td>
			</tr>
			<tr>
			    <td>生源地:</td>
			    <td><input type = "text" name = "stuInfor.stuBirth" id = "stu_name" value = "${stuInfor.stuBirth?default("")}"></td>
			    <td>所属班级:</td>
			    <td>
			    <select name = "classesId" id = "classes">
			    	<option value=${stuInfor.classes.classesId} selected = selected>${(stuInfor.classes.classesName)?default("")}</option>
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
			    <td><input type = "text" name = "stuInfor.stuNation" id = "stu_name" value = "${stuInfor.stuNation?default("")}"></td>
			    <td>身份证号:</td>
			    <td><input type = "text" name = "stuInfor.stuSfzh" id = "stu_name" value = "${stuInfor.stuSfzh?default("")}"></td>
			</tr>
			<tr>
			    <td>最终学历与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXl" id = "stu_name" value = "${stuInfor.lastXl?default("")}"></td>
			    <td>最终学位与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXw" id = "stu_name" value = "${stuInfor.lastXw?default("")}"></td>
			</tr>
			<tr>
			    <td>获奖情况:</td>
			    <td colspan="3">
			    <textarea name = "stuInfor.sruHonour" id = "stu_name" rows = "6" cols = "60">${stuInfor.sruHonour?default("")}</textarea>
			    </td>
			</tr>
			<tr>
				<td>个人简历:</td>
			    <td colspan="3">
			    <textarea name = "stuInfor.stuResume" id = "stu_name" rows = "6" cols = "60">${stuInfor.stuResume?default("")}</textarea>
			    </td>
			</tr>
			<tr>
			    <td>校友类型:</td>
			    <#if Session.adminType == "高级管理员">
			    <td>
			    <select name = "stuInfor.stuType" id = "stuInfor.stuType">
			    		<option value = "${stuInfor.stuType}">${stuInfor.stuType?default("")}</option>
		    			<option value="普通校友">普通校友</option>
		    			<option value="联络员">联络员</option>
		    			<option value="理事">理事</option>
				</select>
			    </td>
			    <#else>
			    <td>
			    <input name = "stuInfor.stuType" type = "hidden" value = "${stuInfor.stuType?default("")}">
			    ${stuInfor.stuType}
			    </td>
			    </#if>
			</tr>
			<tr>
				<td>履历修改</td>
				<td colspan="3">
					<#if resumeList.size()!=0>
						<#list resumeList as res>
						<div>
							<div class="resume_title">个人履历</div>
							<div style="display:none;"><input id="resumeId_${res.resumeId}" value="${res.resumeId?default("")}"/></div>
							<div>
								<span class="resume_span">&nbsp;开始时间:</span>
								<input id="startTM_${res.resumeId}" value="${res.startTM?default("")}" onFocus="WdatePicker()"/>
								
								<span class="resume_span">结束时间:<span>
								<input id="endTM_${res.resumeId}" value="${res.endTM?default("")}" onFocus="WdatePicker()"/>
								
							<div>
							<div>
								<span class="resume_span">所在公司:<span>
								<input id="resumeCompany_${res.resumeId}"  value="${res.resumeCompany?default("")}"/>
								
								<span class="resume_span">&nbsp;&nbsp;&nbsp;职务:&nbsp;&nbsp;&nbsp;<span>
								<input id="resumePost_${res.resumeId}"  value="${res.resumePost?default("")}"/>
								
							</div>
							<div>
								<span class="resume_span">履历详情:<span><br>
								<textarea class="resume_span" id="resumeDesc_${res.resumeId}"   rows = "6" cols = "70">${res.resumeDesc?default("")}</textarea>
								
							<div>
							<div class="resume_bottom">
								<input type="button" class="reusume_button" value="保存当前的履历" onClick="update_Resume('${res.resumeId}')">
							</div>
						</div>	
						</#list>
						
					<#else>
					</#if>
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
