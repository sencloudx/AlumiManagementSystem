<div class="controltitle">当前操作：信息管理——>学生信息列表-->学生信息的打印</div>
<span class="content_button_a_left" onclick="printdiv('div_print');">打印</span>
	<div id = "div_print">
	<table style="width:2500px;" class="tablefirst" id="radioSub">
			<#-- --------
			<col style="width:5%"/>
			<col style="width:5%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
			<col style="width:5%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
			<col style="width:5%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>  --------------->
    		<tr>
    		<th width="100">学号</th><th width="100">姓名</th><th width="60">性别</th><th width="100">专业</th><th width="100">入年</th><th width="100">毕年</th><th width="100">业省</th><th width="100">工单</th><th width="100">岗位</th><th width="100">职称</th>
    		<th width="100">电话</th><th width="100">手机</th><th width="100">通信</th><th width="100">地址</th>
    		<th width="100">身份证</th><th width="100">国家</th><th width="100">学历</th><th width="100">学位</th><th width="100">类型</th><th width="100">班级</th><th width="100">生源</th>
    		</tr>
			<#if inforList?exists>
		   	<#list inforList as infor>
		   	<tr>
	            <td>${infor.stuNum?default("")}</td>
	            <td>${infor.stuName?default("")}</td>
	            <td>${infor.stuSex?default("")}</td>
	            <td>${(infor.major.majorName)?default("")}</td>
	            <td>${infor.stuStartTime?default("")}</td>
	            <td>${infor.stuEndTime?default("")}</td>
	            <td>${infor.stuWorkAddress?default("")}</td>
	            <td>${infor.stuWorkPlace?default("")}</td>
	            <td>${infor.stuWorkPost?default("")}</td>
	            <td>${infor.stuWorkZc?default("")}</td>
	            
	            <td>${infor.stuPhone?default("")}</td>
	            <td>${infor.stuTelephone?default("")}</td>
	            <td>${infor.stuCommAddress?default("")}</td>
	            <td>${infor.stuAddress?default("")}</td>
	            
	            <td>${infor.stuSfzh?default("")}</td>
	            <td>${infor.stuNation?default("")}</td>
	            <td>${infor.lastXl?default("")}</td>
	            <td>${infor.lastXw?default("")}</td>
	            <td>${infor.stuType?default("")}</td>
	            <td>${(infor.classes.classesName)?default("")}</td>
	            <td>${infor.stuBirth?default("")}</td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>
<script>
	function printdiv(printpage){
		var headstr = "<html><head><title></title></head><body>";
		var footstr = "</body></html>";
		var newstr = document.all.item(printpage).innerHTML;
		var oldstr = document.body.innerHTML;
		document.body.innerHTML = headstr+newstr+footstr;
		window.print();
		document.body.innerHTML = oldstr;
		return false;
	}
</script>