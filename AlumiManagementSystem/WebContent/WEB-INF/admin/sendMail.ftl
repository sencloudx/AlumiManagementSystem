<#assign FCK=JspTaglibs["/WEB-INF/FCKeditor.tld"] />
<form method="POST" action="sendMailAction.action" enctype="multipart/form-data" target="infor_hidden_frame">
	<input type="hidden" id = "idStr" value="${idStr?default("")}"/>
	<p style="text-align:left; padding-top:15px">
		邮件主题：<br/>
		<textarea name = "subject" id = "subject" rows = "3" cols = "170" style = "overflow:hidden"></textarea>
	</p>
	<div>
		邮件内容：<br/>
 	 	<@FCK.editor id="message" basePath="/AlumiManagementSystem/FCKeditor/"  
			      toolbarSet="Plan"
			      height="300"
			      width="1100"
				>  
		</@FCK.editor> 
	</div>
	<input type="hidden" name="content" id="content">
	<p style="text-align:center; padding-top:15px">
		<input type="button" value = "发送邮件" onclick = "sendMail('sendMailAction.action');"/>
	</p>
</form>
<iframe name='infor_hidden_frame' id="infor_hidden_frame" style='display:none'></iframe>
<p style="text-align:left; padding-top:15px">
邮件接收对象：
		<table name = "infor" border = "1">
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:10%"/>
    		<tr>
    		<th>序号</th><th>学生学号</th><th>学生姓名</th><th>校友类型</th><th>邮箱地址</th>
    		</tr>
			<#if stuList?exists>
		   	<#list stuList as stu>
		   	<tr>
		   		<td>${stu_index+1}</td>
	            <td>${stu.stuNum}</td>
	            <td>${stu.stuName}</td>
	            <td>${stu.stuType}</td>
	            <td>${stu.stuEmail}</td>
	        </tr>
		   	</#list>
		   	</#if>
</table>
</p>
