<#import "common/tableCommon.ftl" as common>
<div class="controltitle">当前操作：信息管理——>专业列表</div>
	<span style="float:right; margin-right:10px; margin-top:-4px">
	<table border="0" cellpadding="0" cellspacing="0" class="tab_search">
			<tr>
				<td>
					<input type="text" name="content" title="Search" class="searchinput" id="searchinput" onkeydown="if (event.keyCode == 13) {}" onblur="if(this.value=='')value='- - -关键字- - -';" onfocus="if(this.value=='- - -关键字- - -')value='';" value="- - -关键字- - -" size="10" />
				</td>
				<td>
					<input type="image" width="21" height="17" class="" onclick = "searchInfor('inforListAction.action');" alt="Search" src="/AlumiManagementSystem/images/admin/search.gif" border="0" hspace="2"/>
				</td>
			</tr>
	</table>
	</span>
	<span class="content_button_a_left" onclick="allSelect('id')">全选</span>
	<span class="content_button_a_left" onclick="invertSelect('id')">反选</span>
	<span class="content_button_a_left" onclick="batchDelete('deleteAction.action', 'majorListAction.action');">删除</span>
	<span class="content_button_a_left" onclick="seeDetail(0,this,650, 580,'showMajorAddAction.action');">添加</span>
	<span class="content_button_a_left" onclick="showAddBatchSub(0, 'showBachAddMajorAction.action');"><font color = "red">excel导入</font></span>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div id = "div_print">
	<table class="tablefirst" id="radioSub">
			<col style="width:3%"/>
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:8%"/>
    		<col style="width:8%"/>
    		<tr>
    		<th></th><th>序号</th><th>专业名称</th><th>专业备注</th><th>具体操作</th>
    		</tr>
			<#if majorList_?exists>
		   	<#list majorList_ as major>
		   	<tr onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'">
		   		<td><input type="checkbox" name="id" value="${major.majorId}"/></td>
		   		<td>${major_index+1}</td>
	            <td>${major.majorName}</td>
	            <td>${major.majorRemarks}</td>
	            <td>
	            	<span class="editspan" onclick="seeDetail('${major.majorId}',this,650, 580,'showMajorUpdateAction.action')">修改</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<@common.pageList actionName="majorListAction.action"></@common.pageList>
<span class="content_button_a_left" onclick="allSelect('id')">全选</span>
<span class="content_button_a_left" onclick="invertSelect('id')">反选</span>
<span class="content_button_a_left" onclick="batchDelete('deleteMajorAction.action', 'majorListAction.action');">删除</span>
<span class="content_button_a_left" onclick="seeDetail(0,this,650, 580,'showMajorAddAction.action');">添加</span>
<span class="content_button_a_left" onclick="showAddBatchSub(0, 'showBachAddMajorAction.action');"><font color = "red">excel导入</font></span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>

