<div class="controltitle">当前操作：信息管理——>普通管理员列表</div>
	<div id = "div_print">
	<table class="tablefirst" id="radioSub">
			<col style="width:3%"/>
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:18%"/>
    		<col style="width:5%"/>
    		<tr>
    		<th></th><th>序号</th><th>管理员账号</th><th>管理员密码</th><th>管理员权限</th><th>负责部门</th><th>具体操作</th>
    		</tr>
			<#if adminList?exists>
		   	<#list adminList as admin>
		   	<tr onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'">
		   		<td><input type="checkbox" name="id" value="${admin.adminId}"/></td>
		   		<td>${admin_index+1}</td>
	            <td>${admin.adminNum}</td>
	            <td>${admin.adminPw}</td>
	            <td>${admin.adminRight}</td>
	            <td>${admin.manageRange}</td>
	            <td>
	            	<#--<span class="editspan" onclick="seeDetail('${admin.adminId}',this,650, 580,'showAdminUpdateAction.action')">修改</span>&nbsp;&nbsp;&nbsp;&nbsp;-->
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<span class="content_button_a_left" onclick="allSelect('id')">全选</span>
<span class="content_button_a_left" onclick="invertSelect('id')">反选</span>
<span class="content_button_a_left" onclick="batchDelete('deleteAdminAction.action', 'adminListAction.action');">删除</span>
<span class="content_button_a_left" onclick="seeDetail(0,this,650, 580,'showAdminAddAction.action');">添加</span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>
