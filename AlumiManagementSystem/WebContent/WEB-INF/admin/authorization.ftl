<p style="text-align:center; padding-top:15px">
	要授予的权限：
	<select name = "authorization" id = "authorization">
    		<option value=0 selected="selected">--选择权限--</option>
			<option value='理事'>理事</option>
			<option value='联络员'>联络员</option>
	</select>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value = "确认授权" onclick="authorization();"/>
</p>
<p style="text-align:center; padding-top:15px">
 需要被授权的校友
		<table name = "infor" border = "1">
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:8%"/>
    		<col style="width:5%"/>
    		<tr>
    		<th>序号</th><th>学生学号</th><th>学生姓名</th><th>校友类型</th>
    		</tr>
			<#if stuList?exists>
		   	<#list stuList as stu>
		   	<tr>
		   		<td>${stu_index+1}</td>
	            <td>${stu.stuNum}</td>
	            <td>${stu.stuName}</td>
	            <td>${stu.stuType}</td>
	        </tr>
		   	</#list>
		   	</#if>
</table>
</p>