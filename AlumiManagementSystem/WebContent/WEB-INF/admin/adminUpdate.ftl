<input type = "hidden" id = "id" value = ${admin.adminId}></input>
<p style="text-align:center; padding-top:15px">
	管理员账号：<input type="text" id="adminNum" value = ${admin.adminNum}>
</p>
<p style="text-align:center; padding-top:15px">
	管理员密码：<input type="text" id="adminPw" value = ${admin.adminPw}>
</p>
<p style="text-align:center; padding-top:15px">
	负责部门：
	<#if majorList?exists>
	   	<#list majorList as majo>
	   		<input type="checkbox" name="major" value=${majo.majorName}>${majo.majorName}&nbsp;&nbsp;
	   	</#list>
   	</#if>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="修改" onclick="addAdmin('updateAdminAction.action', 'adminListAction.action');"/>
</p>