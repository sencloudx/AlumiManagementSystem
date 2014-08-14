<#import "common/tableCommon.ftl" as common>
<div class="controltitle">当前操作：问卷调查题库</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<big>相关试题搜索：</big>
	范围:&nbsp;<select name="type" id="type">
    		<option value="0" selected="selected">全部</option>
    		<option value="1" >题干</option>
    		<option value="2" >选项A</option>
    		<option value="3" >选项B</option>
    		<option value="4" >选项C</option>
    		<option value="5" >选项D</option>
    		<option value="6" >选项E</option>
	</select>&nbsp;&nbsp;
	内容:&nbsp;<input type="text" id="search" name="search" value="">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onclick="searchSingle('单选题','singleSearchAction.action');" value="查询">
	<table class="tablefirst" id="radioSub">
			<col style="width:5%"/>
			<col style="width:5%"/>
			<col style="width:11%"/>
   			<col style="width:20%"/>
    		<col style="width:20%"/>
    		<col style="width:11%"/>
    		<tr>
    		<th></th><th>序号</th><th>题目类型</th><th>题干</th><th>选项</th><th>基本操作</th>
    		</tr>
			<#if queBankList?exists>
		   	<#list queBankList as que>
		   	<tr>
		   		<td><input type="checkbox" name="id" value="${que.queId}"/></td>
		   		<td>${que_index+1}</td>
	            <td>${(que.queType.typeName)?default("")}</td>
	            <td>${(que.queTitle)?default("")}</td>
	            <td>${(que.queOption)?default("无")}</td>
	            <td>
	            	<span class="details" onclick="seeDetail('${que.queId}',this,400,500,'singDetailAction.action')">查看</span>
	            	<span class="editspan" onclick="seeDetail('${que.queId}',this,400,500,'showUpdateSingAction.action')">修改</span>
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
	</table>
<@common.pageList actionName="showQueList.action"></@common.pageList>
<span class="content_button_a_left" onclick="allSelect()">全选</span>
<span class="content_button_a_left" onclick="invertSelect()">反选</span>
<span class="content_button_a_left" onclick="showAddOneSub(600, 500,'showAddQue.action')">添加试题</span>
<span class="content_button_a_left" onclick="showUpload('showSingleUploadAction.action')">导入试题</span>
<span class="content_button_a_left" onclick="deleteSub('deleteSingAction.action','singleSubAction.action')">删除</span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>