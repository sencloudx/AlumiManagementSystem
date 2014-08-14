<p style="text-align:center; padding-top:15px">
	管理员账号：<input type="text" id="adminNum"/>
</p>
<p style="text-align:center; padding-top:15px">
	管理员密码：<input type="password" id="adminPw"/>
</p>
<p style="text-align:center; padding-top:15px">
	负责部门：
	<#if majorList?exists>
	   	<#list majorList as majo>
	   		<input type="checkbox" name="major" value=${majo.majorName}>${majo.majorName}&nbsp;&nbsp;
	   	</#list>
   	</#if>
</p>
<p style="text-align:left; padding-top:15px">
	<font color = "red">普通管理员的负责部门一般为4类：1、本科和专科；2、七年制、三年制硕士和博士；3、继续教育；4、教职工（仅供参考）</font>
</p>
<p style="text-align:center; padding-top:15px">
	<input type="button" value="确认添加" onclick="addAdmin('adminAddAction.action', 'adminListAction.action');"/>
</p>