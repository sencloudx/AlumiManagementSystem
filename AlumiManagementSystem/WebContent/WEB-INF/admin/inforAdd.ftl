<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<div class="controltitle">当前操作：信息管理——>添加学生信息</div>
<form action ="inforAddAction.action" method ="POST" name="inforAdd" enctype="multipart/form-data" id="inforAddForm">
	<table class="tablefirst" id="radioSub">
			<col style="width:5%"/>
			<col style="width:10%"/>
   			<col style="width:5%"/>
    		<col style="width:10%"/>
    		<tr>
    		<th>操作明细</th><th>写入</th><th>操作明细</th><th>写入</th>
    		</tr>
		   	<tr>
		   		<td>学生姓名：</td>
		   		<td><input type = "text" name = "stuInfor.stuName" id = "stuName"></td>
	            <td>学生性别：</td>
	            <td><input type="radio"  name = "stuInfor.stuSex"  id="stuSexMale" value = "男" checked>&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
	            	<input type="radio"  name = "stuInfor.stuSex"  id="stuSexFemal" value = "女">&nbsp;女</td>
		   	</tr>
		   	<tr>
		   		<td>学生学号：</td>
		   		<td><input type = "text" name = "stuInfor.stuNum" id = "stuNum"></td>
	            <td>所属专业：</td>
	            <td>
	            	<select name = "major" id = "classes">
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
		   		<td><input type = "text" name = "stuInfor.stuPostcode" id = "stuPostcode"></td>
	            <td>学生籍贯:</td>
	            <td><input type = "text" name = "stuInfor.stuJg" id = "stuJg"></td>
		   	</tr>
		   	<tr>
		   		<td>入学年份:</td>
		   		<td><input type="text" id="newsTime" name ="stuInfor.stuStartTime" onFocus="WdatePicker()"/></td>
	            <td>毕业年份:</td>
	            <td><input type="text" id="newsTime" name ="stuInfor.stuEndTime" onFocus="WdatePicker()"/></td>
		   	</tr>
		   	<tr>
		   		<td>就业省市:</td>
		   		<td><input type = "text" name = "stuInfor.stuWorkAddress" id = "stuWorkAddress"><font color = "red">&nbsp;&nbsp;*省+市[如浙江杭州]</font></td>
	            <td>工作单位:</td>
	            <td><input type = "text" name = "stuInfor.stuWorkPlace" id = "stuWorkPlace"></td>
		   	</tr>
		   	<tr>
		   		<td>工作岗位:</td>
		   		<td><input type = "text" name = "stuInfor.stuWorkPost" id = "stuWorkPost"></td>
	            <td>职务:</td>
	            <td><input type = "text" name = "stuInfor.stuWorkZc" id = "stuWorkZc"></td>
		   	</tr>
		   	<tr style="display:none">
		   		<td>医师职称:</td>
		   		<td>
		   			<select name = "docProtitleId" id = "docProtitle">
					<#if docProtitleList?exists>
				   		<#list docProtitleList as doc>
				   			<option value="1">${doc.docProtitleName}</option>
				   		</#list>
				   	</#if>
					</select>
		   		</td>
	            <td>教师职称:</td>
	            <td>
	            	<select name = "teaProtitleId" id = "teaProtitle">
					<#if teaProtitleList?exists>
				   		<#list teaProtitleList as tea>
				   			<option value="1">${tea.teaProtitleName}</option>
				   		</#list>
				   	</#if>
					</select>
	            </td>
		   	</tr>
		   	<tr>
		   		<td>办公电话:</td>
		   		<td><input type = "text" name = "stuInfor.stuPhone" id = "stuPhone"></td>
	            <td>手机号码:</td>
	            <td><input type = "text" name = "stuInfor.stuTelephone" id = "stuTelephone"></td>
		   	</tr>
		   		<tr>
		   		<td>QQ号码:</td>
		   		<td><input type = "text" name = "stuInfor.stuQq" id = "stuQq"></td>
	            <td>电子邮箱:</td>
	            <td><input type = "text" name = "stuInfor.stuEmail" id = "stuEmail"></td>
		   	</tr>
		   	<tr>
		   		<td>通信地址：</td>
		   		<td><input type = "text" name = "stuInfor.stuCommAddress" id = "stuCommAddress"></td>
	            <td>家庭地址:</td>
	            <td><input type = "text" name = "stuInfor.stuAddress" id = "stuAddress"></td>
		   	</tr>
		   	<tr>
			    <td>生源地:</td>
			    <td><input type = "text" name = "stuInfor.stuBirth" id = "stuBirth"><font color = "red">&nbsp;&nbsp;*省+市[如浙江杭州]</font></td>
			    <td>所属班级:</td>
			    <td>
			   	<select name = "classesId" id = "classes">
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
			    <td><input type = "text" name = "stuInfor.stuNation" id = "stuNation"></td>
			    <td>身份证号:</td>
			    <td><input type = "text" name = "stuInfor.stuSfzh" id = "stuSfzh"></td>
			</tr>
			<tr>
			    <td>最终学历与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXl" id = "lastXl"></td>
			    <td>最终学位与学校:</td>
			    <td><input type = "text" name = "stuInfor.lastXw" id = "lastXw"></td>
			</tr>
			<tr>
			<#-- cols 列数-->
			    <td>获奖情况:</td>
			    <td colspan="4">
			    <textarea name = "stuInfor.sruHonour" id = "sruHonour" rows = "6" cols = "100"></textarea>
			    </td>
			</tr>
			<tr>
				<td>个人简历:</td>
			    <td colspan="4">
			    <textarea name = "stuInfor.stuResume" id = "stuResume" rows = "6" cols = "100"></textarea>
			    </td>
			</tr>
			<tr>
			    <td>校友类型:</td>
			    <td>
			    	<select name = "stuInfor.stuType" id = "stuInfor.stuType">
		    			<option value="普通校友">普通校友</option>
		    			<option value="联络员">联络员</option>
		    			<option value="理事">理事</option>
					</select>
			    </td>
				<td>头像上传：</td>
		   		<td><input type = "file" name = "upload" id = "upload"></td>
			</tr>
</table>
<input type = "button" id="addSubmit" name = "test" value = "确定存储">
<input type = "button" name = "test" value = "返回列表" onclick = "showAddBatchSub(0, 'inforListAction.action');">
</form>
<script type="text/javascript">
function checkAdd(form){
    var stuTelephone = $("#stuTelephone").val();
    var stuEmail = $("#stuEmail").val();
    var emailRegular = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    var mobileRegular = /1[3-8]+\d{9}/;
    if(stuTelephone && !mobileRegular.test(stuTelephone)){
        alert("手机号码格式不对，请重新输入");
        $("#stuTelephone").focus();
        return false;
    }else if(stuEmail && !emailRegular.test(stuEmail)){
        alert("邮箱格式不对，请重新输入");
        $("#stuEmail").focus();
        return false;
    }else{
        var options = { 
		    dataType: 'json',
		    success: inforAddResponse 
		};
		$("#inforAddForm").ajaxSubmit(options); 
		return false;
    }
	
}

$("#addSubmit").click(function(){
   if(checkForm()){
        //$("#inforAddForm").submit();
        var options = { 
		    dataType: 'json',
		    success: inforAddResponse 
		};
		$("#inforAddForm").ajaxSubmit(options);
		return false;
    }
});

function checkForm(){
    //校验手机号码、邮箱、用户名、学号、身份证号码、入学年份跟毕业年份的先后
    var stuName = $("#stuName").val();
    var stuNum = $("#stuNum").val();
    var stuTelephone = $("#stuTelephone").val();
    var stuEmail = $("#stuEmail").val();
    var stuSfzh = $("#stuSfzh").val();
    var emailRegular = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    var mobileRegular = /1[3-8]+\d{9}/;
    var idCardRegular = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if(!stuName){
        alert("学生姓名不能为空");
        $("#stuName").focus();
        return false;
    }
    if(!stuNum){
        alert("学生学号不能为空");
        $("#stuNum").focus();
        return false;
    }
    if(!stuSfzh){
         alert("身份证号不能为空");
         $("#stuSfzh").focus();
         return false;
    }else if(!idCardRegular.test(stuSfzh)){
        alert("身份证号格式不对，请重新输入");
        $("#stuSfzh").focus();
        return false;
    }
    if(!stuTelephone){
        alert("手机号码不能为空");
        $("#stuTelephone").focus();
        return false;
    }else if(!mobileRegular.test(stuTelephone)){
        alert("手机号码格式不对，请重新输入");
        $("#stuTelephone").focus();
        return false;
    }
    if(!stuEmail){
        alert("邮箱不能为空");
        $("#stuEmail").focus();
        return false;
    }else if(!emailRegular.test(stuEmail)){
        alert("邮箱格式不对，请重新输入");
        $("#stuEmail").focus();
        return false;
    }
   return true;
}

//回调
function inforAddResponse(responseText){
    
    alert(encodeURI(responseText.msg));
    //$("#inforAddMsg").empty();
    //$("#inforAddMsg").append(responseText.msg);
}
</script>
</html>