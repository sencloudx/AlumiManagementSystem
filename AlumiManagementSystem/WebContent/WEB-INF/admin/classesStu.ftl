<div class="controltitle">当前操作：信息管理——>班级列表--->班级学生</div>
	<div id = "div_print">
	<table class="tablefirst" id="radioSub">
			<col style="width:3%"/>
			<col style="width:3%"/>
   			<col style="width:5%"/>
    		<col style="width:5%"/>
    		<col style="width:8%"/>
    		<col style="width:8%"/>
    		<col style="width:10%"/>
    		<col style="width:10%"/>
    		<col style="width:10%"/>
    		<tr>
    		<th></th><th>序号</th><th>学生学号</th><th>学生姓名</th><th>所属专业</th><th>毕业年份</th><th>工作单位</th><th>就业省市</th><th>操作</th>
    		</tr>
			<#if inforList?exists>
		   	<#list inforList as infor>
		   	<tr <#if infor.deleteType == "1">onmouseover="bgColor='#9ad6fb'" onmouseout="bgColor='#ffffff'"<#else>bgColor='#cccccc'</#if>>
		   		<td><input type="checkbox" name="id" value="${infor.stuId}"/></td>
		   		<td>${infor_index+1}</td>
	            <td>${infor.stuNum}</td>
	            <td>${infor.stuName}</td>
	            <td>${infor.major.majorName}</td>
	            <td>${infor.stuEndTime}</td>
	            <td>${infor.stuWorkPlace}</td>
	            <td>${infor.stuWorkAddress}</td>
	            <td>
	            	<span class="editspan" onclick="seeDetail('${infor.stuId}',this,650, 580,'showInforDetailAction.action')">信息详情</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            	<span class="editspan" onclick="seeDetail('${infor.stuId}',this,650, 580,'showInforUpdateAction.action')">修改</span>&nbsp;&nbsp;&nbsp;&nbsp;
	            </td>
		   	</tr>
		   	</#list>
		   	</#if>
</table>
</div>
<span class="content_button_a_left" onclick="allSelect('id')">全选</span>
<span class="content_button_a_left" onclick="invertSelect('id')">反选</span>
<span class="content_button_a_left" onclick="fakeDelete(0, 'fakeDeleteAction.action', 'inforListAction.action', '删除');">回收站</span>
<span class="content_button_a_left" onclick="batchDelete('thoroughDeleteAction.action', 'inforListAction.action');">彻底删除</span>
<span class="content_button_a_left" onclick="showAddBatchSub(0, 'showInforAddAction.action');">添加</span>
<span class="content_button_a_left" onclick="showAddBatchSub(0, 'showSpreadAction.action');">显示分布</span>
<span class="content_button_a_left" onclick="showAddBatchSub(0, 'showBachAddAction.action');"><font color = "red">excel导入</font></span>
<div class="shadeHiddenBlock" id="subDetail" style="dispaly:none;"></div>
