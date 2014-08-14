<div class="controltitle">所属位置：${city}</div>
	&nbsp;&nbsp;&nbsp;&nbsp;<b>视图切换:</b>;
	<select name = "major" id = "major" onchange = "return showChange('showSpreadByCityAction.action');">
    		<option value="0" selected="selected">全部专业</option>
			<#if majorList?exists>
		   	<#list majorList as majo>
		   		<option value=${majo.majorName} <#if majo.majorName == major> selected = "selected" </#if>>${majo.majorName}</option>
		   	</#list>
		   	</#if>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<span >
	&nbsp;&nbsp;<b>视图人数：</b><font color = "red">[${totalRecord}]</font>
	&nbsp;&nbsp;<b>眼博：</b><font color = "red">[${eyeb}]</font>
	&nbsp;&nbsp;<b>眼硕：</b><font color = "red">[${eyes}]</font>
	&nbsp;&nbsp;<b>眼7：</b><font color = "red">[${eye7}]</font>
	&nbsp;&nbsp;<b>眼本：</b><font color = "red">[${eye5}]</font>
	&nbsp;&nbsp;<b>眼技：</b><font color = "red">[${eye3}]</font>
	&nbsp;&nbsp;<b>教师：</b><font color = "red">[${eyetea}]</font>
	&nbsp;&nbsp;<b>继续教育：</b><font color = "red">[${eyejx}]</font>
	</span>
	<span class="content_button_a_right" onclick="printdiv('div_print');">打印</span>
	<div id = "div_print">
	<input type = "hidden" name = "city" id = "city" value = ${city}>
	<table class="tablefirst" id="radioSub">
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
    		<tr>
    		<th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>入学年份</th><th>毕业年份</th><th>工作省市</th><th>工作单位</th><th>岗位</th><th>职称</th>
    		<th>办公电话</th><th>手机号</th><th>QQ</th><th>电子邮箱</th><th>通信地址</th><th>家庭地址</th>
    		</tr>
			<#if inforList?exists>
		   	<#list inforList as infor>
		   	<tr>
	            <td>${infor.stuNum}</td>
	            <td>${infor.stuName}</td>
	            <td>${infor.stuSex}</td>
	            <td>${infor.major.majorName}</td>
	            <td>${infor.stuStartTime}</td>
	            <td>${infor.stuEndTime}</td>
	            <td>${infor.stuWorkAddress}</td>
	            <td>${infor.stuWorkPlace}</td>
	            <td>${infor.stuWorkPost}</td>
	            <td>${infor.stuWorkZc}</td>
	            
	            <td>${infor.stuPhone}</td>
	            <td>${infor.stuTelephone}</td>
	            <td>${infor.stuQq}</td>
	            <td>${infor.stuEmail}</td>
	            <td>${infor.stuCommAddress}</td>
	            <td>${infor.stuAddress}</td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
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