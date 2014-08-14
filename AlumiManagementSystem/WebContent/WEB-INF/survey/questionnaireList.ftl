<div class="controltitle">当前操作：已出问卷列表</div>
	<table class="tablefirst" id="radioSub">
			<col style="width:5%"/>
			<col style="width:5%"/>
			<col style="width:11%"/>
   			<col style="width:30%"/>
    		<col style="width:5%"/>
    		<col style="width:11%"/>
    		<tr>
    		<th></th><th>序号</th><th>问卷标题</th><th>问卷介绍</th><th>出卷人</th><th>基本操作</th>
    		</tr>
			<#if questionnaireList?exists>
		   	<#list questionnaireList as que>
		   	<tr>
		   		<td><input type="checkbox" name="id" value="${que.questionnaireId}"/></td>
		   		<td>${que_index+1}</td>
	            <td>${(que.questionnaireTitle)?default("")}</td>
	            <td>${(que.questionnaireDes)?default("")}</td>
	            <td>${(que.admin.adminNum)?default("")}</td>
	            <td>
	            	<a class="details" href = "questionnaireDetail.action?questionnaireId=${que.questionnaireId}" target = "_blank">视图</a>
	            	<span class="editspan" onclick="seeDetail('${que.questionnaireId}',this,400,500,'showUpdateSingAction.action')">修改</span>
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
	</table>
<span class="content_button_a_left" onclick="allSelect()">全选</span>
<span class="content_button_a_left" onclick="invertSelect()">反选</span>
<span class="content_button_a_left" onclick="showAddOneSub(600, 500,'showAddQue.action')">添加试题</span>
<span class="content_button_a_left" onclick="showUpload('showSingleUploadAction.action')">导入试题</span>
<span class="content_button_a_left" onclick="deleteSub('deleteSingAction.action','singleSubAction.action')">删除</span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>