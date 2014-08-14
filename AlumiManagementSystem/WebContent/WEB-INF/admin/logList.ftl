<div class="controltitle">当前操作：系统工具——>日志信息</div>
	<div id = "div_print">
	<table class="tablefirst" id="radioSub">
			<col style="width:3%"/>
			<col style="width:5%"/>
   			<col style="width:5%"/>
    		<col style="width:10%"/>
    		<col style="width:28%"/>
    		<tr>
    		<th>序号</th><th>操作人员</th><th>类型</th><th>操作日期</th><th>具体操作</th>
    		</tr>
			<#if operateLogList?exists>
		   	<#list operateLogList as log>
		   	<tr onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'">
		   		<td>${log_index+1}</td>
	            <td>${stuInforService.getStuName("超级管理员", log.userId)}</td>
	            <td>${log.userType?default("")}</td>
	            <td>${log.createtime?default("")}</td>
	            <td>${log.logmsg?default("")}</td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>
